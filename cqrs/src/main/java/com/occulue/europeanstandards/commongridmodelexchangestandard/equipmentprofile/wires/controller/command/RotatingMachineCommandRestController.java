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
 * Implements Spring Controller command CQRS processing for entity RotatingMachine.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RotatingMachine")
public class RotatingMachineCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a RotatingMachine. if not key provided, calls create, otherwise calls save
   *
   * @param RotatingMachine rotatingMachine
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateRotatingMachineCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          RotatingMachineBusinessDelegate.getRotatingMachineInstance()
              .createRotatingMachine(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a RotatingMachine. if no key provided, calls create, otherwise calls save
   *
   * @param RotatingMachine rotatingMachine
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateRotatingMachineCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateRotatingMachineCommand
      // -----------------------------------------------
      completableFuture =
          RotatingMachineBusinessDelegate.getRotatingMachineInstance()
              .updateRotatingMachine(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "RotatingMachineController:update() - successfully update RotatingMachine - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a RotatingMachine entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID rotatingMachineId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteRotatingMachineCommand command = new DeleteRotatingMachineCommand(rotatingMachineId);

    try {
      RotatingMachineBusinessDelegate delegate =
          RotatingMachineBusinessDelegate.getRotatingMachineInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted RotatingMachine with key " + command.getRotatingMachineId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save RatedPowerFactor on RotatingMachine
   *
   * @param command AssignRatedPowerFactorToRotatingMachineCommand
   */
  @PutMapping("/assignRatedPowerFactor")
  public void assignRatedPowerFactor(
      @RequestBody AssignRatedPowerFactorToRotatingMachineCommand command) {
    try {
      RotatingMachineBusinessDelegate.getRotatingMachineInstance().assignRatedPowerFactor(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign RatedPowerFactor", exc);
    }
  }

  /**
   * unassign RatedPowerFactor on RotatingMachine
   *
   * @param command UnAssignRatedPowerFactorFromRotatingMachineCommand
   */
  @PutMapping("/unAssignRatedPowerFactor")
  public void unAssignRatedPowerFactor(
      @RequestBody(required = true) UnAssignRatedPowerFactorFromRotatingMachineCommand command) {
    try {
      RotatingMachineBusinessDelegate.getRotatingMachineInstance()
          .unAssignRatedPowerFactor(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign RatedPowerFactor", exc);
    }
  }

  /**
   * save RatedS on RotatingMachine
   *
   * @param command AssignRatedSToRotatingMachineCommand
   */
  @PutMapping("/assignRatedS")
  public void assignRatedS(@RequestBody AssignRatedSToRotatingMachineCommand command) {
    try {
      RotatingMachineBusinessDelegate.getRotatingMachineInstance().assignRatedS(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign RatedS", exc);
    }
  }

  /**
   * unassign RatedS on RotatingMachine
   *
   * @param command UnAssignRatedSFromRotatingMachineCommand
   */
  @PutMapping("/unAssignRatedS")
  public void unAssignRatedS(
      @RequestBody(required = true) UnAssignRatedSFromRotatingMachineCommand command) {
    try {
      RotatingMachineBusinessDelegate.getRotatingMachineInstance().unAssignRatedS(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign RatedS", exc);
    }
  }

  /**
   * save RatedU on RotatingMachine
   *
   * @param command AssignRatedUToRotatingMachineCommand
   */
  @PutMapping("/assignRatedU")
  public void assignRatedU(@RequestBody AssignRatedUToRotatingMachineCommand command) {
    try {
      RotatingMachineBusinessDelegate.getRotatingMachineInstance().assignRatedU(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign RatedU", exc);
    }
  }

  /**
   * unassign RatedU on RotatingMachine
   *
   * @param command UnAssignRatedUFromRotatingMachineCommand
   */
  @PutMapping("/unAssignRatedU")
  public void unAssignRatedU(
      @RequestBody(required = true) UnAssignRatedUFromRotatingMachineCommand command) {
    try {
      RotatingMachineBusinessDelegate.getRotatingMachineInstance().unAssignRatedU(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign RatedU", exc);
    }
  }

  /**
   * save RotatingMachine on RotatingMachine
   *
   * @param command AssignRotatingMachineToRotatingMachineCommand
   */
  @PutMapping("/addToRotatingMachine")
  public void addToRotatingMachine(
      @RequestBody(required = true) AssignRotatingMachineToRotatingMachineCommand command) {
    try {
      RotatingMachineBusinessDelegate.getRotatingMachineInstance().addToRotatingMachine(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set RotatingMachine", exc);
    }
  }

  /**
   * remove RotatingMachine on RotatingMachine
   *
   * @param command RemoveRotatingMachineFromRotatingMachineCommand
   */
  @PutMapping("/removeFromRotatingMachine")
  public void removeFromRotatingMachine(
      @RequestBody(required = true) RemoveRotatingMachineFromRotatingMachineCommand command) {
    try {
      RotatingMachineBusinessDelegate.getRotatingMachineInstance()
          .removeFromRotatingMachine(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set RotatingMachine", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected RotatingMachine rotatingMachine = null;
  private static final Logger LOGGER =
      Logger.getLogger(RotatingMachineCommandRestController.class.getName());
}
