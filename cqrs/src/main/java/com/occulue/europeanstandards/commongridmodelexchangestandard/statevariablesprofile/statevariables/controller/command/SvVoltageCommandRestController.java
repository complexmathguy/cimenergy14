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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity SvVoltage.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SvVoltage")
public class SvVoltageCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a SvVoltage. if not key provided, calls create, otherwise calls save
   *
   * @param SvVoltage svVoltage
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateSvVoltageCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = SvVoltageBusinessDelegate.getSvVoltageInstance().createSvVoltage(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a SvVoltage. if no key provided, calls create, otherwise calls save
   *
   * @param SvVoltage svVoltage
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateSvVoltageCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateSvVoltageCommand
      // -----------------------------------------------
      completableFuture = SvVoltageBusinessDelegate.getSvVoltageInstance().updateSvVoltage(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "SvVoltageController:update() - successfully update SvVoltage - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a SvVoltage entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID svVoltageId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteSvVoltageCommand command = new DeleteSvVoltageCommand(svVoltageId);

    try {
      SvVoltageBusinessDelegate delegate = SvVoltageBusinessDelegate.getSvVoltageInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted SvVoltage with key " + command.getSvVoltageId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Angle on SvVoltage
   *
   * @param command AssignAngleToSvVoltageCommand
   */
  @PutMapping("/assignAngle")
  public void assignAngle(@RequestBody AssignAngleToSvVoltageCommand command) {
    try {
      SvVoltageBusinessDelegate.getSvVoltageInstance().assignAngle(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Angle", exc);
    }
  }

  /**
   * unassign Angle on SvVoltage
   *
   * @param command UnAssignAngleFromSvVoltageCommand
   */
  @PutMapping("/unAssignAngle")
  public void unAssignAngle(
      @RequestBody(required = true) UnAssignAngleFromSvVoltageCommand command) {
    try {
      SvVoltageBusinessDelegate.getSvVoltageInstance().unAssignAngle(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Angle", exc);
    }
  }

  /**
   * save V on SvVoltage
   *
   * @param command AssignVToSvVoltageCommand
   */
  @PutMapping("/assignV")
  public void assignV(@RequestBody AssignVToSvVoltageCommand command) {
    try {
      SvVoltageBusinessDelegate.getSvVoltageInstance().assignV(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign V", exc);
    }
  }

  /**
   * unassign V on SvVoltage
   *
   * @param command UnAssignVFromSvVoltageCommand
   */
  @PutMapping("/unAssignV")
  public void unAssignV(@RequestBody(required = true) UnAssignVFromSvVoltageCommand command) {
    try {
      SvVoltageBusinessDelegate.getSvVoltageInstance().unAssignV(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign V", exc);
    }
  }

  /**
   * save SvVoltage on SvVoltage
   *
   * @param command AssignSvVoltageToSvVoltageCommand
   */
  @PutMapping("/assignSvVoltage")
  public void assignSvVoltage(@RequestBody AssignSvVoltageToSvVoltageCommand command) {
    try {
      SvVoltageBusinessDelegate.getSvVoltageInstance().assignSvVoltage(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SvVoltage", exc);
    }
  }

  /**
   * unassign SvVoltage on SvVoltage
   *
   * @param command UnAssignSvVoltageFromSvVoltageCommand
   */
  @PutMapping("/unAssignSvVoltage")
  public void unAssignSvVoltage(
      @RequestBody(required = true) UnAssignSvVoltageFromSvVoltageCommand command) {
    try {
      SvVoltageBusinessDelegate.getSvVoltageInstance().unAssignSvVoltage(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SvVoltage", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected SvVoltage svVoltage = null;
  private static final Logger LOGGER =
      Logger.getLogger(SvVoltageCommandRestController.class.getName());
}
