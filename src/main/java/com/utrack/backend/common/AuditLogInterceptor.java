package com.utrack.backend.common;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.utrack.backend.interceptor.IAuditLog;

@Configuration
public class AuditLogInterceptor extends EmptyInterceptor {

	private Set inserts = new HashSet();
	private Set updates = new HashSet();
	private Set deletes = new HashSet();

	@Autowired
	private AuditLogUtil AuditLogUtil;

	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
			throws CallbackException {

		System.out.println("onSave : " + entity);

		if (entity instanceof IAuditLog) {
			inserts.add(entity);
		}
		return false;

	}

	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) throws CallbackException {

		System.out.println("onFlushDirty");

		if (entity instanceof IAuditLog) {
			updates.add(entity);
		}
		return false;

	}

	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {

		System.out.println("onDelete");

		if (entity instanceof IAuditLog) {
			deletes.add(entity);
		}
	}

	// called before commit into database
	public void preFlush(Iterator iterator) {
		System.out.println("preFlush");
	}

	// called after committed into database
	public void postFlush(Iterator iterator) {
		System.out.println("postFlush");

		try {

			for (Iterator it = inserts.iterator(); it.hasNext();) {
				IAuditLog entity = (IAuditLog) it.next();
				System.out.println("postFlush - insert");
				AuditLogUtil.logIt("Inserted", entity);
			}

			for (Iterator it = updates.iterator(); it.hasNext();) {
				IAuditLog entity = (IAuditLog) it.next();
				System.out.println("postFlush - update");
				AuditLogUtil.logIt("Updated", entity);
			}

			for (Iterator it = deletes.iterator(); it.hasNext();) {
				IAuditLog entity = (IAuditLog) it.next();
				System.out.println("postFlush - delete");
				AuditLogUtil.logIt("Deleted", entity);
			}

		} finally {
			inserts.clear();
			updates.clear();
			deletes.clear();
		}
	}
}