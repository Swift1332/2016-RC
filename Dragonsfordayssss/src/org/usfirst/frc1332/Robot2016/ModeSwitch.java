package org.usfirst.frc1332.Robot2016;

import edu.wpi.first.wpilibj.DigitalInput;

public class ModeSwitch extends DigitalInput {

	public ModeSwitch(int channel) {
		super(channel);
		// TODO Auto-generated constructor stub
	}
	
	public String getBit(){
		//return "1" if input is high, "0" if it is low
		return Integer.toString(get() ? 1 : 0);
	}

}