# LLDecode - Java Project Setup Guide

This guide will help you set up and run the LLDecode project locally in IntelliJ IDEA.

## Prerequisites

- **Java 11+** installed on your system
- **Maven 3.6+** installed on your system
- **IntelliJ IDEA** (Community or Ultimate Edition)
- **Git** installed on your system

## Installation Steps

### 1. Clone the Repository

```bash
git clone https://github.com/IshanDigra/LLDecode.git
cd LLDecode
```

### 2. Open in IntelliJ IDEA

#### Option A: Using File Menu
1. Open IntelliJ IDEA
2. Click **File** → **Open**
3. Navigate to the cloned `LLDecode` folder
4. Click **Open**
5. When prompted, select "Open as Project" (not "Attach")
6. IntelliJ will detect the `pom.xml` and configure it as a Maven project

#### Option B: From Command Line
```bash
idea LLDecode
```

### 3. Configure Maven in IntelliJ (if needed)

1. Go to **IntelliJ IDEA** → **Preferences** (macOS) or **File** → **Settings** (Windows/Linux)
2. Navigate to **Build, Execution, Deployment** → **Build Tools** → **Maven**
3. Verify Maven home path is set correctly
4. Click **Apply** and **OK**

### 4. Load Maven Dependencies

1. Right-click on `pom.xml` in the project root
2. Select **Maven** → **Reload Project**
3. Wait for IntelliJ to download and index all dependencies

You should see a message: "Downloading sources and javadoc..."

## Project Structure

```
LLDecode/
├── src/
│   └── main/
│       └── java/
│           └── problems/
│               └── lld/
│                   └── beginner/
│                       └── taskmanagement/
│                           └── v1/
│                               ├── Demo.java              (Main entry point)
│                               ├── enums/
│                               │   ├── TaskPriority.java
│                               │   └── TaskStatus.java
│                               └── model/
│                                   ├── Task.java
│                                   ├── User.java
│                                   ├── TaskManager.java
│                                   ├── ReminderService.java
│                                   └── ReminderServiceAdvance.java
├── pom.xml                     (Maven configuration)
├── .gitignore                  (Git ignore file)
└── README.md                   (Project documentation)
```

## Running the Project

### Option 1: Using IntelliJ's Run Button (Easiest)

1. Open `src/main/java/problems/lld/beginner/taskmanagement/v1/Demo.java`
2. Click the **green play button** (▶) at the top-right of the editor, next to the class name
3. Select **Run 'Demo.main()'**
4. View output in the **Run** panel at the bottom

### Option 2: Using Right-Click Context Menu

1. Right-click on `Demo.java`
2. Select **Run 'Demo.main()'**

### Option 3: Using Maven Command

Open a terminal in the project root directory:

```bash
mvn clean compile exec:java
```

### Option 4: Using Debug Mode

1. Open `Demo.java`
2. Set breakpoints by clicking on the left margin next to the line numbers
3. Click the **green debug button** (bug icon) at the top-right
4. Step through code using debug controls

## Expected Output

When you run `Demo.java`, you should see output similar to:

```
New task has been created by Ishan
New task has been created by Ishan
New task has been created by Pallav
New task has been assigned to Pallav by Ishan
New task has been assigned to Pallav by Ishan
New task has been assigned to Ishan by Pallav

=== All Tasks ===
[Task{title='Movie Plan', description='Planning about a movie', ..., status=ACTIVE}]
...

=== Search Results for 'planning' ===
[...]

=== Filter Tasks (MEDIUM priority, assigned to user1) ===
[...]

=== Tasks after deletion ===
[...]
```

## Building the Project

### Full Build

```bash
mvn clean install
```

This will:
- Clean previous build artifacts
- Compile source code
- Run tests (if any)
- Create a JAR file in `target/` directory

### Quick Compile

```bash
mvn compile
```

### Create Executable JAR

```bash
mvn package
```

The JAR will be created in `target/lldecode-1.0-SNAPSHOT.jar`

## Running Individual Classes

To run a specific class from the command line:

```bash
mvn exec:java -Dexec.mainClass="problems.lld.beginner.taskmanagement.v1.Demo"
```

## Troubleshooting

### Issue: "No main manifest attribute" error

**Solution:** Use the Maven exec plugin (as shown above) instead of running JAR directly.

### Issue: "Project SDK is not defined"

1. Go to **File** → **Project Structure**
2. Click **SDK** on the left panel
3. Select or download Java 11+
4. Click **Apply** and **OK**

### Issue: Maven dependencies not downloading

1. Go to **IntelliJ IDEA** → **Preferences** → **Build Tools** → **Maven**
2. Click **Update** next to Maven home path
3. Right-click `pom.xml` → **Maven** → **Reload Project**

### Issue: Cannot find package errors

1. Right-click on `pom.xml`
2. Select **Maven** → **Reload Project**
3. Wait for indexing to complete

## Adding New Problem Solutions

1. Create a new package under `src/main/java/problems/lld/` following the naming convention
2. Implement your solution classes
3. Create a `Demo.java` main class to test your implementation
4. Run the Demo class to verify

### Example: Adding a new problem

```java
// Package path: src/main/java/problems/lld/beginner/parkingsystem/v1/
package problems.lld.beginner.parkingsystem.v1;

public class Demo {
    public static void main(String[] args) {
        // Your test code here
    }
}
```

## IDE Shortcuts

| Action | macOS | Windows/Linux |
|--------|-------|---------------|
| Run | Ctrl+R | Shift+F10 |
| Debug | Ctrl+D | Shift+F9 |
| Build | Cmd+B | Ctrl+F9 |
| Format Code | Cmd+Option+L | Ctrl+Alt+L |
| Refactor/Rename | Shift+F6 | Shift+F6 |
| Find | Cmd+F | Ctrl+F |
| Find in Project | Cmd+Shift+F | Ctrl+Shift+F |

## Next Steps

1. Explore the existing `TaskManagementSystem` implementation
2. Understand the package structure and naming conventions
3. Add more LLD problems following the same structure
4. Write unit tests in `src/test/java/`
5. Document your solutions with clear comments

## Resources

- [Maven Documentation](https://maven.apache.org/)
- [IntelliJ IDEA Documentation](https://www.jetbrains.com/help/idea/)
- [Java Documentation](https://docs.oracle.com/en/java/)

## Contributing

Feel free to add more problems and solutions! Follow the existing package structure and naming conventions.

---

**Happy Coding! 🚀**
