## green to echo 
function green(){
    echo -e "\033[32m[ $1 ]\033[0m"
}

## Error
function bred(){
    echo -e "\033[31m\033[01m[ $1 ]\033[0m"
}

## warning
function byellow(){
    echo -e "\033[33m\033[01m[ $1 ]\033[0m"
}

green "git auto start..."
msg=$1
if [ -n "$msg" ]; then
   git add -A
   git commit -m"${msg}"
   green "enter password to pull"
   git pull
   green "add, commit, pull finished, enter password to push"
   git push origin master
   green "git auto successfully finished!"
else
   bred "Please add commit message e.g. (bash gitauto.sh \"commit message\")"
fi




