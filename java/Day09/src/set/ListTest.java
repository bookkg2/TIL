package set;

import java.util.ArrayList;
import java.util.Random;

public class ListTest {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Random r= new Random();
		while(true) {
			list.add(r.nextInt(45) +1);
			if(list.size() == 10) {
				break;
			}
		}
		
		for(Integer i: list) {
			System.out.println(i);
		}
		System.out.println(list.toString());// 무작위로 담고 넣는 순서대로 담긴다 . 중복 허용

	}

}
