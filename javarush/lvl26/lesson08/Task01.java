package lvl26.lesson08;

/*
Вежливость - это искусственно созданное хорошее настроение

В классе Task03 создай public static класс IntegerHolder.
IntegerHolder должен быть для типа int (имя переменной должно быть value), быть thread safe и изменяемым.
В этом классе должны быть два public метода get и set.
*/
public class Task01 {
    public static void main(String[] args) {
    }

    public static class IntegerHolder {
        private int value;

        public synchronized int getValue() {
            return value;
        }

        public synchronized void setValue(int value) {
            this.value = value;
        }
    }
}