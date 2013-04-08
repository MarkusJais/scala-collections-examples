package com.markusjais.scala.collections.examples.vector

object collectExamples extends App {

  // find first unique character in a string using collectFirst
  val str = "eagle"
  val charMap = str.groupBy(x => x)
  val firstUniqueChar = str.collectFirst { case i if (charMap(i).length == 1) => i }.getOrElse("None")
  println(firstUniqueChar)

}