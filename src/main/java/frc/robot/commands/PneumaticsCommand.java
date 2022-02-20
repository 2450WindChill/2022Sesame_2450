package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PneumaticsSubsystem;

public class PneumaticsCommand extends CommandBase{

    private final PneumaticsSubsystem m_subsystem; 
    DoubleSolenoid.Value val; 
    public PneumaticsCommand(PneumaticsSubsystem subsystem){
        m_subsystem = subsystem;
    }
    @Override
    public void initialize() {
        System.out.println("Pneumatics command activated!");
        // val = m_subsystem.exampleDouble.get();
        if (val == Value.kForward) {
        // m_subsystem.exampleDouble.set(Value.kReverse);
        
      } else {
        // m_subsystem.exampleDouble.set(Value.kForward);

      }
    }
    @Override
    public void execute() {
        
    }
    @Override
    public void end(boolean interrupted) {
        // m_subsystem.exampleDouble.set(DoubleSolenoid.Value.kOff);
    }
    @Override
    public boolean isFinished() {
        return true;
    }
}
