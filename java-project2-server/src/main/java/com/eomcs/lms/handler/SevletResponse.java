package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Date;

public class SevletResponse {
  
  BufferedReader in;
  PrintWriter out;
  
  public SevletResponse(BufferedReader in, PrintWriter out) {
    this.in = in;
    this.out = out;
  }
  
  public PrintWriter getWriter() {
    return out;
  }
  
  public void println(String message) {
    out.println(message);
  }
  
  public String requestString(String title) throws Exception {
    out.println(title);
    out.println("!{}!");
    out.flush();
    return in.readLine();
  }
  
  public int requestInt(String title) throws Exception {
    return Integer.parseInt(this.requestString(title));
  }
  
  public Date requestDate(String title) throws Exception {
    return Date.valueOf(this.requestString(title));
  }  
}












