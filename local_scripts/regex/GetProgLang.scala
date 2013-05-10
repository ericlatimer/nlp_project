import scala.io.Source

val ProgLangRE1 = """\b([A-Z]+)\b""".r

//UsingRE(lang,_,_)
val ProgLangRE2 = """\b(([A-Z]{2,})|(C\+\+))\b?""".r

//UsingRE(lang,_,_,_,_)
val  ProgLangRE3 = """\b((([4CRJSVPIHD][3910A-Z\*]{2,7})\b|(V?C\+\+))\b?(2|II|\+\+|/1|/390|da)?)\b?""".r

val ProgLangRE4 = """\b(4GL|Access|Ada|Adabas Natural|Assembler|[Aa]ssembly|C\+\+|CICS|COBOL|Cobol|DCL|Distributed  Object  C++|Focus|HTML|IMS|Java|JCL|MF COBOL|MVS JCL|Natural 2|NATURAL 2|Optima ++|PL/1|Power[Bb]uilder|PRO\*Ada|PRO\*C|S/390 assembler|Smalltalk|SQL|VC++|Visual Basic|Visual C++)\b?""".r

val UsingRE = ProgLangRE4
val dirName = args(0)

val fileList = new java.io.File(dirName).listFiles 


for ( file <- fileList) yield {

val document = scala.io.Source.fromFile(file).getLines.toList.mkString(" ")

val langs = {for {UsingRE(lang)<- UsingRE findAllIn document} yield (lang) }.toList

var prevIndex = -1
var inc = 1
var index = 0
for (lang <- langs) yield {
		
		val length=  lang.length
				
		index = document.indexOfSlice(lang,prevIndex+1).toInt
		
		println(file.getName +  " " + index + " " + length  )
		prevIndex = index

}

}

