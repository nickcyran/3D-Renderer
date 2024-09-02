package renderin;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Scene{
	private List<Object3D> objects;

    public Scene() {
        objects = new ArrayList<>();
        
        //Initialize a 'floor'
        objects.add(new Plane(
				new Vector3D(0,-1f,3), 		//pos
				new Vector3D(10,10,10),		//scale
				new Vector3D(0,0,0),		//rotation
				Color.black
			));
    }

    public void addObject(Object3D object) {
        objects.add(object);
    }

    public void removeAllObjects() {
        objects.clear();
    }

    public List<Object3D> getObjects() {
        return objects;
    }
    

}