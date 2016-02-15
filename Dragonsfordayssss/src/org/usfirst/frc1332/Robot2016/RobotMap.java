


package org.usfirst.frc1332.Robot2016;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static SpeedController driveTrainFrontLeft;
    public static SpeedController driveTrainRearLeft;
    public static SpeedController driveTrainFrontRight;
    public static SpeedController driveTrainRearRight;
    public static DragonDrive driveTrainDrive4;
    public static AnalogGyro driveTrainAnalogGyro1;
    public static Encoder driveTrainQuad1;
    public static Encoder driveTrainQuad2;

    
 // set run mode switch channels (DigitPinOut)
    public static int modeSwitchInputChannel1 = 1;
	public static int modeSwitchInputChannel2 = 2;
	public static int modeSwitchInputChannel3 = 3;
	public static int modeSwitchInputChannel4 = 4;


    public static void init() {

    	//PWM Connections        
        driveTrainFrontLeft = new Talon(0);
        LiveWindow.addActuator("DriveTrain", "FrontLeft", (Talon) driveTrainFrontLeft);
        
        driveTrainRearLeft = new Talon(1);
        LiveWindow.addActuator("DriveTrain", "RearLeft", (Talon) driveTrainRearLeft);
        
        driveTrainFrontRight = new Talon(2);
        LiveWindow.addActuator("DriveTrain", "FrontRight", (Talon) driveTrainFrontRight);
      
        driveTrainRearRight = new Talon(3);
        LiveWindow.addActuator("DriveTrain", "RearRight", (Talon) driveTrainRearRight);
        
        driveTrainDrive4 = new DragonDrive(driveTrainFrontLeft, driveTrainRearLeft,
                driveTrainFrontRight, driveTrainRearRight);
        
        driveTrainDrive4.setSafetyEnabled(true);
        driveTrainDrive4.setExpiration(0.1);
        driveTrainDrive4.setSensitivity(0.5);
        driveTrainDrive4.setMaxOutput(0.8);
        
        driveTrainDrive4.setInvertedMotor(DragonDrive.MotorType.kFrontRight, true);
        driveTrainDrive4.setInvertedMotor(DragonDrive.MotorType.kRearRight, true);
        driveTrainDrive4.setInvertedMotor(DragonDrive.MotorType.kFrontLeft, true);
        driveTrainDrive4.setInvertedMotor(DragonDrive.MotorType.kRearLeft, true);
       
        //Digital IO Connections
        driveTrainQuad1 = new Encoder(5, 6, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveBase", "Quad1", driveTrainQuad1);
        driveTrainQuad1.setDistancePerPulse(1.0);
        driveTrainQuad1.setPIDSourceType(PIDSourceType.kRate);
        
        driveTrainQuad2 = new Encoder(7, 8, true, EncodingType.k4X);
        LiveWindow.addSensor("DriveBase", "Quad2", driveTrainQuad2);
        driveTrainQuad2.setDistancePerPulse(1.0);
        driveTrainQuad2.setPIDSourceType(PIDSourceType.kRate);
        
        //Analog IO Connections
        driveTrainAnalogGyro1 = new AnalogGyro(1);
        LiveWindow.addSensor("DriveTrain", "AnalogGyro 1", driveTrainAnalogGyro1);
        driveTrainAnalogGyro1.setSensitivity(0.007);

    }
}
