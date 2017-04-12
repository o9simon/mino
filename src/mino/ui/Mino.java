package mino.ui;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import mino.core.Controller;
import mino.core.Stack;

public class Mino {
	
	private int width = 800;
	private int height = 600;
	
	private Controller ctrl = new Controller();
	
	private char data;
	
    public void start() {	
        try {
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.create();
            Display.setTitle("mino");
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        initGL();

        while (true) {
            renderGL();
            Display.update();
            Display.sync(60); // cap fps to 60fps
        }

        //Display.destroy();
        //System.exit(0);
    }

    public void initGL() {
    	GL11.glEnable(GL11.GL_TEXTURE_2D); // Enable Texture Mapping
        GL11.glShadeModel(GL11.GL_SMOOTH); // Enable Smooth Shading
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // Black Background
        GL11.glClearDepth(1.0); // Depth Buffer Setup
        GL11.glEnable(GL11.GL_DEPTH_TEST); // Enables Depth Testing
        GL11.glDepthFunc(GL11.GL_LEQUAL); // The Type Of Depth Testing To Do
        GL11.glMatrixMode(GL11.GL_PROJECTION); // Select The Projection Matrix
        GL11.glLoadIdentity(); // Reset The Projection Matrix       
        GLU.gluPerspective(45.0f, (float)width /(float)height, 0.1f, 100.0f); // Calculate The Aspect Ratio Of The Window
        GL11.glMatrixMode(GL11.GL_MODELVIEW); // Select The Modelview Matrix
        GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST); // Really Nice Perspective Calculations
    }

    public void renderGL() {
    	ctrl.update();
    	
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT))
        	ctrl.left();
        
        if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
        	ctrl.right();
        
        if (Keyboard.isKeyDown(Keyboard.KEY_DOWN))
        	ctrl.down();
        
        if (Keyboard.isKeyDown(Keyboard.KEY_Z))
        	ctrl.leftRotation();
        
        if (Keyboard.isKeyDown(Keyboard.KEY_X))
        	ctrl.rightRotation();
    	
    	GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT); // Clear The Screen And The Depth Buffer
		
		GL11.glLoadIdentity();
		GL11.glTranslatef(-25.0f, 20.0f, -100.0f);
		
		for (int y = 0; y < Stack.GRID_HEIGHT; y++) {
			GL11.glTranslatef(0.0f, -2.0f, 0.0f);
			
			for (int x = 0; x < Stack.GRID_WIDTH; x++) {
				GL11.glTranslatef(2.0f, 0.0f, 0.0f);
				
				data = ctrl.getData(x, y);
				if (data != 'X') {
					if (data == 'I') {
						GL11.glColor3f(0.0f, 0.0f, 1.0f);
					} else if (data == 'J') {
						GL11.glColor3f(1.0f, 0.5f, 0.0f);
					} else if (data == 'L') {
						GL11.glColor3f(1.0f, 0.0f, 0.0f);
					} else if (data == 'O') {
						GL11.glColor3f(1.0f, 1.0f, 0.0f);
					} else if (data == 'S') {
						GL11.glColor3f(0.5f, 0.5f, 0.0f);
					} else if (data == 'T') {
						GL11.glColor3f(0.0f, 1.0f, 1.0f);
					} else if (data == 'Z') {
						GL11.glColor3f(0.0f, 1.0f, 0.0f);
					}
					GL11.glBegin(GL11.GL_QUADS);
					GL11.glVertex3f( 1.0f, 1.0f,-1.0f);         // Top Right Of The Quad (Top)
					GL11.glVertex3f(-1.0f, 1.0f,-1.0f);         // Top Left Of The Quad (Top)
					GL11.glVertex3f(-1.0f, 1.0f, 1.0f);         // Bottom Left Of The Quad (Top)
					GL11.glVertex3f( 1.0f, 1.0f, 1.0f);         // Bottom Right Of The Quad (Top)
					GL11.glVertex3f( 1.0f,-1.0f, 1.0f);         // Top Right Of The Quad (Bottom)
					GL11.glVertex3f(-1.0f,-1.0f, 1.0f);         // Top Left Of The Quad (Bottom)
					GL11.glVertex3f(-1.0f,-1.0f,-1.0f);         // Bottom Left Of The Quad (Bottom)
					GL11.glVertex3f( 1.0f,-1.0f,-1.0f);         // Bottom Right Of The Quad (Bottom)
					GL11.glVertex3f( 1.0f, 1.0f, 1.0f);         // Top Right Of The Quad (Front)
					GL11.glVertex3f(-1.0f, 1.0f, 1.0f);         // Top Left Of The Quad (Front)
					GL11.glVertex3f(-1.0f,-1.0f, 1.0f);         // Bottom Left Of The Quad (Front)
					GL11.glVertex3f( 1.0f,-1.0f, 1.0f);         // Bottom Right Of The Quad (Front)
					GL11.glVertex3f( 1.0f,-1.0f,-1.0f);         // Bottom Left Of The Quad (Back)
					GL11.glVertex3f(-1.0f,-1.0f,-1.0f);         // Bottom Right Of The Quad (Back)
					GL11.glVertex3f(-1.0f, 1.0f,-1.0f);         // Top Right Of The Quad (Back)
					GL11.glVertex3f( 1.0f, 1.0f,-1.0f);         // Top Left Of The Quad (Back)
					GL11.glVertex3f(-1.0f, 1.0f, 1.0f);         // Top Right Of The Quad (Left)
					GL11.glVertex3f(-1.0f, 1.0f,-1.0f);         // Top Left Of The Quad (Left)
					GL11.glVertex3f(-1.0f,-1.0f,-1.0f);         // Bottom Left Of The Quad (Left)
					GL11.glVertex3f(-1.0f,-1.0f, 1.0f);         // Bottom Right Of The Quad (Left)
					GL11.glVertex3f( 1.0f, 1.0f,-1.0f);         // Top Right Of The Quad (Right)
					GL11.glVertex3f( 1.0f, 1.0f, 1.0f);         // Top Left Of The Quad (Right)
					GL11.glVertex3f( 1.0f,-1.0f, 1.0f);         // Bottom Left Of The Quad (Right)
					GL11.glVertex3f( 1.0f,-1.0f,-1.0f);         // Bottom Right Of The Quad (Right)
					GL11.glEnd();
				}
			}
			
			GL11.glTranslatef(-20.0f, 0.0f, 0.0f);
		}
    }

    public static void main(String[] argv) {
        (new Mino()).start();
    }
}
