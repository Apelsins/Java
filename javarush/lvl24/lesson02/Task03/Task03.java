package lvl24.lesson02.Task03;

/**
 * Created by ATarasevich on 07.08.2017.
 */

interface SelfInterfaceMarker {
}

class SelfInterfaceMarkerImpl implements SelfInterfaceMarker {
    public void printX() {
        System.out.println("x");
    }

    public void printY() {
        System.out.println("y");
    }
}

class UnsupportedInterfaceMarkerException extends Exception {

}

public class Task03 {
    public static void main(String[] args) throws UnsupportedInterfaceMarkerException {
        SelfInterfaceMarkerImpl obj = new SelfInterfaceMarkerImpl();
        UtilLesson2.testClass(obj);
    }
}
