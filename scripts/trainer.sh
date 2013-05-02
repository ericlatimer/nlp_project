export CLASSPATH="${CLASSPATH}:.:${MINORTHIRD-.}/class:${MINORTHIRD-.}/lib/*:${MINORTHIRD-.}/lib/minorThirdIncludes.jar"
export CLASSPATH="${CLASSPATH}:${MINORTHIRD-.}/lib/mixup:${MINORTHIRD-.}/config"
export MONTYLINGUA="${MINORTHIRD-.}/lib/montylingua"

java  -Xmx1000M edu.cmu.minorthird.ui.TrainExtractor -labels train_loader -spanType true_name -learner "new Recommended.HMMAnnotatorLearner()" -saveAs train_trained