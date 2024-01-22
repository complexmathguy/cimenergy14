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
 * Implements Spring Controller command CQRS processing for entity VsConverter.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VsConverter")
public class VsConverterCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a VsConverter. if not key provided, calls create, otherwise calls save
   *
   * @param VsConverter vsConverter
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateVsConverterCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          VsConverterBusinessDelegate.getVsConverterInstance().createVsConverter(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a VsConverter. if no key provided, calls create, otherwise calls save
   *
   * @param VsConverter vsConverter
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateVsConverterCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateVsConverterCommand
      // -----------------------------------------------
      completableFuture =
          VsConverterBusinessDelegate.getVsConverterInstance().updateVsConverter(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "VsConverterController:update() - successfully update VsConverter - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a VsConverter entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID vsConverterId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteVsConverterCommand command = new DeleteVsConverterCommand(vsConverterId);

    try {
      VsConverterBusinessDelegate delegate = VsConverterBusinessDelegate.getVsConverterInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted VsConverter with key " + command.getVsConverterId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save MaxModulationIndex on VsConverter
   *
   * @param command AssignMaxModulationIndexToVsConverterCommand
   */
  @PutMapping("/assignMaxModulationIndex")
  public void assignMaxModulationIndex(
      @RequestBody AssignMaxModulationIndexToVsConverterCommand command) {
    try {
      VsConverterBusinessDelegate.getVsConverterInstance().assignMaxModulationIndex(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MaxModulationIndex", exc);
    }
  }

  /**
   * unassign MaxModulationIndex on VsConverter
   *
   * @param command UnAssignMaxModulationIndexFromVsConverterCommand
   */
  @PutMapping("/unAssignMaxModulationIndex")
  public void unAssignMaxModulationIndex(
      @RequestBody(required = true) UnAssignMaxModulationIndexFromVsConverterCommand command) {
    try {
      VsConverterBusinessDelegate.getVsConverterInstance().unAssignMaxModulationIndex(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MaxModulationIndex", exc);
    }
  }

  /**
   * save MaxValveCurrent on VsConverter
   *
   * @param command AssignMaxValveCurrentToVsConverterCommand
   */
  @PutMapping("/assignMaxValveCurrent")
  public void assignMaxValveCurrent(
      @RequestBody AssignMaxValveCurrentToVsConverterCommand command) {
    try {
      VsConverterBusinessDelegate.getVsConverterInstance().assignMaxValveCurrent(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MaxValveCurrent", exc);
    }
  }

  /**
   * unassign MaxValveCurrent on VsConverter
   *
   * @param command UnAssignMaxValveCurrentFromVsConverterCommand
   */
  @PutMapping("/unAssignMaxValveCurrent")
  public void unAssignMaxValveCurrent(
      @RequestBody(required = true) UnAssignMaxValveCurrentFromVsConverterCommand command) {
    try {
      VsConverterBusinessDelegate.getVsConverterInstance().unAssignMaxValveCurrent(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MaxValveCurrent", exc);
    }
  }

  /**
   * save VsConverterDCSides on VsConverter
   *
   * @param command AssignVsConverterDCSidesToVsConverterCommand
   */
  @PutMapping("/addToVsConverterDCSides")
  public void addToVsConverterDCSides(
      @RequestBody(required = true) AssignVsConverterDCSidesToVsConverterCommand command) {
    try {
      VsConverterBusinessDelegate.getVsConverterInstance().addToVsConverterDCSides(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set VsConverterDCSides", exc);
    }
  }

  /**
   * remove VsConverterDCSides on VsConverter
   *
   * @param command RemoveVsConverterDCSidesFromVsConverterCommand
   */
  @PutMapping("/removeFromVsConverterDCSides")
  public void removeFromVsConverterDCSides(
      @RequestBody(required = true) RemoveVsConverterDCSidesFromVsConverterCommand command) {
    try {
      VsConverterBusinessDelegate.getVsConverterInstance().removeFromVsConverterDCSides(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set VsConverterDCSides", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected VsConverter vsConverter = null;
  private static final Logger LOGGER =
      Logger.getLogger(VsConverterCommandRestController.class.getName());
}
