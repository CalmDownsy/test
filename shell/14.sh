#!/bin/bash

location=`pwd`
echo $location

location2=$(pwd)

echo $location2

# if [[ ${location} != "/" ]]; then
# 	echo "not in root dir cant run script ${location}" >&2
# 	exit 1 
# fi

if [[ $# -lt 3 ]]; then
	echo "`basename $0` needs 3 args" >&2
	exit 1
fi

echo $1
echo $2
echo $3


read editor
if [[ -z $editor ]]; then
	echo "your editor is not init"
else
	echo "$editor"
fi

dir=$1
if [[ -z "`ls $dir`" ]]; then
	echo "$dir is empty"
else
	echo "`ls -l $dir`"
fi