package ws;

public class Grade {
	public int sum(int grade[]) {
		int sum2 = 0;
		for (int data : grade) {
			sum2 += data;
		}

		return sum2;
	}

	public double evg(int grade[]) {
		int evg2 = 0;
		int sum = 0;
		for (int data : grade) {
			sum += data;
			evg2 = sum / grade.length;

		}
		return evg2;
	}

	public char score(int grade[]) {
		int score2 = (int) evg(grade);
		if (score2 >= 90) {
			return 'A';
		} else if (score2 < 90 && score2 >= 80) {
			return 'B';
		} else if (score2 < 80 && score2 >= 70) {
			return 'C';
		} else if (score2 < 70 && score2 >= 60) {
			return 'D';
		} else
			return 'F';
	}

	public int highlean(int grade[]) {
		int Max = grade[0];
		for (int i = 0; i < grade.length - 1; i++) {

			for (int j = i + 1; j < grade.length; j++)
				if (grade[i] < grade[j]) {
					int temp = grade[i];
					grade[i] = grade[j];
					grade[j] = temp;
					Max = grade[0];
				}

		}
		return Max;

	}

	public int lowlean(int grade[]) {
		int Min = grade[0];
		for (int i = 0; i < grade.length - 1; i++) {

			for (int j = i + 1; j < grade.length; j++)
				if (grade[i] > grade[j]) {
					int temp = grade[i];
					grade[i] = grade[j];
					grade[j] = temp;
					Min = grade[0];
				}

		}
		return Min;

	}

	public int[] asort(int grade[]) {
		int[] asort2 = new int[grade.length];
		for (int i = 0; i < grade.length - 1; i++) {

			for (int j = i + 1; j < grade.length; j++)
				if (grade[i] < grade[j]) {
					int temp = grade[i];
					grade[i] = grade[j];
					grade[j] = temp;
					
				}

		}
		
		for(int i = 0; i< grade.length; i++) {
			asort2[i] = grade[i];
		}
		return asort2;
	}
	
	public int[] desort(int grade[]) {
		int[] desort2 = new int[grade.length];
		for (int i = 0; i < grade.length - 1; i++) {

			for (int j = i + 1; j < grade.length; j++)
				if (grade[i] > grade[j]) {
					int temp = grade[i];
					grade[i] = grade[j];
					grade[j] = temp;
					
				}

		}
		
		for(int i = 0; i< grade.length; i++) {
			desort2[i] = grade[i];
		}
		return desort2;
	}

}
