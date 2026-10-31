# 18 · Independently deliver a title-length limit

## Prerequisites

Lessons 1–17, reviewed duplicate feature on `main`, working required PR validation, authorized reviewer, and documented feed/safeguard evidence. External steps still pending must be completed before claiming the full capstone passes.

## Explanation

The capstone checks your ability to connect requirements, implementation, tests, traceability, review, CI, and package boundaries without the tutor doing the work. The assistant may give bounded hints, not the finished feature or test suite.

## Demonstration — delivery pattern, not a solution

1. With consent, create a new Boards item **Limit task titles to 80 characters**. Clarify:
   - Measure the **trimmed** title using Java `String.length()` (UTF-16 code units); this lab does not count grapheme clusters.
   - Length 80 is accepted; length 81 throws `IllegalArgumentException`.
   - Null/blank and duplicate rules remain unchanged.
   - Rejected titles do not mutate state or consume IDs.
   - Existing completion and immutable-snapshot contracts remain intact.
2. At the course root, substitute your new item ID:

```sh
git switch main
git fetch origin
git pull --ff-only
git switch -c feature/456-title-length-limit
```

3. Write your own implementation plan and boundary-test matrix. Ask Chat:

> Critique my plan against these acceptance criteria. Ask me one question if a boundary is unclear. Do not edit, run tools, or provide a complete solution.

4. Implement the change and tests yourself. Run from `starter/`:

```sh
mvn -B verify
java -cp target/task-manager-1.0.0-SNAPSHOT.jar org.example.training.App
```

The console demo may not cover length boundaries; show the named tests that do.

5. Prove a new boundary test fails without your length check using lesson 9's preserve/temporarily-restore/restore method, this time comparing against the pre-capstone `main`. Restore your implementation and verify green before committing.

## Learner action — complete the delivery loop

- Stage only intended source/test paths, inspect secrets/diff, and commit with native `#ID`.
- With separate consent, push and create an Azure Repos PR explicitly linked through Work Items.
- Provide a readable description, actual red/green evidence, and scope/risks.
- Obtain genuine review, respond with evidence, and satisfy required build validation on the latest update. Do not bypass policy.
- With consent and approval, merge; update local `main`, verify it, and update the Board state appropriately.
- If separately approved, queue trusted-main publication under the existing protected environment and consume the resulting SNAPSHOT with a **new isolated cache**. Otherwise label the capstone re-publication optional/not executed; prior lessons' actual feed evidence is still required.
- Explain that a new immutable release would need an approved new version, consumer version update, and pipeline JAR-path update. Do not silently change version coordinates for this exercise.

## STOP checkpoint A

Show your saved item/criteria, independent plan, and boundary-test matrix **before implementation**. The tutor only reviews/hints and waits.

## STOP checkpoint B

Show source/test diff, named red/green results, and an explanation of validation order **before any push**. The tutor waits for explicit consent.

## STOP checkpoint C

Supply item/commit/PR linkage, real review response/approval, latest required CI run, completed PR, updated-main verification, and feed/safeguard evidence. Separate optional publication from actual mandatory outcomes. **STOP: assessment depends on observed evidence, not a generated report.**

## Recovery

- Off-by-one result: compare named tests at 79, 80, and 81 after trimming.
- Accidental unrelated refactor: reduce scope before review; preserve valid prior behavior.
- CI differs from local: compare Java version, exact commit, path, and clean build logs.
- Review/policy/access unavailable: keep the PR or deliverable pending; no fabricated completion.
- Re-publication collides/stale consumer: use the instructor-approved version/feed plan and a new cache, never remove shared packages.

## Independent challenge and completion criteria

Complete [exercise 18](../exercises/18-capstone.md). All mandatory evidence must be real. You must explain the new requirement, boundary tests, Git links, human review, CI policy, and consumption/security limitations without a tutor-generated solution.

## Next module

Course complete when assessed. The config's `next` is `null`. Save sanitized evidence, revoke temporary credentials, and agree cleanup with the instructor; no automatic external deletion.
