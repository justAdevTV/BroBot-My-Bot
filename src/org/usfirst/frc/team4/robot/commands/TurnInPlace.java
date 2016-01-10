package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnInPlace extends Command {
	private PIDController m_pid;

	//TODO Calibrate
	private final double kP = 1/54, kI = 100, kD = 0;

    public TurnInPlace(double angle) {
    	requires(Robot.chassis);
		
    	m_pid = new PIDController(kP, kI, kD, new PIDSource() {
			public double pidGet() {
				return Robot.chassis.getAngle();
			}
		}, new PIDOutput() {
			public void pidWrite(double d) {
				Robot.chassis.gyroDrive(1, angle);
			}
		});
    	
		m_pid.setAbsoluteTolerance(.5);
		m_pid.setSetpoint(Robot.chassis.getAngle() + angle);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		Robot.chassis.reset();
		m_pid.reset();
		m_pid.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		m_pid.disable();
		Robot.chassis.tankDrive(0,0);
		Robot.chassis.reset();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		return m_pid.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
