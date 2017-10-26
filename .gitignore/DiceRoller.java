import java.util.Arrays;

import javax.swing.JOptionPane;

/*
 * Program created by Hunter Dubbs
 * on 10/24/2017
 * version 1.0
 * 
 * This program helps expedite the board game Risk by
 * computing the results of dice rolls for large battles.
 * It asks for the strengths of the two armies and then
 * returns their final strengths after the battle.
 */
public class DiceRoller {

	public static void main(String[] args) {
		
		int attackerTroops = Integer.parseInt(JOptionPane.showInputDialog("Attacker Strength:"));
		int defenderTroops = Integer.parseInt(JOptionPane.showInputDialog("Defender Strength:"));
		
		/*
		 * Each iteration of this loop simulates a round of dice
		 * rolls. It will continue until one side is out of troops.
		 */
		while(attackerTroops > 0 && defenderTroops > 0){
			/*
			 * Rolls the correct number of dice given the current troops
			 * in the battle. If a dice is not rolled, it reads as a 0.
			 */
			int a1 = getDiceRoll();
			int a2 = 0;
			int a3 = 0;
			if(attackerTroops >= 2)
				a2 = getDiceRoll();
			if(attackerTroops >= 3)
				a3 = getDiceRoll();
			int d1 = getDiceRoll();
			int d2 = 0;
			if(defenderTroops >= 2)
				d2 = getDiceRoll();
			/*
			 * Orders each players dice in ascending order
			 * so that they can be compared later.
			 */
			int[] aDice = {a1, a2, a3};
			int[] dDice = {d1, d2};
			Arrays.sort(dDice);
			Arrays.sort(aDice);
			/*
			 * Compares the dice and decides the troop
			 * losses on each side.
			 */
			if(aDice[2] > dDice[1]){
				defenderTroops--;
			}else{
				attackerTroops--;
			}
			if(aDice[1] > dDice[0]){
				defenderTroops--;
			}else{
				attackerTroops--;
			}
		}
		String results = "Attacker: " + attackerTroops + "\nDefender: " + defenderTroops;
		JOptionPane.showMessageDialog(null, results);
	}
	
	public static int getDiceRoll(){
		return (int) Math.ceil(Math.random() * 6);
	}

}
