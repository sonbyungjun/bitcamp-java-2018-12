package ch19.d;

public final class Category {

  public static class computer {

    public static class mouse {
      public static final int bluetooth = 111;
      public static final int gaming = 112;
      public static final int wired = 113;
      public static final int trackball = 113;
    }
    
    public static final int keyboard = 102;
    public static final int monitor = 103;
    public static final int cpu = 104;
    public static final int ram = 105;
    public static final int vga = 106;
  }

  public static class appliance {
    public static final int tv = 201;
    public static final int audio = 202;
    public static final int dvd = 203;
    public static final int vacuum = 204;
  }

  public static class book {
    public static final int poet = 301;
    public static final int novel = 302;
    public static final int essay = 303;
    public static final int it = 304;
    public static final int lang = 305;
  }
}
