package bitcamp.ex06;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/ex06/s3", loadOnStartup=1, initParams={
    @WebInitParam(name="jdbc.driver", value="org.mariadb.jdbc.Driver"),
    @WebInitParam(name="jdbc.url", value="jdbc:mariadb://localhost/bitcampdb"),
    @WebInitParam(name="jdbc.username", value="bitcamp"),
    @WebInitParam(name="jdbc.password", value="1111")
    })
@SuppressWarnings("serial")
public class Servlet03 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    ServletConfig config = this.getServletConfig();
    
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.printf("driver=%s\n", config.getInitParameter("jdbc.driver"));
    out.printf("url=%s\n", config.getInitParameter("jdbc.url"));
    out.printf("username=%s\n", config.getInitParameter("jdbc.username"));
    out.printf("password=%s\n", config.getInitParameter("jdbc.password"));
    
  }
}