package ru.itis.notepad.helper;

import ru.itis.notepad.app.ApplicationManager;
import ru.itis.notepad.models.TextData;

public class TextHelper extends HelperBase {
    public TextHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void createText(TextData textData) {
        x.run("C:\\Program Files\\Notepad++\\notepad++.exe");
        x.winWaitActive("new 1 - Notepad++");
        x.send("Hello");
    }
    public String getText() {
        String text = x.winGetText("*new 1 - Notepad++");
        return text;
    }
}
