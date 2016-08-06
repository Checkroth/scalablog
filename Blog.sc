import $ivy.`com.lihaoyi::scalatags:0.6.0`
import $ivy.`com.atlassian.commonmark:commonmark:0.5.1`
import ammonite.ops._

val postFiles = ls! cwd/'posts
val unsortedPosts = for(path <- postFiles) yield {
  val Array(prefix, suffix) = path.last.split(" - ")
  (prefix.toInt, suffix, path)
}

val sortedPosts = unsortedPosts.sortBy(_._1)

println("POSTS")
sortedPosts.foreach(println)
for((_, suffix, path) <- sortedPosts) {
  import org.commonmark.html.HtmlRenderer
  import org.commonmark.node._
  import org.commonmark.parser.Parser

  val parser = Parser.builder().build()
  val document = parser.parse(read! path)
  val renderer = HtmlRenderer.builder().build()
  val output = renderer.render(document)
  write(
    cwd/'blog/(suffix.stripSuffix(".md").replace(" ", "-").toLowerCase + ".html"),
  output
  )
}
val HTML = {
  import scalatags.Text.all._

  html(
    head(),
    body(
      h1("Charlie's Blog"),
      for((_, suffix, _) <- sortedPosts)
      yield h2(suffix)
   ) 
  ).render
}

write(cwd/"index.html", HTML)
