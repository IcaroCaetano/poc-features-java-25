# POC Java 25 — Generated classes

This repository contains a Proof of Concept (POC) project demonstrating the most relevant new features introduced in Java 25. The code samples are structured to provide hands-on examples that developers can build upon when exploring the latest language, runtime, and API enhancements.

## Features Covered

- Structured Concurrency (Preview) — Simplified management of concurrent tasks with automatic cancellation and error propagation.

- Scoped Values (Final) — Safer alternative to ThreadLocal for passing immutable context values across threads.

- Flexible Constructor Bodies (Final) — Logic and validation allowed before calling super(...) in constructors.

- Primitive Types in Patterns (Preview) — Use primitive types directly in pattern matching with switch and instanceof.

- Vector API (Incubator) — SIMD/vector operations for high-performance numerical processing.

- PEM Encodings for Cryptographic Objects (Preview) — Encode/decode cryptographic material into PEM format.

- Compact Source Files & Instance Main Methods (Final) — Create small utility programs with reduced boilerplate.

- JFR Profiling Improvements — Hooks for leveraging Java Flight Recorder to measure execution time and performance.


## Project Structure

```

src/main/java/com/example/poc/
├── MainApp.java # Entry point running all examples
├── StructuredConcurrency.java
├── ScopedValues.java
├── FlexibleConstructor.java
├── PrimitivePattern.java
├── VectorApi.java
├── PemUtils.java
└── JfrProfiler.java
```

## Requirements

- JDK 25 (Early Access or GA version)

- Enable preview features:

```

javac --release 25 --enable-preview -source 25 $(find src -name "*.java")
java --enable-preview -cp src com.example.poc.MainApp
```

- For the Vector API:

```
--add-modules jdk.incubator.vector
```

## Running the Examples

1 - Clone the repository and ensure JDK 25 is installed.

2 - Compile with preview features enabled:

```
javac --release 25 --enable-preview -source 25 $(find src -name "*.java")
```

3 - Run the main application:

```

java --enable-preview -cp src com.example.poc.MainApp
```

4 - To include the Vector API demo, add:

```
--add-modules jdk.incubator.vector
```

## Example Output

```
POC Java 25 - Running examples


-> Structured concurrency example
-> result-1
-> result-2


-> Scoped values example
scoped value inside thread: user-123


-> Flexible constructor example
instance created with value = 42


-> Primitive pattern example
-> int: 10
-> double: 3.14
-> string: hello
-> short: 7


-> Vector API example (if module available)
vector add result: 11 22 33 44 ...


-> PEM utilities example (simple wrapper)
-----BEGIN TEST-KEY-----
abc123
-----END TEST-KEY-----


POC finished
```
