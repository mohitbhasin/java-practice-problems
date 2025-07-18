package polymorphism;

public class BankAccount {
    public static void main(String args[]) {
        Account saving_account = new Savings(50000);
        Account current_account = new Current(50000);

        saving_account.Deposit(1000);
        saving_account.printBalance();

        saving_account.Withdraw(3000);
        saving_account.printBalance();

        System.out.println();

        current_account.Deposit(1000);
        current_account.printBalance();

        current_account.Withdraw(3000);
        current_account.printBalance();

    }
}

class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void Withdraw(double amount) {
    }

    public void Deposit(double amount) {
    }

    public void printBalance() {
    }
}

class Savings extends Account {
    private double interestRate = 0.8;

    public Savings(double amount) {
        super(amount);
    }

    @Override
    public void Withdraw(double amount) {
        double newAmount = amount * (1+this.interestRate);
        if(newAmount<=this.balance) {
            this.balance-=newAmount;
        }
    }

    @Override
    public void Deposit(double amount) {
        double newAmount = amount * (1 + (this.interestRate));
        this.balance+=newAmount;
    }

    @Override
    public void printBalance() {
        System.out.println("Balance in your saving account: "+super.balance);
    }
}

class Current extends Account {

    public Current(double amount) {
        super(amount);
    }

    @Override
    public void Withdraw(double amount) {
        if(amount<=this.balance) {
            this.balance-=amount;
        }
    }

    @Override
    public void Deposit(double amount) {
        this.balance+=amount;
    }

    @Override
    public void printBalance() {
        System.out.println("Balance in your current account: "+super.balance);
    }
}