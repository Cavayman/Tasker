<%--
  Created by IntelliJ IDEA.
  User: cavayman
  Date: 06.11.2016
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Tasker</title>
    <link rel="stylesheet" href="css/main.css">
  </head>
  <body>
  <div class="container">
  Task 0. (/task0/users; /task0/movies; /task0/ratings)

  Return all users, movies, ratings.
<br>
  Task 1. (/task1)

  Some date in rating is lost. Find the userId of all users who have ratings with a NULL

  value for the date. Set it to today's date in database.

  Return all ratings.
    <br>
  Task 2. (/task2)

  Insert the following movies into the Movie table:

  movieId title director

  9 Deadpool Tim Miller

  10 The 300 spartans Zak Snyder

  Return all movies.
    <br>
  Task 3. (/task3)

  Return the movieID, ratingDate of all movies that received a rating of 4 or 5, and sort

  them in increasing order by ratingDate.
    <br>
  Task 4. (/task4)

  Return the titles of all movies that have no ratings.
    <br>
  Task 5. (/task5)

  Delete the movies you added in task 2 (by id 9 and 10).

  Return all movies
    <br>
  Task 6. (/task6)

  Return the title of the movie, user name and rating for every rating.SQL script:
    <br>
  Task 7. (/task7)

  Update a few rows somehow using POST request.

  Open and close transaction manually for this operation using native JDBC methods.
    <br>
  Task 8. (/task8)

  Get ratings, where there are at least 2 ratings with the same date.
  </div>
  </body>
</html>
