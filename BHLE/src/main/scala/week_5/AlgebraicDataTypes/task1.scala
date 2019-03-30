package week_5.AlgebraicDataTypes

sealed trait Calculator
case class Success(a: Int) extends Calculator
case class Fail(a: String) extends Calculator
