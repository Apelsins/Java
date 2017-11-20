package lvl23.lesson04.Tesk03;

import java.util.List;
import java.util.Map;

public class Task03 {

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = ViewMock.getFakeTasksCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = ViewMock.getFakeNamesCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }
    // 1) реализуйте private class TaskDataProvider используя Task и DbMock, цель которого — обновить поле tasks.
    private class TaskDataProvider implements DbDataProvider<Task> {
        @Override
        public void refreshAllData(Map criteria) {
            tasks = DbMock.getFakeTasks(criteria);
        }
    }

    // 2) реализуйте private class NameDataProvider используя String и DbMock, цель которого — обновить поле names.
    private class NameDataProvider implements DbDataProvider<String> {
        @Override
        public void refreshAllData(Map criteria) {
            names = DbMock.getFakeNames(criteria);
        }
    }

    public static void main(String[] args) {

    }
}

