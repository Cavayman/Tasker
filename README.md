<h1>How to run this prject?</h1>
*Very simple: just pull and build it on tomcat 7+ 
<h1>What is this?</h1>
*Restfull application that is solving tasks. 
Example how to work with servlet 3.1 and DBCP as DataSource, also you can find here Jackson library that is used to send every data to client.
Also hare you can see a simple etalon structore for maven project. 
<details> 
  <summary> What it can do?</summary>
<h4>It was build like an example app that is solving tasks, so it's solving tasks :D</h4>
Task 0. (/task0/users; /task0/movies; /task0/ratings)

Return all users, movies, ratings.

Task 1. (/task1)

Some date in rating is lost. Find the userId of all users who have ratings with a NULL

value for the date. Set it to today's date in database.

Return all ratings.

Task 2. (/task2)

Insert the following movies into the Movie table:

movieId title director

9 Deadpool Tim Miller

10 The 300 spartans Zak Snyder

Return all movies.

Task 3. (/task3)

Return the movieID, ratingDate of all movies that received a rating of 4 or 5, and sort

them in increasing order by ratingDate.

Task 4. (/task4)

Return the titles of all movies that have no ratings.

Task 5. (/task5)

Delete the movies you added in task 2 (by id 9 and 10).

Return all movies

Task 6. (/task6)

Return the title of the movie, user name and rating for every rating.SQL script:

Task 7. (/task7)

Update a few rows somehow using POST request.

Open and close transaction manually for this operation using native JDBC methods.

Task 8. (/task8)

Get ratings, where there are at least 2 ratings with the same date.
</details>

<details> 
  <summary>Example</summary>
   <details> 
  <summary>Running app</summary>
  <br>
   1)I have build war of this app  on my PC so i will go more native way and 
    <p>Copy *.war to tomcat/webapps directory</p>
    <img src="https://pp.vk.me/c638516/v638516486/916c/kld93PRywbU.jpg" width='400p'></img>
    <br>
    2)Go to tomcat/bin and hit 2 times on startup.bat *It will start tomcat.He will find your war-file,compile and run it*
    <img src="https://pp.vk.me/c638516/v638516486/9175/Qd7mr4cRdQw.jpg" width='400p'></img>
   <br>
   3)Congrats you made it !!! Now go  to localhost:8080/*warname* and you will see welcome page 
 <img src="https://pp.vk.me/c638516/v638516486/9189/KB7oxnRfN2w.jpg" width='400p'></img>
</details>
<details> 
  <summary>Send POST requests</summary>
  All GET reguest are available at localhost:port/*Tasker*/task{numberOfTask}</h3>
  And there is 3 tasks that are working not on GET request 
    <h3>Task2: saving movies from Json.</h2>
       <br>
       > Open Postman 
       <br>
       >Chose POST method
       <br>
       >Enter http://localhost:8080/Tasker/task2 in url
        <br>
        use this JS to insert: 
<br>
[{"id":"9",<br>
			"title":"Deadpool",<br>
			"director":"Tim miller"<br>
},{<br>
			"id":"10",<br>
			"title":"The 300 spartans",<br>
			"director":"Zak Snyder"<br>
}
]			
	<br>
    <h3>Task5: Update users manualy from json.</h2>
       <br>
       > Open Postman 
       <br>
       >Chose DELETE method
       <br>
       >Enter http://localhost:8080/Tasker/task5 in url
        <br>
      <h3>Task7: saving movies from Json.</h2>
       <br>
       > Open Postman 
       <br>
       >Chose POST method
       <br>
       >Enter http://localhost:8080/Tasker/task7 in url
        <br>
        use this JS to insert: 
<br>
[
	{"id":"11",
			"name":"Deadpool"
},{
			"id":"12",
			"name":"Deadpool"
}
]			
</details>
</details>
 
