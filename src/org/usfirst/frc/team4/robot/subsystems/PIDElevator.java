package org.usfirst.frc.team4.robot.subsystems;

import org.usfirst.frc.team4.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class PIDElevator extends PIDSubsystem {

	private VictorSP m_elevator;
	//TODO Map POT
    private Potentiometer m_pot;
    //TODO add actual values, Maybe add D
    private static final double kP = 3, kI = 0.07, kD = 0;
	
    // Initialize your subsystem here
    public PIDElevator() {
        super(kP, kI, kD);
        //TODO Determine actual value
        setAbsoluteTolerance(0.005);
        
        m_elevator = new VictorSP(RobotMap.ELEVATOR_MOTOR);
        //TODO Find actual type; Find actual scaling
        m_pot = new AnalogPotentiometer(RobotMap.ELEVATOR_POTENTIOMETER, -.4);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
       return m_pot.get();
    }
    
    protected void usePIDOutput(double output) {
        m_elevator.set(output);
    }
}
