package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClawToggle extends Command {

    public ClawToggle() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Robot.pneumatics.isClawOpen){
    		Robot.pneumatics.clawClose();
    	} else {
    		Robot.pneumatics.clawOpen();
    	}
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
    	Robot.pneumatics.isClawOpen = !Robot.pneumatics.isClawOpen;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}