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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity DCLineSegment.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCLineSegment")
public class DCLineSegmentCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a DCLineSegment. if not key provided, calls create, otherwise calls save
   *
   * @param DCLineSegment dCLineSegment
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateDCLineSegmentCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          DCLineSegmentBusinessDelegate.getDCLineSegmentInstance().createDCLineSegment(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a DCLineSegment. if no key provided, calls create, otherwise calls save
   *
   * @param DCLineSegment dCLineSegment
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateDCLineSegmentCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateDCLineSegmentCommand
      // -----------------------------------------------
      completableFuture =
          DCLineSegmentBusinessDelegate.getDCLineSegmentInstance().updateDCLineSegment(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "DCLineSegmentController:update() - successfully update DCLineSegment - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a DCLineSegment entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID dCLineSegmentId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteDCLineSegmentCommand command = new DeleteDCLineSegmentCommand(dCLineSegmentId);

    try {
      DCLineSegmentBusinessDelegate delegate =
          DCLineSegmentBusinessDelegate.getDCLineSegmentInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted DCLineSegment with key " + command.getDCLineSegmentId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Capacitance on DCLineSegment
   *
   * @param command AssignCapacitanceToDCLineSegmentCommand
   */
  @PutMapping("/assignCapacitance")
  public void assignCapacitance(@RequestBody AssignCapacitanceToDCLineSegmentCommand command) {
    try {
      DCLineSegmentBusinessDelegate.getDCLineSegmentInstance().assignCapacitance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Capacitance", exc);
    }
  }

  /**
   * unassign Capacitance on DCLineSegment
   *
   * @param command UnAssignCapacitanceFromDCLineSegmentCommand
   */
  @PutMapping("/unAssignCapacitance")
  public void unAssignCapacitance(
      @RequestBody(required = true) UnAssignCapacitanceFromDCLineSegmentCommand command) {
    try {
      DCLineSegmentBusinessDelegate.getDCLineSegmentInstance().unAssignCapacitance(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Capacitance", exc);
    }
  }

  /**
   * save Inductance on DCLineSegment
   *
   * @param command AssignInductanceToDCLineSegmentCommand
   */
  @PutMapping("/assignInductance")
  public void assignInductance(@RequestBody AssignInductanceToDCLineSegmentCommand command) {
    try {
      DCLineSegmentBusinessDelegate.getDCLineSegmentInstance().assignInductance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Inductance", exc);
    }
  }

  /**
   * unassign Inductance on DCLineSegment
   *
   * @param command UnAssignInductanceFromDCLineSegmentCommand
   */
  @PutMapping("/unAssignInductance")
  public void unAssignInductance(
      @RequestBody(required = true) UnAssignInductanceFromDCLineSegmentCommand command) {
    try {
      DCLineSegmentBusinessDelegate.getDCLineSegmentInstance().unAssignInductance(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Inductance", exc);
    }
  }

  /**
   * save Length on DCLineSegment
   *
   * @param command AssignLengthToDCLineSegmentCommand
   */
  @PutMapping("/assignLength")
  public void assignLength(@RequestBody AssignLengthToDCLineSegmentCommand command) {
    try {
      DCLineSegmentBusinessDelegate.getDCLineSegmentInstance().assignLength(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Length", exc);
    }
  }

  /**
   * unassign Length on DCLineSegment
   *
   * @param command UnAssignLengthFromDCLineSegmentCommand
   */
  @PutMapping("/unAssignLength")
  public void unAssignLength(
      @RequestBody(required = true) UnAssignLengthFromDCLineSegmentCommand command) {
    try {
      DCLineSegmentBusinessDelegate.getDCLineSegmentInstance().unAssignLength(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Length", exc);
    }
  }

  /**
   * save Resistance on DCLineSegment
   *
   * @param command AssignResistanceToDCLineSegmentCommand
   */
  @PutMapping("/assignResistance")
  public void assignResistance(@RequestBody AssignResistanceToDCLineSegmentCommand command) {
    try {
      DCLineSegmentBusinessDelegate.getDCLineSegmentInstance().assignResistance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Resistance", exc);
    }
  }

  /**
   * unassign Resistance on DCLineSegment
   *
   * @param command UnAssignResistanceFromDCLineSegmentCommand
   */
  @PutMapping("/unAssignResistance")
  public void unAssignResistance(
      @RequestBody(required = true) UnAssignResistanceFromDCLineSegmentCommand command) {
    try {
      DCLineSegmentBusinessDelegate.getDCLineSegmentInstance().unAssignResistance(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Resistance", exc);
    }
  }

  /**
   * save DCLineSegments on DCLineSegment
   *
   * @param command AssignDCLineSegmentsToDCLineSegmentCommand
   */
  @PutMapping("/addToDCLineSegments")
  public void addToDCLineSegments(
      @RequestBody(required = true) AssignDCLineSegmentsToDCLineSegmentCommand command) {
    try {
      DCLineSegmentBusinessDelegate.getDCLineSegmentInstance().addToDCLineSegments(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set DCLineSegments", exc);
    }
  }

  /**
   * remove DCLineSegments on DCLineSegment
   *
   * @param command RemoveDCLineSegmentsFromDCLineSegmentCommand
   */
  @PutMapping("/removeFromDCLineSegments")
  public void removeFromDCLineSegments(
      @RequestBody(required = true) RemoveDCLineSegmentsFromDCLineSegmentCommand command) {
    try {
      DCLineSegmentBusinessDelegate.getDCLineSegmentInstance().removeFromDCLineSegments(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set DCLineSegments", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DCLineSegment dCLineSegment = null;
  private static final Logger LOGGER =
      Logger.getLogger(DCLineSegmentCommandRestController.class.getName());
}
