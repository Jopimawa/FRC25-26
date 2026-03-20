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

  private final DriveSubsystem m_drive = new DriveSubsystem();

  public RobotContainer() {
    configureButtonBindings();
    configureAutoChooser();
  }

  private configureButtonBindings() {

  }

  //
  //Auto init (probably will be moved to a different file for org)
  //

  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  private final Command m_simpleAuto = Commands.sequence(
                                       Commands.run(() -> m_drive.tankDrive(1,1), m_drive)
                                                   .withTimeout(3)
                                       );

  private final Command m_complexAuto = Commands.sequence(
                                        Commands.run(() -> m_drive.tankDrive(1,1), m_drive)
                                                   .withTimeout(3),
                                        Commands.run(() -> m_drive.tankDrive(-1,-1), m_drive)
                                                   .withTimeout(2)
                                        );

    private configureAutoChooser() {
        m_chooser.setDefaultOption("Simple Auto", m_simpleAuto);
        m_chooser.addOption("Complex Auto", m_complexAuto);

        SmartDashboard.putData("Auto Modes", m_chooser);
    }

  public Command getAutonomousCommand() {
        return m_chooser.getSelected();
  }
}
