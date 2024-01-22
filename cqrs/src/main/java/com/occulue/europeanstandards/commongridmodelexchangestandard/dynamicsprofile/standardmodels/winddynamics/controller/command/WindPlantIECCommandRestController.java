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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity WindPlantIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindPlantIEC")
public class WindPlantIECCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindPlantIEC. if not key provided, calls create, otherwise calls save
   *
   * @param WindPlantIEC windPlantIEC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindPlantIECCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindPlantIECBusinessDelegate.getWindPlantIECInstance().createWindPlantIEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindPlantIEC. if no key provided, calls create, otherwise calls save
   *
   * @param WindPlantIEC windPlantIEC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindPlantIECCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindPlantIECCommand
      // -----------------------------------------------
      completableFuture =
          WindPlantIECBusinessDelegate.getWindPlantIECInstance().updateWindPlantIEC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindPlantIECController:update() - successfully update WindPlantIEC - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindPlantIEC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID windPlantIECId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindPlantIECCommand command = new DeleteWindPlantIECCommand(windPlantIECId);

    try {
      WindPlantIECBusinessDelegate delegate =
          WindPlantIECBusinessDelegate.getWindPlantIECInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindPlantIEC with key " + command.getWindPlantIECId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save WindPlantIEC on WindPlantIEC
   *
   * @param command AssignWindPlantIECToWindPlantIECCommand
   */
  @PutMapping("/assignWindPlantIEC")
  public void assignWindPlantIEC(@RequestBody AssignWindPlantIECToWindPlantIECCommand command) {
    try {
      WindPlantIECBusinessDelegate.getWindPlantIECInstance().assignWindPlantIEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign WindPlantIEC", exc);
    }
  }

  /**
   * unassign WindPlantIEC on WindPlantIEC
   *
   * @param command UnAssignWindPlantIECFromWindPlantIECCommand
   */
  @PutMapping("/unAssignWindPlantIEC")
  public void unAssignWindPlantIEC(
      @RequestBody(required = true) UnAssignWindPlantIECFromWindPlantIECCommand command) {
    try {
      WindPlantIECBusinessDelegate.getWindPlantIECInstance().unAssignWindPlantIEC(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign WindPlantIEC", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindPlantIEC windPlantIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindPlantIECCommandRestController.class.getName());
}
