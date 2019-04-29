package com.test;

public class Pqr extends Xyz {
	
	public void demo(){
		System.out.println("Child2 class");
	}
	
public static void main( String args[]){
		
		Abc obj1 = new Abc();
		Abc obj2 = new Xyz();
		Abc obj3 = new Pqr();
		

		Xyz obj4 = new Xyz();
		Xyz obj5 = new Pqr();
		
	
		Pqr obj6 = new Pqr();
	
		obj1.demo();
		obj2.demo();
		obj3.demo();
		obj4.demo();
		obj5.demo();
		obj6.demo();
		
	}

}
