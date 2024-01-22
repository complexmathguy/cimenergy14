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
 * Implements Spring Controller command CQRS processing for entity PhaseTapChangerLinear.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PhaseTapChangerLinear")
public class PhaseTapChangerLinearCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PhaseTapChangerLinear. if not key provided, calls create, otherwise calls save
   *
   * @param PhaseTapChangerLinear phaseTapChangerLinear
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePhaseTapChangerLinearCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance()
              .createPhaseTapChangerLinear(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PhaseTapChangerLinear. if no key provided, calls create, otherwise calls
   * save
   *
   * @param PhaseTapChangerLinear phaseTapChangerLinear
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePhaseTapChangerLinearCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePhaseTapChangerLinearCommand
      // -----------------------------------------------
      completableFuture =
          PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance()
              .updatePhaseTapChangerLinear(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PhaseTapChangerLinearController:update() - successfully update PhaseTapChangerLinear - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PhaseTapChangerLinear entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID phaseTapChangerLinearId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePhaseTapChangerLinearCommand command =
        new DeletePhaseTapChangerLinearCommand(phaseTapChangerLinearId);

    try {
      PhaseTapChangerLinearBusinessDelegate delegate =
          PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted PhaseTapChangerLinear with key "
              + command.getPhaseTapChangerLinearId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save StepPhaseShiftIncrement on PhaseTapChangerLinear
   *
   * @param command AssignStepPhaseShiftIncrementToPhaseTapChangerLinearCommand
   */
  @PutMapping("/assignStepPhaseShiftIncrement")
  public void assignStepPhaseShiftIncrement(
      @RequestBody AssignStepPhaseShiftIncrementToPhaseTapChangerLinearCommand command) {
    try {
      PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance()
          .assignStepPhaseShiftIncrement(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign StepPhaseShiftIncrement", exc);
    }
  }

  /**
   * unassign StepPhaseShiftIncrement on PhaseTapChangerLinear
   *
   * @param command UnAssignStepPhaseShiftIncrementFromPhaseTapChangerLinearCommand
   */
  @PutMapping("/unAssignStepPhaseShiftIncrement")
  public void unAssignStepPhaseShiftIncrement(
      @RequestBody(required = true)
          UnAssignStepPhaseShiftIncrementFromPhaseTapChangerLinearCommand command) {
    try {
      PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance()
          .unAssignStepPhaseShiftIncrement(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign StepPhaseShiftIncrement", exc);
    }
  }

  /**
   * save XMax on PhaseTapChangerLinear
   *
   * @param command AssignXMaxToPhaseTapChangerLinearCommand
   */
  @PutMapping("/assignXMax")
  public void assignXMax(@RequestBody AssignXMaxToPhaseTapChangerLinearCommand command) {
    try {
      PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance().assignXMax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign XMax", exc);
    }
  }

  /**
   * unassign XMax on PhaseTapChangerLinear
   *
   * @param command UnAssignXMaxFromPhaseTapChangerLinearCommand
   */
  @PutMapping("/unAssignXMax")
  public void unAssignXMax(
      @RequestBody(required = true) UnAssignXMaxFromPhaseTapChangerLinearCommand command) {
    try {
      PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance()
          .unAssignXMax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign XMax", exc);
    }
  }

  /**
   * save XMin on PhaseTapChangerLinear
   *
   * @param command AssignXMinToPhaseTapChangerLinearCommand
   */
  @PutMapping("/assignXMin")
  public void assignXMin(@RequestBody AssignXMinToPhaseTapChangerLinearCommand command) {
    try {
      PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance().assignXMin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign XMin", exc);
    }
  }

  /**
   * unassign XMin on PhaseTapChangerLinear
   *
   * @param command UnAssignXMinFromPhaseTapChangerLinearCommand
   */
  @PutMapping("/unAssignXMin")
  public void unAssignXMin(
      @RequestBody(required = true) UnAssignXMinFromPhaseTapChangerLinearCommand command) {
    try {
      PhaseTapChangerLinearBusinessDelegate.getPhaseTapChangerLinearInstance()
          .unAssignXMin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign XMin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PhaseTapChangerLinear phaseTapChangerLinear = null;
  private static final Logger LOGGER =
      Logger.getLogger(PhaseTapChangerLinearCommandRestController.class.getName());
}
