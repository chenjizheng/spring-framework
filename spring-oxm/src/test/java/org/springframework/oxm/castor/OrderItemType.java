package org.springframework.oxm.castor;

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.exolab.castor.xml.Validator;
import org.xml.sax.ContentHandler;

public class OrderItemType implements Serializable {
	private String id;
	private int quantity;
	private boolean _hasquantity;

	public void deleteQuantity() {
		this._hasquantity = false;
	}

	public String getId() {
		return this.id;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public boolean hasQuantity() {
		return this._hasquantity;
	}

	public boolean isValid() {
		try {
			validate();
		}
		catch (ValidationException vex) {
			return false;
		}
		return true;
	}

	public void marshal(Writer out) throws MarshalException, ValidationException {
		Marshaller.marshal(this, out);
	}

	public void marshal(ContentHandler handler)
			throws IOException, MarshalException, ValidationException {
		Marshaller.marshal(this, handler);
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this._hasquantity = true;
	}

	public static OrderItemType unmarshal(Reader reader)
			throws MarshalException, ValidationException {
		return (OrderItemType) Unmarshaller.unmarshal(OrderItemType.class, reader);
	}

	public void validate() throws ValidationException {
		Validator validator = new Validator();
		validator.validate(this);
	}
}