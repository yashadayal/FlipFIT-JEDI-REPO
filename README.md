# FlipFit

## Problem Statement

Design a UI and a backend system for Flipkart's new enterprise application, FlipFit, which aims to enter the fitness space by partnering with gyms across Bangalore.

### Requirements for Beta Launch

- Multiple centers in Bangalore, each with fixed time slots.
- Each center has 'n' slots of an hour each.
- User operations:
  - Register onto the platform
  - View gym's availability/unavailability for a particular day and slot at a center
  - Book a workout if seats are available

### User Stories

1. **View All Centers:** Display details of all centers in a given city.
2. **Book a Slot:** Allow users to successfully book a slot at a specific center.
3. **Replace Booking:** Automatically remove old booking if user books another gym in the same slot.
4. **Error Handling:** Show error if user tries to book a slot already booked by another user.
5. **Prevent Overbooking:** Ensure no scenario of overbooking.

### Bonus Stories

- **View Plan by Day:** View user's plan based on input day.
- **Cancel Booking:** Allow cancellation of workout bookings.
- **Waitlist Management:** Maintain a waiting list when seats are filled and notify waitlisted candidates upon availability.
- **Nearest Time Slot:** Return nearest time slot for the same date/workout/center combination, considering user's existing bookings.

## General Guidelines

- **Platform:** Running UI and backend on Flipkart Platform.
- **Architecture:** Microservices architecture.
- **Data Storage:** Use of databases for center and booking information; no in-memory storage.
- **Modularity:** Design with modularity and interfaces in mind.
- **Quality Assurance:** Ensure Sonar static analysis passes for the code.
- **Monitoring:** Emit metrics & logs from the code.
- **UI:** Provide an intuitive UI interface.
- **Bonus Features:** Implement all bonus features.
- **SDLC:** Follow Git Commits SDLC - PR, PR review.
- **Documentation:** Provide Confluence documentation.
- **Presentation:** Prepare a presentation for the project.

