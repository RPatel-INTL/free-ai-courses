# 08 · Implement duplicate prevention and inspect behavior

## Prerequisites

Lessons 5–7; your feature branch, acceptance criteria, reviewed plan, and green baseline. No production services or new dependencies.

## Explanation

Validation belongs before state changes. A string comparison can look correct yet miss case or whitespace. Debugging means reproducing a behavior, predicting what should happen, and checking the actual state—not asking Copilot to rewrite everything.

## Demonstration — you perform the steps

1. In `starter/`, build and reproduce the baseline through the JDK's JShell:

```sh
mvn -B verify
jshell --class-path target/task-manager-1.0.0-SNAPSHOT.jar
```

At the JShell prompt:

```java
import org.example.training.TaskService;
var service = new TaskService();
service.add("Review PR");
service.add(" review pr ");
service.list();
/exit
```

The unfinished scaffold accepts both titles. Record that actual observation before editing.

2. In VS Code, open `TaskService.java`. Write the feature yourself from your plan:
   - Preserve null/blank validation and the existing `strip()` whitespace behavior, then use the trimmed title. Do not weaken it by replacing it with a different normalization rule.
   - Compare against all stored titles case-insensitively.
   - Throw `IllegalArgumentException` on a match.
   - Only after validation succeeds, allocate the ID and store the new `Task`.
   - Preserve display casing and existing APIs. Completed tasks still reserve their title.
3. Ask Chat for a **hint**, if needed:

> Here is my comparison and validation order. Which acceptance case could fail? Explain without rewriting my implementation.

4. Rebuild with `mvn -B verify`. Exit/restart JShell so it loads the **new** JAR. Repeat the reproduction: the second addition should now throw `IllegalArgumentException`.
5. In a fresh JShell session, name the returned task so you can use its record accessor:

```java
import org.example.training.TaskService;
var service = new TaskService();
var first = service.add("Review PR");
service.complete(first.id());
service.add(" REVIEW PR ");
service.list();
var next = service.add("Write notes");
next.id();
/exit
```

The duplicate call should throw; subsequent JShell statements still run. Compare `first.id()` and `next.id()` and inspect the list to determine whether rejection consumed an ID or changed state.
6. For debugger practice, set a breakpoint on a line in `add` in VS Code. Open `App.java` and select **Debug Java** (or Run and Debug's Java entry). Step through one add, inspect the actual parameter/local variables and ID state, and stop the debug session. Do not assume the console demo exercises every acceptance case.

## Learner action

Inspect your diff at the course root:

```sh
git diff -- starter/src/main/java/org/example/training/TaskService.java
git status --short
```

Explain the validation order, why the duplicate scan includes completed tasks, and how you preserved the first title's casing.

## STOP checkpoint

Provide the baseline duplicate reproduction, the new exception, an unchanged list after rejection, the distinct addition's expected ID, and a debugger observation. Show the narrowly scoped diff. **STOP: manual behavior is not yet sufficient regression coverage.**

## Recovery

- JShell still accepts duplicates: exit, rebuild, verify JAR timestamp/path, and start a new JShell.
- Comparison misses spaces/case: inspect values before comparing; do not normalize the stored display title to lowercase.
- IDs skip after rejection: move validation before the increment; verify with a new service.
- Debug Java missing: check Extension Pack for Java and wait for project import. JShell still provides diagnostic evidence, but debugger practice is pending until available.
- Baseline tests break: inspect the first failure and preserve the public contract. Never weaken tests to hide a regression.

## Independent challenge and completion criteria

Complete [exercise 08](../exercises/08-implement-debug.md). Independently demonstrate exact/case/whitespace duplicate rejection and successful distinct additions without a tutor writing code. Finish when the acceptance behavior and baseline are intact.

## Next module

[09 · JUnit tests](09-junit-tests.md).
