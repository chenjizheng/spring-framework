package org.springframework.oxm.castor.descriptors;

import org.exolab.castor.mapping.AccessMode;
import org.exolab.castor.mapping.FieldDescriptor;
import org.exolab.castor.xml.TypeValidator;
import org.exolab.castor.xml.XMLFieldDescriptor;

import org.springframework.oxm.castor.Flight;

public class FlightDescriptor extends FlightTypeDescriptor {
	private boolean _elementDefinition;
	private String _nsPrefix;
	private String _nsURI;
	private String _xmlName;
	private XMLFieldDescriptor _identity;

	public FlightDescriptor() {
		setExtendsWithoutFlatten(new FlightTypeDescriptor());
		this._nsURI = "http://samples.springframework.org/flight";
		this._xmlName = "flight";
		this._elementDefinition = true;
	}

	public AccessMode getAccessMode() {
		return null;
	}

	public FieldDescriptor getIdentity() {
		if (this._identity == null) {
			return super.getIdentity();
		}
		return this._identity;
	}

	public Class getJavaClass() {
		return Flight.class;
	}

	public String getNameSpacePrefix() {
		return this._nsPrefix;
	}

	public String getNameSpaceURI() {
		return this._nsURI;
	}

	public TypeValidator getValidator() {
		return this;
	}

	public String getXMLName() {
		return this._xmlName;
	}

	public boolean isElementDefinition() {
		return this._elementDefinition;
	}
}