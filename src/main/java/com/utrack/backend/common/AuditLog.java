package com.utrack.backend.common;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "auditLogs")
public class AuditLog implements Serializable {

	public AuditLog(int entityId, String action, String logDetail, Date createdDate, String entityName) {
		this.entityId = entityId;
		this.action = action;
		this.logDetail = logDetail;
		this.createdDate = createdDate;
		this.entityName = entityName;
	}

	public AuditLog() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private long auditLogId;

	private String action;

	private String logDetail;

	private Date createdDate;

	private int entityId;

	private String entityName;

}
