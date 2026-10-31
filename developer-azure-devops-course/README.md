# Java delivery with Copilot and Azure DevOps

An original, beginner-friendly, hands-on course for VS Code. Build a small Java 17 task manager with Maven, then deliver it through Azure Boards, Azure Repos, Azure Pipelines, and Azure Artifacts.

The product change is **preventing duplicate task titles**. The starting application deliberately permits duplicates: you will implement the feature, test it, link the work to a Board item, request a review, and build it in CI. Later, publish its Maven artifact and use it from a second application. The capstone adds a title-length limit.

## What you need

- A computer with permission to install VS Code, a **JDK 17**, Maven, and Git.
- VS Code's Extension Pack for Java and an enabled GitHub Copilot Chat account. Availability, models, and quotas depend on your account and organization.
- A **dedicated Azure DevOps sandbox project**, an Azure Repos Git repository, and a reviewer/instructor. GitHub is not the course's delivery platform.
- Instructor approval for Azure service usage, permissions, pipeline execution, and artifact storage. Access and parallel-job capacity vary by organization.

Local lessons 1–2 and 6–9 can be practiced without Azure. Boards, Repos, Pipelines, and Artifacts lessons require authorized access; they are not simulated successes.

## Open an independent learner workspace

Obtain this course folder from your instructor or a repository download. Copy **only `developer-azure-devops-course/`** to a standalone folder outside the original checkout, then open that folder in VS Code. Keep the folder name if convenient.

Do not experiment in the source course repository, a production repository, or someone else's sandbox. The Azure repository for your exercises should contain this folder's **contents at its root**, so `starter/pom.xml` and `azure-pipelines.yml` are root-relative paths.

Lessons 1–2 use your independent import copy. In lesson 3 you import it into the approved Azure repository (or use an instructor-preseeded baseline), then perform `git clone` into a **new sibling directory**. Open that cloned training root, verify its baseline, and use the clone for every subsequent lesson. Never clone inside the course root.

## Start or resume (no special commands required)

Open Copilot Chat in VS Code and ask:

> Read `INSTRUCTOR.md` and `course-structure.json` in this workspace. Teach lesson `01-setup` from its configured file. Follow the tutor rules: explain one small step, let me perform it, and STOP at every checkpoint until I supply observable evidence. Do not edit files, run commands, or act on external services for me.

To resume, substitute a lesson ID such as `09-junit-tests`, and add:

> My last completed checkpoint was [description]. Here is my evidence: [sanitized output or screenshot description]. Check prerequisites and continue from the first unverified checkpoint.

Use Chat's file attachment/context picker if it cannot find a file. Open the lesson and its exercise yourself if file-reading context is unavailable. You can complete the course manually: the lessons are complete runbooks, not instructions that require a catalog, CLI, or slash commands.

Keep the training repository root open for normal tutoring and repository operations. For **native starter instruction/skill discovery**, you may open `starter/` as a folder in a second VS Code window. In that window, open the root `INSTRUCTOR.md`, `course-structure.json`, and selected lesson through File → Open File, then attach them with **Add Context** (the UI label can vary). The course files are one directory above the starter workspace. Attach `starter/.github/skills/java-unit-tests/SKILL.md` manually if native skills remain unavailable. Opening `starter/` does not change Git's repository root or the pipeline's root-relative `starter/pom.xml` path.

## Course map

| # | Lesson | Result |
|---|---|---|
| 1 | [Setup](lessons/01-setup.md) | Independent workspace and tools |
| 2 | [Java and Maven](lessons/02-java-maven.md) | Understand, test, and run the scaffold |
| 3 | [Azure orientation](lessons/03-azure-orientation.md) | Authorized project and repository |
| 4 | [Boards](lessons/04-boards.md) | Acceptance criteria and work item |
| 5 | [Feature branches](lessons/05-feature-branches.md) | Safe branch linked to your plan |
| 6 | [Copilot planning](lessons/06-copilot-planning.md) | Reviewable implementation plan |
| 7 | [Instructions and skills](lessons/07-instructions-skills.md) | Explicit, verifiable assistant context |
| 8 | [Implement and debug](lessons/08-implement-debug.md) | Duplicate rejection in `TaskService` |
| 9 | [JUnit tests](lessons/09-junit-tests.md) | Regression tests and green verification |
| 10 | [Linked commits](lessons/10-linked-commits.md) | Traceable, narrowly staged change |
| 11 | [Azure Repos PR](lessons/11-azure-repos-pr.md) | Explicitly linked pull request |
| 12 | [Review](lessons/12-review.md) | Human feedback and approved merge |
| 13 | [Conflicts and revert](lessons/13-conflicts-revert.md) | Disposable conflict and safe undo |
| 14 | [Pipeline concepts](lessons/14-pipeline-concepts.md) | Build, test, artifact, policy model |
| 15 | [YAML Maven CI](lessons/15-yaml-maven-ci.md) | Real CI and PR build validation |
| 16 | [Artifacts publishing](lessons/16-artifacts-publish.md) | Approved feed publication |
| 17 | [Consumption and safeguards](lessons/17-consume-safeguards.md) | Feed-backed consumer and access checks |
| 18 | [Capstone](lessons/18-capstone.md) | Independently delivered title-length limit |

Every lesson has a paired exercise under `exercises/`. `course-structure.json` is the ordered navigation source; lesson links are conveniences.

## Project contract

The starter is `org.example.training:task-manager:1.0.0-SNAPSHOT`, with entry point `org.example.training.App`. `TaskService` exposes `add(String)` returning a `Task`, `complete(long)` returning the completed `Task`, and `list()` returning a `List<Task>`. `Task` is a record with `id`, `title`, and `completed`, accessed through `id()`, `title()`, and `completed()`. The service rejects null/blank titles, strips outer whitespace, allocates IDs, completes tasks, and returns an immutable list snapshot. Completing an unknown ID throws `NoSuchElementException`. The initial implementation **does not reject duplicates**.

The finished feature rejects titles equal after trimming and case-insensitive comparison, including when the existing task is completed. Preserve the display casing of the trimmed first title. A rejected addition must not create a task or consume an ID. Use `IllegalArgumentException` for invalid titles, including duplicates.

From a terminal in `starter/`:

```sh
mvn -B verify
java -cp target/task-manager-1.0.0-SNAPSHOT.jar org.example.training.App
```

Use the actual application output as evidence; the console demonstration is not an HTTP service or interactive UI. `consumer/` uses the published SNAPSHOT library. Read its POM and entry point before running it.

## Safety and validation status

Never put tokens, passwords, connection credentials, or private organization data in Git, prompts, screenshots, or logs. Use local Maven credentials outside the repository and pipeline authentication supplied by Azure. Learners need feed **Reader** access; only an approved build identity gets the minimum **Publisher/Contributor** role. Azure role names and scopes should be checked in your organization.

Azure Repos uses native `#123` commit references for work-item linking; **verify the link in the Azure UI**. `AB#123` describes a different GitHub integration and is not this workflow. Link the PR's Work Items section explicitly. Azure Repos PR validation uses a **branch policy**, not a YAML `pr:` trigger.

**Implementation-local checks reported by the course implementer:** 8 JUnit cases pass; the starter console demonstration runs; the Maven publishing profile deploys to a local `file://` repository and an isolated-cache consumer builds/runs; YAML syntax parses. Local `file://` publication is **not Azure feed validation**, and YAML parsing is **not pipeline execution**.

**Classroom validation status:** an instructor must still perform their own local verification, live Azure integration/permissions checks, and learner pilot before delivery. This course does not claim a successful Azure run, publish, permission audit, or learner pilot. Do not mark external checkpoints complete without real evidence.

See [INSTRUCTOR.md](INSTRUCTOR.md) for teaching rules, prerequisites, pilot checks, and assessment. The original files in this course directory use the **MIT License**; this grant does not change the license of other repository content. See [LICENSE](LICENSE).
