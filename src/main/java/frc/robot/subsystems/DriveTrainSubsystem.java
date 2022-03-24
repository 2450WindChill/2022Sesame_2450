package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {
  // Defining motors and putting the right motors in a motor control group
  public final CANSparkMax m_rightMotor = new CANSparkMax(1, MotorType.kBrushed);
  public final CANSparkMax m_rightMotor2 = new CANSparkMax(2, MotorType.kBrushed);
  public final MotorControllerGroup rightMotorGroup = new MotorControllerGroup(m_rightMotor, m_rightMotor2);

  // Defining motors and putting the left motors in a motor control group
  public final CANSparkMax m_leftMotor = new CANSparkMax(3, MotorType.kBrushed);
  public final CANSparkMax m_leftMotor2 = new CANSparkMax(4, MotorType.kBrushed);
  public final MotorControllerGroup leftMotorGroup = new MotorControllerGroup(m_leftMotor, m_leftMotor2);

  // Takes motor control groups and puts them in a differential drive
  // Putting motors into different motor groups
  // Confused about this code
  public final DifferentialDrive m_robotDrive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);

  public DriveTrainSubsystem() {
    double rate = 0.5;

    // Inital acceleration of the robot (adjuste)
    m_rightMotor.setOpenLoopRampRate(rate);
    m_rightMotor2.setOpenLoopRampRate(rate);
    m_leftMotor.setOpenLoopRampRate(rate);
    m_leftMotor2.setOpenLoopRampRate(rate);

    // Inverting the motors (as needed)
  
    m_rightMotor.setInverted(false);
    m_rightMotor2.setInverted(false);
    m_leftMotor.setInverted(false);
    m_leftMotor2.setInverted(false);
  }

  public void takeXboxInputs(XboxController xbox) {
    m_robotDrive.curvatureDrive((-xbox.getLeftTriggerAxis() + xbox.getRightTriggerAxis()), xbox.getLeftX() * 0.5, xbox.getAButton());
    //m_robotDrive.curvatureDrive(0, 0, xbox.getAButton());
  }
}
