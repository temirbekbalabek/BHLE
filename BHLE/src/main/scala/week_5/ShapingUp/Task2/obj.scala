package week_5.ShapingUp.Task2


trait Shape {
  def sides(): Int

  def perimeter(): Double

  def area(): Double
}
trait Rectangular extends Shape{}
class Circle(_radius: Double) extends Shape{
  var radius = _radius
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
class Rectangle(_a: Int, _b: Int) extends Rectangular {
  var a = _a;
  var b = _b;

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
class Square (_a: Int) extends Rectangular {
  var a = _a

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

object obj {

}
