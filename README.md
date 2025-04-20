# Customer Management System (Customers)

This project is a simple Customer Management System (CRUD - Create, Read, Update, Delete) web application developed using Spring Boot. The application allows users to list customers, add new customers, view details of existing customers, and update their information.

## Project Structure

The project follows a standard Maven and Spring Boot project structure:

Customers/
├── .idea/
├── .mvn/
│   └── wrapper/
│       └── maven-wrapper.properties
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/customers/
│   │   │       ├── Controller.java
│   │   │       ├── Customer.java
│   │   │       ├── CustomersApplication.java
│   │   │       └── Repository.java
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       │   ├── addCustomer.html
│   │       │   ├── customers.html
│   │       │   ├── detailCustomer.html
│   │       │   └── updateCustomer.html
│   │       └── application.properties
│   └── test/
│       └── java/
├── target/
│   ├── classes/
│   └── generated-sources/
├── .gitattributes
├── .gitignore
├── customers.json
├── HELP.md
├── mvnw
├── mvnw.cmd
└── pom.xml

## Technologies Used

*   **Java**: The main programming language. (See version in `pom.xml`)
*   **Spring Boot**: Application framework.
*   **Spring Web (MVC)**: For the web layer and RESTful services.
*   **Thymeleaf (Assumed)**: Server-side HTML template engine (based on the `.html` files in `templates`).
*   **Maven**: Project management and build tool.

## Setup and Running

1.  **Clone the Project:**
    ```bash
    git clone <repository_url>
    cd Customers
    ```


2.  **Compile the Project and Download Dependencies:**
    *   Linux/macOS:
        ```bash
        ./mvnw clean install
        ```
    *   Windows:
        ```bash
        mvnw.cmd clean install
        ```

3.  **Start the Application:**
    *   Linux/macOS:
        ```bash
        ./mvnw spring-boot:run
        ```
    *   Windows:
        ```bash
        mvnw.cmd spring-boot:run
        ```

4.  **Access the Application:**
    Once the application starts successfully, open your web browser and navigate to `http://localhost:8080` (or the port specified in `application.properties` if changed).
