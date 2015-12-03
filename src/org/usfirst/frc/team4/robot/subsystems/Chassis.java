package org.usfirst.frc.team4.robot.subsystems;

import org.usfirst.frc.team4.robot.RobotMap;
import org.usfirst.frc.team4.robot.commands.Drive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {
	private VictorSP m_leftFwd, m_leftRwd, m_rightFwd, m_rightRwd;
	private RobotDrive drive;
	private Gyro m_gyro;
	
	public Encoder m_leftEncoder;

	public boolean tank = true;

	public Chassis() {
		super();
		m_leftFwd = new VictorSP(RobotMap.CHASSIS_MOTOR_LEFTFRONT);
		m_leftRwd = new VictorSP(RobotMap.CHASSIS_MOTOR_LEFTREAR);
		m_rightFwd = new VictorSP(RobotMap.CHASSIS_MOTOR_RIGHTFRONT);
		m_rightRwd = new VictorSP(RobotMap.CHASSIS_MOTOR_RIGHTREAR);
		
		drive = new RobotDrive(m_leftFwd, m_leftRwd, m_rightFwd, m_rightRwd);
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		
		m_leftEncoder = new Encoder(RobotMap.CHASSIS_ENCODER_LEFT_A, RobotMap.CHASSIS_ENCODER_LEFT_B);
		//TODO add actual distance
		m_leftEncoder.setDistancePerPulse(0.0773);
		
		m_gyro = new Gyro(RobotMap.CHASSIS_GYRO);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}

	public void tankDrive(double right, double left) {
		drive.tankDrive(left, right, true);
	}

	public void arcadeDrive(double x, double y) {
		drive.arcadeDrive(y, x);
	}
	
	public void gyroDrive(double speed, double angle){
		drive.drive(speed, angle*.03);
	}

	public void stop() {
		tankDrive(0, 0);
	}
	
	public double getAngle(){
		return m_gyro.getAngle();
	}
	
	public void reset(){
		//m_gyro.reset();
		m_leftEncoder.reset();
	}
	
	public double getDistance(){
		//TODO Add right encoder then get average
		double d = m_leftEncoder.getDistance();
		return d;
	}	
	
	public double getRate(){
		return m_leftEncoder.getRate();
	}
}