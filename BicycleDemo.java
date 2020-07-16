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

abstract class Parts{
	protected String chain;
	protected String tireSize;

	public Parts(String chain, String tireSize){
		this.chain = chain;
		this.tireSize = tireSize;
	}

	abstract public HashMap<String, String> localSpares();

	public String defaultChain(){
		if(chain!=null) return chain;
		return "10-speed";
	}

	abstract public String defaultTireSize();

	public HashMap<String, String> getSpares(){
		HashMap<String, String> newMap = new HashMap<> ();
		newMap.put("chain", defaultChain());
		newMap.put("tireSize", defaultTireSize());
		newMap.putAll(localSpares());
		return newMap;
	}

	// declare methods
}

class RoadBikeParts extends Parts{
	public String tapeColor;

	public RoadBikeParts(String chain, String tireSize, String tapeColor){
		super(chain, tireSize);
		this.tapeColor = tapeColor;
	}

	public HashMap<String, String> localSpares(){
		HashMap<String, String> newMap = new HashMap<String, String> ();
		newMap.put("tapeColor", tapeColor);
		return newMap;
	}

	public String defaultTireSize(){
		if(tireSize!=null) return tireSize;
		return "23";
	}

}

class MountainBikeParts extends Parts{
	private String frontShock;
	private String rearShock;

	public MountainBikeParts(String chain, String tireSize, String frontShock, String rearShock){
		super(chain, tireSize);
		this.frontShock = frontShock;
		this.rearShock = rearShock;
	}
	
	public HashMap<String, String> localSpares(){
		HashMap<String, String> newMap = new HashMap<String, String> ();
		newMap.put("rearShock", rearShock);		
		return newMap;
	}

	public String defaultTireSize(){
		if(tireSize!=null) return tireSize;
		return "2.1";
	}

}

// class RecumbentBike extends Bicycle{
// 	private String flag;
// 	public RecumbentBike(String size, String chain, String tireSize, String frontShock, String rearShock, String flag){
// 		super(size, chain, tireSize);
// 		this.flag = flag;
// 	}

// 	public HashMap<String, String> localSpares(){
// 		HashMap<String, String> newMap = new HashMap<String, String> ();
// 		newMap.put("flag", flag);		
// 		return newMap;
// 	}

// 	public String defaultChain(){
// 		if(chain!=null) return chain;
// 		return "9-speed";
// 	}

// 	public String defaultTireSize(){
// 		if(tireSize!=null) return tireSize;
// 		return "28";
// 	}

// }

public class BicycleDemo{
	public static void main(String[] args){
		RoadBikeParts parts = new RoadBikeParts("30-speed", "100", "red");
		Bicycle bike = new Bicycle("M", parts);
		System.out.println(bike.size);
		System.out.println(bike.getSpares());

		MountainBikeParts parts1 = new MountainBikeParts(null, null, "Manitou", "Fox");
		Bicycle bike1 = new Bicycle("S", parts1);
		System.out.println(bike1.size);
		System.out.println(bike1.getSpares());

		// RecumbentBike bike2 = new RecumbentBike("L", null, null, null, null, "orange");
		// System.out.println(bike2.size);
		// System.out.println(bike2.getSpares());
	}
}