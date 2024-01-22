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
 * Implements Spring Controller command CQRS processing for entity Voltage.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Voltage")
public class VoltageCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Voltage. if not key provided, calls create, otherwise calls save
   *
   * @param Voltage voltage
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateVoltageCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = VoltageBusinessDelegate.getVoltageInstance().createVoltage(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Voltage. if no key provided, calls create, otherwise calls save
   *
   * @param Voltage voltage
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateVoltageCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateVoltageCommand
      // -----------------------------------------------
      completableFuture = VoltageBusinessDelegate.getVoltageInstance().updateVoltage(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "VoltageController:update() - successfully update Voltage - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Voltage entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID voltageId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteVoltageCommand command = new DeleteVoltageCommand(voltageId);

    try {
      VoltageBusinessDelegate delegate = VoltageBusinessDelegate.getVoltageInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted Voltage with key " + command.getVoltageId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on Voltage
   *
   * @param command AssignValueToVoltageCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToVoltageCommand command) {
    try {
      VoltageBusinessDelegate.getVoltageInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on Voltage
   *
   * @param command UnAssignValueFromVoltageCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(@RequestBody(required = true) UnAssignValueFromVoltageCommand command) {
    try {
      VoltageBusinessDelegate.getVoltageInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Voltage voltage = null;
  private static final Logger LOGGER =
      Logger.getLogger(VoltageCommandRestController.class.getName());
}
