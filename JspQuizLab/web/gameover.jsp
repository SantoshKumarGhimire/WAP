<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The Number Quiz(JSP Edition)</title>
    </head>
    <body>
        <form name="myform" method="post">
            <h3>Game Over!!</h3>
            <p>Your current score is ${score}.</p>
            <p>
                Your Grade is
            </p>
            <h3>
                <font style="color: red"> ${myGrade}</font>
            </h3>
            <p></p>
            <p>
                <a href="QuizJSP">Start Over!</a>
            </p>
        </form>
    </body>
</html>