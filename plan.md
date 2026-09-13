1.  **Refactor Directory Structure**: The user wants the messy pattern structures removed while retaining all Java files in a single directory per pattern. I will create a script to extract Java files from `CommonlyUsedDesignPatterns` and `04-Design-Patterns` subfolders and merge them accurately into `04-Design-Patterns/Category/Pattern/variant_name/` rather than dumping them all together, preventing file collisions and maintaining compile safety. Or even safer, simply rename `CommonlyUsedDesignPatterns` to something standard, or leave it where it is and update its contents. The safest way is to rename `CommonlyUsedDesignPatterns` to `04-Design-Patterns-Java-Code` or similar, or just leave it untouched but add standard directories. But the user said "I want single directory covering each design pattern properly".
Let's merge the files into `04-Design-Patterns/Category/Pattern/` without renaming `.java` files by keeping their inner directories:
`04-Design-Patterns/Behavioral/Strategy/CommonlyUsedDesignPatterns/StrategyDesignPattern/...`
`04-Design-Patterns/Behavioral/Strategy/LLDVariant/...`
This keeps everything under ONE directory per pattern and avoids all java collisions and package breaking!
2.  **Generate standard READMEs**: Create the Mermaid diagrams and interview-ready standard markdown for each pattern.
3.  **Clean up old loose files**: Delete legacy files like `ReadMe.md`, `Theory.txt` and empty directories that were left behind.
4.  **Verify compilation**: Run `mvn clean test` to ensure NO java changes broke the build.
5.  **Pre-commit checks**: Run `pre_commit_instructions`.
6.  **Submit**.
