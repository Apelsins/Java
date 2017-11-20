package lvl26.lesson10;

import java.util.concurrent.locks.Lock;

/**
 * Created by ATarasevich on 19.09.2017.
 */
public class Task01 {
    private Lock lock;

    public void ifLockIsFree() {

    }

    public void ifLockIsBusy() {

    }

    public void someMethod () {
        try {
            if (!lock.tryLock())
                ifLockIsBusy();
            if (lock.tryLock())
                ifLockIsFree();
        }
        catch (Exception e){
            lock.unlock();
        }
    }
}
