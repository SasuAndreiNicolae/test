package Repositories;

import Domain.Question;
import org.apache.commons.lang.StringEscapeUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public  class Repository
{

    public static Iterable<Question> getQuestions()
    {
        List<Question> comments= new ArrayList<Question>();
        try(Connection connection= DBConnector.getConnection())
        {
            PreparedStatement statement= connection.prepareStatement("SELECT * FROM questions");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next())
            {
                Question comment= new Question( resultSet.getInt("id"),StringEscapeUtils.escapeHtml( resultSet.getString("question")), resultSet.getInt("answer")>0?true:false);
                comments.add(comment);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return comments;
    }
}
