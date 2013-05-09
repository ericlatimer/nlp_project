MINORTHIRD="/u/elatimer/nlp_project/minorthird/"

export CLASSPATH="${CLASSPATH}:.:${MINORTHIRD-.}/class:${MINORTHIRD-.}/lib/*:${MINORTHIRD-.}/lib/minorThirdIncludes.jar"
export CLASSPATH="${CLASSPATH}:${MINORTHIRD-.}/lib/mixup:${MINORTHIRD-.}/config"
export MONTYLINGUA="${MINORTHIRD-.}/lib/montylingua"

time java  -Xmx1000M edu.cmu.minorthird.ui.TrainTestExtractor -labels newsgroup_train_loader -test newsgroup_test_loader -spanType true_name -learner "new Recommended.CRFAnnotatorLearner()" -output "predicted_name" -showTestDetails true -saveAs results/newsgroupResults

#VPHMMLearner()
#CRFAnnotatorLearner()
#HMMAnnotatorLearner()
#VPTagLearner()