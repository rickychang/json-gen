package me.rickychang

import net.liftweb.json.JsonAST._
import net.liftweb.json.Printer._

object Tester extends App {
  
  val jsonGenerator = JsonGen.genJObject
  
  for (i <- 1 to 50) {
    try {
      println(jsonGenerator.sample.map(v => pretty(render(v))).getOrElse(""))
    }
    catch {
      case e: Exception => e.printStackTrace()
    }
  }

}