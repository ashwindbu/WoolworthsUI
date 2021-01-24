package Helper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class Config {

    public static String read (String path, String property) {
        try (Reader read = new FileReader(path)) {
            Properties prop = new Properties();
            prop.load(read);
            return prop.getProperty(property);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } return "";
    }

    public static String read (String property) {
        try (Reader read = new FileReader("./config/config.properties")) {
            Properties prop = new Properties();
            prop.load(read);
            return prop.getProperty(property);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } return "";
    }
}
