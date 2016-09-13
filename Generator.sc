import $file.Blog
import $file.HomeProcessor
import $file.StyleComponents
import HomeProcessor.ConstructHtml
import Blog.genBlog, Blog.mdNameToHtml, Blog.sortedPosts, Blog.parseAndRender
import $ivy.`com.lihaoyi::scalatags:0.6.0`
import $ivy.`com.atlassian.commonmark:commonmark:0.5.1`
import ammonite.ops._
import scalatags.Text._
import scalatags.Text.all._
import StyleComponents.LargeStyles, StyleComponents.SmallStyles


def blogContents = div(
	h1("Blog Posts"),
  	for((_, suffix, _) <- sortedPosts)
	yield div(
    	LargeStyles.blogList,
    	SmallStyles.blogList,
    	a(
    		suffix.stripSuffix(".md"), 
    		href := ("blog/" + mdNameToHtml(suffix))
    		)
    	)
)

write(cwd/"topBlog.html", ConstructHtml(blogContents, "."))
genBlog
parseAndRender(
	cwd/'mds/"index.md",
	RelPath("."),
	"index.html",
	".",
	None
)