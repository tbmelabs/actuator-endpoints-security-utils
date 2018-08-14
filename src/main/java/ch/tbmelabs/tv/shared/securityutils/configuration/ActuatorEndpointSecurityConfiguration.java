package ch.tbmelabs.tv.shared.securityutils.configuration;

import ch.tbmelabs.tv.shared.constants.security.ClientUserRole;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Order(2)
@Configuration
@EnableWebSecurity
public class ActuatorEndpointSecurityConfiguration extends WebSecurityConfigurerAdapter {

  private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

  private ObjectPostProcessor<Object> objectPostProcessor;

  private String actuatorUserName;
  private String actuatorUserPassword;

  public ActuatorEndpointSecurityConfiguration(ObjectPostProcessor<Object> objectPostProcessor,
      ApplicationProperties applicationProperties) {
    this.objectPostProcessor = objectPostProcessor;

    this.actuatorUserName =
        applicationProperties.getEureka().getInstance().getMetadataMap().getUser().getName();
    this.actuatorUserPassword =
        applicationProperties.getEureka().getInstance().getMetadataMap().getUser().getPassword();
  }

  @Override
  protected AuthenticationManager authenticationManager() throws Exception {
    AuthenticationManagerBuilder builder = new AuthenticationManagerBuilder(objectPostProcessor);
    builder.inMemoryAuthentication().passwordEncoder(PASSWORD_ENCODER).withUser(actuatorUserName)
        .password(PASSWORD_ENCODER.encode(actuatorUserPassword))
        .roles(ClientUserRole.ACTUATOR_ROLE);
    return builder.build();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // @formatter:off
    http

        .antMatcher("/actuator/**").authorizeRequests()
          .antMatchers("/actuator/**").hasRole(ClientUserRole.ACTUATOR_ROLE)

        .and().httpBasic();
    // @formatter:on
  }
}
