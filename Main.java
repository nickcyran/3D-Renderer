package renderin;

import java.awt.Color;

public class Main {
	private Camera camera;
	private Renderer rend;
	private InputHandler inputHandler;
	private Scene scene;

	Main() {
		scene = new Scene();
		camera = new Camera();
	
		rend = new Renderer(camera, scene);
		inputHandler = new InputHandler();
		
		Window window = new Window();
		window.add(rend);
		window.addKeyListener(inputHandler);
		
		scene.addObject(new Cube(
							new Vector3D(1,-1f,5), 		//pos
							new Vector3D(1,1,1),		//scale
							new Vector3D(0,0,0),		//rotation
							Color.yellow
						)); 	
	}
 
	public void start() {
	    long lastTime = System.nanoTime();
	    double nsPerUpdate = 1000000000.0 / 60.0; // Targeting 60 updates per second
	    double delta = 0;

	    while (true) {
	        long now = System.nanoTime();
	        delta += (now - lastTime) / nsPerUpdate;
	        lastTime = now;

	        while (delta >= 1) {
	            update();
	            delta--;
	        }
	        rend.render();       
	    }
	}

	private void update() {
		camera.moveCamera(inputHandler, scene.getObjects());
	}

	public static void main(String[] args) {
        Main app = new Main();
		app.start();
	}
}