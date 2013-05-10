NLP_DIR=/u/elatimer/nlp_project

scala $NLP_DIR/scripts/regex/GetPersonalName.scala $NLP_DIR/data/repository/data/meetings_test/bunch4/ > regex.predicted
scala $NLP_DIR/scripts/regex/GetFScore.scala regex.predicted $NLP_DIR/data/repository/data/meetings_test/bunch4.labels
