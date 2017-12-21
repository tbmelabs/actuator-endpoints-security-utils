package ch.tbmelabs.tv.core.entryserver.web;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultRedirectController {
  // TODO: Is the zuul server a UI server in the mean time?
  @RequestMapping(value = { "/" }, method = RequestMethod.GET)
  public String mapRootUri(HttpServletResponse response) throws IOException {
    // response.sendRedirect("/webapp");

    return "Root: " + UUID.randomUUID().toString();
  }

  @RequestMapping(value = { "/public" }, method = RequestMethod.GET)
  public String mapPublicUri(HttpServletResponse response) throws IOException {
    // response.sendRedirect("/webapp");

    return "Public: " + UUID.randomUUID().toString();
  }
}