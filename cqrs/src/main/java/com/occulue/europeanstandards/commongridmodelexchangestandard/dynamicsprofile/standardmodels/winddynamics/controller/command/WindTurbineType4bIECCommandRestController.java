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
 * Implements Spring Controller command CQRS processing for entity WindTurbineType4bIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindTurbineType4bIEC")
public class WindTurbineType4bIECCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindTurbineType4bIEC. if not key provided, calls create, otherwise calls save
   *
   * @param WindTurbineType4bIEC windTurbineType4bIEC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindTurbineType4bIECCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindTurbineType4bIECBusinessDelegate.getWindTurbineType4bIECInstance()
              .createWindTurbineType4bIEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindTurbineType4bIEC. if no key provided, calls create, otherwise calls save
   *
   * @param WindTurbineType4bIEC windTurbineType4bIEC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindTurbineType4bIECCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindTurbineType4bIECCommand
      // -----------------------------------------------
      completableFuture =
          WindTurbineType4bIECBusinessDelegate.getWindTurbineType4bIECInstance()
              .updateWindTurbineType4bIEC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindTurbineType4bIECController:update() - successfully update WindTurbineType4bIEC - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindTurbineType4bIEC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID windTurbineType4bIECId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindTurbineType4bIECCommand command =
        new DeleteWindTurbineType4bIECCommand(windTurbineType4bIECId);

    try {
      WindTurbineType4bIECBusinessDelegate delegate =
          WindTurbineType4bIECBusinessDelegate.getWindTurbineType4bIECInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindTurbineType4bIEC with key "
              + command.getWindTurbineType4bIECId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save WindTurbineType4bIEC on WindTurbineType4bIEC
   *
   * @param command AssignWindTurbineType4bIECToWindTurbineType4bIECCommand
   */
  @PutMapping("/assignWindTurbineType4bIEC")
  public void assignWindTurbineType4bIEC(
      @RequestBody AssignWindTurbineType4bIECToWindTurbineType4bIECCommand command) {
    try {
      WindTurbineType4bIECBusinessDelegate.getWindTurbineType4bIECInstance()
          .assignWindTurbineType4bIEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign WindTurbineType4bIEC", exc);
    }
  }

  /**
   * unassign WindTurbineType4bIEC on WindTurbineType4bIEC
   *
   * @param command UnAssignWindTurbineType4bIECFromWindTurbineType4bIECCommand
   */
  @PutMapping("/unAssignWindTurbineType4bIEC")
  public void unAssignWindTurbineType4bIEC(
      @RequestBody(required = true)
          UnAssignWindTurbineType4bIECFromWindTurbineType4bIECCommand command) {
    try {
      WindTurbineType4bIECBusinessDelegate.getWindTurbineType4bIECInstance()
          .unAssignWindTurbineType4bIEC(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign WindTurbineType4bIEC", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindTurbineType4bIEC windTurbineType4bIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindTurbineType4bIECCommandRestController.class.getName());
}
