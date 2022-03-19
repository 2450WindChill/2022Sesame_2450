package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

// Retracts the dynamic arms a set distance based off of a constant or stops if a limit switch is triggered
public class SetRetractArmsCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final ClimberSubsystem m_subsystem;

    public SetRetractArmsCommand(ClimberSubsystem subsystem) {
        m_subsystem = subsystem;

        addRequirements(subsystem);
    }
 
    @Override
    public void initialize() {
       
    }

    @Override
    public void execute() {
        m_subsystem.VerticalRetractionPID();
    }

    @Override
    public void end(boolean interrupted) {
        m_subsystem.VerticalMotors.set(0);
        System.out.println("Ending: no speed");
    }

    @Override
    public boolean isFinished() {
    if (m_subsystem.verticalEncoder.getDistance() <= Constants.PIDRetractTolerance) {
        return true;
    }
        return false;
    }
}