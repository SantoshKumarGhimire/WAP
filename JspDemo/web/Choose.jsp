<%-- 
    Document   : Choose
    Created on : Dec 6, 2016, 1:42:50 AM
    Author     : Santosh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method='post' action='ChooseServlets'>
            <p>Is JSP cool?</p>
            <%if (session.getAttribute("radioJSPCool") == null || session.getAttribute("radioJSPCool").equals("")) { %>
            <input type='radio' value='1' name='radioJSPCool'><span>Yes</span><br/>
            <input type='radio' value='0' name='radioJSPCool'><span>No</span><br/>
            <input type='submit' name='btnSubmit' value='Submit'/>

            <%  } else {
                String s = session.getAttribute("radioJSPCool").toString();
              
                if (s.equals("1")) {
                    System.out.println("case1");%>
            <input type='radio' value='1' name='radioJSPCool' checked><span>Yes</span><br/>
            <input type='radio' value='0' name='radioJSPCool'><span>No</span><br/>
            <input type='submit' name='btnSubmit' value='Submit'/>
            <%  } else {%>
            <input type='radio' value='1' name='radioJSPCool'><span>Yes</span><br/>
            <input type='radio' value='0' name='radioJSPCool' checked><span>No</span><br/>
            <input type='submit' name='btnSubmit' value='Submit'/>
            <%  }
                }
            %>

            <p>Is JSF way cool?</p>
            <%if (session.getAttribute("JSFwayCool") == null || session.getAttribute("JSFwayCool").equals("")) { %>
            <input type='radio' value='1' name='JSFwayCool'><span>Yes</span><br/>
            <input type='radio' value='0' name='JSFwayCool'><span>No</span><br/>
            <input type='submit' name='btnSubmit' value='Submit'/>

            <%  } else {
                String s = session.getAttribute("JSFwayCool").toString();
                if (s.equals("1")) {%>
            <input type='radio' value='1' name='JSFwayCool' checked><span>Yes</span><br/>
            <input type='radio' value='0' name='JSFwayCool'><span>No</span><br/>
            <input type='submit' name='btnSubmit' value='Submit'/>
            <%  } else {%>
            <input type='radio' value='1' name='JSFwayCool'><span>Yes</span><br/>
            <input type='radio' value='0' name='JSFwayCool' checked><span>No</span><br/>
            <input type='submit' name='btnSubmit' value='Submit'/>
            <%  }
                }
            %>


            <p>Is the moon made of cheese?</p>
            <%if (session.getAttribute("moonCheese") == null || session.getAttribute("moonCheese").equals("")) { %>
            <input type='radio' value='1' name='moonCheese'><span>Yes</span><br/>
            <input type='radio' value='0' name='moonCheese'><span>No</span><br/>
            <input type='submit' name='btnSubmit' value='Submit'/>

            <%  } else {
                String s = session.getAttribute("moonCheese").toString();
                if (s.equals("1")) {%>
                <input type='radio' value='1' name='moonCheese' checked><span>Yes</span><br/>
            <input type='radio' value='0' name='moonCheese'><span>No</span><br/>
            <input type='submit' name='btnSubmit' value='Submit'/>
            <%  } else {%>
            <input type='radio' value='1' name='moonCheese'><span>Yes</span><br/>
            <input type='radio' value='0' name='moonCheese' checked><span>No</span><br/>
            <input type='submit' name='btnSubmit' value='Submit'/>
            <%  }
                }
            %>

        </form>

    </body>
</html>
