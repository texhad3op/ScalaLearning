object OForGit {

  case class Person(var name: String, var surname: String)
  case class Point(x: Int, y: Int)
  def main(args: Array[String]): Unit = {
    fun1("aaa")
  }

  def fun1(a: String) {
    println("string in base")
    val p1 = Person("Maksimka", "Gichan")
    println(p1)
    circle(5, 5, 7)
  }

  def circle(x: Int, y: Int, r: Int) {
    println("Draw circle with center in " + x + "," + y + ", with radius " + r)
  }
}