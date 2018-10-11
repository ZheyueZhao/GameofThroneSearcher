package project1;

public class Character implements Comparable<Character>{
	public String name;
	public String allegiances;
	public MyArrayList<Battle> battles;
	
	
	public Character(String name, String allegiances, MyArrayList<Battle> battles) {
		this.name=name;
		this.allegiances = allegiances;
		this.battles = battles;
		
		
	}
	
	public int compareTo(Character other) {
		return name.compareTo(other.name);
		}
	
	public String toString() {

		if(battles.size()==0) {
			return name + " with alleigance to "+allegiances + "\n" + " - No data for Battles";
		}
		return name + " with alleigance to "+allegiances;
			
	}
}
