package design_pattern.proxy.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
  int plus(int a, int b) throws RemoteException;
  int minus(int a, int b) throws RemoteException;
}
