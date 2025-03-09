package e1;

public class GoldBankAccount implements BankAccount {

    private CoreBankAccount base;

    public GoldBankAccount(){
        this.base = new CoreBankAccount();
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() + 500 < amount){ // can have negative balance up to -500
            throw new IllegalStateException();
        }
        base.withdraw(amount); // no fee
    }
}
