#!/bin/bash
echo "123"
while [[ con=`ls ./00` ]]; do
	if [[ $con="" ]]; then
		echo "NULL"
		break;
	fi
done