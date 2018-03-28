package view;

import java.util.Collection;
import javax.swing.*;
import model.Document;

public class Affichage extends JFrame {

	public void afficherDocument(Collection<Document> docs){
            for(Document document : docs){
                System.out.println(docs);
            }
        }
	
}
