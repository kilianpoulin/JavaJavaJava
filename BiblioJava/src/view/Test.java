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
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultCaret;
import model.Bibliotheque;

public class Test extends JFrame implements Affichage {
    private Bibliotheque biblio = null;
    private static JTextArea text; 
    public Test(){
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
        gbc.gridx = 0;
        gbc.gridy = 0; // on commence à la position (0,0)
        gbc.gridwidth = GridBagConstraints.REMAINDER; // le titre est le dernier élément de la ligne
        gbc.gridheight = 1; // le titre ne s'étend que sur une ligne
        gbc.anchor = GridBagConstraints.NORTH; // on commence au début de la ligne
        gbc.insets = new Insets(30, 15, 0, 100); 
        
        JLabel titre = new JLabel("Bibliotèque complète");
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
            gbc.weighty = 0.;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.BASELINE_LEADING; 
            gbc.insets = new Insets(10, 15, 0, 0);
            
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
            gbc.insets = new Insets(0, 15, 0, 10);
                        
            final JTextField textTitre = new JTextField();
            textTitre.setFont(new Font("TimesRoman", Font.PLAIN, 24)); 
            getContentPane().add(textTitre, gbc);
            
            
      
       return getContentPane();
        
    }
}
