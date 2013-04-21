package com.markusjais.scala.collections.examples.parallel

/**
 * simple example to show how to use a parallel map operation
 */
object parallelMultiplication extends App {
  
  val numbers = (1 to 1000).toVector
  
  // par creates a ParVector[Int]
  val doubled = numbers.par.map(_ * 2)
  
}