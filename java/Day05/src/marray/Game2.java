package marray;

import java.util.*;

public class Game2 {

	public static void main(String[] args) {
		//3 * 3
		
//		(requirement)
//		0. 번갈아 가면서 숫자를 말해서 삼목을 둔다. 한줄을 완성하는 사람이 이긴다.
//		1. 3 * 3에서 진행
//		2. 순서는 번갈아가면서 입력
//		3. 중복 위치 불가
//		4. 비겼을 때 다시 실행(숫자판 다 차도 승부가 안나면 무승부)
//		5. player 1 은 "o" player2 는 "x" 로 진행
//		6. 시작 순서는 주사위를 돌려 숫자가 큰사람이 먼저
//		7. 게임 도중 "q" 를 누르면 항복으로 패배

//		(requirement)
//		- 사용자가 원하는 5 x 5 크기의 브루마블 판을 생성 
//		0. 동시에 시작점에서 시작한다.
//		1. 순서대로 주사위를 던져 나오는 숫자 만큼 이동
//		2. 1칸 앞으로 이동, 1칸 뒤로 이동, 시작의 대각선 끝에는 무인도 생성(한턴 쉬기), 14위가 걸리면 6으로 다시 이동, 나머지는 그냥위치 
//		3. 총 3번을 다 돌면 승리
//		4. 중복 위치시 나란히 표기
//		5. player 1 , player2 순서대로 주사위를 굴린다
//		6. 시작 순서는 주사위를 돌려 숫자가 큰사람이 먼저
//		7. 게임 도중 "q" 를 누르면 게임 종료
		
		int Tic[][] = new int[3][3];
		Scanner sc= new Scanner(System.in);

	}

}
