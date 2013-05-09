import scala.io.Source


//one word starting with capital letter


val ProgLangRE1 = """\b([A-Z]+)\b""".r

//UsingRE(lang,_,_)
val ProgLangRE2 = """\b(([A-Z]{2,})|(C\+\+))\b?""".r

//UsingRE(lang,_,_,_,_)
val  ProgLangRE3 = """\b((([4CRJSVPIHD][3910A-Z\*]{2,7})\b|(V?C\+\+))\b?(2|II|\+\+|/1|/390|da)?)\b?""".r


//UsingRE(lang,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_)
val ProgLangRE4 = """\b((?!PLAIN|IBM|SMP|CPC|COM|VAX|SYS(TEMS)?|PROJECT|SUN|DOC|CORBA|CNE|JOB|SALARY|RELOCATE|SCIENCE|CLUSTER|HAVE|DBA|PDT|HOUSTON|SKILLS|DESIGN|CDC|VLIW|SCSI|SQA|HIGH|STATE|VSDM|DVD|SONET|SEARCH|PERM|CASE|DPMS|PARANET|CALL|PHONE|RDBMS|RAY|VESA|VGA|VMS|[PC]ST|POSTED|DATE|ITS|DCI|CONTACT|ISP|DOS|DEC|CNA|DICE|SIX|PAID|PEOPLE|DOES|START|[SI]PX|DPPROS|DECNET|DEMAND|INI|SNMP|SDK|DLL|[IR]CO|SAS|CPU|VISIT|SITE)(([CJSVPIHD][3910A-Z\*]{2,6})\b|(V?C\+\+)|(Visual\s)|(Java)|(Cobol)|(Smalltalk)|(S/390 assembler)|([Aa]ssem[a-z]{3,4})|(Focus)|(4GL)|(Access)|(Power[Bb]uilder)|(N(atural|ATURAL) 2)|(Optima\s\+\+)|(PL/1))\b?(\+?\+|da|C\+\+|Basic)?)\b?""".r


val ProgLangRE5 = """\b(4GL|Access|Ada|Adabas Natural|Assembler|[Aa]ssembly|C\+\+|CICS|COBOL|Cobol|DCL|Distributed  Object  C++|Focus|HTML|IMS|Java|JCL|MF COBOL|MVS JCL|Natural 2|NATURAL 2|Optima ++|PL/1|Power[Bb]uilder|PRO\*Ada|PRO\*C|S/390 assembler|Smalltalk|SQL|VC++|Visual Basic|Visual C++)\b?""".r

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
		//println(document.slice(index,index + length))
		prevIndex = index

}

}

