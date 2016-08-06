import ammonite.ops._

val postFiles = ls! cwd/'posts
val unsortedPosts = for(path <- postFiles) yield {
  val Array(prefix, suffix) = path.last.split(" - ")
  (prefix.toInt, suffix, path)
}

val sortedPosts = unsortedPosts.sortBy(_._1)

println("POSTS")
sortedPosts.foreach(println)
