# Gym Management System

A Java Swing based gym membership manager with support for regular and premium members.

## Overview

This project provides a desktop GUI to manage gym member records and operations such as:
- adding members
- activating/deactivating memberships
- marking attendance
- upgrading regular plans
- handling premium payments and discounts
- saving member data to a text file

## Tech Stack

- Java
- Java Swing (GUI)
- Core Java collections and file I/O

## Project Structure

- `GymGui.java`: Main GUI application and event handling.
- `GymMember.java`: Abstract base class for shared member data and behavior.
- `RegularMember.java`: Regular member implementation with plan upgrades.
- `PremiumMember.java`: Premium member implementation with payment and discount logic.

## Features

### Member Management

- Add Regular Members
- Add Premium Members
- Activate Membership by member ID
- Deactivate Membership by member ID
- Display member details by member ID
- Clear input fields

### Attendance and Loyalty

- Mark attendance for active members only
- Loyalty points are updated when attendance is marked:
  - Regular Member: +5 points per attendance
  - Premium Member: +10 points per attendance

### Regular Member Features

- Default plan: Basic
- Available plans:
  - Basic: 6500
  - Standard: 12500
  - Deluxe: 18500
- Upgrade plan through GUI

### Premium Member Features

- Premium charge: 20000
- Pay due amount in parts or full
- Calculate 10% discount after full payment
- Revert premium member state

### File Operations

- Save all member details to `MemberDetails.txt`
- Read and display data from `MemberDetails.txt`

## How to Run (Windows PowerShell)

1. Open PowerShell in the project folder.
2. Compile:

```powershell
javac GymMember.java RegularMember.java PremiumMember.java GymGui.java
```

3. Run:

```powershell
java GymGui
```

## Notes

- All classes are in the default package (no package declaration is active).
- Data is kept in memory while the app is running.
- Use the Save button to persist current member data to `MemberDetails.txt`.

## Author

Nigam Niroula
