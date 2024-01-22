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

public class DiagramValidator {

  /** default constructor */
  protected DiagramValidator() {}

  /** factory method */
  public static DiagramValidator getInstance() {
    return new DiagramValidator();
  }

  /** handles creation validation for a Diagram */
  public void validate(CreateDiagramCommand diagram) throws Exception {
    Assert.notNull(diagram, "CreateDiagramCommand should not be null");
    //		Assert.isNull( diagram.getDiagramId(), "CreateDiagramCommand identifier should be null" );
  }

  /** handles update validation for a Diagram */
  public void validate(UpdateDiagramCommand diagram) throws Exception {
    Assert.notNull(diagram, "UpdateDiagramCommand should not be null");
    Assert.notNull(diagram.getDiagramId(), "UpdateDiagramCommand identifier should not be null");
  }

  /** handles delete validation for a Diagram */
  public void validate(DeleteDiagramCommand diagram) throws Exception {
    Assert.notNull(diagram, "{commandAlias} should not be null");
    Assert.notNull(diagram.getDiagramId(), "DeleteDiagramCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Diagram */
  public void validate(DiagramFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DiagramFetchOneSummary should not be null");
    Assert.notNull(summary.getDiagramId(), "DiagramFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign X1InitialView validation for a Diagram
   *
   * @param command AssignX1InitialViewToDiagramCommand
   */
  public void validate(AssignX1InitialViewToDiagramCommand command) throws Exception {
    Assert.notNull(command, "AssignX1InitialViewToDiagramCommand should not be null");
    Assert.notNull(
        command.getDiagramId(),
        "AssignX1InitialViewToDiagramCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignX1InitialViewToDiagramCommand assignment should not be null");
  }

  /**
   * handles unassign X1InitialView validation for a Diagram
   *
   * @param command UnAssignX1InitialViewFromDiagramCommand
   */
  public void validate(UnAssignX1InitialViewFromDiagramCommand command) throws Exception {
    Assert.notNull(command, "UnAssignX1InitialViewFromDiagramCommand should not be null");
    Assert.notNull(
        command.getDiagramId(),
        "UnAssignX1InitialViewFromDiagramCommand identifier should not be null");
  }
  /**
   * handles assign X2InitialView validation for a Diagram
   *
   * @param command AssignX2InitialViewToDiagramCommand
   */
  public void validate(AssignX2InitialViewToDiagramCommand command) throws Exception {
    Assert.notNull(command, "AssignX2InitialViewToDiagramCommand should not be null");
    Assert.notNull(
        command.getDiagramId(),
        "AssignX2InitialViewToDiagramCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignX2InitialViewToDiagramCommand assignment should not be null");
  }

  /**
   * handles unassign X2InitialView validation for a Diagram
   *
   * @param command UnAssignX2InitialViewFromDiagramCommand
   */
  public void validate(UnAssignX2InitialViewFromDiagramCommand command) throws Exception {
    Assert.notNull(command, "UnAssignX2InitialViewFromDiagramCommand should not be null");
    Assert.notNull(
        command.getDiagramId(),
        "UnAssignX2InitialViewFromDiagramCommand identifier should not be null");
  }
  /**
   * handles assign Y1InitialView validation for a Diagram
   *
   * @param command AssignY1InitialViewToDiagramCommand
   */
  public void validate(AssignY1InitialViewToDiagramCommand command) throws Exception {
    Assert.notNull(command, "AssignY1InitialViewToDiagramCommand should not be null");
    Assert.notNull(
        command.getDiagramId(),
        "AssignY1InitialViewToDiagramCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignY1InitialViewToDiagramCommand assignment should not be null");
  }

  /**
   * handles unassign Y1InitialView validation for a Diagram
   *
   * @param command UnAssignY1InitialViewFromDiagramCommand
   */
  public void validate(UnAssignY1InitialViewFromDiagramCommand command) throws Exception {
    Assert.notNull(command, "UnAssignY1InitialViewFromDiagramCommand should not be null");
    Assert.notNull(
        command.getDiagramId(),
        "UnAssignY1InitialViewFromDiagramCommand identifier should not be null");
  }
  /**
   * handles assign Y2InitialView validation for a Diagram
   *
   * @param command AssignY2InitialViewToDiagramCommand
   */
  public void validate(AssignY2InitialViewToDiagramCommand command) throws Exception {
    Assert.notNull(command, "AssignY2InitialViewToDiagramCommand should not be null");
    Assert.notNull(
        command.getDiagramId(),
        "AssignY2InitialViewToDiagramCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignY2InitialViewToDiagramCommand assignment should not be null");
  }

  /**
   * handles unassign Y2InitialView validation for a Diagram
   *
   * @param command UnAssignY2InitialViewFromDiagramCommand
   */
  public void validate(UnAssignY2InitialViewFromDiagramCommand command) throws Exception {
    Assert.notNull(command, "UnAssignY2InitialViewFromDiagramCommand should not be null");
    Assert.notNull(
        command.getDiagramId(),
        "UnAssignY2InitialViewFromDiagramCommand identifier should not be null");
  }

  /**
   * handles add to Diagram validation for a Diagram
   *
   * @param command AssignDiagramToDiagramCommand
   */
  public void validate(AssignDiagramToDiagramCommand command) throws Exception {
    Assert.notNull(command, "AssignDiagramToDiagramCommand should not be null");
    Assert.notNull(
        command.getDiagramId(), "AssignDiagramToDiagramCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(), "AssignDiagramToDiagramCommand addTo attribute should not be null");
  }

  /**
   * handles remove from Diagram validation for a Diagram
   *
   * @param command RemoveDiagramFromDiagramCommand
   */
  public void validate(RemoveDiagramFromDiagramCommand command) throws Exception {
    Assert.notNull(command, "RemoveDiagramFromDiagramCommand should not be null");
    Assert.notNull(
        command.getDiagramId(), "RemoveDiagramFromDiagramCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveDiagramFromDiagramCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getDiagramId(),
        "RemoveDiagramFromDiagramCommand removeFrom attribubte identifier should not be null");
  }
}
