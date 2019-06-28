package marray;

public class Marr4 {

	public static void main(String[] args) {
		String sa[][] = new String[2][3];
		
		for(int i = 0 ; i<sa.length;i++) {
			for(int j = 0; j<sa[i].length;j++) {
				sa[i][j] = i+""+j;//""로 자동으로 String 됨
			}
		}
		for(String temp[]:sa) {
			for(String data : temp) {
				System.out.printf("%S\t" , data);
			}
			System.out.println();
		}

	}

}
