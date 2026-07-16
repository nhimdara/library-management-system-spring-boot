# Database Design

## Main Tables

- `users`: authentication accounts and roles.
- `student`: library student profiles.
- `category`: book categories.
- `book`: catalog records and copy counts.
- `borrow_record`: borrowing lifecycle records.
- `fine`: overdue fine records.

## Relationships

- One `category` has many `book` records.
- One `student` has many `borrow_record` records.
- One `book` has many `borrow_record` records.
- One `borrow_record` has zero or one `fine`.

## Rules

- A book can be borrowed only when `available_copies > 0`.
- A student can have at most three active borrow records.
- The default due date is 14 days after borrowing.
- Fines are calculated at `1.00` per overdue day.
