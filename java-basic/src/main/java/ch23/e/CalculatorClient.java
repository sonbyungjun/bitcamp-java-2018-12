package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    
    int id = 0;
    
    while (true) {
      System.out.print("> ");
      String input = keyboard.nextLine();
      

      try (Socket socket = new Socket("localhost", 8888);
          PrintStream out = new PrintStream(socket.getOutputStream());
          BufferedReader in = new BufferedReader(
              new InputStreamReader(socket.getInputStream()))) {
        
        out.println(id);
        out.flush();
        
        if (id == 0) {
          id = Integer.parseInt(in.readLine());
          System.out.println(id);
        }
        
        out.println(input);
        out.flush();
        
        if (input.equalsIgnoreCase("reset")) {
          System.out.println("값이 초기화 되었음.");
          continue;
          
        } else if (input.equalsIgnoreCase("quit")) {
          System.out.println(in.readLine());
          break;
          
        }

        System.out.println(in.readLine());

      } catch (Exception e) {
        e.printStackTrace();
      }
      
    } // while
    
    keyboard.close();
  }
}











