package agile.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;

import agile.aop.logging.LoggingAspect;

@ConditionalOnProperty("application.logging-aspect.enabled")
@Configuration
@EnableAspectJAutoProxy
public class LoggingAspectAutoConfiguration {

	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspectAutoConfiguration.class);

    @Bean
    public LoggingAspect loggingAspect(Environment env) {
    	logger.debug("Creating Logging Aspect");
        return new LoggingAspect(env);
    }

}
