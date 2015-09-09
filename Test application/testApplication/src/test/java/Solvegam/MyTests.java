package Solvegam;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.PropertyResourceBundle;

import static org.junit.Assert.*;

/**
 * Created by Stas on 09.09.2015.
 */
public class MyTests {

    @Test
    public void printSuitableMessageTest ()
    {
        PropertyResourceBundle boundle = null;
        try {
            boundle = new PropertyResourceBundle(new FileInputStream("src\\text_"+ Locale.getDefault().toString()+".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String text = App.printSuitableMessage(5,boundle);
        assertTrue(text.equals(boundle.getString("4")));
    }

}
