# Library Management System

Full-stack library management scaffold with a Spring Boot backend and static HTML/CSS/JavaScript frontend.

## Structure

- `backend/`: Spring Boot REST API.
- `frontend/`: static user and admin pages.
- `database/`: SQL schema and sample data.
- `docs/`: API, database, user, and report documentation.

## Backend

```bash
cd backend
mvn spring-boot:run
```

Run tests:

```bash
cd backend
mvn test
```

## Frontend

Open `frontend/index.html` directly in a browser, or serve the folder with a static server.

The frontend expects the backend at:

```text
http://localhost:8080/api
```

## Authentication

Register or log in through `/api/auth/**`, then send the returned JWT as:

```text
Authorization: Bearer <token>
```

## Docker

```bash
docker compose up --build
```
