# Exercise 11 · Make review easy

**Prerequisite:** [lesson 11](../lessons/11-azure-repos-pr.md)'s Azure Repos PR.

## Your task

1. Inspect PR source/target, Files, Commits, Work Items, Reviewers, and Policies/Checks.
2. Map each acceptance criterion to a test or code explanation in the PR description.
3. Verify the PR's explicit Work Items link—not just its title/message.
4. Check that local `mvn -B verify` evidence is dated or associated with the actual commit.
5. With consent, improve the description if it overclaims CI or assistant review support.

**Independent challenge:** write one focused question for the human reviewer and one honest limitation (for example, simple in-memory storage rather than persistence).

## STOP and evidence

Supply PR number/source/target, actual work-item link, reviewer assignment, criterion map, and real current policy status.

## Recovery

Correct a wrong branch/diff before asking for approval. If CI is not configured yet, say so; do not label it passed.

## Completion criteria

- [ ] PR is reviewable and narrowly scoped.
- [ ] Explicit Azure work-item link is correct.
- [ ] Human Azure review is requested without assuming GitHub-hosted Copilot review.
- [ ] No merge or bypass has occurred.

Next: [lesson 12](../lessons/12-review.md).
