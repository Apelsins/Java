package lvl26.lesson08;

/*
Мудрый человек думает раз, прежде чем два раза сказать

Все методы, кроме метода main, класса Task03 должны быть thread safe.
Сделайте так, чтобы оба метода могли выполняться одновременно двумя различными тредами.
synchronized(this) для этого не подходит, используй другой объект для лока.

*/

public class Task02 {
    int var1;
    int var2;
    int var3;
    int var4;

    private final Object object1 = new Object();
    private final Object object2 = new Object();

    public Task02(int var1, int var2, int var3, int var4) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;
    }

    public int getSumOfVar1AndVar2() {
        synchronized (object1) {
            return var1 + var2;
        }
    }

    public int getSumOfVar3AndVar4() {
        synchronized (object2) {
            return var3 + var4;
        }
    }

    public static void main(String[] args) {

    }
}