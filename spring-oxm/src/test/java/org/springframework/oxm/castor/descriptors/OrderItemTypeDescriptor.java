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
import org.exolab.castor.xml.validators.IntValidator;
import org.exolab.castor.xml.validators.StringValidator;

import org.springframework.oxm.castor.OrderItemType;

public class OrderItemTypeDescriptor extends XMLClassDescriptorImpl {
	private boolean _elementDefinition;
	private String _nsPrefix;
	private String _nsURI;
	private String _xmlName;
	private XMLFieldDescriptor _identity;

	public OrderItemTypeDescriptor() {
		this._nsURI = "http://samples.springframework.org/order";
		this._xmlName = "orderItemType";
		this._elementDefinition = false;
		XMLFieldDescriptorImpl desc = null;
		FieldHandler handler = null;
		FieldValidator fieldValidator = null;

		desc = new XMLFieldDescriptorImpl(String.class, "id", "id", NodeType.Attribute);
		desc.setImmutable(true);
		handler = new XMLFieldHandler() {
			@Override
			public Object getValue(Object object) throws IllegalStateException {
				OrderItemType target = (OrderItemType) object;
				return target.getId();
			}

			@Override
			public void setValue(Object object, Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					OrderItemType target = (OrderItemType) object;
					target.setId((String) value);
				}
				catch (Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			@Override
			public Object newInstance(Object parent) {
				return null;
			}
		};
		desc.setSchemaType("string");
		desc.setHandler(handler);
		desc.setMultivalued(false);
		addFieldDescriptor(desc);

		fieldValidator = new FieldValidator();

		StringValidator typeValidator = new StringValidator();
		fieldValidator.setValidator(typeValidator);
		typeValidator.setWhiteSpace("preserve");

		desc.setValidator(fieldValidator);

		desc = new XMLFieldDescriptorImpl(Integer.TYPE, "quantity", "quantity",
				NodeType.Attribute);
		handler = new XMLFieldHandler() {
			@Override
			public Object getValue(Object object) throws IllegalStateException {
				OrderItemType target = (OrderItemType) object;
				if (!target.hasQuantity()) {
					return null;
				}
				return new Integer(target.getQuantity());
			}

			@Override
			public void setValue(Object object, Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					OrderItemType target = (OrderItemType) object;

					if (value == null) {
						target.deleteQuantity();
						return;
					}
					target.setQuantity(((Integer) value).intValue());
				}
				catch (Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			@Override
			public Object newInstance(Object parent) {
				return null;
			}
		};
		desc.setSchemaType("int");
		desc.setHandler(handler);
		desc.setMultivalued(false);
		addFieldDescriptor(desc);

		fieldValidator = new FieldValidator();

		IntValidator intValidator = new IntValidator();
		fieldValidator.setValidator(intValidator);
		intValidator.setMinInclusive(-2147483648);
		intValidator.setMaxInclusive(2147483647);

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
		return OrderItemType.class;
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