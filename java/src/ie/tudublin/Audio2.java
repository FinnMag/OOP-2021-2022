package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

/*

The infinite number of waves make up the mind, and all minds are made up of these waves which then interact with one another to form reality via Fourier transformations
Science is not supposed to give meaning to ones life or the reason behind their existence; science only explains the testable and provable mechanisms that run the universe

*/

public class Audio2 extends PApplet
{
    Minim minim;
    AudioPlayer audioPlayer;
    AudioInput audioInput;
    AudioBuffer audioBuffer;

    int mode = 0;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    FFT fft;

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
            if (audioPlayer.isPlaying()) {
                audioPlayer.pause();
            } else {
                audioPlayer.rewind();
                audioPlayer.play();
            }
        }
	}

    public void settings()
    {
        size(1024, 1000, P3D);
        //fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        //audioInput = minim.getLineIn(Minim.MONO, width, 44100, 16);
        //audioBuffer = audioInput.mix; 
        audioPlayer = minim.loadFile("heroplanet.mp3", 1024);
        audioPlayer.play();
        audioBuffer = audioPlayer.mix;
        colorMode(RGB);

        fft = new FFT(1024, 44100);

        y = height / 2;
        smoothedY = y;

        lerpedBuffer = new float[width];
    }

    float off = 0;

    public void draw()
    {
        background(0);
        stroke(255);
        float halfH = height / 2;
        for(int i = 0 ; i < audioBuffer.size() ; i ++)
        {
            line(i, halfH, i, halfH + audioBuffer.get(i) * halfH);
        }

        fft.window(FFT.HAMMING);
        fft.forward(audioBuffer);

        stroke(0, 255, 0);
        for(int i = 0 ; i < fft.specSize(); i ++)
        {
            line(i, 0, i,fft.getBand(i) * 10);
        }


        int maxIndex = 0;

        for(int i = 0 ; i < fft.specSize(); i ++)
        {
            if (fft.getBand(i) > fft.getBand(maxIndex))
            {
                maxIndex = i;
            }
        }

        // Fill out missing code!!

        float freq = fft.indexToFreq(maxIndex);

        textSize(20);
        fill(255);
        text("Freq: " + freq, 100, 200);

    }   
}
