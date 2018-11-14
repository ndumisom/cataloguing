# manageUsersAndCatalogues

*1. Clone the  cataloguing**

```bash
git clone https://github.com/ndumisom/cataloguing.git
```

**2. Create Mysql database**
```bash
create database manageusersandCatalogue
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

Create user
POST -d '{"userName":"jsmith","firstName" : "John", "lastName" : "Smith"}'http://localhost:8080/api/user
Update user
PUT -d '{"firstName" : "John", "lastName" : "Doe"}' http://localhost:8080/api/user/{id}
List all users
 GET http://localhost:8080/api/user
Get User info
 GET http://localhost:8080/api/user/{id}
Create Catalogue
 POST -d '{"name":"My name","description" : "Description of name", "dateTime" : "2016-05-25 14:25:00"}' http://localhost:8080/api/user/{user_id}/name
Update Catalogue
PUT -d '{"name":"My updated name"}' http://localhost:8080/api/user/{user_id}/name/{Catalogue_id}
Delete Catalogue
DELETE http://localhost:8080/api/user/{user_id}/name/{Catalogue_id}
Get Catalogue Info
GET http://localhost:8080/api/user/{user_id}/name/{Catalogue_id}
List all Catalogues for a user
GET http://localhost:8080/api/user/{user_id}/name
