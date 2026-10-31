# Exercise 04 · Make the feature testable

**Prerequisite:** [lesson 04](../lessons/04-boards.md)'s saved duplicate-title work item.

## Your task

1. Write input/expected-result examples for exact duplicate, mixed-case duplicate, whitespace duplicate, completed duplicate, and genuinely distinct title.
2. Describe a sequence of additions that proves a rejection does not consume an ID.
3. State what should remain in `list()` after rejection.
4. List out-of-scope changes: no database, UI, web server, authentication, fuzzy matching, or accent-normalization rules.
5. With consent, clarify any ambiguous criterion in the saved Azure item. Do not expand the feature without agreement.

**Independent challenge:** explain why `"Review"` and `"Review notes"` are not duplicates, while `"Review"` and `" REVIEW "` are.

## STOP and evidence

Show the real item number/type/state, acceptance examples, ID-continuity sequence, and out-of-scope list. The tutor waits.

## Recovery

If process fields differ, use the item's description. If the requirement is disputed, resolve it before planning code.

## Completion criteria

- [ ] Another person can determine pass/fail from your criteria.
- [ ] Display casing, trim, exception type, and completed-title behavior are clear.
- [ ] Every example fits the existing API.

Next: [lesson 05](../lessons/05-feature-branches.md).
