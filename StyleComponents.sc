import $ivy.`com.lihaoyi::scalatags:0.6.0`

import scalatags.stylesheet._
import scalatags.Text.all.{width, height, _}
import scalatags.Text._

val bootstrapCss = {
  link(
    rel := "stylesheet",
    href := "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
  )
}

object LargeStyles extends StyleSheet {
  override def customSheetName = Some("LargeStyles")

  def header = cls(
    styles.width := "100%",
    justifyContent.center
  )

  def headerContent = cls(
    textAlign.center
  )

  def bodyContent = cls(
    textAlign.left
  )

}

object SmallStyles extends StyleSheet {
  override def customSheetName = Some("SmallStyles")

  def header = cls(
    styles.width := "100%",
    justifyContent.center
  )

  def headerContent = cls(
    textAlign.center
  )

  def bodyContent = cls(
    textAlign.left
  )
}

object GeneralStyles extends StyleSheet {
  override def customSheetName = Some("GeneralStyles")

  def header = cls(
    backgroundColor := "#3D2918"
  )
}
