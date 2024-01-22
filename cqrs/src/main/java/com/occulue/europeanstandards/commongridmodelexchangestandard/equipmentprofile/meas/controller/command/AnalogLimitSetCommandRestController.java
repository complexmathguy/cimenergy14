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
 * Implements Spring Controller command CQRS processing for entity AnalogLimitSet.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AnalogLimitSet")
public class AnalogLimitSetCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a AnalogLimitSet. if not key provided, calls create, otherwise calls save
   *
   * @param AnalogLimitSet analogLimitSet
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateAnalogLimitSetCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          AnalogLimitSetBusinessDelegate.getAnalogLimitSetInstance().createAnalogLimitSet(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a AnalogLimitSet. if no key provided, calls create, otherwise calls save
   *
   * @param AnalogLimitSet analogLimitSet
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateAnalogLimitSetCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateAnalogLimitSetCommand
      // -----------------------------------------------
      completableFuture =
          AnalogLimitSetBusinessDelegate.getAnalogLimitSetInstance().updateAnalogLimitSet(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "AnalogLimitSetController:update() - successfully update AnalogLimitSet - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a AnalogLimitSet entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID analogLimitSetId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteAnalogLimitSetCommand command = new DeleteAnalogLimitSetCommand(analogLimitSetId);

    try {
      AnalogLimitSetBusinessDelegate delegate =
          AnalogLimitSetBusinessDelegate.getAnalogLimitSetInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted AnalogLimitSet with key " + command.getAnalogLimitSetId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save LimitSets on AnalogLimitSet
   *
   * @param command AssignLimitSetsToAnalogLimitSetCommand
   */
  @PutMapping("/addToLimitSets")
  public void addToLimitSets(
      @RequestBody(required = true) AssignLimitSetsToAnalogLimitSetCommand command) {
    try {
      AnalogLimitSetBusinessDelegate.getAnalogLimitSetInstance().addToLimitSets(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set LimitSets", exc);
    }
  }

  /**
   * remove LimitSets on AnalogLimitSet
   *
   * @param command RemoveLimitSetsFromAnalogLimitSetCommand
   */
  @PutMapping("/removeFromLimitSets")
  public void removeFromLimitSets(
      @RequestBody(required = true) RemoveLimitSetsFromAnalogLimitSetCommand command) {
    try {
      AnalogLimitSetBusinessDelegate.getAnalogLimitSetInstance().removeFromLimitSets(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set LimitSets", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected AnalogLimitSet analogLimitSet = null;
  private static final Logger LOGGER =
      Logger.getLogger(AnalogLimitSetCommandRestController.class.getName());
}
