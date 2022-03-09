package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class SetExtendArmCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final ClimberSubsystem m_subsystem;

    public SetExtendArmCommand(ClimberSubsystem subsystem) {
        m_subsystem = subsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

    public double goalDistance;

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        goalDistance = m_subsystem.encoder1.getDistance() + Constants.extendDistance;
        System.out.println("Value of goal distance" + goalDistance);
        System.out.println("Initializeing");
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_subsystem.DynamicArms.set(Constants.climbSpeed);
        SmartDashboard.putNumber("Value of the encoder", m_subsystem.encoder1.getDistance());
        System.out.println("Excuting");
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_subsystem.DynamicArms.set(0);
        System.out.println("Ending: no speed");
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        boolean limitSwitchValue = m_subsystem.lernieUp.get();
        System.out.println("Value of limit switch: " + limitSwitchValue + "." + "Value of the encoder: " + m_subsystem.encoder1.getDistance());
        if ((limitSwitchValue == true) || (goalDistance < m_subsystem.encoder1.getDistance())) {
            return true;
        }
        return false;
    }
}