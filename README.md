# DreamBank Web Application

## Author: Taeju Park

# Contents
- [Develop Environment](#develop-environment)
    - [Technical Architecture](/img/technical%20architecture.png)   
    - [Page Flowchart](/img/Page_flowchart.png)
    - [Schema Diagram](/img/schema%20diagram.png)
    - [Wire Frame](/img/wireframe.pdf)
- [Case Study Rubric](https://docs.google.com/spreadsheets/d/1SBBuJB4l3o45Fplam5pSzR35PsIaDP4kSBs5LpcZHOk/edit?usp=sharing)
- [App Description](#app-description)
- [User Story](#user-story)
- [Business Models](#business-models)
- [Daily Progress](#daily-progress)

# Develop Environment
- Back-end
    - Spring Boot
    - RESTful API
    - JPA (MariaDB)

- Front-end
    - HTML/CSS(Bootstrap 5)
    - Thymeleaf
    - JavaScript
    - ~~React(Will be applied once MVP done)~~

# App Description
## Simple Banking App
- User can create the account to use the functions such as checking balance, create the transaction such as either deposit or withdraw from their balance, and check their transactions.

- Each user have a balance and it will be generated randomly in range of $100 ~ $10,000 when user registered an account.

# User Story
- As a user, I want to create the account so I can have a bank account.
- As a user, I want to login to my account so I can use my own account.

# Business Models
## Models
- Customer
- BankAccount
- Transaction
- User
- Role
- ~~(TBD)~~



# Daily Progress
- 04/26/2022 (Day 18) (Deployed)
    - Refactoring codes
    - Test functions

- 04/25/2022 (Day 17) (Total 99.9%)
    - Refactoring codes
    - Added 8 different Junit cases
    - Javascript work
    - Preparing presentation
    - Double checking if the app has any bugs

- 04/22/2022 (Day 16) (BackEnd 99%, FrontEnd 99%)
    - JUnit able to connect with JPA
    - todo list:
        - Create more JUnit cases
        - Javascript to apply on front side
        - Create RESTcontroller for POST/DELETE mapping

- 04/21/2022 (Day 15) (BackEnd 98%, FrontEnd 98%)
    - MVP done
    - Refactoring the codes
    - Sql data preload (still working on it)
    - RESTController (working on POST/DELETE mapping)

- 04/20/2022 (Day 14) (BackEnd 98%, FrontEnd 95%)
    - ADMIN page have menus that REST API, Customers, and Transactions.
    - REST API shows the structure of entire models
    - Customers page in ADMIN can either update or delete the specific customer.
    - Transactions page in ADMIN can either update or delete the specific transaction.
    - Updated User's balance page that display the current balance with `NumberFormat.getCurrencyInstance()`.

- 04/19/2022 (Day 13) (BackEnd 97%, FrontEnd 90%)
    - Balance page, available balance is auto updating when transaction is made by user.
    - Withdraw / deposit is handling on balanceController. (Sometimes it occurs the double type overflow)
    - Activity page, transactions are displaying as in Table by 10 items at once.
    - Working in Admin view.
    - REST API.

- 04/18/2022 (Day 12) (BackEnd 92%, FrontEnd 70%)
    - Balance page 90% done.
    - Transaction function added and working okay so far.
    - Working Activity page throught transactions.

- 04/14/2022 (Day 11) (BackEnd 88%, FrontEnd 60%)
    - Account page done.
    - Balance page, manage to pull transaction object throught user input from balance page.
    - Learned how the Thymeleaf communicate between MVC.

- 04/14/2022 (Day 10) (BackEnd 85%, FrontEnd 50%)
    - User have 3 different menus to check their account information, balance, activities.
    - Was able to pull data by current session email address.

- 04/13/2022 (Day 9)
    - User model and Customer(Business side) is working properly.
    - Modifying Admin page that can pull the whole customer list and have a action either delete or update the specific customer.
    - Working on CRUD operation each roles

- 04/12/2022 (Day 8)
    - User can create account, login, and logout.
    - User authentication is working properly.
    - Working on User access to business models(Customer's bank account)
    - Main page separated depends on user logged in or not.

- 04/11/2022 (Day 7)
    - Added login page error/info messages when logged in or logged out.
    - Created postLogin page that shows user duplicated main page but more menus
    - Working the duplicate pages before / after login.

- 04/09/2022 (Day 6)
    - Fetching the REST API from React
    - UI updated
    - Spring security updated

- 04/08/2022 (Day 5)
    - Installed the React and test out how it works and played around.
    - Used Hateoas dependency to wrap up the REST API
    - REST API domain changed to "/api/v1/customers/"
    - Each objects have a 3 different links in API,
        - customer (current page)
        - customer by id
        - customer's bankAccount

- 04/07/2022 (Day 4)
    - Minor updates the models to connect between models.
    - Established the database relationship between models
        - Customer has a bankaccount and it has a multiful transactions.
        - Customer (One to One) BankAccount
        - BankAccount (One to Many) Transaction
    - Tried to use UUID for Ids but decided to use auto @GeneratedValue
    - Created a CustomerRESTController

- 04/06/2022 (Day 3)
    - Update each controllers, each class' service, and implements.
    - Checked the Customer model CRUD went okay
    - Learning RESTful my models
    - Designed the front side

- 04/05/2022 (Day 2)
    - Created model classes and establish with JPA
    - CRUD testing through localhost
    - Added a links to move around between pages to test
    - Desgined a minimal UI

- 04/04/2022 (Day 1)
    - Initialized the project with Spring Boot
    - Designed the models
    - Customer, BankAccount, Transaction, and Login(TBD)
    - Find the resources