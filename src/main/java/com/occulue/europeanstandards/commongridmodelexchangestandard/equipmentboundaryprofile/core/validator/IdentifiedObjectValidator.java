/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class IdentifiedObjectValidator {

  /** default constructor */
  protected IdentifiedObjectValidator() {}

  /** factory method */
  public static IdentifiedObjectValidator getInstance() {
    return new IdentifiedObjectValidator();
  }

  /** handles creation validation for a IdentifiedObject */
  public void validate(CreateIdentifiedObjectCommand identifiedObject) throws Exception {
    Assert.notNull(identifiedObject, "CreateIdentifiedObjectCommand should not be null");
    //		Assert.isNull( identifiedObject.getIdentifiedObjectId(), "CreateIdentifiedObjectCommand
    // identifier should be null" );
  }

  /** handles update validation for a IdentifiedObject */
  public void validate(UpdateIdentifiedObjectCommand identifiedObject) throws Exception {
    Assert.notNull(identifiedObject, "UpdateIdentifiedObjectCommand should not be null");
    Assert.notNull(
        identifiedObject.getIdentifiedObjectId(),
        "UpdateIdentifiedObjectCommand identifier should not be null");
  }

  /** handles delete validation for a IdentifiedObject */
  public void validate(DeleteIdentifiedObjectCommand identifiedObject) throws Exception {
    Assert.notNull(identifiedObject, "{commandAlias} should not be null");
    Assert.notNull(
        identifiedObject.getIdentifiedObjectId(),
        "DeleteIdentifiedObjectCommand identifier should not be null");
  }

  /** handles fetchOne validation for a IdentifiedObject */
  public void validate(IdentifiedObjectFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "IdentifiedObjectFetchOneSummary should not be null");
    Assert.notNull(
        summary.getIdentifiedObjectId(),
        "IdentifiedObjectFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Description validation for a IdentifiedObject
   *
   * @param command AssignDescriptionToIdentifiedObjectCommand
   */
  public void validate(AssignDescriptionToIdentifiedObjectCommand command) throws Exception {
    Assert.notNull(command, "AssignDescriptionToIdentifiedObjectCommand should not be null");
    Assert.notNull(
        command.getIdentifiedObjectId(),
        "AssignDescriptionToIdentifiedObjectCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDescriptionToIdentifiedObjectCommand assignment should not be null");
  }

  /**
   * handles unassign Description validation for a IdentifiedObject
   *
   * @param command UnAssignDescriptionFromIdentifiedObjectCommand
   */
  public void validate(UnAssignDescriptionFromIdentifiedObjectCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDescriptionFromIdentifiedObjectCommand should not be null");
    Assert.notNull(
        command.getIdentifiedObjectId(),
        "UnAssignDescriptionFromIdentifiedObjectCommand identifier should not be null");
  }
  /**
   * handles assign EnergyIdentCodeEic validation for a IdentifiedObject
   *
   * @param command AssignEnergyIdentCodeEicToIdentifiedObjectCommand
   */
  public void validate(AssignEnergyIdentCodeEicToIdentifiedObjectCommand command) throws Exception {
    Assert.notNull(command, "AssignEnergyIdentCodeEicToIdentifiedObjectCommand should not be null");
    Assert.notNull(
        command.getIdentifiedObjectId(),
        "AssignEnergyIdentCodeEicToIdentifiedObjectCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEnergyIdentCodeEicToIdentifiedObjectCommand assignment should not be null");
  }

  /**
   * handles unassign EnergyIdentCodeEic validation for a IdentifiedObject
   *
   * @param command UnAssignEnergyIdentCodeEicFromIdentifiedObjectCommand
   */
  public void validate(UnAssignEnergyIdentCodeEicFromIdentifiedObjectCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignEnergyIdentCodeEicFromIdentifiedObjectCommand should not be null");
    Assert.notNull(
        command.getIdentifiedObjectId(),
        "UnAssignEnergyIdentCodeEicFromIdentifiedObjectCommand identifier should not be null");
  }
  /**
   * handles assign MRID validation for a IdentifiedObject
   *
   * @param command AssignMRIDToIdentifiedObjectCommand
   */
  public void validate(AssignMRIDToIdentifiedObjectCommand command) throws Exception {
    Assert.notNull(command, "AssignMRIDToIdentifiedObjectCommand should not be null");
    Assert.notNull(
        command.getIdentifiedObjectId(),
        "AssignMRIDToIdentifiedObjectCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMRIDToIdentifiedObjectCommand assignment should not be null");
  }

  /**
   * handles unassign MRID validation for a IdentifiedObject
   *
   * @param command UnAssignMRIDFromIdentifiedObjectCommand
   */
  public void validate(UnAssignMRIDFromIdentifiedObjectCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMRIDFromIdentifiedObjectCommand should not be null");
    Assert.notNull(
        command.getIdentifiedObjectId(),
        "UnAssignMRIDFromIdentifiedObjectCommand identifier should not be null");
  }
  /**
   * handles assign Name validation for a IdentifiedObject
   *
   * @param command AssignNameToIdentifiedObjectCommand
   */
  public void validate(AssignNameToIdentifiedObjectCommand command) throws Exception {
    Assert.notNull(command, "AssignNameToIdentifiedObjectCommand should not be null");
    Assert.notNull(
        command.getIdentifiedObjectId(),
        "AssignNameToIdentifiedObjectCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNameToIdentifiedObjectCommand assignment should not be null");
  }

  /**
   * handles unassign Name validation for a IdentifiedObject
   *
   * @param command UnAssignNameFromIdentifiedObjectCommand
   */
  public void validate(UnAssignNameFromIdentifiedObjectCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNameFromIdentifiedObjectCommand should not be null");
    Assert.notNull(
        command.getIdentifiedObjectId(),
        "UnAssignNameFromIdentifiedObjectCommand identifier should not be null");
  }
  /**
   * handles assign ShortName validation for a IdentifiedObject
   *
   * @param command AssignShortNameToIdentifiedObjectCommand
   */
  public void validate(AssignShortNameToIdentifiedObjectCommand command) throws Exception {
    Assert.notNull(command, "AssignShortNameToIdentifiedObjectCommand should not be null");
    Assert.notNull(
        command.getIdentifiedObjectId(),
        "AssignShortNameToIdentifiedObjectCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignShortNameToIdentifiedObjectCommand assignment should not be null");
  }

  /**
   * handles unassign ShortName validation for a IdentifiedObject
   *
   * @param command UnAssignShortNameFromIdentifiedObjectCommand
   */
  public void validate(UnAssignShortNameFromIdentifiedObjectCommand command) throws Exception {
    Assert.notNull(command, "UnAssignShortNameFromIdentifiedObjectCommand should not be null");
    Assert.notNull(
        command.getIdentifiedObjectId(),
        "UnAssignShortNameFromIdentifiedObjectCommand identifier should not be null");
  }
}
