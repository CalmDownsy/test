#!/bin/bash
echo "$1"
echo "$2"
echo "$3"
echo "$#"
echo "$*"
echo "$@"
for i in "$*";do
echo $i
done

for j in "$@";do
echo $j
done
