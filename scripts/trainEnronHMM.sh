export CLASSPATH="${CLASSPATH}:.:${MINORTHIRD-.}/class:${MINORTHIRD-.}/lib/*:${MINORTHIRD-.}/lib/minorThirdIncludes.jar"
export CLASSPATH="${CLASSPATH}:${MINORTHIRD-.}/lib/mixup:${MINORTHIRD-.}/config"
export MONTYLINGUA="${MINORTHIRD-.}/lib/montylingua"

java  -Xmx1000M edu.cmu.minorthird.ui.TrainExtractor -labels enron0_names -spanType name -learner "new Recommended.HMMAnnotatorLearner()"