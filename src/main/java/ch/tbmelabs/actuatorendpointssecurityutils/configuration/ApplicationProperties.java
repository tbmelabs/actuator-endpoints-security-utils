package ch.tbmelabs.actuatorendpointssecurityutils.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties
public class ApplicationProperties {

  private Eureka eureka;

  @Data
  public static class Eureka {

    private Instance instance;

    @Data
    public static class Instance {

      private MetadataMap metadataMap;

      @Data
      public static class MetadataMap {

        private User user;

        @Data
        public static class User {

          private String name;
          private String password;
          private String role;
        }
      }
    }
  }
}
