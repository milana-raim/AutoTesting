import autoitx4java.AutoItX;
import com.jacob.com.LibraryLoader;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Milana\\Desktop\\jacob-1.20-x64.dll");
        System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
        LibraryLoader.loadJacobLibrary();
        AutoItX x = new AutoItX();
        x.run("C:\\Program Files\\Notepad++\\notepad++.exe");
        x.winWaitActive("*new 2 - Notepad++");
        x.send("Hello");
        String text = x.winGetText("*new 2 - Notepad++");

        System.out.println(text.substring(0,text.indexOf("\n")));

    }

}