import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Compress {

	public static void main(String[] args) {
		Path dir=Paths.get("Blocks"+File.separator+"compressed"+File.separator);
		try {
			Files.createDirectory(dir);
		} catch (Exception e3) {
			// TODO 自動生成された catch ブロック
			e3.printStackTrace();
		}
		boolean shuryo=false;
		// TODO 自動生成されたメソッド・スタブ
		for(int a=1;!shuryo;a++) {
			File block0=new File("Blocks"+File.separator+"compressed"+File.separator+"Block-"+a);
			try {
				block0.createNewFile();
			} catch (IOException e2) {
				// TODO 自動生成された catch ブロック
				e2.printStackTrace();
			}
			FileWriter fw = null;
			try {
				fw=new FileWriter(block0);
			} catch (IOException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			for(int i=1;i<=10000;i++) {
				File file=new File("Blocks"+File.separator+"Block-"+(i+((a-1)*10000)));
				if(file.exists()) {
					FileReader is=null;
					BufferedReader bs=null;
					try {
						is=new FileReader(file);
						bs=new BufferedReader(is);
						fw.write(bs.readLine()+System.getProperty("line.separator"));
					}catch(Exception e) {e.printStackTrace();}
				}else {
					shuryo=true;
					break;
				}
			}
			try {
				fw.close();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}

}
