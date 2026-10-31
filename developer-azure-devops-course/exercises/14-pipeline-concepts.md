# Exercise 14 · Predict before running

**Prerequisite:** [lesson 14](../lessons/14-pipeline-concepts.md)'s YAML walkthrough.

## Your task

1. Read the root YAML and sketch stage → job → step hierarchy.
2. Describe what each of these events should do:
   - Feature push with default parameters.
   - Azure Repos PR update with required build validation.
   - Trusted `main` run with publication false.
   - Approved trusted `main` run with publication true.
3. For a failing JUnit test, predict the Maven step, test-result step, JAR artifact step, PR policy, and Publish stage outcomes.
4. Locate the Java 17 choice, `starter/pom.xml` path, test XML glob, and artifact name.

**Independent challenge:** explain why an unavailable agent, a failing test, and an unauthorized feed publish require different recoveries.

## STOP and evidence

Show your event/outcome table and the YAML locations supporting it. Do not queue a publishing run.

## Recovery

Recheck indentation and policy/trigger distinctions. Read `PIPELINES.md` if the publishing environment's role is unclear.

## Completion criteria

- [ ] You distinguish trigger, validation, policy, authentication, and approval.
- [ ] You distinguish run artifacts from Maven feed packages.
- [ ] You understand why conditions are not a malicious-contributor security boundary.

Next: [lesson 15](../lessons/15-yaml-maven-ci.md).
