// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.LEDPattern;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Leds extends SubsystemBase {

  private AddressableLED m_AddressableLED;
  private AddressableLEDBuffer m_AddressableLEDBuffer;
  private int m_length;
  private int m_pwmPort;

  /** Creates a new Leds. */
  public Leds() {
    m_pwmPort = 6;
    m_length = 40;
    m_AddressableLED = new AddressableLED(m_pwmPort);
    m_AddressableLEDBuffer = new AddressableLEDBuffer(m_length);
    m_AddressableLED.setLength(m_length);
    m_AddressableLED.start();
    setDamageLevel(1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setDamageLevel(int level) {
    if (level == 0) {
      LEDPattern green = LEDPattern.solid(Color.kGreen);
      green.applyTo(m_AddressableLEDBuffer);
      m_AddressableLED.setData(m_AddressableLEDBuffer);
    }

    if (level == 1) {
      LEDPattern red = LEDPattern.solid(Color.kRed);
      red.applyTo(m_AddressableLEDBuffer);
      m_AddressableLED.setData(m_AddressableLEDBuffer);
    }
  }
}
