/*
 *   Name:   Menu
 *   Description: A menu class which has all the operations needed for the program example, read file, write to csv
 *                menu of the program, calculation, searching of customer.
 *   Version:     1
 *   Completed functions: readFile, searchCus(boolean), searchCus(String)
 *   Incomplete functions to be continued: denoCal, writeToCSV,
 *   Date:   11/5/2021
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
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


        return "Nothing for now";
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
                case 2:
                    //write to csv
                    System.exit(1);
                default:
                    System.out.println("Incorrect input of choice please try again");
            }
        }
    }

}
