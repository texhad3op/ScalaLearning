package swingtest

import scala.swing.Dimension
import scala.swing.GridBagPanel
import scala.swing.Label
import scala.swing.MainFrame
import scala.swing.SimpleGUIApplication
import scala.swing.Swing
import scala.swing.Button
import scala.swing.event.ButtonClicked
import scala.swing.Frame
import scala.swing.TextArea
object hello extends SimpleGUIApplication {

  val close_button = new Button {
    text = "Close Window"
    font = new java.awt.Font("Verdana",
      java.awt.Font.PLAIN, 14)
  }
  val help_button = new Button {
    text = "nnn"
    font = new java.awt.Font("Verdana",
      java.awt.Font.PLAIN, 14)
  }

  def top = new MainFrame {
    title = "Greetings"
    preferredSize = new Dimension(400, 300)
    val label = new Label {
      text = "Hello World!"
      font = new java.awt.Font("Verdana",
        java.awt.Font.BOLD, 22)
    }
    contents = new GridBagPanel {
      var c = new Constraints
      c.gridwidth = java.awt.GridBagConstraints.REMAINDER
      add(label, c)
      background = java.awt.Color.yellow
      border = Swing.EmptyBorder(15, 15, 15, 15)
      c.gridwidth = java.awt.GridBagConstraints.RELATIVE

      c.gridwidth = java.awt.GridBagConstraints.REMAINDER
      add(Swing.VStrut(20), c)
      add(close_button, c)
      add(help_button, c)

      listenTo(help_button)
      listenTo(close_button)
      reactions += {

        case ButtonClicked(b) => if (b.equals(help_button)) println("help_button")
        else if (b.equals(close_button)) println("close_button")

      }

      //      reactions += {
      //        case ButtonClicked(b1) => new Frame {
      //          title = "Help Window"
      //          visible = true
      //          val close_button2 = new Button { text = "Close" }
      //          val help_text = new TextArea {
      //            editable = false
      //            text = "Click the «Κλείσιμο» button to . . ."
      //          }
      //          contents = new GridBagPanel {
      //
      //          }
      //          listenTo(close_button2)
      ////          reactions += {
      ////            case ButtonClicked(b3) => dispose()
      ////          }
      //        }
      //      }

      //      reactions += {
      //        case ButtonClicked(b2) => exit(0)
      //      }
    }
  }
}