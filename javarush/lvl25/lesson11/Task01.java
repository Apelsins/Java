package lvl25.lesson11;

import java.util.Random;

/*
Обеспечение отсутствия прерывания важной операции
*/
public class Task01 {
    private static final Integer THRESHOLD_VALUE = 500;
    private static final Random RANDOM = new Random();

    public synchronized void moveMoney(Account from, Account to, int amount) {
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        if (RANDOM.nextInt(5000) > THRESHOLD_VALUE) {
            Thread.yield();
        }
    }

    class Account {
        private int balance;

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }
    }

    public static void main(String[] args) {
    }
}