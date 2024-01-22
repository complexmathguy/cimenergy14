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
package com.occulue.europeanstandards.commongridmodelexchangestandard.topologyboundaryprofile.topology.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class TopologicalNodeValidator {

  /** default constructor */
  protected TopologicalNodeValidator() {}

  /** factory method */
  public static TopologicalNodeValidator getInstance() {
    return new TopologicalNodeValidator();
  }

  /** handles creation validation for a TopologicalNode */
  public void validate(CreateTopologicalNodeCommand topologicalNode) throws Exception {
    Assert.notNull(topologicalNode, "CreateTopologicalNodeCommand should not be null");
    //		Assert.isNull( topologicalNode.getTopologicalNodeId(), "CreateTopologicalNodeCommand
    // identifier should be null" );
  }

  /** handles update validation for a TopologicalNode */
  public void validate(UpdateTopologicalNodeCommand topologicalNode) throws Exception {
    Assert.notNull(topologicalNode, "UpdateTopologicalNodeCommand should not be null");
    Assert.notNull(
        topologicalNode.getTopologicalNodeId(),
        "UpdateTopologicalNodeCommand identifier should not be null");
  }

  /** handles delete validation for a TopologicalNode */
  public void validate(DeleteTopologicalNodeCommand topologicalNode) throws Exception {
    Assert.notNull(topologicalNode, "{commandAlias} should not be null");
    Assert.notNull(
        topologicalNode.getTopologicalNodeId(),
        "DeleteTopologicalNodeCommand identifier should not be null");
  }

  /** handles fetchOne validation for a TopologicalNode */
  public void validate(TopologicalNodeFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "TopologicalNodeFetchOneSummary should not be null");
    Assert.notNull(
        summary.getTopologicalNodeId(),
        "TopologicalNodeFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign BoundaryPoint validation for a TopologicalNode
   *
   * @param command AssignBoundaryPointToTopologicalNodeCommand
   */
  public void validate(AssignBoundaryPointToTopologicalNodeCommand command) throws Exception {
    Assert.notNull(command, "AssignBoundaryPointToTopologicalNodeCommand should not be null");
    Assert.notNull(
        command.getTopologicalNodeId(),
        "AssignBoundaryPointToTopologicalNodeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBoundaryPointToTopologicalNodeCommand assignment should not be null");
  }

  /**
   * handles unassign BoundaryPoint validation for a TopologicalNode
   *
   * @param command UnAssignBoundaryPointFromTopologicalNodeCommand
   */
  public void validate(UnAssignBoundaryPointFromTopologicalNodeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBoundaryPointFromTopologicalNodeCommand should not be null");
    Assert.notNull(
        command.getTopologicalNodeId(),
        "UnAssignBoundaryPointFromTopologicalNodeCommand identifier should not be null");
  }
  /**
   * handles assign FromEndIsoCode validation for a TopologicalNode
   *
   * @param command AssignFromEndIsoCodeToTopologicalNodeCommand
   */
  public void validate(AssignFromEndIsoCodeToTopologicalNodeCommand command) throws Exception {
    Assert.notNull(command, "AssignFromEndIsoCodeToTopologicalNodeCommand should not be null");
    Assert.notNull(
        command.getTopologicalNodeId(),
        "AssignFromEndIsoCodeToTopologicalNodeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignFromEndIsoCodeToTopologicalNodeCommand assignment should not be null");
  }

  /**
   * handles unassign FromEndIsoCode validation for a TopologicalNode
   *
   * @param command UnAssignFromEndIsoCodeFromTopologicalNodeCommand
   */
  public void validate(UnAssignFromEndIsoCodeFromTopologicalNodeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFromEndIsoCodeFromTopologicalNodeCommand should not be null");
    Assert.notNull(
        command.getTopologicalNodeId(),
        "UnAssignFromEndIsoCodeFromTopologicalNodeCommand identifier should not be null");
  }
  /**
   * handles assign FromEndName validation for a TopologicalNode
   *
   * @param command AssignFromEndNameToTopologicalNodeCommand
   */
  public void validate(AssignFromEndNameToTopologicalNodeCommand command) throws Exception {
    Assert.notNull(command, "AssignFromEndNameToTopologicalNodeCommand should not be null");
    Assert.notNull(
        command.getTopologicalNodeId(),
        "AssignFromEndNameToTopologicalNodeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignFromEndNameToTopologicalNodeCommand assignment should not be null");
  }

  /**
   * handles unassign FromEndName validation for a TopologicalNode
   *
   * @param command UnAssignFromEndNameFromTopologicalNodeCommand
   */
  public void validate(UnAssignFromEndNameFromTopologicalNodeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFromEndNameFromTopologicalNodeCommand should not be null");
    Assert.notNull(
        command.getTopologicalNodeId(),
        "UnAssignFromEndNameFromTopologicalNodeCommand identifier should not be null");
  }
  /**
   * handles assign FromEndNameTso validation for a TopologicalNode
   *
   * @param command AssignFromEndNameTsoToTopologicalNodeCommand
   */
  public void validate(AssignFromEndNameTsoToTopologicalNodeCommand command) throws Exception {
    Assert.notNull(command, "AssignFromEndNameTsoToTopologicalNodeCommand should not be null");
    Assert.notNull(
        command.getTopologicalNodeId(),
        "AssignFromEndNameTsoToTopologicalNodeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignFromEndNameTsoToTopologicalNodeCommand assignment should not be null");
  }

  /**
   * handles unassign FromEndNameTso validation for a TopologicalNode
   *
   * @param command UnAssignFromEndNameTsoFromTopologicalNodeCommand
   */
  public void validate(UnAssignFromEndNameTsoFromTopologicalNodeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFromEndNameTsoFromTopologicalNodeCommand should not be null");
    Assert.notNull(
        command.getTopologicalNodeId(),
        "UnAssignFromEndNameTsoFromTopologicalNodeCommand identifier should not be null");
  }
  /**
   * handles assign ToEndIsoCode validation for a TopologicalNode
   *
   * @param command AssignToEndIsoCodeToTopologicalNodeCommand
   */
  public void validate(AssignToEndIsoCodeToTopologicalNodeCommand command) throws Exception {
    Assert.notNull(command, "AssignToEndIsoCodeToTopologicalNodeCommand should not be null");
    Assert.notNull(
        command.getTopologicalNodeId(),
        "AssignToEndIsoCodeToTopologicalNodeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignToEndIsoCodeToTopologicalNodeCommand assignment should not be null");
  }

  /**
   * handles unassign ToEndIsoCode validation for a TopologicalNode
   *
   * @param command UnAssignToEndIsoCodeFromTopologicalNodeCommand
   */
  public void validate(UnAssignToEndIsoCodeFromTopologicalNodeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignToEndIsoCodeFromTopologicalNodeCommand should not be null");
    Assert.notNull(
        command.getTopologicalNodeId(),
        "UnAssignToEndIsoCodeFromTopologicalNodeCommand identifier should not be null");
  }
  /**
   * handles assign ToEndName validation for a TopologicalNode
   *
   * @param command AssignToEndNameToTopologicalNodeCommand
   */
  public void validate(AssignToEndNameToTopologicalNodeCommand command) throws Exception {
    Assert.notNull(command, "AssignToEndNameToTopologicalNodeCommand should not be null");
    Assert.notNull(
        command.getTopologicalNodeId(),
        "AssignToEndNameToTopologicalNodeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignToEndNameToTopologicalNodeCommand assignment should not be null");
  }

  /**
   * handles unassign ToEndName validation for a TopologicalNode
   *
   * @param command UnAssignToEndNameFromTopologicalNodeCommand
   */
  public void validate(UnAssignToEndNameFromTopologicalNodeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignToEndNameFromTopologicalNodeCommand should not be null");
    Assert.notNull(
        command.getTopologicalNodeId(),
        "UnAssignToEndNameFromTopologicalNodeCommand identifier should not be null");
  }
  /**
   * handles assign ToEndNameTso validation for a TopologicalNode
   *
   * @param command AssignToEndNameTsoToTopologicalNodeCommand
   */
  public void validate(AssignToEndNameTsoToTopologicalNodeCommand command) throws Exception {
    Assert.notNull(command, "AssignToEndNameTsoToTopologicalNodeCommand should not be null");
    Assert.notNull(
        command.getTopologicalNodeId(),
        "AssignToEndNameTsoToTopologicalNodeCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignToEndNameTsoToTopologicalNodeCommand assignment should not be null");
  }

  /**
   * handles unassign ToEndNameTso validation for a TopologicalNode
   *
   * @param command UnAssignToEndNameTsoFromTopologicalNodeCommand
   */
  public void validate(UnAssignToEndNameTsoFromTopologicalNodeCommand command) throws Exception {
    Assert.notNull(command, "UnAssignToEndNameTsoFromTopologicalNodeCommand should not be null");
    Assert.notNull(
        command.getTopologicalNodeId(),
        "UnAssignToEndNameTsoFromTopologicalNodeCommand identifier should not be null");
  }

  /**
   * handles add to TopologicalNode validation for a TopologicalNode
   *
   * @param command AssignTopologicalNodeToTopologicalNodeCommand
   */
  public void validate(AssignTopologicalNodeToTopologicalNodeCommand command) throws Exception {
    Assert.notNull(command, "AssignTopologicalNodeToTopologicalNodeCommand should not be null");
    Assert.notNull(
        command.getTopologicalNodeId(),
        "AssignTopologicalNodeToTopologicalNodeCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignTopologicalNodeToTopologicalNodeCommand addTo attribute should not be null");
  }

  /**
   * handles remove from TopologicalNode validation for a TopologicalNode
   *
   * @param command RemoveTopologicalNodeFromTopologicalNodeCommand
   */
  public void validate(RemoveTopologicalNodeFromTopologicalNodeCommand command) throws Exception {
    Assert.notNull(command, "RemoveTopologicalNodeFromTopologicalNodeCommand should not be null");
    Assert.notNull(
        command.getTopologicalNodeId(),
        "RemoveTopologicalNodeFromTopologicalNodeCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveTopologicalNodeFromTopologicalNodeCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getTopologicalNodeId(),
        "RemoveTopologicalNodeFromTopologicalNodeCommand removeFrom attribubte identifier should not be null");
  }
}
