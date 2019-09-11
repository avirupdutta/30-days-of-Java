package ATM;


public class App {
    public static void main ( String[] args ) {
        PremiumUser newUser = new PremiumUser("Avirup", 5000);
//        newUser.deposit(50);
        if (newUser.withdraw(4600)) {
            System.out.println("Success!");
        }
        else {
            System.out.println("Failed!");
        }
        System.out.println(newUser.amount);
    }
}

class User {
    String name;
    int amount;
    User(String name, int amount){
        this.name = name;
        this.amount = amount;
    }
    public void deposit(int amount){
        this.amount += amount;
    }
}

class FreeUser extends User{
    private int limitingAmount;
    FreeUser (String name, int amount){
        super(name, amount);
        limitingAmount = 1000;
    }

    public boolean withdraw(int val){
        System.out.println(this.getClass());
        if (amount-val < this.limitingAmount){
            return false;
        }
        else {
            amount -= val;
            return true;
        }
    }
}

class PremiumUser extends FreeUser{
    private int limitingAmount;
    PremiumUser(String name, int amount){
        super(name, amount);
    }
    public boolean withdraw(int val) {
        limitingAmount = 400;
        System.out.println(limitingAmount);
        if (amount-val < this.limitingAmount){
            return false;
        }
        else {
            amount -= val;
            return true;
        }
//        return super.withdraw(val);
    }
}

