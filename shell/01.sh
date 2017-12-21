#!/bin/bash
echo "hello shell" 
name="lhj"
g="\"$name\""
g2="$name"
g3="${name}"
echo $g
echo $g2
echo $g3
string="runoob is a great company"
echo `expr index "$string" is`
