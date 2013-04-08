package com.markusjais.scala.collections.examples.vector

object groupByExamples extends App {

  val birds = Vector("Golden Eagle", "Gyrfalcon", "American Robin",
    "Mountain BlueBird", "Mountain Hawk-Eagle")

  // partition strings by first char                    
  val (startsWithM, startsWithoutM) = birds.partition(_.startsWith("M"))
  println(startsWithM)
  println(startsWithoutM)

  // group strings by first char
  val groupedByFirstLetter = birds.groupBy(_.charAt(0))
  println(groupedByFirstLetter)

  // group strings using pattern matching
  val raptors = Vector("Golden Eagle", "Bald Eagle", "Prairie Falcon", "Peregrine Falcon", "Harpy Eagle", "Black Woodpecker")
  val kinds = raptors.groupBy {
    case bird if bird.contains("Eagle") => "eagle"
    case bird if bird.contains("Falcon") => "falcon"
    case _ => "unknown"
  }
  println(kinds)

  // group by string length
  val cats = Vector("Tiger", "Lion", "Puma", "Leopard", "Jaguar", "Cheetah", "Bobcat")
  val groupedByLength = cats.groupBy(_.length)
  println(groupedByLength)

  // group by str length
  val words = Vector("one", "two", "one", "three", "four", "two", "one")
  val counts = words.groupBy(w => w).mapValues(_.size)
  println(counts)

  // find integer which occurs the most in a Vector
  val numbers = Vector(1, 2, 3, 2, 1, 2, 3, 4, 3, 4, 3, 3)
  val mostCommon = numbers.groupBy(x => x).mapValues(_.size).maxBy(_._2)._1
  println(mostCommon)

  // find first unique character in a string
  val str = "eagle"
  val firstUniqueChar = str.find(str.groupBy(x => x)(_).length == 1).getOrElse("None")
  println(firstUniqueChar)

  // could write this in one line as above but using a temporary variable (charMap) is faster
  // because if groupBy is called within find then groupBy is called in each iteration and
  // this is less efficient
  val charMap = str.groupBy(x => x)
  val firstUniqueChar2 = str.find(charMap(_).length == 1).getOrElse("None")
  println(firstUniqueChar2)
  

}





