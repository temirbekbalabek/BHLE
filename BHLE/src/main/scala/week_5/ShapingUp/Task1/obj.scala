package week_5.ShapingUp.Task1

trait Shape {
  def sides(): Int

  def perimeter(): Double

  def area(): Double
}
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
class Rectangle(a: Int, b: Int) extends Shape{

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
class Square (_a: Int) extends Shape{
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
