package tests

object Sorting {

  def main(args: Array[String]): Unit = {
    var mas: Array[Int] = Array(9,4,8,62,17)
    mas.foreach(println)
    println
    sort(mas)
    mas.foreach(println)

    println
    var mas2: Array[Int] = Array(36, 12, -9, 487)
    mas2.foreach(println)
    println
    val mas3 = sort2(mas2)
    mas3.foreach(println)
    var i:Int = 0

    While(i< 8)(()=>{i += 1; println(i)})
  }
  def sort(xs: Array[Int]) {
    def swap(i: Int, j: Int) {
      val t = xs(i);
      xs(i) = xs(j);
      xs(j) = t
    }
    def sort1(l: Int, r: Int) {
      val pivot = xs((l + r) / 2)
      println(pivot)
      var i = l;
      var j = r
      while (i <= j) {
        while (xs(i) < pivot) i += 1
        while (xs(j) > pivot) j -= 1
        println(i+"   "+j)
        if (i <= j) {
          swap(i, j)
          i += 1
          j -= 1
        }
      }
      if (l < j) sort1(l, j)
      if (j < r) sort1(i, r)
    }
    sort1(0, xs.length - 1)
  }

  def sort2(xs: Array[Int]): Array[Int] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)
      Array.concat(
        sort2(xs filter (pivot >)),
        xs filter (pivot ==),
        sort2(xs filter (pivot <)))
    }
  }
  def While(p: => Boolean)(s: => Unit) {
  if (p) {
    s; While(p)(s)
  }
}
}