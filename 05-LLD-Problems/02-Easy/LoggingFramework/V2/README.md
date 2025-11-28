# Logging Framework V2

## Problem Statement

The logging framework should support different log levels, such as DEBUG, INFO, WARNING, ERROR, and FATAL. It should allow logging messages with a timestamp, log level, and message content. The framework should support multiple output destinations, such as console, file, and database. It should provide a configuration mechanism to set the log level and output destination. The logging framework should be thread-safe to handle concurrent logging from multiple threads. It should be extensible to accommodate new log levels and output destinations in the future.

## Happy Flow

1. User obtains LoggingFramework singleton instance
2. User sets desired log level via setLevel() method
3. User creates LogMessage with content and log level
4. User calls processLog() with the LogMessage
5. Framework validates message log level against configured threshold
6. If valid, message passes through chain of handlers (DEBUG → INFO → WARNING → ERROR → FATAL)
7. Appropriate handler processes the message based on matching log level
8. Message is forwarded to configured output destination
9. Output destination processes and displays/stores the log message

## Entities

| Entity | Properties | Description |
|--------|-----------|-------------|
| **LogMessage** | timestamp: Timestamp, content: String, level: LogLevel | Represents a single log entry with automatic timestamp generation |
| **Configuration** | level: LogLevel, destination: OutputDestination | Holds framework-wide settings for minimum log level and output target |
| **LoggingFrameWork** | instance: LoggingFrameWork (static), nextHandler: Handler | Singleton entry point implementing handler chain initialization |
| **Handler** (Abstract) | configuration: Configuration (static), nextHandler: Handler, level: LogLevel, logger: Logger (static) | Base class for all log level handlers with chain of responsibility logic |
| **DebugHandler** | Inherits from Handler | Processes DEBUG level messages |
| **InfoHandler** | Inherits from Handler | Processes INFO level messages |
| **WarningHandler** | Inherits from Handler | Processes WARNING level messages |
| **ErrorHandler** | Inherits from Handler | Processes ERROR level messages |
| **OutputDestination** (Interface) | - | Defines contract for message output targets |
| **Console** | logger: Logger (static) | Console-based implementation of OutputDestination |

## Enums

| Enum | Values | Description |
|------|--------|-------------|
| **LogLevel** | DEBUG, INFO, WARNING, ERROR, FATAL | Defines severity levels in ascending order of priority |

## Services & Core Functionalities

| Service/Class | Methods | Responsibilities |
|--------------|---------|------------------|
| **LoggingFrameWork** | getInstance(): LoggingFrameWork, processLog(LogMessage): void | Entry point for logging operations, initializes handler chain (DEBUG → INFO → WARNING → ERROR), delegates processing to handler chain |
| **Handler** | setLevel(LogLevel): void, setDestination(OutputDestination): void, getConfiguration(): Configuration, getNextHandler(): Handler, setNextHandler(Handler): void, processLog(LogMessage): void | Maintains global configuration, validates log level against threshold, forwards requests through chain of responsibility, manages handler linkage |
| **DebugHandler** | processLog(LogMessage): void | Processes DEBUG level messages or forwards to next handler |
| **InfoHandler** | processLog(LogMessage): void | Processes INFO level messages or forwards to next handler |
| **WarningHandler** | processLog(LogMessage): void | Processes WARNING level messages or forwards to next handler |
| **ErrorHandler** | processLog(LogMessage): void | Processes ERROR level messages or forwards to next handler |
| **OutputDestination** | processLog(LogMessage): void | Interface defining contract for output processing |
| **Console** | processLog(LogMessage): void | Outputs log messages to console using Java Logger |
| **Configuration** | getLevel(): LogLevel, setLevel(LogLevel): void, getDestination(): OutputDestination, setDestination(OutputDestination): void | Manages framework-wide log level and output destination settings |
| **LogMessage** | getTime(): Timestamp, getContent(): String, getLevel(): LogLevel, toString(): String | Encapsulates log entry data with automatic timestamp creation |

## Critical Sections

| Critical Section | Concurrency Concern | Implementation |
|-----------------|---------------------|----------------|
| **Singleton Instance Creation** | Multiple threads may attempt to create LoggingFrameWork instance simultaneously | Double-checked locking with volatile keyword in getInstance() method |
| **Configuration Updates** | Concurrent updates to log level or output destination may cause inconsistent state | Static final Configuration object with synchronized setters (not shown in current code but recommended) |
| **Handler Chain Initialization** | Handler chain setup must complete before processing begins | Initialization occurs in private constructor, ensuring thread-safe setup before instance is accessible |

## Exceptions

| Exception | Usage Context | Purpose |
|-----------|--------------|---------|
| **RuntimeException** | Thrown when no valid handler is set in handler chain | Indicates configuration error in handler chain setup |
| **Exception** | Caught and wrapped in RuntimeException within DebugHandler and other handlers | Generic exception handling for processLog operations |

## Utilities

| Utility | Purpose | Implementation |
|---------|---------|----------------|
| **java.util.logging.Logger** | Provides built-in logging for framework operations | Static instances in Handler and Console classes |
| **java.sql.Timestamp** | Captures precise log message creation time | Auto-generated in LogMessage constructor |
| **Enum.ordinal()** | Compares log level severity | Used to determine if message meets minimum log level threshold |

## Design Patterns Used

| Pattern | Implementation | Purpose |
|---------|---------------|---------|
| **Singleton** | LoggingFrameWork class with double-checked locking | Ensures single global instance of logging framework |
| **Chain of Responsibility** | Handler hierarchy (DEBUG → INFO → WARNING → ERROR → FATAL) | Decouples log level processing, allows flexible message handling |
| **Strategy** | OutputDestination interface with Console implementation | Enables pluggable output destinations (console, file, database) |
| **Template Method** | Handler abstract class with processLog() | Defines skeleton of log processing algorithm in parent class |

## Questions to Ask

1. Is this a local logging framework or global logging framework?
2. Should the framework support asynchronous logging for performance optimization?
3. What should be the maximum file size before rotation for file-based output destinations?
4. Should log messages support structured logging (JSON format) in addition to plain text?
5. Do we need to support log aggregation across distributed systems?
6. Should there be rate limiting to prevent log flooding?
7. What retention policy should be applied to historical logs?
8. Should the framework support custom log formatters?
9. Do we need different output destinations for different log levels (e.g., ERROR to file, DEBUG to console)?
10. Should FATAL logs trigger additional actions (e.g., email notifications, system shutdown)?
11. Is there a requirement for log filtering based on source class or package?
12. Should the framework support log level changes at runtime without restart?
13. Do we need log compression for archived logs?
14. Should there be a built-in mechanism for log sanitization (removing sensitive data)?