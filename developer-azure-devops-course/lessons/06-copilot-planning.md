# 06 · Ask for a plan, not an autopilot

## Prerequisites

Lesson 2's code understanding and lesson 5's feature branch/work item. Offline practice can use an unsaved local version of the same acceptance criteria, but Azure evidence remains pending.

## Explanation

Useful assistant context includes the actual contract, relevant source, constraints, and a bounded request. A plan lets you detect misunderstandings before code changes. Model output can be wrong about Java, APIs, and Azure integrations.

## Demonstration — you perform the steps

1. Open `TaskService.java`, `Task.java`, the existing tests, and the work-item criteria. Attach these files in Chat; verify that the attachments name the intended files.
2. Ask:

> Read these files and the duplicate-title acceptance criteria. Propose a small implementation and test plan; do not edit files or run tools. Preserve Java 17, the public API, display casing, ID allocation, and immutable snapshots. Duplicates remain forbidden after completion. No new dependencies. Identify uncertainties and cite the existing code you rely on.

3. Compare the response with the files. A suitable plan validates null/blank first, trims once, checks existing titles case-insensitively **before** allocating an ID or mutating state, and then adds the task. You will write the code yourself later.
4. Ask one follow-up:

> What could go wrong if validation increments the ID before rejecting a duplicate? Suggest a test scenario, not a complete test implementation.

5. Keep your own short plan outside Git or in the work item's planning text with explicit consent. Do not accept a proposal that rewrites the service or adds unrelated tools.

## Learner action

Rewrite the plan in your own words as three implementation steps and a test matrix. Include one risk the assistant missed or explain how you verified its answer.

## STOP checkpoint

Supply your reviewed plan, the bounded prompt, and evidence that no source edits occurred (`git diff --stat`). State at least one suggestion you checked against source. **STOP: no automatic transition to implementation.**

## Recovery

- Chat edits files unexpectedly: stop it, inspect each diff, and undo only its unintended changes through the editor after preserving your own work.
- Missing file context: attach/open files manually; do not assume workspace-wide access.
- Confident but incorrect response: point to the contract and request a revised explanation. Keep responsibility for the decision.
- Copilot unavailable: make the same plan manually, label the assistant step unavailable, and retain the learning evidence.

## Independent challenge and completion criteria

Complete [exercise 06](../exercises/06-copilot-planning.md). Create a bounded debugging prompt that reveals no credentials and cannot authorize external changes. Finish when you can explain and defend your own plan.

## Next module

[07 · Instructions and skills](07-instructions-skills.md).
