/*
*   Name:   Customers
*   Description: A Customer object is created with the reason to store both customers name and coins in this class.
*                This is created separately from the main or other class because customers does not depend on any class
*                then itself.
*   Version:     1
*   Date:   11/5/2021
*
 */

public class Customer {
    private String name;
    private int coins;

    Customer(){
        this.name = "";
        this.coins = 0;
    }

    Customer(String name, int coins){
        this.name = name;
        this.coins = coins;
    }

    public String getName() {
        return name;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

}
