package org.usfirst.frc1332.Robot2016;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;

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
		if (Robot.driveTrain != null && Robot.oi != null) {
			
			if (Robot.oi.sensitivity.get())
			{
				
				leftOutput = leftOutput/3;
				rightOutput = rightOutput/3;
			}			
			// Tune this option (Start @ 0.4 and work the way back down towards
			// 0.1). Want the stick position to be just
			// a tad off center and not turn but still register a turn when
			// needing too. Also can this turn in an arc?
			if (Math.abs(leftOutput - rightOutput) < RobotMap.teleOpGyroDisableTolerance)
			{
				//System.out.println("GYRO: " + String.valueOf(gyroPIDLeftModifier));
				leftOutput = leftOutput + gyroPIDLeftModifier;
				rightOutput = rightOutput + gyroPIDRightModifier;
			} else {
				// reset gyro unless we are autonomous
				//System.out.println("NOGYRO");
				if (!Robot.robot.isAutonomous())
				{
					Robot.driveTrain.resetGyro();
				}

			}

			
			// If the dead man switch is not pressed, set motor outputs to 0 and reset the gyro
			// unless we are in autonomous mode
			if (!Robot.oi.DeadMan.get() && !Robot.robot.isAutonomous())
			{
				//System.out.println("DEADMAN IS DEAD: " + String.valueOf(Timer.getFPGATimestamp()));
				Robot.driveTrain.resetGyro();
				leftOutput = .0;
				rightOutput = .0;

			}
		}
		
		
		 super.setLeftRightMotorOutputs(leftOutput, rightOutput);
		 
		 
	 }

}
