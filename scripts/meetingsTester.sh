export CLASSPATH="${CLASSPATH}:.:${MINORTHIRD-.}/class:${MINORTHIRD-.}/lib/*:${MINORTHIRD-.}/lib/minorThirdIncludes.jar"
export CLASSPATH="${CLASSPATH}:${MINORTHIRD-.}/lib/mixup:${MINORTHIRD-.}/config"
export MONTYLINGUA="${MINORTHIRD-.}/lib/montylingua"

java  -Xmx1000M edu.cmu.minorthird.ui.TrainTestExtractor -labels meetings_train_loader -test meetings_test_loader -spanType true_name -learner "new Recommended.VPTagLearner()" -output "predicted_name" -showTestDetails true -saveAs meetingResults

#VPHMMLearner()
#CRFAnnotatorLearner()
#HMMAnnotatorLearner()
#VPTagLearner()