package Solvegam;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class App 
{

    private static Logger logger;

    private static PropertyResourceBundle myBundle;

    private static Locale currentLocale = Locale.getDefault();

    public static void main( String[] args )
    {
        logger = loggerInitializing ();

        myBundle = bundleInitializing(currentLocale);

        int hours = new Date().getHours();

        String result = printSuitableMessage(hours, myBundle);
        System.out.println(result);
        logger.log(Level.INFO,"The current time was " + hours + " hours, so program printed following text: " + result);
    }

    public static String printSuitableMessage (int hours, PropertyResourceBundle bundle)
    {
       if ((hours < 6 && hours >= 0) || hours == 23)
       {
           return bundle.getString("4");
       }
        else if (hours < 9 && hours >= 6)
       {
           return bundle.getString("1");
       }
       else if (hours < 19 && hours >= 9)
       {
           return bundle.getString("2");
       }
       else if (hours < 23 && hours >= 19)
       {
           return bundle.getString("3");
       }
        else
       {
           return "Something went wrong";
       }
    }

    private static Logger loggerInitializing ()
    {
        Logger logger = Logger.getLogger(App.class.getName());
        logger.setUseParentHandlers(false);

        try {
            FileHandler handler = new FileHandler("%tApp",true);
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
        } catch (SecurityException e) {
            logger.log(Level.SEVERE,"File wasn't created because of your security",e);
        } catch (IOException e) {
            logger.log(Level.SEVERE,"Some problems with streams",e);
        }
        return logger;
    }

    private static PropertyResourceBundle bundleInitializing (Locale locale)
    {
        PropertyResourceBundle instance = null;
        try {
            instance = new PropertyResourceBundle(new FileInputStream("src\\text_"+locale.toString()+".properties"));
        } catch (FileNotFoundException e) {
           System.err.println("hmm, I guess your file is not there or doesn't exist");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return instance;
    }
}
