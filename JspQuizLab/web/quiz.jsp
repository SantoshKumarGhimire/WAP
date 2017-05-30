<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The Number Quiz(JSP Edition)</title>
    </head>
    <body onload="javascript:myform.txtAnswer.focus()">
        <form method="post" name="myform">
            <div id="age" style="display: ${inserted}">
                <p> Enter you age</p>
                <input type="text" name="age" value=${age} >
                <input type="submit" name="Submit" value="Submit Age">
                <% if ((String) session.getAttribute("ageMsg") != null) {  %>
                <br /><p style="color:red"> ${ageMsg} </p>
                <% } else { %>
                <br>
                <br>
                <% }%>
            </div>

            <h1>Have fun with NumberQuiz!</h1>

            <div id="game" style="display:${agevalue}">
                Your Current Score: ${score} <br>

                <p>Attempt  ${attempts}  / 3 </p>

                <br> Guess the next number in the sequence <br>
                <br> ${question} <br>
                <%
                    String num = "";
                    if ((String) session.getAttribute("correctAns") != null) {
                        num = (String) session.getAttribute("correctAns");
                    }
                %>
                <br>Your Answer: <input type="text" name="txtAnswer" size="8" value="${correctAns}">

                <% if ((String) session.getAttribute("msg") != null) {  %>
                <br /><p style="color:red"> ${msg} </p>
                <% } else { %>
                <br>
                <br>
                <% }%>
                <input type="submit" value="Next"> <a href="" onclick="return confirm('Do you want to start over?')">Restart!</a>

                <p><input type="button" name="btnHint" value="Hint?" onclick="alert('${hints}')"></p>

            </div>
        </form>
    </body>
</html>