package firstPack.Test;

;
import firstPack.rootClasses.Contact;
import org.junit.runner.JUnitCore;

import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Stas on 04.07.2015.
 */
public class TestRunner {


    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(TestSuit.class);

        for (Failure failure: result.getFailures())
        {
            System.out.println(failure);
        }
        System.out.println(result.wasSuccessful());
    }
}

