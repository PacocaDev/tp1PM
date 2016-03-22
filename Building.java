public class Building{
	//Levels[] levels = new Level[4];

	public void eventHandler(String info){
		String[] attributes = info.split(";");
		System.out.println (attributes[0]);
		System.out.println (attributes[1]);
		System.out.println (attributes[2]);
		System.out.println (attributes[3]);
		
		
	}
}