
package org.usfirst.frc1332.Robot2016;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc1332.Robot2016.RobotMap;
import org.usfirst.frc1332.Robot2016.RunMode;
import org.usfirst.frc1332.Robot2016.commands.*;
import org.usfirst.frc1332.Robot2016.subsystems.*;
import edu.wpi.first.wpilibj.CameraServer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	  CameraServer server;
	  public RunMode run_mode;
	  
	  

	    public Robot() {
	        server = CameraServer.getInstance();
	        server.setQuality(50);
	        //the camera name (ex "cam0") can be found through the roborio web interface
	        server.startAutomaticCapture("cam0");
	    } 

    Command autonomousCommand;

    public static OI oi;

    public static DriveTrain driveTrain;


    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    RobotMap.init();

    driveTrain = new DriveTrain();

        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period

        autonomousCommand = new AutonomousCommand();

        run_mode = new RunMode(
        		RobotMap.modeSwitchInputChannel1,
        		RobotMap.modeSwitchInputChannel2,
        		RobotMap.modeSwitchInputChannel3,
        		RobotMap.modeSwitchInputChannel4
        		);
        
        switch (run_mode.getRunMode()) {
        
        case 0: 
        	// All switches in off position, probably a good 'sleep' or 
        	// no-op setting
        	break;
        case 1:
        	//call a function, for example:
        	//autonomous1();
        	break;
        case 2: 
        	//call a function, for example:
        	//autonomous(2);
        	break;
        case 15:
        	// All switches in on position, maybe good for automated system check
        	// or some such
        	break;
        default: 
        	// a function to call if the run mode switch setting doesn't correspond to
        	// any previous cases.  Maybe sound a buzzer or flash a warning light.
        	break;
        }        

    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
