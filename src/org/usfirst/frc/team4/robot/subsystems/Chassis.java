package org.usfirst.frc.team4.robot.subsystems;

import org.usfirst.frc.team4.robot.RobotMap;
import org.usfirst.frc.team4.robot.commands.ArcadeDrive;
import org.usfirst.frc.team4.robot.commands.TankDrive;

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
	private Encoder m_leftEncoder;
	private RobotDrive drive;
	private Gyro m_gyro;

	public boolean tank = true;

	public Chassis() {
		super();
		m_leftFwd = new VictorSP(RobotMap.CHASSIS_MOTOR_LEFTFRONT);
		m_leftRwd = new VictorSP(RobotMap.CHASSIS_MOTOR_LEFTREAR);
		m_rightFwd = new VictorSP(RobotMap.CHASSIS_MOTOR_LEFTFRONT);
		m_rightRwd = new VictorSP(RobotMap.CHASSIS_MOTOR_RIGHTREAR);
		
		drive = new RobotDrive(m_leftFwd, m_leftRwd, m_rightFwd, m_rightRwd);
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		
		m_leftEncoder = new Encoder(RobotMap.CHASSIS_ENCODER_LEFT_A, RobotMap.CHASSIS_ENCODER_LEFT_B);
		//TODO add actual distance
		m_leftEncoder.setDistancePerPulse(0.16);
		
		m_gyro = new Gyro(RobotMap.CHASSIS_GYRO);
	}

	public void initDefaultCommand() {
		if (tank) {
			setDefaultCommand(new TankDrive());
		} else {
			setDefaultCommand(new ArcadeDrive());
		}
	}

	public void tankDrive(double right, double left) {
		drive.tankDrive(left, right);
	}

	public void arcadeDrive(double x, double y) {
		drive.arcadeDrive(y, x);
	}

	public void stop() {
		tankDrive(0, 0);
	}
	
	public double getPos(){
		return m_gyro.getAngle();
	}
	
	public void reset(){
		m_gyro.reset();
		m_leftEncoder.reset();
	}
	
	public double getDistance(){
		//TODO Add right encoder then get average
		double d = m_leftEncoder.getDistance();
		return d;
	}	
}