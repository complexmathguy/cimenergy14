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
 * Implements Spring Controller command CQRS processing for entity StaticVarCompensator.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/StaticVarCompensator")
public class StaticVarCompensatorCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a StaticVarCompensator. if not key provided, calls create, otherwise calls save
   *
   * @param StaticVarCompensator staticVarCompensator
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateStaticVarCompensatorCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance()
              .createStaticVarCompensator(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a StaticVarCompensator. if no key provided, calls create, otherwise calls save
   *
   * @param StaticVarCompensator staticVarCompensator
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateStaticVarCompensatorCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateStaticVarCompensatorCommand
      // -----------------------------------------------
      completableFuture =
          StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance()
              .updateStaticVarCompensator(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "StaticVarCompensatorController:update() - successfully update StaticVarCompensator - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a StaticVarCompensator entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID staticVarCompensatorId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteStaticVarCompensatorCommand command =
        new DeleteStaticVarCompensatorCommand(staticVarCompensatorId);

    try {
      StaticVarCompensatorBusinessDelegate delegate =
          StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted StaticVarCompensator with key "
              + command.getStaticVarCompensatorId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save CapacitiveRating on StaticVarCompensator
   *
   * @param command AssignCapacitiveRatingToStaticVarCompensatorCommand
   */
  @PutMapping("/assignCapacitiveRating")
  public void assignCapacitiveRating(
      @RequestBody AssignCapacitiveRatingToStaticVarCompensatorCommand command) {
    try {
      StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance()
          .assignCapacitiveRating(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign CapacitiveRating", exc);
    }
  }

  /**
   * unassign CapacitiveRating on StaticVarCompensator
   *
   * @param command UnAssignCapacitiveRatingFromStaticVarCompensatorCommand
   */
  @PutMapping("/unAssignCapacitiveRating")
  public void unAssignCapacitiveRating(
      @RequestBody(required = true)
          UnAssignCapacitiveRatingFromStaticVarCompensatorCommand command) {
    try {
      StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance()
          .unAssignCapacitiveRating(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign CapacitiveRating", exc);
    }
  }

  /**
   * save InductiveRating on StaticVarCompensator
   *
   * @param command AssignInductiveRatingToStaticVarCompensatorCommand
   */
  @PutMapping("/assignInductiveRating")
  public void assignInductiveRating(
      @RequestBody AssignInductiveRatingToStaticVarCompensatorCommand command) {
    try {
      StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance()
          .assignInductiveRating(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign InductiveRating", exc);
    }
  }

  /**
   * unassign InductiveRating on StaticVarCompensator
   *
   * @param command UnAssignInductiveRatingFromStaticVarCompensatorCommand
   */
  @PutMapping("/unAssignInductiveRating")
  public void unAssignInductiveRating(
      @RequestBody(required = true)
          UnAssignInductiveRatingFromStaticVarCompensatorCommand command) {
    try {
      StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance()
          .unAssignInductiveRating(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign InductiveRating", exc);
    }
  }

  /**
   * save Slope on StaticVarCompensator
   *
   * @param command AssignSlopeToStaticVarCompensatorCommand
   */
  @PutMapping("/assignSlope")
  public void assignSlope(@RequestBody AssignSlopeToStaticVarCompensatorCommand command) {
    try {
      StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance().assignSlope(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Slope", exc);
    }
  }

  /**
   * unassign Slope on StaticVarCompensator
   *
   * @param command UnAssignSlopeFromStaticVarCompensatorCommand
   */
  @PutMapping("/unAssignSlope")
  public void unAssignSlope(
      @RequestBody(required = true) UnAssignSlopeFromStaticVarCompensatorCommand command) {
    try {
      StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance().unAssignSlope(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Slope", exc);
    }
  }

  /**
   * save VoltageSetPoint on StaticVarCompensator
   *
   * @param command AssignVoltageSetPointToStaticVarCompensatorCommand
   */
  @PutMapping("/assignVoltageSetPoint")
  public void assignVoltageSetPoint(
      @RequestBody AssignVoltageSetPointToStaticVarCompensatorCommand command) {
    try {
      StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance()
          .assignVoltageSetPoint(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign VoltageSetPoint", exc);
    }
  }

  /**
   * unassign VoltageSetPoint on StaticVarCompensator
   *
   * @param command UnAssignVoltageSetPointFromStaticVarCompensatorCommand
   */
  @PutMapping("/unAssignVoltageSetPoint")
  public void unAssignVoltageSetPoint(
      @RequestBody(required = true)
          UnAssignVoltageSetPointFromStaticVarCompensatorCommand command) {
    try {
      StaticVarCompensatorBusinessDelegate.getStaticVarCompensatorInstance()
          .unAssignVoltageSetPoint(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign VoltageSetPoint", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected StaticVarCompensator staticVarCompensator = null;
  private static final Logger LOGGER =
      Logger.getLogger(StaticVarCompensatorCommandRestController.class.getName());
}
