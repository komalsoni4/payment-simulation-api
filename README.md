# 💳 Payment Simulation API (Spring Boot)

A lightweight Spring Boot API to simulate payment flows (card transactions). Designed for learning backend systems, REST APIs, and Docker.

---

## 🚀 Features

- Simulates card-based payment transaction flow
- Validates card number, expiry, amount
- Generates transaction IDs
- REST API: POST /api/payment
- GET transaction by ID
- Includes in-memory transaction store
- Swagger integration (optional)
- Dockerized setup
- CI/CD via GitHub Actions (optional)

---

## 🛠 Tech Stack

- Java 17
- Spring Boot
- Maven
- REST API
- Docker

---

## 📦 API Endpoints

### `POST /api/payment`

**Request Body:**
```json
{
  "cardNumber": "4111111111111111",
  "expiryDate": "12/26",
  "amount": 250.00
}
