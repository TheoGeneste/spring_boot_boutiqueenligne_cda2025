package com.cda.boutique.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * CONFIGURATION - Configuration de sécurité Spring Security
 * 
 * Rôle : Configure les règles de sécurité de l'application (authentification, autorisation, CSRF, etc.)
 * Cette configuration désactive la sécurité pour permettre l'accès à tous les endpoints
 */
@Configuration // @Configuration : Indique que cette classe contient des configurations Spring (beans)
public class SecurityConfig {
    
    /**
     * Configure la chaîne de filtres de sécurité Spring Security
     * 
     * @param http Objet HttpSecurity pour configurer la sécurité
     * @return SecurityFilterChain : Chaîne de filtres configurée
     * @throws Exception En cas d'erreur de configuration
     */
    @Bean // @Bean : Indique que cette méthode retourne un bean Spring géré par le conteneur IoC
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable()) // Désactive la protection CSRF (Cross-Site Request Forgery)
        .authorizeHttpRequests(auth -> 
            auth.anyRequest().permitAll() // Autorise toutes les requêtes sans authentification
            // anyRequest() : Toutes les requêtes HTTP
            // permitAll() : Permet l'accès sans authentification
        );
        return http.build(); // Construit et retourne la chaîne de filtres configurée
    }
    // Note : Cette configuration est très permissive (développement uniquement)
    // En production, il faudrait configurer l'authentification et les autorisations
}
