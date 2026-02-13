package org.example.renderform;

import java.io.Serializable;
import java.util.logging.Logger;


public class Button implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(Button.class.getName());
	
	private String label;

	public Button() {
	}

	public String execute() {
		log.info("BUTTON: " + label);
		return null;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String aLabel) {
		this.label = aLabel;
	}
	
	
}
