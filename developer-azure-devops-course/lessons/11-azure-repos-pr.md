# 11 · Request review in Azure Repos

## Prerequisites

Lesson 10's pushed feature commit, linked work item, green local tests, and an authorized reviewer.

## Explanation

A PR compares your feature branch with `main` and invites review before integration. Azure Repos is not GitHub: do not assume GitHub Copilot's hosted review integration exists on this PR. You can use VS Code Chat for local advisory feedback, but Azure's human review and policies are the authority.

## Demonstration — you perform the steps

1. Inspect your comparison locally:

```sh
git fetch origin
git diff --stat origin/main...HEAD
git diff origin/main...HEAD -- starter/src
```

2. **Consent gate:** agree to submit the training PR. In Azure Repos → Pull Requests → New Pull Request, select your feature branch as source and `main` as target.
3. Use title **Prevent duplicate task titles**. Describe:
   - User problem and comparison rule.
   - Files changed and why validation precedes mutation.
   - Named tests, red/green evidence, and the exact `mvn -B verify` result.
   - Known limits and risks. Do not claim an Azure CI run before one exists.
4. In the PR's **Work Items** section, explicitly add your item using its number/search picker. Check it resolves to the right project/item.
5. Add the designated reviewer. Create the PR (draft if the instructor prefers while evidence is incomplete).
6. Inspect Files, Commits, Work Items, Reviewers, and Policies/Checks. Before lesson 15, build validation may not yet be configured. Record **not configured**, rather than “passed.”

## Learner action

Explain source vs target, verify the diff contains only feature code/tests, and ask for a specific review question: “Does duplicate rejection leave the next ID unchanged?”

## STOP checkpoint

Provide PR number/source/target, the explicit Work Items link, assigned reviewer, and real policy/check status. Show that the description distinguishes local verification from CI. **STOP: no merge yet.**

## Recovery

- Wrong target/extra files: correct the target or make focused follow-up commits; do not hide unrelated changes in the description.
- No reviewer available: leave the PR pending; a model cannot approve on their behalf.
- Work-item search empty: verify project scope and permission with the instructor.
- GitHub-only review feature unavailable: use local Chat to inspect an attached diff, then obtain human Azure Repos review.

## Independent challenge and completion criteria

Complete [exercise 11](../exercises/11-azure-repos-pr.md). Independently verify every acceptance criterion has a reviewable test or explanation and identify an honest remaining risk. Finish when the PR is ready for a human reviewer.

## Next module

[12 · Review and merge](12-review.md).
