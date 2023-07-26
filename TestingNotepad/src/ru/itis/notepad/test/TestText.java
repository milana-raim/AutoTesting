package ru.itis.notepad.test;
import org.junit.Assert;
import org.junit.Test;
import ru.itis.notepad.models.TextData;
import ru.itis.notepad.test.base.TestBase;

public class TestText extends TestBase {

    TextData textData = new TextData("Hello");
    @Test
    public void testTextField(){
        applicationManager.getText().createText(textData);
        String text = applicationManager.getText().getText();
        Assert.assertEquals(text.substring(0,text.indexOf("\n")),textData.getText());
        applicationManager.stop();
    }
}
