package org.usfirst.frc.team4.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int 
	
    STICK_DRIVE       = 0,
    STICK_OP          = 1,

    CONT_A            = 1,
    CONT_B            = 2,
    CONT_X            = 3,
    CONT_Y            = 4,

    CONT_L1           = 5,
    CONT_R1           = 6,

    CONT_L2           = 2,
    CONT_R2           = 3,

    CONT_SELECT       = 7,
    CONT_START        = 8,

    CONT_L3           = 9,
    CONT_R3           =10,

    CONT_LY           = 1,
    CONT_LX           = 0,

    CONT_RY           = 5,
    CONT_RX           = 4,
//Chassis
    CHASSIS_MOTOR_LEFTFRONT   = 2,
    CHASSIS_MOTOR_LEFTREAR    = 3,
    CHASSIS_MOTOR_RIGHTFRONT  = 4,
    CHASSIS_MOTOR_RIGHTREAR   = 5,
    CHASSIS_GYRO              = 0,
    
    CHASSIS_ENCODER_LEFT_A    = 9,
    CHASSIS_ENCOFUN_CTIONS	  = -1,
    CHASSIS_ENCODER_LEFT_B    = 8,
         
    CHASSIS_ENCODER_RIGHT_A   = 0,
    CHASSIS_ENCODER_RIGHT_B   = 1,

 //Elevator Subsystem
    ELEVATOR_MOTOR            = 0,
    ELEVATOR_POTENTIOMETER    = 1,

 //Intake Subsystem
    INTAKE_LEFT               = 6,
    INTAKE_RIGHT              = 1,

 //Pneumatics subsystem
    PNEUMATICS_ARM_LEFT_FWD   = 3,
    PNEUMATICS_ARM_LEFT_RWD   = 0,
    PNEUMATICS_ARM_RIGHT_FWD  = 2,
    PNEUMATICS_ARM_RIGHT_RWD  = 1,

    PNEUMATICS_CLAW_RIGHT_FWD = 5,
	PNEUMATICS_CLAW_RIGHT_RWD = 7,
	PNEUMATICS_CLAW_LEFT_FWD = 4,
	PNEUMATICS_CLAW_LEFT_RWD = 6,
	
	PNUEMATICS_COMPRESSOR = 1;

	public static Joystick 
    driveCont,
    opCont;

	public static JoystickButton
	
	    //Drive stick
	
	    driveA,
	    driveB,
	    driveX,
	    driveY,
	
	    driveL1,
	    driveR1,
	
	    driveSelect,
	    driveStart,
	
	    driveL3,
	    driveR3,
	    
	    //OP stick
	    
	    opA,
	    opB,
	    opX,
	    opY,
	    
	    opL1,
	    opR1,
	    
	    opSelect,
	    opStart,
	    
	    opL3,
	    opR3;
	
	public static void init() {
	    driveCont       = new Joystick(STICK_DRIVE);
	    
	    driveA          = new JoystickButton(driveCont, CONT_A);
	    driveB          = new JoystickButton(driveCont, CONT_B);
	    driveX          = new JoystickButton(driveCont, CONT_X);
	    driveY          = new JoystickButton(driveCont, CONT_Y);
	
	    driveL1         = new JoystickButton(driveCont, CONT_L1);
	    driveR1         = new JoystickButton(driveCont, CONT_R1);
	
	    driveSelect     = new JoystickButton(driveCont, CONT_SELECT);
	    driveStart      = new JoystickButton(driveCont, CONT_START);
	
	    driveL3         = new JoystickButton(driveCont, CONT_L3);
	    driveR3         = new JoystickButton(driveCont, CONT_R3);
	    
	    //OP stick
	    opCont          = new Joystick(STICK_OP);
	    
	    opA             = new JoystickButton(opCont, CONT_A);
	    opB             = new JoystickButton(opCont, CONT_B);
	    opX             = new JoystickButton(opCont, CONT_X);
	    opY             = new JoystickButton(opCont, CONT_Y);
	
	    opL1            = new JoystickButton(opCont, CONT_L1);
	    opR1            = new JoystickButton(opCont, CONT_R1);
	
	    opSelect        = new JoystickButton(opCont, CONT_SELECT);
	    opStart         = new JoystickButton(opCont, CONT_START);
	
	    opL3            = new JoystickButton(opCont, CONT_L3);
		opR3            = new JoystickButton(opCont, CONT_R3);
	}
}