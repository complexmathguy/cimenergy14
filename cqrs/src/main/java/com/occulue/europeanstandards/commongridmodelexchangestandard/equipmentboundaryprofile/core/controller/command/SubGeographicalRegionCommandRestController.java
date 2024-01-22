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
 * Implements Spring Controller command CQRS processing for entity SubGeographicalRegion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SubGeographicalRegion")
public class SubGeographicalRegionCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a SubGeographicalRegion. if not key provided, calls create, otherwise calls save
   *
   * @param SubGeographicalRegion subGeographicalRegion
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateSubGeographicalRegionCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          SubGeographicalRegionBusinessDelegate.getSubGeographicalRegionInstance()
              .createSubGeographicalRegion(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a SubGeographicalRegion. if no key provided, calls create, otherwise calls
   * save
   *
   * @param SubGeographicalRegion subGeographicalRegion
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateSubGeographicalRegionCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateSubGeographicalRegionCommand
      // -----------------------------------------------
      completableFuture =
          SubGeographicalRegionBusinessDelegate.getSubGeographicalRegionInstance()
              .updateSubGeographicalRegion(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "SubGeographicalRegionController:update() - successfully update SubGeographicalRegion - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a SubGeographicalRegion entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID subGeographicalRegionId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteSubGeographicalRegionCommand command =
        new DeleteSubGeographicalRegionCommand(subGeographicalRegionId);

    try {
      SubGeographicalRegionBusinessDelegate delegate =
          SubGeographicalRegionBusinessDelegate.getSubGeographicalRegionInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted SubGeographicalRegion with key "
              + command.getSubGeographicalRegionId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Regions on SubGeographicalRegion
   *
   * @param command AssignRegionsToSubGeographicalRegionCommand
   */
  @PutMapping("/addToRegions")
  public void addToRegions(
      @RequestBody(required = true) AssignRegionsToSubGeographicalRegionCommand command) {
    try {
      SubGeographicalRegionBusinessDelegate.getSubGeographicalRegionInstance()
          .addToRegions(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set Regions", exc);
    }
  }

  /**
   * remove Regions on SubGeographicalRegion
   *
   * @param command RemoveRegionsFromSubGeographicalRegionCommand
   */
  @PutMapping("/removeFromRegions")
  public void removeFromRegions(
      @RequestBody(required = true) RemoveRegionsFromSubGeographicalRegionCommand command) {
    try {
      SubGeographicalRegionBusinessDelegate.getSubGeographicalRegionInstance()
          .removeFromRegions(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set Regions", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected SubGeographicalRegion subGeographicalRegion = null;
  private static final Logger LOGGER =
      Logger.getLogger(SubGeographicalRegionCommandRestController.class.getName());
}
