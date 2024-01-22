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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity Terminal.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Terminal")
public class TerminalCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Terminal. if not key provided, calls create, otherwise calls save
   *
   * @param Terminal terminal
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateTerminalCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = TerminalBusinessDelegate.getTerminalInstance().createTerminal(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Terminal. if no key provided, calls create, otherwise calls save
   *
   * @param Terminal terminal
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateTerminalCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateTerminalCommand
      // -----------------------------------------------
      completableFuture = TerminalBusinessDelegate.getTerminalInstance().updateTerminal(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "TerminalController:update() - successfully update Terminal - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Terminal entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID terminalId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteTerminalCommand command = new DeleteTerminalCommand(terminalId);

    try {
      TerminalBusinessDelegate delegate = TerminalBusinessDelegate.getTerminalInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted Terminal with key " + command.getTerminalId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Terminals on Terminal
   *
   * @param command AssignTerminalsToTerminalCommand
   */
  @PutMapping("/addToTerminals")
  public void addToTerminals(
      @RequestBody(required = true) AssignTerminalsToTerminalCommand command) {
    try {
      TerminalBusinessDelegate.getTerminalInstance().addToTerminals(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set Terminals", exc);
    }
  }

  /**
   * remove Terminals on Terminal
   *
   * @param command RemoveTerminalsFromTerminalCommand
   */
  @PutMapping("/removeFromTerminals")
  public void removeFromTerminals(
      @RequestBody(required = true) RemoveTerminalsFromTerminalCommand command) {
    try {
      TerminalBusinessDelegate.getTerminalInstance().removeFromTerminals(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set Terminals", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Terminal terminal = null;
  private static final Logger LOGGER =
      Logger.getLogger(TerminalCommandRestController.class.getName());
}
