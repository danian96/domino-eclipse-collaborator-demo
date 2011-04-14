package aku.demo.application3;

import lotus.domino.Database;
import lotus.domino.Document;
import lotus.domino.DocumentCollection;
import aku.demo.application.base.DemoDocument;

public class Operator {
	private static final String FORM_APPLICATION3 = "Application3";
	private static final String SEARCH_OPEARTE = "Type = \"tochange\"";
	
	private Database database;

	public Operator(Database database){
		this.database = database;
	}
	
	public void convertAllDocumentsTo(String form) throws Exception{
		DocumentCollection dc = database.search(SEARCH_OPEARTE);
		Document doc = dc.getFirstDocument();
		while(doc != null){
			DemoDocument demoDoc = new DemoDocument(doc);
			demoDoc.applyForm(FORM_APPLICATION3);
			doc = dc.getNextDocument();
		}
	}
}
