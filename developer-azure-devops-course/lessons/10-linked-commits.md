# 10 · Commit a traceable change

## Prerequisites

Lesson 9's restored feature and green tests; your Azure work-item ID and feature branch.

## Explanation

A commit groups a reviewed change. Azure Repos can link a commit to a work item using a native `#ID` reference in its message. A branch name alone is not a link. `AB#ID` is not the native Azure Repos workflow taught here.

## Demonstration — you perform the steps

At the course root:

```sh
git branch --show-current
git status --short
git diff --check
git diff -- starter/src
git diff --name-only
```

Review every changed file for accidental edits and secrets. Build output, caches, tokens, local settings, and unsaved scratch work must not be included.

Stage only the production file and the test files **you actually changed**. If your new tests use another filename, substitute its actual path:

```sh
git add starter/src/main/java/org/example/training/TaskService.java
git add starter/src/test/java/org/example/training/TaskServiceTest.java
git diff --cached --stat
git diff --cached
git commit -m "Prevent duplicate task titles #123"
git log -1 --format=fuller
```

Replace `123` with your real item number. Do not use a message that requests closing a work item before review and verification.

**Consent gate:** review what the push shares and confirm the sandbox remote:

```sh
git remote -v
git push
```

In Azure Repos → Commits, open the new commit and inspect linked work items. Open Boards → your item → Links/Development and verify the commit appears. Linking behavior depends on project configuration and permissions; **UI evidence is required**.

## Learner action

Explain why an unstaged file will not travel with this commit and why `git add .` would be risky here. Record the commit hash and work-item link.

## STOP checkpoint

Show the staged-file review, commit hash/message, pushed commit in Azure, and native work-item link in the UI. **STOP: if the link is absent, this checkpoint is not complete.**

## Recovery

- A file should not be staged: `git restore --staged PATH` unstages it without discarding its contents.
- Link missing: verify the number/project, reference syntax, access, and project linking configuration. With consent, use the work item's Add link → Development/Commit picker or the commit's link UI to add the correct commit explicitly. Do not claim automatic linking worked if you used manual recovery.
- Commit omitted a file: create a follow-up focused commit referencing the same item. Do not rewrite already shared history.
- Secret staged/committed: stop before pushing. Remove it and arrange rotation; if pushed, notify the instructor and follow incident handling rather than just deleting the latest line.

## Independent challenge and completion criteria

Complete [exercise 10](../exercises/10-linked-commits.md). Trace one changed line through the commit to the work item and explain the native vs GitHub integration distinction. Finish when code and planning evidence are linked in Azure.

## Next module

[11 · Azure Repos pull request](11-azure-repos-pr.md).
