# Personal Finance Tracker API

A backend REST API built with Spring Boot that lets users upload their bank statement CSVs and get insights into their spending — by category, merchant, and month.

---

## What it does

- Upload a bank statement CSV → Spring Batch parses, categorizes, and stores every transaction
- JWT-secured endpoints — every request requires a valid token
- Analytics API — monthly spend, category breakdown, top merchants, 6-month trend
- Full multi-user support — every user sees only their own data

---

## Tech Stack

| Layer | Technology |
|---|---|
| Framework | Spring Boot 3 |
| Security | Spring Security + JWT |
| Batch Processing | Spring Batch |
| ORM | Spring Data JPA + Hibernate |
| Database | PostgreSQL |
| Containerization | Docker + Docker Compose |
| API Docs | Swagger UI |
| Build Tool | Maven |

---

## Project Structure

```
src/main/java/com/example/finance_tracker/
├── batch/          # Spring Batch reader, processor, writer, config
├── config/         # Security config, app-level config
├── controller/     # REST controllers
├── dto/            # Request/Response DTOs
├── entity/         # JPA entities (User, Transaction)
├── exception/      # Global exception handler
├── repository/     # Spring Data JPA repositories
├── scheduler/      # Scheduled jobs
├── security/       # JWT filter, UserDetailsService
├── service/        # Business logic
└── util/           # CSV parser, category mapper
```

---

## Getting Started

### Prerequisites

- Java 17+
- Docker + Docker Compose
- Maven

### Run with Docker

```bash
# 1. Clone the repo
git clone https://github.com/blessyparida/finance-tracker.git
cd finance-tracker

# 2. Create a .env file (see .env.example)
cp .env.example .env

# 3. Start everything
docker-compose up --build
```

App runs at `http://localhost:8080`

### Run locally (without Docker)

```bash
# Make sure PostgreSQL is running locally, then:
./mvnw spring-boot:run
```

---

## Environment Variables

Create a `.env` file in the root with the following:

```env
DB_URL=jdbc:postgresql://localhost:5432/finance_db
DB_USERNAME=your_db_user
DB_PASSWORD=your_db_password
JWT_SECRET=your_jwt_secret_key
```

---

## API Docs

Swagger UI is available at:

```
http://localhost:8080/swagger-ui/index.html
```

All endpoints are documented and testable from the browser.

---

## Core API Endpoints

### Auth
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/register` | Register a new user |
| POST | `/api/auth/login` | Login and receive JWT token |

### Transactions
| Method | Endpoint | Description |
|---|---|---|
| POST | `/transactions` | Add a transaction manually |
| GET | `/api/transactions` | Get all transactions |
| POST | `/upload` | Upload bank statement CSV |

### Analytics
| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/insights/monthly` | Total spend by month |
| GET | `/api/insights/category` | Spend breakdown by category |
| GET | `/api/insights/top-expenses` | Top merchants by spend |
| GET | `/api/insights/trend` | 6-month spending trend |

> All endpoints except `/api/auth/**` require a Bearer token in the Authorization header.

---

## CSV Format

The upload endpoint accepts CSV files in the following format:

```csv
date,description,amount,type
2024-01-15,Swiggy,250.00,debit
2024-01-16,Salary,50000.00,credit
2024-01-17,Uber,180.00,debit
```

Spring Batch reads the file in chunks, auto-categorizes each transaction by merchant name, and bulk inserts into the database. Malformed rows are skipped without stopping the job.

---

## Upcoming

- Redis caching for analytics endpoints
- Nightly budget alert emails via Spring Mail
- Full Docker deployment setup

---

## Author

**Blessy Parida**  
[GitHub](https://github.com/blessyparida) · [LinkedIn](https://linkedin.com/in/blessy-parida-51040b306)
