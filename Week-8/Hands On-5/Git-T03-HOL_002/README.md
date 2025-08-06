# Git-T03-HOL_002

This repository contains files created as part of the Git Hands-On Lab `Git-T03-HOL_002`.

## Files

- `sample.log`: A basic log file.
- `log/test.log`: A nested log file inside the `log` directory.

## Objective

Demonstrate the ability to create files, track changes using Git, and push updates to a remote repository (GitHub).

## Commands Used

```bash
echo "This is a log file." > sample.log
mkdir log
echo "Another log file." > log/test.log
git init
git add .
git commit -m "Initial commit for Git-T03-HOL_002"
git push -u origin main
```
