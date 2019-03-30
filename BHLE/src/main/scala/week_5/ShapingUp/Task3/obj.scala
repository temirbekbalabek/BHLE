package week_5.ShapingUp.Task3

import javafx.scene.shape.Circle

sealed trait Shape {

  def sides(): Int

  def perimeter(): Double

  def area(): Double
}
object Draw{
  def apply(shape: Shape): String ={
    shape match {
      case newShape: Circle => s"A circle of radius ${newShape.getRadius()}cm"
      case newShape: Rectangle => s"A rectangle of width ${newShape.getWidth()}cm and height ${newShape.getHeight()}cm"
      case newShape: Square => s"A square of side ${newShape.getSide()}cm"
      case _ => "Could't find this kind of Shape"
    }
  }
}
trait Rectangular extends Shape{}

case class Circle(radius: Double) extends Shape{
  def getRadius(): Double = radius

  override def area(): Double = {
    Math.PI * radius * radius
  }

  override def perimeter(): Double = {
    2 * Math.PI * radius
  }

  override def sides(): Int = {
    0
  }
}
case class Rectangle(a: Int, b: Int) extends Rectangular {
  def getWidth(): Double = a
  def getHeight(): Double = b
  override def area(): Double = {
    a * b
  }

  override def perimeter(): Double = {
    2 * a + 2 * b
  }

  override def sides(): Int = {
    4
  }
}
case class Square (a: Int) extends Rectangular {
  def getSide(): Double = a
  override def area(): Double = {
    a * a
  }

  override def perimeter(): Double = {
    a * 4
  }

  override def sides(): Int = {
    4
  }
}

object obj extends App{
  println(Draw(Circle(10)))
  println(Draw.apply(Rectangle(3, 4)))
  println(Draw.apply(Square(5)))
}
