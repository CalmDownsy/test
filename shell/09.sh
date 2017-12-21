#!/bin/bash
echo "input a user"
read username
cu=$(whoami)
echo $cu
if [[ $username != $cu ]]; then
	echo "$username is not running"
fi