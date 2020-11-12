package com.hfhk.cairo.starter.mongo.autoconfigure;

import com.hfhk.cairo.starter.mongo.auditing.UidAuditorWare;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@Configuration
public class MongoAuditorConfig {

	@Bean
	public UidAuditorWare uidAuditorWare() {
		return new UidAuditorWare();
	}

}
