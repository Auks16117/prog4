/**
 * 基本課題2.3 SmartCard
 * Task23に使用
 */

public class SmartCard {
	int INITIAL_BALANCE = 1000;
	String name;
	String phoneNumber;
	long balance;
	
	public String getName() {	// 名前を取得する
		return this.name;
	}
	
	public void setName(String name) {	// 名前を設定する
		this.name = name;
	}
	
	public String getPhoneNumber() {	// 電話番号を取得する
		return this.phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {	//	電話番号を設定する
		this.phoneNumber = phoneNumber;
	}
	
	public long getBalance() {	// 初期残高を取得する
		return this.balance;
	}
	
	public void setlnitialBalance() {	// 	初期残高を設定する
		this.balance = this.INITIAL_BALANCE;
	}
	
	public long charge(int amount) {	// チャージする
		this.balance += amount;
		return this.balance;
	}
	
	public boolean pay(long amount) {	// 金を払う
		if(amount >= 2000) {	// 2000円以上残高があるとき
			this.balance -= 2000L;	//　2000円を引いておく
			return true;
		}else {	// 残高が足りないとき
			return false;
		}
	}
	
	public String toString() {
		return "所有者氏名:" + getName() + "\n電話番号\t:" + getPhoneNumber() + "\n残高\t:" + getBalance() + "円";
	}
}
