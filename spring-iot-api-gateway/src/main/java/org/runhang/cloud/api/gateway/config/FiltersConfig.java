package org.runhang.cloud.api.gateway.config;

import org.runhang.cloud.api.gateway.filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FiltersConfig {

	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}


}
