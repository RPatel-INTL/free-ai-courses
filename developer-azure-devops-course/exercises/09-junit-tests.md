# Exercise 09 · Build a regression matrix

**Prerequisite:** [lesson 09](../lessons/09-junit-tests.md)'s learner-written tests and restored feature.

## Your task

1. Map test method names to:
   - Exact, mixed-case, and whitespace duplicates.
   - Duplicate after completion.
   - Unchanged snapshot/list after rejection.
   - No consumed ID and a subsequent distinct success.
2. Verify the existing null/blank, trimming, ID, completion, unknown-ID, and immutable-snapshot tests remain.
3. Independently add a focused scenario missing from your initial matrix. Avoid duplicating a test merely to increase the count.
4. Perform lesson 09's safe baseline red proof, then immediately restore the implementation.
5. Run `mvn -B verify` in `starter/`; inspect the report and actual diff.

**Independent challenge:** explain which test catches an implementation that compares case-insensitively but before trimming. Explain why catching any exception would weaken the suite.

## STOP and evidence

Supply test names/matrix, actual baseline red failures, restored green summary, and proof the feature—not the baseline—is present in the final diff.

## Recovery

If the proof fails during compilation instead of assertions, correct the setup and repeat. Restore the saved feature before any commit.

## Completion criteria

- [ ] Tests detect the missing feature, not an unrelated failure.
- [ ] All baseline tests remain green.
- [ ] Tests assert the specified exception and public state.
- [ ] No generated reports or scratch buffers are staged.

Next: [lesson 10](../lessons/10-linked-commits.md).
