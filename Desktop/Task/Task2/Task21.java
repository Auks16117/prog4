/**
 *  基本課題2.1 Task21
 *  指定した日付の曜日を表示するプログラム
 */
import java.util.Scanner;

public class Task21 {
	public static void main(String[] args) {
		
		for(int i = 0; i < 2;i++) { // 2回繰り返す
			System.out.print("年　月　日を入力してください>");
			
			Day day = new Day();
			Scanner scanner = new Scanner(System.in);			
			day.setYear(scanner.nextInt());	// 年を入力する
			day.setMonth(scanner.nextInt());	// 月を入力する
			day.setDate(scanner.nextInt());	// 日を入力する
			
			System.out.println(day.toString());
		}
	}	
}
