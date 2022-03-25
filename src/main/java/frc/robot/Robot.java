
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private RobotContainer m_robotContainer;

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
  }

  // Runs a scheduler
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void autonomousInit() {
    if (m_robotContainer.m_autonomousCommand != null) {
      m_robotContainer.m_autonomousCommand.schedule();
      System.out.println("Running autonomous");
    }
  }
}