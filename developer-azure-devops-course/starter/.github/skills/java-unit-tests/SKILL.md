---
name: java-unit-tests
description: Plan and verify focused JUnit tests for the Java task-manager training application.
---

1. Read the learner's acceptance criteria, `TaskService`, and existing tests.
2. Ask the learner to describe one normal case, one boundary, and one failure case.
3. Propose a test matrix and wait for approval before editing.
4. Use fresh service instances and deterministic JUnit assertions. Do not add mocking libraries for in-memory code.
5. For a new behavior, demonstrate a failing test before implementing the fix.
6. Run `mvn -B verify` from `starter/` with permission. Report actual test counts and failures.
7. Ask the learner to explain why each assertion matters and review the diff together.

Do not stage, commit, push, or publish. If skill discovery is unsupported in the installed Copilot client,
the learner can attach this file to chat and request the same workflow manually.
