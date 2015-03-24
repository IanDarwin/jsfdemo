package spy;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;

/**
 * This is intended to present a JPA-free but JPA-like interface.
 * If you have JPA, you might be able to build this class from
 * the author's darwinsys-ee project, using EntityHome.
 *  * @author Ian Darwin
 */
@ManagedBean
public class SpyHome {
	
	@Resource SpyList spyList;

	private Spy instance;

	public Spy getInstance() {
		return instance;
	}

	public Spy find(long id) {
		for (Spy spy : spyList.findAll()) {
			if (spy.id == id) {
				instance = spy;
				return instance;
			} 
		}
		throw new IllegalArgumentException("Can't find Spy # " + id);
	}
}