# ATP-PartB – Advanced Topics in Programming

🎓 This project is part of the "Advanced Topics in Programming" university course. It focuses on object-oriented design, search algorithms, client-server architecture, maze generation/solving, compression techniques, and multi-threading in Java.

## 📚 Project Overview

The project is divided into several parts, each building on the previous one. It involves designing and implementing a system that can:

- Generate 2D and 3D mazes using various algorithms.
- Solve mazes using search strategies.
- Compress and decompress maze data for efficient transmission and storage.
- Communicate between client and server for maze generation and solving.
- Follow SOLID principles, clean code guidelines, and use design patterns (e.g., Decorator, Strategy, Adapter).

---

## 🧩 Part A – Maze Generation

### Features:
- `Maze` class representing a 2D maze (0 = path, 1 = wall).
- `IMazeGenerator` interface with:
  - `generate(rows, cols)`
  - `measureAlgorithmTimeMillis(rows, cols)`
- Implementations:
  - `EmptyMazeGenerator`
  - `SimpleMazeGenerator`
  - `MyMazeGenerator` (student-created with an advanced algorithm)
- Maze structure includes a start and goal position (`Position` class).

### Testing:
- `RunMazeGenerator.java` runs all 3 maze generation algorithms and displays the maze and timing.

---

## 🧠 Part B – Search Algorithms

### Implemented Algorithms:
- Breadth-First Search
- Depth-First Search
- Best-First Search (with heuristics & diagonal movement)

### Core Classes:
- `AState`, `MazeState`, `Solution`, `SearchableMaze`, `ISearchingAlgorithm`
- `SearchableMaze` adapts a Maze into a searchable object.

### Testing:
- `RunSearchOnMaze.java` compares performance and solution quality of all search algorithms.

---

## 📦 Part C – Streams, Compression, and Communication

### Compression:
- `MyCompressorOutputStream` and `MyDecompressorInputStream`: Efficient byte-level maze compression using a custom RLE scheme.
- `SimpleCompressorOutputStream` as a baseline implementation.
- `Maze.toByteArray()` and `Maze(byte[] data)` to serialize/deserialize maze data.

### Client-Server:
- `Server` handles multiple clients using thread pool.
- Two main strategies:
  - `ServerStrategyGenerateMaze`
  - `ServerStrategySolveSearchProblem`
- `Client` communicates with each server using `IClientStrategy`.

### Testing:
- `RunCommunicateWithServers.java`: Tests both servers using the custom maze generator and solver.

---

## 🧪 Unit Testing

- `JUnit` tests (Part D) are implemented for algorithms (e.g., `BestFirstSearchTest`)
- Focus on edge cases, null checks, and algorithm correctness.

---

## 🧱 Optional: 3D Maze (Part G)

- Additional classes for 3D mazes (`Maze3D`, `Position3D`, etc.)
- Adapted search algorithms to support 3D navigation.
- Fully optional but offers 10 bonus points if implemented.

---

## 🌐 Git & Collaboration

- Project is managed via [GitHub](https://github.com/omrihershko/ATP-PartB).
- Includes `GeneralCheckingFunctions.getGithubLink()` as part of the automatic tests.

---

## ✅ Final Requirements

- Must compile and run without errors.
- All files submitted in a `.zip` file including:
  - `src`, `resources`, `.idea`, and compiled `.jar`
- README and documentation are part of the submission.

---

## 🛠 Technologies Used

- **Java 15+**
- **JavaFX** (for GUI in Part C)
- **JUnit 5**
- **IntelliJ IDEA**
- **Git / GitHub**

---

## 👨‍💻 Authors

- 🧑‍💻 Omri Hershko & [Partner Name]
- 👨‍🏫 Course: Advanced Topics in Programming – BGU
- 🧪 Instructor: Dudi, Rahaf, Nittai, Yuval

---

## 📜 License

This is a university coursework project and is not licensed for commercial use.

---

## 🙏 Acknowledgements

Special thanks to the course staff and peers who contributed feedback and insights.
