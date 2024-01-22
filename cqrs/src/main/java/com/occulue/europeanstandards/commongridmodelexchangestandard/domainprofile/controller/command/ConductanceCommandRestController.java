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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity Conductance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Conductance")
public class ConductanceCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Conductance. if not key provided, calls create, otherwise calls save
   *
   * @param Conductance conductance
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateConductanceCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ConductanceBusinessDelegate.getConductanceInstance().createConductance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Conductance. if no key provided, calls create, otherwise calls save
   *
   * @param Conductance conductance
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateConductanceCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateConductanceCommand
      // -----------------------------------------------
      completableFuture =
          ConductanceBusinessDelegate.getConductanceInstance().updateConductance(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ConductanceController:update() - successfully update Conductance - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Conductance entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID conductanceId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteConductanceCommand command = new DeleteConductanceCommand(conductanceId);

    try {
      ConductanceBusinessDelegate delegate = ConductanceBusinessDelegate.getConductanceInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted Conductance with key " + command.getConductanceId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on Conductance
   *
   * @param command AssignValueToConductanceCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToConductanceCommand command) {
    try {
      ConductanceBusinessDelegate.getConductanceInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on Conductance
   *
   * @param command UnAssignValueFromConductanceCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(
      @RequestBody(required = true) UnAssignValueFromConductanceCommand command) {
    try {
      ConductanceBusinessDelegate.getConductanceInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Conductance conductance = null;
  private static final Logger LOGGER =
      Logger.getLogger(ConductanceCommandRestController.class.getName());
}
