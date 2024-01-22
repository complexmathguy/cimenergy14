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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity ACDCTerminal.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ACDCTerminal")
public class ACDCTerminalCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ACDCTerminal. if not key provided, calls create, otherwise calls save
   *
   * @param ACDCTerminal aCDCTerminal
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateACDCTerminalCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ACDCTerminalBusinessDelegate.getACDCTerminalInstance().createACDCTerminal(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ACDCTerminal. if no key provided, calls create, otherwise calls save
   *
   * @param ACDCTerminal aCDCTerminal
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateACDCTerminalCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateACDCTerminalCommand
      // -----------------------------------------------
      completableFuture =
          ACDCTerminalBusinessDelegate.getACDCTerminalInstance().updateACDCTerminal(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ACDCTerminalController:update() - successfully update ACDCTerminal - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ACDCTerminal entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID aCDCTerminalId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteACDCTerminalCommand command = new DeleteACDCTerminalCommand(aCDCTerminalId);

    try {
      ACDCTerminalBusinessDelegate delegate =
          ACDCTerminalBusinessDelegate.getACDCTerminalInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted ACDCTerminal with key " + command.getACDCTerminalId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save SequenceNumber on ACDCTerminal
   *
   * @param command AssignSequenceNumberToACDCTerminalCommand
   */
  @PutMapping("/assignSequenceNumber")
  public void assignSequenceNumber(@RequestBody AssignSequenceNumberToACDCTerminalCommand command) {
    try {
      ACDCTerminalBusinessDelegate.getACDCTerminalInstance().assignSequenceNumber(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SequenceNumber", exc);
    }
  }

  /**
   * unassign SequenceNumber on ACDCTerminal
   *
   * @param command UnAssignSequenceNumberFromACDCTerminalCommand
   */
  @PutMapping("/unAssignSequenceNumber")
  public void unAssignSequenceNumber(
      @RequestBody(required = true) UnAssignSequenceNumberFromACDCTerminalCommand command) {
    try {
      ACDCTerminalBusinessDelegate.getACDCTerminalInstance().unAssignSequenceNumber(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SequenceNumber", exc);
    }
  }

  /**
   * save Terminal on ACDCTerminal
   *
   * @param command AssignTerminalToACDCTerminalCommand
   */
  @PutMapping("/addToTerminal")
  public void addToTerminal(
      @RequestBody(required = true) AssignTerminalToACDCTerminalCommand command) {
    try {
      ACDCTerminalBusinessDelegate.getACDCTerminalInstance().addToTerminal(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set Terminal", exc);
    }
  }

  /**
   * remove Terminal on ACDCTerminal
   *
   * @param command RemoveTerminalFromACDCTerminalCommand
   */
  @PutMapping("/removeFromTerminal")
  public void removeFromTerminal(
      @RequestBody(required = true) RemoveTerminalFromACDCTerminalCommand command) {
    try {
      ACDCTerminalBusinessDelegate.getACDCTerminalInstance().removeFromTerminal(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set Terminal", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ACDCTerminal aCDCTerminal = null;
  private static final Logger LOGGER =
      Logger.getLogger(ACDCTerminalCommandRestController.class.getName());
}
