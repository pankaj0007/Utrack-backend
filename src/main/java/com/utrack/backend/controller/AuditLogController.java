package com.utrack.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.utrack.backend.common.AuditLog;
import com.utrack.backend.service.AuditLogService;

@RestController
@RequestMapping("/utrack")
public class AuditLogController {

	@Autowired
	private AuditLogService auditLogService;

	@RequestMapping(value = "/logs", method = RequestMethod.GET)
	public ResponseEntity<Object> getAuditLogs() {
		List<AuditLog> auditLogs = auditLogService.getLogs();
		return new ResponseEntity<Object>(auditLogs, HttpStatus.OK);
	}

}
