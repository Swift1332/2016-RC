package org.usfirst.frc1332.Robot2016;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.buttons.Button;

public class JoystickPOVButton extends Button {
	
	GenericHID m_joystick;

	public JoystickPOVButton(GenericHID joystick) {
		// TODO Auto-generated constructor stub
		m_joystick = joystick;
	}

	@Override
	public boolean get() {
		// TODO Auto-generated method stub
		int pov = getValue();
		return pov >= 0;
	}
	
	public int getValue(){
		return m_joystick.getPOV(0);
	}

}
