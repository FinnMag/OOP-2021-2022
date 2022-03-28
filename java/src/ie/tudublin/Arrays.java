package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {


    float[] rainfall = { 45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58 };
    String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
    float[] a1 = new float[100];
    float[] a2;

    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
        for(int i = 0; i < rainfall.length; i++) {
            println(rainfall[i] + "\t" + months[i]);
        }

        for(float r:rainfall) {
            println(r);
        }
    }

    public void draw()
    {

    }
        
}
