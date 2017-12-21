#/bin/bash
echo -n "login:" 
read name
echo -n "password:"
read passwd
if [ $name = "cht" -a $passwd = "abc" ];then
echo "the host and password is right!"
else echo "input is error!"
fi

if [[ $name = "cht" || $passwd = "abc" ]]; then
	echo "hahah"
fi

for loop in 1 2 3 4 5
do
    echo "The value is: $loop"
done