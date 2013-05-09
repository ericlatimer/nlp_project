NLP_DIR=/u/elatimer/nlp_project

scala $NLP_DIR/scripts/regex/GetPersonalName.scala $NLP_DIR/data/repository/data/random_test/enronBoth/ > $NLP_DIR/regex.predicted
scala $NLP_DIR/scripts/regex/GetFScore.scala $NLP_DIR/regex.predicted $NLP_DIR/data/repository/data/random_test/enron7-9.labels 