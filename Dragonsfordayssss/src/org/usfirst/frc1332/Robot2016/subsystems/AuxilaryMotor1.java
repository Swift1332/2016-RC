package org.usfirst.frc1332.Robot2016.subsystems;

import org.usfirst.frc1332.Robot2016.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AuxilaryMotor1 extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void set(double speed)
    {
    	RobotMap.auxMotor1.set(speed);
    }
}

