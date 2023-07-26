package ru.itis.notepad.helper;

import autoitx4java.AutoItX;
import ru.itis.notepad.app.ApplicationManager;

public class HelperBase {

    protected ApplicationManager manager;
    public static AutoItX x;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
        this.x = manager.x;
    }

}