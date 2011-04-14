package aku.demo.application.base;

import lotus.domino.Document;

public class DemoDocument {
	private static final String ITEM_FORM = "Form";
	
	private Document document;
	
	public DemoDocument(Document document){
		this.document = document;
	}
	
	public String getForm() throws Exception{
		return document.getItemValueString(ITEM_FORM);
	}
	
	public void applyForm(String form) throws Exception{
		document.replaceItemValue(ITEM_FORM, form);
		document.computeWithForm(true, false);
		document.save(true);
	}
}
