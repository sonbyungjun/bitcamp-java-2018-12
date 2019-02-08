package design_pattern.observer.after;

import java.util.HashSet;

public class Car {
  
  HashSet<CarObserver> observers = new HashSet<>();
  
  public void addObserver(CarObserver observer) {
    observers.add(observer);
  }
  
  public void removeObserver(CarObserver observer) {
    observers.remove(observer);
  }
  
  public void notifyObserversOnStarted() {
    for (CarObserver observer : observers) {
      observer.carStarted();
    }
  }
  
  public void notifyObserversOnStopped() {
    for (CarObserver observer : observers) {
      observer.carStopped();
    }
  }
  
  public void start() {
    System.out.println("시동을 건다.");
    
    notifyObserversOnStarted();
    
  }
  
  public void run() {
    System.out.println("달린다.");
  }
  
  public void stop() {
    System.out.println("시동을 끈다.");
    
    notifyObserversOnStopped();
    
  }
  
  
  
}
