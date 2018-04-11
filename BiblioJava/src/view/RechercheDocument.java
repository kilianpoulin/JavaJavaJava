package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultCaret;
import model.Bibliotheque;
import model.Document;

public class RechercheDocument extends JFrame implements Affichage {
    private Bibliotheque biblio = null;
    private Bibliotheque biblio_tmp = null;
    List<Document> recherche = null;
    private static JTextArea text; 
    
    public RechercheDocument(Bibliotheque biblio){
        this.biblio = biblio;
        this.biblio_tmp = biblio;
        build();
    }
    
    public void build(){
        setTitle("Affichage de la bibliotheque");
        setMinimumSize(new Dimension(800, 600));
        setPreferredSize(new Dimension(800, 600));
        setContentPane(buildContentPane());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    
    public Container buildContentPane(){
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        /**
         * Titre de la page "Affichage des documents".
         */
        gbc.gridx = gbc.gridy = 0; // on commence à la position (0,0)
        gbc.gridheight = 1; // le titre ne s'étend que sur une ligne
        gbc.anchor = GridBagConstraints.NORTH; // on commence au début de la ligne
        gbc.insets = new Insets(30, 15, 0, 100); 
        gbc.gridwidth = GridBagConstraints.REMAINDER; // le titre est le dernier élément de la ligne
        
        JLabel titre = new JLabel("Bibliothèque complète");
        titre.setHorizontalAlignment(JLabel.CENTER);
        titre.setFont(new Font("TimesRoman", Font.PLAIN , 32));
        getContentPane().add(titre, gbc);
      
        
         /**
            * Positionnement du label du champ de saisie "Titre du document".
            */
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 0.;
            gbc.weighty = 1.;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.BASELINE_LEADING; 
            gbc.insets = new Insets(10, 50, 0, 0);
            
            JLabel labelTitre = new JLabel("Titre : ");
            labelTitre.setHorizontalAlignment(JLabel.CENTER);
            labelTitre.setFont(new Font("TimesRoman", Font.PLAIN , 24));          
            getContentPane().add(labelTitre, gbc);
            
        /**
        * Positionnement du champ de saisie "Titre du document".
        */
        gbc.gridx = 1; 
        gbc.gridy = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER; 
        gbc.gridheight = 1; 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.BASELINE;
        gbc.insets = new Insets(0, 0, 0, 30);

        final JTextField textTitre = new JTextField();
        textTitre.setFont(new Font("TimesRoman", Font.PLAIN, 24)); 
        getContentPane().add(textTitre, gbc);

        /**
        * Positionnement du label du champ de saisie "Nom de l'auteur".
        */
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.;
        gbc.weighty = 1.;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.BASELINE_LEADING; 
        gbc.insets = new Insets(0, 50, 0, 0);
        JLabel labelAuteur = new JLabel("Auteur : ");
        labelAuteur.setFont(new Font("TimesRoman", Font.PLAIN , 24));          
        getContentPane().add(labelAuteur, gbc);

        /**
        * Positionnement du champ de saisie "Nom de l'auteur".
        */
        gbc.gridx = 1; 
        gbc.gridy = 2;
        gbc.gridwidth = GridBagConstraints.REMAINDER; 
        gbc.gridheight = 1; 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.BASELINE;
        gbc.insets = new Insets(0, 0, 0, 30);

        final JTextField textAuteur = new JTextField();
        textAuteur.setFont(new Font("TimesRoman", Font.PLAIN, 24)); 
        getContentPane().add(textAuteur, gbc);
        
         /**
         * Positionnement du bouton "Rechercher".
         */        
        gbc.gridx = 0;
        gbc.gridy = 3; // on se positionne sur la ligne suivante
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.;
        gbc.weighty = 0.;
        gbc.fill = GridBagConstraints.NONE;    
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 30, 0, 30);
        
        JButton rechercher = new JButton("Rechercher");
        rechercher.setFont(new Font("TimesRoman", Font.PLAIN , 24));
        getContentPane().add(rechercher, gbc);
        
        /**
         * Positionnement du bouton "Retour au MENU".
         */ 
        gbc.gridx = 1;
        gbc.gridy = 3; // on se positionne sur la ligne suivante
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridwidth = GridBagConstraints.REMAINDER; // le bouton est le dernier élément de la ligne
        
        JButton gotomenu = new JButton("Retour au Menu");
        gotomenu.setFont(new Font("TimesRoman", Font.ITALIC , 24));
        gotomenu.setBackground(Color.RED);
        gotomenu.setForeground(Color.WHITE);
        getContentPane().add(gotomenu, gbc);
        
        /**
         * Positionnement de la liste des documents.
         */ 
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        gbc.weightx = 1.;
        gbc.weighty = 1.;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(30, 0, 20, 0);
        
        text = new JTextArea();
        text.setFont(new Font("TimesRoman", Font.PLAIN , 24));
        JScrollPane scrollpane = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        text.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 10));
       
        JScrollBar bar = scrollpane.getVerticalScrollBar();
        bar.setPreferredSize(new Dimension(20, 0));
        getContentPane().add(scrollpane, gbc);
        
        /**
         * Positionnement des credits.
         */ 
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(10, 0, 0, 30);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        JLabel credits = new JLabel("Credits : Kilian Poulin & Edouard Ok - (2018)");
        credits.setHorizontalAlignment(JLabel.CENTER);
        credits.setFont(new Font("TimesRoman", Font.PLAIN , 20));
        getContentPane().add(credits, gbc);
        
        rechercher.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    if(!(textTitre.getText().equals(""))){
                        recherche = biblio_tmp.rechercheTitre(textTitre.getText());
                        biblio_tmp = new Bibliotheque(recherche);
                    }
                    if(!(textAuteur.getText().equals(""))){
                        recherche = biblio_tmp.rechercheAuteur(textAuteur.getText());
                    }
                   // if(prixlitt.getText() == "")
                        //*
                    biblio_tmp = biblio;
                    final String jTextAreaText = Affichage.afficherDocument(recherche);
                    SwingUtilities.invokeLater(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            text.setText(jTextAreaText);
                        }            
                    });
                }
        }
        );
        
        gotomenu.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    dispose();
                    Fenetre frame = new Fenetre();
                }
        }
        );
        
        return getContentPane();
    }
}
