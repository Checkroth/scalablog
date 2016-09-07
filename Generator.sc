import $file.Blog
import $file.HomeProcessor
import HomeProcessor.ConstructHtml
import Blog.genBlog, Blog.mdNameToHtml, Blog.sortedPosts, Blog.parseAndRender
import $ivy.`com.lihaoyi::scalatags:0.6.0`
import $ivy.`com.atlassian.commonmark:commonmark:0.5.1`
import ammonite.ops._
import scalatags.Text._
import scalatags.Text.all._


def blogContents = div(
  for((_, suffix, _) <- sortedPosts)
    yield h2(a(suffix, href := ("blog/" + mdNameToHtml(suffix))))
)



// write(cwd/'genFiles/"index.html", ConstructHtml(indexContents, "."))
write(cwd/'genFiles/"topBlog.html", ConstructHtml(blogContents, "."))
genBlog
parseAndRender(
	cwd/'mds/"index.md",
	RelPath("main"),
	"index.html",
	"..",
	None
)