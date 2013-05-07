export CLASSPATH="${CLASSPATH}:.:${MINORTHIRD-.}/class:${MINORTHIRD-.}/lib/*:${MINORTHIRD-.}/lib/minorThirdIncludes.jar"
export CLASSPATH="${CLASSPATH}:${MINORTHIRD-.}/lib/mixup:${MINORTHIRD-.}/config"
export MONTYLINGUA="${MINORTHIRD-.}/lib/montylingua"

time java  -Xmx2000M edu.cmu.minorthird.ui.TrainTestExtractor -labels ericJobs_train_loader -test ericJobs_test_loader -spanType true_lang -learner "new Recommended.CRFAnnotatorLearner()" -output "predicted_date" -showTestDetails true -saveAs results/projectWorldResults

#VPHMMLearner()
#CRFAnnotatorLearner()
#HMMAnnotatorLearner()
#VPTagLearner()