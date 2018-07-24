package agile.autoconfigure;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import io.github.jhipster.async.ExceptionHandlingAsyncTaskExecutor;
import io.github.jhipster.config.JHipsterProperties;

@ConditionalOnProperty(value = "application.async.enabled")
@Configuration
@EnableAsync
@EnableScheduling
public class AsyncAutoConfiguration implements AsyncConfigurer {

	private final Logger logger = LoggerFactory.getLogger(AsyncAutoConfiguration.class);

	private final JHipsterProperties jHipsterProperties;

	private final String applicationName;

	public AsyncAutoConfiguration(JHipsterProperties jHipsterProperties,
			@Value("spring.application.name") String applicationName) {
		this.jHipsterProperties = jHipsterProperties;
		this.applicationName = applicationName;
	}

	@Override
	@Bean(name = "taskExecutor")
	public Executor getAsyncExecutor() {
		logger.debug("Creating Async Task Executor");
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(jHipsterProperties.getAsync().getCorePoolSize());
		executor.setMaxPoolSize(jHipsterProperties.getAsync().getMaxPoolSize());
		executor.setQueueCapacity(jHipsterProperties.getAsync().getQueueCapacity());
		executor.setThreadNamePrefix(applicationName + "-Executor-");
		return new ExceptionHandlingAsyncTaskExecutor(executor);
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new SimpleAsyncUncaughtExceptionHandler();
	}

}
