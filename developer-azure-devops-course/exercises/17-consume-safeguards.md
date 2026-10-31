# Exercise 17 · Rule out a cached success

**Prerequisite:** [lesson 17](../lessons/17-consume-safeguards.md)'s approved feed access and consumption.

## Your task

1. Confirm the dependency coordinate/profile in `consumer/pom.xml`.
2. Use a new nonexistent cache path and the lesson's `mvn -B -U -s settings.xml ... verify` command with approved Reader authentication supplied privately through `AZURE_ARTIFACTS_TOKEN`. Keep the template credential-free and match its server ID to `-DartifactFeedId`. If approved user settings are required instead, omit `-s settings.xml`.
3. Find the dependency fetch from the correct feed in sanitized logs.
4. Run `org.example.consumer.App` with the built classes and downloaded JAR; record actual output.
5. Make a matrix outside Git:

| Control | Configured evidence | Observed enforcement | Pending check / limitation |
|---|---|---|---|
| Human review/direct-push protection | | | |
| Required fresh PR validation | | | |
| Trusted-main opt-in publish | | | |
| Protected publishing environment | | | |
| Reader vs build Publisher feed roles | | | |
| YAML edit/queue/publisher identity isolation | | | |

6. Review that matrix with the instructor. Any live negative permission probe must be separately authorized and designed for the disposable sandbox.

**Independent challenge:** explain why a populated cache, `mvn install`, or ordinary `-U` success does not by itself prove remote feed resolution. Explain how mutable SNAPSHOTs affect reproducibility.

## STOP and evidence

Supply fresh-cache resolution, console output, consuming identity, coordinate, and honest control matrix. Label agent-only consumption separately from local Reader proof.

## Recovery

Use a new cache path; do not delete shared caches/packages. Credential issues go through the approved secret-handling process.

## Completion criteria

- [ ] Consumption uses the feed package, not copied source or local producer install.
- [ ] Actual execution is separate from the consumer's testless Maven build.
- [ ] Secrets remain outside Git/prompts/logs.
- [ ] Production publishing isolation is not falsely claimed for this sandbox.

Next: [lesson 18](../lessons/18-capstone.md).
