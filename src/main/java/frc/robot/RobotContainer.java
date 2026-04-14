// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {

  private final Joystick m_driverJoystick = new Joystick(0);

  private final DriveSubsystem m_drive = new DriveSubsystem();
  private final OuttakeSubsystem m_outtake = new OuttakeSubsystem();

  public RobotContainer() {
    configureButtonBindings();
  }

  public DriveSubsystem getDrive() {
    return m_drive;
  }
  private configureButtonBindings() {
    m_drive.setDefaultCommand(new Drive(m_driveSubsystem, m_driverJoystick));

    new JoystickButton(m_driverJoystick, 1)
      .onTrue(new Outtake(m_outtake).withTimeout(OuttakeSubsystem::getTime));
  }

}
