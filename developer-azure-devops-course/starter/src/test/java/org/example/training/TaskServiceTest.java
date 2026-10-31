package org.example.training;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class TaskServiceTest {
    @Test
    void addsTrimmedTitlesWithSequentialIds() {
        TaskService service = new TaskService();
        Task first = service.add("  Review work item  ");
        Task second = service.add("Write tests");

        assertEquals(1, first.id());
        assertEquals(2, second.id());
        assertEquals("Review work item", first.title());
        assertFalse(first.completed());
        assertEquals(List.of(first, second), service.list());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t\n"})
    void rejectsBlankTitlesWithoutChangingState(String title) {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class, () -> service.add(title));
        assertTrue(service.list().isEmpty());
        assertEquals(1, service.add("Valid task").id());
    }

    @Test
    void completesOnlyTheRequestedTaskAndIsIdempotent() {
        TaskService service = new TaskService();
        Task first = service.add("First");
        Task second = service.add("Second");

        Task completed = service.complete(first.id());

        assertTrue(completed.completed());
        assertEquals(first.id(), completed.id());
        assertEquals(first.title(), completed.title());
        assertEquals(completed, service.complete(first.id()));
        assertEquals(List.of(completed, second), service.list());
    }

    @Test
    void missingTaskDoesNotChangeState() {
        TaskService service = new TaskService();
        Task task = service.add("Keep this task");

        assertThrows(NoSuchElementException.class, () -> service.complete(999));
        assertEquals(List.of(task), service.list());
    }

    @Test
    void listsAreImmutableSnapshots() {
        TaskService service = new TaskService();
        Task first = service.add("First");
        List<Task> snapshot = service.list();

        assertThrows(UnsupportedOperationException.class, () -> snapshot.clear());
        service.add("Second");
        service.complete(first.id());

        assertEquals(List.of(first), snapshot);
        assertEquals(2, service.list().size());
    }
}
