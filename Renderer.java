package renderin;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.util.List;

import javax.swing.JPanel;

public class Renderer extends JPanel{
	private static final long serialVersionUID = -4576361545526054095L;

	private transient Camera camera;
	private transient Scene scene;
	
	Renderer(Camera c, Scene s){
		setBackground(Color.gray); 
		camera = c;
		scene = s;
	}
	
	public void render() {
		repaint();
	}
	
	// x' = PVMx
	// model space(M) -> world space(V) -> view space(P) -> clip space -> (clipping) -> (perspective divide) ->
	// Normalized Device Coordinates -> FrameBufferSpace
	
	
	//	------GRAPHICS PIPELINE------
	// array of vertex (tri class) -> vertex shader -> triangle assembly 
	// -> rasterize -> fragmentShader -> framebuffer[testing and blending]
	
	public void rasterize() {

	}
	    
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);

	    // Enable anti-aliasing for smoother rendering
	    Graphics2D g2d = (Graphics2D) g;
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	    Matrix4x4 pvm = camera.perspectiveViewMatrix();

	    for (Object3D obj : scene.getObjects()) {
	        Mesh mesh = obj.getMesh();
		    g2d.setColor(obj.getColor());
	        List<Vector3D> vertices = mesh.getVertices();

	        Matrix4x4 mat = pvm.multiply(obj.getModelMatrix());
	 

	        for (Triangle tri : mesh.getTriangles()) {
	            Vector4D result1 = mat.multiply(vertices.get(tri.v1).homogeneous());
	            Vector4D result2 = mat.multiply(vertices.get(tri.v2).homogeneous());
	            Vector4D result3 = mat.multiply(vertices.get(tri.v3).homogeneous());

	            double pt1x = result1.getX() / result1.getW();
	            double pt1y = result1.getY() / result1.getW();

	            double pt2x = result2.getX() / result2.getW();
	            double pt2y = result2.getY() / result2.getW();

	            double pt3x = result3.getX() / result3.getW();
	            double pt3y = result3.getY() /  result3.getW();

	            // Create a GeneralPath for the current triangle
	            GeneralPath path = new GeneralPath();
	            path.moveTo(pt1x, pt1y);
	            path.lineTo(pt2x, pt2y);
	            path.lineTo(pt3x, pt3y);
	            path.closePath();

	            // Fill the triangle
	            g2d.fill(path);
	        }
	    }
	}
}