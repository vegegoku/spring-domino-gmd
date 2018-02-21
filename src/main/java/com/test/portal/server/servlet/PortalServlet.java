package com.test.portal.server.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PortalServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    int nRead;
    byte[] data = new byte[1024];
    while ((nRead = request.getInputStream()
        .read(data, 0, data.length)) != -1) {
      buffer.write(data, 0, nRead);
    }
    buffer.flush();
    byte[] byteArray = buffer.toByteArray();

    String msgRequest = new String(byteArray, StandardCharsets.UTF_8);
    String msgResponse = "Client said: \"" + msgRequest + "\" Server answered: \"Hi!\"";
    OutputStream os = response.getOutputStream();
    os.write(msgResponse.getBytes());
  }

}