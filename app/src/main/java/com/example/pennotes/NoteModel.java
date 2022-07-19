package com.example.pennotes;

public class NoteModel {
    public NoteModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    String title;
    String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
