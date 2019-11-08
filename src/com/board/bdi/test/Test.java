package com.board.bdi.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Human{
	private int age;
	private int height;
	
	public Human(int age, int height) {
		super();
		this.age = age;
		this.height = height;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Human [age=" + age + ", height=" + height + "]";
	}

}

class Compare<T> implements Comparator<T>{//<T>타입이 들어갈 자리

	@Override
	public int compare(T o1, T o2) {
		Human h1 = (Human)o1;
		Human h2 = (Human)o2;
		if(h1.getAge()<h2.getAge()) {
			return 1;
		}
		if(h1.getAge()>h2.getAge()) {
			return -1;
		}
		return 0;
	}
	
}

public class Test {
	public static void main(String[]args) {
		List<Human> hList = new ArrayList<>();
		hList.add(new Human(3,100));
		hList.add(new Human(2,200));
		hList.add(new Human(4,300));
		hList.add(new Human(5,400));
		hList.add(new Human(1,500));
		Collections.sort(hList,new Compare<Human>());
		System.out.println(hList);

	}
	
}

/*
 * for(int i=1;i<hList.size();i++) { for(int j=i+1;j<hList.size();j++) {
 * if(hList.get(i).getHeight() > hList.get(j).getHeight()) { Human tmp =
 * hList.get(i); hList.set(i,hList.get(j)); hList.set(j, tmp);
 * 
 * 
 * } } }
 */
