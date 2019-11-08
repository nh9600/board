package com.board.bdi.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListTest {
	public static void main(String[]args) {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(5);
		list.add(1);
		list.add(9);
		list.add(2);
		
		Collections.sort(list);//d
		System.out.println(list);
		

			
			 for(int i=0;i<list.size();i++) { 
				 for(int j=i+1;j<list.size();j++) {
			 if(list.get(i)<list.get(j)) { 
				 Integer tmp = list.get(i);
			 list.set(i,list.get(j));
			 list.set(j,tmp); } } }
			 

		System.out.println(list);

		
		int[] nums = new int[5];
		nums[0] = 10;
		nums[1] = 5;
		nums[2] = 1;
		nums[3] = 9;
		nums[4] = 2;
		
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]<nums[j]) {
					int tmp = nums[i];
					nums[i]=nums[j];
					nums[j]=tmp;
				}
			}

		}
		for(int i=0;i<nums.length;i++) {
		//	System.out.println(nums[i]);
		}
		}

}
