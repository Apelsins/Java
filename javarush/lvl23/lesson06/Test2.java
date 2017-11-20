package lvl23.lesson06;

/* Рефакторинг
Отрефакторите класс Task03: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Test2 {

    public final static class Constants {
        public static final String SERVER_NOT_ACC = "Server is not accessible for now.";
        public static final String USER_IS_NOT = "User is not authorized.";
        public static final String USER_IS_BAN = "User is banned.";
        public static final String ACCES_IS_DIN = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.SERVER_NOT_ACC);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.SERVER_NOT_ACC, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.USER_IS_NOT);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.USER_IS_NOT, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.USER_IS_BAN);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.USER_IS_BAN, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.ACCES_IS_DIN);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.ACCES_IS_DIN, cause);
        }
    }
}