NLP_DIR=/u/elatimer/nlp_project

scala $NLP_DIR/scripts/regex/GetPersonalName.scala $NLP_DIR/data/repository/data/newsgroup_test/bunch3b/ > regex.predicted
scala $NLP_DIR/scripts/regex/GetFScore.scala regex.predicted $NLP_DIR/data/repository/data/newsgroup_test/bunch3.labels
