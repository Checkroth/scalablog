import $ivy.`com.lihaoyi::scalatags:0.6.0`
import $ivy.`com.atlassian.commonmark:commonmark:0.5.1`
import ammonite.ops._
import $file.StyleComponents, StyleComponents.bootstrapCss
import $file.HomeProcessor, HomeProcessor.ConstructHtml

val postFiles = ls! cwd/'mds/'posts
val unsortedPosts = for(path <- postFiles) yield {
  val Array(prefix, suffix) = path.last.split(" - ")
  (prefix.toInt, suffix, path)
}
def mdNameToHtml(name: String) = {
  name.stripSuffix(".md").replace(" ", "-").toLowerCase + ".html"
}
val sortedPosts = unsortedPosts.sortBy(- _._1)

println("POSTS")
sortedPosts.foreach(println)
def genBlog = {
  for((_, suffix, path) <- sortedPosts) {
    
    parseAndRender(path, 
                    RelPath("blog"),
                    mdNameToHtml(suffix),
                    "..", 
                    Some(suffix.stripSuffix(".md")))
  }
}

def parseAndRender(readPath: Readable,
                    outputPath: RelPath,
                    outputName: String,
                    homePath: String,
                    pageHeader: Option[String]) = {
  import org.commonmark.html.HtmlRenderer
  import org.commonmark.node._
  import org.commonmark.parser.Parser

  val parser = Parser.builder().build()
  val document = parser.parse(read! readPath)
  val renderer = HtmlRenderer.builder.build()
  val output = renderer.render(document)
  import scalatags.Text.all._
  write(
    cwd/outputPath/outputName, ConstructHtml(
        div(
          pageHeader.map(h1(_)).getOrElse(span()),
          raw(output)
        ),
        homePath
    )
  )
}
