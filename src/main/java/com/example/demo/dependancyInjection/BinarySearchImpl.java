package com.example.demo.dependancyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
/*@Scope("prototype")
 * one type to change bean scope 
 *   by default bean scope is singleton
 * */
/*@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
 * Using ConfigurableBeanFactory 
 * 
 * */
public class BinarySearchImpl {
	//create an instance
	// to tell this is dependancy to be created
	@Autowired
	/*Autowiring by type
	*SortAlgorithm bubbleSortAlgorithm;
	*SortAlgorithm quickSortAlgorithm;
	*/
	/*Autowiring using @Primary
	 * add @Primary to class which you want to depenndancy
	 */
	/*Autowiring using @Qualifier on each bean and name 
	 * using name we can ijact
	 * @Qualifier("quick")
	 * */
	@Qualifier("bubble")
	SortAlgorithm sortAlgorithm;



public int binarySearch(int[] numbers,int searchElement) {
	//implementing sorting logic 
	
	//BubbleSortAlgorithm bubbleSortAlgorithm=new BubbleSortAlgorithm();
	//int [] bubbleSortedNumbers=sortAlgorithm.sort(numbers);
	//QuickSortAlgorithm quickSortAlgorithm=new QuickSortAlgorithm();
	int [] quickSortedNumbers=sortAlgorithm.sort(numbers);
	System.out.println(sortAlgorithm);
	//when want to use bubble sort
	//when want to use quick sort
	//returning search result
	
	return 8;
}
}
