package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
        goalDistance = m_subsystem.vertical_encoder.getDistance() + Constants.extendDistance;
        System.out.println("Value of goal distance" + goalDistance);
        System.out.println("Initializeing");
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_subsystem.VerticalMotors.set(Constants.climbSpeed);
        SmartDashboard.putNumber("Value of the encoder", m_subsystem.vertical_encoder.getDistance());
        System.out.println("Excuting");
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_subsystem.VerticalMotors.set(0);
        System.out.println("Ending: no speed");
    }

    @Override
    public boolean isFinished() {
        // boolean limitSwitchValue = m_subsystem.lernieUp.get();
        // System.out.println("Value of limit switch: " + limitSwitchValue + "." + "Value of the encoder: " + m_subsystem.encoder1.getDistance());
        if (goalDistance < m_subsystem.vertical_encoder.getDistance()) {
            return true;
        }
        return false;
    }
}