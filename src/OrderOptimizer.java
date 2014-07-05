

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang.time.StopWatch;

public class OrderOptimizer {

	public static void main(String[] args) {
		StopWatch sw = new StopWatch();
		sw.start();
		FileInputStream fstream;
		int keySize = args.length - 1;
		int counter = 0;
		String restId = null;
		float mprice = Float.MAX_VALUE;
		if(keySize < 2){
			System.out.println("null");
			return;
		}
		try {
			fstream = new FileInputStream(new File(args[0]));
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			while ((strLine = br.readLine()) != null)   {
				counter = 0;
				for(int i = 1; i < keySize + 1; i ++){
					if(strLine.contains(args[i].trim())){
						counter++;
					}
				}
				if(counter == keySize){
					//System.out.println("Line :"+strLine);
					String[] words = strLine.split(",");
					float tprice = Float.parseFloat(words[1].trim());
					if(tprice < mprice){
						mprice = tprice;
						restId = words[0].trim();
						
					}
				}
				
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(restId == null){
			System.out.println("null");
		}else{
			System.out.println(restId + " " + mprice);
		}
		sw.stop();
		System.out.println("Time :: "+sw.toString());
	}
}