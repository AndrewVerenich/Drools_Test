package by.andver.configuration;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DroolsConfiguration {

    @Bean
    KieContainer getKieContainer() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer container = kieServices.getKieClasspathContainer();
        return container;
    }

    @Bean(name = "statelessKieSession")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    StatelessKieSession getKieSession() {
        StatelessKieSession session = getKieContainer().newStatelessKieSession();
        session.setGlobal("ksession", session);
        return session;
    }
}
