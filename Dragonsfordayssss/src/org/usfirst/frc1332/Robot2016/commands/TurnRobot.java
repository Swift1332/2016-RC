// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1332.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1332.Robot2016.Robot;

/**
 *
 */
public class TurnRobot extends Command {

    public TurnRobot () {

        //requires(Robot.${name.substring(0,1).toLowerCase()}${name.substring(1).replace(' ', '')});
    	requires (Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.enable();
    	Robot.driveTrain.setSetpoint(90.0 + Robot.driveTrain.getGyroAngle());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveTrain.onTarget();
    }
    
    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
