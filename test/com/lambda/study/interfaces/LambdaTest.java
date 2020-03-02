package com.lambda.study.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lambda.study.entity.HasTwoMethod;
import com.lambda.study.entity.Item;

public class LambdaTest {
	@Test
	public void testLambdaForInterface() {
		NoParamNoReturn noParamNoReturn = () -> {System.out.println("noParamNoReturn");};
		noParamNoReturn.method();
		
		OneParamNoReturn oneParamNoReturn = (int a) -> {System.out.println("OneParamNoReturn:" + a);};
		oneParamNoReturn.method(3);
		
		MoreParamNoReturn moreParamNoReturn = (int a, int b) -> {System.out.println("moreParamNoReturn:" + a + ", " + b);};
		moreParamNoReturn.method(2, 3);
		
		NoParamHasReturn noParamHasReturn = () -> {return 0;};
		System.out.println("noParamHasReturn: " + noParamHasReturn.method());
		
		OneParamHasReturn oneParamHasReturn = (int a) -> {return a;};
		System.out.println("oneParamHasReturn: " + oneParamHasReturn.method(4));
		
		MoreParamHasReturn moreParamHasReturn = (int a, int b) -> {return a + b;};
		System.out.println("moreParamHasReturn: " + moreParamHasReturn.method(5, 6));
	}
	
	@Test
	public void testSimpleLambdaForInterface() {
		NoParamNoReturn noParamNoReturn = () -> System.out.println("noParamNoReturn");
		noParamNoReturn.method();
		
		OneParamNoReturn oneParamNoReturn = (a) -> System.out.println("OneParamNoReturn:" + a);
		oneParamNoReturn.method(3);
		
		MoreParamNoReturn moreParamNoReturn = (a, b) -> System.out.println("moreParamNoReturn:" + a + ", " + b);
		moreParamNoReturn.method(2, 3);
		
		NoParamHasReturn noParamHasReturn = () -> 0;
		System.out.println("noParamHasReturn: " + noParamHasReturn.method());
		
		OneParamHasReturn oneParamHasReturn = (a) -> a;
		System.out.println("oneParamHasReturn: " + oneParamHasReturn.method(4));
		
		MoreParamHasReturn moreParamHasReturn = (a, b) -> a + b;
		System.out.println("moreParamHasReturn: " + moreParamHasReturn.method(5, 6));
	}
	
	@Test
	public void testLambdaUsingClassMethod() {
		HasTwoMethod hasTwoMethod = new HasTwoMethod();
		OneParamHasReturn oneParamHasReturn3 = HasTwoMethod::doubleNum;
		System.out.println(oneParamHasReturn3.method(4));
		
		OneParamHasReturn oneParamHasReturn4 = hasTwoMethod::addTwo;
		System.out.println(oneParamHasReturn4.method(4));
	}
	
	@Test
	public void testLambdaUsingConstructor() {
		ItemCreatorUsingNoParam noParam = Item::new;
		System.out.println(noParam.getItem());
		
		ItemCreatorUsingWithParam withParam = Item::new;
		System.out.println(withParam.getItem(2, "zhaojiahong"));
	}
	
	@Test
	public void testIteratorForList() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(1, "item1"));
		items.add(new Item(2, "item2"));
		items.add(new Item(3, "item3"));
		items.add(new Item(4, "item4"));
		items.add(new Item(5, "item5"));
		items.add(new Item(6, "item6"));
		items.add(new Item(7, "item7"));
		items.add(new Item(8, "item8"));
		items.add(new Item(9, "item9"));
		items.add(new Item(10, "item10"));
		
		items.forEach(System.out::println);
		items.forEach(ele -> {
			System.out.println(ele);
		});
	}
	
	@Test
	public void testRemoveEleFromList() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(1, "item1"));
		items.add(new Item(2, "item2"));
		items.add(new Item(3, "item3"));
		items.add(new Item(4, "item4"));
		items.add(new Item(5, "item5"));
		items.add(new Item(6, "item6"));
		items.add(new Item(7, "item7"));
		items.add(new Item(8, "item8"));
		items.add(new Item(9, "item9"));
		items.add(new Item(10, "item10"));
		System.out.println("===========================");
		items.removeIf(ele -> ele.getId() % 2 == 0);
		items.forEach(ele -> {
			System.out.println(ele);
		});
	}
	
	@Test
	public void testCompareEleInList() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(10, "item10"));
		items.add(new Item(1, "item1"));
		items.add(new Item(7, "item7"));
		items.add(new Item(2, "item2"));
		items.add(new Item(9, "item9"));
		items.add(new Item(5, "item5"));
		items.add(new Item(6, "item6"));
		items.add(new Item(3, "item3"));
		items.add(new Item(4, "item4"));
		items.add(new Item(8, "item8"));
		
		System.out.println("===========================");
		items.sort((o1, o2) -> o1.getId() - o2.getId());
		items.forEach(System.out::println);
	}
}
