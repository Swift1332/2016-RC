package org.usfirst.frc1332.Robot2016.commands;

import org.usfirst.frc1332.Robot2016.Robot;
import org.usfirst.frc1332.Robot2016.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveRelative extends Command {
	double target;
	boolean finished = false;
	double startDistance;
	double relative_target;

    public DriveRelative(double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	relative_target = distance;    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {    
    	startDistance = RobotMap.driveTrainQuad1.getDistance();
    	target = startDistance + relative_target;
    	Robot.driveTrain.resetGyro();
    	System.out.println("GYRO DRIVE REL INIT" + String.valueOf(Robot.driveTrain.getGyroAngle()));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double driveMod = relative_target <= 0 ? -1 : 1;
    	double output = .75 * driveMod;
    	
    	//while (Math.abs(target) - Math.abs((RobotMap.driveTrainQuad1.getDistance() + relative_target))  > .5)
    	//while (!finished && (RobotMap.driveTrainQuad1.getDistance() < target && driveMod > 0) || (RobotMap.driveTrainQuad1.getDistance() > target && driveMod < 0))
    	double start = Timer.getFPGATimestamp();
    	
		while ((Timer.getFPGATimestamp() - start) <= Math.abs(relative_target))
    	{
    		//System.out.println((Math.abs(RobotMap.driveTrainQuad1.getDistance() + relative_target) - target));
    		RobotMap.driveTrainDrive4.setLeftRightMotorOutputs(-output, -output);
    		Timer.delay(.05);
    	}
    	
	
    	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.driveTrainDrive4.setLeftRightMotorOutputs(.0, .0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    	finished = true;
    }
}
