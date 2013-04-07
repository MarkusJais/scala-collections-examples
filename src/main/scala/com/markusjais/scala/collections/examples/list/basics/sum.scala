package com.markusjais.scala.collections.examples.list.basics

import scala.annotation.tailrec

/**
 * A simple example with various ways to sum the Long values in a Seq
 */
object sum extends App {

  def recursiveSum(seq: Seq[Long]): Long = {
    seq match {
      case Nil => 0
      case head :: tail => head + recursiveSum(tail)
    }
  }

  def tailrecSum(seq: Seq[Long]): Long = {
    @tailrec
    def sum(seq: Seq[Long], tmpResult: Long): Long = {
      seq match {
        case Nil => tmpResult
        case head :: tail => sum(tail, head + tmpResult)
      }
    }
    sum(seq, 0)
  }

  val numbers = (1l to 100l).toList

  val sum1 = recursiveSum(numbers)
  
  val sum2 = tailrecSum(numbers)

  val sum3 = numbers.reduceLeft((x, y) => x + y)

  val sum4 = numbers.reduceLeft(_ + _)

  val sum5 = numbers.sum

  val sumEvenSquared = numbers.filter(_ % 2 == 0).map(_ * 2).reduceLeft(_ + _)

  println(sum1, sum2, sum3, sum4, sum5, sumEvenSquared)

}