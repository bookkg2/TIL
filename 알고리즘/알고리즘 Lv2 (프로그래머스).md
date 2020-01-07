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

  

