# Stack Overflow V3 - README

## Problem Statement

Design and implement a simplified version of Stack Overflow that supports the following requirements:

Users can post questions, answer questions, and comment on questions and answers.
Users can vote (upvote/downvote) on questions and answers.
Questions should have tags associated with them.
Users can search for questions based on keywords, tags, or user profiles.
The system should assign reputation scores to users based on their activity and the quality of their contributions.
The system should handle concurrent access and ensure data consistency.

## Happy Flow

| Step | Actor | Action | Description |
|------|-------|--------|-------------|
| 1 | User A | Posts Question | User creates a question with title, body, and tags; gains +10 reputation |
| 2 | User B | Answers Question | User provides an answer to the question; gains +8 reputation |
| 3 | User C | Comments on Answer | User adds a comment on the answer; gains +5 reputation |
| 4 | User A | Upvotes Answer | User upvotes User B's answer; User B gains +2 reputation |
| 5 | User C | Upvotes Comment | User upvotes their own or another comment; comment author gains +2 reputation |
| 6 | User B | Downvotes Comment | User downvotes a comment; comment author loses -2 reputation |
| 7 | User | Searches Questions | User searches by keyword, tag, or username to find relevant questions |

## Entities

| Entity | Properties | Description |
|--------|-----------|-------------|
| **User** | `id: String`, `name: String`, `reputation: AtomicLong` | Represents a system user with unique ID and reputation score |
| **Question** | `id: String`, `body: String`, `tags: List<String>`, `postedBy: User`, `timestamp: Timestamp`, `answers: List<Answer>`, `comments: List<Comment>`, `upVotes: List<User>`, `downVotes: List<User>` | Represents a question posted by a user with associated metadata |
| **Answer** | `id: String`, `body: String`, `question: Question`, `postedBy: User`, `timestamp: Timestamp`, `comments: List<Comment>`, `upVotes: List<User>`, `downVotes: List<User>` | Represents an answer to a specific question |
| **Comment** | `id: String`, `content: String`, `postedBy: User`, `timestamp: Timestamp`, `upVotes: List<User>`, `downVotes: List<User>` | Represents a comment on a question or answer |
| **Constants** | `UPVOTE: Long = 2`, `DOWNVOTE: Long = -2`, `QUESTION: Long = 10`, `ANSWER: Long = 8`, `COMMENT: Long = 5` | Defines reputation score values for different actions |

## Enums

No enums are defined in this implementation. All reputation values are stored as constants in the `Constants` class.

## Services & Core Functionalities

| Service | Method | Parameters | Return Type | Description |
|---------|--------|-----------|-------------|-------------|
| **StackOverFlow** | `postQuestion` | `User, List<String> tags, String content` | `Question` | Creates and posts a new question, updates user reputation (+10) |
| | `postAnswer` | `User, String body, Question` | `Answer` | Creates an answer to a question, updates user reputation (+8) |
| | `postComment` | `User, String body, Commentable` | `Comment` | Adds a comment to a commentable entity, updates reputation (+5) |
| | `upVote` | `User, Votable` | `void` | Registers an upvote on a votable entity (+2 reputation) |
| | `downVote` | `User, Votable` | `void` | Registers a downvote on a votable entity (-2 reputation) |
| | `getUpVotes` | `Votable` | `List<User>` | Retrieves list of users who upvoted the entity |
| | `getDownVotes` | `Votable` | `List<User>` | Retrieves list of users who downvoted the entity |
| | `searchQuestions` | `String keyword` | `List<Question>` | Searches questions by keyword, tag, or username |
| **SearchService** | `searchQuestions` | `String keyword` | `List<Question>` | Filters questions based on body content, tags, or author name |
| **Utility** | `UserId` | None | `String` | Generates unique user ID with prefix "USR_" |
| | `QuestionId` | None | `String` | Generates unique question ID with prefix "QS_" |
| | `AnswerId` | None | `String` | Generates unique answer ID with prefix "AS_" |
| | `CommentId` | None | `String` | Generates unique comment ID with prefix "CMT_" |
| | `updateReputation` | `User, Long` | `void` | Updates user's reputation score atomically |

## Critical Sections

| Component | Critical Section | Concurrency Mechanism | Purpose |
|-----------|-----------------|----------------------|---------|
| **Question** | `postComment`, `postAnswer`, `upVote`, `downVote` | `synchronized` methods | Ensures thread-safe operations on question state |
| **Answer** | `postComment`, `upVote`, `downVote` | `synchronized` methods | Prevents race conditions during answer modifications |
| **Comment** | `upVote`, `downVote` | `synchronized` methods | Thread-safe voting operations |
| **User** | `updateReputation` | `synchronized` method + `AtomicLong` | Atomic reputation updates to prevent lost updates |
| **StackOverFlow** | All public methods | `synchronized` methods | Singleton instance protection and consistent state updates |
| **Vote/Comment Lists** | All list operations | `CopyOnWriteArrayList` | Thread-safe list operations without explicit synchronization |
| **Users Map** | All map operations | `ConcurrentHashMap` | Thread-safe concurrent access to user registry |
| **ID Generators** | ID generation in Utility | `AtomicLong.incrementAndGet()` | Atomic and unique ID generation |

## Exceptions

No custom exceptions are implemented. The system throws `RuntimeException` for:
- Empty or null content when posting questions, answers, or comments

## Utilities

| Utility Class | Method | Purpose |
|--------------|--------|---------|
| **Utility** | `UserId()` | Generates unique user identifiers |
| | `QuestionId()` | Generates unique question identifiers |
| | `AnswerId()` | Generates unique answer identifiers |
| | `CommentId()` | Generates unique comment identifiers |
| | `updateReputation(User, Long)` | Centralized reputation update logic |

## Design Patterns Used

| Pattern | Implementation | Location | Purpose |
|---------|---------------|----------|---------|
| **Singleton** | Double-checked locking | `StackOverFlow` service | Ensures single instance of the main service |
| **Strategy** | Interface-based polymorphism | `Votable`, `Commentable` interfaces | Allows different entities to be voted on or commented |
| **Factory** | Static ID generation methods | `Utility` class | Centralized creation of unique identifiers |
| **Service Layer** | Separation of business logic | `StackOverFlow`, `SearchService` | Decouples business logic from entity models |

## Questions to Ask

| Question | Category | Impact |
|----------|----------|--------|
| Can there be comments on comments creating nested hierarchy? | Requirements | Would require recursive comment structure and additional UI complexity |
| What are the criteria for reputation score calculation (positive/negative thresholds)? | Business Logic | Affects user engagement and content quality mechanisms |
| What constitutes a user profile for search purposes? | Feature Scope | Determines search implementation complexity |
| Should there be limits on upvotes/downvotes per user per day? | Anti-abuse | Prevents gaming the reputation system |
| Should questions have acceptance criteria for best answer? | Feature Enhancement | Adds answer acceptance functionality |
| What happens when a user tries to vote on their own content? | Validation | Prevents self-voting abuse |
| Should there be moderator roles with special privileges? | Authorization | Adds role-based access control |
| How should deleted content affect reputation scores? | Data Integrity | Requires rollback mechanisms for reputation |
| Should search support fuzzy matching or only exact keywords? | Search Quality | Determines search algorithm complexity |
| What is the maximum length for questions, answers, and comments? | Validation | Prevents spam and ensures data quality |

---

**Note:** This implementation uses thread-safe collections (`CopyOnWriteArrayList`, `ConcurrentHashMap`) and synchronized methods to handle concurrent access. Future improvements could include eliminating code duplication in voting and commenting logic through inheritance or composition.
