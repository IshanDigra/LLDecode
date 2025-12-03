# Vending Machine V2

## Problem Statement

The vending machine should support multiple products with different prices and quantities. The machine should accept coins and notes of different denominations. The machine should dispense the selected product and return change if necessary. The machine should keep track of the available products and their quantities. The machine should handle multiple transactions concurrently and ensure data consistency. The machine should provide an interface for restocking products and collecting money. The machine should handle exceptional scenarios, such as insufficient funds or out-of-stock products.

**Bonus Requirements:**
- Notify the admin about low inventory count and restocking the product on time.
- Multiple products could be added to cart with varying quantity (currently assuming only 1 quantity selection per product).

---

## Happy Flow

| Step | Action | Description |
|------|--------|-------------|
| 1 | Admin Setup | Admin registers as an observer and restocks products with initial quantities |
| 2 | Product Selection | User browses available products and selects desired items |
| 3 | Cart Management | User can add or remove products from selection |
| 4 | Initiate Payment | User proceeds to payment phase, triggering state transition |
| 5 | Add Money | User inserts coins/cash into the machine |
| 6 | Process Payment | System validates amount against total cost |
| 7 | Payment Validation | If insufficient, user adds more money; if sufficient, payment succeeds |
| 8 | Dispense Products | Machine dispenses selected products and returns change |
| 9 | Low Stock Alert | If inventory falls below threshold, admin is notified |
| 10 | Reset | Machine returns to idle state for next transaction |

---

## Entities

| Entity | Properties | Description |
|--------|-----------|-------------|
| **Product** | `id` (String), `name` (String), `type` (ProductType), `price` (double) | Represents items available in the vending machine |
| **Money** | `type` (MoneyType), `amount` (double) | Represents payment denomination |
| **Admin** | `id` (String), `name` (String) | Observer who receives low inventory notifications |
| **Observer** | Interface | Contract for notification recipients |
| **Observable** | Interface | Contract for subjects that notify observers |

---

## Enums

| Enum | Values | Purpose |
|------|--------|---------|
| **MoneyType** | `COIN`, `CASH` | Defines accepted payment types |
| **ProductType** | `COOKIE`, `CHIPS`, `BAR`, `DRINK` | Categorizes available products |

---

## Services & Core Functionalities

| Service | Responsibilities | Key Methods |
|---------|-----------------|-------------|
| **VendingMachine** | Central coordinator implementing State pattern | `selectProduct()`, `deselectProduct()`, `gotoPayment()`, `addMoney()`, `makePayment()`, `dispenseProducts()`, `reStock()` |
| **InventoryService** | Manages product stock and observer notifications | `reStock()`, `isAvailable()`, `updateQuantity()`, `notifyObservers()` |
| **VendingMachineState** | Defines state behavior contract | `selectProduct()`, `deselectProduct()`, `gotoPayment()`, `addMoney()`, `makePayment()`, `dispenseProducts()` |
| **IdleState** | Handles product selection phase | Product selection and deselection, transition to payment |
| **TransactionState** | Manages payment processing | Money addition, payment validation, transition to dispensing |
| **DispensingState** | Controls product dispensing | Inventory update, change calculation, reset to idle |

---

## Critical Sections

| Area | Concurrency Concern | Synchronization Strategy |
|------|-------------------|-------------------------|
| **Inventory Updates** | Multiple threads restocking/purchasing simultaneously | `synchronized` methods in `InventoryService` |
| **Payment Processing** | Concurrent payment attempts | `synchronized` on `addMoney()` and `makePayment()` in `VendingMachine` |
| **Product Dispensing** | Simultaneous dispensing operations | `synchronized` on `dispenseProducts()` |
| **Amount Tracking** | Race conditions in wallet amount updates | `synchronized` setter for `addedAmount` |
| **Product Selection** | Concurrent add/remove from cart | Thread-safe `CopyOnWriteArrayList` for `selectedProducts` |
| **Inventory Storage** | Concurrent map access | `ConcurrentHashMap` for product inventory |

---

## Exceptions

| Exception | Scenario | Handling |
|-----------|----------|----------|
| **InsufficientFundsException** | Payment amount less than total cost | Prompt user to add more money |
| **OutOfStockException** | Selected product unavailable in sufficient quantity | Notify user and prevent transaction |
| **InvalidStateException** | Operation not allowed in current state | Log error and reject operation |

---

## Utilities

| Utility Class | Purpose | Key Method |
|--------------|---------|------------|
| **IdGenerator** | Generates unique product identifiers | `generateId()` - Returns unique ID using `AtomicLong` |

---

## Design Patterns Used

| Pattern | Implementation | Purpose |
|---------|---------------|---------|
| **State Pattern** | `IdleState`, `TransactionState`, `DispensingState` implementing `VendingMachineState` | Manages vending machine behavior based on current operational state |
| **Singleton Pattern** | `VendingMachine` with double-checked locking | Ensures single machine instance across application |
| **Observer Pattern** | `Observable` interface implemented by `InventoryService`, `Observer` implemented by `Admin` | Notifies admins when inventory runs low |

---

## Questions to Ask

1. Should the system support multiple payment methods simultaneously in one transaction?
2. What is the threshold quantity for low inventory notifications?
3. How should the system handle partial refunds if a selected product becomes unavailable during payment?
4. Should there be a timeout mechanism for incomplete transactions?
5. What happens if a user cancels the transaction midway? Should money be refunded immediately?
6. Should the system maintain transaction history for auditing purposes?
7. Are there different access levels for restocking vs. money collection operations?
8. Should the system support product price updates during runtime?
9. How should the system handle denomination constraints when returning change?
10. Should multiple quantities of the same product be supported in a single transaction?
11. What is the maximum cart size limit?
12. Should expired products be tracked and removed automatically?
