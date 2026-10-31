# Exercise 13 · Explain the safe history

**Prerequisite:** [lesson 13](../lessons/13-conflicts-revert.md)'s local disposable branch exercise.

## Your task

At the course root:

```sh
git log practice/conflict-left -6 --oneline --graph
git show practice/conflict-left:conflict-practice.md
git branch --show-current
git status --short
```

1. Identify the left/right commits, merge resolution, annotation, and revert.
2. Explain why both original delivery-note facts survive the resolution.
3. Explain why the annotation disappears but its commit remains.
4. Confirm that `main` has no practice file and that no practice branch was pushed.

**Independent challenge:** describe how you would resolve a conflict in `TaskService` safely: inspect both changes, preserve acceptance criteria, verify tests, and obtain review. Do not create a real service conflict just for the exercise.

## STOP and evidence

Provide history/resolved content, revert explanation, return-to-main status, and local-only confirmation.

## Recovery

If you are still in a merge/revert, use the lesson's operation-specific abort guidance before switching branches.

## Completion criteria

- [ ] A real conflict was observed and resolved deliberately.
- [ ] A normal commit was reverted without rewriting history.
- [ ] Shared/application branches remain unaffected.

Next: [lesson 14](../lessons/14-pipeline-concepts.md).
