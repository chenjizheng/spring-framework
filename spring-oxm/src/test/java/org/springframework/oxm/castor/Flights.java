package org.springframework.oxm.castor;

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.exolab.castor.xml.Validator;
import org.xml.sax.ContentHandler;

public class Flights implements Serializable {
	private List<Flight> flightList;

	public Flights() {
		this.flightList = new ArrayList();
	}

	public void addFlight(Flight vFlight) throws IndexOutOfBoundsException {
		this.flightList.add(vFlight);
	}

	public void addFlight(int index, Flight vFlight) throws IndexOutOfBoundsException {
		this.flightList.add(index, vFlight);
	}

	public Enumeration<? extends Flight> enumerateFlight() {
		return Collections.enumeration(this.flightList);
	}

	public Flight getFlight(int index) throws IndexOutOfBoundsException {
		if ((index < 0) || (index >= this.flightList.size())) {
			throw new IndexOutOfBoundsException("getFlight: Index value '" + index
					+ "' not in range [0.." + (this.flightList.size() - 1) + "]");
		}

		return this.flightList.get(index);
	}

	public Flight[] getFlight() {
		Flight[] array = new Flight[0];
		return this.flightList.toArray(array);
	}

	public int getFlightCount() {
		return this.flightList.size();
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

	public Iterator<? extends Flight> iterateFlight() {
		return this.flightList.iterator();
	}

	public void marshal(Writer out) throws MarshalException, ValidationException {
		Marshaller.marshal(this, out);
	}

	public void marshal(ContentHandler handler)
			throws IOException, MarshalException, ValidationException {
		Marshaller.marshal(this, handler);
	}

	public void removeAllFlight() {
		this.flightList.clear();
	}

	public boolean removeFlight(Flight vFlight) {
		boolean removed = this.flightList.remove(vFlight);
		return removed;
	}

	public Flight removeFlightAt(int index) {
		Object obj = this.flightList.remove(index);
		return (Flight) obj;
	}

	public void setFlight(int index, Flight vFlight) throws IndexOutOfBoundsException {
		if ((index < 0) || (index >= this.flightList.size())) {
			throw new IndexOutOfBoundsException("setFlight: Index value '" + index
					+ "' not in range [0.." + (this.flightList.size() - 1) + "]");
		}

		this.flightList.set(index, vFlight);
	}

	public void setFlight(Flight[] vFlightArray) {
		this.flightList.clear();

		for (int i = 0; i < vFlightArray.length; i++) {
			this.flightList.add(vFlightArray[i]);
		}
	}

	public static Flights unmarshal(Reader reader)
			throws MarshalException, ValidationException {
		return (Flights) Unmarshaller.unmarshal(Flights.class, reader);
	}

	public void validate() throws ValidationException {
		Validator validator = new Validator();
		validator.validate(this);
	}
}