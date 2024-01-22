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
 * Implements Spring Controller command CQRS processing for entity WindTurbineType1or2IEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindTurbineType1or2IEC")
public class WindTurbineType1or2IECCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindTurbineType1or2IEC. if not key provided, calls create, otherwise calls
   * save
   *
   * @param WindTurbineType1or2IEC windTurbineType1or2IEC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindTurbineType1or2IECCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindTurbineType1or2IECBusinessDelegate.getWindTurbineType1or2IECInstance()
              .createWindTurbineType1or2IEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindTurbineType1or2IEC. if no key provided, calls create, otherwise calls
   * save
   *
   * @param WindTurbineType1or2IEC windTurbineType1or2IEC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindTurbineType1or2IECCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindTurbineType1or2IECCommand
      // -----------------------------------------------
      completableFuture =
          WindTurbineType1or2IECBusinessDelegate.getWindTurbineType1or2IECInstance()
              .updateWindTurbineType1or2IEC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindTurbineType1or2IECController:update() - successfully update WindTurbineType1or2IEC - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindTurbineType1or2IEC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID windTurbineType1or2IECId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindTurbineType1or2IECCommand command =
        new DeleteWindTurbineType1or2IECCommand(windTurbineType1or2IECId);

    try {
      WindTurbineType1or2IECBusinessDelegate delegate =
          WindTurbineType1or2IECBusinessDelegate.getWindTurbineType1or2IECInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindTurbineType1or2IEC with key "
              + command.getWindTurbineType1or2IECId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save WindTurbineType1or2IEC on WindTurbineType1or2IEC
   *
   * @param command AssignWindTurbineType1or2IECToWindTurbineType1or2IECCommand
   */
  @PutMapping("/assignWindTurbineType1or2IEC")
  public void assignWindTurbineType1or2IEC(
      @RequestBody AssignWindTurbineType1or2IECToWindTurbineType1or2IECCommand command) {
    try {
      WindTurbineType1or2IECBusinessDelegate.getWindTurbineType1or2IECInstance()
          .assignWindTurbineType1or2IEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign WindTurbineType1or2IEC", exc);
    }
  }

  /**
   * unassign WindTurbineType1or2IEC on WindTurbineType1or2IEC
   *
   * @param command UnAssignWindTurbineType1or2IECFromWindTurbineType1or2IECCommand
   */
  @PutMapping("/unAssignWindTurbineType1or2IEC")
  public void unAssignWindTurbineType1or2IEC(
      @RequestBody(required = true)
          UnAssignWindTurbineType1or2IECFromWindTurbineType1or2IECCommand command) {
    try {
      WindTurbineType1or2IECBusinessDelegate.getWindTurbineType1or2IECInstance()
          .unAssignWindTurbineType1or2IEC(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign WindTurbineType1or2IEC", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindTurbineType1or2IEC windTurbineType1or2IEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindTurbineType1or2IECCommandRestController.class.getName());
}
