package org.springframework.oxm.castor.descriptors;

import org.exolab.castor.mapping.AccessMode;
import org.exolab.castor.mapping.FieldDescriptor;
import org.exolab.castor.mapping.FieldHandler;
import org.exolab.castor.xml.FieldValidator;
import org.exolab.castor.xml.NodeType;
import org.exolab.castor.xml.TypeValidator;
import org.exolab.castor.xml.XMLFieldDescriptor;
import org.exolab.castor.xml.XMLFieldHandler;
import org.exolab.castor.xml.util.XMLClassDescriptorImpl;
import org.exolab.castor.xml.util.XMLFieldDescriptorImpl;

import org.springframework.oxm.castor.Order;
import org.springframework.oxm.castor.OrderItem;

public class OrderDescriptor extends XMLClassDescriptorImpl {
	private boolean _elementDefinition;
	private String _nsPrefix;
	private String _nsURI;
	private String _xmlName;
	private XMLFieldDescriptor _identity;

	public OrderDescriptor() {
		this._nsURI = "http://samples.springframework.org/order";
		this._xmlName = "order";
		this._elementDefinition = true;

		setCompositorAsSequence();
		XMLFieldDescriptorImpl desc = null;
		FieldHandler handler = null;
		FieldValidator fieldValidator = null;

		desc = new XMLFieldDescriptorImpl(OrderItem.class, "orderItemList", "order-item",
				NodeType.Element);
		handler = new XMLFieldHandler() {
			@Override
			public Object getValue(Object object) throws IllegalStateException {
				Order target = (Order) object;
				return target.getOrderItem();
			}

			@Override
			public void setValue(Object object, Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					Order target = (Order) object;
					target.addOrderItem((OrderItem) value);
				}
				catch (Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			@Override
			public void resetValue(Object object)
					throws IllegalStateException, IllegalArgumentException {
				try {
					Order target = (Order) object;
					target.removeAllOrderItem();
				}
				catch (Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			@Override
			public Object newInstance(Object parent) {
				return new OrderItem();
			}
		};
		desc.setSchemaType("list");
		desc.setComponentType("org.springframework.oxm.castor.OrderItem");
		desc.setHandler(handler);
		desc.setNameSpaceURI("http://samples.springframework.org/order");
		desc.setRequired(true);
		desc.setMultivalued(true);
		addFieldDescriptor(desc);
		addSequenceElement(desc);

		fieldValidator = new FieldValidator();
		fieldValidator.setMinOccurs(1);

		desc.setValidator(fieldValidator);
	}

	@Override
	public AccessMode getAccessMode() {
		return null;
	}

	@Override
	public FieldDescriptor getIdentity() {
		return this._identity;
	}

	@Override
	public Class getJavaClass() {
		return Order.class;
	}

	@Override
	public String getNameSpacePrefix() {
		return this._nsPrefix;
	}

	@Override
	public String getNameSpaceURI() {
		return this._nsURI;
	}

	@Override
	public TypeValidator getValidator() {
		return this;
	}

	@Override
	public String getXMLName() {
		return this._xmlName;
	}

	@Override
	public boolean isElementDefinition() {
		return this._elementDefinition;
	}
}