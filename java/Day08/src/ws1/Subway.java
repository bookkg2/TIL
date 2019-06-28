package ws1;

public class Subway extends Transportation


 {
	 public Subway() {
	        
	    }
	    
	    public Subway(Factor factor) {
	        super(factor);
	    }
	 
	    @Override
	    public double calcFare() {
	        int fare = 0;
	        fare = factor.getDistance() * 5+1200;
	        return fare;
	    }
	 
	    @Override
	    public int calcTime() {
	        int t =0;
	        t = factor.getDistance()/factor.getVelocity();        
	        return t;
	    }
	 
	    @Override
	    public String toString() {
	        return "Subway [calcFare()=" + calcFare() + ", calcTime()=" + calcTime() + "]";
	    }





}
