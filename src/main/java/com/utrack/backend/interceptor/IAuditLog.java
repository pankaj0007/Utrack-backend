package com.utrack.backend.interceptor;

public interface IAuditLog {

	public String getCurrentData();

	public Long getEntityId();

	public String getPreviousData();
}
