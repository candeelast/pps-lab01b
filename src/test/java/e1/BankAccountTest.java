package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    private SilverBankAccount silverAccount;
    private GoldBankAccount goldAccount;
    private BronzeBankAccount bronzeAccount;


    @BeforeEach
    void init(){
        this.silverAccount = new SilverBankAccount();
        this.goldAccount = new GoldBankAccount();
        this.bronzeAccount = new BronzeBankAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.silverAccount.getBalance());
        assertEquals(0, this.goldAccount.getBalance());
        assertEquals(0, this.bronzeAccount.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.silverAccount.deposit(1000);
        this.goldAccount.deposit(1000);
        this.bronzeAccount.deposit(1000);
        assertEquals(1000, this.silverAccount.getBalance());
        assertEquals(1000, this.goldAccount.getBalance());
        assertEquals(1000, this.bronzeAccount.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        this.silverAccount.deposit(1000);
        this.silverAccount.withdraw(200);
        this.goldAccount.deposit(1000);
        this.goldAccount.withdraw(200);
        this.bronzeAccount.deposit(1000);
        this.bronzeAccount.withdraw(200);
        assertEquals(799, this.silverAccount.getBalance());
        assertEquals(800, this.goldAccount.getBalance());
        assertEquals(799, this.bronzeAccount.getBalance());
    }

    @Test
    public void testCanWithdrawBronze() {
        this.bronzeAccount.deposit(1000);
        this.bronzeAccount.withdraw(50);
        assertEquals(950, this.bronzeAccount.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.silverAccount.deposit(1000);
        this.goldAccount.deposit(1000);
        this.bronzeAccount.deposit(1000);
        assertThrows(IllegalStateException.class, () -> this.silverAccount.withdraw(1200));
        assertThrows(IllegalStateException.class, () -> this.goldAccount.withdraw(1600));
        assertThrows(IllegalStateException.class, () -> this.bronzeAccount.withdraw(1200));
    }

    @Test
    public void testCannotWithdrawMoreThanAvailableGold() {
        this.goldAccount.deposit(1000);
        this.goldAccount.withdraw(1450);
        assertEquals(-450, this.goldAccount.getBalance());
    }
}
