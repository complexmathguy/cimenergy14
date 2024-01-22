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
package com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout.controller.command;

import com.occulue.api.*;
import com.occulue.command.*;
import com.occulue.controller.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.*;

/**
 * Implements Spring Controller command CQRS processing for entity DiagramObject.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiagramObject")
public class DiagramObjectCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a DiagramObject. if not key provided, calls create, otherwise calls save
   *
   * @param DiagramObject diagramObject
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateDiagramObjectCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          DiagramObjectBusinessDelegate.getDiagramObjectInstance().createDiagramObject(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a DiagramObject. if no key provided, calls create, otherwise calls save
   *
   * @param DiagramObject diagramObject
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateDiagramObjectCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateDiagramObjectCommand
      // -----------------------------------------------
      completableFuture =
          DiagramObjectBusinessDelegate.getDiagramObjectInstance().updateDiagramObject(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "DiagramObjectController:update() - successfully update DiagramObject - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a DiagramObject entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID diagramObjectId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteDiagramObjectCommand command = new DeleteDiagramObjectCommand(diagramObjectId);

    try {
      DiagramObjectBusinessDelegate delegate =
          DiagramObjectBusinessDelegate.getDiagramObjectInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted DiagramObject with key " + command.getDiagramObjectId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save DrawingOrder on DiagramObject
   *
   * @param command AssignDrawingOrderToDiagramObjectCommand
   */
  @PutMapping("/assignDrawingOrder")
  public void assignDrawingOrder(@RequestBody AssignDrawingOrderToDiagramObjectCommand command) {
    try {
      DiagramObjectBusinessDelegate.getDiagramObjectInstance().assignDrawingOrder(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign DrawingOrder", exc);
    }
  }

  /**
   * unassign DrawingOrder on DiagramObject
   *
   * @param command UnAssignDrawingOrderFromDiagramObjectCommand
   */
  @PutMapping("/unAssignDrawingOrder")
  public void unAssignDrawingOrder(
      @RequestBody(required = true) UnAssignDrawingOrderFromDiagramObjectCommand command) {
    try {
      DiagramObjectBusinessDelegate.getDiagramObjectInstance().unAssignDrawingOrder(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign DrawingOrder", exc);
    }
  }

  /**
   * save PolygonFlag on DiagramObject
   *
   * @param command AssignPolygonFlagToDiagramObjectCommand
   */
  @PutMapping("/assignPolygonFlag")
  public void assignPolygonFlag(@RequestBody AssignPolygonFlagToDiagramObjectCommand command) {
    try {
      DiagramObjectBusinessDelegate.getDiagramObjectInstance().assignPolygonFlag(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign PolygonFlag", exc);
    }
  }

  /**
   * unassign PolygonFlag on DiagramObject
   *
   * @param command UnAssignPolygonFlagFromDiagramObjectCommand
   */
  @PutMapping("/unAssignPolygonFlag")
  public void unAssignPolygonFlag(
      @RequestBody(required = true) UnAssignPolygonFlagFromDiagramObjectCommand command) {
    try {
      DiagramObjectBusinessDelegate.getDiagramObjectInstance().unAssignPolygonFlag(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign PolygonFlag", exc);
    }
  }

  /**
   * save OffsetX on DiagramObject
   *
   * @param command AssignOffsetXToDiagramObjectCommand
   */
  @PutMapping("/assignOffsetX")
  public void assignOffsetX(@RequestBody AssignOffsetXToDiagramObjectCommand command) {
    try {
      DiagramObjectBusinessDelegate.getDiagramObjectInstance().assignOffsetX(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign OffsetX", exc);
    }
  }

  /**
   * unassign OffsetX on DiagramObject
   *
   * @param command UnAssignOffsetXFromDiagramObjectCommand
   */
  @PutMapping("/unAssignOffsetX")
  public void unAssignOffsetX(
      @RequestBody(required = true) UnAssignOffsetXFromDiagramObjectCommand command) {
    try {
      DiagramObjectBusinessDelegate.getDiagramObjectInstance().unAssignOffsetX(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign OffsetX", exc);
    }
  }

  /**
   * save OffsetY on DiagramObject
   *
   * @param command AssignOffsetYToDiagramObjectCommand
   */
  @PutMapping("/assignOffsetY")
  public void assignOffsetY(@RequestBody AssignOffsetYToDiagramObjectCommand command) {
    try {
      DiagramObjectBusinessDelegate.getDiagramObjectInstance().assignOffsetY(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign OffsetY", exc);
    }
  }

  /**
   * unassign OffsetY on DiagramObject
   *
   * @param command UnAssignOffsetYFromDiagramObjectCommand
   */
  @PutMapping("/unAssignOffsetY")
  public void unAssignOffsetY(
      @RequestBody(required = true) UnAssignOffsetYFromDiagramObjectCommand command) {
    try {
      DiagramObjectBusinessDelegate.getDiagramObjectInstance().unAssignOffsetY(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign OffsetY", exc);
    }
  }

  /**
   * save Rotation on DiagramObject
   *
   * @param command AssignRotationToDiagramObjectCommand
   */
  @PutMapping("/assignRotation")
  public void assignRotation(@RequestBody AssignRotationToDiagramObjectCommand command) {
    try {
      DiagramObjectBusinessDelegate.getDiagramObjectInstance().assignRotation(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rotation", exc);
    }
  }

  /**
   * unassign Rotation on DiagramObject
   *
   * @param command UnAssignRotationFromDiagramObjectCommand
   */
  @PutMapping("/unAssignRotation")
  public void unAssignRotation(
      @RequestBody(required = true) UnAssignRotationFromDiagramObjectCommand command) {
    try {
      DiagramObjectBusinessDelegate.getDiagramObjectInstance().unAssignRotation(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rotation", exc);
    }
  }

  /**
   * save StyledObjects on DiagramObject
   *
   * @param command AssignStyledObjectsToDiagramObjectCommand
   */
  @PutMapping("/addToStyledObjects")
  public void addToStyledObjects(
      @RequestBody(required = true) AssignStyledObjectsToDiagramObjectCommand command) {
    try {
      DiagramObjectBusinessDelegate.getDiagramObjectInstance().addToStyledObjects(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set StyledObjects", exc);
    }
  }

  /**
   * remove StyledObjects on DiagramObject
   *
   * @param command RemoveStyledObjectsFromDiagramObjectCommand
   */
  @PutMapping("/removeFromStyledObjects")
  public void removeFromStyledObjects(
      @RequestBody(required = true) RemoveStyledObjectsFromDiagramObjectCommand command) {
    try {
      DiagramObjectBusinessDelegate.getDiagramObjectInstance().removeFromStyledObjects(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set StyledObjects", exc);
    }
  }

  /**
   * save DiagramElements on DiagramObject
   *
   * @param command AssignDiagramElementsToDiagramObjectCommand
   */
  @PutMapping("/addToDiagramElements")
  public void addToDiagramElements(
      @RequestBody(required = true) AssignDiagramElementsToDiagramObjectCommand command) {
    try {
      DiagramObjectBusinessDelegate.getDiagramObjectInstance().addToDiagramElements(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set DiagramElements", exc);
    }
  }

  /**
   * remove DiagramElements on DiagramObject
   *
   * @param command RemoveDiagramElementsFromDiagramObjectCommand
   */
  @PutMapping("/removeFromDiagramElements")
  public void removeFromDiagramElements(
      @RequestBody(required = true) RemoveDiagramElementsFromDiagramObjectCommand command) {
    try {
      DiagramObjectBusinessDelegate.getDiagramObjectInstance().removeFromDiagramElements(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set DiagramElements", exc);
    }
  }

  /**
   * save DiagramObjects on DiagramObject
   *
   * @param command AssignDiagramObjectsToDiagramObjectCommand
   */
  @PutMapping("/addToDiagramObjects")
  public void addToDiagramObjects(
      @RequestBody(required = true) AssignDiagramObjectsToDiagramObjectCommand command) {
    try {
      DiagramObjectBusinessDelegate.getDiagramObjectInstance().addToDiagramObjects(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set DiagramObjects", exc);
    }
  }

  /**
   * remove DiagramObjects on DiagramObject
   *
   * @param command RemoveDiagramObjectsFromDiagramObjectCommand
   */
  @PutMapping("/removeFromDiagramObjects")
  public void removeFromDiagramObjects(
      @RequestBody(required = true) RemoveDiagramObjectsFromDiagramObjectCommand command) {
    try {
      DiagramObjectBusinessDelegate.getDiagramObjectInstance().removeFromDiagramObjects(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set DiagramObjects", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DiagramObject diagramObject = null;
  private static final Logger LOGGER =
      Logger.getLogger(DiagramObjectCommandRestController.class.getName());
}
