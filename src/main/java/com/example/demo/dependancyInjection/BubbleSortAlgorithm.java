package com.example.demo.dependancyInjection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bubble")
public class BubbleSortAlgorithm  implements SortAlgorithm{

	@Override
	public int[] sort(int[] numbers) {
		//sorting logic
		return numbers;
	}
	
}
