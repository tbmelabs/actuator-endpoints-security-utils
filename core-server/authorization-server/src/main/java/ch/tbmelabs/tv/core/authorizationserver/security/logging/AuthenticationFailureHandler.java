package ch.tbmelabs.tv.core.authorizationserver.security.logging;

import ch.tbmelabs.tv.core.authorizationserver.domain.AuthenticationLog.AUTHENTICATION_STATE;
import ch.tbmelabs.tv.core.authorizationserver.service.bruteforce.BruteforceFilterService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

  private static final String X_FORWARDED_HEADER = "X-FORWARDED-FOR";
  private static final String USERNAME_PARAMETER = "username";

  private AuthenticationAttemptLogger authenticationLogger;

  private BruteforceFilterService bruteforceFilter;

  public AuthenticationFailureHandler(AuthenticationAttemptLogger authenticationAttemptLogger,
      BruteforceFilterService bruteforceFilterService) {
    this.authenticationLogger = authenticationAttemptLogger;
    this.bruteforceFilter = bruteforceFilterService;
  }

  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException exception) throws IOException, ServletException {
    super.onAuthenticationFailure(request, response, exception);

    String requestIp = request.getHeader(X_FORWARDED_HEADER);
    if (requestIp == null) {
      requestIp = request.getRemoteAddr();
    }

    logger.debug("Failed authentication from " + requestIp);

    authenticationLogger.logAuthenticationAttempt(AUTHENTICATION_STATE.NOK, requestIp,
        exception.getLocalizedMessage(), request.getParameter(USERNAME_PARAMETER));

    bruteforceFilter.authenticationFromIpFailed(requestIp);
  }
}
