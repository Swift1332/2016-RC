package org.usfirst.frc1332.Robot2016.commands;

import org.usfirst.frc1332.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AuxilaryMotor1Forward extends Command {

    public AuxilaryMotor1Forward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.auxilary_motor_1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.auxilary_motor_1.set(0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.auxilary_motor_1.set(.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
