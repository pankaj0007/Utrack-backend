package com.utrack.backend.service;

import java.util.List;

import com.utrack.backend.common.AuditLog;

public interface AuditLogService {

	public List<AuditLog> getLogs();
	
	public void insertLog(AuditLog auditLog);
}
