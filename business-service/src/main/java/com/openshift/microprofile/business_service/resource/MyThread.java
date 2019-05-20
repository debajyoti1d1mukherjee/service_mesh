package com.openshift.microprofile.business_service.resource;

public class MyThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Start==>>" + System.currentTimeMillis());
		 for (long i = 0; i < 1000000; i++) {
		 double d = Math.tan(Math.atan(Math.tan(
		 Math.atan(Math.tan(Math.atan(Math.tan(Math.atan(Math.tan(Math.atan(123456789.123456789))))))))));
		 Math.cbrt(d);
		
		 for (long j = 0; j < 100000; j++) {
		 double d1 = Math.tan(Math.atan(Math.tan(Math
		 .atan(Math.tan(Math.atan(Math.tan(Math.atan(Math.tan(Math.atan(123456789.123456789))))))))));
		 Math.cbrt(d1);
		
		 }
		
		 }
		
		
		 System.out.println("End==>>" + System.currentTimeMillis());
		int numbers[] =new int[1000]; ;
		int position = 0;

		for (int i = 1000; i > 0; i--) {
			numbers[position++] = i;
		}
		bubbleSort(numbers, 100000);

	}

	public static void bubbleSort(int numbers[], int array_size) {
		int i, j, temp;
		System.out.println("Hi");
		for (i = (array_size - 1); i >= 0; i--) {
			System.out.println("i=" + i);
			for (j = 1; j <= i; j++) {
				System.out.println("j=" + j);
				if (numbers[j - 1] > numbers[j]) {
					temp = numbers[j - 1];
					numbers[j - 1] = numbers[j];
					numbers[j] = temp;
				}
				System.out.println(numbers);
			}
		}
	}
	

}
