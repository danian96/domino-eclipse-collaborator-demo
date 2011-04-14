package aku.demo.application1;

import lotus.domino.Database;
import lotus.domino.Document;
import lotus.domino.DocumentCollection;
import aku.demo.application.base.DemoDocument;

public class Convertor {
	private static final String FORM_APPLICATION1 = "Application1";
	
	private Database database;

	public Convertor(Database database){
		this.database = database;
	}
	
	public void convertAllDocumentsTo(String form) throws Exception{
		DocumentCollection dc = database.getAllDocuments();
		Document doc = dc.getFirstDocument();
		while(doc != null){
			DemoDocument demoDoc = new DemoDocument(doc);
			demoDoc.applyForm(FORM_APPLICATION1);
			doc = dc.getNextDocument();
		}
	}
}
