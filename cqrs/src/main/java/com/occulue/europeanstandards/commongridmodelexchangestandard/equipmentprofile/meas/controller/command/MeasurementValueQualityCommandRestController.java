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
 * Implements Spring Controller command CQRS processing for entity MeasurementValueQuality.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/MeasurementValueQuality")
public class MeasurementValueQualityCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a MeasurementValueQuality. if not key provided, calls create, otherwise calls
   * save
   *
   * @param MeasurementValueQuality measurementValueQuality
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateMeasurementValueQualityCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          MeasurementValueQualityBusinessDelegate.getMeasurementValueQualityInstance()
              .createMeasurementValueQuality(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a MeasurementValueQuality. if no key provided, calls create, otherwise calls
   * save
   *
   * @param MeasurementValueQuality measurementValueQuality
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateMeasurementValueQualityCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateMeasurementValueQualityCommand
      // -----------------------------------------------
      completableFuture =
          MeasurementValueQualityBusinessDelegate.getMeasurementValueQualityInstance()
              .updateMeasurementValueQuality(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "MeasurementValueQualityController:update() - successfully update MeasurementValueQuality - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a MeasurementValueQuality entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID measurementValueQualityId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteMeasurementValueQualityCommand command =
        new DeleteMeasurementValueQualityCommand(measurementValueQualityId);

    try {
      MeasurementValueQualityBusinessDelegate delegate =
          MeasurementValueQualityBusinessDelegate.getMeasurementValueQualityInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted MeasurementValueQuality with key "
              + command.getMeasurementValueQualityId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save MeasurementValueQuality on MeasurementValueQuality
   *
   * @param command AssignMeasurementValueQualityToMeasurementValueQualityCommand
   */
  @PutMapping("/assignMeasurementValueQuality")
  public void assignMeasurementValueQuality(
      @RequestBody AssignMeasurementValueQualityToMeasurementValueQualityCommand command) {
    try {
      MeasurementValueQualityBusinessDelegate.getMeasurementValueQualityInstance()
          .assignMeasurementValueQuality(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MeasurementValueQuality", exc);
    }
  }

  /**
   * unassign MeasurementValueQuality on MeasurementValueQuality
   *
   * @param command UnAssignMeasurementValueQualityFromMeasurementValueQualityCommand
   */
  @PutMapping("/unAssignMeasurementValueQuality")
  public void unAssignMeasurementValueQuality(
      @RequestBody(required = true)
          UnAssignMeasurementValueQualityFromMeasurementValueQualityCommand command) {
    try {
      MeasurementValueQualityBusinessDelegate.getMeasurementValueQualityInstance()
          .unAssignMeasurementValueQuality(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MeasurementValueQuality", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected MeasurementValueQuality measurementValueQuality = null;
  private static final Logger LOGGER =
      Logger.getLogger(MeasurementValueQualityCommandRestController.class.getName());
}
