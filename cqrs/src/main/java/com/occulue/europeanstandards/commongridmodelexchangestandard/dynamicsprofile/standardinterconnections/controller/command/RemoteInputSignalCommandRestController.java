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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardinterconnections.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity RemoteInputSignal.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RemoteInputSignal")
public class RemoteInputSignalCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a RemoteInputSignal. if not key provided, calls create, otherwise calls save
   *
   * @param RemoteInputSignal remoteInputSignal
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateRemoteInputSignalCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          RemoteInputSignalBusinessDelegate.getRemoteInputSignalInstance()
              .createRemoteInputSignal(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a RemoteInputSignal. if no key provided, calls create, otherwise calls save
   *
   * @param RemoteInputSignal remoteInputSignal
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateRemoteInputSignalCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateRemoteInputSignalCommand
      // -----------------------------------------------
      completableFuture =
          RemoteInputSignalBusinessDelegate.getRemoteInputSignalInstance()
              .updateRemoteInputSignal(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "RemoteInputSignalController:update() - successfully update RemoteInputSignal - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a RemoteInputSignal entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID remoteInputSignalId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteRemoteInputSignalCommand command =
        new DeleteRemoteInputSignalCommand(remoteInputSignalId);

    try {
      RemoteInputSignalBusinessDelegate delegate =
          RemoteInputSignalBusinessDelegate.getRemoteInputSignalInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted RemoteInputSignal with key " + command.getRemoteInputSignalId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save RemoteInputSignal on RemoteInputSignal
   *
   * @param command AssignRemoteInputSignalToRemoteInputSignalCommand
   */
  @PutMapping("/addToRemoteInputSignal")
  public void addToRemoteInputSignal(
      @RequestBody(required = true) AssignRemoteInputSignalToRemoteInputSignalCommand command) {
    try {
      RemoteInputSignalBusinessDelegate.getRemoteInputSignalInstance()
          .addToRemoteInputSignal(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set RemoteInputSignal", exc);
    }
  }

  /**
   * remove RemoteInputSignal on RemoteInputSignal
   *
   * @param command RemoveRemoteInputSignalFromRemoteInputSignalCommand
   */
  @PutMapping("/removeFromRemoteInputSignal")
  public void removeFromRemoteInputSignal(
      @RequestBody(required = true) RemoveRemoteInputSignalFromRemoteInputSignalCommand command) {
    try {
      RemoteInputSignalBusinessDelegate.getRemoteInputSignalInstance()
          .removeFromRemoteInputSignal(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set RemoteInputSignal", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected RemoteInputSignal remoteInputSignal = null;
  private static final Logger LOGGER =
      Logger.getLogger(RemoteInputSignalCommandRestController.class.getName());
}
