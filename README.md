# DreamBank Web Application

## Author: Taeju Park

# Development Environment
- Back-end
    - Spring Boot
    - REST API
    - JPA (MariaDB)

- Front-end
    - HTML/CSS(Bootstrap 5)
    - React(Trying to apply it from previous work)

# App Description
## Banking App
- User can create the account to use the functions such as checking balance, transfer money between app users, and check their last transactions(activities).

- Models
    - Customer
    - BankAccount
    - Transaction
    - Login
    - (TBD)

# Dev Logs
- 04/04/2022 (Day 1)
    - Initialized the project with Spring Boot
    - Designed the models
        - Customer, BankAccount, Transaction, and Login(TBD)
    - Find the resources

- 04/05/2022 (Day 2)
    - Created model classes and establish with JPA
    - CRUD testing through localhost
    - Added a links to move around between pages to test
    - Desgined a minimal UI

- 04/06/2022 (Day 3)
    - Update each controllers, each class' service, and implements.
    - Checked the Customer model CRUD went okay
    - Learning RESTful my models
    - Designed the front side

- 04/07/2022 (Day 4)
    - Minor updates the models to connect between models.
    - Established the database relationship between models
        - Customer has a bankaccount and it has a multiful transactions.
        - Customer (One to One) BankAccount
        - BankAccount (One to Many) Transaction
    - Tried to use UUID for Ids but decided to use auto @GeneratedValue
    - Created a CustomerRESTController

- 04/08/2022 (Day 5)
    - Installed the React and test out how it works and played around.
    - Used Hateoas dependency to wrap up the REST API
    - REST API domain changed to "/api/v1/customers/"
    - Each objects have a 3 different links in API,
        - customer (current page)
        - customer by id
        - customer's bankAccount

- 04/09/2022 (Day 6)
    - Fetching the REST API from React
    - UI updated
    - Spring security updated

- 04/11/2022 (Day 7)
    - Added login page error/info messages when logged in or logged out.
    - Created postLogin page that shows user duplicated main page but more menus
    - Working the duplicate pages before / after login.

- 04/12/2022 (Day 8)
    - User can create account, login, and logout.
    - User authentication is working properly.
    - Working on User access to business models(Customer's bank account)
    - Main page separated depends on user logged in or not.