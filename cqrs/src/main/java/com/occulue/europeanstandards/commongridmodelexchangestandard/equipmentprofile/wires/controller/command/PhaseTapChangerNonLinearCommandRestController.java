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
 * Implements Spring Controller command CQRS processing for entity PhaseTapChangerNonLinear.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PhaseTapChangerNonLinear")
public class PhaseTapChangerNonLinearCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PhaseTapChangerNonLinear. if not key provided, calls create, otherwise calls
   * save
   *
   * @param PhaseTapChangerNonLinear phaseTapChangerNonLinear
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePhaseTapChangerNonLinearCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance()
              .createPhaseTapChangerNonLinear(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PhaseTapChangerNonLinear. if no key provided, calls create, otherwise calls
   * save
   *
   * @param PhaseTapChangerNonLinear phaseTapChangerNonLinear
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePhaseTapChangerNonLinearCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePhaseTapChangerNonLinearCommand
      // -----------------------------------------------
      completableFuture =
          PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance()
              .updatePhaseTapChangerNonLinear(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PhaseTapChangerNonLinearController:update() - successfully update PhaseTapChangerNonLinear - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PhaseTapChangerNonLinear entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID phaseTapChangerNonLinearId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePhaseTapChangerNonLinearCommand command =
        new DeletePhaseTapChangerNonLinearCommand(phaseTapChangerNonLinearId);

    try {
      PhaseTapChangerNonLinearBusinessDelegate delegate =
          PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted PhaseTapChangerNonLinear with key "
              + command.getPhaseTapChangerNonLinearId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save VoltageStepIncrement on PhaseTapChangerNonLinear
   *
   * @param command AssignVoltageStepIncrementToPhaseTapChangerNonLinearCommand
   */
  @PutMapping("/assignVoltageStepIncrement")
  public void assignVoltageStepIncrement(
      @RequestBody AssignVoltageStepIncrementToPhaseTapChangerNonLinearCommand command) {
    try {
      PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance()
          .assignVoltageStepIncrement(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign VoltageStepIncrement", exc);
    }
  }

  /**
   * unassign VoltageStepIncrement on PhaseTapChangerNonLinear
   *
   * @param command UnAssignVoltageStepIncrementFromPhaseTapChangerNonLinearCommand
   */
  @PutMapping("/unAssignVoltageStepIncrement")
  public void unAssignVoltageStepIncrement(
      @RequestBody(required = true)
          UnAssignVoltageStepIncrementFromPhaseTapChangerNonLinearCommand command) {
    try {
      PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance()
          .unAssignVoltageStepIncrement(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign VoltageStepIncrement", exc);
    }
  }

  /**
   * save XMax on PhaseTapChangerNonLinear
   *
   * @param command AssignXMaxToPhaseTapChangerNonLinearCommand
   */
  @PutMapping("/assignXMax")
  public void assignXMax(@RequestBody AssignXMaxToPhaseTapChangerNonLinearCommand command) {
    try {
      PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance()
          .assignXMax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign XMax", exc);
    }
  }

  /**
   * unassign XMax on PhaseTapChangerNonLinear
   *
   * @param command UnAssignXMaxFromPhaseTapChangerNonLinearCommand
   */
  @PutMapping("/unAssignXMax")
  public void unAssignXMax(
      @RequestBody(required = true) UnAssignXMaxFromPhaseTapChangerNonLinearCommand command) {
    try {
      PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance()
          .unAssignXMax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign XMax", exc);
    }
  }

  /**
   * save XMin on PhaseTapChangerNonLinear
   *
   * @param command AssignXMinToPhaseTapChangerNonLinearCommand
   */
  @PutMapping("/assignXMin")
  public void assignXMin(@RequestBody AssignXMinToPhaseTapChangerNonLinearCommand command) {
    try {
      PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance()
          .assignXMin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign XMin", exc);
    }
  }

  /**
   * unassign XMin on PhaseTapChangerNonLinear
   *
   * @param command UnAssignXMinFromPhaseTapChangerNonLinearCommand
   */
  @PutMapping("/unAssignXMin")
  public void unAssignXMin(
      @RequestBody(required = true) UnAssignXMinFromPhaseTapChangerNonLinearCommand command) {
    try {
      PhaseTapChangerNonLinearBusinessDelegate.getPhaseTapChangerNonLinearInstance()
          .unAssignXMin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign XMin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PhaseTapChangerNonLinear phaseTapChangerNonLinear = null;
  private static final Logger LOGGER =
      Logger.getLogger(PhaseTapChangerNonLinearCommandRestController.class.getName());
}
