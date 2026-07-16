INSERT INTO category (id, name) VALUES
    (1, 'Programming'),
    (2, 'Database'),
    (3, 'Software Engineering');

INSERT INTO book (id, title, author, isbn, total_copies, available_copies, category_id) VALUES
    (1, 'Clean Code', 'Robert C. Martin', '9780132350884', 5, 5, 1),
    (2, 'Effective Java', 'Joshua Bloch', '9780134685991', 4, 4, 1),
    (3, 'Database System Concepts', 'Abraham Silberschatz', '9780073523323', 3, 3, 2);

INSERT INTO student (id, student_code, full_name, email, phone, department) VALUES
    (1, 'STU001', 'Sok Dara', 'dara@example.com', '010111222', 'Computer Science'),
    (2, 'STU002', 'Chan Lina', 'lina@example.com', '010333444', 'Information Systems');
