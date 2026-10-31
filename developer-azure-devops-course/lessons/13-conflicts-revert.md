# 13 · Resolve a conflict and undo safely

## Prerequisites

Lesson 12's updated `main`, clean tracked files, and Git editor access. This entire practice stays **local on disposable branches**; do not push it or edit service code.

## Explanation

A conflict means Git cannot combine competing edits automatically. Resolution is a deliberate content choice, not “always take mine.” `git revert` adds a new commit reversing an earlier change, preserving history. Reverting a merge needs extra decisions; we practice on a normal one-parent commit instead.

## Demonstration — you perform the steps

At the course root:

```sh
git status --short
git switch main
git switch -c practice/conflict-base
```

1. In VS Code create `conflict-practice.md` containing one line: `Delivery note: baseline`. Stage/commit **only this file**:

```sh
git add conflict-practice.md
git commit -m "Create local conflict practice note"
git switch -c practice/conflict-left
```

2. Change that line to `Delivery note: tests reviewed`, save, then:

```sh
git add conflict-practice.md
git commit -m "Practice left edit"
git switch practice/conflict-base
git switch -c practice/conflict-right
```

3. Change the same line to `Delivery note: package checked`, save, then:

```sh
git add conflict-practice.md
git commit -m "Practice right edit"
git switch practice/conflict-left
git merge practice/conflict-right
git status --short
```

Expect a conflict in the note. **STOP checkpoint A:** show the conflict markers/editor and explain both intended edits. The tutor waits before giving resolution hints.

4. Read both versions and write the resolved line yourself, preserving both facts, for example `Delivery note: tests reviewed; package checked`. Remove all conflict markers, save, then:

```sh
git add conflict-practice.md
git diff --cached
git commit -m "Resolve local delivery-note conflict"
git log -4 --oneline --graph
```

5. Add a second line `Temporary practice annotation`, save, stage the note, and create a normal commit:

```sh
git add conflict-practice.md
git commit -m "Add disposable annotation"
git log -1 --oneline
git revert --no-edit HEAD
git log -2 --oneline
git status --short
git switch main
```

The annotation should disappear while both commits remain. The practice file should not exist on `main`. Leave the local branches for assessment; cleanup is optional and authorized separately.

## Learner action

Explain why the resolved content is correct, what revert preserved, and why you did not force push or reset shared history. Run `mvn -B verify` in `starter/` on `main` to confirm no application change traveled with the practice.

## STOP checkpoint B

Show resolved content/history, the ordinary commit and its revert, your return to `main`, and verification. **STOP: demonstrate both operations, not just an explanation.**

## Recovery

- No conflict: check that both branches started at the same seed commit and changed the exact same line.
- Want to restart the unresolved merge: `git merge --abort` before resolution/commit, then inspect status. It does not undo a completed merge.
- Revert conflicts: inspect the targeted commit; `git revert --abort` safely cancels the in-progress revert. Ensure you targeted the one-parent annotation commit, not the merge.
- Branch/file already exists: inspect it and use new local practice names; never delete someone else's work.

## Independent challenge and completion criteria

Complete [exercise 13](../exercises/13-conflicts-revert.md). Explain how a real code conflict would additionally require tests and review. Finish when local practice history proves a resolved conflict and a safe undo while `main` remains unchanged.

## Next module

[14 · Pipeline concepts](14-pipeline-concepts.md).
