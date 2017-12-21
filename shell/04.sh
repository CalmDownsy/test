#!/bin/bash
val=`expr 1 + 2`
echo "$val"

a=20
b=10

if [[ $a -gt $b ]]; then
	echo "$a gt $b"
fi

a1="string1"
b1="string2"

if [[ $a1 = $b1 ]]; then
	echo $a1
fi

if [[ -z $a1 ]]; then
	echo "0"
else
	echo "no"
fi

if [[ $a1 ]]; then
	echo $a1
else
	echo "noooooo"
fi