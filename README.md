# user-demo
1. Info: A CRUD project based on Spring and MongoDB
2. Dependencies: MongoDB, Web
3. To Run: 

   a. Run MongoDB server by typing mongod in Command Prompt
   
   b. Run the code as Java Application in any IDE as Eclipse
   
   c. Test the code in Postman as follows:
      i. Select HTTP method POST/PUT/GET or DELETE accordingly.
      
      ii.In url, enter the endpoints
      
      iii. In body, select "raw" and then select "JSON(application/json)"
      
   
  |    Method	| Endpoints                                            |	Body	                                  | Notes                |
  |------------|------------------------------------------------------|-----------------------------------------|----------------------|
  |     POST	| http://localhost:8080/users	                         |{	                                     | To create a user     |
  |	         |                                                      | "name": "harry potter",	                |                      |
  |	         |                                                      | "email": "harry.potter@hogwarts.com",   |	                     |
  |	         |                                                      | "phoneNo": "5555555555"	                |                      |
  |	         |                                                      |}	                                     |                      |  
  |     PUT	   | http://localhost:8080/users/5ba07381bc7fb637c4f0daa7 |{	                                     | To update the user   |
  |	         |                                                      | "name": "Harry potter",                 |	                     |
  |	         |                                                      | "email": "harry.potter.7@hogwarts.com", |	                     |
  |	         |                                                      | "phoneNo": "777777777"                  |                      |	
  |	         |                                                      |}                                        |                      |	
  |     GET    | http://localhost:8080/users/5ba07381bc7fb637c4f0daa7 |                                         |	To read user details |
  |   DELETE   | http://localhost:8080/users/5ba07381bc7fb637c4f0daa7 |	                                        |	To delete the user   |
  
