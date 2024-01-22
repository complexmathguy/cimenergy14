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
 * Implements Spring Controller command CQRS processing for entity WindGenTurbineType3aIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindGenTurbineType3aIEC")
public class WindGenTurbineType3aIECCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindGenTurbineType3aIEC. if not key provided, calls create, otherwise calls
   * save
   *
   * @param WindGenTurbineType3aIEC windGenTurbineType3aIEC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindGenTurbineType3aIECCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance()
              .createWindGenTurbineType3aIEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindGenTurbineType3aIEC. if no key provided, calls create, otherwise calls
   * save
   *
   * @param WindGenTurbineType3aIEC windGenTurbineType3aIEC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindGenTurbineType3aIECCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindGenTurbineType3aIECCommand
      // -----------------------------------------------
      completableFuture =
          WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance()
              .updateWindGenTurbineType3aIEC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindGenTurbineType3aIECController:update() - successfully update WindGenTurbineType3aIEC - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindGenTurbineType3aIEC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID windGenTurbineType3aIECId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindGenTurbineType3aIECCommand command =
        new DeleteWindGenTurbineType3aIECCommand(windGenTurbineType3aIECId);

    try {
      WindGenTurbineType3aIECBusinessDelegate delegate =
          WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindGenTurbineType3aIEC with key "
              + command.getWindGenTurbineType3aIECId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Kpc on WindGenTurbineType3aIEC
   *
   * @param command AssignKpcToWindGenTurbineType3aIECCommand
   */
  @PutMapping("/assignKpc")
  public void assignKpc(@RequestBody AssignKpcToWindGenTurbineType3aIECCommand command) {
    try {
      WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance()
          .assignKpc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpc", exc);
    }
  }

  /**
   * unassign Kpc on WindGenTurbineType3aIEC
   *
   * @param command UnAssignKpcFromWindGenTurbineType3aIECCommand
   */
  @PutMapping("/unAssignKpc")
  public void unAssignKpc(
      @RequestBody(required = true) UnAssignKpcFromWindGenTurbineType3aIECCommand command) {
    try {
      WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance()
          .unAssignKpc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpc", exc);
    }
  }

  /**
   * save Tic on WindGenTurbineType3aIEC
   *
   * @param command AssignTicToWindGenTurbineType3aIECCommand
   */
  @PutMapping("/assignTic")
  public void assignTic(@RequestBody AssignTicToWindGenTurbineType3aIECCommand command) {
    try {
      WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance()
          .assignTic(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tic", exc);
    }
  }

  /**
   * unassign Tic on WindGenTurbineType3aIEC
   *
   * @param command UnAssignTicFromWindGenTurbineType3aIECCommand
   */
  @PutMapping("/unAssignTic")
  public void unAssignTic(
      @RequestBody(required = true) UnAssignTicFromWindGenTurbineType3aIECCommand command) {
    try {
      WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance()
          .unAssignTic(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tic", exc);
    }
  }

  /**
   * save Xs on WindGenTurbineType3aIEC
   *
   * @param command AssignXsToWindGenTurbineType3aIECCommand
   */
  @PutMapping("/assignXs")
  public void assignXs(@RequestBody AssignXsToWindGenTurbineType3aIECCommand command) {
    try {
      WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance()
          .assignXs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xs", exc);
    }
  }

  /**
   * unassign Xs on WindGenTurbineType3aIEC
   *
   * @param command UnAssignXsFromWindGenTurbineType3aIECCommand
   */
  @PutMapping("/unAssignXs")
  public void unAssignXs(
      @RequestBody(required = true) UnAssignXsFromWindGenTurbineType3aIECCommand command) {
    try {
      WindGenTurbineType3aIECBusinessDelegate.getWindGenTurbineType3aIECInstance()
          .unAssignXs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xs", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindGenTurbineType3aIEC windGenTurbineType3aIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindGenTurbineType3aIECCommandRestController.class.getName());
}
