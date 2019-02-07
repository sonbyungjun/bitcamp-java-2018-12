package ch22.c;

import java.io.IOException;
import java.io.OutputStream;

public class BufferedOutputStream extends OutputStream {

  OutputStream out;
  byte[] buf = new byte[1024];
  int size = 0;
  
  public BufferedOutputStream(OutputStream out) {
    this.out = out;
  }
  
  @Override
  public void write(int b) throws IOException {
    buf[size++] = (byte)b;
    if (size >= 1024) {
      out.write(buf);
      size = 0;
    }
  }
  
  @Override
  public void flush() throws IOException {
    if (size > 0) {
      out.write(buf, 0, size);
    }
  }
  
}
