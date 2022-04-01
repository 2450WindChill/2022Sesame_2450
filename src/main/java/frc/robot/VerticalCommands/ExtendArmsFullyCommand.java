package frc.robot.VerticalCommands;

import frc.robot.Constants;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

// Extends the dynamic arms a set distance based off of a constant or stops if a limit switch is triggered
public class ExtendArmsFullyCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final ClimberSubsystem m_subsystem;

    public ExtendArmsFullyCommand(ClimberSubsystem subsystem) {
        m_subsystem = subsystem;
        
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        System.out.println("Fully extending arms");
    }

    @Override
    public void execute() {
        m_subsystem.VerticalExtentionPID(-332000);
    }

    @Override
    public void end(boolean interrupted) {
        m_subsystem.setVerticalSpeed(0);
        //m_subsystem.VerticalMotor.set(0);
    }

    @Override
    public boolean isFinished() {
        if ((m_subsystem.verticalEncoder.getDistance() >= Constants.PIDExtendTolerance)) {
            return true;
        } else {
        return false;
        }
    }
}