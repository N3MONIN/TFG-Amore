package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers("/webjars/**", "/css/**", "/img/**","/resources/**", "/js/**", "/fonts/**").permitAll() // rec.estaticos
                .antMatchers("/public").permitAll()
                .antMatchers("/productos").permitAll()
                .antMatchers("/valoracion/new/**").hasRole("USER")
                .antMatchers("/productos/**").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers("/categorias/**").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers("/valoracion/**").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers("/valoracion/").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers("/usuario/new/**").permitAll()
                .antMatchers("/usuario/**").hasRole("ADMIN")
                .antMatchers("/usuario/**").hasRole("ADMIN")
                .antMatchers("/new/**").hasRole("ADMIN")
                .antMatchers("/edit/**").hasRole("ADMIN")
                .antMatchers("/delete/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/accessError");
        return http.build();
    }
}