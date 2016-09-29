package demo;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
 
@ManagedBean
public class LtLocations implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private MapModel simpleModel = new DefaultMapModel();
  
    public LtLocations() {
        simpleModel.addOverlay(new Marker(new LatLng(43.6556128,-79.387219), "Toronto"));
        simpleModel.addOverlay(new Marker(new LatLng(39.0595879,-77.1253589), "Rockville, MD"));
    }
  
    public MapModel getModel() {
        return simpleModel;
    }
}
