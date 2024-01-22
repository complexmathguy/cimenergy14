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
package com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity PositionPoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PositionPoint")
public class PositionPointCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PositionPoint. if not key provided, calls create, otherwise calls save
   *
   * @param PositionPoint positionPoint
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePositionPointCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          PositionPointBusinessDelegate.getPositionPointInstance().createPositionPoint(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PositionPoint. if no key provided, calls create, otherwise calls save
   *
   * @param PositionPoint positionPoint
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePositionPointCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePositionPointCommand
      // -----------------------------------------------
      completableFuture =
          PositionPointBusinessDelegate.getPositionPointInstance().updatePositionPoint(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PositionPointController:update() - successfully update PositionPoint - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PositionPoint entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID positionPointId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePositionPointCommand command = new DeletePositionPointCommand(positionPointId);

    try {
      PositionPointBusinessDelegate delegate =
          PositionPointBusinessDelegate.getPositionPointInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted PositionPoint with key " + command.getPositionPointId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save SequenceNumber on PositionPoint
   *
   * @param command AssignSequenceNumberToPositionPointCommand
   */
  @PutMapping("/assignSequenceNumber")
  public void assignSequenceNumber(
      @RequestBody AssignSequenceNumberToPositionPointCommand command) {
    try {
      PositionPointBusinessDelegate.getPositionPointInstance().assignSequenceNumber(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SequenceNumber", exc);
    }
  }

  /**
   * unassign SequenceNumber on PositionPoint
   *
   * @param command UnAssignSequenceNumberFromPositionPointCommand
   */
  @PutMapping("/unAssignSequenceNumber")
  public void unAssignSequenceNumber(
      @RequestBody(required = true) UnAssignSequenceNumberFromPositionPointCommand command) {
    try {
      PositionPointBusinessDelegate.getPositionPointInstance().unAssignSequenceNumber(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SequenceNumber", exc);
    }
  }

  /**
   * save XPosition on PositionPoint
   *
   * @param command AssignXPositionToPositionPointCommand
   */
  @PutMapping("/assignXPosition")
  public void assignXPosition(@RequestBody AssignXPositionToPositionPointCommand command) {
    try {
      PositionPointBusinessDelegate.getPositionPointInstance().assignXPosition(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign XPosition", exc);
    }
  }

  /**
   * unassign XPosition on PositionPoint
   *
   * @param command UnAssignXPositionFromPositionPointCommand
   */
  @PutMapping("/unAssignXPosition")
  public void unAssignXPosition(
      @RequestBody(required = true) UnAssignXPositionFromPositionPointCommand command) {
    try {
      PositionPointBusinessDelegate.getPositionPointInstance().unAssignXPosition(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign XPosition", exc);
    }
  }

  /**
   * save YPosition on PositionPoint
   *
   * @param command AssignYPositionToPositionPointCommand
   */
  @PutMapping("/assignYPosition")
  public void assignYPosition(@RequestBody AssignYPositionToPositionPointCommand command) {
    try {
      PositionPointBusinessDelegate.getPositionPointInstance().assignYPosition(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign YPosition", exc);
    }
  }

  /**
   * unassign YPosition on PositionPoint
   *
   * @param command UnAssignYPositionFromPositionPointCommand
   */
  @PutMapping("/unAssignYPosition")
  public void unAssignYPosition(
      @RequestBody(required = true) UnAssignYPositionFromPositionPointCommand command) {
    try {
      PositionPointBusinessDelegate.getPositionPointInstance().unAssignYPosition(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign YPosition", exc);
    }
  }

  /**
   * save ZPosition on PositionPoint
   *
   * @param command AssignZPositionToPositionPointCommand
   */
  @PutMapping("/assignZPosition")
  public void assignZPosition(@RequestBody AssignZPositionToPositionPointCommand command) {
    try {
      PositionPointBusinessDelegate.getPositionPointInstance().assignZPosition(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ZPosition", exc);
    }
  }

  /**
   * unassign ZPosition on PositionPoint
   *
   * @param command UnAssignZPositionFromPositionPointCommand
   */
  @PutMapping("/unAssignZPosition")
  public void unAssignZPosition(
      @RequestBody(required = true) UnAssignZPositionFromPositionPointCommand command) {
    try {
      PositionPointBusinessDelegate.getPositionPointInstance().unAssignZPosition(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ZPosition", exc);
    }
  }

  /**
   * save PositionPoints on PositionPoint
   *
   * @param command AssignPositionPointsToPositionPointCommand
   */
  @PutMapping("/addToPositionPoints")
  public void addToPositionPoints(
      @RequestBody(required = true) AssignPositionPointsToPositionPointCommand command) {
    try {
      PositionPointBusinessDelegate.getPositionPointInstance().addToPositionPoints(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set PositionPoints", exc);
    }
  }

  /**
   * remove PositionPoints on PositionPoint
   *
   * @param command RemovePositionPointsFromPositionPointCommand
   */
  @PutMapping("/removeFromPositionPoints")
  public void removeFromPositionPoints(
      @RequestBody(required = true) RemovePositionPointsFromPositionPointCommand command) {
    try {
      PositionPointBusinessDelegate.getPositionPointInstance().removeFromPositionPoints(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set PositionPoints", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PositionPoint positionPoint = null;
  private static final Logger LOGGER =
      Logger.getLogger(PositionPointCommandRestController.class.getName());
}
