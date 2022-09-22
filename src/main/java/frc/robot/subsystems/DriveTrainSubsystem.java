package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {
  // Defining motors and putting the right motors in a motor control group
  public final WPI_TalonSRX m_rightMotor = new WPI_TalonSRX(1);
  public final WPI_TalonSRX m_rightMotor2 = new WPI_TalonSRX(2);
  public final MotorControllerGroup rightMotorGroup = new MotorControllerGroup(m_rightMotor, m_rightMotor2);

  // Defining motors and putting the left motors in a motor control group
  
  public final WPI_TalonSRX m_leftMotor = new WPI_TalonSRX(3);
  public final WPI_TalonSRX m_leftMotor2 = new WPI_TalonSRX(4);
  public final MotorControllerGroup leftMotorGroup = new MotorControllerGroup(m_leftMotor, m_leftMotor2);


  // Takes motor control groups and puts them in a differential drive
  // Putting motors into different motor groups
  // Confused about this code
  public final DifferentialDrive m_robotDrive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);

  public DriveTrainSubsystem() {
    m_rightMotor.setInverted(true);
    m_rightMotor2.setInverted(true);
    m_leftMotor.setInverted(false);
    m_leftMotor2.setInverted(false);
  }

  public void takeXboxInputs(XboxController xbox) {
    m_robotDrive.curvatureDrive((-xbox.getLeftTriggerAxis() + xbox.getRightTriggerAxis()), xbox.getLeftX() * 0.75,
        xbox.getAButton());
  }
}
