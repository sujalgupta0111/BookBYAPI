# 📚 Book Admin Module

## 🚀 Overview
The **Book Admin Module** is a robust application designed for managing books, supporting various CRUD (Create, Read, Update, Delete) operations. It seamlessly connects with a **MySQL database**, utilizes **Hibernate** for ORM, and follows the **RESTful architecture** for API communication. The frontend is developed using **Thymeleaf**.

## 🏗️ Technologies Used
- **Backend**: Java, Spring Boot, Hibernate
- **Frontend**: Thymeleaf, HTML, CSS, JavaScript
- **Database**: MySQL
- **API Communication**: RESTful architecture

## 🔧 Features
✅ **CRUD Operations** - Add, View, Update, and Delete books 📖  
✅ **MySQL Database Integration** 🛢️  
✅ **Hibernate ORM** - Efficient database interactions 🔄  
✅ **RESTful API** - Smooth communication between frontend and backend 🌐  
✅ **Thymeleaf for UI Rendering** 🎨  
✅ **Download Books** - Option to download book details 📥  

## 🛠️ Installation & Setup
### 1️⃣ Prerequisites
Ensure you have the following installed:
- Java (JDK 11 or higher) ☕
- MySQL Server 🛢️
- Maven 🏗️
- Spring Boot 🌱

### 2️⃣ Clone the Repository
```bash
git clone https://github.com/your-repo/book-admin-module.git
cd book-admin-module
```

### 3️⃣ Configure the Database
Create a MySQL database and update **`application.properties`**:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/book_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 4️⃣ Build & Run the Application
```bash
mvn clean install
mvn spring-boot:run
```



## 🎨 Frontend
The frontend is built using **Thymeleaf**, ensuring smooth dynamic rendering within Spring Boot applications. The UI provides an intuitive interface for managing books effortlessly.



## 📌 Future Enhancements
🔹 Add search & filter options 🔍  
🔹 Implement role-based authentication 🔐  
🔹 Improve UI with Bootstrap 🎨  
🔹 Export books as PDF 📄  

## 🤝 Contributing
Contributions are welcome! Feel free to fork the repo and submit a pull request.

## 📄 License
This project is licensed under the MIT License.

Happy coding! 🎉

