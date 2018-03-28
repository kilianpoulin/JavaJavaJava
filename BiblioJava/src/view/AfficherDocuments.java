package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class AfficherDocuments extends JFrame implements Affichage {
    private Bibliotheque biblio = null;
    private static JTextArea text; 
    public AfficherDocuments(Bibliotheque biblio){
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
        getContentPane().setLayout(new GridLayout(3, 1));
        
        
        JLabel titre = new JLabel("Bibliotheque complète");
        titre.setHorizontalAlignment(JLabel.CENTER);
        titre.setFont(new Font("TimesRoman", Font.PLAIN , 32));
        getContentPane().add(titre, BorderLayout.CENTER);
        
        JPanel pane = new JPanel(new FlowLayout());
        JButton sortTitre = new JButton("Trier par titre");
        sortTitre.setFont(new Font("TimesRoman", Font.PLAIN , 28));
        pane.add(sortTitre);
        
        
        JButton sortAuteur = new JButton("Trier par auteur");
        sortAuteur.setFont(new Font("TimesRoman", Font.PLAIN , 28));
        pane.add(sortAuteur);
        
        getContentPane().add(pane);
        
        
        text = new JTextArea(Affichage.afficherDocument(biblio.getDocuments()));
        text.setFont(new Font("TimesRoman", Font.PLAIN , 24));
        JScrollPane scrollpane = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollBar bar = scrollpane.getVerticalScrollBar();
        bar.setPreferredSize(new Dimension(20, 0));
        getContentPane().add(scrollpane);
        
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
       
        
        return getContentPane();
    }
}
