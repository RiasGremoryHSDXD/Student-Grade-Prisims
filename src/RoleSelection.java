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
                this.setupTeacherAcc();
            }
            else
            {
                System.out.println("Invalid Keyword");
            }
        }while (loop_con);
    }


    String[] setupTeacherAcc()
    {
        InputChecker inputChecker = new InputChecker();

        String T_first_name = inputChecker.InputString("First name: ", call_scanner, 100);
        String T_middle_name = inputChecker.InputString("Middle name: ", call_scanner, 100);
        String T_last_name = inputChecker.InputString("Last name: ", call_scanner, 100);
        long T_ID = inputChecker.InputID("Identification: ", call_scanner, 10);
        String T_complete_name = T_last_name + ", " + T_first_name + " " + T_middle_name;
        String convert_name_format = inputChecker.toTitleCase(T_complete_name);

        String last_name = inputChecker.toTitleCase(T_last_name);
        String first_name = inputChecker.toTitleCase(T_first_name);
        String account_name = inputChecker.toAccount(T_last_name, T_first_name);

        System.out.println("Identification: " + T_ID);
        System.out.println("Teacher Name: " + convert_name_format);
        System.out.println("account name: " + account_name);

        return new String[]{};
    }
}
