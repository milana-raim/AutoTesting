package ru.itis.notepad.models;

public class TextData {
    private String text;

    public TextData(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
