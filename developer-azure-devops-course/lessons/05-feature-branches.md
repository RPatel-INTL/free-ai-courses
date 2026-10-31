# 05 · Work on a feature branch

## Prerequisites

Lesson 4's work-item ID; clean tracked files, baseline `main` pushed to your Azure repo. Build output may be untracked; never stage it.

## Explanation

A feature branch isolates your change from `main`. It is not a copy of the whole project. A push shares commits; uncommitted edits remain local. Branch names help humans but do not automatically create work-item links.

## Demonstration — you perform the steps

At the course root, substitute your own numeric work-item ID:

```sh
git status --short
git switch main
git fetch origin
git pull --ff-only
git switch -c feature/123-prevent-duplicate-titles
git branch --show-current
git log -1 --oneline
```

Do not switch branches with unexplained tracked changes. `--ff-only` refuses an unexpected divergent update rather than silently creating a merge.

**Consent gate:** decide whether to share this branch now. If approved:

```sh
git push -u origin feature/123-prevent-duplicate-titles
```

Inspect Azure Repos → Branches. The branch currently has the same content as `main`; no feature code exists yet.

## Learner action

Find the branch indicator in VS Code and compare it with `git branch --show-current`. Explain what `origin` and an upstream tracking branch mean. Record your branch and work-item ID outside the repo.

## STOP checkpoint

Show branch name, last commit, and clean **tracked-file** status. If pushed, show it in Azure; if not, explicitly label it local-only. **STOP: verify you are not editing `main`.**

## Recovery

- Tracked edits present: inspect the diff and preserve intentional work. Ask for help before moving it; do not discard blindly.
- Branch name exists: inspect its commit/status and resume it, or choose another instructor-approved name.
- `pull --ff-only` fails: investigate divergence with `git log --oneline --all --graph`; do not force push.
- Git too old for `switch`: update or use the instructor's equivalent `checkout -b` command.

## Independent challenge and completion criteria

Complete [exercise 05](../exercises/05-feature-branches.md). Show the same branch in terminal and editor, explain local vs remote state, and identify the next safe step before any edit.

## Next module

[06 · Copilot planning](06-copilot-planning.md).
