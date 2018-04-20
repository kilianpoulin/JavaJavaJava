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

/**
 *
 * @author Kilian
 */
public class AfficherDocuments extends JFrame implements Affichage {
    //private Bibliotheque biblio = null;
 
    /**
     *
     */
        public static JTextArea text; 
    private Fenetre main = null;
    
    private final JLabel titre = new JLabel("Bibliothèque complète");

    final JButton refresh = new JButton();
    private final JButton sortTitre = new JButton("Trier par Titre");       
    private final JButton sortAuteur = new JButton("Trier par Auteur");
    private final JButton exporter = new JButton("Exporter");
    private final JButton gotomenu = new JButton("Menu");
    private final JButton sortLivre = new JButton("Livres");
    private final JButton sortRevue = new JButton("Revues");
    private final JButton sortRoman = new JButton("Romans");
    private final JButton sortManuel = new JButton("Manuels");
    
    /**
     *
     * @param frame
     */
    public AfficherDocuments(Fenetre frame){
        this.main = frame;
        build();
    }
    
    /**
     *
     */
    public void build(){
        setTitle("Recherche de documents");
        setMinimumSize(new Dimension(800, 600));
        setPreferredSize(new Dimension(800, 600));
        setContentPane(buildContentPane());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(false);
    }
    
    /**
     *
     * @return
     */
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
        
        
        sortTitre.setFont(new Font("TimesRoman", Font.PLAIN , 24));
        getContentPane().add(sortTitre, gbc);
        
        /**
         * Positionnement du bouton "Trier par AUTEUR".
         */     
        gbc.gridx = 1;
        gbc.gridy = 1; // on se positionne sur la ligne suivante
        gbc.insets = new Insets(50, 0, 0, 30);

        sortAuteur.setFont(new Font("TimesRoman", Font.PLAIN , 24));
        getContentPane().add(sortAuteur, gbc);
       
        /**
         * Positionnement du bouton "Exporter".
         */     
        gbc.gridx = 2;
        gbc.gridy = 1; // on se positionne sur la ligne suivante
        gbc.insets = new Insets(50, 0, 0, 30);

        exporter.setFont(new Font("TimesRoman", Font.PLAIN , 24));
        exporter.setBackground(Color.BLUE);
        exporter.setForeground(Color.WHITE);
        getContentPane().add(exporter, gbc);
        
        /**
         * Positionnement du bouton "Retour au MENU".
         */ 
        gbc.gridx = 3;
        gbc.gridy = 1; // on se positionne sur la ligne suivante
        gbc.insets = new Insets(50, 0, 0, 30);
        gbc.gridwidth = GridBagConstraints.REMAINDER; // le bouton est le dernier élément de la ligne
        
        gotomenu.setFont(new Font("TimesRoman", Font.ITALIC , 24));
        gotomenu.setBackground(Color.RED);
        gotomenu.setForeground(Color.WHITE);
        getContentPane().add(gotomenu, gbc);
        
        /**
         * Positionnement du bouton "Trier par LIVRE".
         */        
        gbc.gridx = 0;
        gbc.gridy = 2; // on se positionne sur la ligne suivante
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.;
        gbc.weighty = 0.;
        gbc.fill = GridBagConstraints.NONE;    
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(50, 30, 0, 10);
        
        sortLivre.setFont(new Font("TimesRoman", Font.PLAIN , 20));
        getContentPane().add(sortLivre, gbc);
        
        /**
         * Positionnement du bouton "Trier par ROMAN".
         */     
        gbc.gridx = 1;
        gbc.gridy = 2; // on se positionne sur la ligne suivante
        gbc.insets = new Insets(50, 0, 0, 10);
        
        
        sortRoman.setFont(new Font("TimesRoman", Font.PLAIN , 20));
        getContentPane().add(sortRoman, gbc);
        
        /**
         * Positionnement du bouton "Trier par MANUEL".
         */     
        gbc.gridx = 2;
        gbc.gridy = 2; // on se positionne sur la ligne suivante
        gbc.insets = new Insets(50, 0, 0, 10);
        
        sortManuel.setFont(new Font("TimesRoman", Font.PLAIN , 20));
        getContentPane().add(sortManuel, gbc);
        
        /**
         * Positionnement du bouton "Trier par REVUE".
         */     
        gbc.gridx = 3;
        gbc.gridy = 2; // on se positionne sur la ligne suivante
        gbc.gridwidth = GridBagConstraints.REMAINDER; // le bouton est le dernier élément de la ligne
        gbc.insets = new Insets(50, 50, 0, 10);
        
        
        sortRevue.setFont(new Font("TimesRoman", Font.PLAIN , 20));
        getContentPane().add(sortRevue, gbc);
       
        
        
        /**
         * Positionnement de la liste des documents.
         */ 
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        gbc.weightx = 1.;
        gbc.weighty = 1.;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(40, 0, 20, 0);
        
        text = new JTextArea(Affichage.afficherDocument(main.biblio.getDocuments()));
        text.setFont(new Font("TimesRoman", Font.PLAIN , 21));
        JScrollPane scrollpane = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollpane.setPreferredSize(new Dimension(500,200));
        text.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 10));
       
        JScrollBar bar = scrollpane.getVerticalScrollBar();
        bar.setPreferredSize(new Dimension(20, 0));
        getContentPane().add(scrollpane, gbc);
        
        /**
         * Positionnement des credits.
         */ 
        gbc.gridx = 0;
        gbc.gridy = 4;
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
                    main.biblio.sortTitre();
                    final String jTextAreaText = Affichage.afficherDocument(main.biblio.getDocuments());
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
                    main.biblio.sortAuteur();
                    final String jTextAreaText = Affichage.afficherDocument(main.biblio.getDocuments());
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
        
        sortRevue.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    final String jTextAreaText = Affichage.afficherDocument(main.biblio.getRevues());
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
        
        sortLivre.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    final String jTextAreaText = Affichage.afficherDocument(main.biblio.getLivres());
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
        
        sortRoman.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    final String jTextAreaText = Affichage.afficherDocument(main.biblio.getRomans());
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
        
        
        sortManuel.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    final String jTextAreaText = Affichage.afficherDocument(main.biblio.getManuels());
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
        
        exporter.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    main.biblio.exporter();
                }
        }
        );
        
        
        
        sortManuel.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    final String jTextAreaText = Affichage.afficherDocument(main.biblio.getManuels());
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
        
        refresh.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    final String jTextAreaText = Affichage.afficherDocument(main.biblio.getDocuments());
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
                            setVisible(false);
                            main.setVisible(true);
                        }            
                    });
                }
        }
        );
        
        return getContentPane();
    }
}
