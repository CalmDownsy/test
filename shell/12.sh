#!/bin/bash

if grep 'LHJS\>' ./06.txt >/dev/null 2>&1;then
	echo "lhj in txt"
else
	echo "no lhj"
fi

echo "input list of names"
read list
if echo $list | grep "lhj" > /dev/null 2>&1;then
	echo "lgj in list"
else
	echo "no content"
fi

echo "独立应用 底层服务 专有云只服务中国站 "