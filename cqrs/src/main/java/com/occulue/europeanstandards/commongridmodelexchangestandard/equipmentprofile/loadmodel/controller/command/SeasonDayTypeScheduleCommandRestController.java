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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity SeasonDayTypeSchedule.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SeasonDayTypeSchedule")
public class SeasonDayTypeScheduleCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a SeasonDayTypeSchedule. if not key provided, calls create, otherwise calls save
   *
   * @param SeasonDayTypeSchedule seasonDayTypeSchedule
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateSeasonDayTypeScheduleCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          SeasonDayTypeScheduleBusinessDelegate.getSeasonDayTypeScheduleInstance()
              .createSeasonDayTypeSchedule(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a SeasonDayTypeSchedule. if no key provided, calls create, otherwise calls
   * save
   *
   * @param SeasonDayTypeSchedule seasonDayTypeSchedule
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateSeasonDayTypeScheduleCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateSeasonDayTypeScheduleCommand
      // -----------------------------------------------
      completableFuture =
          SeasonDayTypeScheduleBusinessDelegate.getSeasonDayTypeScheduleInstance()
              .updateSeasonDayTypeSchedule(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "SeasonDayTypeScheduleController:update() - successfully update SeasonDayTypeSchedule - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a SeasonDayTypeSchedule entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID seasonDayTypeScheduleId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteSeasonDayTypeScheduleCommand command =
        new DeleteSeasonDayTypeScheduleCommand(seasonDayTypeScheduleId);

    try {
      SeasonDayTypeScheduleBusinessDelegate delegate =
          SeasonDayTypeScheduleBusinessDelegate.getSeasonDayTypeScheduleInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted SeasonDayTypeSchedule with key "
              + command.getSeasonDayTypeScheduleId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save SeasonDayTypeSchedules on SeasonDayTypeSchedule
   *
   * @param command AssignSeasonDayTypeSchedulesToSeasonDayTypeScheduleCommand
   */
  @PutMapping("/addToSeasonDayTypeSchedules")
  public void addToSeasonDayTypeSchedules(
      @RequestBody(required = true)
          AssignSeasonDayTypeSchedulesToSeasonDayTypeScheduleCommand command) {
    try {
      SeasonDayTypeScheduleBusinessDelegate.getSeasonDayTypeScheduleInstance()
          .addToSeasonDayTypeSchedules(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set SeasonDayTypeSchedules", exc);
    }
  }

  /**
   * remove SeasonDayTypeSchedules on SeasonDayTypeSchedule
   *
   * @param command RemoveSeasonDayTypeSchedulesFromSeasonDayTypeScheduleCommand
   */
  @PutMapping("/removeFromSeasonDayTypeSchedules")
  public void removeFromSeasonDayTypeSchedules(
      @RequestBody(required = true)
          RemoveSeasonDayTypeSchedulesFromSeasonDayTypeScheduleCommand command) {
    try {
      SeasonDayTypeScheduleBusinessDelegate.getSeasonDayTypeScheduleInstance()
          .removeFromSeasonDayTypeSchedules(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set SeasonDayTypeSchedules", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected SeasonDayTypeSchedule seasonDayTypeSchedule = null;
  private static final Logger LOGGER =
      Logger.getLogger(SeasonDayTypeScheduleCommandRestController.class.getName());
}
