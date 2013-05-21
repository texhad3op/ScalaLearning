package tests
import scala.Array.canBuildFrom

object Test1 {

  def main(args: Array[String]): Unit = {
    //    println("jkjkjk")
    //
    //    val args2: Array[String] = Array("hjklh", "ooo")
    //
    //    val res: Array[String] = for (a <- args2) yield a.toUpperCase
    //    println("Arguments: " + res.toString)
    //    res.foreach(println)
    //    println
    //    
    //    val m:Map[Int, String] = Map[Int, String](1 -> "aaa", 2 -> "jkjk")
    //    println(m.getOrElse(5,"kkkk"))
    //
    //    println(1 to 5 flatMap(m.get))

//    val ints: Array[Int] = Array(2, 9, 6, 3)
//
//    val ints2 = ints.foldLeft(100)((a, b) => a + b)
//    ints.foreach(println)
//    println(ints2)

    val d = List("A", "Cat").map(s => s.toUpperCase)
    d.foreach(println)
    
    val s1:String = "hh"
      
     val s2:String = "hh"    
       println(s1.equals(s2))

  }

}