# API Documentation

Base URL: `http://localhost:8080/api`

## Authentication

- `POST /auth/register` creates a user and returns a JWT.
- `POST /auth/login` authenticates a user and returns a JWT.

Use authenticated endpoints with:

```text
Authorization: Bearer <token>
```

## Books

- `GET /books`
- `GET /books?q=clean`
- `GET /books/{id}`
- `POST /books`
- `PUT /books/{id}`
- `DELETE /books/{id}`

## Students

- `GET /students`
- `GET /students/{id}`
- `POST /students`
- `PUT /students/{id}`
- `DELETE /students/{id}`

## Borrowing and Returns

- `GET /borrows`
- `POST /borrows`
- `POST /returns`

## Fines and Reports

- `GET /fines`
- `GET /fines?unpaidOnly=true`
- `POST /fines/{id}/pay`
- `GET /reports/summary`
