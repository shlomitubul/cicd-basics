
 import org.testng.TestNG;

 import java.io.File;
 import java.io.IOException;
 import java.io.InputStream;
 import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 import java.nio.file.StandardCopyOption;
 import java.util.logging.Level;

 public class TestRunner {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
       copy(TestRunner.class.getClassLoader().getResourceAsStream(args[0]), "testng.xml");
       Thread.sleep(4000);
       TestNG.main(args);
    }


    public static boolean copy(InputStream source , String destination) {
        boolean succeess = true;
        System.out.println("Copying ->" + source + "\n\tto ->" + destination);
        try {
            Files.copy(source, Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            succeess = false;
        }

        return succeess;

    }
}

