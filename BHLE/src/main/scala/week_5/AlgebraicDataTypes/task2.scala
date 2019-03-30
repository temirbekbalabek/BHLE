package week_5.AlgebraicDataTypes

sealed trait Source
case object Tap extends Source
case class BottledWater(size: Int, source: Source, carbonated: Boolean)