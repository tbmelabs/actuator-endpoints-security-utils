package ch.tbmelabs.tv.core.authorizationserver.test.security.logging;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import ch.tbmelabs.tv.core.authorizationserver.domain.AuthenticationLog;
import ch.tbmelabs.tv.core.authorizationserver.domain.AuthenticationLog.AUTHENTICATION_STATE;
import ch.tbmelabs.tv.core.authorizationserver.domain.User;
import ch.tbmelabs.tv.core.authorizationserver.domain.repository.AuthenticationLogCRUDRepository;
import ch.tbmelabs.tv.core.authorizationserver.domain.repository.UserCRUDRepository;
import ch.tbmelabs.tv.core.authorizationserver.security.logging.AuthenticationAttemptLogger;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.stereotype.Component;

public class AuthenticationAttemptLoggerTest {

  @Mock
  private AuthenticationLogCRUDRepository mockAuthenticationLogRepository;

  @Mock
  private UserCRUDRepository mockUserRepository;

  @Spy
  @InjectMocks
  private AuthenticationAttemptLogger fixture;

  @Before
  public void beforeTestSetUp() {
    initMocks(this);

    doReturn(Optional.of(new User())).when(mockUserRepository)
        .findOneByUsernameIgnoreCase(ArgumentMatchers.anyString());
  }

  @Test
  public void authenticationAttemptLoggerShouldBeAnnotated() {
    assertThat(AuthenticationAttemptLogger.class).hasAnnotation(Component.class);
  }

  @Test
  public void authenticationAttemptLoggerShouldSaveNewAttempt() {
    fixture.logAuthenticationAttempt(AUTHENTICATION_STATE.OK, "127.0.0.1", "This is some message.",
        "Testuser");

    verify(mockUserRepository, times(1)).findOneByUsernameIgnoreCase(ArgumentMatchers.anyString());
    verify(mockAuthenticationLogRepository, times(1))
        .save(ArgumentMatchers.any(AuthenticationLog.class));
  }
}
