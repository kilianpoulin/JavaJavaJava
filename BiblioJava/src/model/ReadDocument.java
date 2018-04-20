package model;

import java.io.FileReader ;
import java.io.BufferedReader ;
import java.io.File;
import java.io.IOException ;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kilian
 */
public class ReadDocument {
    
    private List<Document> documents = new ArrayList<Document>();;
    private String line;
    private String[] attr = new String[9];
    private final String fileName;

    /**
     *
     * @param fileName
     */
    public ReadDocument(String fileName){
        this.fileName = fileName;
        build();
    } 
    
    /**
     *
     */
    public void build(){
        BufferedReader file;
        int i = 0;
        try
        {
            Path pathAbsolute = Paths.get(fileName);
            Path pathBase = Paths.get(new File("src/pdfReader/TestFile.txt").getAbsolutePath());
            Path pathRelative = pathBase.relativize(pathAbsolute);
            System.out.println(pathRelative);
            file = new BufferedReader(new FileReader(fileName)) ;
            while (file.ready()==true) 
            {
                line = file.readLine();
                attr = line.split(";");
                if(i != 0){
                    switch(attr[8]){
                        case "Livre" :
                            documents.add(readLivre());
                            break;
                        case "Roman" :
                            documents.add(readRoman());
                            break;
                        case "Manuel" :
                            documents.add(readManuel());
                            break;
                        case "Revue" :
                            documents.add(readRevue());
                            break;
                    }
                }
                i++;
            }
        }
        catch (NullPointerException e)
        {
                System.out.println("Erreur : pointeur null");
        }
        catch (IOException e) 
        {
                System.out.println("Problème d'IO");
        }
    }
    
    /**
     *
     * @return
     */
    public Document readLivre(){
        Livre doc = new Livre(attr[1], attr[2], Integer.parseInt(attr[3]));
        doc.setNumEnreg(Integer.parseInt(attr[0]));
        return doc;
    }

    /**
     *
     * @return
     */
    public Document readManuel(){
        Manuel doc = new Manuel(attr[1], attr[2], Integer.parseInt(attr[5]), Integer.parseInt(attr[3]));
        return doc;
    }

    /**
     *
     * @return
     */
    public Document readRoman(){
        Roman Prix = null;
            if(attr[4].compareTo("GONCOURT") == 0)
                Prix = Roman.GONCOURT;
            else if(attr[4].compareTo("MEDICIS") == 0)
                Prix = Roman.MEDICIS;
            else if(attr[4].compareTo("RENAUDOT") == 0)
                Prix = Roman.RENAUDOT;
                            
            Roman doc = new Roman(attr[1], attr[2], Integer.parseInt(attr[3]), Prix);
        return doc;
    }

    /**
     *
     * @return
     */
    public Document readRevue(){
        Revue doc = new Revue(attr[1], Integer.parseInt(attr[6]), Integer.parseInt(attr[7]));
        return doc;
    }

    /**
     *
     * @return
     */
    public List<Document> getDocuments() {
        return documents;
    }

    /**
     *
     * @param documents
     */
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
    
}
 