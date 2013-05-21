object ForTest {

  def main(args: Array[String]): Unit = {
    
    for{i <- 0 to 4 if i != 2; ch <- "abcd"} println(ch+"   "+i)
      var b = new DDD
  println("JJJJJJJJ"+b(4))
  }

  

}

class DDD{
  def apply(a:Int):Int = {
    a*2
  }
}