# 09 · Make the feature repeatably provable

## Prerequisites

Lesson 8's implementation and baseline tests. The starter already supplies JUnit and Maven test tooling; do not add a new framework.

## Explanation

A regression test must fail for the old behavior and pass for the intended behavior. Use a fresh service per test and assert behavior, not incidental private fields. Tests should catch a missing check, an incomplete comparison, and a mutation before rejection.

## Demonstration — you perform the steps

1. Open the existing `TaskService` tests. Follow their JUnit imports/style and create narrowly named tests.
2. As an illustration of **one assertion**, after a test has added `"Plan"`:

```java
assertThrows(IllegalArgumentException.class, () -> service.add(" plan "));
```

Write your own setup and the rest of the tests; do not paste this line without understanding its precondition.

3. Cover exact duplicates, mixed case, surrounding whitespace, completed duplicates, unchanged list after rejection, next-ID continuity, and a distinct successful title. Keep all baseline tests.
4. From `starter/`:

```sh
mvn -B verify
```

5. Prove red against the baseline **without losing your feature**:
   - Copy your entire current `TaskService.java` into an unsaved editor buffer; keep it open.
   - At the course root, display the baseline source:

```sh
git show main:starter/src/main/java/org/example/training/TaskService.java
```

   - Temporarily replace only the production file's contents with that displayed baseline in VS Code. Keep your new tests unchanged.
   - Run `mvn -B verify` in `starter/`. The new duplicate tests should fail because the baseline accepts duplicates. Record their names/reasons.
   - **Immediately restore** the saved feature source from the unsaved buffer, save the file, and run `mvn -B verify` again. Do not commit/push while the baseline is restored.

This proof relies on `main` still being the original baseline, before lesson 12's merge. If it has changed, locate the import commit with `git log` and have the instructor verify the correct baseline before using `git show`.

## Learner action

Read `target/surefire-reports/` and match the summary to your test methods. Review `git diff` for only intended production/test changes. Explain which test detects ID consumption and which detects a mutable or live list.

## STOP checkpoint

Provide named red failures with baseline production code, the restored green verification summary, your test matrix, and a diff showing the feature is restored. **STOP: a green run alone does not prove the new tests detect the defect.**

## Recovery

- Tests not discovered: follow existing `*Test` naming and JUnit imports; check Maven's reported count.
- Red proof fails for unrelated compilation: restore your feature, fix the setup, and repeat; unrelated failures do not count.
- Saved source buffer lost: use VS Code local history and your prior diff with instructor help. Do not discard all changes.
- Assertion too broad: require `IllegalArgumentException`, not any exception.
- Green only after removing tests: restore the tests and fix the implementation.

## Independent challenge and completion criteria

Complete [exercise 09](../exercises/09-junit-tests.md). Add a independently designed test exposing an incomplete duplicate check, explain its failure mode, and verify the restored feature. Finish when new tests are meaningful and all baseline behavior is protected.

## Next module

[10 · Linked commits](10-linked-commits.md).
