package com.myworkspace.reportapp.config.auditing;

        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.data.domain.AuditorAware;
        import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
        import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
        import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.myworkspace.reportapp.repository")
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AuditingConfig {

    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditorAwareImpl();
    }
}
