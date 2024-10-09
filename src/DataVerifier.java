package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataVerifier
{
    private long user_id;
    private String user_name;
    private String account_email;

    private String url = "jdbc:mysql://127.0.0.1:3306/student_grade_prisms";
    private String user = "root";
    private String password = "";

    void setUser_id(long user_id)
    {
        this.user_id = user_id;
    }


    void setUser_name(String user_name)
    {
        this.user_name = user_name;
    }


    void setAccount_email(String account_email)
    {
        this.account_email = account_email;
    }

    void display()
    {
        System.out.println("ID: " + this.user_id);
        System.out.println("Name: " + this.user_name);
        System.out.println("Account Email: " + this.account_email);
    }

    void Account_Authentication()
    {
        try
        {
            Connection connection = DriverManager.getConnection(this.url, this.user, this.password);
            Statement create_statement = connection.createStatement();
            ResultSet result_set = create_statement.executeQuery("SELECT * FROM account_verification_view");

            int count_record = 1;
            while (result_set.next())
            {
                long user_id = result_set.getLong("identification");
                String user_name = result_set.getString("full_name");
                String account_email = result_set.getString("account_name");

                if(user_id == this.user_id)
                {
                    System.out.println("The ID is already exist");
                }

                if(user_name.equals(this.user_name))
                {
                    System.out.println("Teacher Name is already exist");
                }

                if(account_email.equals(this.account_email))
                {
                    System.out.println("Account name is already exist");
                }
                count_record++;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
