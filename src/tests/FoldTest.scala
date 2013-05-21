package tests

object FoldTest {

  def main(args: Array[String]): Unit = {

    val ids = Array(121, 56, 98, 765, 54)

    val el: scala.xml.Elem =
      <stuff>
        { ids.map(i => <v id={ i.toString }>{ i }</v>) }
      </stuff>
    println(el)
    println(answer(ff(8)))
  }

  def ff(a: Int): String = {
    a.toString
  }
  def answer(f: => String):String = {
    "ret:"+f
  }
}
