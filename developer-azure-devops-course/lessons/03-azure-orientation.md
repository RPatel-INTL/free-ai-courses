# 03 · Find your Azure sandbox

## Prerequisites

Lessons 1–2; an instructor-approved Azure DevOps organization/project and either an empty Azure Repos Git repository you may import into, or an instructor-preseeded repository containing the approved baseline. Initial import may require instructor assistance before branch protection is enabled.

## Explanation

An organization contains projects. A project can contain Boards, Repos, Pipelines, and Artifacts. These services connect planning to source, builds, and packages. You do **not** need an Azure cloud deployment for this console application.

`git remote add` connects an existing local repository to a remote; it does not download another working copy. `git clone` downloads the repository history, creates a working directory, and configures `origin`. You will clone the imported baseline and use **that clone for all later lessons**.

## Demonstration — you perform the steps

1. Sign in to your approved Azure DevOps organization in a browser. Open the dedicated training project. Confirm its identity with the instructor before changing anything.
2. Find **Boards → Work Items**, **Repos → Files**, **Pipelines**, and **Artifacts**. If a service is disabled or missing, ask the instructor to check access—not your personal production account.
3. Under Repos → Files, select your learner repository. Copy its HTTPS clone URL, without embedding credentials. An example shape is:

```text
https://dev.azure.com/ORGANIZATION/PROJECT/_git/REPOSITORY
```

If the instructor has already populated this repository with the verified course baseline, inspect its root files and commit with them, then **skip the import in steps 4–5** and go directly to step 6. Do not push your independently initialized history over a preseeded repository.

4. For an **empty** repository, in a terminal at the local course root:

```sh
git status --short
git branch --show-current
git remote -v
```

If no remote exists, replace the example with your actual sandbox URL:

```sh
git remote add origin https://dev.azure.com/ORGANIZATION/PROJECT/_git/REPOSITORY
git remote -v
```

**Consent gate:** confirm the repository and initial push with your instructor. Then you—not the tutor—run:

```sh
git push -u origin main
```

Use the approved Git credential manager/browser sign-in. Never put a PAT in the remote URL.

5. Refresh Azure Repos → Files and inspect `starter/pom.xml`. Repository root must also contain `azure-pipelines.yml`, `consumer/`, and the course docs.

6. **Consent gate:** approve reading the sandbox repository to create a new local clone. From your original independent course root, replace the URL with the approved URL:

```sh
git clone --branch main https://dev.azure.com/ORGANIZATION/PROJECT/_git/REPOSITORY ../azure-training-clone
```

`../azure-training-clone` is a **new, nonexistent sibling directory**, not a directory inside your current course root. If that sibling name already exists, choose a different new name; do not overwrite or delete it. Never clone into `starter/`, the course root, or the upstream source checkout.

7. In VS Code choose File → Open Folder and open the new `azure-training-clone` folder. Open a **new terminal there**, then check:

```sh
git rev-parse --show-toplevel
git remote -v
git branch --show-current
git log -1 --oneline
git status --short
git config user.name "Your Name"
git config user.email "your-approved-email@example.com"
```

Use your approved real identity. A clone does not inherit the original repository's local identity settings. Confirm root path is the new clone, branch is `main`, and its commit matches Azure.

8. Verify the untouched baseline in the clone:

```sh
cd starter
mvn -B verify
```

Inspect the actual summary. Open a new terminal at the **cloned training root** afterward. Keep using this clone for Boards-linked branches, commits, PRs, CI configuration, and the remaining lessons; leave the original import copy alone. Resume Chat by attaching the cloned root's instructor/config/selected lesson files.

## Learner action

Explain which service will hold your feature request, code review, test run, and reusable JAR. Check your access level and note which administrative actions require the instructor. Explain how clone differs from adding a remote and point to the clone you will use next.

## STOP checkpoint

Show the sanitized remote URL, Azure repository file listing, and initial commit in the UI. Also supply the **new clone's** root path, matching commit/main branch, clean tracked-file status, and actual baseline verification summary. Name the organization/project/repository and confirm it is a sandbox. **STOP: neither import nor clone success may be inferred.**

## Recovery

- Remote already exists: inspect it first; use `git remote set-url origin ...` only after confirming it is your independent learner repo.
- Unexpected remote commits: do not force push or combine unrelated histories. Have the instructor verify a preseeded baseline for cloning or provide an empty repo for the import path.
- Clone destination exists: choose a new nonexistent sibling directory; do not remove the existing folder.
- Clone has the wrong content/branch: confirm the selected Azure repo and approved baseline before working. Do not import over it.
- Verification fails only in the clone: check Maven's JDK, network access, and cloned source/commit. Local generated files from the import copy do not travel through Git.
- 401/403: distinguish sign-in failure from missing repository permission; use approved identity support.
- Push blocked by policy: ask the instructor to import the baseline under the approved setup procedure. Do not bypass policy yourself.
- No Azure access: leave external work pending. Local practice is possible but cannot satisfy this checkpoint.

## Independent challenge and completion criteria

Complete [exercise 03](../exercises/03-azure-orientation.md). Find all four services without hints and explain the boundary between your learner rights and administrator rights. Finish when the approved baseline is visible in Azure and your independently cloned training root verifies.

## Next module

[04 · Boards work items](04-boards.md).
