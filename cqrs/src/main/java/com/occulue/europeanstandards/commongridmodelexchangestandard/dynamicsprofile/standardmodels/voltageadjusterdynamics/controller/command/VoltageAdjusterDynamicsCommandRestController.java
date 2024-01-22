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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltageadjusterdynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity VoltageAdjusterDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VoltageAdjusterDynamics")
public class VoltageAdjusterDynamicsCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a VoltageAdjusterDynamics. if not key provided, calls create, otherwise calls
   * save
   *
   * @param VoltageAdjusterDynamics voltageAdjusterDynamics
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateVoltageAdjusterDynamicsCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          VoltageAdjusterDynamicsBusinessDelegate.getVoltageAdjusterDynamicsInstance()
              .createVoltageAdjusterDynamics(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a VoltageAdjusterDynamics. if no key provided, calls create, otherwise calls
   * save
   *
   * @param VoltageAdjusterDynamics voltageAdjusterDynamics
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateVoltageAdjusterDynamicsCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateVoltageAdjusterDynamicsCommand
      // -----------------------------------------------
      completableFuture =
          VoltageAdjusterDynamicsBusinessDelegate.getVoltageAdjusterDynamicsInstance()
              .updateVoltageAdjusterDynamics(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "VoltageAdjusterDynamicsController:update() - successfully update VoltageAdjusterDynamics - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a VoltageAdjusterDynamics entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID voltageAdjusterDynamicsId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteVoltageAdjusterDynamicsCommand command =
        new DeleteVoltageAdjusterDynamicsCommand(voltageAdjusterDynamicsId);

    try {
      VoltageAdjusterDynamicsBusinessDelegate delegate =
          VoltageAdjusterDynamicsBusinessDelegate.getVoltageAdjusterDynamicsInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted VoltageAdjusterDynamics with key "
              + command.getVoltageAdjusterDynamicsId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save VoltageAdjusterDynamics on VoltageAdjusterDynamics
   *
   * @param command AssignVoltageAdjusterDynamicsToVoltageAdjusterDynamicsCommand
   */
  @PutMapping("/assignVoltageAdjusterDynamics")
  public void assignVoltageAdjusterDynamics(
      @RequestBody AssignVoltageAdjusterDynamicsToVoltageAdjusterDynamicsCommand command) {
    try {
      VoltageAdjusterDynamicsBusinessDelegate.getVoltageAdjusterDynamicsInstance()
          .assignVoltageAdjusterDynamics(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign VoltageAdjusterDynamics", exc);
    }
  }

  /**
   * unassign VoltageAdjusterDynamics on VoltageAdjusterDynamics
   *
   * @param command UnAssignVoltageAdjusterDynamicsFromVoltageAdjusterDynamicsCommand
   */
  @PutMapping("/unAssignVoltageAdjusterDynamics")
  public void unAssignVoltageAdjusterDynamics(
      @RequestBody(required = true)
          UnAssignVoltageAdjusterDynamicsFromVoltageAdjusterDynamicsCommand command) {
    try {
      VoltageAdjusterDynamicsBusinessDelegate.getVoltageAdjusterDynamicsInstance()
          .unAssignVoltageAdjusterDynamics(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign VoltageAdjusterDynamics", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected VoltageAdjusterDynamics voltageAdjusterDynamics = null;
  private static final Logger LOGGER =
      Logger.getLogger(VoltageAdjusterDynamicsCommandRestController.class.getName());
}
