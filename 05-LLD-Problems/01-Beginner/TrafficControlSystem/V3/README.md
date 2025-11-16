# Traffic Control System V3

## Problem Statement

The traffic signal system should control the flow of traffic at an intersection with multiple roads. The system should support different types of signals, such as red, yellow, and green. The duration of each signal should be configurable and adjustable based on traffic conditions. The system should handle the transition between signals smoothly, ensuring safe and efficient traffic flow. The system should be able to detect and handle emergency situations, such as an ambulance or fire truck approaching the intersection. The system should be scalable and extensible to support additional features and functionality.

## Happy Flow

1. System initialization with multiple roads and traffic signals
2. Each road's signal starts at RED by default
3. Traffic control cycle begins: current road signal transitions from RED → GREEN → YELLOW → RED
4. Next road in queue gets its turn for signal transition
5. Emergency situation arises on a specific road
6. System pauses normal cycle and handles emergency with AtomicInteger counter
7. Multiple emergencies can be tracked simultaneously
8. Once emergencies are cleared, system resumes normal cycle
9. Process continues in round-robin fashion across all roads

## Entities

| Entity | Properties | Description |
|--------|-----------|-------------|
| **Road** | `id: String`<br>`name: String`<br>`trafficLight: TrafficSignal` | Represents a road at the intersection with an associated traffic signal |
| **TrafficSignal** | `id: String`<br>`currSignal: SignalType` | Manages the current signal state (RED, GREEN, YELLOW) |
| **SignalConfig** | `redDuration: int`<br>`greenDuration: int`<br>`yellowDuration: int` | Abstract base class for signal timing configuration |
| **GlobalSignalConfig** | Inherits from SignalConfig | Global configuration applied to all traffic signals |
| **TrafficSignalControl** | `roads: Deque<Road>`<br>`executor: ScheduledExecutorService`<br>`emergencySituationCheck: AtomicInteger`<br>`globalSignalConfig: SignalConfig` | Singleton service managing the traffic control system |

## Enums

| Enum | Values |
|------|--------|
| **SignalType** | `RED`, `GREEN`, `YELLOW` |

## Services & Core Functionalities

| Service | Responsibilities | Key Methods |
|---------|-----------------|-------------|
| **TrafficSignalControl** | Central control system managing all traffic signals | `getInstance()` - Returns singleton instance<br>`addRoad(Road)` - Registers a road<br>`startSystem()` - Initiates the traffic control cycle<br>`singleCycle()` - Executes one complete signal cycle<br>`startEmergency(Road)` - Triggers emergency mode<br>`clearEmergency()` - Clears emergency status<br>`setGlobalSignalConfig(SignalConfig)` - Updates timing configuration |

### Key Implementation Details

- Uses `ConcurrentLinkedDeque` for thread-safe road queue management
- `ScheduledExecutorService` with fixed delay for continuous signal cycling
- Round-robin scheduling using queue rotation
- Emergency handling with `AtomicInteger` for concurrent emergency tracking
- Signal transitions follow strict sequence: GREEN → YELLOW → RED

## Critical Sections

| Critical Section | Synchronization Mechanism | Purpose |
|-----------------|--------------------------|---------|
| **Signal Cycle Execution** | `synchronized singleCycle()` | Prevents concurrent modification of signal states during transitions |
| **Emergency Counter** | `AtomicInteger emergencySituationCheck` | Thread-safe increment/decrement for multiple concurrent emergencies |
| **Singleton Initialization** | Double-checked locking | Ensures single instance creation in multi-threaded environment |
| **Road Queue Operations** | `ConcurrentLinkedDeque` | Thread-safe queue operations for road management |

### Concurrency Considerations

- Emergency situations can occur while signals are transitioning
- System checks emergency status between each signal state change
- If emergency detected, current road is re-queued at front and cycle pauses
- Multiple emergencies are tracked via counter, not boolean flag

## Exceptions

No custom exceptions are currently implemented in V3. Potential exceptions to consider:

- `InvalidRoadException` - When attempting to add duplicate or invalid road
- `EmergencyHandlingException` - For emergency management failures
- `SignalTransitionException` - For signal state transition errors

## Utilities

| Utility Class | Methods | Purpose |
|--------------|---------|---------|
| **IdUtil** | `generateRoadId()` - Returns unique road ID (format: RID_N)<br>`generateTSId()` - Returns unique traffic signal ID (format: TSID_N) | Thread-safe ID generation using `AtomicLong` counters |

## Design Patterns Used

| Pattern | Implementation | Benefit |
|---------|---------------|---------|
| **Singleton** | `TrafficSignalControl` with double-checked locking | Ensures single point of control for the entire system |
| **Dependency Injection** | `Road` accepts `TrafficSignal` via constructor | Reduces tight coupling between Road and TrafficSignal |
| **Template Method** | `SignalConfig` abstract class with `getSignalDuration()` | Allows flexible configuration strategies (Global, Per-Road, etc.) |
| **Strategy Pattern** | `SignalConfig` abstraction | Enables different timing strategies without modifying core logic |

## Questions to Ask

1. Should signal duration configuration be global for all lights or vary for each individual light?
2. What is the maximum number of concurrent emergencies the system should support?
3. Should there be priority levels for different types of emergencies (ambulance vs. fire truck)?
4. What happens if an emergency lasts longer than expected? Should there be a timeout?
5. Should the system support dynamic addition/removal of roads at runtime?
6. Is there a requirement for logging and monitoring traffic flow statistics?
7. Should pedestrian signals be considered as part of the system?
8. What is the expected behavior if all roads have simultaneous emergencies?
9. Should the system support time-based signal adjustments (rush hour vs. normal hours)?
10. Is there a need for manual override capabilities for traffic operators?
