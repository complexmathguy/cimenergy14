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
 * Implements Spring Controller command CQRS processing for entity AccumulatorLimitSet.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AccumulatorLimitSet")
public class AccumulatorLimitSetCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a AccumulatorLimitSet. if not key provided, calls create, otherwise calls save
   *
   * @param AccumulatorLimitSet accumulatorLimitSet
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateAccumulatorLimitSetCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          AccumulatorLimitSetBusinessDelegate.getAccumulatorLimitSetInstance()
              .createAccumulatorLimitSet(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a AccumulatorLimitSet. if no key provided, calls create, otherwise calls save
   *
   * @param AccumulatorLimitSet accumulatorLimitSet
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateAccumulatorLimitSetCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateAccumulatorLimitSetCommand
      // -----------------------------------------------
      completableFuture =
          AccumulatorLimitSetBusinessDelegate.getAccumulatorLimitSetInstance()
              .updateAccumulatorLimitSet(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "AccumulatorLimitSetController:update() - successfully update AccumulatorLimitSet - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a AccumulatorLimitSet entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID accumulatorLimitSetId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteAccumulatorLimitSetCommand command =
        new DeleteAccumulatorLimitSetCommand(accumulatorLimitSetId);

    try {
      AccumulatorLimitSetBusinessDelegate delegate =
          AccumulatorLimitSetBusinessDelegate.getAccumulatorLimitSetInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted AccumulatorLimitSet with key "
              + command.getAccumulatorLimitSetId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save LimitSets on AccumulatorLimitSet
   *
   * @param command AssignLimitSetsToAccumulatorLimitSetCommand
   */
  @PutMapping("/addToLimitSets")
  public void addToLimitSets(
      @RequestBody(required = true) AssignLimitSetsToAccumulatorLimitSetCommand command) {
    try {
      AccumulatorLimitSetBusinessDelegate.getAccumulatorLimitSetInstance().addToLimitSets(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set LimitSets", exc);
    }
  }

  /**
   * remove LimitSets on AccumulatorLimitSet
   *
   * @param command RemoveLimitSetsFromAccumulatorLimitSetCommand
   */
  @PutMapping("/removeFromLimitSets")
  public void removeFromLimitSets(
      @RequestBody(required = true) RemoveLimitSetsFromAccumulatorLimitSetCommand command) {
    try {
      AccumulatorLimitSetBusinessDelegate.getAccumulatorLimitSetInstance()
          .removeFromLimitSets(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set LimitSets", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected AccumulatorLimitSet accumulatorLimitSet = null;
  private static final Logger LOGGER =
      Logger.getLogger(AccumulatorLimitSetCommandRestController.class.getName());
}
