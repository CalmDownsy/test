#!/bin/bash

echo "input a file name"
read filename
if [[ -e /Users/zhangsy/Desktop/test/shell/$filename ]]; then
	echo "the file exist"
else
	echo "asdt"
fi

if [[ -x  /Users/zhangsy/Desktop/test/shell/$filename ]]; then
	echo "run it"
else
	echo "read it"
fi