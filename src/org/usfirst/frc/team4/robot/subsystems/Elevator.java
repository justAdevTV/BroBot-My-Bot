package org.usfirst.frc.team4.robot.subsystems;

import org.usfirst.frc.team4.robot.RobotMap;
import org.usfirst.frc.team4.robot.commands.Lift;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class Elevator extends Subsystem {
    
    private VictorSP m_elevator;
    private Potentiometer m_pot;
    
    private elePos currentState;
    
    // TODO Change to actual value
    private final int MAX_POS = 90, MIN_POS = 0;
    
    private enum elePos{
    	OVER_HEIGHT,
    	SAFE_HEIGHT,
    	UNDER_HEIGHT;
    }
    
    public Elevator(){
    	m_elevator = new VictorSP(RobotMap.ELEVATOR_MOTOR);
    	//TODO Add actual scale
    	m_pot = new AnalogPotentiometer(RobotMap.ELEVATOR_POTENTIOMETER, .4);
    	checkPos();
    }
    	
    public void initDefaultCommand() {
       setDefaultCommand(new Lift());
    }
    
    public void eleVator(double height){
    	currentState = checkPos();
    	
    	height = limitPos(currentState, height);
    		
    	//Motor is reversed
    	m_elevator.set(-height);
    }
    
    public void stop(){
    	eleVator(0);
    }
    
    private elePos checkPos(){
    	//TODO check if correct
    	if (m_pot.get() > MAX_POS){
    		return elePos.OVER_HEIGHT;
    	} if (m_pot.get() < MIN_POS){
    		return elePos.UNDER_HEIGHT;
    	} else {
    		return elePos.SAFE_HEIGHT;
    	}
    }
    
    private double limitPos(elePos p, double h){
    	if(p == elePos.OVER_HEIGHT){
    		return h = h < 0 ? 0 : h;
    	} else if (p == elePos.UNDER_HEIGHT){
    		return h = h > 0 ? 0 : h;
    	} else {
    		return h;
    	}
    }
    
    public double getStep(){
    	return m_pot.get();
    }
}
