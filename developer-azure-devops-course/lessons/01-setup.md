# 01 · Make a safe workspace

## Prerequisites

An instructor-provided course copy, installation permission, and a place outside the upstream repository for your own workspace. No Azure subscription or credentials are needed for this lesson.

## Explanation

A JDK compiles and runs Java. Maven builds and tests the project. Git records source changes. VS Code and Copilot help you understand those changes; neither replaces your judgment.

## Demonstration — you perform the steps

1. Copy the course directory to a standalone folder, outside every existing Git checkout. Open **that folder** in VS Code, not just `starter/`.
2. Install a JDK 17 from an approved distribution, Maven, and Git using your platform's documented installer. Set `JAVA_HOME` to the JDK and update PATH if required; restart VS Code after changing them.
3. Install **Extension Pack for Java**. Enable the Copilot Chat experience offered by your VS Code version and sign in through its UI. Use Chat/Ask rather than an autonomous edit/agent session.
4. Open Terminal → New Terminal at the course root:

```sh
java -version
javac -version
mvn -version
git --version
git rev-parse --show-toplevel
```

For a fresh independent folder, the last command should report that it is not a Git repository. If it points at the upstream checkout or a parent folder, stop and copy to an independent location.

5. Set your commit identity **locally**, using your real approved name/email, then create a local baseline:

```sh
git init -b main
git config user.name "Your Name"
git config user.email "your-approved-email@example.com"
git add README.md INSTRUCTOR.md PIPELINES.md course-structure.json lessons exercises LICENSE
git add .gitignore .github/copilot-instructions.md
git add starter/pom.xml starter/src starter/.github consumer/pom.xml consumer/src
git add azure-pipelines.yml settings.xml
git diff --cached --stat
git status --short
```

Inspect staged files. They should contain course source/templates, never passwords, generated `target/` files, caches, or upstream private files. The course's own `.gitignore` excludes Maven `target/` directories; inspect it rather than relying on the upstream repository's ignore rules.

```sh
git commit -m "Import Java Azure DevOps training baseline"
git rev-parse --show-toplevel
```

This is a local commit, not a push. Do not connect Azure until lesson 3.

## Learner action

Check that both Java commands report 17 and Maven reports a Java 17 runtime. Open `starter/pom.xml` and find the Java compiler setting. Ask Chat to read `INSTRUCTOR.md`, `course-structure.json`, and this lesson without editing or running anything.

## STOP checkpoint

Supply sanitized tool version output, the repository-root path, the baseline commit summary, and a Chat response confirming it will wait at checkpoints. Explain why this is not the upstream repository. **STOP: the tutor waits for this evidence.**

## Recovery

- Java runtime differs from compiler: fix `JAVA_HOME`/PATH and restart the terminal; Maven may use a different JDK.
- Maven/Git not found: follow the installed tool's platform instructions; do not paste unknown installation scripts into a shell.
- `git init -b` unsupported: update Git, or use `git init` followed by `git branch -M main` before committing.
- Copilot unavailable: attach/read the files manually and continue with the runbooks. Record the assistant capability as unavailable, not working.
- A file in the staging command is absent: check that your instructor delivered the full course before proceeding.

## Independent challenge and completion criteria

Complete [exercise 01](../exercises/01-setup.md). From a new terminal, reproduce the version checks without hints. Explain where source, Git metadata, and generated build files belong. Finish only when the workspace is independent and the baseline is committed.

## Next module

[02 · Java and Maven](02-java-maven.md). On resume, ask Chat to read the config and `02-java-maven`.
