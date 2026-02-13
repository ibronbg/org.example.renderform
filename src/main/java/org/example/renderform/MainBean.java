package org.example.renderform;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.inject.Named;

@Named
@SessionScoped
public class MainBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(MainBean.class.getName());

	public MainBean() {
	}
	
	private Map<String, Field> data;
	
	private String activeView;
	private List<Field> activeViewFields;
	private Button button;
	
	@PostConstruct
	private void init() {
		data = new HashMap<>();
		button = new Button();
		button.setLabel("Click Me");
		activeViewFields = new LinkedList<>();
		
		Field field;
		
		field = new Field();
		field.setId("field-a");
		field.setLabel("Field A");
		field.setValue("1");
		data.put(field.getId(), field);
		
		field = new Field();
		field.setId("field-b");
		field.setLabel("Field B");
		field.setValue("2");
		data.put(field.getId(), field);
		
		field = new Field();
		field.setId("field-c");
		field.setLabel("Field C");
		field.setValue("3");
		data.put(field.getId(), field);
		
		field = new Field();
		field.setId("field-d");
		field.setLabel("Field D");
		field.setValue("4");
		data.put(field.getId(), field);
		
		setActiveView("View1");;
	}

	public String getActiveView() {
		return activeView;
	}

	public void setActiveView(String aActiveView) {
		this.activeView = aActiveView;
		
		log.info("Phase " + FacesContext.getCurrentInstance().getCurrentPhaseId());
		log.info("Set View to " + aActiveView);
		
		activeViewFields.clear();
		
		switch (aActiveView) {
		case "View1":
			activeViewFields.add(data.get("field-a"));
			activeViewFields.add(data.get("field-b"));
			break;

		case "View2":
			activeViewFields.add(data.get("field-c"));
			activeViewFields.add(data.get("field-d"));
			break;
			
		default:
			activeViewFields.add(data.get("field-a"));
			activeViewFields.add(data.get("field-b"));
			activeViewFields.add(data.get("field-c"));
			activeViewFields.add(data.get("field-d"));
			break;
		}
	}
	
	public List<Field> getActiveViewFields() {
		return activeViewFields;
	}
	
	public void change(AjaxBehaviorEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		log.info("Phase " + facesContext.getCurrentPhaseId());
		
		facesContext.getPartialViewContext().getRenderIds().add("myMenuForm");
		
		UIInput field = (UIInput)event.getSource();
		log.info("Field " + field.getId() + " changed to " + field.getValue());
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button aButton) {
		this.button = aButton;
	}

}
