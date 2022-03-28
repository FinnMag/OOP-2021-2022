package ie.tudublin;

import java.util.Spliterators.AbstractLongSpliterator;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{
    Minim minim;
    AudioPlayer audioPlayer;
    AudioInput audioInput;
    AudioBuffer audioBuffer;

    public void settings()
    {
        size(1024, 1000, P3D);
        //fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        // ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        // ab = ai.mix; 
        audioPlayer = minim.loadFile("heroplanet.mp3", 1024);
        audioPlayer.play();
        audioBuffer = audioPlayer.mix;
        colorMode(HSB);
    }

    float off = 0;

    public void draw()
    {
        background(0);
        stroke(255);
        float halfHeight = height / 2;
        float average = 0;
        float sum = 0;
    
        for(int i = 0 ; i < audioBuffer.size() ; i ++)
        {
            //float c = map(audioBuffer.get(i), -1, 1, 0, 255);
            float c = map(i, 0, audioBuffer.size(), 0, 255);
            stroke(c, 255, 255);
            line(i, halfHeight, i, halfHeight + audioBuffer.get(i) * halfHeight);
            sum += abs(audioBuffer.get(i));
        }

        average = sum / (float) audioBuffer.size();

        

        stroke(255);
        fill(100, 255, 255);
        circle(width / 2, halfHeight, average * 100);

        // Other examples we made in the class
        /*
        stroke(255);
        fill(100, 255, 255);        
        
        circle(width / 2, halfH, lerpedA * 100);

        circle(100, y, 50);
        y += random(-10, 10);
        smoothedY = lerp(smoothedY, y, 0.1f);        
        circle(200, smoothedY, 50);
        */

    }        
}
