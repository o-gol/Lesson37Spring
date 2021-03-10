set /p textCommit="commit info:"
echo %textCommit%
git add -A
git commit -a -m"%textCommit%"
git push
cmd