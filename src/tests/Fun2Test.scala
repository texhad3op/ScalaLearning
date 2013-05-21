package tests

object Fun2Test {

  def main(args: Array[String]): Unit = {

    val uu:Unit = using("45") {
      passed =>
        {
          val tt = passed.toInt
          println("--"+tt)
        }
    }

  }

  def using[A, B](param: A)(f: A => B):Unit = {
    f(param)
    println("kkk")
  }

}