<%@ page import="Domain.Question" %>
<%@ page import="Repositories.Repository" %><%--
  Created by IntelliJ IDEA.
  User: Andrei
  Date: 28.05.2018
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
      $(document).ready(function () {
          var l = document.getElementsByClassName("a").length;
          alert(l);
          $("form").submit(answer);
      });
      function answer()
      {
          var l = document.getElementsByClassName("a").length;
          var response="";
          for(var  i=0;i<l/2;i++)
          {
              var tr= document.getElementById(i+"t");
              var fs= document.getElementById(i+"f");
              var res="";
              if(fs.checked)
                  res="false";
              if(tr.checked)
                  res="true";
              if(res!="")
              {
                  var id= tr.name.replace("ans","");
                  var k = id+":"+res;
                  if(response=="")
                    response+=k;
                  else
                  response=response+";"+k;
              }
              else {
                  document.getElementById("info").innerText="Unchecked answers";
                  return false;
              }

          }

          document.getElementById("res").value=response;
          alert(response);
          return true;
      }
    </script>
  </head>
  <body>
  <form action="/ValidateAnswers" method="post" id="form">
    <input type="hidden" name="response" id="res">
    <input type="submit">
  </form>
  <label id="info"></label>
  <%
    if(request.getSession().getAttribute("answers")!=null)
    {
      out.print("You answered correct at " + request.getSession().getAttribute("answers") + "questions!");
      request.getSession().removeAttribute("answers");
    }
  %>
    <table>
      <tr>

        <th>Question</th>
        <th>True </th>
        <th>False</th>
        <%
          int i=0;
          for (Question q: Repository.getQuestions())
          {
              out.print("<tr>");
                out.print("<td>"+q.getQuestion()+"</td>");
                out.print("<td><input type='radio' class='a'  name='"+q.getId()+"ans' id='"+i+"t'></td>");
                out.print("<td><input type='radio' class='a'  name='"+q.getId()+"ans' id='"+i+"f'></td>");
                i++;
              out.print("</tr>");

          }
        %>
      </tr>
    </table>

  </body>
</html>
