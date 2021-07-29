package com.springboot.datastructures;

public class Queue<T> {

	private Node<T> front;
	private Node<T> back;

	public void enqueue(T val) {
		Node<T> node = new Node<T>(val);

		if (this.back != null) {
			this.back.next = node;
			this.back = this.back.next;
		} else {
			this.back = node;
			this.front = node;
			this.front.next = this.back;
		}
	}

	public T dequeue() {
		if (front != null) {
			Node<T> node = this.front;
			this.front = this.front.next;
			return node.val;
		}
		return null;
	}

}
