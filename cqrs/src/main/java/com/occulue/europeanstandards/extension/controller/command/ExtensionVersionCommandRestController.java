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
package com.occulue.europeanstandards.extension.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity ExtensionVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExtensionVersion")
public class ExtensionVersionCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExtensionVersion. if not key provided, calls create, otherwise calls save
   *
   * @param ExtensionVersion extensionVersion
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExtensionVersionCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExtensionVersionBusinessDelegate.getExtensionVersionInstance()
              .createExtensionVersion(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExtensionVersion. if no key provided, calls create, otherwise calls save
   *
   * @param ExtensionVersion extensionVersion
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExtensionVersionCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExtensionVersionCommand
      // -----------------------------------------------
      completableFuture =
          ExtensionVersionBusinessDelegate.getExtensionVersionInstance()
              .updateExtensionVersion(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExtensionVersionController:update() - successfully update ExtensionVersion - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExtensionVersion entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID extensionVersionId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExtensionVersionCommand command = new DeleteExtensionVersionCommand(extensionVersionId);

    try {
      ExtensionVersionBusinessDelegate delegate =
          ExtensionVersionBusinessDelegate.getExtensionVersionInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted ExtensionVersion with key " + command.getExtensionVersionId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Date on ExtensionVersion
   *
   * @param command AssignDateToExtensionVersionCommand
   */
  @PutMapping("/assignDate")
  public void assignDate(@RequestBody AssignDateToExtensionVersionCommand command) {
    try {
      ExtensionVersionBusinessDelegate.getExtensionVersionInstance().assignDate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Date", exc);
    }
  }

  /**
   * unassign Date on ExtensionVersion
   *
   * @param command UnAssignDateFromExtensionVersionCommand
   */
  @PutMapping("/unAssignDate")
  public void unAssignDate(
      @RequestBody(required = true) UnAssignDateFromExtensionVersionCommand command) {
    try {
      ExtensionVersionBusinessDelegate.getExtensionVersionInstance().unAssignDate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Date", exc);
    }
  }

  /**
   * save NamespaceURI on ExtensionVersion
   *
   * @param command AssignNamespaceURIToExtensionVersionCommand
   */
  @PutMapping("/assignNamespaceURI")
  public void assignNamespaceURI(@RequestBody AssignNamespaceURIToExtensionVersionCommand command) {
    try {
      ExtensionVersionBusinessDelegate.getExtensionVersionInstance().assignNamespaceURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NamespaceURI", exc);
    }
  }

  /**
   * unassign NamespaceURI on ExtensionVersion
   *
   * @param command UnAssignNamespaceURIFromExtensionVersionCommand
   */
  @PutMapping("/unAssignNamespaceURI")
  public void unAssignNamespaceURI(
      @RequestBody(required = true) UnAssignNamespaceURIFromExtensionVersionCommand command) {
    try {
      ExtensionVersionBusinessDelegate.getExtensionVersionInstance().unAssignNamespaceURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NamespaceURI", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExtensionVersion extensionVersion = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExtensionVersionCommandRestController.class.getName());
}
