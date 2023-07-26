package ru.itis.notepad.test.base;

import org.junit.Before;
import ru.itis.notepad.app.ApplicationManager;

public class TestBase {

    protected ApplicationManager applicationManager;

    @Before
    public void setUp() throws Exception {
        applicationManager = ApplicationManager.GetInstance();

    }

}