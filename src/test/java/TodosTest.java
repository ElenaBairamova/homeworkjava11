import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.*;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnArrayWithOneMatches() {
        SimpleTask simpleTask = new SimpleTask(78, "Задача первая");
        String[] subtasks = {"подзадача1", "подзадача2", "подзадача3"};
        Epic epic = new Epic(56, subtasks);
        Meeting meeting = new Meeting(67, "Название первое", "Проект первый", "завтра утро");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {epic};
        Task[] actual = todos.search("подзадача2");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnArrayWithEmptyMatches() {
        SimpleTask simpleTask = new SimpleTask(78, "Задача первая");
        String[] subtasks = {"подзадача1", "подзадача2", "подзадача3"};
        Epic epic = new Epic(56, subtasks);
        Meeting meeting = new Meeting(67, "Название первое", "Проект первый", "завтра утро");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnArrayWithNoMatches() {
        SimpleTask simpleTask = new SimpleTask(78, "Задача первая");
        String[] subtasks = {"подзадача1", "подзадача2", "подзадача3"};
        Epic epic = new Epic(56, subtasks);
        Meeting meeting = new Meeting(67, "Название первое", "Проект первый", "завтра утро");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {};
        Task[] actual = todos.search("привет");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnArrayWithTwoMatches() {
        SimpleTask simpleTask = new SimpleTask(78, "Задача первая");
        String[] subtasks = {"подзадача первая", "подзадача2", "подзадача3"};
        Epic epic = new Epic(56, subtasks);
        Meeting meeting = new Meeting(67, "Название первое", "Проект первый", "завтра утро");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("первая");
        Assertions.assertArrayEquals(expected, actual);
    }
}
