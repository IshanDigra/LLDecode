Here is your definitive, end-to-end survival guide for tomorrow. It consolidates everything into a single reference, capped off with a master code template that uses strings, maps, custom heaps, arrays, and lists all working together.

### 1. The Unified C++ to Java Translation Table

| Data Structure | C++ Implementation | Java Implementation | Key Methods & Crucial Differences |
| :--- | :--- | :--- | :--- |
| **String** | `std::string` | `String` / `StringBuilder` | `s.charAt(i)`, `s.substring(start, end)`, `s.equals(s2)`. **Use `StringBuilder` for loop appends.** |
| **Dynamic Array** | `std::vector<int>` | `ArrayList<Integer>` | `list.add(val)`, `list.get(i)`, `list.set(i, val)`, `list.remove(list.size()-1)`. No bracket notation `[]`. |
| **Stack** | `std::stack<int>` | `Deque<Integer> st = new ArrayDeque<>()` | `st.push(val)`, `st.pop()` (returns value), `st.peek()`. |
| **Queue** | `std::queue<int>` | `Deque<Integer> q = new ArrayDeque<>()` | `q.offer(val)`, `q.poll()` (returns value), `q.peek()`. |
| **Deque** | `std::deque<int>` | `Deque<Integer> dq = new ArrayDeque<>()` | `offerFirst/Last`, `pollFirst/Last`, `peekFirst/Last`. |
| **Min-Heap** | `std::priority_queue<int, vector, greater>` | `PriorityQueue<Integer>` | `pq.offer(val)`, `pq.poll()`, `pq.peek()`. **Java is Min-Heap by default.** |
| **Max-Heap** | `std::priority_queue<int>` | `PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder())` | Same methods. |
| **Hash Map** | `std::unordered_map<string, int>` | `HashMap<String, Integer>` | `map.put(k, v)`, `map.get(k)` (returns null if missing), `map.containsKey(k)`, `map.getOrDefault(k, defaultVal)`. |
| **Hash Set** | `std::unordered_set<int>` | `HashSet<Integer>` | `set.add(val)`, `set.contains(val)`, `set.remove(val)`. |

---

### 2. The Length & Loop Cheat Sheet
Knowing when to use parentheses for length will save you compilation headaches:

*   **Array:** `arr.length` (Property, no brackets)
*   **String:** `str.length()` (Method)
*   **Collections (List, Set, Map):** `list.size()` (Method)

**The Conditionals Trap:** Java requires explicit booleans.
*   *C++:* `while (n--)`
*   *Java:* `while (n-- > 0)`

---

### 3. The Master Runnable Template
This is a complete, copy-pasteable file. It solves a classic SDE-2 interview problem: **"Top K Frequent Words"**.

It is the perfect final practice example because it forces you to use Arrays, Strings, HashMaps, a PriorityQueue with a custom Lambda Comparator, Lists, and `for-each` loops simultaneously.

Save this as `Main.java`:

```java
import java.util.*;

// 1. Core Logic
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Frequency Map (HashMap)
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            // getOrDefault is your best friend in Java maps
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        // Step 2: Min-Heap (PriorityQueue) with Custom Comparator
        // If frequencies are equal, sort alphabetically descending (so larger gets polled out first)
        // Otherwise, sort by frequency ascending
        PriorityQueue<String> minHeap = new PriorityQueue<>(
            (w1, w2) -> {
                if (count.get(w1).equals(count.get(w2))) {
                    return w2.compareTo(w1); 
                }
                return count.get(w1) - count.get(w2);
            }
        );

        // Step 3: Populate the Heap
        for (String word : count.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll(); // Keep heap size at exactly K
            }
        }

        // Step 4: Extract to List and Reverse
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        
        // Min-heap gave us least frequent first, so reverse it
        Collections.reverse(result); 
        
        return result;
    }
}

// 2. Testing Environment
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Standard Array Initialization
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;

        System.out.println("Processing Array of length: " + words.length);
        
        // Execute and print
        List<String> topWords = sol.topKFrequent(words, k);
        System.out.println("Top " + k + " words: " + topWords);
        
        // Quick Stream Example: Convert List<String> to a single concatenated String
        String combined = String.join(", ", topWords);
        System.out.println("Joined with streams/utils: " + combined);
    }
}
```

### 4. How to Execute
Open your terminal in the same directory as the file and run:
```bash
javac Main.java