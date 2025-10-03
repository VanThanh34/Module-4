package com.example.user.config;


import com.example.user.service.UserInfoDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final UserInfoDetailService userInfoDetailService;

    public SecurityConfig(UserInfoDetailService userInfoDetailService) {
        this.userInfoDetailService = userInfoDetailService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(PasswordEncoder encoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userInfoDetailService);
        provider.setPasswordEncoder(encoder);
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf((csrf) -> csrf.disable())
//                Config các đường dẫn không cần đăng nhập
                .authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests
                                .requestMatchers("/login", "/logoutSuccessful", "/403").permitAll()
                                .requestMatchers("/blogs/create").hasRole("ADMIN")
                                .requestMatchers("/blogs").hasAnyRole("USER", "ADMIN")
                                .requestMatchers( "/logout").authenticated())
//               Cấu hình lại form login
                .formLogin((formLogin) ->
                        formLogin
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .loginPage("/login")
                                .failureUrl("/login?error=true")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/blogs"))
                .logout((logout) ->
                        logout.deleteCookies("remove")
                                .invalidateHttpSession(false)
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/logoutSuccessful"))
                // Cấu hình lỗi 403 - Truy cập bị từ chối
                .exceptionHandling((exception) ->
                        exception
                                .accessDeniedPage("/403")
                );
        return httpSecurity.build();
    }

}
