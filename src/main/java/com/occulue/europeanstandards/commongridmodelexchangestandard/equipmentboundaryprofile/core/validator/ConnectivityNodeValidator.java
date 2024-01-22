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

public class ConnectivityNodeValidator {

  /** default constructor */
  protected ConnectivityNodeValidator() {}

  /** factory method */
  public static ConnectivityNodeValidator getInstance() {
    return new ConnectivityNodeValidator();
  }

  /** handles creation validation for a ConnectivityNode */
  public void validate(CreateConnectivityNodeCommand connectivityNode) throws Exception {
    Assert.notNull(connectivityNode, "CreateConnectivityNodeCommand should not be null");
    //		Assert.isNull( connectivityNode.getConnectivityNodeId(), "CreateConnectivityNodeCommand
    // identifier should be null" );
  }

  /** handles update validation for a ConnectivityNode */
  public void validate(UpdateConnectivityNodeCommand connectivityNode) throws Exception {
    Assert.notNull(connectivityNode, "UpdateConnectivityNodeCommand should not be null");
    Assert.notNull(
        connectivityNode.getConnectivityNodeId(),
        "UpdateConnectivityNodeCommand identifier should not be null");
  }

  /** handles delete validation for a ConnectivityNode */
  public void validate(DeleteConnectivityNodeCommand connectivityNode) throws Exception {
    Assert.notNull(connectivityNode, "{commandAlias} should not be null");
    Assert.notNull(
        connectivityNode.getConnectivityNodeId(),
        "DeleteConnectivityNodeCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ConnectivityNode */
  public void validate(ConnectivityNodeFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ConnectivityNodeFetchOneSummary should not be null");
    Assert.notNull(
        summary.getConnectivityNodeId(),
        "ConnectivityNodeFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign BoundaryPoint validation for a ConnectivityNode
   *
   * @param command AssignBoundaryPointToConnectivityNodeCommand
   */
  public void validate(AssignBoundaryPointToConnectivityNodeCommand command) throws Exception {
    Assert.notNull(command, "AssignBoundaryPointToConnectivityNodeCommand should not be null");
    Assert.notNull(
        command.getConnectivityNodeId(),
        "AssignBoundaryPointToConnectivityNodeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBoundaryPointToConnectivityNodeCommand assignment should not be null");
  }

  /**
   * handles unassign BoundaryPoint validation for a ConnectivityNode
   *
   * @param command UnAssignBoundaryPointFromConnectivityNodeCommand
   */
  public void validate(UnAssignBoundaryPointFromConnectivityNodeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBoundaryPointFromConnectivityNodeCommand should not be null");
    Assert.notNull(
        command.getConnectivityNodeId(),
        "UnAssignBoundaryPointFromConnectivityNodeCommand identifier should not be null");
  }
  /**
   * handles assign FromEndIsoCode validation for a ConnectivityNode
   *
   * @param command AssignFromEndIsoCodeToConnectivityNodeCommand
   */
  public void validate(AssignFromEndIsoCodeToConnectivityNodeCommand command) throws Exception {
    Assert.notNull(command, "AssignFromEndIsoCodeToConnectivityNodeCommand should not be null");
    Assert.notNull(
        command.getConnectivityNodeId(),
        "AssignFromEndIsoCodeToConnectivityNodeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignFromEndIsoCodeToConnectivityNodeCommand assignment should not be null");
  }

  /**
   * handles unassign FromEndIsoCode validation for a ConnectivityNode
   *
   * @param command UnAssignFromEndIsoCodeFromConnectivityNodeCommand
   */
  public void validate(UnAssignFromEndIsoCodeFromConnectivityNodeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFromEndIsoCodeFromConnectivityNodeCommand should not be null");
    Assert.notNull(
        command.getConnectivityNodeId(),
        "UnAssignFromEndIsoCodeFromConnectivityNodeCommand identifier should not be null");
  }
  /**
   * handles assign FromEndName validation for a ConnectivityNode
   *
   * @param command AssignFromEndNameToConnectivityNodeCommand
   */
  public void validate(AssignFromEndNameToConnectivityNodeCommand command) throws Exception {
    Assert.notNull(command, "AssignFromEndNameToConnectivityNodeCommand should not be null");
    Assert.notNull(
        command.getConnectivityNodeId(),
        "AssignFromEndNameToConnectivityNodeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignFromEndNameToConnectivityNodeCommand assignment should not be null");
  }

  /**
   * handles unassign FromEndName validation for a ConnectivityNode
   *
   * @param command UnAssignFromEndNameFromConnectivityNodeCommand
   */
  public void validate(UnAssignFromEndNameFromConnectivityNodeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFromEndNameFromConnectivityNodeCommand should not be null");
    Assert.notNull(
        command.getConnectivityNodeId(),
        "UnAssignFromEndNameFromConnectivityNodeCommand identifier should not be null");
  }
  /**
   * handles assign FromEndNameTso validation for a ConnectivityNode
   *
   * @param command AssignFromEndNameTsoToConnectivityNodeCommand
   */
  public void validate(AssignFromEndNameTsoToConnectivityNodeCommand command) throws Exception {
    Assert.notNull(command, "AssignFromEndNameTsoToConnectivityNodeCommand should not be null");
    Assert.notNull(
        command.getConnectivityNodeId(),
        "AssignFromEndNameTsoToConnectivityNodeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignFromEndNameTsoToConnectivityNodeCommand assignment should not be null");
  }

  /**
   * handles unassign FromEndNameTso validation for a ConnectivityNode
   *
   * @param command UnAssignFromEndNameTsoFromConnectivityNodeCommand
   */
  public void validate(UnAssignFromEndNameTsoFromConnectivityNodeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFromEndNameTsoFromConnectivityNodeCommand should not be null");
    Assert.notNull(
        command.getConnectivityNodeId(),
        "UnAssignFromEndNameTsoFromConnectivityNodeCommand identifier should not be null");
  }
  /**
   * handles assign ToEndIsoCode validation for a ConnectivityNode
   *
   * @param command AssignToEndIsoCodeToConnectivityNodeCommand
   */
  public void validate(AssignToEndIsoCodeToConnectivityNodeCommand command) throws Exception {
    Assert.notNull(command, "AssignToEndIsoCodeToConnectivityNodeCommand should not be null");
    Assert.notNull(
        command.getConnectivityNodeId(),
        "AssignToEndIsoCodeToConnectivityNodeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignToEndIsoCodeToConnectivityNodeCommand assignment should not be null");
  }

  /**
   * handles unassign ToEndIsoCode validation for a ConnectivityNode
   *
   * @param command UnAssignToEndIsoCodeFromConnectivityNodeCommand
   */
  public void validate(UnAssignToEndIsoCodeFromConnectivityNodeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignToEndIsoCodeFromConnectivityNodeCommand should not be null");
    Assert.notNull(
        command.getConnectivityNodeId(),
        "UnAssignToEndIsoCodeFromConnectivityNodeCommand identifier should not be null");
  }
  /**
   * handles assign ToEndName validation for a ConnectivityNode
   *
   * @param command AssignToEndNameToConnectivityNodeCommand
   */
  public void validate(AssignToEndNameToConnectivityNodeCommand command) throws Exception {
    Assert.notNull(command, "AssignToEndNameToConnectivityNodeCommand should not be null");
    Assert.notNull(
        command.getConnectivityNodeId(),
        "AssignToEndNameToConnectivityNodeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignToEndNameToConnectivityNodeCommand assignment should not be null");
  }

  /**
   * handles unassign ToEndName validation for a ConnectivityNode
   *
   * @param command UnAssignToEndNameFromConnectivityNodeCommand
   */
  public void validate(UnAssignToEndNameFromConnectivityNodeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignToEndNameFromConnectivityNodeCommand should not be null");
    Assert.notNull(
        command.getConnectivityNodeId(),
        "UnAssignToEndNameFromConnectivityNodeCommand identifier should not be null");
  }
  /**
   * handles assign ToEndNameTso validation for a ConnectivityNode
   *
   * @param command AssignToEndNameTsoToConnectivityNodeCommand
   */
  public void validate(AssignToEndNameTsoToConnectivityNodeCommand command) throws Exception {
    Assert.notNull(command, "AssignToEndNameTsoToConnectivityNodeCommand should not be null");
    Assert.notNull(
        command.getConnectivityNodeId(),
        "AssignToEndNameTsoToConnectivityNodeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignToEndNameTsoToConnectivityNodeCommand assignment should not be null");
  }

  /**
   * handles unassign ToEndNameTso validation for a ConnectivityNode
   *
   * @param command UnAssignToEndNameTsoFromConnectivityNodeCommand
   */
  public void validate(UnAssignToEndNameTsoFromConnectivityNodeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignToEndNameTsoFromConnectivityNodeCommand should not be null");
    Assert.notNull(
        command.getConnectivityNodeId(),
        "UnAssignToEndNameTsoFromConnectivityNodeCommand identifier should not be null");
  }

  /**
   * handles add to ConnectivityNodes validation for a ConnectivityNode
   *
   * @param command AssignConnectivityNodesToConnectivityNodeCommand
   */
  public void validate(AssignConnectivityNodesToConnectivityNodeCommand command) throws Exception {
    Assert.notNull(command, "AssignConnectivityNodesToConnectivityNodeCommand should not be null");
    Assert.notNull(
        command.getConnectivityNodeId(),
        "AssignConnectivityNodesToConnectivityNodeCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignConnectivityNodesToConnectivityNodeCommand addTo attribute should not be null");
  }

  /**
   * handles remove from ConnectivityNodes validation for a ConnectivityNode
   *
   * @param command RemoveConnectivityNodesFromConnectivityNodeCommand
   */
  public void validate(RemoveConnectivityNodesFromConnectivityNodeCommand command)
      throws Exception {
    Assert.notNull(
        command, "RemoveConnectivityNodesFromConnectivityNodeCommand should not be null");
    Assert.notNull(
        command.getConnectivityNodeId(),
        "RemoveConnectivityNodesFromConnectivityNodeCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveConnectivityNodesFromConnectivityNodeCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getConnectivityNodeId(),
        "RemoveConnectivityNodesFromConnectivityNodeCommand removeFrom attribubte identifier should not be null");
  }
}
