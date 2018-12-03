/**
 *  基本課題2.1 Day
 *  Task21に使用
 */

import java.lang.Math;

public class Day {	
	public int year;
	public int month;
	public int date;
	
	public int getYear() {		
		return this.year;	// 年を取得する
	}
	
	public void setYear(int year) {
		this.year = year;	//	年を設定する
	}
	
	public int getMonth() {	
		return this.month;	//	月を取得する
	}
	
	public void setMonth(int month) {
		this.month = month;	// 月を設定する
	}
	
	public int getDate() {	
		return this.date;	// 日にちを取得する
	}
	
	public void setDate(int date) {
		this.date = date;	// 日にちを設定する
	}
	
	public String getDayOfWeek() {
		int dayNumber = (getYear() + Math.floorDiv(getYear(), 4) - Math.floorDiv(getYear(), 100)
						+ Math.floorDiv(getYear(), 400) + Math.floorDiv((13 * getMonth() + 8), 5) + getDate()) % 7;
		// 日にちの番号ツェラーの公式を用いて計算する
		String[] day = {"日", "月", "火", "水", "木", "金", "土"};
		return day[dayNumber] + "曜日";	// 曜日を取得する
	}
	
	public String toString() {
		String str = String.format("%d年%2d月%2d日は%sです.", getYear(), getMonth(), getDate(), getDayOfWeek());
		return str;	//	年月日を取得する
	}
}
