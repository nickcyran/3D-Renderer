package renderin;

public class Triangle {
	int v1,v2,v3;


	Triangle(int v1, int v2, int v3) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	} 
	
	public String toString() {
		return "{v1: " + v1 + ", v2: " + v2 + ", v3: " + v3 + "}"; 
	}
}
