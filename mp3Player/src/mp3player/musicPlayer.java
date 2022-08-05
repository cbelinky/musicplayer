package mp3player;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Charlie
 */
public class musicPlayer {
    
    static musicPlayer player = new musicPlayer();
    
    static Clip clip;
    
    // default constructor
    private musicPlayer()
    {
        
    }
    
    // getter that returns the static 'player' object 
    public static musicPlayer getInstance()
    {
        return player;
    }
    
    // Function that finds a music file and loads it into memory.
    public static void loadMusic(String filepath)
    {
        try
        {
            File musicPath = new File(filepath);//creates a new file object called musicPath using the filepath argument
            
            if(musicPath.exists())//checking for the file's existance before attempting to load it
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);//obtains an audio input from the filepath provided
                clip = AudioSystem.getClip();//translating audiostream into a java clip
                /* 
                AudioFormat format = audioInput.getFormat();
                //DataLine.Info info = new DataLine.Info(Clip.class, format);
                //clip = (Clip) AudioSystem.getLine(info);
                */
                clip.open(audioInput);//opens clip               
                System.out.println("initialized");
            }
        }
        catch(IOException | LineUnavailableException | UnsupportedAudioFileException e)
        {
            System.out.println(e);//debugging; prints error in case filepath provided does not exist
        }
    }
}
