package renderin;

import java.awt.Color;

public class Plane implements Object3D {
    private Mesh mesh;
    private Vector3D position;    	// obj position
    private Vector3D rotation;    	// obj ROTATION
    private Vector3D scale;        	// Obj scale
    private Color color;

    public Plane(Vector3D position, Vector3D scale, Vector3D rotation, Color color) {
        this.position = position;
        this.scale = scale;
        this.rotation = rotation;
        this.color = color;
        this.mesh = createPlaneMesh(); // You should implement createPlaneMesh() to generate the plane's mesh.
    }
    

    private Mesh createPlaneMesh() {
        Mesh planeMesh = new Mesh();

        Vector3D v0 = new Vector3D(-1, 0.0f, -1f); // bottom-left
        Vector3D v1 = new Vector3D(1f, 0.0f, -1f);  // bottom-right
        Vector3D v2 = new Vector3D(1f, 0.0f, 1f);   // top-right
        Vector3D v3 = new Vector3D(-1f, 0.0f, 1f);  // top-left

        // Add vertices to the mesh
        planeMesh.addVertex(v0);
        planeMesh.addVertex(v1);
        planeMesh.addVertex(v2);
        planeMesh.addVertex(v3);

        // Create two triangles using the vertices
        Triangle triangle1 = new Triangle(0, 1, 2);
        Triangle triangle2 = new Triangle(0, 2, 3);

        // Add triangles to the mesh
        planeMesh.addTriangle(triangle1);
        planeMesh.addTriangle(triangle2);

        return planeMesh;
    }

    @Override
    public Mesh getMesh() {
        return mesh;
    }

    @Override
    public Vector3D getPosition() {
        return position;
    }

    @Override
    public Vector3D getRotation() {
        return rotation;
    }

    @Override
    public Vector3D getScale() {
        return scale;
    }

    @Override
    public Vector3D getMinBounds() {
        // You need to implement this method to return the minimum bounds of the plane.
        return null;
    }

    @Override
    public Vector3D getMaxBounds() {
        // You need to implement this method to return the maximum bounds of the plane.
        return null;
    }

    @Override
	public Matrix4x4 getModelMatrix() {
		Matrix4x4 rotationMatrix = Matrix4x4.rotation(rotation);
		Matrix4x4 translationMatrix = Matrix4x4.translation(position);
		Matrix4x4 scalingMatrix = Matrix4x4.scale(scale);
		
		return rotationMatrix.multiply(translationMatrix).multiply(scalingMatrix);
	}
    
    @Override
	public Color getColor() {
		return color;
	}
}