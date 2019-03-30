package lab4

object Options extends App{
    def calculator(operand1: String, operator: String, operand2: String):Unit = {

      def sum(opt1: Option[Int], opt2: Option[Int]): Option[Double] =  {
        for {
          value1 <- opt1
          value2 <- opt2
        } yield value1 + value2
      }
      def subtract(opt1: Option[Int], opt2: Option[Int]): Option[Double] =  {
        for {
          value1 <- opt1
          value2 <- opt2
        } yield value1 - value2
      }
      def divide(opt1: Option[Int], opt2: Option[Int]): Option[Double] =  {
//        opt2 match {
//          case Some(0) => None
//        }

        for {
          value1 <- opt1
          value2 <- opt2 if value2 != 0
        } yield value1 / value2
      }

      def multiply(opt1: Option[Int], opt2: Option[Int]): Option[Double] =  {
        for {
          value1 <- opt1
          value2 <- opt2
        } yield value1 * value2
      }

      val a1: Option[Int] = if(operand1 matches "\\d+") Some(operand1.toInt) else None
      val a2: Option[Int] = if(operand2 matches "\\d+") Some(operand2.toInt) else None


      val res = operator match {
        case "+" => sum(a1, a2)
        case "-" => subtract(a1, a2)
        case "*" => multiply(a1, a2)
        case "/" => divide(a1, a2)
        case _ =>
      }

      println(res)
    }



    calculator("2", "/", "0")
}