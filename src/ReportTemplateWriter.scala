
import java.io._
import org.apache.poi.ss.util._
import org.apache.poi.xssf.usermodel._

object ReportTemplateWriter {
  def main(args: Array[String]): Unit = {
    // ������ ��� ���������� ������
    val months = Array("������� 2012", "������ 2012", "������� 2012",
      "������ 2013", "������� 2013", "���� 2013")
    val data = Map(
      (1, "RU-CENTER") -> Array(83318, 80521, 83048, 73638, 82014, 93982),
      (2, "REGRU") -> Array(35621, 37013, 36515, 41595, 45042, 49101),
      (3, "R01") -> Array(44155, 44356, 43199, 39629, 42754, 48528),
      (4, "REGTIME") -> Array(19999, 18587, 18630, 18627, 19886, 20496))

    // ��������� ������ ������
    //  val wb = new XSSFWorkbook(
    //      getClass.getResourceAsStream("/template.xlsx")
    //    )

    val is = new FileInputStream("template.xlsx");
    val wb = new XSSFWorkbook(is);
    is.close();

    val sheet = wb.getSheetAt(0)

    // ��������� ����� �������
    val headerRow = sheet.getRow(0)
    for (idx <- 1 to months.size) {
      headerRow.getCell(idx).setCellValue(months(idx - 1))
    }

    // ��������� ���� �������
    for (key @ (rowNumber, rowName) <- data.keys) {
      val row = sheet.getRow(rowNumber)
      row.getCell(0).setCellValue(rowName)
      for (idx <- 1 to data(key).size) {
        row.getCell(idx).setCellValue(data(key)(idx - 1))
      }
    }

    // ����� ����� ��������� ������, ����� �� �� �������������
    val footerRow = sheet.getRow(data.size + 1)
    for (idx <- 1 to months.size) {
      val cell = footerRow.getCell(idx)
      val range = new CellRangeAddress(1, data.size, idx, idx)
      cell.setCellFormula("SUM("+range.formatAsString()+")")
    }

    // ��������� �����
    val resultFile = new FileOutputStream("report.xlsx")
    wb.write(resultFile)
    resultFile.close
  }
}