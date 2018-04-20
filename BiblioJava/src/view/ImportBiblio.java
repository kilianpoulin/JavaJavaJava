package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import model.Bibliotheque;
import model.Document;
import model.ReadDocument;

public class ImportBiblio extends JFrame {
    private Fenetre main = null;
    private static JTextArea text; 
    private Object fichier;
    private final String filename = "";
    
    public ImportBiblio(Fenetre frame){
        this.main = frame;
        build();
    }
    
    public void build(){
        setTitle("Importer une bibliotheque");
        setMinimumSize(new Dimension(800, 600));
        setPreferredSize(new Dimension(800, 600));
        setContentPane(buildContentPane());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(false);
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
        
        JLabel titre = new JLabel("Importer une bibliothèque");
        titre.setHorizontalAlignment(JLabel.CENTER);
        titre.setFont(new Font("TimesRoman", Font.PLAIN , 32));
        getContentPane().add(titre, gbc);
      
        
         /**
            * Positionnement du label du champ de saisie "Nom du fichier".
            */
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 0.;
            gbc.weighty = 1.;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.BASELINE_LEADING; 
            gbc.insets = new Insets(100, 50, 0, 0);
            
            JLabel labelFichier = new JLabel("Nom du fichier : ");
            labelFichier.setHorizontalAlignment(JLabel.CENTER);
            labelFichier.setFont(new Font("TimesRoman", Font.PLAIN , 24));          
            getContentPane().add(labelFichier, gbc);
            
            /**
            * Positionnement du label du champ de saisie "Nom du fichier".
            */
            gbc.gridx = 1; 
            gbc.gridy = 1;
            gbc.gridheight = 1; 
            gbc.anchor = GridBagConstraints.BASELINE;
            gbc.insets = new Insets(100, 0, 0, 30);

            JTextField file_name = new JTextField(filename);
            file_name.setPreferredSize(new Dimension(300, 36));
            file_name.setFont(new Font("TimesRoman", Font.ITALIC , 24));
            getContentPane().add(file_name, gbc);
            
            /**
            * Positionnement du label du bouton "Parcourir".
            */
            gbc.gridx = 2; 
            gbc.gridy = 1;
            gbc.gridwidth = GridBagConstraints.REMAINDER; 
            gbc.gridheight = 1; 
            gbc.anchor = GridBagConstraints.BASELINE;
            gbc.insets = new Insets(100, 0, 0, 30);

            JButton parcourir = new JButton("Parcourir");
            parcourir.setFont(new Font("TimesRoman", Font.ITALIC , 24));
            parcourir.setBackground(Color.BLUE);
            parcourir.setForeground(Color.WHITE);
            
            
            getContentPane().add(parcourir, gbc);

   
        /**
         * Positionnement du bouton "Importer".
         */ 
        gbc.gridx = 0;
        gbc.gridy = 2; // on se positionne sur la ligne suivante
        gbc.insets = new Insets(0, -100, 0, 75);
        
        JButton importer = new JButton("Importer");
        importer.setFont(new Font("TimesRoman", Font.ITALIC , 24));
        importer.setBackground(Color.BLACK);
        importer.setForeground(Color.WHITE);
        getContentPane().add(importer, gbc);
        
        /**
         * Positionnement du bouton "Retour au MENU".
         */ 
        gbc.gridx = 1;
        gbc.gridy = 2; // on se positionne sur la ligne suivante
        gbc.insets = new Insets(0, 75, 0, 0);
        gbc.gridwidth = GridBagConstraints.REMAINDER; // le bouton est le dernier élément de la ligne
        
        JButton gotomenu = new JButton("Retour au Menu");
        gotomenu.setFont(new Font("TimesRoman", Font.ITALIC , 24));
        gotomenu.setBackground(Color.RED);
        gotomenu.setForeground(Color.WHITE);
        getContentPane().add(gotomenu, gbc);
        
        
        /**
         * Positionnement des credits.
         */ 
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 0, 30);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        JLabel credits = new JLabel("Credits : Kilian Poulin & Edouard Ok - (2018)");
        credits.setHorizontalAlignment(JLabel.CENTER);
        credits.setFont(new Font("TimesRoman", Font.PLAIN , 20));
        getContentPane().add(credits, gbc);
        
        
        gotomenu.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    setVisible(false);
                    main.setVisible(true);
                }
        }
        );
                    
        importer.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    if(file_name.getText() != "" ||file_name.getText() != " "){
                        ReadDocument file = new ReadDocument(file_name.getText());
                        main.biblio = new Bibliotheque(file.getDocuments());
                        setVisible(false);
                        
                        // on rafraichit l'affichage de la bibliotheque
                        ActionEvent event;
                        long when;

                        when  = System.currentTimeMillis();
                        event = new ActionEvent(main.frame_afficher.refresh, ActionEvent.ACTION_PERFORMED, "Anything", when, 0);

                        for (ActionListener listener : main.frame_afficher.refresh.getActionListeners()) {
                            listener.actionPerformed(event);
                        }
                        // on redirige
                        main.frame_afficher.setVisible(true);
                    }
                }
        }
        );
        
        parcourir.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                { 
                    final JFileChooser fichier = new JFileChooser();
                    fichier.setCurrentDirectory(new File(System.getProperty("user.home")));
                    int result = fichier.showOpenDialog(fichier);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fichier.getSelectedFile();
                    
                        final String jTextAreaText = selectedFile.getAbsolutePath();
                        SwingUtilities.invokeLater(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                file_name.setText(jTextAreaText);
                            }            
                        });
                    }
                    
                }
        }
        );
        

        return getContentPane();
    }
}
