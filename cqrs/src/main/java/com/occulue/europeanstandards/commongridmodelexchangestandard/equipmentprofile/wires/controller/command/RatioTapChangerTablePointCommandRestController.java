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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity RatioTapChangerTablePoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RatioTapChangerTablePoint")
public class RatioTapChangerTablePointCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a RatioTapChangerTablePoint. if not key provided, calls create, otherwise calls
   * save
   *
   * @param RatioTapChangerTablePoint ratioTapChangerTablePoint
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateRatioTapChangerTablePointCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          RatioTapChangerTablePointBusinessDelegate.getRatioTapChangerTablePointInstance()
              .createRatioTapChangerTablePoint(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a RatioTapChangerTablePoint. if no key provided, calls create, otherwise calls
   * save
   *
   * @param RatioTapChangerTablePoint ratioTapChangerTablePoint
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateRatioTapChangerTablePointCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateRatioTapChangerTablePointCommand
      // -----------------------------------------------
      completableFuture =
          RatioTapChangerTablePointBusinessDelegate.getRatioTapChangerTablePointInstance()
              .updateRatioTapChangerTablePoint(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "RatioTapChangerTablePointController:update() - successfully update RatioTapChangerTablePoint - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a RatioTapChangerTablePoint entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID ratioTapChangerTablePointId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteRatioTapChangerTablePointCommand command =
        new DeleteRatioTapChangerTablePointCommand(ratioTapChangerTablePointId);

    try {
      RatioTapChangerTablePointBusinessDelegate delegate =
          RatioTapChangerTablePointBusinessDelegate.getRatioTapChangerTablePointInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted RatioTapChangerTablePoint with key "
              + command.getRatioTapChangerTablePointId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save RatioTapChangerTablePoint on RatioTapChangerTablePoint
   *
   * @param command AssignRatioTapChangerTablePointToRatioTapChangerTablePointCommand
   */
  @PutMapping("/addToRatioTapChangerTablePoint")
  public void addToRatioTapChangerTablePoint(
      @RequestBody(required = true)
          AssignRatioTapChangerTablePointToRatioTapChangerTablePointCommand command) {
    try {
      RatioTapChangerTablePointBusinessDelegate.getRatioTapChangerTablePointInstance()
          .addToRatioTapChangerTablePoint(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set RatioTapChangerTablePoint", exc);
    }
  }

  /**
   * remove RatioTapChangerTablePoint on RatioTapChangerTablePoint
   *
   * @param command RemoveRatioTapChangerTablePointFromRatioTapChangerTablePointCommand
   */
  @PutMapping("/removeFromRatioTapChangerTablePoint")
  public void removeFromRatioTapChangerTablePoint(
      @RequestBody(required = true)
          RemoveRatioTapChangerTablePointFromRatioTapChangerTablePointCommand command) {
    try {
      RatioTapChangerTablePointBusinessDelegate.getRatioTapChangerTablePointInstance()
          .removeFromRatioTapChangerTablePoint(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set RatioTapChangerTablePoint", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected RatioTapChangerTablePoint ratioTapChangerTablePoint = null;
  private static final Logger LOGGER =
      Logger.getLogger(RatioTapChangerTablePointCommandRestController.class.getName());
}
