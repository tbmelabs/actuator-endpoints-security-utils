package ch.tbmelabs.actuatorendpointssecurityutils.configuration;

import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

@Order(2)
@Configuration
@EnableWebSecurity
public class ActuatorEndpointSecurityConfiguration extends WebSecurityConfigurerAdapter {

  private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

  private ObjectPostProcessor<Object> objectPostProcessor;

  private String actuatorUserName;
  private String actuatorUserPassword;
  private String actuatorUserRole;

  public ActuatorEndpointSecurityConfiguration(ObjectPostProcessor<Object> objectPostProcessor,
      ApplicationProperties applicationProperties) {
    this.objectPostProcessor = objectPostProcessor;

    this.actuatorUserName =
        applicationProperties.getEureka().getInstance().getMetadataMap().getUser().getName();
    this.actuatorUserPassword =
        applicationProperties.getEureka().getInstance().getMetadataMap().getUser().getPassword();
    this.actuatorUserRole =
        applicationProperties.getEureka().getInstance().getMetadataMap().getUser().getRole();
  }

  @PostConstruct
  public void postConstruct() {
    Assert.notNull(actuatorUserName, "You must specify an actuator user name!");
    Assert.notNull(actuatorUserPassword, "You must specify an actuator user password!");
    Assert.notNull(actuatorUserRole, "You must specify an actuator user role!");
  }

  @Override
  protected AuthenticationManager authenticationManager() throws Exception {
    AuthenticationManagerBuilder builder = new AuthenticationManagerBuilder(objectPostProcessor);
    builder.inMemoryAuthentication().passwordEncoder(PASSWORD_ENCODER).withUser(actuatorUserName)
        .password(PASSWORD_ENCODER.encode(actuatorUserPassword)).roles(actuatorUserRole);
    return builder.build();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // @formatter:off
    http

        .antMatcher("/actuator/**").authorizeRequests()
          .antMatchers("/actuator/**").hasRole(actuatorUserRole)

        .and().httpBasic();
    // @formatter:on
  }
}
