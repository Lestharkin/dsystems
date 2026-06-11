package lenin;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Service extends UnicastRemoteObject implements RMI {

  private static final long serialVersionUID = 123L;

  protected Service() throws RemoteException {
    super();
  }

  @Override
  public int add(int a, int b) throws RemoteException {
    return a + b;
  }
  
}
