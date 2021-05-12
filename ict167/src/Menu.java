/*
 *   Name:   Menu
 *   Description: A menu class which has all the operations needed for the program example, read file, write to csv
 *                menu of the program, calculation, searching of customer.
 *   Version:     1
 *   Completed functions: readFile, searchCus(boolean), searchCus(String)
 *   Incomplete functions to be continued: denoCal, writeToCSV,
 *   Date:   11/5/2021
 *
 *   Description: Finishing and complete denoCal function and ensure all code is runnable
 *   Changes: Updated the searchCus(boolean), completed the denoCal
 *   Version:   2
 *   Date 12/5/2021
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Menu {
    List<Customer> customerList = new ArrayList<>();

    //empty constructor
    Menu() {
        readFile();
        BodyOfProgram();
    }

    //read the data from coins.txt and add the names with coins into the customerList
    private void readFile()  {
        System.out.println("Loading in Data......");
        try {
            File FILE = new File("coins.txt");
            Scanner S = new Scanner(FILE);
            while (S.hasNextLine()) {
                String line = S.nextLine();
                String[] array = line.split(" ");
                int amount = Integer.parseInt(array[1]);
                if(!searchCus(array[0],amount)){
                    customerList.add(new Customer(array[0],amount));
                }
            }
            System.out.println("Data Loaded......");
            S.close();      //close the reading
        } catch (FileNotFoundException e){
            System.out.println("Cannot find File");
            e.printStackTrace();
        }
    }

    // search for the customer if they exist or not
    private boolean searchCus(String name, int amount){
        if(amount%5 != 0) {
            return true;
        }
        for(Customer c : customerList){
            String cusName = c.getName();
            int cusAmount = c.getCoins();
            if(cusName.equals(name)){
                int sum = cusAmount + amount;
                c.setCoins(sum);
                return true;
            }
        }
        return false;
    }

    private String searchCus(String name){
        for (Customer c : customerList) {
            if (c.getName().equals(name)) {
                System.out.println("Customer:\n" + name + " " + c.getCoins() + "\n");
                return denoCal(c.getCoins(), 1);
            }
        }
        return "Not Found";
    }

    //incomplete need to work on tomorrow
    private String denoCal(int amount, int choice){
        int cents50=0, cents20=0, cents10=0, cents5=0;
        while(amount != 0){
            while(amount >= 50){
                cents50++;
                amount -= 50;
            }
            while(amount >= 20){
                cents20++;
                amount -= 20;
            }
            while(amount >= 10){
                cents10++;
                amount -= 10;
            }
            while(amount >= 5){
                cents5++;
                amount -= 5;
            }
        }
        if(choice == 1){
            String line50 = "50 Cents: "+cents50 ,
                    line20= "20 Cents: "+cents20 ,
                    line10= "10 Cents: "+cents10 ,
                    line5= "5 Cents: "+cents5 ;
            if(cents50 != 0){
                System.out.println(line50);
            }
            if(cents20 != 0){
                System.out.println(line20);
            }
            if(cents10 != 0){
                System.out.println(line10);
            }
            if(cents5 != 0){
                System.out.println(line5);
            }
            return "";
        }   //choice is two
        return cents50+","+cents20+","+cents10+","+cents5;
    }

    //incomplete need to work on tomorrow
    private void BodyOfProgram(){
        Scanner s = new Scanner(System.in);
        int choice = 0;
        while(true) {
            System.out.println("-------------\n1.Enter name\n2.Quit\n-------------");
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = s.next();
                    String result = searchCus(name);
                    System.out.println(result);
                    break;
                case 2:
                    //write to csv
                    System.exit(1);
                    break;
                default:
                    System.out.println("Incorrect input of choice please try again");
                    break;
            }
        }
    }

}
