package frc.robot.commands.VerticalCommands;

import frc.robot.Constants;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

// Retracts the dynamic arms a set distance based off of a constant or stops if a limit switch is triggered
public class RetractArmsFullyCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final ClimberSubsystem m_subsystem;

    public RetractArmsFullyCommand(ClimberSubsystem subsystem) {
        m_subsystem = subsystem;

        addRequirements(subsystem);
    }
 
    @Override
    public void initialize() {
       //System.out.println("Fully retracting arms");
    }
 
    @Override
    public void execute() {
        //System.out.println("Executing retract fully arms command");
        m_subsystem.VerticalRetractionPID(0);
    }

    @Override
    public void end(boolean interrupted) {
        //m_subsystem.setVerticalSpeed(0);
        m_subsystem.VerticalMotor.set(0);
    }

    @Override
    public boolean isFinished() {
    if ((m_subsystem.verticalEncoder.getPosition() <= Constants.PIDRetractTolerance) || (m_subsystem.maxRetractSwitch.get() == true)) {
        //System.out.println("Is finished: true");
        return true;
    }
    //System.out.println("Is finished: false");
    return false;
    }
}