- 기능개발

  ```java
  import java.util.ArrayList;
  import java.util.Arrays;
  class Solution {
      public int[] solution(int[] progresses, int[] speeds) {
  	       int[] answer = null;
  	        int[] finishday = new int[progresses.length];
  	        ArrayList<Integer> pro = new ArrayList<>();
  	        
  	        
  	        for(int i =0; i <progresses.length;i++) {
  	        	int mok = (100 - progresses[i]) / speeds[i];
  	        	int nam = (100 - progresses[i]) % speeds[i];
  	        	if(nam == 0) {
  	        		finishday[i] = mok;
  	        	}else {
  	        		finishday[i] = mok+1;
  	        	}
  	        }
  	        	
  	        	
  	       int max = finishday[0];
  	       int cnt = 1;
  	       for(int i =0 ;i < finishday.length-1;i++) {
  	    	   
  	    	   if(max >= finishday[i+1]) {
  	    		   cnt++;
  	    		   
  	    		   
  	    	   }else {
  	    		   pro.add(cnt);
  	    		   max = finishday[i+1];
  	    		   cnt=1;
  	    		   
  	    		   
  	    	   }
  	    	   
  	    	   
  	       }
  	       pro.add(cnt);
  	       answer = new int[pro.size()];
  	       for(int i =0; i < answer.length;i++) {
  	    	   answer[i] = pro.get(i);
  	       }
  	        	
  	        
  	        	
  
  	       
  	        return answer;
  	 }
  }
  ```

  - 풀이 2

  ```java
   static public int[] solution(int[] progresses, int[] speeds) {
        
        int[] prog = progresses.clone();
        int pcnt = progresses.length;
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] end = new boolean[pcnt];
        while (!end[pcnt-1]) {
           int d = 0;
           int idx = 0;
           for (int i = 0; i < pcnt; i++) {
              if (end[i] == false) {
                 idx = i;
                 break;
              }
           }
           
           while (prog[idx] < 100) {
              prog[idx] += speeds[idx];
              for (int j = idx + 1; j < pcnt; j++) {
                 prog[j] += speeds[j];
              }
              
              end[idx] = true;
           }
           
           int cnt = 1;
           for (int i = idx + 1; i < pcnt; i++) {
              if (prog[i] >= 100) {
                 cnt++;
                 
                 end[i] = true;
              }
              else {
                 break;
              }
           }
           list.add(cnt);
        }
        
        int[] answer = new int [list.size()];
        for (int i=0;i<list.size();i++) {
           answer[i]=list.get(i);
        }         
        return answer;
     }
  
  ```

  

