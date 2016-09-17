package saperclient.View.Frames.Login.Ranking;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import saperclient.Controller.RankingListener;

import saperclient.SaperClient;

/**
 *
 * @author Damian
 */
public class RankingFrame {
    
    private static final Dimension SIZE_BUTTON = new Dimension( 120, 30 );
    
    private JFrame frame;
    
    //==========================================================================
    
    public RankingFrame() {
        
        SwingUtilities.invokeLater( new Runnable() {
            
            public void run() {

                frame = new JFrame();

                frame.setLayout( new GridBagLayout() );
                frame.getRootPane().setBorder( BorderFactory.createEmptyBorder( 30, 60, 30, 60 ) );

                if( SaperClient.current_frame != null ) {
                    
                    SaperClient.current_frame.removeAll();
                    SaperClient.current_frame.dispose();
                    SaperClient.current_frame = null;
                }
                
                SaperClient.current_frame = frame;
                
                    addContent();

                frame.pack();

                frame.setVisible( true );
                frame.setResizable( false );

                frame.setLocationRelativeTo( null );
                frame.setTitle( "Saper - Ranking" );
                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            }
        });
    }
    
    //==========================================================================
    
    private void addContent() {

        addRankingTitle();
            
            addRankingTable();
            
        addBackButton();
    }
    
    //--------------------------------------------------------------------------
    
    private void addRankingTitle() {

        JLabel ranking_label = new JLabel( "Ranking" );

            ranking_label.setFont( ranking_label.getFont().deriveFont( 30.f ) );

        GridBagConstraints layout = new GridBagConstraints();

            layout.anchor = GridBagConstraints.CENTER;
            layout.insets = new Insets( 0, 0, 0, 0 );
            layout.gridx = 0;
            layout.gridy = 0;

        frame.add( ranking_label, layout );
    }
    
        private void addRankingTable() {

            DefaultTableModel dataModel = new DefaultTableModel() {

                @Override
                public String getColumnName( int col ) {

                    switch( col ) {
                        
                        case 0:
                            return "Login";
                        
                        case 1:
                            return "Ilość rozegranych gier";
                        
                        case 2:
                            return "Ilość wygranych";
                    }
                    
                    return "";
                }

                @Override
                public int getColumnCount() {

                    return 3;
                }

                @Override
                public int getRowCount() {

                    return 0;
                }

                @Override
                public Object getValueAt( int row, int col ) {

                    return "";
                }
            };
        
            JTable table = new JTable( dataModel );
            
            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment( SwingConstants.CENTER );
            
            for( int i = 0; i < dataModel.getColumnCount(); ++i ) {
                
                table.getColumnModel().getColumn( i ).setCellRenderer( rightRenderer );
            }
                /*table.getColumnModel().getColumn( i ).setMinWidth( 10 );
                table.getColumnModel().getColumn( i ).setPreferredWidth( 10 );
            }
            
            table.getColumnModel().getColumn(0).setMinWidth( 100 );
            table.getColumnModel().getColumn(0).setPreferredWidth( 100 );*/

            GridBagConstraints layout = new GridBagConstraints();

                layout.anchor = GridBagConstraints.CENTER;
                layout.insets = new Insets( 50, 0, 0, 0 );
                layout.gridx = 0;
                layout.gridy = 1;

            JScrollPane table_scrollpane = new JScrollPane( table );
            table_scrollpane.setPreferredSize( new Dimension( 500, 152 ) );

            frame.add( table_scrollpane, layout );
        }
    
    private void addBackButton() {
        
        JButton back_button = new JButton( "Wróć" );

            back_button.setPreferredSize( SIZE_BUTTON );
            back_button.addActionListener( new ActionListener() {
                
                @Override
                public void actionPerformed( ActionEvent e ) {
                    
                    if( SaperClient.saved_frame != null ) {
                        
                        SaperClient.current_frame.removeAll();
                        SaperClient.current_frame.dispose();
                        
                        SaperClient.current_frame = SaperClient.saved_frame;
                        SaperClient.current_frame.setVisible( true );
                        
                        SaperClient.saved_frame = null;
                    }
                }
            } );
        
        GridBagConstraints layout = new GridBagConstraints();

            layout.anchor = GridBagConstraints.CENTER;
            layout.insets = new Insets( 20, 0, 0, 0 );
            layout.gridx = 0;
            layout.gridy = 2;

        frame.add( back_button, layout );
    }
}
