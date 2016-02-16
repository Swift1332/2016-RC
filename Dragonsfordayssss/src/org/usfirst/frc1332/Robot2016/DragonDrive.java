package org.usfirst.frc1332.Robot2016;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

public class DragonDrive extends RobotDrive {
	
	public double gyroPIDLeftModifier = 0;
	public double gyroPIDRightModifier = 0;

	public DragonDrive(int leftMotorChannel, int rightMotorChannel) {
		super(leftMotorChannel, rightMotorChannel);
		// TODO Auto-generated constructor stub
	}

	public DragonDrive(SpeedController leftMotor, SpeedController rightMotor) {
		super(leftMotor, rightMotor);
		// TODO Auto-generated constructor stub
	}

	public DragonDrive(int frontLeftMotor, int rearLeftMotor, int frontRightMotor, int rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		// TODO Auto-generated constructor stub
	}

	public DragonDrive(SpeedController frontLeftMotor, SpeedController rearLeftMotor, SpeedController frontRightMotor,
			SpeedController rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		// TODO Auto-generated constructor stub
	}
	
	 public void setLeftRightMotorOutputs(double leftOutput, double rightOutput) {
		 
		 if ((Math.abs(leftOutput - rightOutput) < 0.1)) //&& Robot.oi.DeadMan.get()) 
			 //Tune this option (Start @ 0.4 and work the way back down towards 0.1). Want the stick position to be just 
			 //a tad off center and not turn but still register a turn when needing too. Also can this turn in an arc?
		 {
			 leftOutput = leftOutput + gyroPIDLeftModifier;
			 rightOutput = rightOutput + gyroPIDRightModifier;
		 }
		 else
		 {
			 //reset gyro
			 Robot.driveTrain.resetGyro();
		 }
		 
		 if (!Robot.oi.DeadMan.get()) //This function is a safety measure. This prevents motor output and reset the gyro unless trigger is pressed.
		 {
			 Robot.driveTrain.resetGyro();
			 Robot.driveTrain.drivestop(0);
		 }
		 
		 super.setLeftRightMotorOutputs(leftOutput, rightOutput);	 
	 }

}
