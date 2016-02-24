package org.usfirst.frc1332.Robot2016.subsystems;

import org.usfirst.frc1332.Robot2016.Robot;
import org.usfirst.frc1332.Robot2016.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CameraGimbal extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void moveCameraUp() {
		double current = RobotMap.cameraGimbalServo_Y.getAngle();
		RobotMap.cameraGimbalServo_Y.setAngle(current - 2);
	}

	public void moveCameraDown() {
		double current = RobotMap.cameraGimbalServo_Y.getAngle();
		RobotMap.cameraGimbalServo_Y.setAngle(current + 2);
	}

	public void moveCameraLeft() {
		double current = RobotMap.cameraGimbalServo_X.getAngle();
		RobotMap.cameraGimbalServo_X.setAngle(current - 2);

	}

	public void moveCameraRight() {
		double current = RobotMap.cameraGimbalServo_X.getAngle();
		RobotMap.cameraGimbalServo_X.setAngle(current + 2);
	}

}
