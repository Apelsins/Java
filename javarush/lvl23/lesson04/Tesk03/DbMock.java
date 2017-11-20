package lvl23.lesson04.Tesk03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ATarasevich on 01.08.2017.
 */
public class DbMock {
    private static final List<Task03.Task> FAKE_TASKS = new ArrayList<>();
    private static final List<String> FAKE_NAMES = new ArrayList<>();

    public static List<Task03.Task> getFakeTasks(Map criteria) {
        return ViewMock.getFakeTasksCriteria().equals(criteria) ? FAKE_TASKS : null;
    }

    public static List<String> getFakeNames(Map criteria) {
        return ViewMock.getFakeNamesCriteria().equals(criteria) ? FAKE_NAMES : null;
    }
}
