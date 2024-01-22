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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity Frequency.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Frequency")
public class FrequencyCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Frequency. if not key provided, calls create, otherwise calls save
   *
   * @param Frequency frequency
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateFrequencyCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = FrequencyBusinessDelegate.getFrequencyInstance().createFrequency(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Frequency. if no key provided, calls create, otherwise calls save
   *
   * @param Frequency frequency
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateFrequencyCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateFrequencyCommand
      // -----------------------------------------------
      completableFuture = FrequencyBusinessDelegate.getFrequencyInstance().updateFrequency(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "FrequencyController:update() - successfully update Frequency - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Frequency entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID frequencyId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteFrequencyCommand command = new DeleteFrequencyCommand(frequencyId);

    try {
      FrequencyBusinessDelegate delegate = FrequencyBusinessDelegate.getFrequencyInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted Frequency with key " + command.getFrequencyId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on Frequency
   *
   * @param command AssignValueToFrequencyCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToFrequencyCommand command) {
    try {
      FrequencyBusinessDelegate.getFrequencyInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on Frequency
   *
   * @param command UnAssignValueFromFrequencyCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(
      @RequestBody(required = true) UnAssignValueFromFrequencyCommand command) {
    try {
      FrequencyBusinessDelegate.getFrequencyInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Frequency frequency = null;
  private static final Logger LOGGER =
      Logger.getLogger(FrequencyCommandRestController.class.getName());
}
