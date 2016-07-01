package com.util;

import java.awt.List;
import java.util.ArrayList;

public class CircularLinkedList{
	private Node header = null;// 头结点
	
	public Node getHeader() {
		return header;
	}

	public void setHeader(Node header) {
		this.header = header;
	}

	/**
	 * 插入链表
	 */
public	void insertList(Integer o) {
		Node e = new Node();
		e.value = o;
		if (header == null)// 第一次插入元素
		{
			header=e;
			//e.next=header;
		} else// 不是第一次插入元素
		{
			// temp引用在栈中，temp和header引用都指向堆中的initList()中new的Node对象
			Node temp = header;
			while (temp.next != null)// 寻找最后一个元素
			{
				temp = temp.next;
			}
			temp.next = e;
		//	e.next = header;// 新插入的最后一个节点指向头结点
		}
	}

	/**
	 * 删除链表中第i个元素
	 */
public	void deletelist(Integer o) {
		Node temp = header;
		if(temp.value==o){//删除的是头结点
			if(size()==1){//只有一条
				return;
			}else{
				//找到尾结点
				Node headerNode = temp.next;
				Node tail=null;
				while(temp.next!=header){
					temp=temp.next;
				}
				tail=temp;
				header=headerNode;
				tail.next=header;
			}
		}else{
			while (temp.next != header) {
				// 判断temp当前指向的结点的下一个结点是否是要删除的结点
				if (temp.next.value==(o)) {
					temp.next = temp.next.next;// 删除结点
					return;
				} else {
					temp = temp.next;// temp“指针”后移
				}
			}
		}
	}

	public Node getNode(Integer value){
		Node temp=header;
		while(temp.next!=header){
			if(temp.value==value || value.equals(temp.value)){
				return temp;
			}
			temp=temp.next;
		}
		if(temp.value==value){
			return temp;
		}
		return null;
	}
	/**
	 * 链表长度
	 */
	public int size() {
		Node temp = header;
		int size = 0;
		while (temp.next != header) {
			size++;
			temp = temp.next;
		}
		return size+1;
	}

	/**
	 * 判断链表中是否存在某元素
	 */
public	Boolean isContain(Integer o) {
		Node temp = header;
		while (temp.next != header) {
			if (temp.next.value==(o)) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	/**
	 * 打印链表
	 */
	public ArrayList print() {
		 if(header==null){
			 return null;
		 }
		 ArrayList<Integer> results = new ArrayList<Integer>();
		Node temp = header;
		results.add(header.value);
		while (temp.next != header) {
			temp = temp.next;
			results.add(temp.value);
		}
		System.out.println(results.toString());
		return results;
	}
	public CircularLinkedList generateQueue(CircularLinkedList instance,Integer start,Integer num){
		CircularLinkedList result=new CircularLinkedList();
	      Node node1 = instance.getNode(start);
	      int count=1;
	      result.insertList(node1.value);
	      while(count<num){
	      	node1=node1.next;
	      	result.insertList(node1.value);
	      	count++;
	      }
	      return result;
	}
}
