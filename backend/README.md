# Library Management API 📚

A modern, production-ready Spring Boot REST API for managing library operations including user authentication, book catalog management, member tracking, book borrowing/returns, and analytics reporting.

---

## 🚀 Tech Stack

- **Framework**: Spring Boot 3.3.5 (Java 17+)
- **Security**: Spring Security + JWT Authentication
- **Database**: PostgreSQL (Production/Dev) & H2 (In-memory optional)
- **Database GUI**: pgAdmin 4
- **ORM**: Spring Data JPA / Hibernate
- **Build Tool**: Apache Maven
- **Environment Management**: `spring-dotenv` (`.env` files)
- **Containerization**: Docker & Docker Compose

---

## 📁 Project Structure

```
library-management-api/
│
├── .env                       # Environment configuration (DB credentials, JWT secrets)
├── .env.example               # Template environment configuration
├── docker-compose.yml         # Docker setup for PostgreSQL & pgAdmin
├── pom.xml                    # Maven dependencies
│
└── src/main/java/com/library/
    ├── LibraryApplication.java
    │
    ├── controller/            # REST API endpoints
    │   ├── AuthController.java
    │   ├── MemberController.java
    │   ├── BookController.java
    │   ├── BorrowController.java
    │   ├── ReturnController.java
    │   └── ReportController.java
    │
    ├── service/               # Business logic & services
    │   ├── AuthService.java
    │   ├── MemberService.java
    │   ├── BookService.java
    │   ├── BorrowService.java
    │   ├── ReturnService.java
    │   └── ReportService.java
    │
    ├── repository/            # Spring Data JPA Repositories
    │   ├── UserRepository.java
    │   ├── MemberRepository.java
    │   ├── BookRepository.java
    │   ├── BorrowRepository.java
    │   ├── ReturnRepository.java
    │   └── CategoryRepository.java
    │
    ├── model/                 # JPA Domain Entities
    │   ├── User.java
    │   ├── Member.java
    │   ├── Book.java
    │   ├── Category.java
    │   ├── Borrow.java
    │   ├── Return.java
    │   ├── Role.java
    │   └── BorrowStatus.java
    │
    ├── dto/                   # Request/Response Data Transfer Objects
    ├── exception/             # Custom exceptions & GlobalExceptionHandler
    ├── security/              # JWT filter, UserDetailsService & TokenProvider
    └── config/                # Security & application configuration
```

---

## 🛠️ Environment Configuration (`.env`)

Configuration parameters are loaded automatically from `.env`:

```env
# Application Configuration
APP_NAME=library-management-api
APP_ENV=local
SERVER_PORT=8080

# Database Configuration (PostgreSQL)
DB_CONNECTION=pgsql
DB_HOST=127.0.0.1
DB_PORT=5432
DB_DATABASE=librarydb
DB_USERNAME=postgres
DB_PASSWORD=postgres

# PostgreSQL JDBC Connection
DB_URL=jdbc:postgresql://127.0.0.1:5432/librarydb
DB_DRIVER=org.postgresql.Driver
JPA_DIALECT=org.hibernate.dialect.PostgreSQLDialect

# Security & JWT Configuration
JWT_SECRET=9a2f8c4e1b7d5a3f6e8c0b2d4f6a8c1e3b5d7f9a2c4e6b8d0f2a4c6e8b0d2f4a
JWT_EXPIRATION_MS=86400000

# CORS
CORS_ALLOWED_ORIGINS=http://localhost:3000,http://localhost:5173,http://localhost:4200
```

---

## 🐳 Running Database & pgAdmin via Docker

Start PostgreSQL and pgAdmin 4 in containers:

```bash
docker compose up -d
```

- **PostgreSQL**: `localhost:5432` (`librarydb`)
- **pgAdmin 4**: [http://localhost:5050](http://localhost:5050)
  - **Login Email**: `admin@admin.com`
  - **Password**: `admin`

---

## ⚡ How to Run

### 1. Prerequisites
- JDK 17 or Java 21
- Maven 3.8+
- PostgreSQL database running (or Docker container)

### 2. Build and Run Application

```bash
# Clean and compile
mvn clean compile

# Run Spring Boot app
mvn spring-boot:run
```

The application will start on **`http://localhost:8080`**.

---

## 🔌 API Endpoints Summary

### Authentication (`/api/auth`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/auth/register` | Register a new user |
| `POST` | `/api/auth/login` | Login and receive JWT token |

### Members (`/api/members`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/members` | Get all members |
| `POST` | `/api/members` | Create new member |
| `GET` | `/api/members/{id}` | Get member details |
| `PUT` | `/api/members/{id}` | Update member profile |
| `DELETE` | `/api/members/{id}` | Remove member |

### Books & Categories (`/api/books`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/books` | List & search books |
| `POST` | `/api/books` | Add a new book |
| `GET` | `/api/books/{id}` | Get book details |
| `PUT` | `/api/books/{id}` | Update book details |
| `DELETE` | `/api/books/{id}` | Delete book |

### Borrows (`/api/borrows`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/borrows` | Issue a book to a member |
| `GET` | `/api/borrows/overdue` | List all overdue borrowings |

### Returns (`/api/returns`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/returns` | Process a book return & calculate fines |

### Reports (`/api/reports`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/reports/dashboard` | Get system summary stats |

---

## 📜 License

This project is open-source and available under the [MIT License](LICENSE).
