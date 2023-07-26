package ru.itis.notepad.app;

import autoitx4java.AutoItX;
import com.jacob.com.LibraryLoader;
import org.junit.Assert;
import ru.itis.notepad.helper.TextHelper;

import java.io.File;

import static org.junit.Assert.fail;

public class ApplicationManager {
    protected TextHelper text;
    public static AutoItX x;
    private StringBuffer verificationErrors = new StringBuffer();

    private static ThreadLocal<ApplicationManager> app = new ThreadLocal<ApplicationManager>();

    private ApplicationManager() {
        File file = new File("C:\\Users\\Milana\\Desktop\\jacob-1.20-x64.dll");
        System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
        LibraryLoader.loadJacobLibrary();
        x = new AutoItX();
        text = new TextHelper(this);

    }

    public void stop() {
        x.winClose("*new 1 - Notepad++");
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public TextHelper getText() {
        return text;
    }

    public static ApplicationManager GetInstance() {
        if (app.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            app.set(newInstance);
        }
        return app.get();
    }

}