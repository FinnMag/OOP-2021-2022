package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

	int mode = 0;

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);

	}

	public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		println(mode);
	}

	float magicMap(float a, float b, float c, float d, float e) {
		float output;
		a -= b;
		c -= b;
		e -= d;

		output = ((a / c) * e) + d;

		return output;
	}

	float magicMap1(float a, float b, float c, float d, float e) {
		float r1 = c - b;
		float r2 = e - d;
		float howFar = a - b;

		return d + ((howFar / r1) * r2);
	}

	float offset = 0;

	public void draw() {
		switch (mode) {
			case 0:
				background(0);
				//Creates an integer based on the position of mouse within window
				//ie X = 500, 500/20 = 25 bars
				int bars = (int) (mouseX / 20.0f);
				//Width of bars = Width of Screen / Amount of Bars
				float w = width / (float) bars;

				for (int i = 0; i < bars; i++) {
					noStroke();
					// map(a, b, c, d, e);
					// a = Input Value
					// b, c - start and end of the first range
					// d, e - start and and of the end range
					fill(map(i, 0, bars, 0, 255), 255, 255);
					rect(map(i, 0, bars, 0, 500), 0, w, height);
				}

				break;
			
			case 1:
				background(0);
				int squares = (int) (mouseX / 20.f);
				float h = width / (float) squares;

				for (int i = 0; i < squares; i++) {
					noStroke();
					fill(map(i, 0, squares, 0, 255), 255, 255);
					float x = map(i, 0, squares, 0, width);
					rect(x, x, h, h);
					rect((width - h) - x, x, h, h);

				}

				break;

			case 2:
				background(0);
				int circles = (int) (mouseX / 20.f);

				for (int i = 0; i < circles; i++) {
					noStroke();
					fill(map(i, 0, circles, 0, 255), 255, 255);
					float circleWidth = width - map(i, 0, circles, 0, width - 50);
					ellipse(width / 2, height / 2, circleWidth, circleWidth);
				}
				
			break;

			case 3:
				background(0);
				int numCircles = (int) (mouseX / 20.f);
				float circleWidth = width / (float) numCircles;


				for (int i = 1; i < numCircles; i++) {
					noStroke();
					fill(map(i, 0, numCircles, 0, 255), 255, 255);
					//maps x cordinate of each circle	
					float x = map(i, 0, numCircles, 0, width);
					circle(x, 250, circleWidth);
					
				}
				
			break;

			case 4:
				background(0);
				numCircles = (int) (mouseX / 20.f);
				circleWidth = width / (float) numCircles;

				for(int row = 1; row < numCircles; row++) {
					for(int col = 1; col < numCircles; col++) {
						noStroke();
						fill(map(col, 0, numCircles, 0, 255), 255, 255);
						//maps x and y cordinates of each circle	
						float x = map(row, 0, numCircles, 0, width);
						float y = map(col, 0, numCircles, 0, height);
						circle(x, y, circleWidth);
					}

				}
				
			break;

			case 5:
				background(0);
				int numTiles = (int) (mouseX / 20.f);
				float tileWidth = width / (float) numTiles;
				
				for(int row = 0; row < numTiles; row++) {
					for(int col = 0; col < numTiles; col++) {
						noStroke();
						
						//maps x and y cordinates of each tile	
						float x = map(row, 0, numTiles, 0, width);
						float y = map(col, 0, numTiles, 0, height);
						if(x % 2 == 0) {
							fill(map(row, 0, numTiles, 255, 255), 255, 255);
						}
						else {
							fill(map(row, 0, numTiles, 100, 100), 255, 255);
						}
						square(x, y, tileWidth);
					}
				
				}

			break;

		}
	}
}

