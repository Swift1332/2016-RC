package org.usfirst.frc1332.Robot2016.subsystems;

import org.usfirst.frc1332.Robot2016.Robot;
import org.usfirst.frc1332.Robot2016.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Shooter extends Subsystem {
    
	SpeedController victor = RobotMap.shootervictor1;
	DigitalInput limitswitch1 = RobotMap.shooterlimitswitch1;
	//RobotDrive robotDrive = RobotMap.shooterRobotDriveVictor;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    public void initDefaultCommand() {
    	
    }
      
   public void ballPickup(){
	 RobotMap.shootervictor1.set(-.5);
	  
   }
   
	public void stopMotor() {
		victor.stopMotor();
		// TODO Auto-generated method stub
	}
	
	public boolean isSwitchSet(){
		limitswitch1.get();
		return true;
	}

	public void isFree(){
		limitswitch1.free();
	}
		
	public void shootBall(){
		RobotMap.shootervictor1.set(1);
	}
	
}

