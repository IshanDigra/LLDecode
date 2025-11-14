# Medium Level Problems

These problems involve multiple interacting services, complex state management, and require understanding of several design patterns. Great for building intermediate LLD skills.

## 🎯 Learning Objectives

After completing these problems, you will understand:
- Multiple service interactions
- Complex state management
- Advanced design patterns
- Concurrency considerations
- Payment and transaction systems

## 📋 Problems

### LRUCache
**Focus:** Data structure design and caching
- **Entities:** Cache, Node, CacheEntry
- **Concepts:** LRU algorithm, data structure design
- **Patterns:** Strategy pattern, data structures
- **Complexity:** 3-4 entities, algorithm implementation

### DigitalWallet
**Focus:** Payment systems and currency handling
- **Entities:** Wallet, Transaction, PaymentMethod, Account
- **Concepts:** Payment processing, currency conversion
- **Patterns:** Strategy pattern, Factory pattern
- **Complexity:** 5-6 entities, payment logic

### OnlineAuction
**Focus:** Bidding systems and time management
- **Entities:** Auction, Bid, Bidder, Item
- **Concepts:** Bidding logic, time management
- **Patterns:** Observer pattern, State pattern
- **Complexity:** 4-5 entities, bidding system

### TicketBooking
**Focus:** Reservation systems and seat management
- **Entities:** Ticket, Seat, Show, Customer
- **Concepts:** Seat allocation, booking management
- **Patterns:** State pattern, Observer pattern
- **Complexity:** 5-6 entities, reservation system

### TicTacToe
**Focus:** Game logic and state management
- **Entities:** Game, Player, Board, Move
- **Concepts:** Game state, move validation
- **Patterns:** State pattern, Strategy pattern
- **Complexity:** 4-5 entities, game logic

### Elevator
**Focus:** System control and scheduling
- **Entities:** Elevator, Floor, Request, ElevatorController
- **Concepts:** Scheduling algorithms, system control
- **Patterns:** State pattern, Observer pattern
- **Complexity:** 4-5 entities, scheduling logic

### CarRental
**Focus:** Resource management and booking
- **Entities:** Car, Customer, Rental, Payment
- **Concepts:** Resource allocation, booking system
- **Patterns:** State pattern, Strategy pattern
- **Complexity:** 5-6 entities, rental system

### ATM
**Focus:** Banking operations and security
- **Entities:** ATM, Account, Transaction, Card
- **Concepts:** Banking operations, security
- **Patterns:** State pattern, Strategy pattern
- **Complexity:** 4-5 entities, banking system

### HotelManagement
**Focus:** Room management and booking
- **Entities:** Hotel, Room, Booking, Guest
- **Concepts:** Room allocation, booking management
- **Patterns:** State pattern, Observer pattern
- **Complexity:** 5-6 entities, hotel system

## 🚀 Key Concepts

### Service Integration
- Multiple services working together
- Service communication patterns
- Data flow between services

### Advanced Patterns
- **Observer Pattern** - Event notifications
- **Strategy Pattern** - Algorithm selection
- **State Pattern** - Complex state management
- **Factory Pattern** - Object creation

### Concurrency
- Thread safety considerations
- Synchronization mechanisms
- Race condition handling

### Business Logic
- Complex validation rules
- Multi-step processes
- Error handling and recovery

## 💡 Problem-Solving Approach

1. **Identify all services** - What does each service do?
2. **Define interfaces** - How do services communicate?
3. **Handle concurrency** - Where are the critical sections?
4. **Design for scalability** - How can the system grow?
5. **Test edge cases** - What can go wrong?

## 🔗 Next Steps

After mastering these problems, move on to:
- [Hard Problems](../04-Hard/) - Complex business systems
- [Expert Problems](../05-Expert/) - Enterprise-level systems
- [Templates](../../02-Templates/) - Standardized structure
- [LLD Fundamentals](../../03-LLD-Fundamentals/) - Essential knowledge and best practices
- [Concurrency Problems](../../06-Concurrency-Problems/) - Advanced threading
