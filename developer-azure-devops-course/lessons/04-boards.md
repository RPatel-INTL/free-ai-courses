# 04 · Turn a request into acceptance criteria

## Prerequisites

Lesson 3's approved project/repository and permission to create a work item.

## Explanation

A work item captures the user need and how you will prove it is met. Azure processes differ: choose User Story (Agile), Product Backlog Item (Scrum), Issue (Basic), or the instructor-approved Task type. Field names and state names vary.

## Demonstration — you perform the steps

**Consent gate:** agree that you will create one training work item.

1. Open Boards → Work Items → New Work Item. Use title **Prevent duplicate task titles**.
2. Describe the problem: accidentally adding the same task twice clutters the list.
3. Enter these acceptance criteria in the appropriate field or description:
   - `add("Review PR")` stores `"Review PR"`.
   - A later `add(" review pr ")` throws `IllegalArgumentException`.
   - Exact, mixed-case, and outer-whitespace duplicates are rejected.
   - Completing the first task does not permit reuse of its title.
   - A rejected addition neither changes the list nor consumes the next ID.
   - Null/blank rejection, trimming, completion, missing-ID exceptions, and immutable snapshots still work.
4. Assign it to yourself when allowed and choose the sandbox area/iteration. Save and record the numeric ID, for example **123**. Throughout the course, replace `123` with **your own ID**.
5. Inspect state choices. Move it to the process's active/in-progress state only when you actually begin work.

## Learner action

Identify two negative cases and one successful distinct-title case. Explain that the contract compares trimmed titles case-insensitively without changing stored display casing. Do not invent accent folding or Unicode normalization requirements.

## STOP checkpoint

Provide the saved item's number, type/state, and acceptance criteria (sanitized screenshot or copied field text). Explain how a test could prove that a duplicate rejection did not consume an ID. **STOP: tutor waits before planning implementation.**

## Recovery

- No Acceptance Criteria field: use a clearly labeled section in Description.
- Save denied: check permissions and required fields with the instructor.
- Wrong project: do not leave active work in another project; ask the owner for an approved correction.
- Criteria ambiguous: clarify examples now, not after code review.

## Independent challenge and completion criteria

Complete [exercise 04](../exercises/04-boards.md). Write your own positive/negative examples and an explicit out-of-scope list. Finish when another person can tell whether the feature is complete from the work item alone.

## Next module

[05 · Feature branches](05-feature-branches.md).
