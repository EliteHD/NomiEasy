package mx.ulsa.josiaslpsw.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http.
                csrf(AbstractHttpConfigurer::disable);
        http
                .authorizeHttpRequests((httpRequests) -> {
                    httpRequests.requestMatchers(new AntPathRequestMatcher("/"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/home"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/WEB-INF/**"))
                            .permitAll().requestMatchers(new AntPathRequestMatcher("/css/**"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/images/**"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/js/**"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/panel/**"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/loginUser"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/register"))
                            .permitAll()

                            .requestMatchers(new AntPathRequestMatcher("/addUser","GET"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/saveUser","POST"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/dashboard"))
                            .hasAuthority("administrador")
                            .requestMatchers(new AntPathRequestMatcher("/imagen"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/upload"))
                            .permitAll()



                            .requestMatchers(new AntPathRequestMatcher("/user1"))
                            .hasAuthority("usuario")
                            .anyRequest()
                            .authenticated();
                })
                .formLogin((formLogin) -> {
                    formLogin.loginPage("/loginUser")
                            .loginProcessingUrl("/loginUser")
                            .defaultSuccessUrl("/redirect") //me lleva a la pagina segun corresponda del tipo de usuario
                            .permitAll();
                })
                .logout((logout) -> {
                    logout.logoutUrl("/logout")
                            .logoutSuccessUrl("/home")
                            .permitAll();
                });
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}