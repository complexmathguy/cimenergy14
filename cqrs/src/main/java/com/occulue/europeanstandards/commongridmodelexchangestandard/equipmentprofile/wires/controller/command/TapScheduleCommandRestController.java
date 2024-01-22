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
 * Implements Spring Controller command CQRS processing for entity TapSchedule.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TapSchedule")
public class TapScheduleCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a TapSchedule. if not key provided, calls create, otherwise calls save
   *
   * @param TapSchedule tapSchedule
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateTapScheduleCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          TapScheduleBusinessDelegate.getTapScheduleInstance().createTapSchedule(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a TapSchedule. if no key provided, calls create, otherwise calls save
   *
   * @param TapSchedule tapSchedule
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateTapScheduleCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateTapScheduleCommand
      // -----------------------------------------------
      completableFuture =
          TapScheduleBusinessDelegate.getTapScheduleInstance().updateTapSchedule(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "TapScheduleController:update() - successfully update TapSchedule - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a TapSchedule entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID tapScheduleId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteTapScheduleCommand command = new DeleteTapScheduleCommand(tapScheduleId);

    try {
      TapScheduleBusinessDelegate delegate = TapScheduleBusinessDelegate.getTapScheduleInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted TapSchedule with key " + command.getTapScheduleId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save TapSchedules on TapSchedule
   *
   * @param command AssignTapSchedulesToTapScheduleCommand
   */
  @PutMapping("/addToTapSchedules")
  public void addToTapSchedules(
      @RequestBody(required = true) AssignTapSchedulesToTapScheduleCommand command) {
    try {
      TapScheduleBusinessDelegate.getTapScheduleInstance().addToTapSchedules(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set TapSchedules", exc);
    }
  }

  /**
   * remove TapSchedules on TapSchedule
   *
   * @param command RemoveTapSchedulesFromTapScheduleCommand
   */
  @PutMapping("/removeFromTapSchedules")
  public void removeFromTapSchedules(
      @RequestBody(required = true) RemoveTapSchedulesFromTapScheduleCommand command) {
    try {
      TapScheduleBusinessDelegate.getTapScheduleInstance().removeFromTapSchedules(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set TapSchedules", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected TapSchedule tapSchedule = null;
  private static final Logger LOGGER =
      Logger.getLogger(TapScheduleCommandRestController.class.getName());
}
