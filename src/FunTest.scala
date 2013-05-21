object FunTest {

  def main(args: Array[String]): Unit = {

    println(mainfun(f1(4))(emptyf))
  }

  def mainfun(called: => Boolean)(s: => Unit): Int = {
    var y = called
    s
    45
  }

  def f1(ppp: Int): Boolean = {
    println("function")
    if (0 == ppp) false else true
  }

  def emptyf = {
    println("some code")
  }
  
}