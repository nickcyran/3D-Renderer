package renderin;
public class Vector3D {
    private float x;
    private float y;
    private float z;

    public Vector3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public void setVector(Vector3D v) {
    	x = v.getX();
    	y = v.getY();
    	z = v.getZ();
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
    
    public void setZ(float v) {
    	z = v;
    }
    
    public void setY(float v) {
    	y = v;
    }
    public void setX(float v) {
    	x = v;
    }
    
    public void addtoX(float i) {
        x+= i;
    }
    public void addtoY(float i) {
    	y+= i;
    }
    public void addtoZ(float i) {
    	z+= i;
    }
    
    public Vector3D rotate(float angle, Vector3D axis) {
        float cos = (float)Math.cos(angle);
        float sin = (float)Math.sin(angle);
        float dot = this.dot(axis);
        Vector3D cross = this.cross(axis);

        return this.scale(cos).add(cross.scale(sin)).add(axis.scale(dot * (1 - cos)));
    }

    public Vector3D add(Vector3D other) {
        return new Vector3D(x + other.x, y + other.y, z + other.z);
    }
    
    public void addTo(Vector3D other) {
        x += other.x;
        y += other.y;
        z += other.z;
    }

    public Vector3D subtract(Vector3D other) {
        return new Vector3D(x - other.x, y - other.y, z - other.z);
    }

    public Vector3D scale(float scalar) {
        return new Vector3D(x * scalar, y * scalar, z * scalar);
    }

    public Vector3D divide(float scalar) {
        if (scalar != 0) {
            return new Vector3D(x / scalar, y / scalar, z / scalar);
        } else {
            throw new ArithmeticException("Division by zero");
        }
    }

    public float dot(Vector3D other) {
        return x * other.x + y * other.y + z * other.z;
    }

    public Vector3D cross(Vector3D other) {
        return new Vector3D(
                y * other.z - z * other.y,
                z * other.x - x * other.z,
                x * other.y - y * other.x
        );
    }

    public float magnitude() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3D normalize() {
        float mag = magnitude();
        if (mag != 0) {
            return divide(mag);
        } else {
            // Handle zero-length vectors
            throw new ArithmeticException("Cannot normalize a zero-length vector");
        }
    }

    public Vector3D negate() {
        return new Vector3D(-x, -y, -z);
    }
    
    public Vector4D homogeneous() {
    	return new Vector4D(x,y,z,1);
    }
    
    public String toString() {
    	return "{x: " + x + ", y: " + y + ", z: " + z + "}"; 
    }
}