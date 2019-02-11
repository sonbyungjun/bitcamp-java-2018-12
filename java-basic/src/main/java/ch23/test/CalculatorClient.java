package ch23.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {

  public static void main(String[] args) {

    try (Scanner keyboard = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8888);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream())) {

      while (true) {
        String input = in.readLine();
        System.out.println(input);
        if (input.length() == 0)
          break;
      }

      while (true) {
        
        System.out.print("> ");
        String input = keyboard.nextLine();
        out.println(input);
        out.flush();
        
        System.out.println(in.readLine());
        
        if (input.equalsIgnoreCase("quit"))
          break;
      }

    } catch (Exception e) {
      e.printStackTrace();

    }


  }

}
