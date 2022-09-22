package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterSubsystem;

public class Shoot extends CommandBase {
    private final ShooterSubsystem m_shoot;


    public Shoot(ShooterSubsystem subsystem){
        m_shoot = subsystem;

        addRequirements(subsystem);
    
    }
    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        m_shoot.topLaunchMotor.set(Constants.topShootSpeed);
        m_shoot.bottomLaunchMotor.set(Constants.bottomShootSpeed);
    }

    @Override
    public void end(boolean interrupted) {
        m_shoot.topLaunchMotor.set(0);
        m_shoot.bottomLaunchMotor.set(0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
