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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class TransformerEndValidator {

  /** default constructor */
  protected TransformerEndValidator() {}

  /** factory method */
  public static TransformerEndValidator getInstance() {
    return new TransformerEndValidator();
  }

  /** handles creation validation for a TransformerEnd */
  public void validate(CreateTransformerEndCommand transformerEnd) throws Exception {
    Assert.notNull(transformerEnd, "CreateTransformerEndCommand should not be null");
    //		Assert.isNull( transformerEnd.getTransformerEndId(), "CreateTransformerEndCommand identifier
    // should be null" );
  }

  /** handles update validation for a TransformerEnd */
  public void validate(UpdateTransformerEndCommand transformerEnd) throws Exception {
    Assert.notNull(transformerEnd, "UpdateTransformerEndCommand should not be null");
    Assert.notNull(
        transformerEnd.getTransformerEndId(),
        "UpdateTransformerEndCommand identifier should not be null");
  }

  /** handles delete validation for a TransformerEnd */
  public void validate(DeleteTransformerEndCommand transformerEnd) throws Exception {
    Assert.notNull(transformerEnd, "{commandAlias} should not be null");
    Assert.notNull(
        transformerEnd.getTransformerEndId(),
        "DeleteTransformerEndCommand identifier should not be null");
  }

  /** handles fetchOne validation for a TransformerEnd */
  public void validate(TransformerEndFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "TransformerEndFetchOneSummary should not be null");
    Assert.notNull(
        summary.getTransformerEndId(),
        "TransformerEndFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign EndNumber validation for a TransformerEnd
   *
   * @param command AssignEndNumberToTransformerEndCommand
   */
  public void validate(AssignEndNumberToTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "AssignEndNumberToTransformerEndCommand should not be null");
    Assert.notNull(
        command.getTransformerEndId(),
        "AssignEndNumberToTransformerEndCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEndNumberToTransformerEndCommand assignment should not be null");
  }

  /**
   * handles unassign EndNumber validation for a TransformerEnd
   *
   * @param command UnAssignEndNumberFromTransformerEndCommand
   */
  public void validate(UnAssignEndNumberFromTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEndNumberFromTransformerEndCommand should not be null");
    Assert.notNull(
        command.getTransformerEndId(),
        "UnAssignEndNumberFromTransformerEndCommand identifier should not be null");
  }
  /**
   * handles assign Grounded validation for a TransformerEnd
   *
   * @param command AssignGroundedToTransformerEndCommand
   */
  public void validate(AssignGroundedToTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "AssignGroundedToTransformerEndCommand should not be null");
    Assert.notNull(
        command.getTransformerEndId(),
        "AssignGroundedToTransformerEndCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignGroundedToTransformerEndCommand assignment should not be null");
  }

  /**
   * handles unassign Grounded validation for a TransformerEnd
   *
   * @param command UnAssignGroundedFromTransformerEndCommand
   */
  public void validate(UnAssignGroundedFromTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGroundedFromTransformerEndCommand should not be null");
    Assert.notNull(
        command.getTransformerEndId(),
        "UnAssignGroundedFromTransformerEndCommand identifier should not be null");
  }
  /**
   * handles assign Rground validation for a TransformerEnd
   *
   * @param command AssignRgroundToTransformerEndCommand
   */
  public void validate(AssignRgroundToTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "AssignRgroundToTransformerEndCommand should not be null");
    Assert.notNull(
        command.getTransformerEndId(),
        "AssignRgroundToTransformerEndCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRgroundToTransformerEndCommand assignment should not be null");
  }

  /**
   * handles unassign Rground validation for a TransformerEnd
   *
   * @param command UnAssignRgroundFromTransformerEndCommand
   */
  public void validate(UnAssignRgroundFromTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRgroundFromTransformerEndCommand should not be null");
    Assert.notNull(
        command.getTransformerEndId(),
        "UnAssignRgroundFromTransformerEndCommand identifier should not be null");
  }
  /**
   * handles assign Xground validation for a TransformerEnd
   *
   * @param command AssignXgroundToTransformerEndCommand
   */
  public void validate(AssignXgroundToTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "AssignXgroundToTransformerEndCommand should not be null");
    Assert.notNull(
        command.getTransformerEndId(),
        "AssignXgroundToTransformerEndCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXgroundToTransformerEndCommand assignment should not be null");
  }

  /**
   * handles unassign Xground validation for a TransformerEnd
   *
   * @param command UnAssignXgroundFromTransformerEndCommand
   */
  public void validate(UnAssignXgroundFromTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXgroundFromTransformerEndCommand should not be null");
    Assert.notNull(
        command.getTransformerEndId(),
        "UnAssignXgroundFromTransformerEndCommand identifier should not be null");
  }

  /**
   * handles add to TransformerEnds validation for a TransformerEnd
   *
   * @param command AssignTransformerEndsToTransformerEndCommand
   */
  public void validate(AssignTransformerEndsToTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "AssignTransformerEndsToTransformerEndCommand should not be null");
    Assert.notNull(
        command.getTransformerEndId(),
        "AssignTransformerEndsToTransformerEndCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignTransformerEndsToTransformerEndCommand addTo attribute should not be null");
  }

  /**
   * handles remove from TransformerEnds validation for a TransformerEnd
   *
   * @param command RemoveTransformerEndsFromTransformerEndCommand
   */
  public void validate(RemoveTransformerEndsFromTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "RemoveTransformerEndsFromTransformerEndCommand should not be null");
    Assert.notNull(
        command.getTransformerEndId(),
        "RemoveTransformerEndsFromTransformerEndCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveTransformerEndsFromTransformerEndCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getTransformerEndId(),
        "RemoveTransformerEndsFromTransformerEndCommand removeFrom attribubte identifier should not be null");
  }

  /**
   * handles add to TransformerEnd validation for a TransformerEnd
   *
   * @param command AssignTransformerEndToTransformerEndCommand
   */
  public void validate(AssignTransformerEndToTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "AssignTransformerEndToTransformerEndCommand should not be null");
    Assert.notNull(
        command.getTransformerEndId(),
        "AssignTransformerEndToTransformerEndCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignTransformerEndToTransformerEndCommand addTo attribute should not be null");
  }

  /**
   * handles remove from TransformerEnd validation for a TransformerEnd
   *
   * @param command RemoveTransformerEndFromTransformerEndCommand
   */
  public void validate(RemoveTransformerEndFromTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "RemoveTransformerEndFromTransformerEndCommand should not be null");
    Assert.notNull(
        command.getTransformerEndId(),
        "RemoveTransformerEndFromTransformerEndCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveTransformerEndFromTransformerEndCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getTransformerEndId(),
        "RemoveTransformerEndFromTransformerEndCommand removeFrom attribubte identifier should not be null");
  }
}
