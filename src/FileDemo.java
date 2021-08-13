import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileDemo {

	public FileDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			String fileName = "book";
			String fileExtension= ".pdf";
			
			FileInputStream fin = new FileInputStream(new File("d:/"+fileName+fileExtension));
			FileOutputStream fout = new FileOutputStream(new File("d:/"+fileName+"_copy"+fileExtension));
			
			int b =0;
			long startTime = System.currentTimeMillis();
			System.out.println("File Size is " + fin.available() + " bytes");
			byte byteFileArray[] = new byte[100000];
			while((fin.read(byteFileArray)) != -1) {
				fout.write(byteFileArray);
			}
			fin.close();
			fout.close();
			System.out.println("Time taken for FileInpuStream & FileOuputStream  is " + ((System.currentTimeMillis()-startTime)) + " milli seconds");
			
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(new File("d:/"+fileName+fileExtension)));
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(new File("d:/"+fileName+"_buff_copy"+fileExtension)));
			byte byteArray[] = new byte[100000];
			startTime = System.currentTimeMillis();
			
			while((bin.read(byteArray))!= -1) {
				bout.write(byteArray);
			}
			bin.close();
			bout.close();
			System.out.println("Time taken for BuffereInpuStream & BufferedOuputStream  is " + ((System.currentTimeMillis()-startTime)) + " milli seconds");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
