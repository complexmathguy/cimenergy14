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
package com.occulue.europeanstandards.extension.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class ENTSOEIdentifiedObjectValidator {

  /** default constructor */
  protected ENTSOEIdentifiedObjectValidator() {}

  /** factory method */
  public static ENTSOEIdentifiedObjectValidator getInstance() {
    return new ENTSOEIdentifiedObjectValidator();
  }

  /** handles creation validation for a ENTSOEIdentifiedObject */
  public void validate(CreateENTSOEIdentifiedObjectCommand eNTSOEIdentifiedObject)
      throws Exception {
    Assert.notNull(
        eNTSOEIdentifiedObject, "CreateENTSOEIdentifiedObjectCommand should not be null");
    //		Assert.isNull( eNTSOEIdentifiedObject.getENTSOEIdentifiedObjectId(),
    // "CreateENTSOEIdentifiedObjectCommand identifier should be null" );
  }

  /** handles update validation for a ENTSOEIdentifiedObject */
  public void validate(UpdateENTSOEIdentifiedObjectCommand eNTSOEIdentifiedObject)
      throws Exception {
    Assert.notNull(
        eNTSOEIdentifiedObject, "UpdateENTSOEIdentifiedObjectCommand should not be null");
    Assert.notNull(
        eNTSOEIdentifiedObject.getENTSOEIdentifiedObjectId(),
        "UpdateENTSOEIdentifiedObjectCommand identifier should not be null");
  }

  /** handles delete validation for a ENTSOEIdentifiedObject */
  public void validate(DeleteENTSOEIdentifiedObjectCommand eNTSOEIdentifiedObject)
      throws Exception {
    Assert.notNull(eNTSOEIdentifiedObject, "{commandAlias} should not be null");
    Assert.notNull(
        eNTSOEIdentifiedObject.getENTSOEIdentifiedObjectId(),
        "DeleteENTSOEIdentifiedObjectCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ENTSOEIdentifiedObject */
  public void validate(ENTSOEIdentifiedObjectFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ENTSOEIdentifiedObjectFetchOneSummary should not be null");
    Assert.notNull(
        summary.getENTSOEIdentifiedObjectId(),
        "ENTSOEIdentifiedObjectFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign EnergyIdentCodeEic validation for a ENTSOEIdentifiedObject
   *
   * @param command AssignEnergyIdentCodeEicToENTSOEIdentifiedObjectCommand
   */
  public void validate(AssignEnergyIdentCodeEicToENTSOEIdentifiedObjectCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignEnergyIdentCodeEicToENTSOEIdentifiedObjectCommand should not be null");
    Assert.notNull(
        command.getENTSOEIdentifiedObjectId(),
        "AssignEnergyIdentCodeEicToENTSOEIdentifiedObjectCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEnergyIdentCodeEicToENTSOEIdentifiedObjectCommand assignment should not be null");
  }

  /**
   * handles unassign EnergyIdentCodeEic validation for a ENTSOEIdentifiedObject
   *
   * @param command UnAssignEnergyIdentCodeEicFromENTSOEIdentifiedObjectCommand
   */
  public void validate(UnAssignEnergyIdentCodeEicFromENTSOEIdentifiedObjectCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignEnergyIdentCodeEicFromENTSOEIdentifiedObjectCommand should not be null");
    Assert.notNull(
        command.getENTSOEIdentifiedObjectId(),
        "UnAssignEnergyIdentCodeEicFromENTSOEIdentifiedObjectCommand identifier should not be null");
  }
  /**
   * handles assign ShortName validation for a ENTSOEIdentifiedObject
   *
   * @param command AssignShortNameToENTSOEIdentifiedObjectCommand
   */
  public void validate(AssignShortNameToENTSOEIdentifiedObjectCommand command) throws Exception {
    Assert.notNull(command, "AssignShortNameToENTSOEIdentifiedObjectCommand should not be null");
    Assert.notNull(
        command.getENTSOEIdentifiedObjectId(),
        "AssignShortNameToENTSOEIdentifiedObjectCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignShortNameToENTSOEIdentifiedObjectCommand assignment should not be null");
  }

  /**
   * handles unassign ShortName validation for a ENTSOEIdentifiedObject
   *
   * @param command UnAssignShortNameFromENTSOEIdentifiedObjectCommand
   */
  public void validate(UnAssignShortNameFromENTSOEIdentifiedObjectCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignShortNameFromENTSOEIdentifiedObjectCommand should not be null");
    Assert.notNull(
        command.getENTSOEIdentifiedObjectId(),
        "UnAssignShortNameFromENTSOEIdentifiedObjectCommand identifier should not be null");
  }
}
