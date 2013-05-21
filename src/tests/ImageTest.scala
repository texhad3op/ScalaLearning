package tests

import java.awt.Graphics2D
import java.awt.image.BufferedImage
import java.io.File

import javax.imageio.ImageIO

object ImageTest {
  val width = 640
  def main(args: Array[String]): Unit = {

    resizeImageAndWrite("c:\\22\\ogo.jpg", "c:\\22\\ogo2.jpg")

  }

  def resizeImageAndWrite(in: String, out: String) {
    val originalImage: BufferedImage = ImageIO.read(new File(in))
    println(originalImage.getWidth() + "     " + originalImage.getHeight())
    val scaleY = originalImage.getHeight().toFloat / originalImage.getWidth().toFloat
    println(scaleY)
    val resizeImagePng: BufferedImage = resizeImage(originalImage, width, (width * scaleY).toInt)
    ImageIO.write(resizeImagePng, "JPG", new File(out))
  }

  def resizeImage(originalImage: BufferedImage, width: Int, height: Int): BufferedImage = {
    val resizedImage: BufferedImage = new BufferedImage(width, height,
      BufferedImage.TYPE_INT_RGB)
    val g: Graphics2D = resizedImage.createGraphics()
    g.drawImage(originalImage, 0, 0, width, height, null)
    g.dispose()

    resizedImage
  }
}
