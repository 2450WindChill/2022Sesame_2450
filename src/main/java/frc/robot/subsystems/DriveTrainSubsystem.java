package frc.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class DriveTrainSubsystem extends SubsystemBase{
// Defineing triggers
  public final JoystickButton m_triggerLeft = new JoystickButton(null, 2);  
  public final JoystickButton m_triggerRight = new JoystickButton(null, 3);  

  // Other code/ideas:
  //getRawButton
  //getTriggerAxis(GenericHID.Hand hand);
}


