package demo;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
 
@ManagedBean
@ApplicationScoped
public class LtLocations implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private MapModel model;

	@PostConstruct
    public void init() {
		System.out.println("LtLocations.init()");
		
    	model = new DefaultMapModel();
		// US
        model.addOverlay(new Marker(new LatLng(38.955777, -77.4156047), "Herndon, VA"));
        model.addOverlay(new Marker(new LatLng(39.0595879, -77.1253589), "Rockville, MD"));
		// CA
        model.addOverlay(new Marker(new LatLng(43.6556128, -79.387219), "Toronto"));
        model.addOverlay(new Marker(new LatLng(45.3842746, -75.9137376), "Ottawa"));
		// UK
        model.addOverlay(new Marker(new LatLng(51.5286966, -0.1337989), "London"));
		// SV
        model.addOverlay(new Marker(new LatLng(59.338296, 18.0057384), "Stockholm"));
		// FR
        model.addOverlay(new Marker(new LatLng(48.8420222, 2.31957), "Paris"));
		// JP
		// Haven't found street address... Pin is in the harbor :-)
        model.addOverlay(new Marker(new LatLng(35.6594398, 139.760134), "Tokyo"));
    }
  
    public MapModel getModel() {
		System.out.println("LtLocations.getModel()");
        return model;
    }
}
