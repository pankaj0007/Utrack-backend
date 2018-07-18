package com.utrack.backend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.utrack.backend.common.AuditLog;

@Repository
public class AuditLogDAOImpl implements AuditLogDAO {

	@Autowired
	private MongoTemplate mangoTemplate;

	@Override
	public List<AuditLog> getAuditLogs() {
		List<AuditLog> auditLogs = mangoTemplate.findAll(AuditLog.class);
		return auditLogs;
	}

	@Override
	public void insertLog(AuditLog auditLog) {
		mangoTemplate.save(auditLog);
	}

}
