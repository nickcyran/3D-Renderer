package renderin;


import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Window extends JFrame {
	private static final long serialVersionUID = 3123582157964830966L;
	
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;
	
	Window(){
		setTitle("Renderer");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
