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

public class VisibilityLayerValidator {

  /** default constructor */
  protected VisibilityLayerValidator() {}

  /** factory method */
  public static VisibilityLayerValidator getInstance() {
    return new VisibilityLayerValidator();
  }

  /** handles creation validation for a VisibilityLayer */
  public void validate(CreateVisibilityLayerCommand visibilityLayer) throws Exception {
    Assert.notNull(visibilityLayer, "CreateVisibilityLayerCommand should not be null");
    //		Assert.isNull( visibilityLayer.getVisibilityLayerId(), "CreateVisibilityLayerCommand
    // identifier should be null" );
  }

  /** handles update validation for a VisibilityLayer */
  public void validate(UpdateVisibilityLayerCommand visibilityLayer) throws Exception {
    Assert.notNull(visibilityLayer, "UpdateVisibilityLayerCommand should not be null");
    Assert.notNull(
        visibilityLayer.getVisibilityLayerId(),
        "UpdateVisibilityLayerCommand identifier should not be null");
  }

  /** handles delete validation for a VisibilityLayer */
  public void validate(DeleteVisibilityLayerCommand visibilityLayer) throws Exception {
    Assert.notNull(visibilityLayer, "{commandAlias} should not be null");
    Assert.notNull(
        visibilityLayer.getVisibilityLayerId(),
        "DeleteVisibilityLayerCommand identifier should not be null");
  }

  /** handles fetchOne validation for a VisibilityLayer */
  public void validate(VisibilityLayerFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "VisibilityLayerFetchOneSummary should not be null");
    Assert.notNull(
        summary.getVisibilityLayerId(),
        "VisibilityLayerFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign DrawingOrder validation for a VisibilityLayer
   *
   * @param command AssignDrawingOrderToVisibilityLayerCommand
   */
  public void validate(AssignDrawingOrderToVisibilityLayerCommand command) throws Exception {
    Assert.notNull(command, "AssignDrawingOrderToVisibilityLayerCommand should not be null");
    Assert.notNull(
        command.getVisibilityLayerId(),
        "AssignDrawingOrderToVisibilityLayerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDrawingOrderToVisibilityLayerCommand assignment should not be null");
  }

  /**
   * handles unassign DrawingOrder validation for a VisibilityLayer
   *
   * @param command UnAssignDrawingOrderFromVisibilityLayerCommand
   */
  public void validate(UnAssignDrawingOrderFromVisibilityLayerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDrawingOrderFromVisibilityLayerCommand should not be null");
    Assert.notNull(
        command.getVisibilityLayerId(),
        "UnAssignDrawingOrderFromVisibilityLayerCommand identifier should not be null");
  }

  /**
   * handles add to VisibilityLayers validation for a VisibilityLayer
   *
   * @param command AssignVisibilityLayersToVisibilityLayerCommand
   */
  public void validate(AssignVisibilityLayersToVisibilityLayerCommand command) throws Exception {
    Assert.notNull(command, "AssignVisibilityLayersToVisibilityLayerCommand should not be null");
    Assert.notNull(
        command.getVisibilityLayerId(),
        "AssignVisibilityLayersToVisibilityLayerCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignVisibilityLayersToVisibilityLayerCommand addTo attribute should not be null");
  }

  /**
   * handles remove from VisibilityLayers validation for a VisibilityLayer
   *
   * @param command RemoveVisibilityLayersFromVisibilityLayerCommand
   */
  public void validate(RemoveVisibilityLayersFromVisibilityLayerCommand command) throws Exception {
    Assert.notNull(command, "RemoveVisibilityLayersFromVisibilityLayerCommand should not be null");
    Assert.notNull(
        command.getVisibilityLayerId(),
        "RemoveVisibilityLayersFromVisibilityLayerCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveVisibilityLayersFromVisibilityLayerCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getVisibilityLayerId(),
        "RemoveVisibilityLayersFromVisibilityLayerCommand removeFrom attribubte identifier should not be null");
  }
}
