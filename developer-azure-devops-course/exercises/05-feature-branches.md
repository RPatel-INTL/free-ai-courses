# Exercise 05 · Verify isolation before editing

**Prerequisite:** [lesson 05](../lessons/05-feature-branches.md)'s feature branch.

## Your task

At the course root:

```sh
git branch --show-current
git status --short
git log -1 --oneline
git branch -vv
```

1. Compare the terminal branch with VS Code's indicator.
2. Identify the baseline commit and whether the branch has an upstream.
3. If you approved its push, locate it under Azure Repos → Branches. Otherwise say local-only.
4. Explain why the work-item number in the branch name is useful but does not prove linking.

**Independent challenge:** predict which information changes after the first feature commit and which remains unchanged until a push. Do not create an empty commit to test the prediction.

## STOP and evidence

Supply branch/status/upstream observations and the next safe editing step.

## Recovery

If on `main` or with unexplained edits, use lesson 05's preservation steps before continuing.

## Completion criteria

- [ ] Feature branch is based on current authorized `main`.
- [ ] No unexplained tracked changes exist.
- [ ] You can distinguish local branch, commit, remote branch, and work-item link.

Next: [lesson 06](../lessons/06-copilot-planning.md).
