package lenin;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Client RMI
 *
 */
public class Main {
    public static void main(String[] args) {
        Properties config = new Properties();
        try (FileInputStream fin = new FileInputStream(new File(
                "config.properties"))) {
            config.load(fin);
            Client client = new Client (
                    (String) config.get("IP"),
                    (String) config.get("PORT"),
                    (String) config.get("SERVICENAME"));            
            System.out.println("Resultado: " + String.valueOf(client.fn(100, 5)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
