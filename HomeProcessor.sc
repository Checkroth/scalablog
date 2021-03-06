import $ivy.`com.lihaoyi::scalatags:0.6.0`
import $ivy.`com.atlassian.commonmark:commonmark:0.5.1`
import ammonite.ops._
import $file.StyleComponents, StyleComponents._
import scalatags.Text._
import scalatags.Text.all.{width, height, _}

def ConstructHtml(content: Frag, homeDir: String) = {
  val pageTitle = "Charles Henry Heckroth"
  // val sheets = Seq(StyleComponents.bootstrapCss)

  val headerLinks = Seq(
    div("Resume") -> "http://resumelink.com",
    div("Slides") -> "http://slideslink.com",
    div("Contact") -> "http://contactlink.com"
  )

  html(
    meta(charset := "utf-8"),
		meta(raw(""" <meta name="viewport" content="width=device-width, initial-scale=1">  """.stripMargin)),
    head(
      tags2.title(pageTitle),
      tags2.style(s"@media (min-width: 60em) {${LargeStyles.styleSheetText}}"),
      tags2.style(s"@media (max-width: 60em) {${SmallStyles.styleSheetText}}"),
      tags2.style(GeneralStyles.styleSheetText),
      bootstrapCss,
      googleAnalytics
    ),
    body(
      div(
        GeneralStyles.header,
        div(
          LargeStyles.headerLarge,
          SmallStyles.headerLarge,
          LargeStyles.headerContent,
          h1(
            span(
              GeneralStyles.headerText,
              LargeStyles.headerText,
              color := "white",
              "Charles Henry Heckroth"
            )
          )
        ),
        div(
          SmallStyles.headerSmall,
          LargeStyles.headerSmall,
          SmallStyles.headerContent,
          h1(
            a(
              GeneralStyles.headerText,
              SmallStyles.headerText,
              color := "white",
              "@checkroth",
              href := s"$homeDir/index.html"
            )
          )
        )
        ,
        div(
          GeneralStyles.navBar,
          LargeStyles.navBar,
          SmallStyles.navBar,
          div(
            LargeStyles.navElem,
            SmallStyles.navElem,
            SmallStyles.headerLarge,
            LargeStyles.navElemLeft,
            a(
              LargeStyles.navElemText,
              color := "white",
              "Home",
              href := s"$homeDir/index.html"
            )
          ),
          div(
            LargeStyles.navElem,
            SmallStyles.navElem,
            LargeStyles.navElemRight,
            a(
              LargeStyles.navElemText,
              color := "white",
              "Blog",
              href := s"$homeDir/topBlog.html"
            )
          )
        )
      ),
      div(
        LargeStyles.bodyContent,
        SmallStyles.bodyContent,
        content
      )
    )
  ).render
}
def googleAnalytics: Frag = script(raw(
  """
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-84071551-1', 'auto');
  ga('send', 'pageview');
  """.stripMargin))
