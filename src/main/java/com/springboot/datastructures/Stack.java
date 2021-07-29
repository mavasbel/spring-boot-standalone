package com.springboot.datastructures;

public class Stack<T> {

	private Node<T> top;

	public void push(T val) {
		Node<T> newTop = new Node<T>(val);
		if (this.top != null)
			newTop.next = this.top;
		this.top = newTop;
	}

	public T pop() {
		if (this.top != null) {
			Node<T> node = this.top;
			this.top = this.top.next;
			return node.val;
		}
		return null;
	}

}
