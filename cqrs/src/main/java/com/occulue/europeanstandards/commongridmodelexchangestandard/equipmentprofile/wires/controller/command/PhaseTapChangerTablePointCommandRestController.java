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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity PhaseTapChangerTablePoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PhaseTapChangerTablePoint")
public class PhaseTapChangerTablePointCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PhaseTapChangerTablePoint. if not key provided, calls create, otherwise calls
   * save
   *
   * @param PhaseTapChangerTablePoint phaseTapChangerTablePoint
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePhaseTapChangerTablePointCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          PhaseTapChangerTablePointBusinessDelegate.getPhaseTapChangerTablePointInstance()
              .createPhaseTapChangerTablePoint(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PhaseTapChangerTablePoint. if no key provided, calls create, otherwise calls
   * save
   *
   * @param PhaseTapChangerTablePoint phaseTapChangerTablePoint
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePhaseTapChangerTablePointCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePhaseTapChangerTablePointCommand
      // -----------------------------------------------
      completableFuture =
          PhaseTapChangerTablePointBusinessDelegate.getPhaseTapChangerTablePointInstance()
              .updatePhaseTapChangerTablePoint(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PhaseTapChangerTablePointController:update() - successfully update PhaseTapChangerTablePoint - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PhaseTapChangerTablePoint entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID phaseTapChangerTablePointId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePhaseTapChangerTablePointCommand command =
        new DeletePhaseTapChangerTablePointCommand(phaseTapChangerTablePointId);

    try {
      PhaseTapChangerTablePointBusinessDelegate delegate =
          PhaseTapChangerTablePointBusinessDelegate.getPhaseTapChangerTablePointInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted PhaseTapChangerTablePoint with key "
              + command.getPhaseTapChangerTablePointId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Angle on PhaseTapChangerTablePoint
   *
   * @param command AssignAngleToPhaseTapChangerTablePointCommand
   */
  @PutMapping("/assignAngle")
  public void assignAngle(@RequestBody AssignAngleToPhaseTapChangerTablePointCommand command) {
    try {
      PhaseTapChangerTablePointBusinessDelegate.getPhaseTapChangerTablePointInstance()
          .assignAngle(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Angle", exc);
    }
  }

  /**
   * unassign Angle on PhaseTapChangerTablePoint
   *
   * @param command UnAssignAngleFromPhaseTapChangerTablePointCommand
   */
  @PutMapping("/unAssignAngle")
  public void unAssignAngle(
      @RequestBody(required = true) UnAssignAngleFromPhaseTapChangerTablePointCommand command) {
    try {
      PhaseTapChangerTablePointBusinessDelegate.getPhaseTapChangerTablePointInstance()
          .unAssignAngle(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Angle", exc);
    }
  }

  /**
   * save PhaseTapChangerTablePoint on PhaseTapChangerTablePoint
   *
   * @param command AssignPhaseTapChangerTablePointToPhaseTapChangerTablePointCommand
   */
  @PutMapping("/addToPhaseTapChangerTablePoint")
  public void addToPhaseTapChangerTablePoint(
      @RequestBody(required = true)
          AssignPhaseTapChangerTablePointToPhaseTapChangerTablePointCommand command) {
    try {
      PhaseTapChangerTablePointBusinessDelegate.getPhaseTapChangerTablePointInstance()
          .addToPhaseTapChangerTablePoint(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set PhaseTapChangerTablePoint", exc);
    }
  }

  /**
   * remove PhaseTapChangerTablePoint on PhaseTapChangerTablePoint
   *
   * @param command RemovePhaseTapChangerTablePointFromPhaseTapChangerTablePointCommand
   */
  @PutMapping("/removeFromPhaseTapChangerTablePoint")
  public void removeFromPhaseTapChangerTablePoint(
      @RequestBody(required = true)
          RemovePhaseTapChangerTablePointFromPhaseTapChangerTablePointCommand command) {
    try {
      PhaseTapChangerTablePointBusinessDelegate.getPhaseTapChangerTablePointInstance()
          .removeFromPhaseTapChangerTablePoint(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set PhaseTapChangerTablePoint", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PhaseTapChangerTablePoint phaseTapChangerTablePoint = null;
  private static final Logger LOGGER =
      Logger.getLogger(PhaseTapChangerTablePointCommandRestController.class.getName());
}
