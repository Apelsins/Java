package lvl23.lesson04;

/* Inner 2
В классе SuperUser метод getDescription должен учитывать страну и город, т.е. возвращать результат аналогичный следующему:
My name is George. I'm from the USA, Seattle.
Используйте возможности иннер класса.
*/
public class Task02 {
    private String country;
    private String city;

    public Task02(String country, String city) {
        this.country = country;
        this.city = city;
    }

    /*т.к. модификатор иннер класса private, то чтобы вызвать метод getDescription из другого внешнего класса,
    нужно обернуть его вызов в какой-то public метод*/
    public String getDescriptionOfUser(String name) {
        return getTrickyUser(name).getDescription();
    }

    public SuperUser getTrickyUser(String name) {
        return new SuperUser(name);
    }

    private class SuperUser {
        private String name;

        //доступ к этому методу возможен только внутри класса Task03, т.к. модификатор иннер класса private
        public SuperUser(String name) {
            this.name = name;
        }

        //доступ к этому методу возможен только внутри класса Task03, т.к. модификатор иннер класса private
        public String getDescription() {
            return String.format("My name is %s. I'm from the %s, %s.", this.name, country, city);
        }
    }

    public static void main(String[] args) {
        Task02 solution = new Task02("the USA", "Seattle");
        //внутри класса Task03 (а сейчас мы внутри) к методу getDescription можно обращаться обоими способами
        System.out.println(solution.getTrickyUser("George").getDescription());
        //а из любого другого внешнего класса только так:
        System.out.println(solution.getDescriptionOfUser("George"));
    }
}
