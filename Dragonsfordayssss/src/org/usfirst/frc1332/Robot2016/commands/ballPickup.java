package org.usfirst.frc1332.Robot2016.commands;

import org.usfirst.frc1332.Robot2016.Robot;
import org.usfirst.frc1332.Robot2016.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ballPickup extends Command {

    public ballPickup() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (RobotMap.shooterlimitswitch1.get())
    	{
    	   	Robot.shooter.ballPickup();
    	   	Timer.delay(.1);
    	} 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return true;
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
