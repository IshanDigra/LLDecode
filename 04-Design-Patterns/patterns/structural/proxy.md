# Proxy Design Pattern

**Definition:**
A structural pattern that provides a surrogate or placeholder for another object to control access, add security, cache results, or manage resources.

**Concept:**
The Proxy acts as a middleman between the client and the real object. The client interacts with the proxy, which controls or enhances access to the real object.

**Structure:**
| **Role**         | **Example**                           |
|------------------|----------------------------------------|
| Subject          | Interface (e.g., `VideoService`)       |
| RealSubject      | Actual implementation (e.g., `YouTubeVideoService`) |
| Proxy            | Controls access (e.g., `YouTubeProxy`) |
| Client           | Uses the proxy (e.g., `YouTubeClient`) |

**Diagram:**
```
                 Controls Access
+--------+         +--------+         +-------------+
| Client | ----->  | Proxy  | ----->  | RealSubject |
+--------+         +--------+         +-------------+
```

**Benefits:**
- Add security checks
- Control resource usage
- Hide complexity or remote objects
- Log, audit, or monitor access

**When to Use:**
- You need to control access to an object
- You want to add extra functionality to an object transparently
