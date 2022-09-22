package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Delay;
import frc.robot.subsystems.DriveTrainSubsystem;

public class TurnAround extends CommandBase {
    private final DriveTrainSubsystem m_drive;
    
    private Delay d;
    private long time = Constants.turnAroundTime;

    public TurnAround(DriveTrainSubsystem m_subsystem){
        m_drive = m_subsystem;

        addRequirements(m_subsystem);
    
    }
    @Override
    public void initialize() {
        d = new Delay(time);
    }

    @Override
    public void execute() {
        m_drive.leftMotorGroup.set(0.5);
        m_drive.rightMotorGroup.set(-0.1);
    }

    @Override   
    public void end(boolean interrupted) {
        
    }

    @Override
    public boolean isFinished() {
        return d.isExpired();
    }

}
