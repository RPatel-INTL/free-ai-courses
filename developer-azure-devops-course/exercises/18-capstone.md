# Exercise 18 · Deliver independently

**Prerequisite:** [lesson 18](../lessons/18-capstone.md)'s readiness gate and all prior mandatory local/Azure evidence.

## Your task

Deliver **Limit task titles to 80 characters** through the full workflow. The tutor may explain a concept or ask a question, but must not author your solution or perform external actions.

1. Create the approved Board item with the trimmed Java `String.length()` contract.
2. Create a feature branch from updated `main` and write your own plan.
3. Implement narrowly and write boundary/regression tests.
4. Demonstrate red against pre-capstone production code, restore the feature, then demonstrate green.
5. Inspect/stage/commit only intended files with native `#ID`.
6. With consent, push and open an explicitly linked Azure Repos PR.
7. Answer real review, obtain human approval, and pass latest required build validation.
8. With consent, complete the PR, update local `main`, verify, and update the work-item state.
9. Present prior actual feed-backed consumption and safeguards evidence. Optionally, with separate approval, re-publish trusted-main and re-consume with a new cache; label this optional action accurately.

## Independent test matrix

Include accepted 79/80-character titles, rejected 81-character titles, trimming before measurement, no state/ID change on rejection, duplicate prevention, and all baseline behaviors. Explain the UTF-16 code-unit definition and avoid inventing grapheme-counting requirements.

## STOP evidence gates

- **Before editing:** saved item, independent plan, boundary matrix.
- **Before pushing:** your diff, named red/green output, restored feature, secret/staging review.
- **Before claiming complete:** real item/commit/PR links, review thread/vote, required latest CI run, merge/main verification, consumption and control matrix.

Tutor: stop at each gate and wait. No automatic merges, approvals, pipeline runs, publication, or cleanup.

## Recovery

Use earlier lessons' targeted recovery. Keep blocked Azure work pending; a local or simulated substitute does not satisfy an external deliverable.

## Completion criteria

- [ ] Feature and tests meet the explicit length/duplicate/state contract.
- [ ] You can explain the code without assistant-generated narration.
- [ ] Work item, native linked commit, and explicitly linked PR agree.
- [ ] Human review and current required CI validation are real.
- [ ] Reviewed `main` verifies after integration.
- [ ] Prior required publication/consumption evidence is real, not cached/local-only.
- [ ] Safeguard limitations and pending instructor checks are stated honestly.
- [ ] Optional re-publication is separately authorized or labeled not executed.

Course complete only after instructor assessment. Agree cleanup and credential revocation; do not automatically delete external resources.
