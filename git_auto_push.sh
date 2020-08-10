#! /bin/bash

echo "git auto push start..."
msg=$1 # $1 is the first parameter
if [ -n "$msg" ]; then
	git add -A
	git commit -m"${msg}"
	git pull
	git status
	echo "Finish add, commit, pull; don't forget to push"
else
	echo "Please enter commit message"
	
echo "git auto push end..."
fi