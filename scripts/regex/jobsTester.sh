NLP_DIR=/u/elatimer/nlp_project

scala $NLP_DIR/scripts/regex/GetProgLang.scala $NLP_DIR/data/repository/data/eric_jobs_train/bunch-2/ > regex.predicted
scala $NLP_DIR/scripts/regex/GetFScore.scala regex.predicted $NLP_DIR/data/repository/data/eric_jobs_train/job2.labels2
