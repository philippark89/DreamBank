for branch in $(git branch --format="%(refname:short)" --merged main); do 
  if (($(git log -1 --since='2 month ago' -s $branch|wc -l)==0)); then
    echo git branch -d $branch
  fi
done