# 12 · Respond to review and integrate

## Prerequisites

Lesson 11's Azure Repos PR and a real reviewer. Follow all currently enabled branch policies.

## Explanation

Review is a conversation about correctness and maintenance. An assistant can flag risks but cannot replace authorization or a human approval. A review comment is resolved by evidence and agreement, not by merely pressing Resolve.

## Demonstration — you perform the steps

1. Ask the reviewer to inspect duplicate comparison, ID continuity, completed-task behavior, and test strength. They should leave at least one genuine question or improvement comment.
2. Read the comment and restate the concern. If an edit is needed, write it yourself on the same feature branch, run `mvn -B verify` in `starter/`, and review the diff.
3. Commit only the actual changed paths with a message referencing your work item; for example:

```sh
git add starter/src/test/java/org/example/training/TaskServiceTest.java
git diff --cached
git commit -m "Clarify duplicate regression coverage #123"
```

Do not manufacture a code change just to demonstrate a commit.

**Consent gate:** approve pushing the response, then run `git push`. Reply in Azure with the actual commit/test evidence (or a reasoned explanation if no edit was needed). Resolve the thread only after reviewer agreement.

4. The reviewer records their vote. Inspect all required policies. If CI policies already exist, every required check must pass; if not, record that limitation and use the instructor's explicit initial-course merge authorization. You will establish enforced build validation in lesson 15 before capstone delivery.
5. **Consent gate:** only when authorized and policies are satisfied, complete the PR using the project's approved merge strategy. Do not choose “bypass policies.” Do not auto-delete a branch you still need for evidence.
6. At the course root:

```sh
git switch main
git fetch origin
git pull --ff-only
git log -3 --oneline
```

Then run `mvn -B verify` in `starter/`. Verify the work item's Development links include the completed PR. Change its state to Done/Closed only when acceptance and the instructor's workflow permit.

## Learner action

Explain the reviewer concern and how evidence answered it. Distinguish local green tests, required policy checks, the human vote, and the completed merge.

## STOP checkpoint

Show a real review thread/response, reviewer approval, policy status, completed PR, and local verification on updated `main`. Label absent CI policy as absent. **STOP: no invented approval or bypass.**

## Recovery

- Reviewer requests changes: keep the PR open and iterate.
- New commits reset approval: obtain the required fresh review.
- Merge conflict: do not force push; use the instructor's conflict assistance or practice lesson 13 first on disposable branches.
- `pull --ff-only` fails: inspect divergence; preserve local commits and ask for help.
- Work item not auto-closed: update its state explicitly with consent after verifying acceptance; linkage alone does not imply closure.

## Independent challenge and completion criteria

Complete [exercise 12](../exercises/12-review.md). Give a reasoned response to review and explain what controls actually governed this merge. Finish when the reviewed feature is visible and green on `main`.

## Next module

[13 · Conflicts and revert](13-conflicts-revert.md).
