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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity PerLengthDCLineParameter.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PerLengthDCLineParameter")
public class PerLengthDCLineParameterCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PerLengthDCLineParameter. if not key provided, calls create, otherwise calls
   * save
   *
   * @param PerLengthDCLineParameter perLengthDCLineParameter
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePerLengthDCLineParameterCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance()
              .createPerLengthDCLineParameter(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PerLengthDCLineParameter. if no key provided, calls create, otherwise calls
   * save
   *
   * @param PerLengthDCLineParameter perLengthDCLineParameter
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePerLengthDCLineParameterCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePerLengthDCLineParameterCommand
      // -----------------------------------------------
      completableFuture =
          PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance()
              .updatePerLengthDCLineParameter(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PerLengthDCLineParameterController:update() - successfully update PerLengthDCLineParameter - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PerLengthDCLineParameter entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID perLengthDCLineParameterId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePerLengthDCLineParameterCommand command =
        new DeletePerLengthDCLineParameterCommand(perLengthDCLineParameterId);

    try {
      PerLengthDCLineParameterBusinessDelegate delegate =
          PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted PerLengthDCLineParameter with key "
              + command.getPerLengthDCLineParameterId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Capacitance on PerLengthDCLineParameter
   *
   * @param command AssignCapacitanceToPerLengthDCLineParameterCommand
   */
  @PutMapping("/assignCapacitance")
  public void assignCapacitance(
      @RequestBody AssignCapacitanceToPerLengthDCLineParameterCommand command) {
    try {
      PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance()
          .assignCapacitance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Capacitance", exc);
    }
  }

  /**
   * unassign Capacitance on PerLengthDCLineParameter
   *
   * @param command UnAssignCapacitanceFromPerLengthDCLineParameterCommand
   */
  @PutMapping("/unAssignCapacitance")
  public void unAssignCapacitance(
      @RequestBody(required = true)
          UnAssignCapacitanceFromPerLengthDCLineParameterCommand command) {
    try {
      PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance()
          .unAssignCapacitance(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Capacitance", exc);
    }
  }

  /**
   * save Inductance on PerLengthDCLineParameter
   *
   * @param command AssignInductanceToPerLengthDCLineParameterCommand
   */
  @PutMapping("/assignInductance")
  public void assignInductance(
      @RequestBody AssignInductanceToPerLengthDCLineParameterCommand command) {
    try {
      PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance()
          .assignInductance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Inductance", exc);
    }
  }

  /**
   * unassign Inductance on PerLengthDCLineParameter
   *
   * @param command UnAssignInductanceFromPerLengthDCLineParameterCommand
   */
  @PutMapping("/unAssignInductance")
  public void unAssignInductance(
      @RequestBody(required = true) UnAssignInductanceFromPerLengthDCLineParameterCommand command) {
    try {
      PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance()
          .unAssignInductance(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Inductance", exc);
    }
  }

  /**
   * save Resistance on PerLengthDCLineParameter
   *
   * @param command AssignResistanceToPerLengthDCLineParameterCommand
   */
  @PutMapping("/assignResistance")
  public void assignResistance(
      @RequestBody AssignResistanceToPerLengthDCLineParameterCommand command) {
    try {
      PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance()
          .assignResistance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Resistance", exc);
    }
  }

  /**
   * unassign Resistance on PerLengthDCLineParameter
   *
   * @param command UnAssignResistanceFromPerLengthDCLineParameterCommand
   */
  @PutMapping("/unAssignResistance")
  public void unAssignResistance(
      @RequestBody(required = true) UnAssignResistanceFromPerLengthDCLineParameterCommand command) {
    try {
      PerLengthDCLineParameterBusinessDelegate.getPerLengthDCLineParameterInstance()
          .unAssignResistance(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Resistance", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PerLengthDCLineParameter perLengthDCLineParameter = null;
  private static final Logger LOGGER =
      Logger.getLogger(PerLengthDCLineParameterCommandRestController.class.getName());
}
