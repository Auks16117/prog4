/**
 * 基本課題5.A Task5AServer
 * サーバ側のプログラム
 */
import java.io.*;
import java.net.*;

public class Task5AServer {

	/** 最大接続数（100クライアント） */
	private static final int MAX_CONNECTION = 100;
	private static ServerSocket serverSocket;

	public static void main(String[] args) {
		int port = Integer.parseInt(args[0]);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		bos = new BufferedOutputStream(fos);	// 出力用バッファ

		Socket socket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.setReuseAddress(true);
			// 指定ポート番号にバインド
			serverSocket.bind(new InetSocketAddress(port), MAX_CONNECTION);
			System.out.println("Server listening on port " + port + "...");

			while (true) {
				// クライアントからの接続要求を待機（クライアント接続するまでブロッキング）
				socket = serverSocket.accept();

				// 接続されたソケットの入力ストリームを取得し，データ入力ストリームを連結
				InputStream is = socket.getInputStream();
				DataInputStream dis = new DataInputStream(is);

				// 接続されたソケットの出力ストリームを取得し，データ出力ストリームを連結
				OutputStream os = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);

				// 接続したクライアントの情報を表示
				showClientInformation(socket);

				String fileOperate = dis.readUTF();	//	ファイルと操作を受信する

				String[] fileAndOperation = fileOperate.split("[\\s]");	//	ファイルと操作を分割する

				int ch;

				if(fileAndOperation[0].equals("list")) {	//	listのときの操作
					String path;
			    		if (args.length == 2) {
			    			// コマンドライン引数で指定されたパスを取得
			    			path = args[1];

			    		} else {
			    			// コマンドライン引数で指定が無い場合はカレントディレクトリのパスを取得
			    			path = System.getProperty("user.dir");

			    		}
			    		System.out.println(path);

					// 指定されたディレクトリのインスタンスを生成
					File directory = new File(path);
					// 指定したディレクトリ内に存在するディレトリとファイルの一覧を取得
					File[] files = directory.listFiles();

					dos.writeInt(files.length);
					dos.flush();
					System.out.println(fileAndOperation[0]);

					for (int i = 0; i < files.length; i++) {
						File file = files[i];
						/*
						 * 取得したディレクトリ名とファイル名を出力する．
						 * なお，参照しているインスタンスの種類に応じて"D","F"を表記する．
						 * - isDirectory()メソッドでディレクトリかどうかを判定
						 *   （isFile()メソッドでファイルかどうかを判定してもよい）
						 * - getName()メソッドでディレクトリ名またはファイル名を取得
						 */
						if (file.isDirectory()) {

							dos.writeUTF((i + 1) + ":D: " + file.getName());
						}else {

							dos.writeUTF((i + 1) + ":F: " + file.getName());
						}
					}
					dos.flush();
				}else if(fileAndOperation[0].equals("get")) {	//	getのときの操作
					fis = new FileInputStream(args[1] + "\\" + fileAndOperation[1]);		// ファイル入力バイトストリーム
					bis = new BufferedInputStream(fis);		// 入力用バッファ

					// ファイルから1バイトずつ読み込む
					while ((ch = bis.read()) != -1) {
						dos.writeChar(ch);
					}
					dos.flush();
					System.out.println("書き込みが終わりました");
				}else if(fileAndOperation[0].equals("put")) {	//	putのときの操作
					fos = new FileOutputStream(args[1] + "\\" + fileAndOperation[1]);
					bos = new BufferedOutputStream(fos);
					System.out.println(args[1] + "\\" + fileAndOperation[1]);
					while((ch = dis.read()) != -1) {	//	ファイルの内容を送信する
						bos.write(ch);
						bos.flush();
					}

					System.out.println("送信完了");
				}else {
					System.out.println("指定された操作以外です!");
					System.exit(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ソケットをクローズする
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {}
			}
			//	入力用ファイルを閉じる
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {}
			}
			//	出力用ファイルを閉じる
			if(bos != null) {
				try {
					bos.close();
				} catch (IOException e) {}
			}
		}
	}

	private static void showClientInformation(Socket socket) throws IOException {
		// クライアントのIPアドレスを取得
		InetAddress address = socket.getInetAddress();
		// クライアントのポート番号を取得
		int port = socket.getPort();

		System.out.println("クライアント[" + address.toString() + ":" + port + "] が接続しました．");
	}
}
