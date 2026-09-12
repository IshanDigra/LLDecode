package problems.lld.beginner.taskmanagement.v1;

import java.util.*;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        testStrings();
        testArrays();
        testArrayLists();
        testStacks();
        testQueuesAndDeques();
        testPriorityQueues();
        testHashMaps();
        testHashSets();
        testTreeNodes();
        testGraphAdjacencyList();
    }

    // ==========================================
    // 1. STRINGS & STRINGBUILDER
    // ==========================================
    static void testStrings() {
        System.out.println("--- 1. Strings & StringBuilder ---");

        // Initialization
        String s = "leetcode"; // this will use string pool
        String s2 = new String("leetcode");

        // Length & Character Access
        int len = s.length();                     // 8 (uses method .length())
        char ch = s.charAt(0);                    // 'l' (no s[0] bracket access)

        // Substring: s.substring(startIndex, endIndexExclusive)
        String sub = s.substring(0, 4);           // "leet"

        // Equality Check: ALWAYS use .equals(), NEVER ==
        boolean isEqual = s.equals(s2);           // true

        // Conversion to char array for iteration
        for (char c : s.toCharArray()) {
            // Process character
        }

        // Conversion to/from char values
        int digit = '5' - '0';                    // 5
        char cDigit = (char) ('0' + 5);           // '5'

        // StringBuilder for In-place / Loop modifications (avoids TLE)
        StringBuilder sb = new StringBuilder("leet");
        sb.append("code");                        // "leetcode"
        sb.insert(4, "-");                        // "leet-code"
        sb.deleteCharAt(4);                       // "leetcode"
        sb.reverse();                             // "edocteel"
        sb.setCharAt(0, 'E');                     // "Edocteel"
        String finalStr = sb.toString();
        for (int i = 0 ; i < sb.length(); i++){
            System.out.print(sb.charAt(i) + ", ");
        }

        System.out.println("Final String from SB: " + finalStr);
    }

    // ==========================================
    // 2. ARRAYS (PRIMITIVE & 2D)
    // ==========================================
    static void testArrays() {
        System.out.println("--- 2. Primitive & 2D Arrays ---");

        // 1D Array Initialization
        int[] arr = new int[5];                   // Defaults to [0, 0, 0, 0, 0]
        int[] preset = {5, 2, 8, 1, 9};

        // Access & Length
        int n = preset.length;                    // Property, no parentheses
        preset[0] = 10;                           // Bracket notation works on raw arrays

        // Sorting & Searching
        Arrays.sort(preset);                      // [1, 2, 8, 9, 10]
        int idx = Arrays.binarySearch(preset, 8); // 2

        // Fill array
        Arrays.fill(arr, -1);                     // [-1, -1, -1, -1, -1]

        // 2D Array / Matrix Initialization
        int rows = 3, cols = 4;
        int[][] matrix = new int[rows][cols];
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        // Fill 2D array with default values
        for (int[] row : matrix) {
            Arrays.fill(row, 0);
        }

        // Sorting 2D Arrays (e.g., Intervals: sort by start time ascending)
        int[][] intervals = {{3, 4}, {1, 2}, {2, 5}};
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        System.out.println("Sorted intervals: " + Arrays.deepToString(intervals));
    }

    // ==========================================
    // 3. ARRAYLIST (DYNAMIC ARRAY)
    // ==========================================
    static void testArrayLists() {
        System.out.println("--- 3. Dynamic Arrays (ArrayList) ---");

        // Initialization
        List<Integer> list = new ArrayList<>(Collections.nCopies(5,-1));
        // list.forEach((i)-> System.out.println(2*i));

        // Adding Elements
        list.add(10);                             // Append: O(1) amortized
        list.add(20);
        list.add(0, 5);                           // Insert at index 0: O(N)

        // Accessing & Updating
        int val = list.get(1);                    // 10 (no list[1])
        list.set(1, 15);                          // list[1] = 15

        // Size & Emptiness
        int size = list.size();                   // 3
        boolean empty = list.isEmpty();           // false

        // Removing Elements
        list.remove(list.size() - 1);             // Pop back: O(1)
        list.remove(0);                           // Remove by index: O(N)
        list.remove(Integer.valueOf(15));         // Remove by object value

        // Sorting
        list.addAll(Arrays.asList(40, 10, 30, 20));
//        Collections.sort(list);                   // Ascending: [10, 20, 30, 40]
//        Collections.sort(list, Collections.reverseOrder()); // Descending

        // Conversions via Streams
        int[] primitiveArr = list.stream().mapToInt(i -> i).toArray();
        List<Integer> fromArr = Arrays.stream(primitiveArr).boxed().collect(Collectors.toList());

        System.out.println("List: " + list);
    }

    // ==========================================
    // 4. STACK (USING ARRAYDEQUE)
    // ==========================================
    static void testStacks() {
        System.out.println("--- 4. Stack (ArrayDeque) ---");

        // Initialization: Use Deque interface with ArrayDeque
        Deque<Integer> stack = new ArrayDeque<>();

        // Push (add to top)
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Peek (look at top without removing)
        int top = stack.peek();                   // 30
        System.out.println(top);
        // Pop (remove and return top)
        int popped = stack.pop();                 // 30

        // Size & Check
        int size = stack.size();                  // 2
        boolean hasElements = !stack.isEmpty();   // true

        System.out.println("Stack top after pop: " + stack.peek());
    }

    // ==========================================
    // 5. QUEUE & DEQUE (USING ARRAYDEQUE)
    // ==========================================
    static void testQueuesAndDeques() {
        System.out.println("--- 5. Queue & Deque (ArrayDeque) ---");

        // Standard FIFO Queue: Use Queue interface or Deque interface
        Deque<Integer> queue = new ArrayDeque<>();

        // Enqueue (Push Back)
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        // Peek Front
        int front = queue.peek();                 // 10

        // Dequeue (Pop Front): returns and removes
        int removedFront = queue.poll();          // 10

        // Double-Ended Queue (Deque) Operations
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(1);                      // Add to front: [1]
        deque.offerLast(2);                       // Add to back:  [1, 2]
        deque.offerFirst(0);                      // Add to front: [0, 1, 2]

        int firstVal = deque.peekFirst();         // 0
        int lastVal = deque.peekLast();           // 2

        int polledFirst = deque.pollFirst();      // 0 (removes 0)
        int polledLast = deque.pollLast();        // 2 (removes 2)

        System.out.println("Deque remaining element: " + deque.peekFirst());
    }

    // ==========================================
    // 6. PRIORITY QUEUE (HEAPS)
    // ==========================================
    static void testPriorityQueues() {
        System.out.println("--- 6. PriorityQueue (Min/Max Heap) ---");

        // Min-Heap (Default in Java)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(30);
        minHeap.offer(10);
        minHeap.offer(20);

        int minVal = minHeap.peek();              // 10
        int polledMin = minHeap.poll();           // 10 (removes 10)

        // Max-Heap (Using Comparator)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(30);
        maxHeap.offer(10);
        maxHeap.offer(20);

        int maxVal = maxHeap.peek();              // 30
        int polledMax = maxHeap.poll();           // 30 (removes 30)

        // Custom Comparator (e.g., Min-Heap of coordinate pairs [x, y] sorted by x)
        PriorityQueue<int[]> pairHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0])
        );
        pairHeap.offer(new int[]{5, 100});
        pairHeap.offer(new int[]{2, 200});

        int[] smallestXPair = pairHeap.poll();    // [2, 200]
        System.out.println("Smallest X pair: [" + smallestXPair[0] + ", " + smallestXPair[1] + "]");
    }

    // ==========================================
    // 7. HASHMAP (KEY-VALUE MAP)
    // ==========================================
    static void testHashMaps() {
        System.out.println("--- 7. HashMap ---");

        // Initialization
        Map<String, Integer> map = new HashMap<>();

        // Put (Insert / Update)
        map.put("apple", 3);
        map.put("banana", 2);
        map.put("apple", 5);                      // Overwrites 3 with 5

        // Get & Check Existence
        int count = map.get("apple");             // 5 (throws NullPointerException if missing and unboxed to int)
        Integer missing = map.get("orange");      // null
        boolean exists = map.containsKey("banana");// true

        // Essential DSA Methods
        // getOrDefault: returns fallback value if key doesn't exist
        int orangeCount = map.getOrDefault("orange", 0); // 0

        // putIfAbsent: insert only if key is not present
        map.putIfAbsent("mango", 4);

        // Removing
        map.remove("banana");

        // Iterating Keys, Values, and Entries
        for (String key : map.keySet()) {
            int val = map.get(key);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String k = entry.getKey();
            int v = entry.getValue();
        }

        System.out.println("HashMap size: " + map.size());
    }

    // ==========================================
    // 8. HASHSET (UNIQUE VALUES)
    // ==========================================
    static void testHashSets() {
        System.out.println("--- 8. HashSet ---");

        // Initialization
        Set<Integer> set = new HashSet<>();

        // Add: returns true if added, false if duplicate
        boolean addedFirst = set.add(10);         // true
        boolean addedDup = set.add(10);           // false

        // Lookup
        boolean contains = set.contains(10);      // true

        // Remove
        set.remove(10);

        // Size and Emptiness
        int size = set.size();                    // 0
        boolean isEmpty = set.isEmpty();          // true

        // Conversion from Array/List to Set (Deduplication)
        List<Integer> duplicates = Arrays.asList(1, 2, 2, 3, 3, 3);
        Set<Integer> uniqueSet = new HashSet<>(duplicates);

        System.out.println("Unique set: " + uniqueSet);
    }

    // ==========================================
    // 9. BINARY TREE NODE DEFINITION & BFS/DFS
    // ==========================================
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static void testTreeNodes() {
        System.out.println("--- 9. Trees (BFS Traversal Example) ---");

        // Construct Tree:      1
        //                     / \
        //                    2   3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // Level-Order Traversal (BFS)
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();
                currentLevel.add(curr.val);

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            levels.add(currentLevel);
        }

        System.out.println("BFS Level Order: " + levels);
    }

    // ==========================================
    // 10. GRAPH ADJACENCY LIST
    // ==========================================
    static void testGraphAdjacencyList() {
        System.out.println("--- 10. Graph Representation ---");

        int numNodes = 4;
        // Adjacency List: List of Lists
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            adj.add(new ArrayList<>());
        }

        // Add Directed Edges (u -> v)
        // 0 -> 1, 0 -> 2, 1 -> 3
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);

        // Traverse neighbors of node 0
        System.out.print("Neighbors of Node 0: ");
        for (int neighbor : adj.get(0)) {
            System.out.print(neighbor + " ");
        }
        System.out.println();
    }
}
