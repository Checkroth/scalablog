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
    justifyContent.center,
    paddingTop := "1.2em"
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

  def navElem = cls(
    textAlign.center,
    margin := "1em 0",
    width := "50%",
    float.left
  )

  def navElemText = cls(
    fontSize := "2.5em"
  )

  def headerText = cls(fontSize := "1.9em")

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
    textAlign.center,
    paddingTop := "0.5em"
  )

  def headerText = cls(fontSize := "1.35em")

  def bodyContent = cls(
    textAlign.left,
    marginLeft := "1em"
  )

  def navElem = cls(
    textAlign.center,
    marginTop := ".25em",
    width := "100%",
    fontWeight := "bold",
    fontSize := "2em"
  )
}

object GeneralStyles extends StyleSheet {
  override def customSheetName = Some("GeneralStyles")

  def header = cls(
    backgroundColor := "#3D2918"
  )

  def headerText = cls(
    fontWeight := "bold"
  )

  def navBar = cls(
    backgroundColor := "#3D2918",
    height := "7em"
  )
}
