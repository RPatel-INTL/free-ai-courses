# 14 · Understand CI before configuring it

## Prerequisites

Lesson 13, access to the supplied root YAML and [PIPELINES.md](../PIPELINES.md), and instructor information about Azure agent availability.

## Explanation

CI runs repeatable checks on a clean agent. A pipeline has stages, jobs, and steps. A trigger decides when branch CI starts. A branch policy decides whether a PR can merge. Test results make failures inspectable. A run-associated pipeline artifact is not a Maven feed package.

This course's YAML already includes validation and **disabled-by-default** publication. You will inspect it, establish real validation, then separately approve publication.

## Demonstration — you perform the steps

1. Open `azure-pipelines.yml` at the course root. Locate:
   - `trigger`: `main` and `feature/*` branch pushes.
   - `Validate` stage → `MavenCI` job → checkout, Java 17, Maven verify.
   - `PublishTestResults@2` using `starter/target/surefire-reports/TEST-*.xml` and `succeededOrFailed()`.
   - `PublishPipelineArtifact@1` saving `task-manager-jar`.
   - `Publish` stage depending on validation, with `publishPackage` default **false**.
2. Translate the CI invocation to your local terminal:

```sh
cd starter
mvn -B verify
```

The agent invocation adds `-ntp`, `clean`, and `-f starter/pom.xml` because it starts at the repository root. `clean` removes previous generated output; `-ntp` reduces download progress noise.

3. Trace two events on paper:
   - A feature push: Validate should run; Publish should skip.
   - An Azure Repos PR update: required validation comes from `main`'s **Build validation branch policy**. No YAML `pr:` trigger is used.
4. Explain that `ubuntu-latest` is a Microsoft-hosted pool selection, not a guarantee your organization has an available parallel job. An approved self-hosted pool is a different instructor configuration.
5. Read the Publish condition: success, `refs/heads/main`, not `PullRequest`, and explicit true parameter. The environment's approvals/permissions are configured in Azure, not established by this YAML.

## Learner action

Map each output to its location: local `target/`, pipeline Tests view, pipeline artifact download, and Azure Artifacts feed (not yet populated).

## STOP checkpoint

Show your annotated pipeline flow, actual local verification summary, and predictions for feature push/PR/main publish. Explain why a publishing condition is an accident guard, not protection against malicious pipeline edits. **STOP: do not queue or enable publishing in this lesson.**

## Recovery

- YAML unfamiliar: use indentation to identify stage/job/step scope; consult the supplied file rather than rewriting it.
- Agent access unknown: ask the instructor to confirm pool entitlement and approved network access.
- Mistaking green local tests for CI: keep local and Azure evidence separately labeled.
- Missing publish approvals: leave publishing disabled until lesson 16's provisioning gate.

## Independent challenge and completion criteria

Complete [exercise 14](../exercises/14-pipeline-concepts.md). Predict what outputs remain after a failing Maven test and describe why downloading a pipeline JAR does not prove feed publication.

## Next module

[15 · YAML Maven CI](15-yaml-maven-ci.md).
