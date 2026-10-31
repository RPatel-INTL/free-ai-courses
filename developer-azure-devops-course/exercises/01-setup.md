# Exercise 01 · Prove the workspace is yours

**Prerequisite:** [lesson 01](../lessons/01-setup.md)'s tool installation and local baseline. Work only in your independent course copy.

## Your task

1. Close the terminal and open a new one at the course root.
2. Run `java -version`, `javac -version`, `mvn -version`, `git --version`, and `git rev-parse --show-toplevel`.
3. Run `git log -1 --oneline` and `git status --short`. Explain each untracked item rather than assuming it is safe.
4. Open the starter POM, main source directory, and test directory without a tutor pointing to them.
5. Start a fresh Chat with the README start prompt, or read the same files manually if Chat is unavailable.

**Independent challenge:** explain what would happen if you opened the upstream repository instead of the standalone course folder. Explain how Maven can use a different JDK from VS Code.

## STOP and evidence

Supply sanitized versions, repository root, baseline commit, and confirmation that Chat will wait (or the manual fallback). Do not share your complete environment or credential configuration.

## Recovery

Return to lesson 01's PATH and workspace checks; do not initialize a nested repository to hide the wrong root.

## Completion criteria

- [ ] Java compiler and Maven runtime use Java 17.
- [ ] Git root is the independent learner workspace.
- [ ] Baseline contains source/templates, not secrets/build output.
- [ ] You can start/resume without a custom command.

Next: [lesson 02](../lessons/02-java-maven.md).
