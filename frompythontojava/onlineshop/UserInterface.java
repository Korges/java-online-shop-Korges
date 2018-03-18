import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public List<String> menuOptions;
    public List<Integer> optionsList;
    public static Scanner sc = new Scanner(System.in);


    public UserInterface(List<String> menuOptions, List<Integer> optionsList){

        this.menuOptions = menuOptions;
        this.optionsList= optionsList;

    }

    public void displayMenu(){

        for(int i=0; i<this.menuOptions.size(); i++){

            System.out.format("%d - %s\n",this.optionsList.get(i) , this.menuOptions.get(i));

        }
    }

    public Date getExpirationDate()
    {
        Date date = new Date();
        return date;
    }


    public void showMessage(String message)
    {
        System.out.println(message);
    }

    public String getString(String message)
    {
        sc = new Scanner(System.in);
        showMessage(message);
        return sc.nextLine();
    }

    public float getFloat(String message)
    {
        do{
            sc = new Scanner(System.in);
            showMessage(message);
        } while(!sc.hasNextFloat());
        return sc.nextFloat();
    }

    public int getInt(String message)
    {
        do{
            sc = new Scanner(System.in);
            showMessage(message);
        } while(!sc.hasNextInt());
        return sc.nextInt();
    }

    public boolean getBoolean(String message) {

        if (message.toLowerCase().equals("yes") || message.toLowerCase().equals("y")) {
            return true;
        }
        return false;
    }

    public int getMenuOption()
    {
        int option = getInt("Choose action");
        return option;
    }



}

