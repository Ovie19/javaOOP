package diary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DiariesTest {

    private Diaries diaries;
    private final String username = "username";
    private final String password = "password";

    @BeforeEach
    public void setUp() {
        diaries = new Diaries();
    }

    @Test
    public void newDiariesCountIsZeroTest() {
        assertEquals(0, diaries.getDiariesCount());
    }

    @Test
    public void addDiary_diariesCountIsOneTest() {
        assertEquals(0, diaries.getDiariesCount());
        diaries.add(username, password);
        assertEquals(1, diaries.getDiariesCount());
    }

    @Test
    public void addDiaryTwice_diariesCountIsTwoTest() {
        assertEquals(0, diaries.getDiariesCount());
        diaries.add(username, password);
        diaries.add("username1", "password2");
        assertEquals(2, diaries.getDiariesCount());
    }

    @Test
    public void addDiary_findDiaryWithSameUsername_returnDiaryTest() {
        diaries.add(username, password);
        Diary myDiary = diaries.findByUsername(username);
        assertEquals(username, myDiary.getUsername());
    }

    @Test
    public void addDiary_addDiaryWithSameUsernameThrowsExceptionTest() {
        diaries.add(username, password);
        assertThrows(IllegalArgumentException.class, () -> diaries.add(username, password));
        assertEquals(1, diaries.getDiariesCount());
    }

    @Test
    public void addDiary_deleteDiary_diariesCountIsZeroTest() {
        diaries.add(username, password);
        diaries.delete(username, password);
        assertEquals(0, diaries.getDiariesCount());
    }

    @Test
    public void deleteDiaryWithWrongPasswordThrowsException_diariesCountIsUnchangedTest() {
        diaries.add(username, password);
        assertThrows(
                IllegalArgumentException.class,
                ()->diaries.delete(username, "password234")
        );
        assertEquals(1, diaries.getDiariesCount());
    }

    @Test
    public void deleteDiaryWithWrongUsernameThrowsException_diariesCountIsUnchangedTest() {
        diaries.add(username, password);
        assertThrows(
                IllegalArgumentException.class,
                ()->diaries.delete("username123", password)
        );
        assertEquals(1, diaries.getDiariesCount());
    }
}