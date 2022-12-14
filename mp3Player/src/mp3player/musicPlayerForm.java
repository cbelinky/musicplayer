package mp3player;

import javax.sound.sampled.Clip;

/**
 *
 * @author Charlie
 */
public class musicPlayerForm extends javax.swing.JFrame {

    /**
     * Creates new form musicPlayerForm
     */
    public musicPlayerForm() {
        initComponents();
        
        player.loadMusic(filepath);
    }
    
    //creates a global music player object
    static musicPlayer player = musicPlayer.getInstance();
    static String filepath = "TM.wav";
    static long clipTimePosition;
    
    static boolean isPlaying = true;
    static boolean isRepeating = false;
    
    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filepath_textfield = new javax.swing.JTextField();
        filepath_label = new javax.swing.JLabel();
        load_button = new javax.swing.JButton();
        play_button = new javax.swing.JButton();
        pause_button = new javax.swing.JButton();
        repeat_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        filepath_label.setText("Filepath:");

        load_button.setText("Load");
        load_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                load_buttonActionPerformed(evt);
            }
        });

        play_button.setText("Play");
        play_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                play_buttonActionPerformed(evt);
            }
        });

        pause_button.setText("Pause");
        pause_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pause_buttonActionPerformed(evt);
            }
        });

        repeat_button.setText("Repeat");
        repeat_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repeat_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(filepath_label)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(play_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pause_button)
                        .addGap(93, 93, 93)
                        .addComponent(repeat_button))
                    .addComponent(filepath_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(load_button)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filepath_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filepath_label)
                    .addComponent(load_button))
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(play_button)
                    .addComponent(pause_button)
                    .addComponent(repeat_button))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void play_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_play_buttonActionPerformed
        player.clip.setMicrosecondPosition(0);
        clipTimePosition = 0;
        player.clip.start();
    }//GEN-LAST:event_play_buttonActionPerformed

    private void pause_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pause_buttonActionPerformed
        //if song is playing, button will pause. else if the song is paused, button will reume the song.
        if(isPlaying)
        {
            clipTimePosition = player.clip.getMicrosecondPosition();
            player.clip.stop();
            pause_button.setText("Resume");
        }
        else
        {
            player.clip.setMicrosecondPosition(clipTimePosition);
            player.clip.start();
            pause_button.setText("Pause");
        }
        
        isPlaying = !isPlaying;
    }//GEN-LAST:event_pause_buttonActionPerformed

    private void repeat_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repeat_buttonActionPerformed
        if(!isRepeating)
        {
            player.clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        else
        {
            player.clip.loop(0);
        }
        
        isRepeating = !isRepeating;
    }//GEN-LAST:event_repeat_buttonActionPerformed

    private void load_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_load_buttonActionPerformed
        filepath = filepath_textfield.getText(); //assigns filepath to the text entered by the user
        player.clip.stop(); //stops playing the previously loaded song
        player.clip.setMicrosecondPosition(0); //starts song at 0:00
        clipTimePosition = 0; //resets the variable to 0 to ensure that new song plays at 0:00 and not the timestamp of the previously loaded song
        player.loadMusic(filepath); //calls user defined function to load a song into the player
    }//GEN-LAST:event_load_buttonActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(musicPlayerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(musicPlayerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(musicPlayerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(musicPlayerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new musicPlayerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel filepath_label;
    private javax.swing.JTextField filepath_textfield;
    private javax.swing.JButton load_button;
    private javax.swing.JButton pause_button;
    private javax.swing.JButton play_button;
    private javax.swing.JButton repeat_button;
    // End of variables declaration//GEN-END:variables
}