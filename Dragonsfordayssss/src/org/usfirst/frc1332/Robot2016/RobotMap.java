


package org.usfirst.frc1332.Robot2016;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SafePWM;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static RobotDrive shooterRobotDriveVictor;
	public static DigitalInput shooterlimitswitch1;
	public static SpeedController driveTrainFrontLeft;
    public static SpeedController driveTrainRearLeft;
    public static SpeedController driveTrainFrontRight;
    public static SpeedController driveTrainRearRight;
    public static DragonDrive driveTrainDrive4;
    public static AnalogGyro driveTrainAnalogGyro1;
    public static Encoder driveTrainQuad1;
    public static Encoder driveTrainQuad2;
    public static Victor shootervictor1;
    public static Servo cameraGimbalServo_Y;
    public static Servo cameraGimbalServo_X;
    
    public static SpeedController auxMotor1;
    public static int auxMotorInputChannel = 8;
    
    public static int servoXChannel = 7;
    public static int servoYChannel = 6;
    
    public static double servoXDefault = 0.717222222222;
    public static double servoYDefault = 0.713888888888;
    
    
 // set run mode switch channels (DigitChannelPinOut)
    public static int modeSwitchInputChannel1 = 3;
	public static int modeSwitchInputChannel2 = 2;
	public static int modeSwitchInputChannel3 = 1;
	public static int modeSwitchInputChannel4 = 0;
	
	public static double teleOpGyroDisableTolerance = 0.2;
	
	// DriveTrain PID values
	public static double driveTrainPID_F = 0.0;
	public static double driveTrainPID_Period = PIDController.kDefaultPeriod; //default .05
	
	public static double driveTrainPID_P_TeleOp = 0.057;
	public static double driveTrainPID_I_TeleOp = 0.000;
	public static double driveTrainPID_D_TeleOp = 0.0;
	
	public static double driveTrainPID_P_Auto = 0.03;
	public static double driveTrainPID_I_Auto = 0.000;
	public static double driveTrainPID_D_Auto = 0.0;



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

        shootervictor1 = new Victor (4);
        LiveWindow.addActuator("Shooter", "victor", (Victor)shootervictor1);
       
        shootervictor1.setSafetyEnabled(false);
        
        //shootervictor1.setExpiration(1.0);        
        
        shooterlimitswitch1 = new DigitalInput(8);
        
        //Digital IO Connections
        driveTrainQuad1 = new Encoder(4, 5, true, EncodingType.k4X);
        LiveWindow.addSensor("DriveBase", "Quad1", driveTrainQuad1);
        driveTrainQuad1.setDistancePerPulse(.00542299);
        driveTrainQuad1.setPIDSourceType(PIDSourceType.kRate);
        
        driveTrainQuad2 = new Encoder(6, 7, true, EncodingType.k4X);
        LiveWindow.addSensor("DriveBase", "Quad2", driveTrainQuad2);
        driveTrainQuad2.setDistancePerPulse(1.0);
        driveTrainQuad2.setPIDSourceType(PIDSourceType.kRate);
        
        //Analog IO Connections
        driveTrainAnalogGyro1 = new AnalogGyro(1);
        LiveWindow.addSensor("DriveTrain", "AnalogGyro 1", driveTrainAnalogGyro1);
        driveTrainAnalogGyro1.setSensitivity(0.007);

        cameraGimbalServo_X = new Servo(servoXChannel);
        cameraGimbalServo_Y = new Servo(servoYChannel);
        
        auxMotor1 = new Talon(auxMotorInputChannel);
        auxMotor1.setInverted(false);

        
        //LiveWindow.addActuator("Camera","servo" , (Servo)cameraCameraservo1);
              
  
    }
}
