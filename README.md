# 2022daisy
Rapid React 2450 Windchill Code


DESCRIPTION OF COMMANDS:

AngleDownCommand: angles the arm down while a button is held. But will eventually angle the arm down with a set distance based off of a constant.

AngleUpCommand: angles the arm up while a button is held. But it will eventually angle the arm up a set distance based off of a constant.

AutoClimb: When on ground and attached to mid bar, this command will automatically get the robot to the high bar. Could theoretically be used to get robot from high bar to traversal but swing would be an issue.

AutonomousCommand: Calls DriveBackward when the autonomous phase begins.

Drive: Puts xbox inputs into the curvature drive.

DriveBackward: Drives the robot backward for 1.5 seconds.

ManualAnglingCommand: Angles the dynamic arms using the right stick.

ManualClimbCommand: Extends or retracts the dynamic arms depending on the right stick.

MoveArmCommand: If the distance of the arms is greater than the setpoint, then set the speed of the motors to extend.

SetExtendCommand: Called once the command ends or is interrupted.

SetRetractCommand: Retracts the dynamic arms a set distance based off of a constant or stops if a limit switch is triggered.

SwitchStateCommand: Switches the state of the arms form whatever it is to the other state.



DESCRIPTION OF SUBSYSTEMS:

ClimberSubSystem: Holds motors, encoders, and limit switches associated with climbing. Also holds logic statements to change the state.

DriveTrainSubsystem: Holds motors associated with driving. Also has curvature drive and things that slow initial acceleration.


MOTOR ID'S:
Vertical motors: 5 and 6
Angle adjuster: 7