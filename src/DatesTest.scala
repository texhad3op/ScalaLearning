import java.sql.Date
object DatesTest {

  var dates2: List[Template] = Nil
  def main(args: Array[String]): Unit = {

    val now: Date = getDate(2012, 9, 25)

    val dates: List[Template] = List(new Template(getDate(2012, 4, 12), getDate(2012, 4, 20)),
      new Template(getDate(2012, 5, 6), getDate(2012, 5, 20)),
      new Template(getDate(2012, 4, 20), getDate(2012, 5, 6)),
      new Template(getDate(2012, 5, 20), null))

    dates2 = dates.sort((a, b) => a.start.before(b.start))
    println(dates2)
    println(getCurrent(now))
  }

  def getCurrent(now: Date): Template = {
    try {
      dates2.filter(a => now.after(a.start) && (if (null != a.end) now.before(a.end) else true))(0)
    } catch {
      case ex: IndexOutOfBoundsException =>
        null
    }
  }

  def getDate(year: Int, month: Int, date: Int): Date = {
    val d1: Date = new Date(System.currentTimeMillis)
    d1.setYear(year - 1900)
    d1.setMonth(month - 1)
    d1.setDate(date)
    d1
  }

}
// this in master
class Template(val start: Date, val end: Date) {
  override def toString = "OBJ{{" + (if (null == start) "" else start.toString) + "==" + (if (null == end) "" else end.toString) + "}}";
}