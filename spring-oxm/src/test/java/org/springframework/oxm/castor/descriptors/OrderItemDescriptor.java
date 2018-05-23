package org.springframework.oxm.castor.descriptors;

import org.exolab.castor.mapping.AccessMode;
import org.exolab.castor.mapping.FieldDescriptor;
import org.exolab.castor.xml.TypeValidator;
import org.exolab.castor.xml.XMLFieldDescriptor;

import org.springframework.oxm.castor.OrderItem;

public class OrderItemDescriptor extends OrderItemTypeDescriptor {
	private boolean _elementDefinition;
	private String _nsPrefix;
	private String _nsURI;
	private String _xmlName;
	private XMLFieldDescriptor _identity;

	public OrderItemDescriptor() {
		setExtendsWithoutFlatten(new OrderItemTypeDescriptor());
		this._nsURI = "http://samples.springframework.org/order";
		this._xmlName = "order-item";
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
		return OrderItem.class;
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