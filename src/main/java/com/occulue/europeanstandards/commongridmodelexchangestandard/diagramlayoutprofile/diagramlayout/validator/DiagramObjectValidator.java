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
package com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class DiagramObjectValidator {

  /** default constructor */
  protected DiagramObjectValidator() {}

  /** factory method */
  public static DiagramObjectValidator getInstance() {
    return new DiagramObjectValidator();
  }

  /** handles creation validation for a DiagramObject */
  public void validate(CreateDiagramObjectCommand diagramObject) throws Exception {
    Assert.notNull(diagramObject, "CreateDiagramObjectCommand should not be null");
    //		Assert.isNull( diagramObject.getDiagramObjectId(), "CreateDiagramObjectCommand identifier
    // should be null" );
  }

  /** handles update validation for a DiagramObject */
  public void validate(UpdateDiagramObjectCommand diagramObject) throws Exception {
    Assert.notNull(diagramObject, "UpdateDiagramObjectCommand should not be null");
    Assert.notNull(
        diagramObject.getDiagramObjectId(),
        "UpdateDiagramObjectCommand identifier should not be null");
  }

  /** handles delete validation for a DiagramObject */
  public void validate(DeleteDiagramObjectCommand diagramObject) throws Exception {
    Assert.notNull(diagramObject, "{commandAlias} should not be null");
    Assert.notNull(
        diagramObject.getDiagramObjectId(),
        "DeleteDiagramObjectCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DiagramObject */
  public void validate(DiagramObjectFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DiagramObjectFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDiagramObjectId(), "DiagramObjectFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign DrawingOrder validation for a DiagramObject
   *
   * @param command AssignDrawingOrderToDiagramObjectCommand
   */
  public void validate(AssignDrawingOrderToDiagramObjectCommand command) throws Exception {
    Assert.notNull(command, "AssignDrawingOrderToDiagramObjectCommand should not be null");
    Assert.notNull(
        command.getDiagramObjectId(),
        "AssignDrawingOrderToDiagramObjectCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDrawingOrderToDiagramObjectCommand assignment should not be null");
  }

  /**
   * handles unassign DrawingOrder validation for a DiagramObject
   *
   * @param command UnAssignDrawingOrderFromDiagramObjectCommand
   */
  public void validate(UnAssignDrawingOrderFromDiagramObjectCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDrawingOrderFromDiagramObjectCommand should not be null");
    Assert.notNull(
        command.getDiagramObjectId(),
        "UnAssignDrawingOrderFromDiagramObjectCommand identifier should not be null");
  }
  /**
   * handles assign PolygonFlag validation for a DiagramObject
   *
   * @param command AssignPolygonFlagToDiagramObjectCommand
   */
  public void validate(AssignPolygonFlagToDiagramObjectCommand command) throws Exception {
    Assert.notNull(command, "AssignPolygonFlagToDiagramObjectCommand should not be null");
    Assert.notNull(
        command.getDiagramObjectId(),
        "AssignPolygonFlagToDiagramObjectCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPolygonFlagToDiagramObjectCommand assignment should not be null");
  }

  /**
   * handles unassign PolygonFlag validation for a DiagramObject
   *
   * @param command UnAssignPolygonFlagFromDiagramObjectCommand
   */
  public void validate(UnAssignPolygonFlagFromDiagramObjectCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPolygonFlagFromDiagramObjectCommand should not be null");
    Assert.notNull(
        command.getDiagramObjectId(),
        "UnAssignPolygonFlagFromDiagramObjectCommand identifier should not be null");
  }
  /**
   * handles assign OffsetX validation for a DiagramObject
   *
   * @param command AssignOffsetXToDiagramObjectCommand
   */
  public void validate(AssignOffsetXToDiagramObjectCommand command) throws Exception {
    Assert.notNull(command, "AssignOffsetXToDiagramObjectCommand should not be null");
    Assert.notNull(
        command.getDiagramObjectId(),
        "AssignOffsetXToDiagramObjectCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignOffsetXToDiagramObjectCommand assignment should not be null");
  }

  /**
   * handles unassign OffsetX validation for a DiagramObject
   *
   * @param command UnAssignOffsetXFromDiagramObjectCommand
   */
  public void validate(UnAssignOffsetXFromDiagramObjectCommand command) throws Exception {
    Assert.notNull(command, "UnAssignOffsetXFromDiagramObjectCommand should not be null");
    Assert.notNull(
        command.getDiagramObjectId(),
        "UnAssignOffsetXFromDiagramObjectCommand identifier should not be null");
  }
  /**
   * handles assign OffsetY validation for a DiagramObject
   *
   * @param command AssignOffsetYToDiagramObjectCommand
   */
  public void validate(AssignOffsetYToDiagramObjectCommand command) throws Exception {
    Assert.notNull(command, "AssignOffsetYToDiagramObjectCommand should not be null");
    Assert.notNull(
        command.getDiagramObjectId(),
        "AssignOffsetYToDiagramObjectCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignOffsetYToDiagramObjectCommand assignment should not be null");
  }

  /**
   * handles unassign OffsetY validation for a DiagramObject
   *
   * @param command UnAssignOffsetYFromDiagramObjectCommand
   */
  public void validate(UnAssignOffsetYFromDiagramObjectCommand command) throws Exception {
    Assert.notNull(command, "UnAssignOffsetYFromDiagramObjectCommand should not be null");
    Assert.notNull(
        command.getDiagramObjectId(),
        "UnAssignOffsetYFromDiagramObjectCommand identifier should not be null");
  }
  /**
   * handles assign Rotation validation for a DiagramObject
   *
   * @param command AssignRotationToDiagramObjectCommand
   */
  public void validate(AssignRotationToDiagramObjectCommand command) throws Exception {
    Assert.notNull(command, "AssignRotationToDiagramObjectCommand should not be null");
    Assert.notNull(
        command.getDiagramObjectId(),
        "AssignRotationToDiagramObjectCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRotationToDiagramObjectCommand assignment should not be null");
  }

  /**
   * handles unassign Rotation validation for a DiagramObject
   *
   * @param command UnAssignRotationFromDiagramObjectCommand
   */
  public void validate(UnAssignRotationFromDiagramObjectCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRotationFromDiagramObjectCommand should not be null");
    Assert.notNull(
        command.getDiagramObjectId(),
        "UnAssignRotationFromDiagramObjectCommand identifier should not be null");
  }

  /**
   * handles add to StyledObjects validation for a DiagramObject
   *
   * @param command AssignStyledObjectsToDiagramObjectCommand
   */
  public void validate(AssignStyledObjectsToDiagramObjectCommand command) throws Exception {
    Assert.notNull(command, "AssignStyledObjectsToDiagramObjectCommand should not be null");
    Assert.notNull(
        command.getDiagramObjectId(),
        "AssignStyledObjectsToDiagramObjectCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignStyledObjectsToDiagramObjectCommand addTo attribute should not be null");
  }

  /**
   * handles remove from StyledObjects validation for a DiagramObject
   *
   * @param command RemoveStyledObjectsFromDiagramObjectCommand
   */
  public void validate(RemoveStyledObjectsFromDiagramObjectCommand command) throws Exception {
    Assert.notNull(command, "RemoveStyledObjectsFromDiagramObjectCommand should not be null");
    Assert.notNull(
        command.getDiagramObjectId(),
        "RemoveStyledObjectsFromDiagramObjectCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveStyledObjectsFromDiagramObjectCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getDiagramObjectId(),
        "RemoveStyledObjectsFromDiagramObjectCommand removeFrom attribubte identifier should not be null");
  }

  /**
   * handles add to DiagramElements validation for a DiagramObject
   *
   * @param command AssignDiagramElementsToDiagramObjectCommand
   */
  public void validate(AssignDiagramElementsToDiagramObjectCommand command) throws Exception {
    Assert.notNull(command, "AssignDiagramElementsToDiagramObjectCommand should not be null");
    Assert.notNull(
        command.getDiagramObjectId(),
        "AssignDiagramElementsToDiagramObjectCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignDiagramElementsToDiagramObjectCommand addTo attribute should not be null");
  }

  /**
   * handles remove from DiagramElements validation for a DiagramObject
   *
   * @param command RemoveDiagramElementsFromDiagramObjectCommand
   */
  public void validate(RemoveDiagramElementsFromDiagramObjectCommand command) throws Exception {
    Assert.notNull(command, "RemoveDiagramElementsFromDiagramObjectCommand should not be null");
    Assert.notNull(
        command.getDiagramObjectId(),
        "RemoveDiagramElementsFromDiagramObjectCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveDiagramElementsFromDiagramObjectCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getDiagramObjectId(),
        "RemoveDiagramElementsFromDiagramObjectCommand removeFrom attribubte identifier should not be null");
  }

  /**
   * handles add to DiagramObjects validation for a DiagramObject
   *
   * @param command AssignDiagramObjectsToDiagramObjectCommand
   */
  public void validate(AssignDiagramObjectsToDiagramObjectCommand command) throws Exception {
    Assert.notNull(command, "AssignDiagramObjectsToDiagramObjectCommand should not be null");
    Assert.notNull(
        command.getDiagramObjectId(),
        "AssignDiagramObjectsToDiagramObjectCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignDiagramObjectsToDiagramObjectCommand addTo attribute should not be null");
  }

  /**
   * handles remove from DiagramObjects validation for a DiagramObject
   *
   * @param command RemoveDiagramObjectsFromDiagramObjectCommand
   */
  public void validate(RemoveDiagramObjectsFromDiagramObjectCommand command) throws Exception {
    Assert.notNull(command, "RemoveDiagramObjectsFromDiagramObjectCommand should not be null");
    Assert.notNull(
        command.getDiagramObjectId(),
        "RemoveDiagramObjectsFromDiagramObjectCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveDiagramObjectsFromDiagramObjectCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getDiagramObjectId(),
        "RemoveDiagramObjectsFromDiagramObjectCommand removeFrom attribubte identifier should not be null");
  }
}
