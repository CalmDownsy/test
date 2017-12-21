#!/bin/bash

if cp 07.txt 066.bak
then
	echo "good copy"
else
	echo "`basename $0`: error could not copy" >&2
fi

echo "请输入需要复制的文件: "
read sourcefile
if cp $sourcefile destfile.bak >/dev/null 2>&1; then
	echo "good copy \n`ls -l destfile.bak`"
else
	echo "`basename $0`: error $sourcefile: no souch file or dir"
fi

