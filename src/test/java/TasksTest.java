import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Epic;
import ru.netology.Meeting;
import ru.netology.SimpleTask;

public class TasksTest {
    @Test
    public void shouldFalseQueryNotInSubtasks() {
        String[] subtasks = {"Подзадача1", "Подзадача2", "Подхадача3"};
        Epic epic = new Epic(65, subtasks);
        String query = "Подзадача4";
        boolean expected = false;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTrueQueryInSubtasks() {
        String[] subtasks = {"Подзадача1", "Подзадача2", "Подхадача3"};
        Epic epic = new Epic(65, subtasks);
        String query = "Подзадача2";
        boolean expected = true;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTrueQueryInTitle() {
        SimpleTask simpleTask = new SimpleTask(75, "Назвать задачу");
        String query = "задачу";
        boolean expected = true;
        boolean actual = simpleTask.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFalseQueryNotInTitle() {
        SimpleTask simpleTask = new SimpleTask(75, "Назвать задачу");
        String query = "задание";
        boolean expected = false;
        boolean actual = simpleTask.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTrueQueryInTopic() {
        Meeting meeting = new Meeting(76, "Задача первая", "Проект один", "завтра");
        String query = "первая";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTrueQueryInProject() {
        Meeting meeting = new Meeting(76, "Задача первая", "Проект один", "завтра");
        String query = "один";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFalseQueryNotInProjectAndProject() {
        Meeting meeting = new Meeting(76, "Задача первая", "Проект один", "завтра");
        String query = "две";
        boolean expected = false;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }
}
