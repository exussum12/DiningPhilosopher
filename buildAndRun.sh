#!/bin/bash

find src -iname '*.java' > sources.txt
javac -d bin @sources.txt
rm sources.txt

cd bin
find . -iname '*.class' | xargs jar cvfm DiningPhilosopher.jar manifest.txt

java -jar DiningPhilosopher.jar
