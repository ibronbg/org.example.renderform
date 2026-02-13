package org.example.renderform;

import java.io.Serializable;
import java.util.logging.Logger;

import jakarta.faces.context.FacesContext;

public class Field implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(Field.class.getName());
	
	private String id;
	private String label;
	private String value;

	public Field() {
	}

	public String getId() {
		return id;
	}

	public void setId(String aId) {
		this.id = aId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String aLabel) {
		this.label = aLabel;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String aValue) {
		log.info("Phase " + FacesContext.getCurrentInstance().getCurrentPhaseId());
		this.value = aValue;
	}

	
}
