export CLASSPATH="${CLASSPATH}:.:${MINORTHIRD-.}/class:${MINORTHIRD-.}/lib/*:${MINORTHIRD-.}/lib/minorThirdIncludes.jar"
export CLASSPATH="${CLASSPATH}:${MINORTHIRD-.}/lib/mixup:${MINORTHIRD-.}/config"
export MONTYLINGUA="${MINORTHIRD-.}/lib/montylingua"

mkdir results
time java  -Xmx2000M edu.cmu.minorthird.ui.TrainTestExtractor -labels projectWorldTrain.sri -test projectWorldTest.sri -spanType true_date -learner "new Recommended.CRFAnnotatorLearner()" -output "predicted_date" -showTestDetails true -saveAs results/projectWorldResults

#VPHMMLearner()
#CRFAnnotatorLearner()
#HMMAnnotatorLearner()
#VPTagLearner()
