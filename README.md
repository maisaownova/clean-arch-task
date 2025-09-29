# Clean Architecture Task Management (Progress Log)

This project is my coding exercise from a job interview.  
The goal was to implement a small task management domain using **Clean Architecture** principles, focusing on clean, testable code.

---

## My Progress

### 1. Setting up the project
- Cloned the starter repository.
- Faced several issues with Gradle on Windows (e.g. `Could not find or load main class org.gradle.wrapper.GradleWrapperMain`).
- Resolved them by:
  - Moving the project to a folder without diacritics in the path.
  - Regenerating the Gradle wrapper.
  - Downgrading from Gradle 9.1 to 8.10.2 (more stable with JUnit 5 and Java 17).
- Finally achieved a successful build and working test environment.

### 2. Understanding the structure
- **Entities**: pure domain models (`Task`).
- **Application**: abstract contract (`TaskRepository`).
- **Use Cases**: application-specific business logic (`CreateTask`, `UpdateTaskTitle`, etc.).
- **Infrastructure**: concrete repository (`InMemoryTaskRepository`).
- **Tests**: JUnit 5 tests verifying each use case.

### 3. Implementing use cases
- **CreateTask**: creates a task and saves it.
- **UpdateTaskTitle**: changes a task’s title, validates non-empty input.
- **ToggleTaskCompletion**: flips completion flag (done ↔ not done).
- **ListAllTasks**: returns all tasks from the repository.
- **DeleteTask**: removes a task, throws if it doesn’t exist.

Each use case was implemented with **tests first** (TDD style), covering both success and failure scenarios.

### 4. Refining the code
- Unified naming conventions (`repo`, `usecase`, `updated`).
- Chose meaningful but concise test data (e.g. "Prepare monthly report" instead of "Do homework").
- Removed unnecessary comments, relied on expressive code and test names.
- Ensured consistency across all tests and use cases.

## 5. Key Takeaways
- Learned how Clean Architecture separates **entities**, **use cases**, **interfaces**, and **infrastructure**.  
- Got practical experience with **Gradle**, **JUnit 5**, and troubleshooting build issues.  
- Improved naming and consistency to write **clean, professional, testable code**.  
- Delivered a fully working solution with **complete test coverage**.  

---


```bash
./gradlew test
