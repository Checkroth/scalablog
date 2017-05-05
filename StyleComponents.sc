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

val mainColor = "#3D2918"

object LargeStyles extends StyleSheet {
  override def customSheetName = Some("LargeStyles")

  def headerLarge = cls(
    styles.width := "100%",
    justifyContent.center,
    paddingTop := "0.1em",
    paddingBottom := "0.1em"
  )
  def headerSmall = cls(display := "none")

  def headerContent = cls(
    textAlign.center
  )

  def bodyContent = cls(
    textAlign.left,
    margin := "2em auto 0",
    width := "85%",
    fontSize := "1.2em"
  )

  def navElem = cls(
    width := "50%",
    float.left
  )

  def navElemLeft = cls(
    textAlign := "right",
    paddingRight := "10em"
  )

  def navElemRight = cls(
    textAlign := "left",
    paddingLeft := "10em"
  )

  def navBar = cls(height := "5em")

  def navElemText = cls(
    fontSize := "2.5em"
  )

  def headerText = cls(fontSize := "1.4em")

  def blogList = cls(
    fontSize := "1.4em",
    borderLeft := s"0.4em solid $mainColor",
    paddingLeft := "0.6em",
    marginBottom := "0.3em" 
    )

  def indexStyle = cls(padding := "0 20%")

  def blogListContainer = cls(padding := "0 26%")

}

object SmallStyles extends StyleSheet {
  override def customSheetName = Some("SmallStyles")

  def headerSmall = cls(
    styles.width := "100%",
    justifyContent.center,
    fontWeight := "bold",
    paddingBottom := "0.1em"
  )
  def headerLarge = cls(display := "none")

  def headerContent = cls(
    textAlign.center,
    paddingTop := "0.5em"
  )

  def headerText = cls(fontSize := "1.35em")

  def bodyContent = cls(
    textAlign.left,
    margin := "1em",
    fontSize := "1.3em"
  )

  def navElem = cls(
    textAlign.center,
    marginTop := ".25em",
    width := "100%",
    fontWeight := "bold",
    fontSize := "2em"
  )

  def blogList = cls(fontSize := "1.6em")

  def navBar = cls(height := "5em")
}

object GeneralStyles extends StyleSheet {
  override def customSheetName = Some("GeneralStyles")

  def header = cls(
    backgroundColor := mainColor
  )

  def headerText = cls(
    fontWeight := "bold"
  )

  def navBar = cls(backgroundColor := "#3D2918")
}
