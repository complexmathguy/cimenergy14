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
 * Implements Spring Controller command CQRS processing for entity Conductor.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Conductor")
public class ConductorCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Conductor. if not key provided, calls create, otherwise calls save
   *
   * @param Conductor conductor
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateConductorCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ConductorBusinessDelegate.getConductorInstance().createConductor(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Conductor. if no key provided, calls create, otherwise calls save
   *
   * @param Conductor conductor
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateConductorCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateConductorCommand
      // -----------------------------------------------
      completableFuture = ConductorBusinessDelegate.getConductorInstance().updateConductor(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ConductorController:update() - successfully update Conductor - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Conductor entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID conductorId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteConductorCommand command = new DeleteConductorCommand(conductorId);

    try {
      ConductorBusinessDelegate delegate = ConductorBusinessDelegate.getConductorInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted Conductor with key " + command.getConductorId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Length on Conductor
   *
   * @param command AssignLengthToConductorCommand
   */
  @PutMapping("/assignLength")
  public void assignLength(@RequestBody AssignLengthToConductorCommand command) {
    try {
      ConductorBusinessDelegate.getConductorInstance().assignLength(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Length", exc);
    }
  }

  /**
   * unassign Length on Conductor
   *
   * @param command UnAssignLengthFromConductorCommand
   */
  @PutMapping("/unAssignLength")
  public void unAssignLength(
      @RequestBody(required = true) UnAssignLengthFromConductorCommand command) {
    try {
      ConductorBusinessDelegate.getConductorInstance().unAssignLength(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Length", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Conductor conductor = null;
  private static final Logger LOGGER =
      Logger.getLogger(ConductorCommandRestController.class.getName());
}
