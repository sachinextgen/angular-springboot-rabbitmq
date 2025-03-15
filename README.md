# Angular + Spring Boot + RabbitMQ 

## Setup Instructions

### 🐇 RabbitMQ
Run RabbitMQ locally or via Docker:
```cmd
docker pull rabbitmq:4.0.7-management (pulls rabbitMQ docker image from docker hub to docker desktop)
docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:4.0.7-management (To run container of docker image)
```

### 🔥 Backend (Spring Boot)
- Navigate to `backend-springboot/`
- Run with `mvn spring-boot:run`
OR
docker build -t sachinextgen/springbootrabbitmq:0.0.1 . (To create Image backend application)
docker run --rm -it --name springbootrabbitmq -p <host-port>:<container:port> <image-id>

### ⚡ Frontend (Angular)
- Navigate to `frontend-angular/`
- Run with `ng serve`

### ➡️ Flow
Angular → Spring Boot → RabbitMQ → Spring Boot Listener