# Exercise 03 · Map the delivery services

**Prerequisite:** [lesson 03](../lessons/03-azure-orientation.md)'s sandbox, approved import or instructor-preseeded baseline, and learner-performed clone into a new sibling directory.

## Your task

1. In Azure, find your organization, project, and learner repository.
2. Locate the baseline commit and `starter/pom.xml` in Repos.
3. Find Boards Work Items, Pipelines, and Artifacts without creating resources.
4. In the **cloned training root**, run `git rev-parse --show-toplevel`, `git remote -v`, `git branch --show-current`, and `git log -1 --oneline`; compare with Azure.
5. Make a four-row note outside Git: requirement → service, source/review → service, automated tests → service, Maven package → service.
6. Run `mvn -B verify` in the clone's `starter/`, record the baseline summary, and return to a terminal at the cloned training root for later lessons.

**Independent challenge:** explain what `git clone` downloaded that `git remote add` did not, and why the sibling destination avoids a nested repository. Identify an administrative action you cannot perform and who can authorize it. Do not attempt privilege escalation.

## STOP and evidence

Provide the sanitized remote, new clone path, matching main commit, root file listing, actual cloned-baseline test summary, service map, and sandbox confirmation.

## Recovery

If the remote/project differs, stop before pushing again and follow lesson 03's identity/repository checks.

## Completion criteria

- [ ] Local baseline matches the correct Azure repository.
- [ ] You performed a clone into a new sibling directory and will use it for the remaining course.
- [ ] The clone's baseline verifies, and its local commit identity is configured.
- [ ] Course contents are at Azure repo root.
- [ ] You distinguish learner rights from instructor provisioning.
- [ ] Missing access is labeled pending, not simulated.

Next: [lesson 04](../lessons/04-boards.md).
