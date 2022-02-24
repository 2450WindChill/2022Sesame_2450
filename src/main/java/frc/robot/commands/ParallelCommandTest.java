package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ClimberSubSystem;
import frc.robot.subsystems.PneumaticsSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ParallelCommandTest extends ParallelCommandGroup {

    public ParallelCommandTest(ClimberSubSystem m_climb, PneumaticsSubsystem m_pneumatics, ShooterSubsystem m_shooter) {
      addCommands(
        new SequentialCommandGroup(
            new ClimberStep1Command(1, m_climb),
            new ClimberStep2Command(m_climb),
            new ParallelCommandGroup(
                new SpinShooter(m_shooter),
                new PneumaticsCommand(m_pneumatics)
          )));
    }
  }