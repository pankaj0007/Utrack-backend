package com.utrack.backend.interceptor;

public interface IAuditLog {

	public String getCurrentData();

	public int getEntityId();

	public String getPreviousData();
}
