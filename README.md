NLP Project README
===========

MinorThird is the main program we use for the CRF experiments and it is quite large (100MB+).  We did make changes so you’ll need to use our version.  Also, running our experiments requires ~30MB of data.

You have two options for running it.  Option 1 allows you to simply run the scripts from my account, so no downloading necessary.  Option 2 allows you to download our project folder which contains our modified MinorThird and our dataset and setup your environment and run the scripts.  

Option 1:
	Run the scripts (no setup required):
	CRF:
		$  bash /u/elatimer/nlp_project/scripts/crf/all.sh
		$  bash /u/elatimer/nlp_project/scripts/crf/meetingsTester.sh
		$  bash /u/elatimer/nlp_project/scripts/crf/randomTester.sh
		$  bash /u/elatimer/nlp_project/scripts/crf/newsgroupTester.sh
		$  bash /u/elatimer/nlp_project/scripts/crf/sriTester.sh
		$  bash /u/elatimer/nlp_project/scripts/crf/jobsTester.sh
	RegEx:
		$  bash /u/elatimer/nlp_project/scripts/regex/all.sh
		$  bash /u/elatimer/nlp_project/scripts/regex/meetingTester.sh
		$  bash /u/elatimer/nlp_project/scripts/regex/randomTester.sh
		$  bash /u/elatimer/nlp_project/scripts/regex/newsgroupTester.sh
		$  bash /u/elatimer/nlp_project/scripts/regex/sriTester.sh
		$  bash /u/elatimer/nlp_project/scripts/regex/jobsTester.sh

	Viewing results:
		At the end of each individual script you will see the overall span recall, precision and F1. The /u/elatimer/nlp_project/results directory contains the predicted spans as well as the standard ouput log.

Option 2: 
	Download Project Folder
		/u/elatimer/nlp_project

	Extract folder to your local environment
		Lets call this location $nlp_project
		Navigate inside directory
			$ cd $nlp_project

	Add $MINORTHIRD env variable pointing to minorthird directory
		e.g. export MINORTHIRD=$nlp_project/minorthird

	Build MinorThird
		$ cd minorthird/
		$ ant build
		$ cd ..
	
	Edit $MINORTHIRD/config/data.properties
		point “edu.cmu.minorthird.repository” to $nlp_project/data/repository
			eg. edu.cmu.minorthird.repository=$nlp_project/data/repository

	Choose script to run from scripts directory
		Options:
			CRF:
				$ ./local_scripts/crf/all.sh
				$ ./local_scripts/crf/meetingsTester.sh
				$ ./local_scripts/crf/randomTester.sh
				$ ./local_scripts/crf/newsgroupTester.sh
				$ ./local_scripts/crf/sriTester.sh
				$ ./local_scripts/crf/jobsTester.sh
			RegEx:
				$ ./local_scripts/regex/all.sh
				$ ./local_scripts/regex/meetingTester.sh
				$ ./local_scripts/regex/randomTester.sh
				$ ./local_scripts/regex/newsgroupTester.sh
				$ ./local_scripts/regex/sriTester.sh
				$ ./local_scripts/regex/jobsTester.sh

	Viewing results:
		At the end of each individual script you will see the overall span recall, precision and F1. The /u/elatimer/nlp_project/results directory contains the predicted spans as well as the standard ouput log.

	Scala Files:
		RegEx IE Method Implementation:
			- GetPersonalName.scala
			- GetDateTime.scala
			- GetProgLang.scala
		Each file contains the four iterations of RegEx patterns for each information type and follows the same basic algorithm to find all
		strings that match the current pattern and output the desired information used to compare to the gold standard provided by the label
		files of the annotations of the data.  The scripts use this scala program by calling the following line:
			scala Get[info-type].scala [path to and name of fold with data files] > [output file]
		For each file in the input folder, the content is read in as a string and the current RegEx pattern is used to ubild a list of all
		matching strings found in the file. Then, the index and length of each matching string is determined and printed on the same line, 
		along with the file name.  This output can be directed to a file that is used by GetFScore.scala to evaluated the performance of the 
		extraction task.

		Note: To select the iteration of RegEx to be used, the current RegEx variable must be set to the appropriate number. 
			For example, in GetProgLang.scala, to use the 3rd iteration pattern, set UsingRE equal to ProgLangRE3.
		
		RegEx Performance Evaluation
			-GetFScore.scala
		To evaluate the performance of the RegEx IE method, the output files from the above programs are provided as input to GetFScore.scala 
		along with the label file following the MinorThird format that contains the gold standard labeling for the appropriate files.  
		The recall, precision, and F1 values are then calculated easily.  The number of lines in the output file is the number of found entities.  
		The number of lines in the gold standard label file is the actual number of entities.  The correct number of entities found is the number
		of lines in the output file that match the gold standard label file.
