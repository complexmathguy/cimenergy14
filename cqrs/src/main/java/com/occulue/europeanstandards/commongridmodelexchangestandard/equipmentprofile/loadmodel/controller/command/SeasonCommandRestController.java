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
 * Implements Spring Controller command CQRS processing for entity Season.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Season")
public class SeasonCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Season. if not key provided, calls create, otherwise calls save
   *
   * @param Season season
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreateSeasonCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = SeasonBusinessDelegate.getSeasonInstance().createSeason(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Season. if no key provided, calls create, otherwise calls save
   *
   * @param Season season
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdateSeasonCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateSeasonCommand
      // -----------------------------------------------
      completableFuture = SeasonBusinessDelegate.getSeasonInstance().updateSeason(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "SeasonController:update() - successfully update Season - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Season entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID seasonId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteSeasonCommand command = new DeleteSeasonCommand(seasonId);

    try {
      SeasonBusinessDelegate delegate = SeasonBusinessDelegate.getSeasonInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted Season with key " + command.getSeasonId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save EndDate on Season
   *
   * @param command AssignEndDateToSeasonCommand
   */
  @PutMapping("/assignEndDate")
  public void assignEndDate(@RequestBody AssignEndDateToSeasonCommand command) {
    try {
      SeasonBusinessDelegate.getSeasonInstance().assignEndDate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EndDate", exc);
    }
  }

  /**
   * unassign EndDate on Season
   *
   * @param command UnAssignEndDateFromSeasonCommand
   */
  @PutMapping("/unAssignEndDate")
  public void unAssignEndDate(
      @RequestBody(required = true) UnAssignEndDateFromSeasonCommand command) {
    try {
      SeasonBusinessDelegate.getSeasonInstance().unAssignEndDate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EndDate", exc);
    }
  }

  /**
   * save StartDate on Season
   *
   * @param command AssignStartDateToSeasonCommand
   */
  @PutMapping("/assignStartDate")
  public void assignStartDate(@RequestBody AssignStartDateToSeasonCommand command) {
    try {
      SeasonBusinessDelegate.getSeasonInstance().assignStartDate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign StartDate", exc);
    }
  }

  /**
   * unassign StartDate on Season
   *
   * @param command UnAssignStartDateFromSeasonCommand
   */
  @PutMapping("/unAssignStartDate")
  public void unAssignStartDate(
      @RequestBody(required = true) UnAssignStartDateFromSeasonCommand command) {
    try {
      SeasonBusinessDelegate.getSeasonInstance().unAssignStartDate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign StartDate", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Season season = null;
  private static final Logger LOGGER =
      Logger.getLogger(SeasonCommandRestController.class.getName());
}
