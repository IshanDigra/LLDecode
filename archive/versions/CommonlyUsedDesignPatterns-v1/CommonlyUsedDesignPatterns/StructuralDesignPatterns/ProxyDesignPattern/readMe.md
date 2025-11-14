# Proxy Design Pattern

------------------------------------------------------------

**Definition:**  
A structural pattern that provides a surrogate or placeholder for another object to control access, add security, cache results, or manage resources.

------------------------------------------------------------

**Concept:**  
The Proxy acts as a middleman between the client and the real object. The client interacts with the proxy, which controls or enhances access to the real object.

------------------------------------------------------------

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
> The proxy stands in for the real object, adding security, caching, logging, or delaying resource use.

------------------------------------------------------------

**Why Use a Proxy?**
- Add security checks (e.g., only allow certain users to access methods)
- Control resource usage (e.g., lazy loading, caching, rate limiting)
- Hide complexity or remote objects (e.g., network proxies)
- Log, audit, or monitor access

------------------------------------------------------------

**Real World Examples:**
- Internet proxies (control/filter web requests)
- Virtual proxies (delay heavy object creation)
- Protection proxies (restrict access based on permissions)
- Smart references (add logging, counting, etc.)
- Spring/SpringBoot beans use proxies for singleton management

------------------------------------------------------------

**Code Example (Generalized Template):**
```java
// Subject
interface Subject {
    void request();
}

// RealSubject
class RealSubject implements Subject {
    public void request() {
        System.out.println("Request handled by RealSubject");
    }
}

// Proxy
class Proxy implements Subject {
    private RealSubject realSubject;
    private boolean authorized;

    public Proxy(boolean authorized) {
        this.authorized = authorized;
        this.realSubject = new RealSubject();
    }

    public void request() {
        if (authorized) {
            System.out.println("Proxy: Access granted.");
            realSubject.request();
        } else {
            System.out.println("Proxy: Access denied.");
        }
    }
}

    // Usage
    Subject user = new Proxy(true);
user.request(); // Output: Proxy: Access granted. Request handled by RealSubject

        Subject guest = new Proxy(false);
        guest.request(); // Output: Proxy: Access denied.
```
> Note: You can add caching, logging, or other logic in the proxy as needed!

------------------------------------------------------------

**Summary:**
- Proxy controls access to a real object.
- Useful for security, performance, and resource management.
- Keeps client code simple and decoupled from access logic.

------------------------------------------------------------
