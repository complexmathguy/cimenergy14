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
 * Implements Spring Controller command CQRS processing for entity VoltagePerReactivePower.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VoltagePerReactivePower")
public class VoltagePerReactivePowerCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a VoltagePerReactivePower. if not key provided, calls create, otherwise calls
   * save
   *
   * @param VoltagePerReactivePower voltagePerReactivePower
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateVoltagePerReactivePowerCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          VoltagePerReactivePowerBusinessDelegate.getVoltagePerReactivePowerInstance()
              .createVoltagePerReactivePower(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a VoltagePerReactivePower. if no key provided, calls create, otherwise calls
   * save
   *
   * @param VoltagePerReactivePower voltagePerReactivePower
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateVoltagePerReactivePowerCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateVoltagePerReactivePowerCommand
      // -----------------------------------------------
      completableFuture =
          VoltagePerReactivePowerBusinessDelegate.getVoltagePerReactivePowerInstance()
              .updateVoltagePerReactivePower(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "VoltagePerReactivePowerController:update() - successfully update VoltagePerReactivePower - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a VoltagePerReactivePower entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID voltagePerReactivePowerId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteVoltagePerReactivePowerCommand command =
        new DeleteVoltagePerReactivePowerCommand(voltagePerReactivePowerId);

    try {
      VoltagePerReactivePowerBusinessDelegate delegate =
          VoltagePerReactivePowerBusinessDelegate.getVoltagePerReactivePowerInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted VoltagePerReactivePower with key "
              + command.getVoltagePerReactivePowerId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on VoltagePerReactivePower
   *
   * @param command AssignValueToVoltagePerReactivePowerCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToVoltagePerReactivePowerCommand command) {
    try {
      VoltagePerReactivePowerBusinessDelegate.getVoltagePerReactivePowerInstance()
          .assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on VoltagePerReactivePower
   *
   * @param command UnAssignValueFromVoltagePerReactivePowerCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(
      @RequestBody(required = true) UnAssignValueFromVoltagePerReactivePowerCommand command) {
    try {
      VoltagePerReactivePowerBusinessDelegate.getVoltagePerReactivePowerInstance()
          .unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected VoltagePerReactivePower voltagePerReactivePower = null;
  private static final Logger LOGGER =
      Logger.getLogger(VoltagePerReactivePowerCommandRestController.class.getName());
}
