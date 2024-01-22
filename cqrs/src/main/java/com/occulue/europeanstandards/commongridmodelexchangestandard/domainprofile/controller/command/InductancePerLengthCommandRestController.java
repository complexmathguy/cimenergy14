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
 * Implements Spring Controller command CQRS processing for entity InductancePerLength.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/InductancePerLength")
public class InductancePerLengthCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a InductancePerLength. if not key provided, calls create, otherwise calls save
   *
   * @param InductancePerLength inductancePerLength
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateInductancePerLengthCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          InductancePerLengthBusinessDelegate.getInductancePerLengthInstance()
              .createInductancePerLength(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a InductancePerLength. if no key provided, calls create, otherwise calls save
   *
   * @param InductancePerLength inductancePerLength
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateInductancePerLengthCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateInductancePerLengthCommand
      // -----------------------------------------------
      completableFuture =
          InductancePerLengthBusinessDelegate.getInductancePerLengthInstance()
              .updateInductancePerLength(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "InductancePerLengthController:update() - successfully update InductancePerLength - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a InductancePerLength entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID inductancePerLengthId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteInductancePerLengthCommand command =
        new DeleteInductancePerLengthCommand(inductancePerLengthId);

    try {
      InductancePerLengthBusinessDelegate delegate =
          InductancePerLengthBusinessDelegate.getInductancePerLengthInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted InductancePerLength with key "
              + command.getInductancePerLengthId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on InductancePerLength
   *
   * @param command AssignValueToInductancePerLengthCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToInductancePerLengthCommand command) {
    try {
      InductancePerLengthBusinessDelegate.getInductancePerLengthInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on InductancePerLength
   *
   * @param command UnAssignValueFromInductancePerLengthCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(
      @RequestBody(required = true) UnAssignValueFromInductancePerLengthCommand command) {
    try {
      InductancePerLengthBusinessDelegate.getInductancePerLengthInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected InductancePerLength inductancePerLength = null;
  private static final Logger LOGGER =
      Logger.getLogger(InductancePerLengthCommandRestController.class.getName());
}
