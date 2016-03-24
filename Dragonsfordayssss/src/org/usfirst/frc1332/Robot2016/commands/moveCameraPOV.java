package org.usfirst.frc1332.Robot2016.commands;

import org.usfirst.frc1332.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class moveCameraPOV extends Command {
	boolean finished = false;
	int pov_direction;

    public moveCameraPOV() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.camera_gimbal);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	pov_direction = Robot.oi.pov.getValue();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (pov_direction >= 0)
    	{

    		if (pov_direction >= 315 || pov_direction <= 45)
    		{
    			Robot.camera_gimbal.moveCameraDown();
    		}

    		if (pov_direction >= 45 && pov_direction <= 135)
    		{
    			Robot.camera_gimbal.moveCameraRight();
    		}

    		if (pov_direction >= 135 && pov_direction <= 225)
    		{
    			Robot.camera_gimbal.moveCameraUp();
    		}

    		if (pov_direction >= 225 && pov_direction <= 315)
    		{
    			Robot.camera_gimbal.moveCameraLeft();
    		}
    	}
    	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
