package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

// Extends the dynamic arms a set distance based off of a constant or stops if a limit switch is triggered
public class SetExtendArmsCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final ClimberSubsystem m_subsystem;
    public double goalDistance;

    public SetExtendArmsCommand(ClimberSubsystem subsystem) {
        m_subsystem = subsystem;
        
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        goalDistance = m_subsystem.verticalEncoder.getDistance() + Constants.extendDistance;
        System.out.println("Value of goal distance" + goalDistance);
        System.out.println("Initializeing");
    }

    @Override
    public void execute() {
        m_subsystem.VerticalMotors.set(Constants.climbSpeed);
    }

    @Override
    public void end(boolean interrupted) {
        m_subsystem.VerticalMotors.set(0);
    }

    @Override
    public boolean isFinished() {
        if (goalDistance < m_subsystem.verticalEncoder.getDistance()) {
            return true;
        } else {
        return false;
        }
    }
}