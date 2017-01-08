package org.usfirst.frc1332.Robot2016;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.buttons.Button;

public class JoystickAxesTrigger extends Button {

	Joystick m_joystick;
	
	AxisType trigger;
	double deadzone = 0.1;
		
	
	public JoystickAxesTrigger(Joystick joystick, AxisType at_trigger) {
		// TODO Auto-generated constructor stub
		m_joystick = joystick;
		trigger = at_trigger;
	}

	@Override
	public boolean get() {
		// TODO Auto-generated method stub
		// left 2
		// right 3
		if (m_joystick.getAxis(trigger) >= deadzone)
		{
			return true;
		}
		
		return false;
	}

}
