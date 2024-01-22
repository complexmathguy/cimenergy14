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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity OperationalLimit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/OperationalLimit")
public class OperationalLimitCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a OperationalLimit. if not key provided, calls create, otherwise calls save
   *
   * @param OperationalLimit operationalLimit
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateOperationalLimitCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          OperationalLimitBusinessDelegate.getOperationalLimitInstance()
              .createOperationalLimit(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a OperationalLimit. if no key provided, calls create, otherwise calls save
   *
   * @param OperationalLimit operationalLimit
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateOperationalLimitCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateOperationalLimitCommand
      // -----------------------------------------------
      completableFuture =
          OperationalLimitBusinessDelegate.getOperationalLimitInstance()
              .updateOperationalLimit(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "OperationalLimitController:update() - successfully update OperationalLimit - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a OperationalLimit entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID operationalLimitId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteOperationalLimitCommand command = new DeleteOperationalLimitCommand(operationalLimitId);

    try {
      OperationalLimitBusinessDelegate delegate =
          OperationalLimitBusinessDelegate.getOperationalLimitInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted OperationalLimit with key " + command.getOperationalLimitId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save OperationalLimit on OperationalLimit
   *
   * @param command AssignOperationalLimitToOperationalLimitCommand
   */
  @PutMapping("/addToOperationalLimit")
  public void addToOperationalLimit(
      @RequestBody(required = true) AssignOperationalLimitToOperationalLimitCommand command) {
    try {
      OperationalLimitBusinessDelegate.getOperationalLimitInstance().addToOperationalLimit(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set OperationalLimit", exc);
    }
  }

  /**
   * remove OperationalLimit on OperationalLimit
   *
   * @param command RemoveOperationalLimitFromOperationalLimitCommand
   */
  @PutMapping("/removeFromOperationalLimit")
  public void removeFromOperationalLimit(
      @RequestBody(required = true) RemoveOperationalLimitFromOperationalLimitCommand command) {
    try {
      OperationalLimitBusinessDelegate.getOperationalLimitInstance()
          .removeFromOperationalLimit(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set OperationalLimit", exc);
    }
  }

  /**
   * save OperationalLimitValue on OperationalLimit
   *
   * @param command AssignOperationalLimitValueToOperationalLimitCommand
   */
  @PutMapping("/addToOperationalLimitValue")
  public void addToOperationalLimitValue(
      @RequestBody(required = true) AssignOperationalLimitValueToOperationalLimitCommand command) {
    try {
      OperationalLimitBusinessDelegate.getOperationalLimitInstance()
          .addToOperationalLimitValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set OperationalLimitValue", exc);
    }
  }

  /**
   * remove OperationalLimitValue on OperationalLimit
   *
   * @param command RemoveOperationalLimitValueFromOperationalLimitCommand
   */
  @PutMapping("/removeFromOperationalLimitValue")
  public void removeFromOperationalLimitValue(
      @RequestBody(required = true)
          RemoveOperationalLimitValueFromOperationalLimitCommand command) {
    try {
      OperationalLimitBusinessDelegate.getOperationalLimitInstance()
          .removeFromOperationalLimitValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set OperationalLimitValue", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected OperationalLimit operationalLimit = null;
  private static final Logger LOGGER =
      Logger.getLogger(OperationalLimitCommandRestController.class.getName());
}
