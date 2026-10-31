# Exercise 16 · Follow the package identity

**Prerequisite:** [lesson 16](../lessons/16-artifacts-publish.md)'s approved feed, protected environment, and trusted-main publication.

## Your task

1. Compare feed name/URL from Connect to feed with the queued `feedName`/`feedUrl`.
2. Trace the server ID from `MavenAuthenticate` to `-DartifactFeedId` and the Maven publishing profile.
3. Record selected main commit, Validate result, approval wait/decision, and actual deployment result.
4. Find `org.example.training:task-manager:1.0.0-SNAPSHOT` in the feed. Inspect version details/POM metadata and actual publication time.
5. Compare that package evidence with the separate `task-manager-jar` pipeline artifact.
6. Confirm ordinary default/feature/PR runs skip Publish.

**Independent challenge:** explain why changing a feed URL without changing the matching authentication ID can fail. Explain why repeating a release version is not the same as a SNAPSHOT update.

## STOP and evidence

Supply sanitized parameter/ID mapping, actual run/approval/package evidence, and a skipped-publishing example. Never share tokens or generated settings.

## Recovery

Follow lesson 16's 401/403, placeholder, and version-collision checks. Do not grant broad roles or delete shared packages.

## Completion criteria

- [ ] Authorized trusted-main publication actually occurred.
- [ ] Package coordinate/POM/metadata are visible in the intended feed.
- [ ] Publisher identity and independent approval are identified.
- [ ] Accident guards are observed without claiming malicious-edit isolation.

Without live evidence, publication validation remains **pending**.

Next: [lesson 17](../lessons/17-consume-safeguards.md).
