package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetDistance extends Command {
	private PIDController m_pid;

	// TODO Add actual values
	private final double kP = 1, kI = 1, kD = 0;

	public SetDistance(double distance) {
		requires(Robot.chassis);
		m_pid = new PIDController(kP, kI, kD, new PIDSource() {
			public double pidGet() {
				// TODO Make a getDistance
				return Robot.chassis.getDistance();
			}
		}, new PIDOutput() {
			public void pidWrite(double d) {
				Robot.chassis.tankDrive(d, d);
			}
		});
		//TODO add actual tolerance
		m_pid.setAbsoluteTolerance(0.05);
		m_pid.setSetpoint(distance);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.chassis.reset();
		m_pid.reset();
		m_pid.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return m_pid.onTarget();
	}

	// Called once after isFinished returns true
	protected void end() {
		m_pid.disable();
		Robot.chassis.tankDrive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
