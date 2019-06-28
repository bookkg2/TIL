package vo;

public class Factory {
	String FactNo ;
	String FactName;
	String FacLoc;
	public Factory(String factNo, String factName, String facLoc) {
		FactNo = factNo;
		FactName = factName;
		FacLoc = facLoc;
	}
	public String getFactNo() {
		return FactNo;
	}
	public void setFactNo(String factNo) {
		FactNo = factNo;
	}
	public String getFactName() {
		return FactName;
	}
	public void setFactName(String factName) {
		FactName = factName;
	}
	public String getFacLoc() {
		return FacLoc;
	}
	public void setFacLoc(String facLoc) {
		FacLoc = facLoc;
	}
	@Override
	public String toString() {
		return "Factory [FactNo=" + FactNo + ", FactName=" + FactName + ", FacLoc=" + FacLoc + "]";
	}
	
}
