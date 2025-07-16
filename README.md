# Courses Management Application

## Description

The **Courses Management App** is a web-based application that allows teachers to manage courses, students, and statistics. Key features include:

- Create, update, and delete courses
- Manage student records per course
- Add and modify grades (project, final exam)
- View statistics per course

---

## Development Team

- Angeliki Gkavardina, ID: 4042 (Scrum Master)
- Dimitrios Balderanis, ID: 4116
- Ioanna Kokkali, ID: 4268  
**Product Owner:** A. Zarras

---

## Features (Use Cases)

| Use Case             | Description                                                              |
|----------------------|--------------------------------------------------------------------------|
| **UC1: Login**        | Teacher logs into the system with username and password                 |
| **UC2: ShowCourseList** | Displays list of courses with options to create/update/delete         |
| **UC3: ChangeCourse** | Create or update a course                                                |
| **UC4: ShowStudentList** | View students enrolled in a course and manage them                 |
| **UC5: ChangeStudent** | Create or update student details and grades                             |
| **UC6: CalculateStatistics** | Display performance statistics per course                     |

---

## Technologies

- Backend: Java με Spring Boot 2.6.7
- Build tool: Maven
- View layer: Thymeleaf (HTML templates)
- Database: MySQL 
- Persistence: Spring Data JPA
- Security: Spring Security
- Testing: Spring Boot Test, Spring Security Test
- Math utilities: Apache Commons Math3
- Java Version: 11
