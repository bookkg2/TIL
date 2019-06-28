package set;

import java.util.HashSet;
import java.util.Random;

public class SetTest {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();// <object> 쓰면 set에 다 들어가게 하기 위하여 
		Random r= new Random();
		while(true) {
			set.add(r.nextInt(45) +1);
			if(set.size() == 6) {
				break;
			}
		}
		System.out.println(set.toString());//중복을 제거 하고 출력
		
	}

}
