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

  def headerLarge = cls(
    styles.width := "100%",
    justifyContent.center
  )
  def headerSmall = cls(display := "none")

  def headerContent = cls(
    textAlign.center
  )

  def bodyContent = cls(
    textAlign.left,
    margin := "2em auto 0",
    width := "50%"
  )

}

object SmallStyles extends StyleSheet {
  override def customSheetName = Some("SmallStyles")

  def headerSmall = cls(
    styles.width := "100%",
    justifyContent.center,
    fontWeight := "bold"
  )
  def headerLarge = cls(display := "none")

  def headerContent = cls(
    textAlign.center
  )

  def bodyContent = cls(
    textAlign.left,
    marginLeft := "1em"
  )
}

object GeneralStyles extends StyleSheet {
  override def customSheetName = Some("GeneralStyles")

  def header = cls(
    backgroundColor := "#3D2918"
  )

  def headerText = cls(
    fontWeight := "bold",
    fontSize := "1.9em"
  )
}
