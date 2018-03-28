package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

public class SaisieDocument extends JFrame {
    public SaisieDocument(){
        
        build();
        
    }
    public void build(){
        setTitle("Saisie document");
        
        
        
        setMinimumSize(new Dimension(800, 600));
        setContentPane(buildContentPane());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }
    
    Container buildContentPane()
    {	
            getContentPane().setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            
            JLabel labelTitre = new JLabel("Titre : ");
            gbc.weighty = 1;
            gbc.gridx = gbc.gridy = 0;
            gbc.insets = new Insets(50, 100, 0, 0);
            gbc.anchor = GridBagConstraints.NORTHWEST;
            labelTitre.setFont(new Font("TimesRoman", Font.PLAIN , 32));          
            getContentPane().add(labelTitre, gbc);
                        
            final JTextField textTitre = new JTextField();
            gbc = new GridBagConstraints();
            gbc.weighty = 1;
            gbc.weightx = 1;
            gbc.insets = new Insets(50, 200, 0, 100);
            gbc.gridx = 0;
            gbc.fill=GridBagConstraints.HORIZONTAL;
            gbc.gridy = 0;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTHWEST;
            textTitre.setFont(new Font("TimesRoman", Font.PLAIN, 32)); 
            getContentPane().add(textTitre, gbc);
            
            
            JLabel labelAuteur = new JLabel("Auteur : ");
            gbc.weighty = 1;
            gbc.gridx = gbc.gridy = 0;
            gbc.insets = new Insets(150, 70, 0, 0);
            gbc.anchor = GridBagConstraints.NORTHWEST;
            labelAuteur.setFont(new Font("TimesRoman", Font.PLAIN , 32));          
            getContentPane().add(labelAuteur, gbc);
                        
            final JTextField textAuteur = new JTextField();
            gbc = new GridBagConstraints();
            gbc.weighty = 1;
            gbc.weightx = 1;
            gbc.insets = new Insets(150, 200, 0, 100);
            gbc.gridx = 0;
            gbc.fill=GridBagConstraints.HORIZONTAL;
            gbc.gridy = 0;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTHWEST;
            textAuteur.setFont(new Font("TimesRoman", Font.PLAIN, 32)); 
            getContentPane().add(textAuteur, gbc);
            
            /**
            *   Nombre de pages.
            */
            
            JLabel labelPages = new JLabel("Nb pages : ");
            gbc.weighty = 1;
            gbc.gridx = gbc.gridy = 0;
            gbc.insets = new Insets(250, 40, 0, 0);
            gbc.anchor = GridBagConstraints.NORTHWEST;
            labelPages.setFont(new Font("TimesRoman", Font.PLAIN , 32));          
            getContentPane().add(labelPages, gbc);
            
            final JTextField textPages = new JTextField();
            gbc = new GridBagConstraints();
            gbc.weighty = 1;
            gbc.weightx = 1;
            gbc.insets = new Insets(250, 200, 0, 200);
            gbc.gridx = 0;
            gbc.fill=GridBagConstraints.HORIZONTAL;
            gbc.gridy = 0;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTHWEST;
            textPages.setFont(new Font("TimesRoman", Font.PLAIN, 32)); 
            getContentPane().add(textPages, gbc);
            
            
            /**
            *   Prix littéraires.
            */
            JLabel labelPrix = new JLabel("Prix litteraire : ");
            gbc.weighty = 1;
            gbc.gridx = gbc.gridy = 0;
            gbc.insets = new Insets(350, 40, 0, 0);
            gbc.anchor = GridBagConstraints.NORTHWEST;
            labelPrix.setFont(new Font("TimesRoman", Font.PLAIN , 32));          
            getContentPane().add(labelPrix, gbc);
            
            final JRadioButton bGoncourt = new JRadioButton();
            gbc = new GridBagConstraints();
            gbc.weighty = 1;
            gbc.weightx = 1;
            gbc.insets = new Insets(350, 400, 0, 0);
            gbc.gridx = 0;
            gbc.fill=GridBagConstraints.HORIZONTAL;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.NORTHWEST;
            bGoncourt.setFont(new Font("TimesRoman", Font.PLAIN, 32)); 
            getContentPane().add(bGoncourt, gbc);
            
            final JRadioButton bMedicis = new JRadioButton();
            gbc = new GridBagConstraints();
            gbc.weighty = 1;
            gbc.weightx = 1;
            gbc.insets = new Insets(350, 500, 0, 0);
            gbc.gridx = 0;
            gbc.fill=GridBagConstraints.HORIZONTAL;
            gbc.gridy = 0;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTHWEST;
            bMedicis.setFont(new Font("TimesRoman", Font.PLAIN, 32)); 
            getContentPane().add(bMedicis, gbc);
/*            JButton valider = new JButton("Valider");
            getContentPane().add(valider);
*/

            pack();
            return getContentPane();
    }	
    
}
