package org.usfirst.frc.team4.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Wait extends Command {

	long time;
	
    public Wait(long t) {
        time = t;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
       		try {
    		    Thread.sleep(time*1000);
    		} catch(InterruptedException ex) {
    		    Thread.currentThread().interrupt();
    		}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
