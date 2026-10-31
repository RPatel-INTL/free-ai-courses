# 17 · Consume from the feed and verify boundaries

## Prerequisites

Lesson 16's published SNAPSHOT, feed Reader access, Java/Maven, and approved local authentication or access to the publishing run's consumer step. No source duplication or new dependency is needed.

## Explanation

The consumer declares a Maven dependency on the task-manager library. A local `mvn install` could make consumption succeed **without** Azure, so feed evidence requires a fresh local cache and a successful remote resolution. SNAPSHOT updates may need `-U`.

## Demonstration — you perform the steps

1. Read `consumer/pom.xml` and `consumer/src/main/java/org/example/consumer/App.java`. Find `taskManagerVersion`, the `azure-artifacts` profile, and the use of the library API.
2. Inspect the authorized publishing run's **Consume package using an isolated Maven cache** step. Its cache differs from the publisher's cache, and its console application exercises the library. This is valid agent consumption evidence, not proof your local Reader identity works.
3. For local Reader evidence, use Connect to feed → Maven and your organization's approved credential process. The course-root `settings.xml` is a **credential-free template** using `${env.AZURE_ARTIFACTS_TOKEN}` with default server ID `training-feed`; local commands below select it with `-s settings.xml`.
   - If this authentication method is approved, privately supply a short-lived read-only token in `AZURE_ARTIFACTS_TOKEN` through the organization's secret-entry process. Never put the token in source, a saved shell command/history, Chat, or a screenshot. Do not replace the template expression with the credential.
   - The template's server ID must match the actual feed and the `-DartifactFeedId` value. For a renamed feed, edit **only its non-secret server ID** to match, leaving the token expression intact.
   - If policy requires a credential provider or user Maven settings instead, keep those credentials **outside the repository**, normally under `~/.m2/settings.xml`, preserve existing entries, and omit `-s settings.xml` from the command so Maven uses the approved user settings.
   - Do not display effective settings, expose credentials, or upload generated settings as a pipeline artifact. Pipeline `MavenAuthenticate` uses the job identity independently and never reads this local template.
4. Set the **non-secret** feed URL in the current terminal. Replace the placeholders. For Bash:

```sh
export AZURE_ARTIFACTS_URL='https://pkgs.dev.azure.com/ORGANIZATION/PROJECT/_packaging/FEED/maven/v1'
```

For PowerShell:

```powershell
$env:AZURE_ARTIFACTS_URL = 'https://pkgs.dev.azure.com/ORGANIZATION/PROJECT/_packaging/FEED/maven/v1'
```

5. From the course root, choose a **new, nonexistent** cache directory for each proof, e.g. `consumer/target/feed-cache-01`. Substitute your feed's actual ID for `training-feed`:

```sh
mvn -B -U -s settings.xml -f consumer/pom.xml verify -Pazure-artifacts -DartifactFeedId=training-feed -Dmaven.repo.local=consumer/target/feed-cache-01
```

This command explicitly uses the course's environment-based template, as in `PIPELINES.md`. Approve the external feed connection before running it. On repeat, use `feed-cache-02`, not the populated cache. Do not run producer `install` into the proof cache.

6. Verify the log shows the task-manager dependency fetched from the expected feed URL. Find its JAR/POM under `consumer/target/feed-cache-01/org/example/training/task-manager/1.0.0-SNAPSHOT/`.
7. Run the consumer with that exact JAR. Bash/macOS/Linux:

```sh
java -cp "consumer/target/classes:consumer/target/feed-cache-01/org/example/training/task-manager/1.0.0-SNAPSHOT/task-manager-1.0.0-SNAPSHOT.jar" org.example.consumer.App
```

PowerShell/Windows (classpath separator is `;`):

```powershell
java -cp "consumer/target/classes;consumer/target/feed-cache-01/org/example/training/task-manager/1.0.0-SNAPSHOT/task-manager-1.0.0-SNAPSHOT.jar" org.example.consumer.App
```

The consumer's Maven `verify` builds it; it does not have a unit-test suite. Actual execution is a separate observation. To run it from VS Code instead, repeat the authenticated Maven command **without** `-Dmaven.repo.local` to populate the IDE's default cache from the feed, then reload its Maven project. An IDE run from that populated cache alone is not remote-resolution evidence.

## Learner action — safeguard audit

With the instructor, inspect branch protection, linked work items, PR validation, environment approvals, queue/edit permissions, and feed roles. A `main` condition plus false parameter prevents accidents, **not malicious YAML changes**. Environment approval controls the deployment job, not direct token misuse from another authorized job. The same project build identity may be exploitable by other jobs if granted Publisher access. For untrusted contributors/production, use separately protected publishing pipelines/projects/identities and centrally enforced permissions/templates. This sandbox does not claim that architecture.

Reader/publisher restrictions should be verified through role inspection and instructor-authorized harmless probes in the isolated sandbox, not unauthorized publication attempts. Denied-access live probes require consent and instructor design.

After the lab, clear the privately supplied token from the shell environment and revoke temporary credentials through the approved process. Do not delete shared user Maven settings or feeds.

## STOP checkpoint

Show the fresh-cache remote resolution, consumer output, coordinates, and which identity consumed. Supply a sanitized safeguard matrix distinguishing configured controls, observed enforcement, and pending instructor checks. **STOP: no claims of permission isolation without evidence.**

## Recovery

- Cached success: use a new cache path; `-U` alone does not prove the package came from Azure.
- 401/403: check Reader rights, user settings server ID, and approved authentication.
- Package missing: verify producer coordinate/version, URL, snapshot enablement, and the successful publish run.
- Class not found: inspect the exact JAR path and OS classpath separator.
- Local authentication disallowed: use the authorized agent proof and label local Reader validation pending.
- Secret exposed: stop, revoke/rotate with instructor help, and sanitize evidence. Never rely on Git ignore as credential protection.

## Independent challenge and completion criteria

Complete [exercise 17](../exercises/17-consume-safeguards.md). Explain cache false positives, mutable SNAPSHOT risks, and the limitations of this sandbox's publishing guards. Finish when real feed-backed consumption and honest access-control evidence are documented.

## Next module

[18 · Capstone](18-capstone.md).
