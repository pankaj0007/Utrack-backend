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

	public AuditLog(int entityId, String action, String previousData, String currentData, Date createdDate,
			String entityName) {
		this.entityId = entityId;
		this.action = action;
		this.previousData = previousData;
		this.currentData = currentData;
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

	private String previousData;

	private String currentData;

	private Date createdDate;

	private int entityId;

	private String entityName;

	public long getAuditLogId() {
		return auditLogId;
	}

	public void setAuditLogId(long auditLogId) {
		this.auditLogId = auditLogId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPreviousData() {
		return previousData;
	}

	public void setPreviousData(String previousData) {
		this.previousData = previousData;
	}

	public String getCurrentData() {
		return currentData;
	}

	public void setCurrentData(String currentData) {
		this.currentData = currentData;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getEntityId() {
		return entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

}
