#!/bin/bash
for filename in `ls`; do
	size=$(ls -l $filename | awk '{print $5}')
	if [[ $size -gt 100 ]]; then
		echo `ls -l $filename`
	fi
done