package src;

import java.util.Scanner;

public class RoleSelection {

    private String roleSelection;
    private Scanner call_scanner = new Scanner(System.in);

    public void getRoleSelection(String roleSelection)
    {
        this.roleSelection = roleSelection;
    }

    public void setRoleSelection()
    {
        if(this.roleSelection.equals("T"))
        {
            this.roleSelection = "T";
            this.RoleAsTeacher();
        }
        else if (this.roleSelection.equals("S"))
        {
            this.roleSelection = "S";
        }
        else
        {
           this.roleSelection = "E";
        }
    }

    void RoleAsTeacher()
    {
        DataVerifier dataVerifier = new DataVerifier();

        String user_choose;
        Object[] teacher_data;
        boolean loop_con = true;
        do
        {
            System.out.print("Already have a teacher account (Y/N): ");
            user_choose = call_scanner.nextLine().toUpperCase().trim();

            if (user_choose.equals("Y"))
            {
                System.out.println("The teacher have a account already");
            }
            else if (user_choose.equals("N"))
            {
                teacher_data = this.setupTeacherAcc();
                dataVerifier.setUser_id((long) teacher_data[0]);
                dataVerifier.setUser_name((String) teacher_data[1]);
                dataVerifier.setAccount_email((String) teacher_data[2]);
                dataVerifier.display();
                dataVerifier.Account_Authentication();
            }
            else
            {
                System.out.println("Invalid Keyword");
            }
        }while (loop_con);
    }


    Object[] setupTeacherAcc()
    {
        InputChecker inputChecker = new InputChecker();

        String T_first_name = inputChecker.InputString("First name: ", call_scanner, 100);
        String T_middle_name = inputChecker.InputString("Middle name: ", call_scanner, 100);
        String T_last_name = inputChecker.InputString("Last name: ", call_scanner, 100);
        long T_ID = inputChecker.InputID("Identification: ", call_scanner, 1);
        String T_complete_name = T_last_name + ", " + T_first_name + " " + T_middle_name;
        String convert_name_format = inputChecker.toTitleCase(T_complete_name);
        T_complete_name = convert_name_format;

        String account_email = inputChecker.toAccount(T_last_name, T_first_name);

        return new Object[]{T_ID, T_complete_name, account_email};
    }
}
