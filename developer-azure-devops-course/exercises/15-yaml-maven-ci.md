# Exercise 15 · Prove policy failure and recovery

**Prerequisite:** [lesson 15](../lessons/15-yaml-maven-ci.md)'s approved pipeline/policy/probe PR. Real Azure access is required.

## Your task

1. Record the baseline CI run/commit, Tests summary, and `task-manager-jar` listing.
2. Record the instructor-configured Automatic/Required build validation and human-review policies.
3. Trace the deliberately failing assertion from local Maven to the probe PR's failed validation run and Tests view.
4. Confirm normal PR completion is blocked. Do not choose bypass.
5. After removal of the probe and a consented push, inspect the **latest** required green validation.
6. Verify Publish skipped throughout, then abandon the no-net-change probe PR with consent.

**Independent challenge:** explain how stale validation could mislead a reviewer after `main` changes and which policy expiration setting the lab uses.

## STOP and evidence

Supply run numbers/commits, failure name, blocked completion, corrected green policy result, skipped Publish, and abandoned probe PR.

## Recovery

If the PR has no check, inspect its target branch's policy rather than adding YAML `pr:`. Agent entitlement problems require instructor provisioning.

## Completion criteria

- [ ] Real CI produces tests and a successful-run JAR artifact.
- [ ] Real failure blocks normal PR completion.
- [ ] Correction triggers fresh required validation.
- [ ] Publishing remains disabled and the temporary probe is not merged.

If external evidence is missing, status is **pending**, not passed.

Next: [lesson 16](../lessons/16-artifacts-publish.md).
