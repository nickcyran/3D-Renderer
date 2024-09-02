package renderin;

import java.util.List;

public class Camera {
	private float aspectRatio = 1.33f;
	private float fov = 0.001f;		
	private float near = 1; 		
	private float far = 100;		
	private float moveSpeed = 0.2f;

	private Vector3D cameraPos = new Vector3D(28.2703f, -18.720147f, 5.160756f);	
	private Vector3D cameraFront = new Vector3D(0.78080195f, -0.32404298f, 0.53417647f);
	private Vector3D cameraUp = new Vector3D(0, 1, 0);

	private float yaw = 0.600001f;
	private float pitch = -0.33999994f;
	
	public Matrix4x4 perspectiveViewMatrix() {
		var vM = viewMatrix();
		return perspectiveMatrix().multiply(vM);
	}
	
	public Matrix4x4 perspectiveMatrix() {
		return new Matrix4x4(new float[][] { 
				{ (float) (1 / (Math.tan(fov / 2) * aspectRatio)), 0, 0, 0 },
				{ 0, (float) (1 / (Math.tan(fov / 2))), 0, 0 }, 
				{ 0, 0, -(far + near) / (far - near), -(2* far * near) / (far - near) },
				{ 0, 0, 1, 0 } });
	}

	public Matrix4x4 viewMatrix() {
		Vector3D cTarget = cameraPos.add(cameraFront);
		Vector3D cDirection = cameraPos.subtract(cTarget).normalize();
		Vector3D cRight = cameraUp.cross(cDirection).normalize();
		Vector3D cUp = cDirection.cross(cRight);

		return new Matrix4x4(new float[][] { 
				{ cRight.getX(), cRight.getY(), cRight.getZ(), 0 },
				{ cUp.getX(), cUp.getY(), cUp.getZ(), 0 },
				{ cDirection.getX(), cDirection.getY(), cDirection.getZ(), 0 }, 
				{ 0, 0, 0, 1 } })
				.multiply(Matrix4x4.translation(cameraPos));
	}

	public void moveCamera(InputHandler input, List<Object3D> objects) {
		float sense = 0.013f;
		for (Direction key : input.getKeys()) {
			switch (key) {
			// move y-axis
			case UP -> moveYaxis(-moveSpeed);
			case DOWN -> moveYaxis(moveSpeed);

			// move z-axis
			case FORWARD -> moveZaxis(-moveSpeed);
			case BACKWARD -> moveZaxis(moveSpeed);

			// move x-axis
			case LEFT -> moveXaxis(-moveSpeed);
			case RIGHT -> moveXaxis(moveSpeed);

			// rotate-y
			case C_LEFT -> changeYaw(sense);

			case C_RIGHT -> changeYaw(-sense);

			// rotate-x
			case C_UP -> changePitch(sense);
			case C_DOWN -> changePitch(-sense);
			}
		}
	}

	private void moveYaxis(float i) {
		cameraPos.addtoY(i);
	}

	private void moveZaxis(float i) {
	    // Save the current y position
	    float currentY = cameraPos.getY();		//maintain height regardless of where looking

	    // Calculate the new camera position
	    Vector3D newPosition = cameraPos.add(cameraFront.scale(i));

	    // Set the y component back to the original value
	    newPosition.setY(currentY);

	    // Update the camera position
	    cameraPos.setVector(newPosition);
	}

	private void moveXaxis(float i) {
		cameraPos.addTo(cameraFront.cross(cameraUp).normalize().scale(i));
	}
	
	private void updateCamFront() {
		float dirX = (float) (Math.cos(yaw) * Math.cos(pitch));
		float dirY = (float)  Math.sin(pitch);
		float dirZ = (float) (Math.sin(yaw) * Math.cos(pitch));

		Vector3D direction = new Vector3D(dirX, dirY, dirZ);
		cameraFront = direction.normalize();
	}
	
	private void changeYaw(float sense) {
		yaw += sense;
		updateCamFront();
	}

	private void changePitch(float sense) {
		pitch += sense;
		int deg = 1;
		if (pitch > deg) {
			pitch = deg;
		}

		if (pitch < -deg) {
			pitch = -deg;
		}
		updateCamFront();
	}
}