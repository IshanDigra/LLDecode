# LRU Cache

## Problem Statement

Design and implement a Least Recently Used (LRU) Cache that efficiently stores key-value pairs with a fixed capacity. When the cache reaches its maximum capacity and a new element needs to be inserted, the least recently used item should be evicted. The cache should support both get and put operations with efficient time complexity.

## Happy Flow

1. User initializes LRU Cache with a specified capacity (e.g., capacity = 3)
2. User performs put operations to add key-value pairs (put(1, "Value 1"), put(2, "Value 2"), put(3, "Value 3"))
3. User performs get operations to retrieve values (get(1) returns "Value 1", marks key 1 as recently used)
4. When cache is full and a new key is added, the least recently used item is automatically evicted
5. User can update existing keys with new values (put(1, "Updated Value"))
6. Recently accessed keys move to the front of the cache ordering

## Entities

| Entity | Properties | Description |
|--------|-----------|-------------|
| Node<K, V> | key: K, value: V, next: Node, prev: Node | Doubly linked list node storing cache entry with forward and backward pointers |
| LRU<K, V> | capacity: int, hash: Map<K, Node>, head: Node, tail: Node | Main cache structure with fixed capacity using doubly linked list and hash map |

## Enums

No enums are required for this problem.

## Services & Core Functionalities

| Service | Methods | Responsibility |
|---------|---------|-----------------|
| LRU Cache | `LRU(int capacity)` | Initialize cache with specified capacity and sentinel head/tail nodes |
| | `V get(K key)` | Retrieve value by key, move accessed node to front (most recently used position) |
| | `void put(K key, V value)` | Insert or update key-value pair, evict LRU item if capacity exceeded |
| | `void add(Node<K,V> node)` | Add node at head position (most recently used) and update hash map |
| | `void remove(Node<K,V> node)` | Remove node from doubly linked list and hash map |

## Critical Sections

| Area | Details |
|------|---------|
| get() method | Synchronized to prevent concurrent access issues when moving node position |
| put() method | Synchronized to safely handle insertion, eviction, and capacity checks |
| add() method | Must maintain doubly linked list integrity and hash map consistency |
| remove() method | Must properly unlink node from neighbors and remove from hash map |
| Capacity management | Critical point when hash.size() equals capacity before adding new elements |

## Exceptions

No custom exceptions are explicitly required. Standard scenarios include:
- KeyNotFoundException: Can be handled via null return when key not found (current implementation)
- CapacityExceededException: Automatically handled by evicting LRU item

## Utilities

| Utility | Purpose |
|---------|---------|
| ConcurrentHashMap<K, Node<K,V>> | Thread-safe map for O(1) key lookup during get/put operations |
| Doubly Linked List | Maintains insertion order; enables O(1) eviction of least recently used item |
| Sentinel Nodes | Head and tail dummy nodes simplify edge case handling in add/remove operations |

## Design Patterns Used

| Pattern | Implementation |
|---------|-----------------|
| Combination Pattern | Hash Map + Doubly Linked List for O(1) operations |
| Synchronized Methods | Ensures thread safety for concurrent access |
| Generic Programming | <K, V> generics allow flexible key-value types |

## Questions to Ask

1. Should the cache support thread-safe concurrent operations?
2. What should be the behavior when getting a non-existent key - return null or throw exception?
3. Should updating an existing key increase its count or just update the value?
4. Is there a minimum or maximum capacity requirement?
5. Should the cache track statistics like hit/miss ratios?
6. What types of keys and values should be supported - primitives or objects?
7. Should there be an operation to explicitly remove items from cache?
8. How should the cache handle null keys or values?
9. Should there be a way to check if a key exists without updating its recency?
10. Is there a need to clear the entire cache?
