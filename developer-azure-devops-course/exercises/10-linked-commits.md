# Exercise 10 · Trace the code to its requirement

**Prerequisite:** [lesson 10](../lessons/10-linked-commits.md)'s focused commit and approved push.

## Your task

At the course root:

```sh
git log -1 --oneline
git show --stat HEAD
git status --short
```

1. Inspect the committed files and confirm no `target/`, local cache, or credentials are included.
2. Find the commit in Azure Repos and its work-item reference.
3. Open the work item's Development/Links area and follow its commit link back to the same hash.
4. Choose one changed line and explain how it satisfies one acceptance criterion.

**Independent challenge:** explain why `feature/123-name` is not sufficient linkage and why native Azure Repos `#123` differs from GitHub's `AB#123` integration.

## STOP and evidence

Provide hash/message, actual linked item, sanitized committed-file list, and the changed-line explanation. If you used manual linking recovery, say so.

## Recovery

Follow lesson 10's link diagnostics. Never amend/force-push shared history just to repair a missing UI link.

## Completion criteria

- [ ] Commit contains only the intended feature/tests.
- [ ] Native `#ID` reference is present and UI linkage is verified.
- [ ] You can trace a requirement to a specific code/test change.

Next: [lesson 11](../lessons/11-azure-repos-pr.md).
