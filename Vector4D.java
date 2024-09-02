package renderin;
public class Vector4D {
    private float x;
    private float y;
    private float z;
    private float w;

    public Vector4D(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public float getW() {
        return w;
    }
    
    public void setW(float i) {
    	w=i;
    }
    
    public float getElement(int i) {
    	switch(i) {
    	case 0:return x;
    	case 1:return y;
    	case 2:return z;
    	case 3:return w;
    	default:
    		throw new IndexOutOfBoundsException("The index " + i + " is not in Vector4D");
    	}
    }
    
    public Vector4D add(Vector4D other) {
        return new Vector4D(x + other.x, y + other.y, z + other.z, w + other.w);
    }

    public Vector4D subtract(Vector4D other) {
        return new Vector4D(x - other.x, y - other.y, z - other.z, w - other.w);
    }

    public Vector4D multiply(float scalar) {
        return new Vector4D(x * scalar, y * scalar, z * scalar, w * scalar);
    }

    public float dot(Vector4D other) {
        return x * other.x + y * other.y + z * other.z + w * other.w;
    }

    // Additional vector operations...

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ", " + w + ")";
    }
}