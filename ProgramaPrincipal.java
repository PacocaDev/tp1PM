public class ProgramaPrincipal{

	public static void main(String[] args) {
		
		Building parkingBuilding = new Building(4);
		IOHandler eventReader = new IOHandler();

		//eventReader.openFile();
		
		while(parkingBuilding.eventHandler(eventReader.readInputLine()));

		System.out.println ("terminou arquivo");
		
	}
}

