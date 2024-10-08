package src;

import java.util.Scanner;

public class InputChecker
{

    public String InputString(String inputInstruction, Scanner userInput, int charactersLimit)
    {
        String strTemStore;
        boolean loop_control;
        do
        {
            loop_control = false;

            System.out.print(inputInstruction);
            strTemStore = userInput.nextLine().trim();
            int textLength = strTemStore.length();

            if(!isLetter(strTemStore) || textLength > charactersLimit)
            {
                System.out.println("Invalid Input, Try Again!");
                loop_control = true;
            }

        }while (loop_control);
        return strTemStore;
    }


    public long InputID(String inputInstruction, Scanner userInput, int IDLimit)
    {
        String intTemStore;
        while (true)
        {
            System.out.print(inputInstruction);
            intTemStore = userInput.nextLine();

            if(isNumber(intTemStore) && intTemStore.length() == IDLimit)
            {
                return Long.parseLong(intTemStore);
            }
            System.out.println("The student ID must contain exactly " +  IDLimit + " digit.");
        }
    }


    public String toAccount(String lastName, String firstName)
    {
        return lastName.replace(" ", "").toLowerCase() + "." +
                firstName.replace(" ", "").toLowerCase() + "@prisms.com";
    }

    public String toTitleCase(String text) {
        text = text.trim();

        text = text.replaceAll("\\s+", " ");

        StringBuilder titleCase = new StringBuilder();
        String[] words = text.split(" ");

        for (String word : words) {
            if (word.length() > 0) {
                String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                titleCase.append(capitalizedWord).append(" ");
            }
        }

        return titleCase.toString();
    }

    public boolean isLetter(String letterChecker)
    {
        return letterChecker.matches("[a-zA-Z\\s]+");
    }

    public boolean isNumber(String numberChecker)
    {
        return numberChecker.matches("^\\d+$");
    }

}
