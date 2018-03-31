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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultCaret;
import model.Bibliotheque;

public class RechercheDocument extends JFrame implements Affichage {
    private Bibliotheque biblio = null;
    private static JTextArea text; 
    public RechercheDocument(Bibliotheque biblio){
        this.biblio = biblio;
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
         * Positionnement du bouton "Trier par TITRE".
         */        
        gbc.gridx = 0;
        gbc.gridy = 1; // on se positionne sur la ligne suivante
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.;
        gbc.weighty = 0.;
        gbc.fill = GridBagConstraints.NONE;    
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(50, 30, 0, 30);
        
        JButton sortTitre = new JButton("Trier par Titre");
        sortTitre.setFont(new Font("TimesRoman", Font.PLAIN , 24));
        getContentPane().add(sortTitre, gbc);
        
        /**
         * Positionnement du bouton "Trier par AUTEUR".
         */     
        gbc.gridx = 1;
        gbc.gridy = 1; // on se positionne sur la ligne suivante
        gbc.insets = new Insets(50, 0, 0, 30);
        
        JButton sortAuteur = new JButton("Trier par Auteur");
        sortAuteur.setFont(new Font("TimesRoman", Font.PLAIN , 24));
        getContentPane().add(sortAuteur, gbc);
        
        /**
         * Positionnement du bouton "Retour au MENU".
         */ 
        gbc.gridx = 2;
        gbc.gridy = 1; // on se positionne sur la ligne suivante
        gbc.insets = new Insets(50, 0, 0, 30);
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
        gbc.gridy = 2;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        gbc.weightx = 1.;
        gbc.weighty = 1.;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(40, 0, 20, 0);
        
        text = new JTextArea(Affichage.afficherDocument(biblio.getDocuments()));
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
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(10, 0, 0, 20);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        JLabel credits = new JLabel("Credits : Kilian Poulin & Edouard Ok - (2018)");
        credits.setHorizontalAlignment(JLabel.CENTER);
        credits.setFont(new Font("TimesRoman", Font.PLAIN , 20));
        getContentPane().add(credits, gbc);
        
        sortTitre.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    biblio.sortTitre();
                    final String jTextAreaText = Affichage.afficherDocument(biblio.getDocuments());
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
        
        sortAuteur.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    biblio.sortAuteur();
                    final String jTextAreaText = Affichage.afficherDocument(biblio.getDocuments());
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
                    SwingUtilities.invokeLater(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            dispose();
                            Fenetre frame = new Fenetre();
                        }            
                    });
                }
        }
        );
        
        return getContentPane();
    }
}
