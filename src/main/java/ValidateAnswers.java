import Domain.Question;
import Repositories.Repository;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/ValidateAnswers")
public class ValidateAnswers extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException
    {
        String resp= request.getParameter("response");
        System.out.println(resp);
        int cr=0;
        try
        {
            Iterable<Question> questions= Repository.getQuestions();
            String[] spart=resp.split(";");

            for (String ans:spart)
            {
                String[]k = ans.split(":");
                int id= Integer.parseInt(k[0]);
                String r= k[1];
                for (Question q:questions)
                {
                    if(q.getId()==id)
                    {
                        Boolean b= new Boolean(r);
                        System.out.println(b);
                        System.out.println(q.getAnswer());
                        if(b.compareTo(q.getAnswer())==0)
                            cr++;
                        break;
                    }
                }

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(cr);
        request.getSession().setAttribute("answers",cr);
        response.sendRedirect("index.jsp");
        System.out.println("done");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException
    {

    }
}
