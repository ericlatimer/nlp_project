import scala.io.Source
import scala.util.matching.Regex

val PersonalNameRE = """\b([A-Z][a-zA-Z]+[\\b\s$]([A-Z][a-zA-Z]+)?\b?)""".r
val PersonalNameRE2 = """\b([A-Z][a-zA-Z]+[\\b\s$]([A-Z][a-zA-Z]+))""".r
val PersonalNameRE3 = """\b([A-Z][a-z]+[\\b\s$][A-Z][a-z]+)""".r

val PersonalNameRE4 = """\b((?!Meeting\b|Mtg\b|Mtgs\b|Mime\b|Group\b)[A-Z][a-z]+[\\b\s$](?!Meeting\b|Mtg\b|Mtgs\b|Mime\b|Group\b)[A-Z][a-z]+)""".r


val UsingRE = PersonalNameRE4

val dirName = args(0)

val fileList = new java.io.File(dirName).listFiles //.filter(_.getName.endsWith(".txt"))


for ( file <- fileList) yield {

val document = scala.io.Source.fromFile(file).getLines.toList.mkString(" ")

val first_last = {for {UsingRE(first) <- UsingRE findAllIn document} yield (first) }.toList

var prevIndex = -1
for (fl <- first_last) yield {
		val index = document.indexOfSlice(fl,prevIndex+1)
		val length=  fl.length
		println(file.getName +  " " + index + " " + length  )
		)
		prevIndex = index
}

}


                                 










