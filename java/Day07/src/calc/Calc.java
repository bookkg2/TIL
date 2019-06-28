package calc;

import java.util.Arrays;
import java.util.Collections;

public class Calc {
	private int[] data;

	public Calc() {
	}

	public Calc(int[] data) {//[] 대신 ... 으로도 가능(argument 일때만 !)
		this.data = data;
	}

	// 1. Sum
	public int sum(int data[]) {

		int sum = 0;
		for (int data2 : data) {

			sum += data2;
		}
		return sum;
	}

	public double avg(int data[]) {
		double evg = 0;
		int sum = 0;
		for (int data3 : data) {
			sum += data3;
			evg = sum / data.length;
		}
		return evg;
	}

	// 2. Sort Asc
	public int[] asort(int data[]) {// 배열을 리턴
		int asort2[] = new int[data.length];

		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i] < data[j]) {
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;

				}
				for (int i1 = 0; i1 < data.length; i1++) {
					asort2[i1] = data[i1];
				}
			}

		}
		return asort2;
	}

	// 3. Sort Desc
	public int[] desort(int data[]) {
		int desort2[] = new int[data.length];
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i] > data[j]) {
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;

				}
				for (int i1 = 0; i1 < data.length; i1++) {
					desort2[i1] = data[i1];
				}
			}
			
		}
		return desort2;
	}
}
