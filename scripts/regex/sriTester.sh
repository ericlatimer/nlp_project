NLP_DIR=/u/elatimer/nlp_project

scala $NLP_DIR/scripts/regex/GetDateTime.scala $NLP_DIR/data/repository/data/sri-projectWorld/projectWorld4/ > $NLP_DIR/regex.predicted
scala $NLP_DIR/scripts/regex/GetFScore.scala $NLP_DIR/regex.predicted $NLP_DIR/data/repository/labels/sri-projectWorld/projectWorld4-dates-corrected.env