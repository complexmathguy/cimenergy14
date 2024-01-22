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

public class BoundaryExtensionsValidator {

  /** default constructor */
  protected BoundaryExtensionsValidator() {}

  /** factory method */
  public static BoundaryExtensionsValidator getInstance() {
    return new BoundaryExtensionsValidator();
  }

  /** handles creation validation for a BoundaryExtensions */
  public void validate(CreateBoundaryExtensionsCommand boundaryExtensions) throws Exception {
    Assert.notNull(boundaryExtensions, "CreateBoundaryExtensionsCommand should not be null");
    //		Assert.isNull( boundaryExtensions.getBoundaryExtensionsId(),
    // "CreateBoundaryExtensionsCommand identifier should be null" );
  }

  /** handles update validation for a BoundaryExtensions */
  public void validate(UpdateBoundaryExtensionsCommand boundaryExtensions) throws Exception {
    Assert.notNull(boundaryExtensions, "UpdateBoundaryExtensionsCommand should not be null");
    Assert.notNull(
        boundaryExtensions.getBoundaryExtensionsId(),
        "UpdateBoundaryExtensionsCommand identifier should not be null");
  }

  /** handles delete validation for a BoundaryExtensions */
  public void validate(DeleteBoundaryExtensionsCommand boundaryExtensions) throws Exception {
    Assert.notNull(boundaryExtensions, "{commandAlias} should not be null");
    Assert.notNull(
        boundaryExtensions.getBoundaryExtensionsId(),
        "DeleteBoundaryExtensionsCommand identifier should not be null");
  }

  /** handles fetchOne validation for a BoundaryExtensions */
  public void validate(BoundaryExtensionsFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "BoundaryExtensionsFetchOneSummary should not be null");
    Assert.notNull(
        summary.getBoundaryExtensionsId(),
        "BoundaryExtensionsFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign BoundaryPoint validation for a BoundaryExtensions
   *
   * @param command AssignBoundaryPointToBoundaryExtensionsCommand
   */
  public void validate(AssignBoundaryPointToBoundaryExtensionsCommand command) throws Exception {
    Assert.notNull(command, "AssignBoundaryPointToBoundaryExtensionsCommand should not be null");
    Assert.notNull(
        command.getBoundaryExtensionsId(),
        "AssignBoundaryPointToBoundaryExtensionsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBoundaryPointToBoundaryExtensionsCommand assignment should not be null");
  }

  /**
   * handles unassign BoundaryPoint validation for a BoundaryExtensions
   *
   * @param command UnAssignBoundaryPointFromBoundaryExtensionsCommand
   */
  public void validate(UnAssignBoundaryPointFromBoundaryExtensionsCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignBoundaryPointFromBoundaryExtensionsCommand should not be null");
    Assert.notNull(
        command.getBoundaryExtensionsId(),
        "UnAssignBoundaryPointFromBoundaryExtensionsCommand identifier should not be null");
  }
  /**
   * handles assign FromEndIsoCode validation for a BoundaryExtensions
   *
   * @param command AssignFromEndIsoCodeToBoundaryExtensionsCommand
   */
  public void validate(AssignFromEndIsoCodeToBoundaryExtensionsCommand command) throws Exception {
    Assert.notNull(command, "AssignFromEndIsoCodeToBoundaryExtensionsCommand should not be null");
    Assert.notNull(
        command.getBoundaryExtensionsId(),
        "AssignFromEndIsoCodeToBoundaryExtensionsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignFromEndIsoCodeToBoundaryExtensionsCommand assignment should not be null");
  }

  /**
   * handles unassign FromEndIsoCode validation for a BoundaryExtensions
   *
   * @param command UnAssignFromEndIsoCodeFromBoundaryExtensionsCommand
   */
  public void validate(UnAssignFromEndIsoCodeFromBoundaryExtensionsCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignFromEndIsoCodeFromBoundaryExtensionsCommand should not be null");
    Assert.notNull(
        command.getBoundaryExtensionsId(),
        "UnAssignFromEndIsoCodeFromBoundaryExtensionsCommand identifier should not be null");
  }
  /**
   * handles assign FromEndName validation for a BoundaryExtensions
   *
   * @param command AssignFromEndNameToBoundaryExtensionsCommand
   */
  public void validate(AssignFromEndNameToBoundaryExtensionsCommand command) throws Exception {
    Assert.notNull(command, "AssignFromEndNameToBoundaryExtensionsCommand should not be null");
    Assert.notNull(
        command.getBoundaryExtensionsId(),
        "AssignFromEndNameToBoundaryExtensionsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignFromEndNameToBoundaryExtensionsCommand assignment should not be null");
  }

  /**
   * handles unassign FromEndName validation for a BoundaryExtensions
   *
   * @param command UnAssignFromEndNameFromBoundaryExtensionsCommand
   */
  public void validate(UnAssignFromEndNameFromBoundaryExtensionsCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFromEndNameFromBoundaryExtensionsCommand should not be null");
    Assert.notNull(
        command.getBoundaryExtensionsId(),
        "UnAssignFromEndNameFromBoundaryExtensionsCommand identifier should not be null");
  }
  /**
   * handles assign FromEndNameTso validation for a BoundaryExtensions
   *
   * @param command AssignFromEndNameTsoToBoundaryExtensionsCommand
   */
  public void validate(AssignFromEndNameTsoToBoundaryExtensionsCommand command) throws Exception {
    Assert.notNull(command, "AssignFromEndNameTsoToBoundaryExtensionsCommand should not be null");
    Assert.notNull(
        command.getBoundaryExtensionsId(),
        "AssignFromEndNameTsoToBoundaryExtensionsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignFromEndNameTsoToBoundaryExtensionsCommand assignment should not be null");
  }

  /**
   * handles unassign FromEndNameTso validation for a BoundaryExtensions
   *
   * @param command UnAssignFromEndNameTsoFromBoundaryExtensionsCommand
   */
  public void validate(UnAssignFromEndNameTsoFromBoundaryExtensionsCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignFromEndNameTsoFromBoundaryExtensionsCommand should not be null");
    Assert.notNull(
        command.getBoundaryExtensionsId(),
        "UnAssignFromEndNameTsoFromBoundaryExtensionsCommand identifier should not be null");
  }
  /**
   * handles assign ToEndIsoCode validation for a BoundaryExtensions
   *
   * @param command AssignToEndIsoCodeToBoundaryExtensionsCommand
   */
  public void validate(AssignToEndIsoCodeToBoundaryExtensionsCommand command) throws Exception {
    Assert.notNull(command, "AssignToEndIsoCodeToBoundaryExtensionsCommand should not be null");
    Assert.notNull(
        command.getBoundaryExtensionsId(),
        "AssignToEndIsoCodeToBoundaryExtensionsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignToEndIsoCodeToBoundaryExtensionsCommand assignment should not be null");
  }

  /**
   * handles unassign ToEndIsoCode validation for a BoundaryExtensions
   *
   * @param command UnAssignToEndIsoCodeFromBoundaryExtensionsCommand
   */
  public void validate(UnAssignToEndIsoCodeFromBoundaryExtensionsCommand command) throws Exception {
    Assert.notNull(command, "UnAssignToEndIsoCodeFromBoundaryExtensionsCommand should not be null");
    Assert.notNull(
        command.getBoundaryExtensionsId(),
        "UnAssignToEndIsoCodeFromBoundaryExtensionsCommand identifier should not be null");
  }
  /**
   * handles assign ToEndName validation for a BoundaryExtensions
   *
   * @param command AssignToEndNameToBoundaryExtensionsCommand
   */
  public void validate(AssignToEndNameToBoundaryExtensionsCommand command) throws Exception {
    Assert.notNull(command, "AssignToEndNameToBoundaryExtensionsCommand should not be null");
    Assert.notNull(
        command.getBoundaryExtensionsId(),
        "AssignToEndNameToBoundaryExtensionsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignToEndNameToBoundaryExtensionsCommand assignment should not be null");
  }

  /**
   * handles unassign ToEndName validation for a BoundaryExtensions
   *
   * @param command UnAssignToEndNameFromBoundaryExtensionsCommand
   */
  public void validate(UnAssignToEndNameFromBoundaryExtensionsCommand command) throws Exception {
    Assert.notNull(command, "UnAssignToEndNameFromBoundaryExtensionsCommand should not be null");
    Assert.notNull(
        command.getBoundaryExtensionsId(),
        "UnAssignToEndNameFromBoundaryExtensionsCommand identifier should not be null");
  }
  /**
   * handles assign ToEndNameTso validation for a BoundaryExtensions
   *
   * @param command AssignToEndNameTsoToBoundaryExtensionsCommand
   */
  public void validate(AssignToEndNameTsoToBoundaryExtensionsCommand command) throws Exception {
    Assert.notNull(command, "AssignToEndNameTsoToBoundaryExtensionsCommand should not be null");
    Assert.notNull(
        command.getBoundaryExtensionsId(),
        "AssignToEndNameTsoToBoundaryExtensionsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignToEndNameTsoToBoundaryExtensionsCommand assignment should not be null");
  }

  /**
   * handles unassign ToEndNameTso validation for a BoundaryExtensions
   *
   * @param command UnAssignToEndNameTsoFromBoundaryExtensionsCommand
   */
  public void validate(UnAssignToEndNameTsoFromBoundaryExtensionsCommand command) throws Exception {
    Assert.notNull(command, "UnAssignToEndNameTsoFromBoundaryExtensionsCommand should not be null");
    Assert.notNull(
        command.getBoundaryExtensionsId(),
        "UnAssignToEndNameTsoFromBoundaryExtensionsCommand identifier should not be null");
  }
}
