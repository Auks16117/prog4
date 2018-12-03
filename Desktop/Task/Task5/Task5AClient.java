/**
 * 基本課題5.A Task5AClient
 * クライアント側のプログラム
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Task5AClient {
	public static void main(String[] args) {
		String directoryPass = args[2];

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		// コマンドライン引数から接続先サーバのホスト名またはIPアドレスを取得
		String server = args[0];
		// コマンドライン引数からポート番号を取得
		int port = Integer.parseInt(args[1]);

		Socket socket = null;
		try {
			// ソケットを作成
			socket = new Socket();
			// 指定されたホスト名（IPアドレス）とポート番号でサーバに接続する
			socket.connect(new InetSocketAddress(server, port));
			// 接続されたソケットの入力ストリームを取得し，データ入力ストリームを連結
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			// 接続されたソケットの出力ストリームを取得し，データ出力ストリームを連結
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);

			System.out.print("操作を入力> ");	//	操作を入力する
			Scanner scanner = new Scanner(System.in);
			String fileOperate = scanner.nextLine();

			dos.writeUTF(fileOperate);	//	操作とファイルをサーバに起こる

			String[] fileAndOperation = fileOperate.split("[\\s]");	//	コマンドとファイルを分割する

			int ch;

			if(fileAndOperation[0].equals("list")) {	//	listを選んだ時
				int filesLength = dis.readInt();	//	ファイルの数を取得する
				for(int i = 0; i < filesLength;i++) {
					System.out.println(dis.readUTF());	//	ファイルを表示する
				}
			} else if(fileAndOperation[0].equals("get")) {	//	getを選んだ時
				fos = new FileOutputStream(args[2] + "\\" + fileAndOperation[1]);		// ファイル入力バイトストリーム
				bos = new BufferedOutputStream(fos);	// 出力用バッファ
				System.out.println(args[2] + "\\" + fileAndOperation[1]);
				while((ch = dis.read()) != -1) {	//	ファイルに書き込んでいく
					bos.write(ch);
					bos.flush();
				}


			} else if(fileAndOperation[0].equals("put")) {	// putを選んだ時
				System.out.println(args[2] + "\\" + fileAndOperation[1]);
				// ファイルから1バイトずつ読み込む
				fis = new FileInputStream(args[2] + "\\" + fileAndOperation[1]);
				bis = new BufferedInputStream(fis);		// 入力用バッファ
				while ((ch = bis.read()) != -1) {	//	サーバにファイルの内容を送る
					dos.write(ch);
				}
				dos.flush();
				System.out.println("送信しました");

			}
		} catch (FileNotFoundException e) {
			System.out.println("ファイル" + directoryPass + "が見つかりません．");
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			// ソケットをクローズする
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {}
			}
			//	入力ファイルを閉じる
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {}
			}
			//	出力ファイルを閉じる
			if(bos != null) {
				try {
					bos.close();
				} catch (IOException e) {}
			}
		}
	}
}
