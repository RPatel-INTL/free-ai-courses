# Exercise 08 · Check state, not just exceptions

**Prerequisite:** [lesson 08](../lessons/08-implement-debug.md)'s learner-written feature. Rebuild the starter JAR before using a new JShell session.

## Your task

Use `jshell --class-path target/task-manager-1.0.0-SNAPSHOT.jar` from `starter/`, import `TaskService`, and create a **fresh** service for each sequence:

1. Add a title, try its exact duplicate, then inspect `list()`.
2. Add `"Review PR"`, try `" review pr "`, then add `"Write notes"` and compare IDs.
3. Add a title, complete its returned ID, then attempt the same title in another case.
4. Add two genuinely distinct titles and check their trimmed display casing.
5. Exit JShell with `/exit`. Run `mvn -B verify`.
6. Inspect your production diff at the course root and describe one debugger observation from the lesson.

**Independent challenge:** find a plausible incorrect implementation order that would still throw the duplicate exception but consume an ID. Explain how sequence 2 detects it without reading private fields.

## STOP and evidence

Provide exception types, list contents, ID continuity, completed-title result, green baseline summary, and your explained diff.

## Recovery

Restart JShell after rebuilding. Use a fresh service to avoid confusing old state with a defect.

## Completion criteria

- [ ] Exact/case/outer-whitespace duplicates are rejected.
- [ ] Rejection has no state/ID side effects.
- [ ] Completed titles remain reserved and distinct titles succeed.
- [ ] Baseline behavior and APIs are preserved.

Next: [lesson 09](../lessons/09-junit-tests.md).
