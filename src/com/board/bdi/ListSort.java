package com.board.bdi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

interface TestInter {
	void test();
}

/*
 * class HumanComparator implements Comparator<Human>{
 * 
 * public int compare(Human o1, Human o2) { int fAge = o1.getfAge(); int Age =
 * o2.getAge(); if(fAge <! Age) { return 1; } return 0; }
 * 
 * }
 */
public class ListSort {
	public static void main(String[] args) {
		List<TestInter> tiList = new ArrayList<>();
		tiList.add(new TestInter() {
			public void test() {
				System.out.println("a");
			}
		});
	}

}
