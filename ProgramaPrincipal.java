
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProgramaPrincipal{

	public static void main(String[] args) {
		try{
			FileInputStream fstream = new FileInputStream("entrada.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine;
			Building parkingBuilding = new Building();	

			while ((strLine = br.readLine()) != null)   {
		 		//FAZER COISAS
		 		
		 		

		  		System.out.println (strLine);
		  		parkingBuilding.eventHandler(strLine);
			}
			br.close();
		} catch (IOException e){
			//TODO
		}
	}
}

