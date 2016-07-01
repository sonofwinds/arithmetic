package com.util;

import java.util.HashMap;
import java.util.Map;

public class MergeNode {
	public static  Node merge(Node node1,Node node2){
		if(node1==null){
			return node2;
		}
		if(node2==null){
			return node1;
		}
		Node temp;
		if(node1.value<=node2.value){
			temp=node1;
			temp.next = merge(node1.next,node2);
		}else{
			temp=node2;
			temp.next = merge(node2.next,node1);
		}
		return temp;
	}
	public static void main(String[] args) {
		CircularLinkedList list1=new CircularLinkedList();
		list1.insertList(3);
		list1.insertList(7);
		list1.insertList(13);
		CircularLinkedList list2=new CircularLinkedList();
		list2.insertList(1);
		list2.insertList(8);
		list2.insertList(90);
		Node node = merge(list1.getHeader(),list2.getHeader());
		System.out.println(node.toString());
	}

}
