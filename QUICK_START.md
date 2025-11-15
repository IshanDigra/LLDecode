# LLDecode - Quick Start Guide

## TL;DR - Get Running in 5 Minutes

### Prerequisites
- Java 11+ installed
- Maven 3.6+ installed
- IntelliJ IDEA installed

### Steps

1. **Clone and Open**
   ```bash
   git clone https://github.com/IshanDigra/LLDecode.git
   ```
   - Open the folder in IntelliJ IDEA

2. **IntelliJ Auto-Setup**
   - Wait for IntelliJ to detect `pom.xml`
   - Right-click `pom.xml` → **Maven** → **Reload Project**
   - Wait for Maven to download dependencies

3. **Run the Demo**
   - Open: `src/main/java/problems/lld/beginner/taskmanagement/v1/Demo.java`
   - Click the **green play button** (▶) next to `public class Demo`
   - View output in the Run tab at the bottom

---

## What Was Done?

Your repository has been converted to a **runnable Maven Java project**:

- ✅ **Maven Configuration** (`pom.xml`) - Build and dependency management
- ✅ **Proper Package Structure** - `src/main/java/` with organized packages
- ✅ **Refactored Java Files** - All Java files moved and updated with correct imports
- ✅ **IntelliJ Compatible** - Can open and run directly in your IDE
- ✅ **Setup Documentation** - Complete setup guides included

---

## Project Structure Overview

```
src/main/java/
└── problems/lld/beginner/taskmanagement/v1/
    ├── Demo.java                    ← RUN THIS
    ├── enums/
    │   ├── TaskPriority.java
    │   └── TaskStatus.java
    └── model/
        ├── Task.java
        ├── User.java
        ├── TaskManager.java
        ├── ReminderService.java
        └── ReminderServiceAdvance.java
```

---

## Available Commands

### Via IntelliJ GUI
- **Run**: Click green play button on any class with `main()` method
- **Debug**: Click green debug button (bug icon)
- **Build**: IntelliJ automatically compiles on save

### Via Terminal

```bash
# Build project
mvn clean install

# Run the demo
mvn exec:java

# Run with specific main class
mvn exec:java -Dexec.mainClass="problems.lld.beginner.taskmanagement.v1.Demo"

# Quick compile
mvn compile
```

---

## What Can You Do Now?

1. **Run Tasks** - Execute `Demo.java` to test the Task Management System
2. **Add More Problems** - Create new packages for other LLD problems
3. **Write Tests** - Add JUnit tests in `src/test/java/`
4. **Debug Code** - Use IntelliJ's debugging tools
5. **Build JAR** - Create executable JAR with `mvn package`

---

## Common Tasks

### Add a New LLD Problem

1. Create package: `src/main/java/problems/lld/beginner/yourproblem/v1/`
2. Add your solution classes
3. Create `Demo.java` with `main()` method
4. Click green play button to run

### Run Multiple Main Classes

In IntelliJ:
1. Go to `Run` → `Edit Configurations`
2. Click `+` to add new configuration
3. Select `Application`
4. Set Main class
5. Click Run

### Create an Executable JAR

```bash
mvn clean package
cd target
java -jar lldecode-1.0-SNAPSHOT.jar
```

---

## Need Help?

Refer to **SETUP_GUIDE.md** for:
- Detailed installation instructions
- Troubleshooting common issues
- IDE configuration tips
- Advanced Maven commands

---

**You're all set! Start running and testing your LLD problems! 🚀**
