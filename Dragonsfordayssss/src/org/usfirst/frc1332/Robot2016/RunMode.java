package org.usfirst.frc1332.Robot2016;

public class RunMode {
	
	public ModeSwitch switch_one;
	public ModeSwitch switch_two;
	public ModeSwitch switch_three;
	public ModeSwitch switch_four;
	private int run_mode;

	public RunMode(int switch_one_channel, int switch_two_channel, int switch_three_channel, int switch_four_channel){
		switch_one = new ModeSwitch(switch_one_channel);
		switch_two = new ModeSwitch(switch_two_channel);
		switch_three = new ModeSwitch(switch_three_channel);
		switch_four = new ModeSwitch(switch_four_channel);
	}
	
	public int getRunMode(){
		/* parse the "0"/"1" concatenation of all four switches in order as 
		 * if it were a 4 bit byte and return the resulting integer value:
		 * 
		 * 
		 *        (8) (4) (2) (1) 
		 *  |   || 1 | 2 | 3 | 4 | 
		 *  ---------------------
		 *  | 0 || 0 | 0 | 0 | 0 |
		 *  | 1 || 0 | 0 | 0 | 1 |
		 *  | 2 || 0 | 0 | 1 | 0 |
		 *  | 3 || 0 | 0 | 1 | 1 |
		 *  | 4 || 0 | 1 | 0 | 0 |
		 *  | 5 || 0 | 1 | 0 | 1 |
		 *  | 6 || 0 | 1 | 1 | 0 |
		 *  | 7 || 0 | 1 | 1 | 1 |
		 *  | 8 || 1 | 0 | 0 | 0 | 
		 *  | 9 || 1 | 0 | 0 | 1 |
		 *  |10 || 1 | 0 | 1 | 0 |
		 *  |11 || 1 | 0 | 1 | 1 |
		 *  |12 || 1 | 1 | 0 | 0 |
		 *  |13 || 1 | 1 | 0 | 1 |
		 *  |14 || 1 | 1 | 1 | 0 |
		 *  |15 || 1 | 1 | 1 | 1 |
		 * 
		 */

		run_mode = Byte.parseByte((
				switch_one.getBit() + 
				switch_two.getBit() + 
				switch_three.getBit() + 
				switch_four.getBit()
				),2);
		
		return run_mode;
	}
}