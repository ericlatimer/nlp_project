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
		