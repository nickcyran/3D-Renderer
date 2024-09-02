package renderin;

import java.awt.Color;

public class Cube implements Object3D {
	private Mesh mesh;
	private Vector3D position;	//obj position
	private Vector3D rotation;	//obj ROTATION
	private Vector3D scale;		//Obj scale
	private Color color;
	
	Cube(){
		this(new Vector3D(0,0,0), new Vector3D(0,0,0), new Vector3D(0,0,0), Color.yellow);
	}
	
	Cube(Vector3D pos, Vector3D s, Vector3D rot, Color c){
		mesh = createCube();
		position = pos;
		scale = s;
		rotation = rot;
		color = c;
	}
	
	public Mesh createCube() {
		Mesh cubeMesh = new Mesh();
		addCubeVertices(cubeMesh);
		addCubeFaces(cubeMesh);
		return cubeMesh;
	}
	
	private void addCubeVertices(Mesh mesh) {
		for (int x = 0; x < 2; x++) {
			for (int y = 0; y < 2; y++) {
				for (int z = 0; z < 2; z++) {
					mesh.addVertex((new Vector3D(x, y, z)));
				}
			}
		} 
	}

	private void addCubeFaces(Mesh mesh) {
		int[][] faces = { 
				{ 0, 1, 3, 2 }, // front face
				{ 1, 5, 7, 3 }, // right face
				{ 5, 4, 6, 7 }, // back face
				{ 4, 0, 2, 6 }, // left face
				{ 3, 7, 6, 2 }, // top face
				{ 0, 4, 5, 1 }  // bottom face
		};

		for (int[] face : faces) {
			mesh.addTriangle(new Triangle(face[0], face[1], face[2]));
			mesh.addTriangle(new Triangle(face[0], face[2], face[3]));
		}
	}
	
	@Override
    public Vector3D getMinBounds() {
        return position.subtract(scale.scale(0.5f));
    }

	@Override
    public Vector3D getMaxBounds() {
        return position.add(scale.scale(0.5f));
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
