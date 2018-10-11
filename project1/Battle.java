package project1;

public class Battle implements Comparable<Battle>{
		public String name;
		public String attackerKing;
		public String defenderKing;
		public String attackerOutcome;
		public String battleType;
		public String location;
		public String region;
		
		public Battle(String name, String attackerKing, String defenderKing, String attackerOutcome, String battleType, String location, String region) {
			this.name = name;
			this.attackerKing = attackerKing;
			this.defenderKing = defenderKing;
			this.attackerOutcome = attackerOutcome;
			this.battleType = battleType;
			this.location = location;
			this.region = region;
		}
		
		public Battle(String name) {
			
			this.name = name;
		}

		@Override
		public int compareTo(Battle other) {
			return name.compareTo(other.name);
			}
		
		/* 	Test Class for compareTo method
		 * 	outputs 1
		 * 
		 * 
		 * public static void main(String args[]) {
			Battle newBattle = new Battle("abc");
			Battle secBattle = new Battle("bcd");
			System.out.println(secBattle.compareTo(newBattle));
			
		}
		*/
		
		public String toString() {
			
			return((" - "+name+", when "+ attackerKing+" attacked "+ defenderKing+", resulting in a "+ attackerOutcome+", through a"
					
					
					+ battleType+", at "+ location+", in the region of "+ region));
			
			}
}
