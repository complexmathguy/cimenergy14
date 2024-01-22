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
 * Implements Spring Controller command CQRS processing for entity Measurement.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Measurement")
public class MeasurementCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Measurement. if not key provided, calls create, otherwise calls save
   *
   * @param Measurement measurement
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateMeasurementCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          MeasurementBusinessDelegate.getMeasurementInstance().createMeasurement(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Measurement. if no key provided, calls create, otherwise calls save
   *
   * @param Measurement measurement
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateMeasurementCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateMeasurementCommand
      // -----------------------------------------------
      completableFuture =
          MeasurementBusinessDelegate.getMeasurementInstance().updateMeasurement(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "MeasurementController:update() - successfully update Measurement - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Measurement entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID measurementId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteMeasurementCommand command = new DeleteMeasurementCommand(measurementId);

    try {
      MeasurementBusinessDelegate delegate = MeasurementBusinessDelegate.getMeasurementInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted Measurement with key " + command.getMeasurementId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save MeasurementType on Measurement
   *
   * @param command AssignMeasurementTypeToMeasurementCommand
   */
  @PutMapping("/assignMeasurementType")
  public void assignMeasurementType(
      @RequestBody AssignMeasurementTypeToMeasurementCommand command) {
    try {
      MeasurementBusinessDelegate.getMeasurementInstance().assignMeasurementType(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MeasurementType", exc);
    }
  }

  /**
   * unassign MeasurementType on Measurement
   *
   * @param command UnAssignMeasurementTypeFromMeasurementCommand
   */
  @PutMapping("/unAssignMeasurementType")
  public void unAssignMeasurementType(
      @RequestBody(required = true) UnAssignMeasurementTypeFromMeasurementCommand command) {
    try {
      MeasurementBusinessDelegate.getMeasurementInstance().unAssignMeasurementType(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MeasurementType", exc);
    }
  }

  /**
   * save Measurements on Measurement
   *
   * @param command AssignMeasurementsToMeasurementCommand
   */
  @PutMapping("/addToMeasurements")
  public void addToMeasurements(
      @RequestBody(required = true) AssignMeasurementsToMeasurementCommand command) {
    try {
      MeasurementBusinessDelegate.getMeasurementInstance().addToMeasurements(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set Measurements", exc);
    }
  }

  /**
   * remove Measurements on Measurement
   *
   * @param command RemoveMeasurementsFromMeasurementCommand
   */
  @PutMapping("/removeFromMeasurements")
  public void removeFromMeasurements(
      @RequestBody(required = true) RemoveMeasurementsFromMeasurementCommand command) {
    try {
      MeasurementBusinessDelegate.getMeasurementInstance().removeFromMeasurements(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set Measurements", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Measurement measurement = null;
  private static final Logger LOGGER =
      Logger.getLogger(MeasurementCommandRestController.class.getName());
}
