package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
//import frc.robot.ExampleCommand;

// Puts SpinShooter and ExampleCommand into a parallel command
public class ParallelExample extends ParallelCommandGroup {
    public ParallelExample(ShooterSubsystem subsystem, ExampleSubsystem subsystem2) {
        addCommands(new SpinShooter(subsystem), new ExampleCommand(subsystem2));    
    }
}
