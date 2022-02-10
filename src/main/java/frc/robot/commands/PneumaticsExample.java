package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PneumaticsExample extends CommandBase{
    DoubleSolenoid exampleDouble = new DoubleSolenoid(PneumaticsModuleType.REVPH, 0, 1);
    public PneumaticsExample(){

    }
    @Override
    public void initialize() {
        System.out.println("Pneumatics command activated!");
        exampleDouble.toggle();
    }
    @Override
    public void execute() {

    }
    @Override
    public void end(boolean interrupted) {

    }
    @Override
    public boolean isFinished() {
        return false;
    }
}
