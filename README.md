# School Management System

## Overview

The School Management System is a comprehensive solution designed to streamline and automate various aspects of educational institution management. Built on a modern microservices architecture, this system provides a scalable, maintainable, and robust platform for managing students, teachers, courses, classes, enrollments, payments, and more.

## System Architecture

This application is designed using a microservices architecture pattern with the following components:

- **Microservices**: Independent services for specific business domains
- **API Gateway**: Single entry point for all client requests
- **Service Registry**: Dynamic service discovery
- **Config Server**: Centralized configuration management
- **Database**: Each service has its own PostgreSQL database instance

```
┌─────────────┐           ┌─────────────┐
│   Client    │────────▶  │ API Gateway │
└─────────────┘           └──────┬──────┘
                                 │
                                 ▼
                         ┌───────────────┐
                         │Service Registry│
                         └───────────────┘
                                 │
         ┌────────┬─────────┬────┴─────┬─────────┬───────┐
         │        │         │          │         │       │
         ▼        ▼         ▼          ▼         ▼       ▼
┌─────────────┐ ┌─────┐ ┌────────┐ ┌────────┐ ┌─────┐ ┌─────┐
│ Config      │ │User │ │Student │ │Teacher │ │Class│ │More │
│ Server      │ │Svc  │ │Svc     │ │Svc     │ │Svc  │ │Svcs │
└─────────────┘ └─────┘ └────────┘ └────────┘ └─────┘ └─────┘
```

## Technology Stack

- **Programming Language**: Java (version 17+)
- **Framework**: Spring Boot (3.x)
- **Microservices**: Spring Cloud
- **Service Discovery**: Netflix Eureka
- **API Gateway**: Spring Cloud Gateway
- **Database**: PostgreSQL
- **Build Tool**: Maven
- **Documentation**: Swagger/OpenAPI
- **Containerization**: Docker (optional)
- **Orchestration**: Kubernetes (optional)

## Microservices

The system consists of the following microservices:

1. **Student Service**: Manages student information, registrations, and academic records
2. **Teacher Service**: Handles teacher profiles, specializations, and assignments
3. **Course Service**: Maintains course catalogs, descriptions, and prerequisites
4. **Class Service**: Manages class schedules, room assignments, and sessions
5. **Enrollment Service**: Processes student enrollments and course registrations
6. **Payment Service**: Handles payment processing and financial transactions
7. **Accounting Service**: Manages financial records, invoices, and receipts
8. **User Service**: Manages authentication, authorization, and user profiles
9. **API Gateway**: Routes client requests to appropriate services
10. **Config Server**: Centralizes configuration management
11. **Service Registry**: Facilitates service discovery using Netflix Eureka

## Prerequisites

To run this application, you need:

- Java Development Kit (JDK) 17 or higher
- Maven 3.6+
- PostgreSQL 12+
- Git
- IDE (IntelliJ IDEA, Eclipse, or VS Code recommended)
- Docker (optional, for containerization)

## Setup and Installation

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd school-system
   ```

2. **Database Setup**:
   - Install PostgreSQL if not already installed
   - Create databases for each service (details in each service's readme)
   - Configure database connection in each service's `application.properties` or through Config Server

3. **Configure Services**:
   - Update configuration in the Config Server or in each service's `application.properties`
   - Ensure correct service registry URL is set

4. **Build the Project**:
   ```bash
   mvn clean install -DskipTests
   ```

## Running the Application

1. **Start the services in the following order**:
   ```bash
   # 1. Start Service Registry
   cd service_registry
   mvn spring-boot:run

   # 2. Start Config Server
   cd ../config_server
   mvn spring-boot:run

   # 3. Start API Gateway
   cd ../api-gateway
   mvn spring-boot:run

   # 4. Start the other services
   cd ../student_service
   mvn spring-boot:run
   # Repeat for other services
   ```

2. **Access the application**:
   - Service Registry Dashboard: http://localhost:8761
   - API Gateway: http://localhost:8080
   - Swagger Documentation: http://localhost:8080/swagger-ui.html

## API Endpoints Overview

The system exposes RESTful APIs through the API Gateway. Here's a general overview of the available endpoints:

- **Student API**: `/api/students/*` - CRUD operations for student management
- **Teacher API**: `/api/teachers/*` - Endpoints for teacher management
- **Course API**: `/api/courses/*` - Course management operations
- **Class API**: `/api/classes/*` - Class scheduling and management
- **Enrollment API**: `/api/enrollments/*` - Enrollment processing endpoints
- **Payment API**: `/api/payments/*` - Payment processing operations
- **User API**: `/api/users/*` - User management and authentication

Detailed API documentation is available through Swagger at each service's `/swagger-ui.html` endpoint or centrally through the API Gateway.

## Future Enhancements

- Implement event-driven architecture using Kafka or RabbitMQ
- Add monitoring with Prometheus and Grafana
- Implement CI/CD pipeline
- Enhance security with OAuth2 and JWT
- Add reporting and analytics features
- Implement mobile application
- Add multilingual support

## Contributors

- Benoit Kekwandi - Initial work and project setup

## License

This project is licensed under the MIT License - see the LICENSE.md file for details.

