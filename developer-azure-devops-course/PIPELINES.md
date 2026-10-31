# Pipeline and Maven feed lab

## Training repository layout

Copy the **contents** of this course directory into a separate Azure Repos training repository.
Its root must contain `starter/`, `consumer/`, `lessons/`, and `azure-pipelines.yml`.
Do not point this pipeline at the existing public repository or change its other courses.
Use Azure DevOps Services for this example; Azure DevOps Server needs supported task/agent alternatives.

## Instructor prerequisites

1. Create an isolated project and a same-project Maven feed named `training-feed`.
   Give learners Reader access for consuming packages; grant publishing rights only to approved
   training publishers. A lab on local publishing requires temporary, narrowly scoped publishing access.
2. Check hosted-agent parallel-job entitlement, or provide a permitted self-hosted pool with
   Java 17 and Maven. The example uses a Microsoft-hosted Ubuntu agent.
3. Create a pipeline from this YAML and configure `main` branch policies: required reviewers,
   linked work items, no direct pushes, and automatic required build validation on PR updates.
   YAML `trigger` controls branch CI, not Azure Repos PR validation.
4. Create the `training-packages` environment **before** publishing. Configure approval checks
   and restrict its pipeline permissions outside YAML. Do not let learners approve their own publication.
5. Identify the actual project-scoped build service identity. For publication it needs feed
   Feed Publisher (Contributor) access; don't grant Project Collection-wide rights.
   Keep job authorization project-scoped. Check feed permissions and pipeline authorization explicitly.
6. Copy the HTTPS Maven URL from Artifacts → Connect to feed → Maven. Run a manually approved
   build from `main` with `publishPackage: true`, the actual feed name, and that URL.
   If using another feed name, the server ID created by `MavenAuthenticate@0` must match
   the `artifactFeedId` supplied to Maven. For cross-project feeds, follow the feed's connection
   instructions and grant explicit project access; this lab intentionally uses the same project.

## Authentication and security boundaries

`MavenAuthenticate@0` writes temporary agent-user Maven settings using the job identity.
The pipeline does **not** use the local `settings.xml` template or store a PAT in YAML.
Do not print generated settings or upload them as artifacts.

The branch condition and opt-in parameter prevent accidental PR publication; they are **not**
a security boundary against a contributor who can edit pipeline scripts. A build identity with
feed publishing rights can potentially be used by other jobs in the same authorized project.
For untrusted contributors or production use, isolate publication into a protected pipeline/project
with a separate publisher identity, centrally enforced template/permissions and approvals.
The training feed must contain no valuable or production packages. Restrict who can edit YAML,
queue publishing runs, change checks, or change feed permissions.

Local Maven authentication uses `settings.xml` (server ID `training-feed`) with
`${env.AZURE_ARTIFACTS_TOKEN}`. Set a short-lived, organization-approved token privately in
your shell environment using your organization's secret-handling process. Never paste tokens into
Copilot chat, shell commands saved in history, committed files, screenshots, or reports.
Use read-only packaging scope for consumption; publishing requires approved write access.
Clear the environment variable and revoke temporary credentials after the lab.
Use the platform's approved credential provider instead if required by your organization.

## Local commands

Run from the training repository root. Set `AZURE_ARTIFACTS_URL` to the real feed URL first.
These commands access Azure only after the instructor has provisioned it and you approve.

```sh
mvn -B -f starter/pom.xml verify
java -jar starter/target/task-manager-1.0.0-SNAPSHOT.jar

# Authorized local publication only; pipeline publication is the preferred delivery path.
mvn -B -s settings.xml -f starter/pom.xml deploy -Pazure-artifacts

# Use an empty cache to prove resolution from the feed rather than local installation.
mvn -B -U -s settings.xml -f consumer/pom.xml verify -Pazure-artifacts \
  -Dmaven.repo.local=consumer/target/feed-cache
```

After successful feed consumption, run the downloaded package directly on macOS/Linux:

```sh
java -cp "consumer/target/classes:consumer/target/feed-cache/org/example/training/task-manager/1.0.0-SNAPSHOT/task-manager-1.0.0-SNAPSHOT.jar" org.example.consumer.App
```

On Windows, use `;` instead of `:` between classpath entries. To run from VS Code,
first repeat the authenticated consumer Maven command **without** `-Dmaven.repo.local`
to populate the IDE's default cache from the feed, then reload its Maven project.
Do not count that cached IDE run alone as proof of feed connectivity.
The consumer depends on the starter JAR, not its source tree. Its basic `verify` builds the
consumer; it does not contain a unit-test suite.

For a local-only preview, run `mvn -B -f starter/pom.xml install`, then
`mvn -B -f consumer/pom.xml verify`. This proves Java API compatibility **not** feed connectivity.

## Versions and outputs

`org.example.training:task-manager:1.0.0-SNAPSHOT` is the training coordinate.
Maven snapshots resolve timestamped builds and may need `-U` to refresh.
Release versions are immutable: publish each approved version once and change both the
producer version and consumer `taskManagerVersion` for subsequent releases.
The sample pipeline's JAR path targets the initial SNAPSHOT; update that path when changing versions.
Give each cohort its own feed or coordinates to avoid version collisions.

A **pipeline artifact** is a run-associated downloadable JAR.
An **Azure Artifacts Maven feed** stores the JAR, POM and metadata for dependency resolution.
The consumer lab proves that the POM and metadata were published as well as the JAR.

## Live validation checklist (instructor must execute)

Local build success does not prove this checklist. Record real run IDs and sanitized evidence.

- Feature push builds; PR branch policy requires validation on the latest update.
- A deliberately failing JUnit test blocks the PR and publishes failure results.
- A PR cannot enter the publishing stage; default runs skip publication.
- A trusted `main` publishing run waits for the externally configured approval.
- Approved publication appears in the feed under the expected Maven coordinates.
- A consumer with an empty cache resolves from the feed and executes the demo.
- Reader credentials cannot publish, and unauthorized pipelines cannot use protected publishing resources.
- Revoke temporary access and clean up the isolated training resources after the pilot.

These Azure checks and the beginner pilot remain pending until an authorized instructor runs them.
