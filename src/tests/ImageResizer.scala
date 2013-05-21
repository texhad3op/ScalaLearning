package tests

import java.awt.Graphics2D
import java.awt.image.BufferedImage
import java.io.File
import java.io.IOException

import javax.imageio.ImageIO

object ImageResizer {
  val width = 200
  def main(args: Array[String]): Unit = {
    val file: File = new File("C:/mikrometras")
    println(file.getName);
    processDirectory(1, file.listFiles);
    println("Converting finished.")
  }

  def processDirectory(level: Int, fileList: Array[File]): Unit = {
    val level2 = level + 1;
    fileList.foreach { file =>
      if (file.isDirectory) {
        processDirectory(level, file.listFiles);
      } else if (file.isFile) {
        val in: String = file.getPath
        val index: Int = in.lastIndexOf(".")
        val out = in.substring(0, index) + "resized" + in.substring(index, in.length())
        val fileType = in.substring(index + 1, in.length())
        println(in)
        println(out)
        try {
          resizeImageAndWrite(in, out, fileType)
        } catch {
          case e: Exception => ;
        }
      }
    }
  }

  def resizeImageAndWrite(in: String, out: String, fileType: String) {
    val originalImage: BufferedImage = ImageIO.read(new File(in))
    if (width < originalImage.getWidth()) {
      val scaleY = originalImage.getHeight().toFloat / originalImage.getWidth().toFloat
      val resizeImagePng: BufferedImage = resizeImage(originalImage, width, (width * scaleY).toInt)
      ImageIO.write(resizeImagePng, fileType, new File(out))
    }
  }

  private def resizeImage(originalImage: BufferedImage, width: Int, height: Int): BufferedImage = {
    val resizedImage: BufferedImage = new BufferedImage(width, height,
      BufferedImage.TYPE_INT_RGB)
    val g: Graphics2D = resizedImage.createGraphics()
    g.drawImage(originalImage, 0, 0, width, height, null)
    g.dispose()
    resizedImage
  }
}