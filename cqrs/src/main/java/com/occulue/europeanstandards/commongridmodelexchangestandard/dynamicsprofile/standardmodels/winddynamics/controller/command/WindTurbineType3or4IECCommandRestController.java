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
 * Implements Spring Controller command CQRS processing for entity WindTurbineType3or4IEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindTurbineType3or4IEC")
public class WindTurbineType3or4IECCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindTurbineType3or4IEC. if not key provided, calls create, otherwise calls
   * save
   *
   * @param WindTurbineType3or4IEC windTurbineType3or4IEC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindTurbineType3or4IECCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindTurbineType3or4IECBusinessDelegate.getWindTurbineType3or4IECInstance()
              .createWindTurbineType3or4IEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindTurbineType3or4IEC. if no key provided, calls create, otherwise calls
   * save
   *
   * @param WindTurbineType3or4IEC windTurbineType3or4IEC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindTurbineType3or4IECCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindTurbineType3or4IECCommand
      // -----------------------------------------------
      completableFuture =
          WindTurbineType3or4IECBusinessDelegate.getWindTurbineType3or4IECInstance()
              .updateWindTurbineType3or4IEC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindTurbineType3or4IECController:update() - successfully update WindTurbineType3or4IEC - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindTurbineType3or4IEC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID windTurbineType3or4IECId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindTurbineType3or4IECCommand command =
        new DeleteWindTurbineType3or4IECCommand(windTurbineType3or4IECId);

    try {
      WindTurbineType3or4IECBusinessDelegate delegate =
          WindTurbineType3or4IECBusinessDelegate.getWindTurbineType3or4IECInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindTurbineType3or4IEC with key "
              + command.getWindTurbineType3or4IECId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save WindTurbineType3or4IEC on WindTurbineType3or4IEC
   *
   * @param command AssignWindTurbineType3or4IECToWindTurbineType3or4IECCommand
   */
  @PutMapping("/assignWindTurbineType3or4IEC")
  public void assignWindTurbineType3or4IEC(
      @RequestBody AssignWindTurbineType3or4IECToWindTurbineType3or4IECCommand command) {
    try {
      WindTurbineType3or4IECBusinessDelegate.getWindTurbineType3or4IECInstance()
          .assignWindTurbineType3or4IEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign WindTurbineType3or4IEC", exc);
    }
  }

  /**
   * unassign WindTurbineType3or4IEC on WindTurbineType3or4IEC
   *
   * @param command UnAssignWindTurbineType3or4IECFromWindTurbineType3or4IECCommand
   */
  @PutMapping("/unAssignWindTurbineType3or4IEC")
  public void unAssignWindTurbineType3or4IEC(
      @RequestBody(required = true)
          UnAssignWindTurbineType3or4IECFromWindTurbineType3or4IECCommand command) {
    try {
      WindTurbineType3or4IECBusinessDelegate.getWindTurbineType3or4IECInstance()
          .unAssignWindTurbineType3or4IEC(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign WindTurbineType3or4IEC", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindTurbineType3or4IEC windTurbineType3or4IEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindTurbineType3or4IECCommandRestController.class.getName());
}
