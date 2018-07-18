package com.utrack.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utrack.backend.common.AuditLog;
import com.utrack.backend.dao.AuditLogDAO;

@Service
public class AuditLogServiceImpl implements AuditLogService {

	@Autowired
	private AuditLogDAO AuditLogDAO;

	@Override
	public List<AuditLog> getLogs() {
		return AuditLogDAO.getAuditLogs();
	}

	@Override
	public void insertLog(AuditLog auditLog) {
		AuditLogDAO.insertLog(auditLog);
	}

}
