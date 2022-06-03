 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="post" action="arithmetic">
            <label for="firstInput">First:</label>
            <input type="text" name="firstInput" value="${userValueOne}">
            <br>
            <label for="userAge">Second:</label>
            <input type="text" name="secondInput" value="${userValueTwo}">
            <br>
            <input type="submit" name="operation" value="+">       
            <input type="submit" name= "operation"value="-">
            <input type="submit" name="operation" value="*">
            <input type="submit" name="operation" value="%">
            
            <p>Result: ${output}</p>
                       
            <a href="age">Age Calculator</a>
        </form>
    </body>
</html>
