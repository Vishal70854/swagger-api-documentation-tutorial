## SWAGGER OPEN API DOCUMENTATION CONFIGURING STEPS

# READING MATERIAL - MUST WATCH
https://bell-sw.com/blog/documenting-rest-api-with-swagger-in-spring-boot-3/

## Run your application to see swagger is working
Run your application and go to the default page where
the API documentation is located: http://localhost:8080/v3/api-docs.

You should see the data on your endpoints in JSON format.
You can also access the .yaml file at http://localhost:8080/v3/api-docs.yaml.

## Change default path to access swagger api's

It is possible to change the default path in the application.properties file. For example:

**springdoc.api-docs.path=/api-docs**
Now the documentation is available at http://localhost:8080/api-docs.

**## Integrate Swagger UI**
The beauty about springdoc-openapi library dependency is that it already includes Swagger UI,
so we don’t have to configure the tool separately!

**You can access Swagger UI at http://localhost:8080/swagger-ui/index.html,**
where you will see a beautiful user interface to interact with your endpoints
(or similar to the one on the screenshot if you are using your project):

## Steps to add swagger springdoc-openapi-starter-webmvc-ui

1. Add dependency in pom.xml:
<!--		dependency for swagger springdoc-openapi-starter-webmvc-ui open api documentation		-->
		<!-- https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui -->
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.5.0</version>
		</dependency>

2. Go to Main class and add annotation @OPENAPIDEFINITION() with some details for our OPEN API DOCUMENTATION:
   **@OpenAPIDefinition(
   info = @Info(
   title = "Course Application OPEN API",
   version = "1.0.0",
   description = "Course Application OPEN API DOCUMENTATION"
   ),
   servers = @Server(
   url = "http://localhost:8080",
   description = "Course Application OPEN API"
   )
   )**

3. Go to controller class and there we will add an annotation **@Tag(name="", description="")** to give tag to our swagger api documentation
   **@Tag(name = "MyController", description = "To perform operations on fetching course application details")**
   here **@Tag()** is used to tell our controller that we have to create api documentation for our controller class with
   api documentation for all methods mentioned in controller class
   Now to perform operations on all api's created in controller class we will use **@Operation** annotation details provided below

4. Now we will add operations to each of the api's mentioned and for that we will use **@peration()** annotation in all api's
   below is the example code for 2 to 3 api's
   **@Operation(
   summary = "GET operation on course application",
   description = "This api is used to get list of courses from database for our course application"
   )
   @Operation(
   summary = "POST operation on course application",
   description = "This api is used to create a new course in database for our course application"
   )
   @Operation(
   summary = "DELETE operation on course application",
   description = "This api is used to delete a course from database in our course application"
   )**

5. Now Run your main application class and see if your swagger OPEN API DOCUMENTATION is working or not.
   Access the swagger api documentation in below url
   link : http://localhost:8080/swagger-ui/index.html
6. 