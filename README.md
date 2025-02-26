In collaboration with:

https://github.com/Yeeen0822


# Product Launch Event Management System
This system is designed to manage product launch events efficiently through two user interfaces: Administrator and Participant.

## Object-Oriented Programming (OOP) Concepts in the Event Management System
### 1. Inheritance (Promotes Code Reusability)
Super Class: Person

Child Classes: Organizer, Participant, Admin

Super Class: Payment

Child Classes: Cash, Card

Super Class: Event

Child Classes: PhoneEvent, CarEvent

### 2. Abstraction (Hides Implementation Details)
The Person class is abstract to prevent direct instantiation.
### 3. Interface Implementation
Comparable Interface: Implemented for sorting participant names, improving the readability of the registration report.
### 4. Polymorphism (Method Overriding & Dynamic Binding)
Event Objects in ArrayList: Can be either PhoneEvent or CarEvent.
Method Overriding:
calcFees() method from Event is overridden in PhoneEvent and CarEvent.
### 5. Encapsulation (Data Hiding & Security)
Object attributes are set to private to ensure proper data hiding and prevent unauthorized access.


## Key Features:
### Event Booking & Payment:

Organizers book events through an administrator, providing event details on a printed form.

Payment is required, with charges based on venue, decoration, number of products, and promoters.

Bookings must be made at least 15 days in advance.

Paid bookings can be canceled with a 50% refund within 3 working days.

### Participant Registration & Payment:

Registration is done via a kiosk on event day.

Only paid events are available for registration.

VIP seat: RM500, Normal seat: RM350.

No refunds or cancellations. Each participant can only purchase one ticket.

### Administrator Features:

Admin Login & Profile Management: Secure access with ID and password, password recovery via IC verification.

Event Management: Create, update, and cancel event bookings.

Analytics & Reports: View booking statistics, event registration reports, revenue, location-based analytics, cancellations, and payment analytics.
