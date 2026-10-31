# 15 · Run CI and enforce PR validation

## Prerequisites

Lesson 14, YAML in the Azure repository root, approved agent/parallel-job capacity, and an instructor authorized to create a pipeline and change `main`'s policies. Publication remains disabled.

## Explanation

A green CI run is evidence for one commit. Required build validation checks the PR's relevant version and can become stale. A policy must be verified by observing both failure and recovery, not just checking a settings box.

## Demonstration — you perform the steps

**Consent gate:** instructor approves pipeline creation and a validation-only run.

1. In Azure Pipelines → New pipeline, select **Azure Repos Git**, your learner repo, and **Existing Azure Pipelines YAML file**. Select `main` and `/azure-pipelines.yml`. Review rather than replacing the file with a wizard-generated template.
2. Save/create the pipeline. If the UI offers Save and Run together, approve that specific validation-only execution. Leave `publishPackage` **false**. Record the pipeline name.
3. Inspect its run: commit/branch, Java 17 setup, Maven verification, Tests tab, and `task-manager-jar` artifact. `Publish` must be skipped.

**STOP checkpoint A:** supply a real run number, successful test summary, JAR artifact listing, and skipped Publish stage. If unavailable, mark CI pending. The tutor waits.

4. **Consent gate:** instructor configures Repos → Branches → `main` → Branch policies:
   - Required human reviewers, without self-approval as the sole approval.
   - Required linked work items when supported by the project.
   - **Build validation**: this pipeline, Automatic trigger, Required policy, and an expiration policy that revalidates when `main` changes (immediately for this lab).
   - Appropriate branch security so direct pushes/policy bypass are not a learner escape hatch.
5. Create an approved training Task/Issue **Verify PR build policy**, record its ID, and create `feature/ID-ci-policy-probe` from updated `main`.
6. Add a deliberately failing assertion to one existing JUnit test using VS Code:

```java
assertTrue(false, "Temporary training policy probe");
```

Use the existing static import or qualify `org.junit.jupiter.api.Assertions.assertTrue`. This is a **temporary sandbox probe**, not application logic.

7. Run `mvn -B verify` in `starter/` and observe failure. Stage only the test file, commit with the probe work-item `#ID`, and—with specific consent—push and open an explicitly linked PR into `main`.
8. Inspect the PR policy's validation run. It must fail, publish the failed test result, and block normal completion. Confirm the latest PR update is the evaluated version.

**STOP checkpoint B:** show the failed test, PR build-policy failure, and blocked completion state. Do not click bypass. The tutor waits.

9. Remove only the probe assertion, verify locally, commit the correction with `#ID`, and—with consent—push. Observe fresh green required validation. The Publish stage must still skip.
10. With consent, **abandon this probe PR** after recording recovery; it has no net product change and is not merged into `main`. Update the probe item appropriately. Return to `main` and leave the branch for evidence or approved cleanup.

## Learner action

Check that failed-test reporting uses `succeededOrFailed()` while JAR publication does not claim success after failed Maven verification. Explain why YAML `pr:` is unnecessary for Azure Repos validation.

## STOP checkpoint C

Show corrected green validation on the latest probe update, skipped Publish, required policy configuration, and abandoned probe PR. **STOP: UI setup without the failure/recovery evidence is not complete.**

## Recovery

- Run queued indefinitely: instructor checks parallel jobs, pool approval, and capacity.
- YAML path failure: ensure the course contents—not an enclosing folder—are repository root.
- No test results: inspect `starter/target/surefire-reports/TEST-*.xml` glob and the Maven failure; compilation errors may occur before tests are generated.
- PR has no automatic validation: check the target branch's policy, pipeline selection, and filters.
- Publish runs on a probe: stop and alert the instructor; treat it as a safety failure, not a successful lesson.
- Unauthorized to alter policies: instructor performs the approved administrative step and shows evidence; learner does not escalate their permissions.

## Independent challenge and completion criteria

Complete [exercise 15](../exercises/15-yaml-maven-ci.md). Trace an actual failure from test to run to PR policy, then prove recovery. Finish only after real Azure validation and enforcement, or explicitly record the external checkpoint as pending.

## Next module

[16 · Artifacts publishing](16-artifacts-publish.md).
