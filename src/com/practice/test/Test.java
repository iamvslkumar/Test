package com.practice.test;

//A simple enum example where enum is declared
//outside any class (Note enum keyword instead of
//class keyword)
enum Color
{
 RED, GREEN, BLUE;
}
public class Test {

	public static void main(String[] args){
		
		
		Color c1 = Color.BLUE;
        System.out.println(c1);
	}
}
