# Tutor and instructor guide

## Interactive teaching contract

Read this file, `course-structure.json`, and the learner's selected lesson before teaching. Attach the paired exercise when needed. These are original course materials, not an imitation of a third-party course.

1. Ask which lesson/checkpoint the learner has reached and what sanitized evidence they have. On a new start, begin lesson 1.
2. Confirm that prerequisites are met. Explain only the next small step, with its purpose and expected observation.
3. A **demonstration** is a worked description for the learner to perform. It is not permission for the tutor to execute the commands.
4. Let the learner type commands, edit code, inspect output, and make decisions. Give hints before solutions. Do not implement the feature, generate their complete test suite, or finish the capstone for them.
5. At every **STOP**, wait for the specified evidence. Ask a follow-up if evidence is ambiguous. Never fabricate output, a green build, a work-item link, an approval, or a deployment.
6. For external actions—creating/editing Boards items, pushing, opening or merging PRs, altering policies/permissions, running pipelines, publishing/deleting packages—explain the consequence and require explicit consent for that action. Default to learner-performed actions. Prior consent for one action is not blanket consent for others.
7. Do not call Azure/GitHub tools or use agent mode to act silently. Do not ask for secrets. If a learner shares a credential, pause, advise revocation/rotation, and remove it from retained examples; never repeat it.
8. Use small, bounded Copilot prompts. Require the learner to explain suggestions and review diffs. Chat output is a proposal, not authority.
9. Prefer local recovery steps; preserve the learner's work. Avoid force pushes, `reset --hard`, bulk deletion, and policy bypass.
10. Advance only when the checkpoint and exercise completion criteria have been demonstrated. Read the config's next entry instead of assuming a slash command.

The learner may disable Copilot and use the same lesson manually. File instructions and skills are aids, not security controls or guarantees of model behavior.

## Start/resume procedure

The learner asks Copilot Chat to read these files as shown in README. If reading fails, have them attach/open the three files. Do not assume a CLI catalog, custom command registration, a GitHub-hosted repository, or support for every preview VS Code feature.

Keep a learner-owned note **outside the repository**, containing:

- Lesson ID and last checkpoint verified.
- Tool versions, current branch, and sanitized test summary.
- Azure project/repository name, work-item number, PR number, and pipeline run number when applicable.
- Outstanding issues and the next step.

On resume, recheck `git status`, branch, and the most relevant evidence. A claimed completion is not enough if the workspace has changed. If Azure access is unavailable, mark that checkpoint **blocked/pending**; continue an independent local lesson only after explaining that it does not satisfy the blocked external outcome.

## Classroom preparation (instructor-required; pending until performed)

Use a dedicated sandbox and individual learner repositories or isolated branches. Never share a production service connection or PAT.

1. Validate supported installers for Windows/macOS/Linux. Require JDK 17, Maven, Git, VS Code, Extension Pack for Java, and working Copilot Chat entitlement. Shell examples are portable commands; use separate terminals for directory changes. Explain Windows PATH/environment-variable setup.
2. Copy course contents to a standalone repository root. Confirm `starter/`, `consumer/`, `azure-pipelines.yml`, and `settings.xml` match the documentation. Initialize the learner repository without carrying the upstream course repository's Git history.
3. Run `mvn -B verify` in `starter/` and the console application. Inspect baseline coverage and confirm duplicates are intentionally accepted. Verify the feature/test exercises remain unsolved.
4. Ensure learners can access Azure Boards and Repos, create work items and feature branches, push, and submit PRs. Provide a reviewer. Select the project process: Agile uses User Story, Scrum uses Product Backlog Item, Basic uses Issue; a Task is acceptable when configured.
5. Confirm Azure Pipelines access, approved agent pool, Java 17 availability, outbound Maven connectivity, parallel-job capacity, and YAML permissions. Review untrusted-branch permissions and logging.
6. Confirm the root YAML uses the correct `starter/pom.xml` path, runs Maven verification, publishes test results even on failure, and saves a JAR as a pipeline artifact.
7. Configure `main` policy after the first successful CI run: required reviewers, no self-approval as the only approval, and automatic/required build validation. Ensure direct pushes cannot bypass the intended controls. Explain any admin privileges learners do not have.
8. Create a **project-scoped** training feed with a unique per-learner name, or use an instructor-managed versioning plan. Check Reader access for consumers and minimum Publisher/Contributor rights for the actual pipeline build identity. Cross-project access and organization-scoped feeds require different setup and are outside the default path.
9. Read the YAML's `publishPackage`, `feedName`, and `feedUrl` parameters and the starter's `azure-artifacts` profile. Supply approved sandbox queue-time values for the placeholder URL/name. The profile reads `AZURE_ARTIFACTS_URL` and `artifactFeedId`; `MavenAuthenticate` must select the same project feed and matching server ID. Create the `training-packages` environment beforehand with independent approvals and restricted pipeline access. The publish parameter starts **false**; its trusted-main/non-PR condition is an accident guard, not protection against malicious pipeline edits.
10. Validate a deliberately failed PR build is blocked, a corrected PR build can pass, and publishing is absent on feature/PR runs. With separate explicit approval, validate one trusted-main publish and one feed-backed consumer restore with an isolated local Maven cache.
11. Verify skill discovery in the installed VS Code version, or teach the manual attachment fallback. For native starter context, open `starter/` as a folder in a second VS Code window and attach the root instructor/config/lesson files through Add Context. Validate path-scoped instruction support and record the extension versions. Keep the original root window for course navigation and root-relative Git commands.
12. Perform a learner pilot. Record elapsed time, confusing steps, screenshots of current Azure UI, and recovered failures. Sanitize all logs. Check licensing, service costs, quotas, package retention, and agreed cleanup.

**Implementation-local checks reported by the course implementer:** 8 JUnit cases pass, the console demo runs, the publishing profile and isolated-cache consumer work against a local `file://` Maven repository, and YAML syntax parses. These checks do not establish Azure feed connectivity, policy enforcement, or successful pipeline execution.

**No live validation is implied by this checklist.** Keep a dated instructor record outside the published repository. Until the instructor actually performs them, their own local classroom verification, Azure integration validation, permission validation, and learner pilot are **pending**.

## Evidence and assessment

For each lesson, ask for the named STOP evidence and the paired exercise criteria. Accept pasted sanitized summaries, a screen share, or screenshots with credentials/private data removed. Review actual diffs and test names, not just a model's summary.

Feature acceptance:

- Null/blank input is rejected and stored titles are trimmed.
- Duplicates are rejected with `IllegalArgumentException` after trim/case-insensitive comparison.
- Rejection does not mutate tasks or allocate an ID; completing a task does not free its title.
- Existing ID, completion, missing-ID exception, and immutable list snapshot behavior remains intact.
- JUnit regression tests fail before the feature and pass after it.
- Board item, native `#ID` commit link, explicitly linked Azure Repos PR, human review, and required build evidence agree.

The conflict/revert lesson stays local on disposable branches. Learners do not rewrite shared history or introduce a broken feature into `main`.

## Artifact boundaries

A pipeline artifact is a run's downloadable JAR. An Azure Artifacts feed is a Maven package registry with coordinates and access control. One does not prove the other.

`SNAPSHOT` packages are for this sandbox exercise and may resolve to new timestamped builds. Coordinate collisions and caches can obscure evidence. Use isolated feeds or approved versions and a fresh local consumer cache; do not delete shared packages to resolve collisions. Production release/version/promotion design is a discussion, not a claimed implementation.

Use the feed's **Connect to feed → Maven** instructions as the authority for URLs and server IDs. Keep local credentials in the user's Maven settings outside this repository. The root `settings.xml` is a credential-free template, not a place to paste a PAT. Never commit a generated effective settings file.

## Capstone assessment

Require independently written acceptance criteria, a plan, implementation, boundary tests, a linked commit and PR, review responses, a policy-enforced green build, and an explanation of publication safeguards. The learner must state what was actually executed versus pending. A pending external step is not a passing external deliverable.

## Cleanup

With explicit approval, the learner/instructor may remove disposable Azure branches, disable training pipelines, and apply agreed artifact retention or sandbox deletion. Check ownership and impact first. Revoke temporary credentials, remove local authentication/cache material through approved OS procedures, and keep sanitized evidence. Do not automatically delete projects, feeds, repositories, or learner work.
