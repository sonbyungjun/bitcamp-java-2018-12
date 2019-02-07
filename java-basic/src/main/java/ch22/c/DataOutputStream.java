package ch22.c;

import java.io.IOException;
import java.io.OutputStream;

public class DataOutputStream extends OutputStream {
  
  OutputStream out;
  
  public DataOutputStream(OutputStream out) {
    this.out = out;
  }
  
  @Override
  public void write(int b) throws IOException {
    out.write(b);
  }
  
  public void writeShort(Short value) throws IOException {
    out.write(value >> 8);
    out.write(value);
  }
  
  public void writeInt(int value) throws IOException {
    out.write(value >> 24);
    out.write(value >> 16);
    out.write(value >> 8);
    out.write(value);
  }
  
  public void writeUTF(String value) throws IOException {
    byte[] bytes = value.getBytes("UTF-8");
    out.write(bytes.length >> 8);
    out.write(bytes.length);
    out.write(bytes);
  }
  
  @Override
  public void flush() throws IOException {
    out.flush();
  }
}
