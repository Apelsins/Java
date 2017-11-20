package lvl24.lesson04;

import java.math.BigDecimal;

/* Наследование от внутреннего класса
Внутри класса Task03 создайте 2 внутренних public класса Apt3Bedroom, BigHall.
Унаследуйте их от Apartments и Hall.
*/
public class Task01 {
    public class Building {
        public class Hall {
            private BigDecimal square;

            public Hall(BigDecimal square) {
                this.square = square;
            }
        }

        public class Apartments {
        }
    }

    // class 1

    public class Apt3Bedroom extends Building.Apartments {
        public Apt3Bedroom(Building building) {
            building.super();
        }
    }

    // class 2

    public class BigHall extends Building.Hall {
        public BigHall(Building hall, BigDecimal bigDecimal) {
            hall.super(bigDecimal);
        }
    }
}