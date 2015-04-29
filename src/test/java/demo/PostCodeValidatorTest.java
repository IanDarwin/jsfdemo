package demo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PostCodeValidatorTest {

	PostalCodeValidationDemo target;
	FacesContext jsfContext;
	UIComponent component;
	
	@Before
	public void start() {
		target = new PostalCodeValidationDemo();
		jsfContext = mock(FacesContext.class);
		component = mock(UIInput.class);
	}
	
	@Test
	public void testCanadaGood() {
		target.setCountry(Country.CANADA);
		when (component.getClientId(jsfContext)).thenReturn("fred");
		target.validatePostCode(jsfContext,
	            component, "M5S 1A1");
		((UIInput) verify(component, never())).setValid(false);
	}
	
	@Test
	public void testCanadaBad() {
		target.setCountry(Country.CANADA);
		when (component.getClientId(jsfContext)).thenReturn("fred");
		target.validatePostCode(jsfContext,
	            component, "Key Lime Pie");
		((UIInput) verify(component, times(1))).setValid(false);
	}

	/** Test a USA Postal Code */
	@Test
	public void testUSAGood() {
		target.setCountry(Country.USA);
		when (component.getClientId(jsfContext)).thenReturn("fred");
		target.validatePostCode(jsfContext,
	            component, "20212");
		((UIInput) verify(component, never())).setValid(false);
	}
	
	/** Test a USA "5+4" Postal Code */
	@Test
	public void testUSALongGood() {
		target.setCountry(Country.USA);
		when (component.getClientId(jsfContext)).thenReturn("fred");
		target.validatePostCode(jsfContext,
	            component, "20212-1234");
		((UIInput) verify(component, never())).setValid(false);
	}

	/** The "Other" doesn't get any validation ATM so this must pass */
	@Test
	public void testOther() {
		target.setCountry(Country.OTHER);
		when (component.getClientId(jsfContext)).thenReturn("fred");
		target.validatePostCode(jsfContext,
	            component, "GIGO");
		((UIInput) verify(component, never())).setValid(false);

	}
}
