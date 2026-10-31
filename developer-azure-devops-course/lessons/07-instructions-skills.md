# 07 · Give reusable, inspectable context

## Prerequisites

Lesson 6's reviewed plan; VS Code Chat or the manual file-reading fallback.

## Explanation

Repository instructions describe ongoing conventions. Path-scoped instructions focus on matching files. A skill packages a repeatable workflow with a `SKILL.md`. These do not grant permissions, guarantee correctness, or override your consent.

Automatic support/discovery varies with VS Code version, settings, workspace root, and organization policy. This workspace's root instructions govern tutoring. The starter's nested files are **not guaranteed to load automatically** when the course root is open.

## Demonstration — you perform the steps

1. Read these files in VS Code:

```text
.github/copilot-instructions.md
starter/.github/copilot-instructions.md
starter/.github/instructions/java.instructions.md
starter/.github/skills/java-unit-tests/SKILL.md
```

2. Find the path-scoped file's `applyTo` frontmatter. Explain which Java source/test paths it intends to match. Check its patterns against the workspace root; do not silently assume nested patterns apply.
3. Check your installed VS Code/Chat version and its current documentation/settings for **custom instructions**, **instruction files**, and **agent skills**. If supported, look for the chat's context/reference or diagnostics UI indicating the files actually used. A model saying “I used it” is not proof of automatic discovery.
   - To try **native starter discovery**, open a second VS Code window, select File → Open Folder, and open `starter/` within your training repository. Its `.github` files are now workspace-root context.
   - In that window use File → Open File to open the training root's `INSTRUCTOR.md`, `course-structure.json`, this lesson, and its exercise. Use Chat's **Add Context** control to attach them explicitly; labels vary by version.
   - Keep the original training-root window open for navigation and root-relative Git commands. The starter window's terminal starts in `starter/`, so `mvn -B verify` runs there directly. Pipeline `-f starter/pom.xml` still starts at the training repository root.
4. Regardless of discovery, attach the three starter files plus the test file to Chat. Ask:

> Read these attached instructions and the Java unit-tests skill as explicit context. Summarize the workflow and propose two duplicate-title test scenarios only. Do not edit, execute commands, or provide the whole exercise solution. Cite the attached files.

5. If skills are not supported, treat `SKILL.md` as an ordinary Markdown checklist: open it, select the relevant steps, and follow them manually. Do not install an unapproved extension or assume slash commands exist.

## Learner action

Identify one repository-wide rule, one Java-only rule, and one repeatable testing step. Write a proposed clarification in an unsaved note, not a global settings file. Use the existing conventions; no new dependency or instruction overhaul is needed.

## STOP checkpoint

Show the instruction/skill paths, your VS Code version, the intended `applyTo` scope, and either observable discovery references or an explicit **manual attachment fallback**. Supply the two scenarios and explain why instructions are not security enforcement. **STOP: wait for evidence.**

## Recovery

- Nested files not discovered: try the separate starter-folder window with root lesson files attached, or explicitly attach the starter guidance/skill in the original root window. Do not move files or change pipeline paths to obtain discovery.
- Preview skills setting unavailable: use the checklist manually; do not mark native support as successful.
- Assistant ignores a rule: restate it and inspect the result; change your workflow rather than trusting a claim.
- Course copy lacks files: ask the instructor to restore the delivered scaffolding.

## Independent challenge and completion criteria

Complete [exercise 07](../exercises/07-instructions-skills.md). With a fresh chat, reproduce explicit context loading and show a bounded response. Finish when you can separate actual feature support from the fallback and explain both.

## Next module

[08 · Implement and debug](08-implement-debug.md).
