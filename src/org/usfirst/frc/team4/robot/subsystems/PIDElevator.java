package org.usfirst.frc.team4.robot.subsystems;

import org.usfirst.frc.team4.robot.RobotMap;
import org.usfirst.frc.team4.robot.commands.Lift;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class PIDElevator extends PIDSubsystem {

	private VictorSP m_elevator;
	// TODO Map POT
	private Potentiometer m_pot;
	// TODO add actual values, Maybe add D
	private static final double kP = 1/26, kI = 1, kD = 0;

	private elePos currentState;

	private final double MAX_POS = -.176, MIN_POS = -.39;

	private enum elePos {
		OVER_HEIGHT, SAFE_HEIGHT, UNDER_HEIGHT;
	}

	// Initialize your subsystem here
	public PIDElevator() {
		super("pelevator",kP, kI, kD);

		setAbsoluteTolerance(0.01);

		m_elevator = new VictorSP(RobotMap.ELEVATOR_MOTOR);

		m_pot = new AnalogPotentiometer(RobotMap.ELEVATOR_POTENTIOMETER, -.4);
	}

	protected double returnPIDInput() {
		return m_pot.get();
	}

	protected void usePIDOutput(double output) {
		if (m_pot.get() < -.176 && m_pot.get() > -.39) {
			m_elevator.set(output);
		}
	}

	public void initDefaultCommand() {
		setDefaultCommand(new Lift());
	}

	public void eleVator(double height) {
		currentState = checkPos();

		height = limitPos(currentState, height);

		// Motor is reversed
		m_elevator.set(-height);
	}

	public void stop() {
		eleVator(0);
	}

	private elePos checkPos() {
		if (m_pot.get() > MAX_POS) {
			return elePos.OVER_HEIGHT;
		}
		if (m_pot.get() < MIN_POS) {
			return elePos.UNDER_HEIGHT;
		} else {
			return elePos.SAFE_HEIGHT;
		}
	}

	private double limitPos(elePos p, double h) {
		if (p == elePos.OVER_HEIGHT) {
			return h = h < 0 ? 0 : h;
		} else if (p == elePos.UNDER_HEIGHT) {
			return h = h > 0 ? 0 : h;
		} else {
			return h;
		}
	}

	public double getStep() {
		return m_pot.get();
	}
}
