# 🩺 SpringBoot Medical Appointments Manager

This is a web application developed using **Spring Boot** that allows patients to register, view available doctors, and schedule or cancel medical appointments. The frontend is styled with **TailwindCSS**, and the application follows a modular structure.

## 🔧 Technologies Used

- **Java 17**
- **Spring Boot**
- **Spring MVC**
- **Spring Security**
- **Thymeleaf**
- **TailwindCSS**
- **MySQL Database**
- **JPA & Hibernate**

## ✨ Features

### 👤 User Authentication

- Registration and login functionality.
- Secure password hashing.
- Session-based authentication with Spring Security.
- Role-based access (e.g., `ROLE_PATIENT`).

### 🩻 Doctor Management

- List all available doctors.
- Filter doctors by specialty using a dropdown.
- Doctors have a defined shift (`DAY`, `NIGHT`, `MIXED`).

### 📅 Appointment Scheduling

- Patients can schedule appointments by selecting a doctor and a valid date/time.
- Validation prevents double-booking for the same doctor, date, and time.
- Appointments are assigned based on the doctor's shift.

### 📂 Patient Dashboard

- Authenticated users can view their full appointment history.
- Future appointments can be cancelled if their date hasn't passed.

### ❌ Appointment Cancellation

- Appointments can only be cancelled if they haven't expired.
- Server-side validation ensures no expired appointment can be cancelled.

### 🔐 Logout Functionality

- Users can securely log out of their session.

## 🖼️ UI & Styling

The entire HTML structure is styled using **TailwindCSS**, providing a clean and responsive user interface.

## 🗂️ Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com.medicalappointments.medicalappointmentsmanager/
│   │       ├── controllers/
│   │       ├── models/
│   │       ├── dtos/
│   │       ├── services/
│   │       ├── enums/
│   │       ├── utils/
│   │       ├── repositories/
│   │       └── config/
│   └── resources/
│       ├── templates/     <-- Thymeleaf HTML templates
```

## 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/Jesus24-Dev/SpringBoot-Medical-Appointments-Manager.git
   cd SpringBoot-Medical-Appointments-Manager
   ```

2. Run the application (e.g., via your IDE or command line):
   ```bash
   ./mvnw spring-boot:run
   ```

3. Access the app in your browser:
   ```
   http://localhost:8080
   ```


---

## 🧠 Author

**Jesús Sirit**  
GitHub: [@Jesus24-Dev](https://github.com/Jesus24-Dev)

---

## 📃 License

This project is licensed under the MIT License.
