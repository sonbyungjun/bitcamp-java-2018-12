package design_pattern.proxy.rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteObjectServer {

  public static void main(String[] args) {

//    if (System.getSecurityManager() == null) {
//      System.setSecurityManager(new SecurityManager());
//    }
    
    try {
      Calculator calcObj = new CalculatorImpl();
      
      Calculator stub = (Calculator) UnicastRemoteObject.exportObject(calcObj, 0);
      
      Registry registry = LocateRegistry.getRegistry("study.bitcamp.co.kr");
      
      registry.rebind("calc", stub);
      
      System.out.println("calculator 객체의 프록시(stub)가 RMI Registry 서버에 등록되었다.");

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
