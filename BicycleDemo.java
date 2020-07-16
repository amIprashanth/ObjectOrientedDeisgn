package learnDesign;
import java.util.Arrays;
import java.util.HashMap;

class Bicycle{
	public String size;
	private Parts parts;
	public Bicycle(String size, Parts parts){
		this.size = size;
		this.parts = parts;
	}

	public HashMap<String, String> getSpares(){
		return parts.getSpares();
	}
}

class Parts{
	private Part[] parts;

	public Parts(Part[] parts){
		this.parts = parts;
	}

	public HashMap<String, String> getSpares(){
		HashMap<String, String> newMap = new HashMap<> ();
		for(Part pt: parts){
			if(pt.needsSpare) newMap.put(pt.name, pt.description);
		}
		return newMap;
	}
}

class Part{
	public String name;
	public String description;
	public boolean needsSpare;

	public Part(String name, String description, boolean needsSpare){
		this.name = name;
		this.description= description;
		this.needsSpare = needsSpare;
	}
}

public class BicycleDemo{
	public static void main(String[] args){
		Part chain = new Part("chain", "10-speed", true);
		Part roadTire = new Part("tireSize", "23", true);
		Part tape = new Part("tapeColor", "red", true);
		Part mountainTire = new Part("tireSize", "2.1", true);
		Part rearShock = new Part("rearShock", "Fox", true);
		Part frontShock = new Part("frontShock", "Manitou", false);

		Parts roadBikeParts = new Parts(new Part[]{chain, roadTire, tape});
		Bicycle bike = new Bicycle("L", roadBikeParts);
		System.out.println(bike.size);
		System.out.println(bike.getSpares());

		Parts mountainBikeParts = new Parts(new Part[]{chain, mountainTire, frontShock, rearShock});
		Bicycle bike2 = new Bicycle("M", mountainBikeParts);
		System.out.println(bike2.size);
		System.out.println(bike2.getSpares());

	}
}