# 16 · Publish an approved Maven package

## Prerequisites

Lesson 15's enforced validation, trusted reviewed `main`, an instructor-provisioned **same-project** sandbox Maven feed, and approved publishing permissions. Read [PIPELINES.md](../PIPELINES.md).

Instructor requirements: create the `training-packages` environment **before** running publication; configure independent approval checks and restricted pipeline permissions; identify the actual project build identity. Give learners Reader access and the build identity minimum Feed Publisher (Contributor) access. Organization-wide or cross-project publishing is outside this default lab.

## Explanation

Maven publication uploads a POM, JAR, and version metadata to a feed. The coordinate is `org.example.training:task-manager:1.0.0-SNAPSHOT`. `SNAPSHOT` supports development updates, not immutable releases. A run's JAR artifact is separate evidence.

`MavenAuthenticate@0` writes agent-user Maven credentials for the job identity. It does **not** use this repo's local `settings.xml`. Never print/generated-upload those settings.

The protected environment controls entry to this deployment job; it does **not** prevent an arbitrary authorized pipeline script from attempting to use the same publisher-capable build token. Production or untrusted-code publishing needs the separately protected project/pipeline/identity design in `PIPELINES.md`, not just this environment and YAML condition.

## Demonstration — you perform the steps

1. In Artifacts select the approved feed → **Connect to feed → Maven**. Record the non-secret HTTPS URL:

```text
https://pkgs.dev.azure.com/ORGANIZATION/PROJECT/_packaging/FEED/maven/v1
```

Use the UI's exact URL, including encoded project names when present.

2. Read the YAML parameters:
   - `publishPackage`: false by default.
   - `feedName`: default `training-feed`; supply your provisioned feed name.
   - `feedUrl`: placeholder; replace at queue time with the exact approved URL.
3. Read the starter's `azure-artifacts` Maven profile. It uses `${env.AZURE_ARTIFACTS_URL}` and `${artifactFeedId}` for release/snapshot destinations. The pipeline sets `AZURE_ARTIFACTS_URL` from `feedUrl` and passes `-DartifactFeedId` from `feedName`.
4. Verify `MavenAuthenticate`'s `artifactsFeeds` parameter matches that same feed/server ID. A matching URL alone is insufficient if the authentication ID differs.
   - Pipeline authentication uses the selected `feedName` and `-DartifactFeedId`; no local template change is needed for that run.
   - For later **local** template use, `settings.xml`'s literal server ID starts as `training-feed`. If the actual feed name differs, change only that non-secret ID to match the local `-DartifactFeedId` value, or configure a matching server in approved user settings. Never replace the environment-token expression with a credential.
5. **STOP checkpoint A:** show URL/name/ID consistency, a sanitized role review, the protected environment, and the trusted-main validation evidence. The tutor waits. No tokens should appear.

**Consent gate:** instructor approves **one** publication and its storage/use consequences.

6. In Pipelines → your pipeline → Run pipeline, choose **branch `main`**, set `publishPackage` true, and supply `feedName`/`feedUrl`. Review the selected commit. Queue only this authorized run.
7. Validate must succeed; Publish should wait for the `training-packages` environment's configured independent approval. The instructor/authorized approver—not the learner acting as their own reviewer—approves.
8. Inspect `MavenAuthenticate`, `clean deploy -Pazure-artifacts`, and the feed package/version listing. The pipeline also builds/runs the consumer with an isolated cache; lesson 17 explains that evidence.
9. Confirm a separate ordinary default/feature/PR validation run skips Publish. Do not “test” safeguards by granting broader permissions.

## Learner action

Trace feedName → Maven server ID → artifactFeedId and feedUrl → environment variable → Maven destination. Explain why a Reader should consume but not publish.

## STOP checkpoint B

Supply publishing run number/branch/commit, approval evidence, actual feed coordinate/version and timestamped metadata, and a validation-only run with skipped Publish. **STOP: a downloaded pipeline artifact is not proof of Maven publication.**

## Recovery

- 401: verify identity, authentication task execution, and matching server/feed ID.
- 403: instructor checks the actual build-service identity's minimum feed role/project scope. Do not grant collection-wide rights to “make it work.”
- Placeholder URL rejected: use Connect to feed; never disable the URL validation.
- Waiting approval/environment missing: instructor configures the intended protected resource, not a replacement unprotected environment.
- Version collision: use isolated learner feeds or an approved version plan. Do not delete shared packages; release versions require a new version and matching JAR path.
- No authorized Azure access: keep publication pending. Local `install` is not a substitute.

## Independent challenge and completion criteria

Complete [exercise 16](../exercises/16-artifacts-publish.md). Explain how you distinguish pipeline artifacts from Maven packages and which identity performed each action. Finish only after actual authorized publication evidence, otherwise record it as pending.

## Next module

[17 · Consume and safeguard](17-consume-safeguards.md).
