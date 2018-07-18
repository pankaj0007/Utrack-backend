# Utrack-backend

1. Spring  boot kick start with Maven 
2. Spring boot connectivity with Mysql database
3. Spring boot with MVC pattern
4. Implementation of JWT based Oauth Authentication


Login service to get access Token :

URL : http://localhost:8889/oauth/token

Body : grant_type=password&username=admin&password=admin

Header :

1. Authorization :  Basic dXRyYWNrQXV0aDpYWTdrbXpvTnpsMTAw   ( window.btoa('utrackAuth:XY7kmzoNzl100') : base64 encoded format of client_id:client_secret)

2. Content-Type : application/x-www-form-urlencoded

Response :

{
  "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidXRyYWNrYXV0aHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTMwMTE5ODA3LCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIiwiUk9MRV9VU0VSIl0sImp0aSI6Ijk1ZDZkMzliLTNmYjQtNDdjYy05NGE0LWUzZWE3Y2EzMDdiMSIsImNsaWVudF9pZCI6InV0cmFja0F1dGgifQ.hlPzbWrRmy8nxVpipefUY4CXPR9iASZ-UQq_YD2V0mo",
  "token_type": "bearer",
  "expires_in": 43199,
  "scope": "read write",
  "jti": "95d6d39b-3fb4-47cc-94a4-e3ea7ca307b1"
}


Service to get all user :

URL : http://localhost:8889/utrack/user

Header :
1. Authorization : Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidXRyYWNrYXV0aHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTMwMTE5ODA3LCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIiwiUk9MRV9VU0VSIl0sImp0aSI6Ijk1ZDZkMzliLTNmYjQtNDdjYy05NGE0LWUzZWE3Y2EzMDdiMSIsImNsaWVudF9pZCI6InV0cmFja0F1dGgifQ.hlPzbWrRmy8nxVpipefUY4CXPR9iASZ-UQq_YD2V0mo  (Header of the format "Bearer access_token" fetched in above step)

2. Content-Type : Application/json


Response :

[{
  "name": "admin",
  "password": "admin",
  "role": {
    "name": "admin"
  }
}, {
  "name": "kevin",
  "password": "kevin",
  "role": {
    "name": "User"
  }
}, {
  "name": "John",
  "password": "john",
  "role": {
    "name": "admin"
  }
}]


========================================================================================================================================
Audit log support using MongoDB

1. Spring Hibernate - MongoDB connection
2. Using Interceptor to log database events
3. Inserted, Update and Delete log database activity




Helpful links : 

Spring-boot-hibernate-CRUD : http://candidjava.com/tutorial/spring-boot-hibernate-crud-example/

Mysql Commands :  http://g2pc1.bu.edu/~qzpeng/manual/MySQL%20Commands.htm

Jackson Exception : http://www.baeldung.com/jackson-exception

JWT Based Web token : https://medium.com/@nydiarra/secure-a-spring-boot-rest-api-with-json-web-token-reference-to-angular-integration-e57a25806c50

Interceptor Mongo Audit log: https://www.mkyong.com/hibernate/hibernate-interceptor-example-audit-log/


