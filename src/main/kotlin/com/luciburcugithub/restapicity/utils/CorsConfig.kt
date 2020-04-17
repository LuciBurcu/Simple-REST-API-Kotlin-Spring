package com.luciburcugithub.restapicity.utils

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class CorsConfig {
    @Bean
    fun configureCors(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/**")
                        .allowedOrigins(CORS_LOCALHOST)
                        .allowedHeaders("*")
                        .allowedMethods("*")
            }
        }
    }

}

//TODO
const val CORS_LOCALHOST = "http://localhost:3000"