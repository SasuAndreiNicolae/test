package Domain;

public class Question
{
    private int id;
    private String question;
    private Boolean answer;

    @Override
    public String toString()
    {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer=" + answer +
                '}';
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public Boolean getAnswer()
    {
        return answer;
    }

    public void setAnswer(Boolean answer)
    {
        this.answer = answer;
    }

    public Question(int id, String question, Boolean answer)
    {

        this.id = id;
        this.question = question;
        this.answer = answer;
    }

}
