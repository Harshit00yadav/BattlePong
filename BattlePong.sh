#!/bin/bash

echo "compiling source code"
echo "making build files"
javac src/*/*.java -d build/
echo "completed!"
cd build
echo "starting application."
java src.game.Main
echo "cleaning build files."
cd ..
rm -rf build/
