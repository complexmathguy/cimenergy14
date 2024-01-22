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
 * Implements Spring Controller command CQRS processing for entity WindGenTurbineType3IEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindGenTurbineType3IEC")
public class WindGenTurbineType3IECCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindGenTurbineType3IEC. if not key provided, calls create, otherwise calls
   * save
   *
   * @param WindGenTurbineType3IEC windGenTurbineType3IEC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindGenTurbineType3IECCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindGenTurbineType3IECBusinessDelegate.getWindGenTurbineType3IECInstance()
              .createWindGenTurbineType3IEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindGenTurbineType3IEC. if no key provided, calls create, otherwise calls
   * save
   *
   * @param WindGenTurbineType3IEC windGenTurbineType3IEC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindGenTurbineType3IECCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindGenTurbineType3IECCommand
      // -----------------------------------------------
      completableFuture =
          WindGenTurbineType3IECBusinessDelegate.getWindGenTurbineType3IECInstance()
              .updateWindGenTurbineType3IEC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindGenTurbineType3IECController:update() - successfully update WindGenTurbineType3IEC - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindGenTurbineType3IEC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID windGenTurbineType3IECId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindGenTurbineType3IECCommand command =
        new DeleteWindGenTurbineType3IECCommand(windGenTurbineType3IECId);

    try {
      WindGenTurbineType3IECBusinessDelegate delegate =
          WindGenTurbineType3IECBusinessDelegate.getWindGenTurbineType3IECInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindGenTurbineType3IEC with key "
              + command.getWindGenTurbineType3IECId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Dipmax on WindGenTurbineType3IEC
   *
   * @param command AssignDipmaxToWindGenTurbineType3IECCommand
   */
  @PutMapping("/assignDipmax")
  public void assignDipmax(@RequestBody AssignDipmaxToWindGenTurbineType3IECCommand command) {
    try {
      WindGenTurbineType3IECBusinessDelegate.getWindGenTurbineType3IECInstance()
          .assignDipmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dipmax", exc);
    }
  }

  /**
   * unassign Dipmax on WindGenTurbineType3IEC
   *
   * @param command UnAssignDipmaxFromWindGenTurbineType3IECCommand
   */
  @PutMapping("/unAssignDipmax")
  public void unAssignDipmax(
      @RequestBody(required = true) UnAssignDipmaxFromWindGenTurbineType3IECCommand command) {
    try {
      WindGenTurbineType3IECBusinessDelegate.getWindGenTurbineType3IECInstance()
          .unAssignDipmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dipmax", exc);
    }
  }

  /**
   * save Diqmax on WindGenTurbineType3IEC
   *
   * @param command AssignDiqmaxToWindGenTurbineType3IECCommand
   */
  @PutMapping("/assignDiqmax")
  public void assignDiqmax(@RequestBody AssignDiqmaxToWindGenTurbineType3IECCommand command) {
    try {
      WindGenTurbineType3IECBusinessDelegate.getWindGenTurbineType3IECInstance()
          .assignDiqmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Diqmax", exc);
    }
  }

  /**
   * unassign Diqmax on WindGenTurbineType3IEC
   *
   * @param command UnAssignDiqmaxFromWindGenTurbineType3IECCommand
   */
  @PutMapping("/unAssignDiqmax")
  public void unAssignDiqmax(
      @RequestBody(required = true) UnAssignDiqmaxFromWindGenTurbineType3IECCommand command) {
    try {
      WindGenTurbineType3IECBusinessDelegate.getWindGenTurbineType3IECInstance()
          .unAssignDiqmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Diqmax", exc);
    }
  }

  /**
   * save WindGenTurbineType3IEC on WindGenTurbineType3IEC
   *
   * @param command AssignWindGenTurbineType3IECToWindGenTurbineType3IECCommand
   */
  @PutMapping("/assignWindGenTurbineType3IEC")
  public void assignWindGenTurbineType3IEC(
      @RequestBody AssignWindGenTurbineType3IECToWindGenTurbineType3IECCommand command) {
    try {
      WindGenTurbineType3IECBusinessDelegate.getWindGenTurbineType3IECInstance()
          .assignWindGenTurbineType3IEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign WindGenTurbineType3IEC", exc);
    }
  }

  /**
   * unassign WindGenTurbineType3IEC on WindGenTurbineType3IEC
   *
   * @param command UnAssignWindGenTurbineType3IECFromWindGenTurbineType3IECCommand
   */
  @PutMapping("/unAssignWindGenTurbineType3IEC")
  public void unAssignWindGenTurbineType3IEC(
      @RequestBody(required = true)
          UnAssignWindGenTurbineType3IECFromWindGenTurbineType3IECCommand command) {
    try {
      WindGenTurbineType3IECBusinessDelegate.getWindGenTurbineType3IECInstance()
          .unAssignWindGenTurbineType3IEC(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign WindGenTurbineType3IEC", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindGenTurbineType3IEC windGenTurbineType3IEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindGenTurbineType3IECCommandRestController.class.getName());
}
