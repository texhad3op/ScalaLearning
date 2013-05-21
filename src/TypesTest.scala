

object TypesTest {
  type ChangeHandler = { def changed(c: Long): Unit }

  def main(args: Array[String]): Unit = {
    // aa(142l)

    var l1 = List(2)
    l1 = 7 :: l1
    println(l1)
    l1 ::= 9
    println(l1)
    l1 -= 2
    println(l1)
    val hh: List[Int] = Nil

    println(List(1, 2, 3).map { _ + 1 })
    println(
      f3(1) {
        b => if (0 == b) false else true
      })

  }

  def f1(a: Int): Boolean = {
    if (a > 0) true else false
  }

  def f3(a: Int)(b: Int => Boolean): Boolean = {
    if (1 == a) true else b(a)
  }

    def f4(a: Int)(b: Int => Boolean): Boolean = {
    if (1 == a) true else b(a)
  }
  
  def aa[T <: Long](in: T) {
    println(in)
  }

}

case class ChangeEvent[OnType](on: OnType)
