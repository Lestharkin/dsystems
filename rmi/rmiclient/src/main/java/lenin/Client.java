package lenin;

import java.rmi.Naming;

public class Client {

  private String uri;  

  public Client(String ipService, String portService, String serviceName) {
    this.uri = "rmi://" + ipService + ":" + portService + "/" + serviceName;
  }

  public int fn(int a, int b) {
    RMI service;
    try {
      service = (RMI) Naming.lookup(uri);
      return service.add(a, b);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0;
  }
  
}
