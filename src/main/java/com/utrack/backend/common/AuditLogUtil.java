package com.utrack.backend.common;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.utrack.backend.interceptor.IAuditLog;
import com.utrack.backend.service.AuditLogService;

@Component
public class AuditLogUtil {

	@Autowired
	private AuditLogService auditLogService;

	public void logIt(String action, IAuditLog entity) {
		System.out.println("MongoDB operations");
		AuditLog auditLog = new AuditLog(entity.getEntityId(), action, entity.getPreviousData(),
				entity.getCurrentData(), new Date(), entity.getClass().toString());
		auditLogService.insertLog(auditLog);
	}

}
