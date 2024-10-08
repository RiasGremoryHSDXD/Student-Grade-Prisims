package src;

import java.util.*;
public class MainMenu
{
    public static void main(String[] args)
    {
        Scanner call_scanner = new Scanner(System.in);
        RoleSelection role_select = new RoleSelection();

        String role_sel;

        System.out.println("Student Grade Prisim\n\n");


        System.out.println("+--------------------+----------+");
        System.out.println("|  TEACHER           |    T     |");
        System.out.println("|  STUDENT           |    S     |");
        System.out.println("|  EXIT              |    E     |");
        System.out.println("+--------------------+----------+");

        while (true)
        {
            System.out.print("Log in as: ");
            role_sel = call_scanner.nextLine().trim().toUpperCase();

            switch (role_sel)
            {
                case "T", "S", "E" ->
                {
                    role_select.getRoleSelection(role_sel);
                    role_select.setRoleSelection();
                }
                default -> System.out.println("Invalid Keyword Try Again!");
            }
        }
    }
}
