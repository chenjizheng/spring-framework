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

public class Order implements Serializable {
	private List<OrderItem> orderItemList;

	public Order() {
		this.orderItemList = new ArrayList();
	}

	public void addOrderItem(OrderItem vOrderItem) throws IndexOutOfBoundsException {
		this.orderItemList.add(vOrderItem);
	}

	public void addOrderItem(int index, OrderItem vOrderItem)
			throws IndexOutOfBoundsException {
		this.orderItemList.add(index, vOrderItem);
	}

	public Enumeration<? extends OrderItem> enumerateOrderItem() {
		return Collections.enumeration(this.orderItemList);
	}

	public OrderItem getOrderItem(int index) throws IndexOutOfBoundsException {
		if ((index < 0) || (index >= this.orderItemList.size())) {
			throw new IndexOutOfBoundsException("getOrderItem: Index value '" + index
					+ "' not in range [0.." + (this.orderItemList.size() - 1) + "]");
		}

		return (OrderItem) this.orderItemList.get(index);
	}

	public OrderItem[] getOrderItem() {
		OrderItem[] array = new OrderItem[0];
		return (OrderItem[]) this.orderItemList.toArray(array);
	}

	public int getOrderItemCount() {
		return this.orderItemList.size();
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

	public Iterator<? extends OrderItem> iterateOrderItem() {
		return this.orderItemList.iterator();
	}

	public void marshal(Writer out) throws MarshalException, ValidationException {
		Marshaller.marshal(this, out);
	}

	public void marshal(ContentHandler handler)
			throws IOException, MarshalException, ValidationException {
		Marshaller.marshal(this, handler);
	}

	public void removeAllOrderItem() {
		this.orderItemList.clear();
	}

	public boolean removeOrderItem(OrderItem vOrderItem) {
		boolean removed = this.orderItemList.remove(vOrderItem);
		return removed;
	}

	public OrderItem removeOrderItemAt(int index) {
		Object obj = this.orderItemList.remove(index);
		return (OrderItem) obj;
	}

	public void setOrderItem(int index, OrderItem vOrderItem)
			throws IndexOutOfBoundsException {
		if ((index < 0) || (index >= this.orderItemList.size())) {
			throw new IndexOutOfBoundsException("setOrderItem: Index value '" + index
					+ "' not in range [0.." + (this.orderItemList.size() - 1) + "]");
		}

		this.orderItemList.set(index, vOrderItem);
	}

	public void setOrderItem(OrderItem[] vOrderItemArray) {
		this.orderItemList.clear();

		for (int i = 0; i < vOrderItemArray.length; i++) {
			this.orderItemList.add(vOrderItemArray[i]);
		}
	}

	public static Order unmarshal(Reader reader)
			throws MarshalException, ValidationException {
		return (Order) Unmarshaller.unmarshal(Order.class, reader);
	}

	public void validate() throws ValidationException {
		Validator validator = new Validator();
		validator.validate(this);
	}
}