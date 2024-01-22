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
 * Implements Spring Controller command CQRS processing for entity DCTerminal.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCTerminal")
public class DCTerminalCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a DCTerminal. if not key provided, calls create, otherwise calls save
   *
   * @param DCTerminal dCTerminal
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateDCTerminalCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          DCTerminalBusinessDelegate.getDCTerminalInstance().createDCTerminal(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a DCTerminal. if no key provided, calls create, otherwise calls save
   *
   * @param DCTerminal dCTerminal
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateDCTerminalCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateDCTerminalCommand
      // -----------------------------------------------
      completableFuture =
          DCTerminalBusinessDelegate.getDCTerminalInstance().updateDCTerminal(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "DCTerminalController:update() - successfully update DCTerminal - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a DCTerminal entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID dCTerminalId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteDCTerminalCommand command = new DeleteDCTerminalCommand(dCTerminalId);

    try {
      DCTerminalBusinessDelegate delegate = DCTerminalBusinessDelegate.getDCTerminalInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted DCTerminal with key " + command.getDCTerminalId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save DCTerminals on DCTerminal
   *
   * @param command AssignDCTerminalsToDCTerminalCommand
   */
  @PutMapping("/addToDCTerminals")
  public void addToDCTerminals(
      @RequestBody(required = true) AssignDCTerminalsToDCTerminalCommand command) {
    try {
      DCTerminalBusinessDelegate.getDCTerminalInstance().addToDCTerminals(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set DCTerminals", exc);
    }
  }

  /**
   * remove DCTerminals on DCTerminal
   *
   * @param command RemoveDCTerminalsFromDCTerminalCommand
   */
  @PutMapping("/removeFromDCTerminals")
  public void removeFromDCTerminals(
      @RequestBody(required = true) RemoveDCTerminalsFromDCTerminalCommand command) {
    try {
      DCTerminalBusinessDelegate.getDCTerminalInstance().removeFromDCTerminals(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set DCTerminals", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DCTerminal dCTerminal = null;
  private static final Logger LOGGER =
      Logger.getLogger(DCTerminalCommandRestController.class.getName());
}
