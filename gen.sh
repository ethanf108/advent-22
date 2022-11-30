#!/bin/sh

cp advent_template.java src/advent22/Advent$1.java
sed -i 's/%%%NUM%%%/'$1'/g' src/advent22/Advent$1.java
touch src/in/in$1.txt
