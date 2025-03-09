package e1;

public class BronzeBankAccount implements BankAccount {

    private CoreBankAccount base;

    public BronzeBankAccount(){
        this.base = new CoreBankAccount();
    }

    @Override
    public int getBalance(){
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){ // no overdraft allowed
            throw new IllegalStateException();
        }

        if (amount < 100){
            base.withdraw(amount); //no fee
        }
        else {
            base.withdraw(amount + 1);
        }

    }
}
