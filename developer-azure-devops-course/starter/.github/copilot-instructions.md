# Java training workspace

- Teach first: explain the proposed change and wait for the learner to approve implementation.
- Use Java 17 and Maven. Keep this application in memory, single-threaded, and dependency-light.
- Run `mvn -B verify` from `starter/`; never claim a test passed without reading its result.
- Preserve immutable `Task` records and snapshot results from `TaskService.list()`.
- Add JUnit tests for changed behavior, including invalid inputs and unchanged state after rejection.
- Do not implement later exercises ahead of the learner. Duplicate-title rejection is a lesson feature, not a starter defect to fix automatically.
- Keep edits limited to the approved Azure Boards acceptance criteria.
- Review generated diffs. Never commit credentials, publish packages, push branches, or create external resources without explicit learner approval.
- Azure Repos hosts this project's PRs; do not use GitHub PR commands or assume GitHub cloud-agent/review integration.
