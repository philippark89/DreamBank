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
- Day 1
    - Initialized the project with Spring Boot
    - Designed the models
        - Customer, BankAccount, Transaction, and Login(TBD)
    - Find the resources

- Day 2
    - Created model classes and establish with JPA
    - CRUD testing through localhost
    - Added a links to move around between pages to test
    - Desgined a minimal UI

- Day 3
    - Update each controllers, each class' service, and implements.
    - Checked the Customer model CRUD went okay
    - Learning RESTful my models
    - Designed the front side

- Day 4
    - Minor updates the models to connect between models.
    - Established the database relationship between models
        - Customer has a bankaccount and it has a multiful transactions.
        - Customer (One to One) BankAccount
        - BankAccount (One to Many) Transaction
    - Tried to use UUID for Ids but decided to use auto @GeneratedValue
    - Created a CustomerRESTController

- Day 5
    - Installed the React and test out how it works and played around.
    - Used Hateoas dependency to wrap up the REST API
    - REST API domain changed to "/api/v1/customers/"
    - Each objects have a 3 different links in API,
        - customer (current page)
        - customer by id
        - customer's bankAccount

- Day 6
    - Fetching the REST API from React
    - UI updated
    - Spring security updated

- Day 7
    - Added login page error/info messages when logged in or logged out.
    - Created postLogin page that shows user duplicated main page but more menus
    - Working the duplicate pages before / after login.