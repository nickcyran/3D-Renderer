package renderin;

import java.awt.Color;

public interface Object3D {				//TODO: make this an abstract class for the love of god man are u stupid or something damn
	public abstract Mesh getMesh();
	public abstract Vector3D getPosition();
	public abstract Vector3D getRotation();
	public abstract Vector3D getScale();
	public abstract Vector3D getMinBounds();
	public abstract Vector3D getMaxBounds();
	
	public abstract Color getColor();
	
	public abstract Matrix4x4 getModelMatrix();

}
