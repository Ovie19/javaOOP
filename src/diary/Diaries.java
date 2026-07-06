package diary;

import java.util.ArrayList;
import java.util.List;

public class Diaries {
    private final List<Diary> diaries = new ArrayList<>();
    private int diaryCount;

    public void add(String username, String password) {
        Diary foundDiary = findByUsername(username);
        if (foundDiary != null) throw new IllegalArgumentException("Username already exists!");

        Diary newDiary = new Diary(username, password);
        diaries.add(newDiary);
        diaryCount++;
    }


    public Diary findByUsername(String username) {
        for (Diary diary : diaries) {
            if (diary.getUsername().equals(username)) {
                return diary;
            }
        }
        return null;
    }

    public void delete(String username, String password) {
        Diary foundDiary = findByUsername(username);
        if  (foundDiary == null) throw new IllegalArgumentException("Username not found!");

        foundDiary.unlockDiary(password);

        diaries.remove(foundDiary);
        diaryCount--;
    }

    public int getDiariesCount() {
        return diaryCount;
    }
}
