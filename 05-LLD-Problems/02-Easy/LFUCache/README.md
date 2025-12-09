# LFU Cache -- current implematation is flawed. need to resolve it from scratch. first implement simple solution check on leetcode. 
then convert to end to end solution with syncronization atomicity and everything. 

## Problem Statement

Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

- **LFUCache(int capacity)** - Initializes the object with the capacity of the data structure.
- **int get(key)** - Gets the value of the key if the key exists in the cache. Otherwise, returns null.
- **void put(key, value)** - Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.

To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 0 (due to the put operation). The use counter for a key in the cache is incremented when either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.

## Happy Flow

The user interacts with the LFU cache through the following sequence:

1. Create an LFU cache instance with a specified capacity
2. Insert key-value pairs using put() operation
3. Retrieve values using get() operation
4. When the cache reaches capacity and a new item needs to be added, the least frequently used key-value pair is automatically evicted
5. In case of frequency tie, the least recently used key among the tied keys is evicted
6. Continue performing get/put operations on remaining cache entries

## Entities

| Entity | Description | Attributes |
|--------|-------------|-----------|
| **Node<K, V>** | Represents a cache entry with linked list pointers | key, value, freq, next, prev |
| **DLL<K, V>** | Doubly Linked List for maintaining insertion order within a frequency bucket | head, tail, size |
| **LFU<K, V>** | Main cache data structure | nodeMap, freqMap, capacity, currSize, minFrequency |

### Entity Details

**Node<K, V>**: Each node contains:
- Key and value for the cache entry
- Frequency counter tracking access count
- Pointers to next and previous nodes for DLL traversal

**DLL<K, V>**: Manages nodes at each frequency level:
- Sentinel head and tail nodes for boundary handling
- Atomic size counter for thread-safe operations
- Nodes added at tail for LRU ordering within same frequency

**LFU<K, V>**: Core cache structure:
- `nodeMap`: HashMap for O(1) lookup of nodes by key
- `freqMap`: HashMap mapping frequency to DLL of nodes at that frequency
- `minFrequency`: Tracks the lowest frequency in use for quick eviction
- `currSize`: Current number of entries in cache
- `capacity`: Maximum cache capacity

## Enums

No enums are required for this implementation.

## Services & Core Functionalities

| Service | Method | Responsibility |
|---------|--------|-----------------|
| **LFU** | `add(Node<K,V> node, long freq)` | Adds node at specified frequency level; updates minFrequency; enforces capacity check |
| **LFU** | `remove(Node<K,V> node)` | Removes node from its frequency list; updates minFrequency if frequency bucket empties |
| **LFU** | `get(K key)` | Returns value for key; increments frequency; repositions node to new frequency level |
| **LFU** | `put(K key, V value)` | Inserts or updates key-value pair; evicts LFU node if capacity exceeded; resets frequency on new insertions |
| **DLL** | `addNode(Node<K,V> node)` | Adds node at tail of doubly linked list in O(1) |
| **DLL** | `removeNode(Node<K,V> node)` | Removes node from its position in doubly linked list in O(1) |
| **DLL** | `getFirstNode()` | Returns head node for eviction purposes |

## Critical Sections

The following areas require synchronization for concurrent access:

| Critical Section | Location | Reason |
|-----------------|----------|--------|
| **get() operation** | LFU.java | Synchronized to prevent race conditions during frequency update and node repositioning |
| **put() operation** | LFU.java | Synchronized to ensure atomicity of insertion, eviction, and frequency management |
| **addNode()** | DLL.java | Synchronized to prevent concurrent modifications to linked list structure |
| **removeNode()** | DLL.java | Synchronized to maintain list integrity during concurrent removals |
| **Frequency update** | LFU.java | Atomic operations used for minFrequency, currSize to ensure thread-safe counter management |

## Exceptions

The following conditions are handled:

| Scenario | Handling |
|----------|----------|
| **Key not found in get()** | Returns null with log message |
| **Eviction when full** | Removes LFU node before insertion |
| **Empty DLL removal** | Returns with log message without error |
| **Capacity exceeded on add** | Returns early without insertion |

## Utilities

| Utility Class | Purpose |
|---------------|---------|
| **ConcurrentHashMap** | Thread-safe map implementation for nodeMap and freqMap |
| **AtomicLong** | Lock-free atomic operations for minFrequency, currSize, and DLL size |

## Design Patterns Used

| Pattern | Implementation |
|---------|-----------------|
| **Cache Pattern** | LFU provides memory-bounded caching with automatic eviction |
| **Doubly Linked List** | Used to maintain insertion order within frequency buckets for O(1) LRU eviction |
| **Bucket Hashing** | Frequency map acts as bucketing for grouping nodes by access frequency |
| **Lazy Deletion** | Nodes are repositioned rather than explicitly marked as deleted |
| **Thread-Safe Singleton** | ConcurrentHashMap and AtomicLong ensure thread safety without explicit locking overhead |

## Questions to Ask

1. What should be the behavior when capacity is zero or negative?
2. Should null keys be supported in the cache?
3. How should the cache handle concurrent modifications from multiple threads?
4. Should there be a method to clear the entire cache?
5. What is the expected behavior if the same key is put multiple times without getting it?
6. Should cache statistics (hit rate, evictions count) be tracked?
7. How should the cache behave when memory constraints are tight?
8. Should cache entries have TTL (Time To Live) for automatic expiration?
9. What serialization requirements exist for persistence?
10. Should there be different eviction policies based on use case?
