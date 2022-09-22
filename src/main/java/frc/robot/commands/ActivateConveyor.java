package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ConveyorSubsystem;

public class ActivateConveyor extends CommandBase {
    private final ConveyorSubsystem m_conveyor;
    
    public ActivateConveyor(ConveyorSubsystem subsystem){
        m_conveyor = subsystem;

        addRequirements(subsystem);
    
    }
    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        m_conveyor.conveyorMotor.set(Constants.conveyorSpeed);
    }

    @Override
    public void end(boolean interrupted) {
        m_conveyor.conveyorMotor.set(0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
