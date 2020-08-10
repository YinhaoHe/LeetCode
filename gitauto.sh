echo -e "\033[32m[git auto start...]\033[0m"
msg=$1
if [ -n "$msg" ]; then
   git add -A
   git commit -m"${msg}"
   git pull
   echo -e "\033[32m[add, commit, pull finished, enter password to push]\033[0m"
   git push origin master
   echo -e "\033[32m[git auto successfully finished!]\033[0m"
else
   echo -e "\033[31m\033[01m\033[05m[Please add commit message e.g. (bash gitauto.sh \"commit message\")]\033[0m" 
fi