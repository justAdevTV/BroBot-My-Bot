package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleDrive extends Command {

    public ToggleDrive() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Switching to " + findMode());
    	Robot.chassis.tank = !Robot.chassis.tank;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.chassis = new Chassis();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    private String findMode(){
    	if (Robot.chassis.tank){
    		return "Arcade.";
    	} else {
    		return "Tank.";
    	}
    }
}