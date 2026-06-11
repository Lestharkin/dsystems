package lenin;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Server RMI
 *
 */
public class Main {
    public static void main(String[] args) {
        Properties config = new Properties();
        try (FileInputStream fin = new FileInputStream(new File("config.properties"))) {
            config.load(fin);
            Server server = new Server(
                    (String) config.get("IP"),
                    (String) config.get("PORT"),
                    (String) config.get("SERVICENAME"));
            server.deploy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
