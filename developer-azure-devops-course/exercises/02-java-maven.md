# Exercise 02 · Explain a green baseline

**Prerequisite:** [lesson 02](../lessons/02-java-maven.md). No feature edits.

## Your task

1. From `starter/`, run `mvn -B verify`.
2. Identify the artifact coordinates and Java version in the POM.
3. Run `java -cp target/task-manager-1.0.0-SNAPSHOT.jar org.example.training.App`.
4. Select three existing JUnit tests. For each, state its setup, action, and assertion.
5. Locate the `add` code that trims a title and allocates an ID. Determine whether it inspects existing titles before adding.

**Independent challenge:** predict whether two calls adding `"Review"` and `" review "` will succeed in the scaffold. Compare the prediction with the implementation; do not “fix” it yet.

## STOP and evidence

Show actual test summary, JAR name, console output, three test explanations, and the untested duplicate behavior. The tutor waits.

## Recovery

Use lesson 02's JDK/network/path checks. A download error is not a failed feature assertion.

## Completion criteria

- [ ] Build and console demonstration actually run.
- [ ] You distinguish source, compiled classes, tests, and JAR.
- [ ] You can explain immutable snapshots and the intentional missing feature.

Next: [lesson 03](../lessons/03-azure-orientation.md).
