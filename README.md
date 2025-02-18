# CAREPLUS-ECOM-WEBAPP
# CarePlus – Online Medicine Ordering Web App

## 📌 Overview
CarePlus is a web-based application designed for seamless online medicine ordering. It provides a user-friendly interface for customers to browse, search, and purchase medicines while ensuring secure transactions. The system follows the **MVC design pattern** and includes **role-based access** for visitors, customers, and admins.

## 🚀 Features
- **User Management**
  - Role-based login (Visitor, Customer, Admin)
  - Customer registration & authentication (OTP validation, forgot password)
  - Account management & password change
- **Product Management (CRUD)**
  - Add, update, delete, and view medicines
  - Category-wise product filtering
- **Company Management (CRUD)**
  - Manage pharmaceutical companies
- **Category Management (CRUD)**
  - Organize medicines into categories
- **Shopping Cart**
  - Add to cart & remove items
  - Secure checkout process
- **Order Management**
  - Invoice generation & download
  - Order tracking & management
  - View order history

## 🏗️ Tech Stack
- **Frontend:** HTML, CSS, JavaScript, Bootstrap 5, AJAX, jQuery
- **Backend:** Java, JSP, Servlets, JDBC
- **Database:** MySQL
- **Server:** Tomcat 9.X

## 🏛️ Project Modules
1. **Visitor** – Browse medicines, register/login
2. **Customer** – Manage profile, account settings, change password, add to cart, place orders, view order history, download invoices
3. **Admin** – Manage products, categories, companies, users, and orders

## 📂 Installation & Setup
### Prerequisites
- **Java Development Kit (JDK) 8+**
- **Eclipse IDE** (or IntelliJ IDEA)
- **Apache Tomcat 9.X**
- **MySQL Database**

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/careplus.git
   ```
2. Open **Eclipse IDE** and import the project.
3. Configure the **MySQL database** and update `db.properties` with your credentials.
4. Add **Apache Tomcat 9.X** as a server in Eclipse.
5. Build and deploy the project on **Tomcat**.
6. Run the application and access it via a browser.

## 💡 Contribution
Contributions are welcome! Feel free to fork the repo, create a pull request, or report issues.

---

🚀 **CarePlus - Simplifying Online Medicine Ordering!**

