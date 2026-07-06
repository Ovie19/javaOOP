package diary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryTest {

    private Diary diary;
    private final String password = "Ghost999";

    @BeforeEach
    void setUp() {
        diary = new Diary("Ghost2003", password);
    }

    @Test
    public void newDiaryIsLockedTest() {
        assertTrue(diary.isLocked());
    }

    @Test
    public void unlockDiary_diaryIsUnlockedTest() {
        diary.unlockDiary(password);
        assertFalse(diary.isLocked());
    }

    @Test
    public void unlockDiaryWithWrongPasswordThrowExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> diary.unlockDiary("wrong password"));
        assertTrue(diary.isLocked());
    }

    @Test
    public void unlockDiary_lockDiary_diaryIsLockedTest() {
        diary.unlockDiary(password);
        diary.lockDiary();
        assertTrue(diary.isLocked());
    }

    @Test
    public void createEntry_numberOfEntriesIs1Test() {
        diary.unlockDiary(password);
        diary.createEntry("Semicolon Shege", "Omo, semicolon is after my life ooo.");
        assertEquals(1, diary.getEntriesCount());
    }

    @Test
    public void createEntryTwice_numberOfEntriesIs2Test() {
        diary.unlockDiary(password);
        diary.createEntry("Semicolon Shege", "Omo, semicolon is after my life ooo.");
        diary.createEntry("Semicolon Shege Part 2", "Omo, semicolon is still after my life ooo.");
        assertEquals(2, diary.getEntriesCount());
    }

    @Test
    public void createEntryWhenDiaryIsLockedThrowsExceptionTest() {
        assertTrue(diary.isLocked());
        assertThrows(
            IllegalArgumentException.class,
            () -> diary.createEntry("Semicolon Shege", "Omo, semicolon is after my life ooo.")
        );
    }

    @Test
    public void findEntryUsingId_returnsEntryTest() {
        String title = "Semicolon Shege";
        String content = "Omo, semicolon is after my life ooo.";

        diary.unlockDiary(password);
        int entryId = diary.createEntry(title, content);
        Entry entry = diary.findEntryById(entryId);
        assertEquals(title, entry.getTitle());
        assertEquals(content, entry.getBody());
    }

    @Test
    public void findEntryUsingInvalidId_throwsExceptionTest() {
        diary.unlockDiary(password);
        assertThrows(
                IllegalArgumentException.class,
                () -> diary.findEntryById(1234)
        );
    }

    @Test
    public void findEntryWhenDiaryIsLocked_throwsExceptionTest() {
        diary.unlockDiary(password);
        int entryId = diary.createEntry("title", "content");
        diary.lockDiary();
        assertTrue(diary.isLocked());
        assertThrows(
            IllegalArgumentException.class,
            () -> diary.findEntryById(entryId)
        );
    }

    @Test
    public void createEntry_deleteEntryById_numberOfEntriesIs0Test() {
        diary.unlockDiary(password);
        int entryId = diary.createEntry("title", "content");
        assertEquals(1, diary.getEntriesCount());
        diary.deleteEntry(entryId);
        assertEquals(0, diary.getEntriesCount());
    }

    @Test
    public void deleteEntryWhenDiaryIsLocked_throwsExceptionTest() {
        diary.unlockDiary(password);
        int entryId = diary.createEntry("title", "content");
        diary.lockDiary();
        assertTrue(diary.isLocked());
        assertThrows(
                IllegalArgumentException.class,
                () -> diary.deleteEntry(entryId)
        );
    }

    @Test
    public void createEntry_updateEntry_changesAreVisibleTest() {
        diary.unlockDiary(password);
        int entryId = diary.createEntry("title", "content");
        diary.updateEntry(entryId, "new title", "new body");
        Entry entry = diary.findEntryById(entryId);
        assertEquals("new title", entry.getTitle());
        assertEquals("new body", entry.getBody());
    }

    @Test
    public void updateEntryWhenDiaryIsLocked_throwsExceptionTest() {
        diary.unlockDiary(password);
        int entryId = diary.createEntry("title", "content");
        diary.lockDiary();
        assertTrue(diary.isLocked());

        assertThrows(
                IllegalArgumentException.class,
                () -> diary.updateEntry(entryId, "new title", "new body")
        );
    }
}