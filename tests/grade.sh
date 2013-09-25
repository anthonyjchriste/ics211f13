#!/bin/bash

# Basic usage: bash grade.sh /location/to/source/directory/containing/all/source/files/for/a/student

# Name of the test class with no file extension
TEST_CLASS="Assignment02Tests"

# Name of the test class with .java file extension
TEST_SRC=$TEST_CLASS.java

# Location of JUnit jar file
JUNIT_HOME="/home/anthony/Data/UH/ics211f13private/lib/junit-4.11.jar"

# Location of Hamcrest jar file (needs to be included in class path for junit to work)
HAMCREST_HOME="/home/anthony/Data/UH/ics211f13private/lib/hamcrest-core-1.3.jar"

# Location of src files (passed in as first argument to script)
SRC_DIR=$1

# Class which runs test classes
JUNIT_RUNNER="org.junit.runner.JUnitCore"

# Copy the test class to source directory
cp $TEST_SRC $SRC_DIR/.

# Compile (compiling the test class should compile everything)
javac -cp $SRC_DIR:$JUNIT_HOME $SRC_DIR/$TEST_SRC 

# Extra compile options
javac -cp $SRC_DIR $SRC_DIR/CreateSegments.java

# Run JUnit (output to stdout and a report is generated in the src directory)
java -cp $SRC_DIR:$JUNIT_HOME:$HAMCREST_HOME $JUNIT_RUNNER $TEST_CLASS | 2>&1 tee $SRC_DIR/report.txt



