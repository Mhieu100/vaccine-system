package team.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import team.project.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    UserDetailsService userDetailsService(UserService userService) {
        return new CustomUserDetailsService(userService);
    }

    @Bean
    AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new SuccessHandler();
    }

    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider(PasswordEncoder passwordEncoder,
                                                        UserDetailsService userDetailsService) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setHideUserNotFoundExceptions(false);
        return authenticationProvider;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests
                        (authorize -> authorize
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/admin/**").hasAnyRole("ADMIN","DOCTOR", "RECEPTIONIST")
                                .anyRequest().authenticated())
                .logout(logout -> logout.deleteCookies("JSESSIONID").invalidateHttpSession(true))
                .formLogin(formLogin -> formLogin.loginPage("/login")
                        .failureUrl("/login?error")
                        .successHandler(authenticationSuccessHandler())
                        .permitAll())
                .exceptionHandling(ex -> ex.accessDeniedPage("/access-deny"));
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        return httpSecurity.build();
    }
}
