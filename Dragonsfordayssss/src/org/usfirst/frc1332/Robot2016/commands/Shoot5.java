package org.usfirst.frc1332.Robot2016.commands;

import org.usfirst.frc1332.Robot2016.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Shoot5 extends Command {
	boolean finished = false;

    public Shoot5() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double start = Timer.getFPGATimestamp();
    	
		while ((Timer.getFPGATimestamp() - start) <= 5.0) {
			Robot.shooter.shootBall();
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
    	Robot.shooter.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
