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

public class Fenetre extends JFrame {
    private Bibliotheque biblio = null;
    public Fenetre(){
        build();
        ReadDocument file = new ReadDocument("bibliotheque.csv");
        biblio = new Bibliotheque(file.getDocuments());
    }
    
    public void build(){
        setTitle("Menu de la bibliotheque");
        setMinimumSize(new Dimension(800, 600));
        setPreferredSize(new Dimension(800, 600));
        setContentPane(buildContentPane());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    
    public Container buildContentPane(){
        getContentPane().setLayout(new GridLayout(4, 1));
        
        JPanel pane = new JPanel(new BorderLayout());
        JLabel titre = new JLabel("Choisir parmi les options");
        titre.setHorizontalAlignment(JLabel.CENTER);
        titre.setFont(new Font("TimesRoman", Font.PLAIN , 32));
        getContentPane().add(titre, BorderLayout.CENTER);
        
        
        JButton addButton = new JButton("Ajouter un document");
        addButton.setFont(new Font("TimesRoman", Font.PLAIN , 26));
        getContentPane().add(addButton);
        
        JButton searchButton = new JButton("Rechercher un document");
        searchButton.setFont(new Font("TimesRoman", Font.PLAIN , 26));
        getContentPane().add(searchButton);
        
        JButton showButton = new JButton("Afficher la bibliothèque");
        showButton.setFont(new Font("TimesRoman", Font.PLAIN , 26));
        getContentPane().add(showButton);
        
        addButton.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    dispose();
                    SaisieDocument saisir = new SaisieDocument(biblio);
                }
        }
        );
        
        searchButton.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    dispose();
                    RechercheDocument recherche = new RechercheDocument(biblio);
                }
        }
        );
        
        showButton.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    dispose();
                    AfficherDocuments afficher = new AfficherDocuments(biblio);
                }
        }
        );
        
        return getContentPane();
    }
}


