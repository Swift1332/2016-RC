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
		 
		 if (Math.abs(leftOutput - rightOutput) < 0.1)
		 {
			 leftOutput = leftOutput + gyroPIDLeftModifier;
			 rightOutput = rightOutput + gyroPIDRightModifier;
		 }
		 else
		 {
			 //reset gyro
			 Robot.driveTrain.resetGyro();
		 }
		 
		 super.setLeftRightMotorOutputs(leftOutput, rightOutput);	 
	 }

}
