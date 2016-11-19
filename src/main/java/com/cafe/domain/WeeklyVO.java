package com.cafe.domain;

<<<<<<< HEAD
import com.cafe.flags.WeekFlag;
=======
import com.cafe.flag.DateFlag;
import com.cafe.flag.WeeklyFlag;
>>>>>>> origin/weekly

/**
 * Value Object for Weekly
 * @author YJH
 * 2016.11.19.Sat
 */
public class WeeklyVO {

	//fields
	private String cafeName;
	private String menuName;
<<<<<<< HEAD
	private WeekFlag wFlag;
	private String dateFlag;
=======
	private	WeeklyFlag wFlag;
	private DateFlag dateFlag;
>>>>>>> origin/weekly
	
	/* getter, setter methods */
	public String getCafeName() {
		return cafeName;
	}

	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getwFlag() {
		return wFlag.getNum();
	}

	public void setwFlag(WeeklyFlag wFlag) {
		this.wFlag = wFlag;
	}

	public int getDateFlag() {
		return dateFlag.getNum();
	}

	public void setDateFlag(DateFlag dateFlag) {
		this.dateFlag = dateFlag;
	}
	
	@Override
	public String toString() {
		return "WeeklyVO [cafeName=" + cafeName + ", menuName=" + menuName + ", wFlag=" + wFlag + ", dateFlag="
				+ dateFlag + "]";
	}

}
