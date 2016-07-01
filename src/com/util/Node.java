package com.util;
public class Node {
		public int value;
		public Node next = null;	
		@Override
		public String toString() {			
		return value+".."+next;
		}
}
