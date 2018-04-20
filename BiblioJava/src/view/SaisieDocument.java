package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.Bibliotheque;
import model.Livre;
import model.Manuel;
import model.Revue;
import model.Roman;

/**
 *  Cette classe (qui est une fenêtre) permet d'ajouter plusieurs types de documents au choix :
 *      - Livre
 *      - Roman
 *      - Manuel
 *      - Revue
 * 
 *  Si l'utilisateur ajoute un document alors le résultat sera affiché dans la fenêtre de classe AfficherDocuments.
 * @author Kilian
 */
public class SaisieDocument extends JFrame {

    private Fenetre main = null;
    /// tous les composants
    private final String[] typeList = {"Livre", "Roman", "Manuel", "Revue"};
    private final String[] moisList = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    private final String[] anneeList = {"2018", "2017", "2016", "2015", "2014", "2013", "2012"};
    private final JComboBox type = new JComboBox(typeList);
    
    private final JLabel titre = new JLabel("Ajouter un document à la bibliothèque");
    private final JLabel labelPrix = new JLabel("Prix litteraire : ");
    private final JLabel labelPages = new JLabel("Nb pages : ");
    private final JLabel labelAuteur = new JLabel("Auteur : ");
    private final JLabel credits = new JLabel("Credits : Kilian Poulin & Edouard Ok - (2018)");
    private final JLabel labelTitre = new JLabel("Titre : ");
    private final JLabel labelNiveau = new JLabel("Niveau : ");
    private final JLabel labelMois = new JLabel("Mois : ");
    private final JLabel labelAnnee = new JLabel("Annee : ");
    
    public final JButton valider = new JButton("Valider");
    private final JButton gotomenu = new JButton("Retour au Menu");
    private final JButton Btype = new JButton("Changer");
    
    private final JRadioButton bMedicis = new JRadioButton("Medicis");
    private final JRadioButton bRenaudot = new JRadioButton("Renaudot");
    private final JRadioButton bGoncourt = new JRadioButton("Goncourt");
    private final JTextField textTitre = new JTextField();
    private final JTextField textAuteur = new JTextField();
    private final JTextField textPages = new JTextField();
    private final JTextField niveau = new JTextField();
    
    private final JComboBox mois = new JComboBox(moisList);
    private final JComboBox annee = new JComboBox(anneeList);
    
    /**
     *      Constructeur permettant de lier la fenêtre à la fenêtre principale.
     * @param frame
     *      La fenêtre principale (le menu).
     */
    public SaisieDocument(Fenetre frame){
        build();
        this.main = frame;
    }

    /**
     *  Construit les éléments basiques de la fenêtre.
     */
    public void build(){
        setTitle("Saisie d'un document");
        setMinimumSize(new Dimension(800, 600));
        setPreferredSize(new Dimension(800, 600));
        setContentPane(buildContentPane());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(false);
    }
    
    
    /**
     *  Construit la structure interne de la fenêtre (place tous les élements).
     * @return 
     *      le contenu de la fenêtre.
     */
    Container buildContentPane()
    {	
        
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        headerContentPane(gbc);
            
        choiceContentPane(gbc);
        
        footerContentPane(gbc);
        
        return getContentPane();
    }	
    
    /**
     *      Affiche le choix de type de document à ajouter et gère les différents champ à afficher en conséquence.
     *  @param gbc
     *      Contraintes de placement dans la fenêtre.
     */
    void choiceContentPane(GridBagConstraints gbc){
            /**
            * Positionnement du choix du type de document à ajouter.
            */
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 0.;
            gbc.weighty = 1.;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.BASELINE_LEADING; 
            gbc.insets = new Insets(10, 50, 0, 0);
            
            type.setFont(new Font("TimesRoman", Font.PLAIN , 24));
            getContentPane().add(type, gbc);
            
            gbc.gridx = 1; 
            gbc.gridy = 1;
            gbc.gridwidth = GridBagConstraints.REMAINDER; 
            gbc.gridheight = 1; 
            gbc.anchor = GridBagConstraints.BASELINE;
            gbc.insets = new Insets(10, 60, 0, 0);
                        
            Btype.setFont(new Font("TimesRoman", Font.PLAIN, 24)); 
            getContentPane().add(Btype, gbc);
            
        
        
      Btype.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            { 
                removeComponents();
                if(type.getSelectedItem() == "Livre"){
                            documentContentPane(gbc);
                            livreContentPane(gbc);
                            valider.addActionListener(new ActionListener()
                            {
                                @Override
                                public void actionPerformed(ActionEvent e)
                                { 
                                    if(!textTitre.getText().equals("") 
                                            && !textAuteur.getText().equals("") 
                                            && !textPages.getText().equals("")) {
                                        Livre livre = new Livre(textTitre.getText(), textAuteur.getText(), 
                                                Integer.parseInt(textPages.getText()));
                                        main.biblio.addDocument(livre);
                                        setVisible(false);
                                        main.frame_afficher.setVisible(true);
                                    }
                                }
                            }
                            );

                        }
                        else if(type.getSelectedItem() == "Roman"){
                            documentContentPane(gbc);
                            livreContentPane(gbc);
                            romanContentPane(gbc);
                            valider.addActionListener(new ActionListener()
                            {
                                @Override
                                public void actionPerformed(ActionEvent e)
                                { 
                                    if(!textTitre.getText().equals("") 
                                            && !textAuteur.getText().equals("") 
                                            && !textPages.getText().equals("")) {
                                        Roman roman = null;
                                        if(bGoncourt.isSelected()){
                                            roman = new Roman(textTitre.getText(), textAuteur.getText(), 
                                                Integer.parseInt(textPages.getText()), Roman.GONCOURT);
                                        }
                                        else if(bMedicis.isSelected()){
                                            roman = new Roman(textTitre.getText(), textAuteur.getText(), 
                                                Integer.parseInt(textPages.getText()), Roman.GONCOURT);
                                        }
                                        else if(bRenaudot.isSelected()){
                                            roman = new Roman(textTitre.getText(), textAuteur.getText(), 
                                                Integer.parseInt(textPages.getText()), Roman.RENAUDOT);
                                        }
                                        else{
                                            roman = new Roman(textTitre.getText(), textAuteur.getText(), 
                                                Integer.parseInt(textPages.getText()));
                                        }
                                        main.biblio.addDocument(roman);
                                        ActionEvent event;
                                        long when;

                                        when  = System.currentTimeMillis();
                                        event = new ActionEvent(main.frame_afficher.refresh, ActionEvent.ACTION_PERFORMED, "Anything", when, 0);

                                        for (ActionListener listener : main.frame_afficher.refresh.getActionListeners()) {
                                            listener.actionPerformed(event);
                                        }
                                        setVisible(false);
                                        main.frame_afficher.setVisible(true);
                                    }
                                }
                            }
                            );

                        }
                        else if(type.getSelectedItem() == "Manuel"){
                            documentContentPane(gbc);
                            livreContentPane(gbc);
                            manuelContentPane(gbc);
                            
                            valider.addActionListener(new ActionListener()
                            {
                                @Override
                                public void actionPerformed(ActionEvent e)
                                { 
                                    if(!textTitre.getText().equals("") 
                                            && !textAuteur.getText().equals("") 
                                            && !textPages.getText().equals("")
                                            && !niveau.getText().equals("")) {
                                        Manuel manuel = new Manuel(textTitre.getText(), textAuteur.getText(), 
                                                Integer.parseInt(niveau.getText()),
                                                Integer.parseInt(textPages.getText()));
                                        main.biblio.addDocument(manuel);
                                        setVisible(false);
                                        main.frame_afficher.setVisible(true);
                                    }
                                }
                            }
                            );

                        }
                        else if(type.getSelectedItem() == "Revue"){
                            documentContentPane(gbc);
                            revueContentPane(gbc);
                             valider.addActionListener(new ActionListener()
                            {
                                @Override
                                public void actionPerformed(ActionEvent e)
                                { 
                                    String month = (String) mois.getSelectedItem();
                                    String year = (String) annee.getSelectedItem();
                                    if(!textTitre.getText().equals("")
                                            && !mois.getSelectedItem().equals("")
                                            && !annee.getSelectedItem().equals("")) {
                                        Revue revue = new Revue(textTitre.getText(),  
                                                Integer.parseInt(month),
                                                Integer.parseInt(year));
                                        main.biblio.addDocument(revue);
                                        setVisible(false);
                                        main.frame_afficher.setVisible(true);
                                    }
                                }
                            }
                            );
                        }
                setContentPane(getContentPane());

            }
        }
        );
    }
    
     /**
     *      Affiche l'en-tête de la fenêtre (titre)
     *  @param gbc
     *      Contraintes de placement dans la fenêtre.
     */
    void headerContentPane(GridBagConstraints gbc){
            /**
             * Positionnement du itre de la page "Saisie d'un document".
             */
            gbc.gridx = 0;
            gbc.gridy = 0; // on commence à la position (0,0)
            gbc.anchor = GridBagConstraints.NORTH; // on commence au début de la ligne
            gbc.gridheight = 1; // le titre ne s'étend que sur une ligne
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.NONE;
            gbc.gridwidth = GridBagConstraints.REMAINDER; // le titre est le dernier élément de la ligne
            gbc.insets = new Insets(30, 0, 0, 0); 
            
            titre.setHorizontalAlignment(JLabel.CENTER);
            titre.setFont(new Font("TimesRoman", Font.PLAIN , 28));          
            getContentPane().add(titre, gbc);
    }
    
    /**
     *      Affiche les champs nécessaire pour l'ajout d'un document
     *  @param gbc
     *      Contraintes de placement dans la fenêtre.
     */
    void documentContentPane(GridBagConstraints gbc){
            /**
            * Positionnement du label du champ de saisie "Titre du document".
            */
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 0.;
            gbc.weighty = 1.;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.BASELINE_LEADING; 
            gbc.insets = new Insets(10, 50, 0, 0);
            
            labelTitre.setHorizontalAlignment(JLabel.CENTER);
            labelTitre.setFont(new Font("TimesRoman", Font.PLAIN , 24));          
            getContentPane().add(labelTitre, gbc);
            
            /**
            * Positionnement du champ de saisie "Titre du document".
            */
            gbc.gridx = 1; 
            gbc.gridy = 2;
            gbc.gridwidth = GridBagConstraints.REMAINDER; 
            gbc.gridheight = 1; 
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.BASELINE;
            gbc.insets = new Insets(0, 0, 0, 30);
                        
            textTitre.setFont(new Font("TimesRoman", Font.PLAIN, 24)); 
            getContentPane().add(textTitre, gbc);
    }
     /**
     *      Affiche les champs nécessaire pour l'ajout d'un roman
     *  @param gbc
     *      Contraintes de placement dans la fenêtre.
     */
    void romanContentPane(GridBagConstraints gbc){
       /**
            *   Positionnement du label prix littéraires.
            */
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 0.;
            gbc.weighty = 0.;
            
            gbc.insets = new Insets(0, 50, 10, 10);
            
            labelPrix.setFont(new Font("TimesRoman", Font.PLAIN , 24));          
            getContentPane().add(labelPrix, gbc);
            
            /**
            *   Positionnement du choix : "Prix GONCOURT".
            */
            gbc.gridx = 1; 
            gbc.gridy = 5;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.BASELINE;
            gbc.gridheight = 1; 
            gbc.insets = new Insets(0, 50, 10, 10);
            
            
            bGoncourt.setFont(new Font("TimesRoman", Font.PLAIN , 24));       
            getContentPane().add(bGoncourt, gbc);
             
            /**
            *   Positionnement du choix : "Prix MEDICIS".
            */         
            gbc.gridx = 2; 
            gbc.gridy = 5;
            gbc.anchor = GridBagConstraints.BASELINE;
            gbc.gridheight = 1; 
            gbc.insets = new Insets(0, 50, 10, 10);
            
            bMedicis.setFont(new Font("TimesRoman", Font.PLAIN , 24));       
            getContentPane().add(bMedicis, gbc);
            
            /**
            *   Positionnement du choix : "Prix RENAUDOT".
            */            
            gbc.gridx = 3; 
            gbc.gridy = 5;
            gbc.gridwidth = GridBagConstraints.REMAINDER; 
            gbc.gridheight = 1; 
            gbc.insets = new Insets(0, 50, 10, 10);
            
            bRenaudot.setFont(new Font("TimesRoman", Font.PLAIN , 24));       
            getContentPane().add(bRenaudot, gbc);
            
            
            bGoncourt.addActionListener(new ActionListener()
            {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    { 
                        if(bGoncourt.isSelected()){
                            bMedicis.setSelected(false);
                            bRenaudot.setSelected(false);
                        }
                    }
            }
            );
            bMedicis.addActionListener(new ActionListener()
            {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    { 
                        if(bMedicis.isSelected()){
                            bGoncourt.setSelected(false);
                            bRenaudot.setSelected(false);
                        }
                    }
            }
            );
            bRenaudot.addActionListener(new ActionListener()
            {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    { 
                        if(bRenaudot.isSelected()){
                            bGoncourt.setSelected(false);
                            bMedicis.setSelected(false);
                        }
                    }
            }
            );
    }
    /**
     *      Affiche le bas de page dans la fenêtre
     *  @param gbc
     *      Contraintes de placement dans la fenêtre.
     */
    void footerContentPane(GridBagConstraints gbc){
        
          /**
            *   Positionnement du bouton "Valider".
            */
            
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 0.;
            gbc.weighty = 1.;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.BASELINE_LEADING; 
            gbc.insets = new Insets(0, 15, 0, 0);
            
            valider.setFont(new Font("TimesRoman", Font.BOLD , 24));
            valider.setBackground(Color.BLACK);
            valider.setForeground(Color.WHITE);
            getContentPane().add(valider, gbc);
            
            /**
            *   Positionnement du bouton "Retour au MENU".
            */
            gbc.gridx = 1; 
            gbc.gridy = 6;
            gbc.gridwidth = GridBagConstraints.REMAINDER; 
            gbc.gridheight = 1; 
            //gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.BASELINE;
            gbc.insets = new Insets(0, 15, 0, 10);
            
            gotomenu.setFont(new Font("TimesRoman", Font.ITALIC , 24));
            gotomenu.setBackground(Color.RED);
            gotomenu.setForeground(Color.WHITE);
            getContentPane().add(gotomenu, gbc);
            
            /**
            * Positionnement des credits.
            */ 
           gbc.gridx = 0;
           gbc.gridy = 7;
           gbc.anchor = GridBagConstraints.LINE_START;
           gbc.insets = new Insets(10, 0, 0, 20);
           gbc.gridwidth = GridBagConstraints.REMAINDER;
           gbc.fill = GridBagConstraints.BOTH;
           
           credits.setHorizontalAlignment(JLabel.CENTER);
           credits.setFont(new Font("TimesRoman", Font.PLAIN , 20));
           getContentPane().add(credits, gbc);
           
        
           
        gotomenu.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    SwingUtilities.invokeLater(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            setVisible(false);
                            main.setVisible(true);
                        }            
                    });
                }
        }
        );
        
        
    }
    
     /**
     *      Affiche les champs nécessaire pour l'ajout d'un livre
     *  @param gbc
     *      Contraintes de placement dans la fenêtre.
     */
    void livreContentPane(GridBagConstraints gbc){
            
            /**
            * Positionnement du label du champ de saisie "Nom de l'auteur".
            */
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 0.;
            gbc.weighty = 1.;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.BASELINE_LEADING; 
            gbc.insets = new Insets(0, 50, 0, 0);
            
            labelAuteur.setFont(new Font("TimesRoman", Font.PLAIN , 24));          
            getContentPane().add(labelAuteur, gbc);
                        
            /**
            * Positionnement du champ de saisie "Nom de l'auteur".
            */
            gbc.gridx = 1; 
            gbc.gridy = 3;
            gbc.gridwidth = GridBagConstraints.REMAINDER; 
            gbc.gridheight = 1; 
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.BASELINE;
            gbc.insets = new Insets(0, 0, 0, 30);
            
            
            textAuteur.setFont(new Font("TimesRoman", Font.PLAIN, 24)); 
            getContentPane().add(textAuteur, gbc);
            
            /**
            *   Positionnement du champ de saisie "Nombre de pages".
            */
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 0.;
            gbc.weighty = 1.;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.BASELINE_LEADING; 
            gbc.insets = new Insets(0, 40, 0, 0);
            
            labelPages.setFont(new Font("TimesRoman", Font.PLAIN , 24));          
            getContentPane().add(labelPages, gbc);
            
            /**
            * Positionnement du champ de saisie "Nombre de pages".
            */
            gbc.gridx = 1; 
            gbc.gridy = 4;
            gbc.gridwidth = GridBagConstraints.REMAINDER; 
            gbc.gridheight = 1; 
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.BASELINE;
            gbc.insets = new Insets(0, 0, 0, 30);
            
            textPages.setFont(new Font("TimesRoman", Font.PLAIN, 24)); 
            getContentPane().add(textPages, gbc);

    }
    
     /**
     *      Affiche les champs nécessaire pour l'ajout d'un manuel
     *  @param gbc
     *      Contraintes de placement dans la fenêtre.
     */
    
    void manuelContentPane(GridBagConstraints gbc){
        /**
            *   Positionnement du champ de saisie "Niveau".
            */
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 0.;
            gbc.weighty = 1.;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.BASELINE_LEADING; 
            gbc.insets = new Insets(0, 40, 0, 0);
            
            labelNiveau.setFont(new Font("TimesRoman", Font.PLAIN , 24));          
            getContentPane().add(labelNiveau, gbc);
            
            /**
            * Positionnement du champ de saisie "Niveau".
            */
            gbc.gridx = 1; 
            gbc.gridy = 5;
            gbc.gridwidth = GridBagConstraints.REMAINDER; 
            gbc.gridheight = 1; 
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.BASELINE;
            gbc.insets = new Insets(0, 0, 0, 30);
            
            niveau.setFont(new Font("TimesRoman", Font.PLAIN, 24)); 
            getContentPane().add(niveau, gbc);
      
  }
    
    /**
     *      Affiche les champs nécessaire pour l'ajout d'une revue
     *  @param gbc
     *      Contraintes de placement dans la fenêtre.
     */
    void revueContentPane(GridBagConstraints gbc){
        /**
            *   Positionnement du champ de saisie "Mois".
            */
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 0.;
            gbc.weighty = 1.;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.BASELINE_LEADING; 
            gbc.insets = new Insets(0, 40, 0, 0);
            
            labelMois.setFont(new Font("TimesRoman", Font.PLAIN , 24));          
            getContentPane().add(labelMois, gbc);
            
            /**
            * Positionnement du champ de saisie "Mois".
            */
            gbc.gridx = 1; 
            gbc.gridy = 3;
            gbc.gridwidth = GridBagConstraints.REMAINDER; 
            gbc.gridheight = 1; 
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.BASELINE;
            gbc.insets = new Insets(0, 0, 0, 30);
            
            mois.setFont(new Font("TimesRoman", Font.PLAIN, 24));
            getContentPane().add(mois, gbc);
            
            /**
            *   Positionnement du champ de saisie "Année".
            */
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 0.;
            gbc.weighty = 1.;
            gbc.fill = GridBagConstraints.NONE;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.BASELINE_LEADING; 
            gbc.insets = new Insets(0, 40, 0, 0);
            
            labelAnnee.setFont(new Font("TimesRoman", Font.PLAIN , 24));          
            getContentPane().add(labelAnnee, gbc);
            
            /**
            * Positionnement du champ de saisie "Année".
            */
            gbc.gridx = 1; 
            gbc.gridy = 4;
            gbc.gridwidth = GridBagConstraints.REMAINDER; 
            gbc.gridheight = 1; 
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.BASELINE;
            gbc.insets = new Insets(0, 0, 0, 30);
            
            annee.setFont(new Font("TimesRoman", Font.PLAIN, 24)); 
            getContentPane().add(annee, gbc);
      
  }
    
    /**
     *      Supprime tous les composants en cas de changement de type de document à ajouter.
     *  @param gbc
     *      Contraintes de placement dans la fenêtre.
     */
    void removeComponents(){
        //getContentPane().remove(titre);
        getContentPane().remove(labelPrix);
        getContentPane().remove(labelPages);
        getContentPane().remove(labelAuteur);
        //getContentPane().remove(credits);
        getContentPane().remove(labelTitre);
        getContentPane().remove(labelAnnee);
        getContentPane().remove(labelMois);
        getContentPane().remove(labelNiveau);
                
        //getContentPane().remove(valider);
        //getContentPane().remove(gotomenu);
        
        getContentPane().remove(bMedicis);
        getContentPane().remove(bGoncourt);
        getContentPane().remove(bRenaudot);
        
        getContentPane().remove(textTitre);
        getContentPane().remove(textAuteur);
        getContentPane().remove(textPages);
        getContentPane().remove(niveau);
        getContentPane().remove(annee);
        getContentPane().remove(mois);
    }
}
