package tests
import scala.xml.XML

object MapTest {

  def main(args: Array[String]): Unit = {
    var p = Map(1 -> "David", 9 -> "Elwood")
    println(p)

    p += 8 -> "Jura"
    println(p)

    println(p.getOrElse(5, "hhh"))

    var l = 1 to 5 flatMap (p.get)
    println(l)
    println(p.reduceLeft((a, b) => if (a._2.length() < b._2.length()) a else b))

    var p5 = Map("name" -> "David", "age" -> "42")

    var oo =
      for {
        name <- p5.get("name")
        ageStr <- p5.get("age")
        if(name.equals("David5"))
      } yield (name, ageStr)

    println(oo)
    
    
    val xml = XML.loadFile("c:\\audio\\1.xml")
    var bb  = (xml \\ "root" \ "sub1").map(_ \ "@par1")

    bb.map(v => println(v))

  }

}