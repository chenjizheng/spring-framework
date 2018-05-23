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

import org.springframework.oxm.jibx.FlightType;

public class Flight extends FlightType implements Serializable {
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

	public static Flight unmarshal(Reader reader)
			throws MarshalException, ValidationException {
		return (Flight) Unmarshaller.unmarshal(Flight.class, reader);
	}

	public void validate() throws ValidationException {
		Validator validator = new Validator();
		validator.validate(this);
	}
}