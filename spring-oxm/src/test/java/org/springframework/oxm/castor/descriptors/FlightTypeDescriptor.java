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
import org.exolab.castor.xml.validators.LongValidator;

import org.springframework.oxm.castor.FlightType;

public class FlightTypeDescriptor extends XMLClassDescriptorImpl {
	private boolean _elementDefinition;
	private String _nsPrefix;
	private String _nsURI;
	private String _xmlName;
	private XMLFieldDescriptor _identity;

	public FlightTypeDescriptor() {
		this._nsURI = "http://samples.springframework.org/flight";
		this._xmlName = "flightType";
		this._elementDefinition = false;

		setCompositorAsSequence();
		XMLFieldDescriptorImpl desc = null;
		FieldHandler handler = null;
		FieldValidator fieldValidator = null;

		desc = new XMLFieldDescriptorImpl(Long.TYPE, "number", "number",
				NodeType.Element);
		handler = new XMLFieldHandler() {
			@Override
			public Object getValue(Object object) throws IllegalStateException {
				FlightType target = (FlightType) object;
				if (!target.hasNumber()) {
					return null;
				}
				return new Long(target.getNumber());
			}

			@Override
			public void setValue(Object object, Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					FlightType target = (FlightType) object;

					if (value == null) {
						return;
					}

					target.setNumber(((Long) value).longValue());
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
		desc.setSchemaType("long");
		desc.setHandler(handler);
		desc.setNameSpaceURI("http://samples.springframework.org/flight");
		desc.setRequired(true);
		desc.setMultivalued(false);
		addFieldDescriptor(desc);
		addSequenceElement(desc);

		fieldValidator = new FieldValidator();
		fieldValidator.setMinOccurs(1);

		LongValidator typeValidator = new LongValidator();
		fieldValidator.setValidator(typeValidator);
		typeValidator.setMinInclusive(-9223372036854775808L);
		typeValidator.setMaxInclusive(9223372036854775807L);

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
		return FlightType.class;
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