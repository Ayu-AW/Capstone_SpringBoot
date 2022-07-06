# Springboot Application
## Capstone_SpringBoot

MyLibrary is a simple web application where a user can store and retrive Books information. 

### Technologies 
* SpringBoot
* Maven
* Java Corretto 11
* Spring JPA
* MariaDB
* Spring Security
* Thymeleaf
* Lombok
* BootStrap
* HTML
* CSS
### Business Requirement
To create a basic personal library web application where users can sign up and store, retrive and view their books.
### Work-Flow
Website with links to each service
* homepage
* books 
* categoris 
* author
* publisher
### Models
* models requires:
* no args constructor
* all args constructor
* required args constructor
* setters and getter
* toString (exclude collections to avoid infinite loops)
* override equals and hashcode methods (don't use lombok here)
* helper methods

Book (@Table(name = "Books")

Field | Datatype | Description | Database Attributes
| :--- | ---: | :---: | :---:
id  | Long  | Book unique id | Primary Key
name  | String | Book Name | 100 Characters, not null
ISBN  | String | Book uiniqe code | 100 Characters, not null
description | String | Information about the book | 250 Characters 


Author(@Table(name = "authors")

Field | Datatype | Description | Database Attributes
| :--- | ---: | :---: | :---:
id  | Long  | Author unique id | Primary Key
name  | String | Author Name | 150 Characters, not null
description | String | Information about the Author | 250 Characters 

Category(@Table(name = "Catagories")

Field | Datatype | Description | Database Attributes
| :--- | ---: | :---: | :---:
id  | Long  | Category unique id | Primary Key
name  | String | Category Name | 100 Characters, not null

publisher(@Table(name = "publishers")

Field | Datatype | Description | Database Attributes
| :--- | ---: | :---: | :---:
id  | Long  | publisher unique id | Primary Key
name  | String | publisher Name | 100 Characters, not null

UsersModel(@Table(name = "users_table")

Field | Datatype | Description | Database Attributes
| :--- | ---: | :---: | :---:
id  | Integer  | User unique id | Primary Key
login  | String | user Name | not null
password | String | password to login in to the page |
email | String | email to login in to the page |

# Reguirment 2 - service layer
implements interfaces

* AuthorServices
* BookServices
* CategoryServices
* PublisherServices
* UserServices

Requirement 3 - Controllers

* AuthorController
  mapping for services
* BookController
  mapping for services
* CategoryController
  mapping for services
* publisherController
  mapping for services
* UsersController
  mapping for services
  
Requirment 4 - view using Thymeleaf
* build a template using thymeleaf fragments
