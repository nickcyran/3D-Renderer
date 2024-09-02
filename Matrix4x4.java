package renderin;

public class Matrix4x4 {
    private float[][]matrix;

    public Matrix4x4(float[][]matrix) {
        if (matrix.length == 4 &&matrix[0].length == 4 && 
           matrix[1].length == 4 &&matrix[2].length == 4 &&
           matrix[3].length == 4) {
            this.matrix = matrix;
        } else {
            throw new IllegalArgumentException("Invalid matrix dimensions");
        }
    }

    public Matrix4x4 multiply(Matrix4x4 other) { 
        float[][] result = new float[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 4; k++) {
                    result[i][j] +=matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return new Matrix4x4(result);
    }
    
    public Vector4D multiply(Vector4D vector) {
        float[] result = new float[4];

        for (int i = 0; i < 4; i++) {
            result[i] = 0;
            for (int j = 0; j < 4; j++) {
                result[i] +=matrix[i][j] * vector.getElement(j);
            }
        }

        return new Vector4D(result[0], result[1], result[2], result[3]);
    }
    
    public static Matrix4x4 rotation(Vector3D rotation) {	//not investing too much atm
        float yaw = (float) Math.toRadians(rotation.getY()); 
        float pitch = (float) Math.toRadians(rotation.getX());
        float roll = (float) Math.toRadians(rotation.getZ());

        float cosYaw = (float) Math.cos(yaw);
        float sinYaw = (float) Math.sin(yaw);
        float cosPitch = (float) Math.cos(pitch);
        float sinPitch = (float) Math.sin(pitch);
        float cosRoll = (float) Math.cos(roll);
        float sinRoll = (float) Math.sin(roll);

        // Build the rotation matrix
        float[][] matrix = {
            {cosYaw * cosPitch, cosYaw * sinPitch * sinRoll - sinYaw * cosRoll, cosYaw * sinPitch * cosRoll + sinYaw * sinRoll, 0},
            {sinYaw * cosPitch, sinYaw * sinPitch * sinRoll + cosYaw * cosRoll, sinYaw * sinPitch * cosRoll - cosYaw * sinRoll, 0},
            {-sinPitch, cosPitch * sinRoll, cosPitch * cosRoll, 0},
            {0, 0, 0, 1}
        };

        return new Matrix4x4(matrix);
    }
    
    public static Matrix4x4 scale(float x, float y, float z) {
        return new Matrix4x4(new float[][] {
            {x, 0, 0, 0},
            {0, y, 0, 0},
            {0, 0, z, 0},
            {0, 0, 0, 1}
        });
    }
    
    public static Matrix4x4 scale(Vector3D v) {
        return new Matrix4x4(new float[][] {
            {v.getX(), 0, 0, 0},
            {0, v.getY(), 0, 0},
            {0, 0, v.getZ(), 0},
            {0, 0, 0, 1}
        });
    }
     
    public static Matrix4x4 translation(float x, float y, float z) {
        return new Matrix4x4(new float[][] {
            {1, 0, 0, x},
            {0, 1, 0, y},
            {0, 0, 1, z},
            {0, 0, 0, 1}
        });
    }
    
    public static Matrix4x4 translation(Vector3D v) {
        return new Matrix4x4(new float[][] {
            {1, 0, 0, v.getX()},
            {0, 1, 0, v.getY()},
            {0, 0, 1, v.getZ()},
            {0, 0, 0, 1}
        });
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Matrix4x4:\n");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result.append(matrix[i][j]).append("\t");
            }
            result.append("\n");
        }

        return result.toString();
    }


}