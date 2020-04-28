package com.fms.fmsevent.model;

public enum Role {
	
	//ROLE_ADMIN,ROLE_PMO,ROLE_POC
	
	ROLE_ADMIN("admin"),ROLE_PMO("pmo"),ROLE_POC("poc"),ROLE_PARTICIPANT("participant");

	private final String identifier;
	
	Role(String identifier) {
		 this.identifier = identifier;
	}
	
	public String toString() {
        return identifier;
    }
	
	 public static Role getEnumNameForValue(String value){
		 Role[] values = Role.values();
	        Role enumValue = null;
	        for(Role eachValue : values) {
	        	System.out.println(eachValue);
	            enumValue = eachValue;

	            if (enumValue.toString().equalsIgnoreCase(value)) {
	            	System.out.println("name===>"+eachValue.name());
	                return eachValue;
	            }
	        }
	        return enumValue;
	    }

	/*
	 * public static void main(String[] ar){ getEnumNameForValue("participant");
	 * 
	 * }
	 */
}
