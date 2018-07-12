package com.utrack.backend.common;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.utrack.backend.interceptor.IAuditLog;

@Component
public class AuditLogUtil {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void logIt(String action, IAuditLog entity) {
		System.out.println("MongoDB operations");
		AuditLog log = new AuditLog(entity.getEntityId(), action, entity.getLogDetail(), new Date(), entity.getClass().toString());
		mongoTemplate.insert(log);
	}

}
