/**
 * 基本課題5.2 Task52
 * コマンドライン引数で読み込んだPNG画像ファイルの幅と高さを表示するプログラム
 */
import java.io.*;

public class Task52 {
	public static void main(String[] args) {
		final byte[] PNG_SIGNATURE = {(byte)0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A};

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;

		try {
			fis = new FileInputStream(args[0]);
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);

			for(int i = 0;i < 8;i++) {
				if(PNG_SIGNATURE[i] != dis.readByte()) {	//	ズレていたとき，終了する
					System.out.println("PNG画像ファイルではありません!");
					System.exit(1);
				}
			}
			for(int i = 0;i < 8;i++) {
				dis.readByte();
			}
			int width = dis.readInt();	//	幅と高さを取得する
			int height = dis.readInt();
			System.out.println("Width = " + width + " pixel, Heigth = " + height + " pixel");
		}catch(IOException e){
			System.out.println("エラーです．システムを終了します．");
		}
	}
}
