package th.mfu;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/book").permitAll() // Allow access to /machines without authentication
                .anyRequest().authenticated() // Require authentication for other requests
                .and()
                .logout() // Configure logout
                    .logoutUrl("/logout") // Set the logout URL
                    .logoutSuccessUrl("/") // Redirect to home page after logout
                    .invalidateHttpSession(true) // Invalidate session
                    .deleteCookies("JSESSIONID") // Delete cookies if needed
                    .permitAll() // Allow all to access logout URL
                .and()
                .csrf().disable() // Disable CSRF (http://www.baeldung.com/spring-security-csrf)
            .httpBasic(); // Enable Basic Authentication
    }
}

