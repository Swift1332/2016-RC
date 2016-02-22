package org.usfirst.frc1332.Robot2016.commands;

import org.usfirst.frc1332.Robot2016.Robot;
import org.usfirst.frc1332.Robot2016.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PivotRelative extends Command {
	double target;
	double relative_target;
	boolean finished = false;

    public PivotRelative(double turnDegrees) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);    	
    	relative_target = turnDegrees;

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	double currentAngle = Robot.driveTrain.getGyroAngle();
    	target = currentAngle + relative_target;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//determine motor direction
    	double rightMod = relative_target <= 0 ? -1 : 1;
    	double leftMod = relative_target <= 0 ? 1 : -1;
    	
    	//set motor speed and multiply by mod to set speed and direction
    	double leftOutput = .3 * leftMod;
    	double rightOutput = .3 * rightMod;
    	Robot.driveTrain.getPIDController().setSetpoint(target);
    	
    	while (!finished && (Math.abs(Robot.driveTrain.getGyroAngle() - target) > 1))
    	{
    		//System.out.println(String.valueOf(Robot.driveTrain.getGyroAngle()));
    		RobotMap.driveTrainDrive4.setLeftRightMotorOutputs(leftOutput, rightOutput);
    		Timer.delay(.05);
    	}
    	
    	Timer.delay(.5);
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
    	RobotMap.driveTrainDrive4.setLeftRightMotorOutputs(.0, .0);
    	finished = true;
    }
}
