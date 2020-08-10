echo "git auto start..."
msg=$1
if [ -n "$msg" ]; then
   git add -A
   git commit -m"${msg}"
   git pull
   echo "add, commit, pull finished, enter password to push"
   git push origin master
   echo "git auto successfully finished!"
else
   echo "Please add commit message e.g. (bash gitauto.sh message)"
fi