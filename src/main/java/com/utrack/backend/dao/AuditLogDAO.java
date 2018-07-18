package com.utrack.backend.dao;

import java.util.List;

import com.utrack.backend.common.AuditLog;

public interface AuditLogDAO {

	public List<AuditLog> getAuditLogs();

	public void insertLog(AuditLog auditLog);

}
