# Exercise 06 · Critique an assistant plan

**Prerequisite:** [lesson 06](../lessons/06-copilot-planning.md)'s bounded planning conversation.

## Your task

1. Produce your own three-step implementation plan and a test matrix.
2. Check each assistant claim against the API/source and criteria.
3. Reject or revise any proposal that changes the public API, consumes an ID before validation, ignores completed tasks, or adds dependencies.
4. Write a debugging prompt containing a sanitized observation, expected behavior, relevant file context, and “explain only; do not edit or execute.”
5. Run `git diff --stat` at the course root and confirm planning did not change source.

**Independent challenge:** explain why a very confident assistant response is weaker evidence than a test or source inspection. Give one specific mistake you checked for.

## STOP and evidence

Show your plan, matrix, bounded prompt, checked claim, and unchanged source status.

## Recovery

Use manual file attachment if context is missing. Stop unintended agent edits and inspect them before undoing anything.

## Completion criteria

- [ ] You own and can defend the plan.
- [ ] The prompt grants no external-action consent and contains no secrets.
- [ ] Assistant limitations are explicitly acknowledged.

Next: [lesson 07](../lessons/07-instructions-skills.md).
