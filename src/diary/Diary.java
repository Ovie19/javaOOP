package diary;

import java.util.ArrayList;
import java.util.List;

public class Diary {
    private final String username;
    private String password;
    private boolean isLocked = true;
    private final List<Entry> entries;

    private int count;

    public Diary(String username, String password) {
        this.username = username;
        this.password = password;
        entries = new ArrayList<>();
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void unlockDiary(String password) {
        boolean isInvalidPassword = !this.password.equals(password);
        if (isInvalidPassword) throw new IllegalArgumentException("Invalid password");
        this.isLocked = false;
    }

    public void lockDiary() {
        this.isLocked = true;
    }

    public int createEntry(String title, String body) {
        if (isLocked) throw new IllegalArgumentException("Diary is locked");
        Entry entry = new Entry(++count, title, body);
        entries.add(entry);
        return count;
    }

    public Entry findEntryById(int entryId) {
        if (isLocked) throw new IllegalArgumentException("Diary is locked");
        for (Entry entry : entries) {
            if (entry.getId() == entryId) return entry;
        }
        throw new IllegalArgumentException("Entry with id " + entryId + " not found");
    }

    public void deleteEntry(int entryId) {
        Entry foundEntry = findEntryById(entryId);
        entries.remove(foundEntry);
    }

    public void updateEntry(int entryId, String title, String body) {
        Entry foundEntry = findEntryById(entryId);
        foundEntry.setTitle(title);
        foundEntry.setBody(body);
    }

    public String getUsername() {
        return this.username;
    }

    public int getEntriesCount() {
        return entries.size();
    }
}
