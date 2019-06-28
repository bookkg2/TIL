package vo;

import java.util.Date;

public class Products {
	int PdNo;
	String PdName;
	String PdsUBName;
	String FactNo;
	Date PdDate;
	int PdCost;
	int PdPrice;
	int PdAmount;
	public Products(int pdNo, String pdName, String pdsUBName, String factNo, Date pdDate, int pdCost, int pdPrice,
			int pdAmount) {
		PdNo = pdNo;
		PdName = pdName;
		PdsUBName = pdsUBName;
		FactNo = factNo;
		PdDate = pdDate;
		PdCost = pdCost;
		PdPrice = pdPrice;
		PdAmount = pdAmount;
	}
	public int getPdNo() {
		return PdNo;
	}
	public void setPdNo(int pdNo) {
		PdNo = pdNo;
	}
	public String getPdName() {
		return PdName;
	}
	public void setPdName(String pdName) {
		PdName = pdName;
	}
	public String getPdsUBName() {
		return PdsUBName;
	}
	public void setPdsUBName(String pdsUBName) {
		PdsUBName = pdsUBName;
	}
	public String getFactNo() {
		return FactNo;
	}
	public void setFactNo(String factNo) {
		FactNo = factNo;
	}
	public Date getPdDate() {
		return PdDate;
	}
	public void setPdDate(Date pdDate) {
		PdDate = pdDate;
	}
	public int getPdCost() {
		return PdCost;
	}
	public void setPdCost(int pdCost) {
		PdCost = pdCost;
	}
	public int getPdPrice() {
		return PdPrice;
	}
	public void setPdPrice(int pdPrice) {
		PdPrice = pdPrice;
	}
	public int getPdAmount() {
		return PdAmount;
	}
	public void setPdAmount(int pdAmount) {
		PdAmount = pdAmount;
	}
	@Override
	public String toString() {
		return "Products [PdNo=" + PdNo + ", PdName=" + PdName + ", PdsUBName=" + PdsUBName + ", FactNo=" + FactNo
				+ ", PdDate=" + PdDate + ", PdCost=" + PdCost + ", PdPrice=" + PdPrice + ", PdAmount=" + PdAmount + "]";
	}
}
