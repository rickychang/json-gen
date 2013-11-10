package me.rickychang

import net.liftweb.json._
import org.scalacheck._
import Gen._
import Arbitrary.arbitrary

object JsonGen {
  
  val genJNothing = value(JNothing)
  
  val genJNull = value(JNull)
  
  val genJBool = for {
    b <- arbitrary[Boolean]
  } yield JBool(b)
 
  val genJDouble = for {
    d <- arbitrary[Double]
  } yield JDouble(d)
  
  val genJInt = for {
    i <- arbitrary[Int]
  } yield JInt(i)

  val genJString = for {
    s <- frequency((1, arbitrary[String]), (5, alphaStr))
  } yield JString(s)
  
  val genJArray = for {
    len <- choose(1, 10)
    elems <- Gen.listOfN[JValue](len, genJValue)
  } yield JArray(elems)

  
  val genJField = for {
    s <- frequency((1, arbitrary[String]), (10, identifier))
    v <- genJValue
  } yield JField(s, v)
  
  val genJObject = for {
    len <- frequency(
      (5, choose(1, 20)),
      (2, choose(21, 50)),
      (1, choose(51, 200)))
    elems <- Gen.listOfN[JField](len, genJField)
  } yield JObject(elems)

  def genJValue: Gen[JValue] = lzy(frequency(
    (1, genJNothing),
    (1, genJNull),
    (100, genJDouble),
    (50, genJString),
    (100, genJInt),
    (10, genJArray),
    (5, genJObject)))
      

}