# Movie Theatre Ticket Reservation System
A movie theatre ticketing application developed for ENSF 480: Principles of Software Design. The system supports two user types with different features and privileges.

### Features
In this project our team was tasked to analyze, design, and develop a system that can be used by two group of users:

**Ordinary Users:**
- Search for movies and select specific theaters
- View available movies and showtimes
- Graphical seat selection interface
- Credit card payment processing
- Email delivery of tickets and receipts
- Ticket cancellation up to 72 hours before showtime (15% administration fee applies, credit valid for one year)

**Registered Users:**
- $20.00 annual account fee
- Saved user information (name, address, credit/debit card) in database
- No cancellation administration fee
- Early access to movie news before public announcement
- Early seat purchase: 10% of seats available on first-come, first-served basis prior to public announcements

### System Constraints
- Registered users can only purchase from 10% of available seats before public release
- Cancellations must be made at least 72 hours before showtime
- Cancellation credits expire after one year
