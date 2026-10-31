# 02 · Read, build, and run Java

## Prerequisites

Lesson 1's independent repository and JDK/Maven checks. The intentionally unfinished duplicate feature must still be present.

## Explanation

`pom.xml` describes coordinates, dependencies, Java level, and build plugins. `src/main/java` contains production code; `src/test/java` contains JUnit tests. Maven's `verify` lifecycle compiles, tests, packages, and runs configured verification. A passing baseline does not prove a feature its tests never checked.

`TaskService` stores tasks; `Task` is a record carrying `id`, `title`, and `completed`. A returned list snapshot is immutable and should not change when later tasks are added.

## Demonstration — you perform the steps

1. Open `starter/pom.xml`, `starter/src/main/java/org/example/training/App.java`, `TaskService.java`, and `Task.java`. Find `add`, `complete`, and `list`.
2. In a terminal at the course root:

```sh
cd starter
mvn -B verify
java -cp target/task-manager-1.0.0-SNAPSHOT.jar org.example.training.App
```

3. Read the test summary and open `target/surefire-reports/`. These are local generated files, not source to commit.
4. Open the tests in `src/test/java/org/example/training/`. Match tests to null/blank rejection, trimming, ID allocation, completion, unknown-ID handling, and list snapshots. Do not change them yet.
5. Trace how `App` constructs the service and prints its demonstration. It is a console example, not a web application. If it demonstrates duplicate acceptance, record that behavior; otherwise inspect `add` to locate the missing duplicate check.

## Learner action

Draw or describe this chain: Maven → compiled classes/tests → JAR → `App` → `TaskService` → `Task`. Explain why `list().add(...)` must not be used to modify the service.

Optional bounded prompt:

> Explain this POM's Java version and test plugin. Cite the lines you used. Do not suggest dependency changes or edit files.

## STOP checkpoint

Provide the actual Maven test summary, the JAR name, sanitized console output, and one baseline test name with the behavior it proves. Identify the duplicate behavior the baseline does not reject. **STOP: wait for evidence.**

## Recovery

- Compile error about release 17: compare `mvn -version` with `javac -version`.
- Dependency download fails: check approved network/proxy settings with the instructor. Do not disable TLS or add random mirrors.
- Entry point not found: run from `starter/`, verify the JAR exists, and use the exact fully qualified class name.
- Tests fail before edits: retain the output and have the instructor verify the scaffold; do not delete assertions to obtain green.

## Independent challenge and completion criteria

Complete [exercise 02](../exercises/02-java-maven.md). Explain compile vs test vs package, show baseline verification, and identify why green tests still permit duplicates. No feature code changes yet.

## Next module

[03 · Azure orientation](03-azure-orientation.md).
