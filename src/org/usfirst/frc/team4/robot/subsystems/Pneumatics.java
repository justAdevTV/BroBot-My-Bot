package org.usfirst.frc.team4.robot.subsystems;

import org.usfirst.frc.team4.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
	
	public boolean isClawOpen = true;
	public boolean isArmOpen = true;
	
	private Compressor m_compressor = new Compressor(RobotMap.PNUEMATICS_COMPRESSOR);
    
    private DoubleSolenoid m_leftClaw = new DoubleSolenoid(RobotMap.PNEUMATICS_CLAW_LEFT_FWD, RobotMap.PNEUMATICS_CLAW_LEFT_RWD);
    private DoubleSolenoid m_rightClaw = new DoubleSolenoid(RobotMap.PNEUMATICS_CLAW_RIGHT_FWD, RobotMap.PNEUMATICS_CLAW_RIGHT_RWD);
    
    private DoubleSolenoid m_leftArm = new DoubleSolenoid(RobotMap.PNEUMATICS_ARM_LEFT_FWD, RobotMap.PNEUMATICS_ARM_LEFT_RWD);
    private DoubleSolenoid m_rightArm = new DoubleSolenoid(RobotMap.PNEUMATICS_ARM_RIGHT_FWD, RobotMap.PNEUMATICS_ARM_RIGHT_RWD);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void compStart(){
    	m_compressor.start();
    }
    
    public void compStop(){
    	m_compressor.stop();
    }
    
    public void clawOpen(){
    	m_leftClaw.set(DoubleSolenoid.Value.kForward);
    	m_rightClaw.set(DoubleSolenoid.Value.kForward);
    }
    
    public void clawClose(){
    	m_leftClaw.set(DoubleSolenoid.Value.kReverse);
    	m_rightClaw.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void armOpen(){
    	m_leftArm.set(DoubleSolenoid.Value.kForward);
    	m_rightArm.set(DoubleSolenoid.Value.kForward);
    }
    
    public void armClose(){
    	m_leftArm.set(DoubleSolenoid.Value.kReverse);
    	m_rightArm.set(DoubleSolenoid.Value.kReverse);
    }
}