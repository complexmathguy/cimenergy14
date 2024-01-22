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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity LoadGroup.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadGroup")
public class LoadGroupCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a LoadGroup. if not key provided, calls create, otherwise calls save
   *
   * @param LoadGroup loadGroup
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateLoadGroupCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = LoadGroupBusinessDelegate.getLoadGroupInstance().createLoadGroup(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a LoadGroup. if no key provided, calls create, otherwise calls save
   *
   * @param LoadGroup loadGroup
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateLoadGroupCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateLoadGroupCommand
      // -----------------------------------------------
      completableFuture = LoadGroupBusinessDelegate.getLoadGroupInstance().updateLoadGroup(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "LoadGroupController:update() - successfully update LoadGroup - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a LoadGroup entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID loadGroupId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteLoadGroupCommand command = new DeleteLoadGroupCommand(loadGroupId);

    try {
      LoadGroupBusinessDelegate delegate = LoadGroupBusinessDelegate.getLoadGroupInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted LoadGroup with key " + command.getLoadGroupId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save LoadGroups on LoadGroup
   *
   * @param command AssignLoadGroupsToLoadGroupCommand
   */
  @PutMapping("/addToLoadGroups")
  public void addToLoadGroups(
      @RequestBody(required = true) AssignLoadGroupsToLoadGroupCommand command) {
    try {
      LoadGroupBusinessDelegate.getLoadGroupInstance().addToLoadGroups(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set LoadGroups", exc);
    }
  }

  /**
   * remove LoadGroups on LoadGroup
   *
   * @param command RemoveLoadGroupsFromLoadGroupCommand
   */
  @PutMapping("/removeFromLoadGroups")
  public void removeFromLoadGroups(
      @RequestBody(required = true) RemoveLoadGroupsFromLoadGroupCommand command) {
    try {
      LoadGroupBusinessDelegate.getLoadGroupInstance().removeFromLoadGroups(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set LoadGroups", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected LoadGroup loadGroup = null;
  private static final Logger LOGGER =
      Logger.getLogger(LoadGroupCommandRestController.class.getName());
}
