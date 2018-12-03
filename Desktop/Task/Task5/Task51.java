/**
 * 基本課題5.1 Task51
 * CSVファイルを読み込み，コマンドライン引数で指定した年・月のデータのみを
 * 別ファイルに保存するプログラム
 */
import java.io.*;

public class Task51 {

	/**
	 * @param args 読み込むテキストファイル名
	 */
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		int year = Integer.parseInt(args[1]);
		int month = Integer.parseInt(args[2]);
		String[] inputFileName;
		String outputFileName;
		try {
			fr = new FileReader(args[0]);	// ファイル入力文字ストリーム
			br = new BufferedReader(fr);	// 入力用バッファ
			inputFileName = args[0].split("\\.");	//	.csvを抜いた名前を取得する
			outputFileName = inputFileName[0] + "_" + args[1] + "-" + args[2] + ".csv";	//	出力ファイル名を取得する
			fw = new FileWriter(outputFileName);
			bw = new BufferedWriter(fw);
			String str;
			WeatherData[] weatherData = new WeatherData[31];
			int weatherDataNumber = 0;
			// ファイルからまとめて入力用バッファ読み込み，入力用バッファから1行読み込み
			str = br.readLine();
			bw.write(str + "\n");
			while ((str = br.readLine()) != null) {
				String[] data = str.split("[,/]");	// コンマとスラッシュで区切る

				if(year == Integer.parseInt(data[0]) && month == Integer.parseInt(data[1])) {	//	年と月が一致しているか確かめる
					weatherData[weatherDataNumber] = new WeatherData(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), Double.parseDouble(data[3]),
							Double.parseDouble(data[4]), Double.parseDouble(data[5]), Double.parseDouble(data[6]), Double.parseDouble(data[7]));
					bw.write(weatherData[weatherDataNumber].toString() + "\n");	//	データを書き込む
					weatherDataNumber++;
				}
			}
			bw.flush();	//	ファイルに書き込む
			System.out.println(args[1] + "年" + args[2] + "月の気象データを" + outputFileName + "に抽出しました．");
			WeatherData.showMonthlySummary();
			//	月間の最高気温，最低気温，降水量合計，日照時間合計
		} catch (FileNotFoundException e) {
			System.out.println("ファイル" + args[0] + "が見つかりません．");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {}
			}
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e){}
			}
		}
	}
}
