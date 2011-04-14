package aku.demo.application2;

import lotus.domino.Database;
import lotus.domino.Document;
import lotus.domino.View;
import aku.demo.application.base.DemoDocument;

public class Applicator {
	private static final String FORM_APPLICATION2 = "Application2";
	private static final String VIEW_TO_APPLY = "new.docs";
	
	private Database database;

	public Applicator(Database database){
		this.database = database;
	}
	
	public void applyForm(String form) throws Exception{		
		View view  = database.getView(VIEW_TO_APPLY);
		Document doc = view.getFirstDocument();
		while(doc!=null){
			DemoDocument demoDoc = new DemoDocument(doc);
			demoDoc.applyForm(FORM_APPLICATION2);
			doc = view.getNextDocument(doc);
		}
	}
}
