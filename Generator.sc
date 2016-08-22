import $file.Blog
import $file.HomeProcessor
import HomeProcessor.ConstructHtml
import Blog.genBlog, Blog.mdNameToHtml, Blog.sortedPosts
import $ivy.`com.lihaoyi::scalatags:0.6.0`
import $ivy.`com.atlassian.commonmark:commonmark:0.5.1`
import ammonite.ops._
import scalatags.Text._
import scalatags.Text.all._


def contents = div(
  for((_, suffix, _) <- sortedPosts)
    yield h2(a(suffix, href := ("blog/" + mdNameToHtml(suffix))))
)

write(cwd/'genFiles/"index.html", ConstructHtml(contents, "."))
genBlog
