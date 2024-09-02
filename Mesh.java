package renderin;

import java.util.ArrayList;
import java.util.List;

public class Mesh {
    private List<Vector3D> vertices;
    private List<Triangle> triangles;

    public Mesh() {
        this.vertices = new ArrayList<>();
        this.triangles = new ArrayList<>();
    }

    public void addVertex(Vector3D vertex) {
        vertices.add(vertex);
    }

    public void addTriangle(Triangle triangle) {
        triangles.add(triangle);
    }
    
    public List<Triangle> getTriangles(){
    	return triangles;
    }
    
    public List<Vector3D> getVertices(){
    	return vertices;
    }
    
    public void setVertices(List<Vector3D> v){
    	vertices = v;
    }
    
    public void printData() {
    	System.err.println("---[VERTICES]------------");
    	vertices.forEach(System.err::println);

    	
    	System.err.println("---[TRIANGLES]-----------");
    	triangles.forEach(System.err::println);
    }
}