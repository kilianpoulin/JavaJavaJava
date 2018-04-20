package view;

import static java.awt.BorderLayout.CENTER;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import model.Bibliotheque;
import model.ReadDocument;

/**
 *
 * @author Kilian
 */
public class Fenetre extends JFrame {

    /**
     *
     */
    public static Bibliotheque biblio = null;
    AfficherDocuments frame_afficher = null;
    RechercheDocument frame_recherche = null;
    SaisieDocument frame_saisie = null;
    ImportBiblio frame_importer = null;
    
    /**
     *
     */
    public Fenetre(){
        build();
        //ReadDocument file = new ReadDocument("bibliotheque.csv");
        //biblio = new Bibliotheque(file.getDocuments());
        biblio = new Bibliotheque();
        biblio.loadDefaultBiblio(); // on charge une biblio par défaut
        
        frame_afficher = new AfficherDocuments(this);
        frame_recherche = new RechercheDocument(this);
        frame_saisie = new SaisieDocument(this);
        frame_importer = new ImportBiblio(this);
        
        frame_afficher.setVisible(false);
        frame_recherche.setVisible(false);
        frame_saisie.setVisible(false);
        frame_importer.setVisible(false);
    }
    
    /**
     *
     */
    public void build(){
        setTitle("Menu de la bibliotheque");
        setMinimumSize(new Dimension(800, 600));
        setPreferredSize(new Dimension(800, 600));
        setContentPane(buildContentPane());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    
    /**
     *
     * @return
     */
    public Container buildContentPane(){
        getContentPane().setLayout(new GridLayout(5, 1));
        
        JPanel pane = new JPanel(new BorderLayout());
        JLabel titre = new JLabel("Choisir parmi les options");
        titre.setHorizontalAlignment(JLabel.CENTER);
        titre.setFont(new Font("TimesRoman", Font.PLAIN , 32));
        getContentPane().add(titre, BorderLayout.CENTER);
        
        JButton importButton = new JButton("Importer une bibliothèque");
        importButton.setFont(new Font("TimesRoman", Font.PLAIN , 26));
        getContentPane().add(importButton);
        
        JButton addButton = new JButton("Ajouter un document");
        addButton.setFont(new Font("TimesRoman", Font.PLAIN , 26));
        getContentPane().add(addButton);
        
        JButton searchButton = new JButton("Rechercher un document");
        searchButton.setFont(new Font("TimesRoman", Font.PLAIN , 26));
        getContentPane().add(searchButton);
        
        JButton showButton = new JButton("Afficher la bibliothèque");
        showButton.setFont(new Font("TimesRoman", Font.PLAIN , 26));
        getContentPane().add(showButton);
        
        importButton.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    setVisible(false);
                    frame_importer.setVisible(true);
                }
        }
        );
        
        addButton.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    setVisible(false);
                    frame_saisie.setVisible(true);
                }
        }
        );
        
        searchButton.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    setVisible(false);
                    frame_recherche.setVisible(true);
                }
        }
        );
        
        showButton.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    setVisible(false);
                    frame_afficher.setVisible(true);
                }
        }
        );
        
        return getContentPane();
    }
}


