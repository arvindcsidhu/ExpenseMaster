package com.expense.master.Enumerators;

import java.util.HashMap;
import java.util.Map;

public enum TaskStatus {
	READY("READY"),
	NEW("NEW"),
	COMPLETE("COMPLETE"), 
	FL_RESCHEDULE("FL_RESCHEDULE"),
	HOLD("HOLD"), 
	CANCEL("CANCEL"), 
	FALLOUT("FALLOUT"),
	IGNORE("IGNORE");

	private static class Holder {
		static Map<String, TaskStatus> MAP = new HashMap<>();
	}

	private String s;
	
	private TaskStatus(String s) {
		Holder.MAP.put(s, this);
	}

	public static TaskStatus find(String val) {
		TaskStatus t = Holder.MAP.get(val);
		if (t == null) {
			throw new IllegalStateException(String.format("Unsupported type %s.", val));
		}
		return t;
	}
	
	  
	  
}
	

