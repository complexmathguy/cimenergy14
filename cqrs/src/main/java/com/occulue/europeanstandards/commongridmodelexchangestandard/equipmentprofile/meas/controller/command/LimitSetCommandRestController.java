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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity LimitSet.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LimitSet")
public class LimitSetCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a LimitSet. if not key provided, calls create, otherwise calls save
   *
   * @param LimitSet limitSet
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateLimitSetCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = LimitSetBusinessDelegate.getLimitSetInstance().createLimitSet(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a LimitSet. if no key provided, calls create, otherwise calls save
   *
   * @param LimitSet limitSet
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateLimitSetCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateLimitSetCommand
      // -----------------------------------------------
      completableFuture = LimitSetBusinessDelegate.getLimitSetInstance().updateLimitSet(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "LimitSetController:update() - successfully update LimitSet - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a LimitSet entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID limitSetId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteLimitSetCommand command = new DeleteLimitSetCommand(limitSetId);

    try {
      LimitSetBusinessDelegate delegate = LimitSetBusinessDelegate.getLimitSetInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted LimitSet with key " + command.getLimitSetId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save PercentageLimitsFlag on LimitSet
   *
   * @param command AssignPercentageLimitsFlagToLimitSetCommand
   */
  @PutMapping("/assignPercentageLimitsFlag")
  public void assignPercentageLimitsFlag(
      @RequestBody AssignPercentageLimitsFlagToLimitSetCommand command) {
    try {
      LimitSetBusinessDelegate.getLimitSetInstance().assignPercentageLimitsFlag(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign PercentageLimitsFlag", exc);
    }
  }

  /**
   * unassign PercentageLimitsFlag on LimitSet
   *
   * @param command UnAssignPercentageLimitsFlagFromLimitSetCommand
   */
  @PutMapping("/unAssignPercentageLimitsFlag")
  public void unAssignPercentageLimitsFlag(
      @RequestBody(required = true) UnAssignPercentageLimitsFlagFromLimitSetCommand command) {
    try {
      LimitSetBusinessDelegate.getLimitSetInstance().unAssignPercentageLimitsFlag(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign PercentageLimitsFlag", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected LimitSet limitSet = null;
  private static final Logger LOGGER =
      Logger.getLogger(LimitSetCommandRestController.class.getName());
}
