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
 * Implements Spring Controller command CQRS processing for entity LinearShuntCompensator.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LinearShuntCompensator")
public class LinearShuntCompensatorCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a LinearShuntCompensator. if not key provided, calls create, otherwise calls
   * save
   *
   * @param LinearShuntCompensator linearShuntCompensator
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateLinearShuntCompensatorCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance()
              .createLinearShuntCompensator(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a LinearShuntCompensator. if no key provided, calls create, otherwise calls
   * save
   *
   * @param LinearShuntCompensator linearShuntCompensator
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateLinearShuntCompensatorCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateLinearShuntCompensatorCommand
      // -----------------------------------------------
      completableFuture =
          LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance()
              .updateLinearShuntCompensator(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "LinearShuntCompensatorController:update() - successfully update LinearShuntCompensator - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a LinearShuntCompensator entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID linearShuntCompensatorId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteLinearShuntCompensatorCommand command =
        new DeleteLinearShuntCompensatorCommand(linearShuntCompensatorId);

    try {
      LinearShuntCompensatorBusinessDelegate delegate =
          LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted LinearShuntCompensator with key "
              + command.getLinearShuntCompensatorId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save B0PerSection on LinearShuntCompensator
   *
   * @param command AssignB0PerSectionToLinearShuntCompensatorCommand
   */
  @PutMapping("/assignB0PerSection")
  public void assignB0PerSection(
      @RequestBody AssignB0PerSectionToLinearShuntCompensatorCommand command) {
    try {
      LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance()
          .assignB0PerSection(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign B0PerSection", exc);
    }
  }

  /**
   * unassign B0PerSection on LinearShuntCompensator
   *
   * @param command UnAssignB0PerSectionFromLinearShuntCompensatorCommand
   */
  @PutMapping("/unAssignB0PerSection")
  public void unAssignB0PerSection(
      @RequestBody(required = true) UnAssignB0PerSectionFromLinearShuntCompensatorCommand command) {
    try {
      LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance()
          .unAssignB0PerSection(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign B0PerSection", exc);
    }
  }

  /**
   * save BPerSection on LinearShuntCompensator
   *
   * @param command AssignBPerSectionToLinearShuntCompensatorCommand
   */
  @PutMapping("/assignBPerSection")
  public void assignBPerSection(
      @RequestBody AssignBPerSectionToLinearShuntCompensatorCommand command) {
    try {
      LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance()
          .assignBPerSection(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BPerSection", exc);
    }
  }

  /**
   * unassign BPerSection on LinearShuntCompensator
   *
   * @param command UnAssignBPerSectionFromLinearShuntCompensatorCommand
   */
  @PutMapping("/unAssignBPerSection")
  public void unAssignBPerSection(
      @RequestBody(required = true) UnAssignBPerSectionFromLinearShuntCompensatorCommand command) {
    try {
      LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance()
          .unAssignBPerSection(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BPerSection", exc);
    }
  }

  /**
   * save G0PerSection on LinearShuntCompensator
   *
   * @param command AssignG0PerSectionToLinearShuntCompensatorCommand
   */
  @PutMapping("/assignG0PerSection")
  public void assignG0PerSection(
      @RequestBody AssignG0PerSectionToLinearShuntCompensatorCommand command) {
    try {
      LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance()
          .assignG0PerSection(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign G0PerSection", exc);
    }
  }

  /**
   * unassign G0PerSection on LinearShuntCompensator
   *
   * @param command UnAssignG0PerSectionFromLinearShuntCompensatorCommand
   */
  @PutMapping("/unAssignG0PerSection")
  public void unAssignG0PerSection(
      @RequestBody(required = true) UnAssignG0PerSectionFromLinearShuntCompensatorCommand command) {
    try {
      LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance()
          .unAssignG0PerSection(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign G0PerSection", exc);
    }
  }

  /**
   * save GPerSection on LinearShuntCompensator
   *
   * @param command AssignGPerSectionToLinearShuntCompensatorCommand
   */
  @PutMapping("/assignGPerSection")
  public void assignGPerSection(
      @RequestBody AssignGPerSectionToLinearShuntCompensatorCommand command) {
    try {
      LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance()
          .assignGPerSection(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign GPerSection", exc);
    }
  }

  /**
   * unassign GPerSection on LinearShuntCompensator
   *
   * @param command UnAssignGPerSectionFromLinearShuntCompensatorCommand
   */
  @PutMapping("/unAssignGPerSection")
  public void unAssignGPerSection(
      @RequestBody(required = true) UnAssignGPerSectionFromLinearShuntCompensatorCommand command) {
    try {
      LinearShuntCompensatorBusinessDelegate.getLinearShuntCompensatorInstance()
          .unAssignGPerSection(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign GPerSection", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected LinearShuntCompensator linearShuntCompensator = null;
  private static final Logger LOGGER =
      Logger.getLogger(LinearShuntCompensatorCommandRestController.class.getName());
}
