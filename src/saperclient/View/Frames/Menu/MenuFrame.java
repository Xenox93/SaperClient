package saperclient.View.Frames.Menu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.SwingUtilities;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JRadioButton;

import saperclient.Controller.*;
import saperclient.Model.Level;
import saperclient.Network.Requests.BoardRequest;
import saperclient.SaperClient;
import saperclient.View.Frames.Board.BoardFrame;

/**
 *
 * @author Damian
 */
public class MenuFrame {
    
    private static final Dimension SIZE_BUTTON = new Dimension( 120, 30 );
    
    private final ButtonGroup button_group = new ButtonGroup();
    private JRadioButton custom_level;
    
    private JPanel level_panel, buttons_panel;
    
    private JFrame frame;
    
    //==========================================================================
    
    public MenuFrame() {
        
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
                frame.setTitle( "Saper - Menu" );
                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            }
        });
    }
    
    //==========================================================================
    
    private void addContent() {

        addMenuTitle();
            
            addLevelChooser();
            
        addButtons();
    }
    
    //--------------------------------------------------------------------------
    
    private void addMenuTitle() {

        JLabel menu_label = new JLabel( "Menu" );

            menu_label.setFont( menu_label.getFont().deriveFont( 30.f ) );

        GridBagConstraints layout = new GridBagConstraints();

            layout.anchor = GridBagConstraints.CENTER;
            layout.insets = new Insets( 0, 0, 0, 0 );
            layout.gridx = 0;
            layout.gridy = 0;

        frame.add( menu_label, layout );
    }
    
    private void addLevelChooser() {
        
        level_panel = new JPanel( new GridBagLayout() );
        
            addBeginner();
            addMediumAdvanced();
            addAdvanced();
            addCustom();
        
        GridBagConstraints layout = new GridBagConstraints();

            layout.anchor = GridBagConstraints.CENTER;
            layout.insets = new Insets( 50, 0, 0, 0 );
            layout.gridx = 0;
            layout.gridy = 1;
        
        frame.add( level_panel, layout );
    }
        
        private void addBeginner() {
            
            JRadioButton beginner_level = new LevelChooser( "Beginner", 10, 10, 2 );
            
                button_group.add( beginner_level );
                beginner_level.setSelected( true );
                BoardFrame.level = new Level( 10, 10, 2 );
                beginner_level.addActionListener( new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        BoardFrame.level = new Level( 10, 10, 2 );
                        LevelChooser.setEnable( false );
                    }
                    
                } );
            
            GridBagConstraints layout = new GridBagConstraints();

                layout.anchor = GridBagConstraints.WEST;
                layout.insets = new Insets( 0, 0, 10, 25 );
                layout.gridx = 0;
                layout.gridy = 0;

            level_panel.add( beginner_level, layout );
        }
        private void addMediumAdvanced() {
            
            JRadioButton medium_advanced_level = new LevelChooser( "Medium-advanced", 5, 5, 5 );
                
                button_group.add( medium_advanced_level );
                medium_advanced_level.addActionListener( new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        BoardFrame.level = new Level( 5, 5, 5 );
                        LevelChooser.setEnable( false );
                    }
                    
                } );
                
            GridBagConstraints layout = new GridBagConstraints();

                layout.anchor = GridBagConstraints.WEST;
                layout.insets = new Insets( 0, 25, 10, 0 );
                layout.gridx = 1;
                layout.gridy = 0;

            level_panel.add( medium_advanced_level, layout );
        }
        private void addAdvanced() {
            
            JRadioButton advanced_level = new LevelChooser( "Advanced", 5, 5, 25 );
                
                button_group.add( advanced_level );
                advanced_level.addActionListener( new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        BoardFrame.level = new Level( 5, 5, 25 );
                        LevelChooser.setEnable( false );
                    }
                    
                } );
                
            GridBagConstraints layout = new GridBagConstraints();

                layout.anchor = GridBagConstraints.WEST;
                layout.insets = new Insets( 0, 0, 30, 15 );
                layout.gridx = 0;
                layout.gridy = 1;

            level_panel.add( advanced_level, layout );
        }
        private void addCustom() {
            
            custom_level = new LevelChooser();
                
                button_group.add( custom_level );
                custom_level.addActionListener( new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        LevelChooser.setEnable( true );
                    }
                    
                } );
                
            GridBagConstraints layout = new GridBagConstraints();

                layout.anchor = GridBagConstraints.WEST;
                layout.insets = new Insets( 0, 25, 30, 0 );
                layout.gridx = 1;
                layout.gridy = 1;

            level_panel.add( custom_level, layout );
        }
    
    private void addButtons() {
        
        buttons_panel = new JPanel( new GridBagLayout() );
        
            addLogOutButton();
            addPlayButton();
            addRankingButton();
        
        GridBagConstraints layout = new GridBagConstraints();

            layout.anchor = GridBagConstraints.CENTER;
            layout.insets = new Insets( 50, 0, 0, 0 );
            layout.gridx = 0;
            layout.gridy = 2;
        
        frame.add( buttons_panel, layout );
    }
    
        private void addLogOutButton() {

            JButton logout_button = new JButton( "Wyloguj" );

                logout_button.setPreferredSize( SIZE_BUTTON );
                logout_button.setName( "logout" );
                logout_button.addActionListener( new LogOutListener() );

            GridBagConstraints layout = new GridBagConstraints();

                layout.anchor = GridBagConstraints.EAST;
                layout.insets = new Insets( 20, 0, 0, 0 );
                layout.gridwidth = 1;
                layout.gridx = 0;
                layout.gridy = 0;

            buttons_panel.add( logout_button, layout );
        }
        private void addPlayButton() {

            JButton play_button = new JButton( "Graj" );

                play_button.setFont( play_button.getFont().deriveFont( 25.f ) );
                play_button.addActionListener( new ActionListener() {

                    @Override
                    public void actionPerformed( ActionEvent e ) {

                        if( custom_level.isSelected() )
                            BoardFrame.level = ((LevelChooser)custom_level).getLevel();
                        
                        BoardRequest.getBoard();
                    }
                });
                
            GridBagConstraints layout = new GridBagConstraints();

                layout.anchor = GridBagConstraints.EAST;
                layout.insets = new Insets( 20, 5, 0, 0 );
                layout.gridwidth = 1;
                layout.gridx = 1;
                layout.gridy = 0;

            buttons_panel.add( play_button, layout );
        }
        private void addRankingButton() {

            JButton ranking_button = new JButton( "Ranking" );

                ranking_button.setPreferredSize( SIZE_BUTTON );
                ranking_button.addActionListener( new RankingListener() );

            GridBagConstraints layout = new GridBagConstraints();

                layout.anchor = GridBagConstraints.CENTER;
                layout.insets = new Insets( 20, 5, 0, 0 );
                layout.gridwidth = 1;
                layout.gridx = 2;
                layout.gridy = 0;

            buttons_panel.add( ranking_button, layout );
        }
}
