#!/bin/bash

echo "compiling source code"
echo "making build files"
javac com/company/*/*.java -d build/
echo "completed!"
cd build
echo "starting application."
java com.company.game.Main
echo "cleaning build files."
cd ..
rm -rf build/
