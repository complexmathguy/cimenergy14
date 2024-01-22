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
 * Implements Spring Controller command CQRS processing for entity ENTSOEIdentifiedObject.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ENTSOEIdentifiedObject")
public class ENTSOEIdentifiedObjectCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ENTSOEIdentifiedObject. if not key provided, calls create, otherwise calls
   * save
   *
   * @param ENTSOEIdentifiedObject eNTSOEIdentifiedObject
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateENTSOEIdentifiedObjectCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ENTSOEIdentifiedObjectBusinessDelegate.getENTSOEIdentifiedObjectInstance()
              .createENTSOEIdentifiedObject(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ENTSOEIdentifiedObject. if no key provided, calls create, otherwise calls
   * save
   *
   * @param ENTSOEIdentifiedObject eNTSOEIdentifiedObject
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateENTSOEIdentifiedObjectCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateENTSOEIdentifiedObjectCommand
      // -----------------------------------------------
      completableFuture =
          ENTSOEIdentifiedObjectBusinessDelegate.getENTSOEIdentifiedObjectInstance()
              .updateENTSOEIdentifiedObject(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ENTSOEIdentifiedObjectController:update() - successfully update ENTSOEIdentifiedObject - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ENTSOEIdentifiedObject entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID eNTSOEIdentifiedObjectId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteENTSOEIdentifiedObjectCommand command =
        new DeleteENTSOEIdentifiedObjectCommand(eNTSOEIdentifiedObjectId);

    try {
      ENTSOEIdentifiedObjectBusinessDelegate delegate =
          ENTSOEIdentifiedObjectBusinessDelegate.getENTSOEIdentifiedObjectInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted ENTSOEIdentifiedObject with key "
              + command.getENTSOEIdentifiedObjectId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save EnergyIdentCodeEic on ENTSOEIdentifiedObject
   *
   * @param command AssignEnergyIdentCodeEicToENTSOEIdentifiedObjectCommand
   */
  @PutMapping("/assignEnergyIdentCodeEic")
  public void assignEnergyIdentCodeEic(
      @RequestBody AssignEnergyIdentCodeEicToENTSOEIdentifiedObjectCommand command) {
    try {
      ENTSOEIdentifiedObjectBusinessDelegate.getENTSOEIdentifiedObjectInstance()
          .assignEnergyIdentCodeEic(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EnergyIdentCodeEic", exc);
    }
  }

  /**
   * unassign EnergyIdentCodeEic on ENTSOEIdentifiedObject
   *
   * @param command UnAssignEnergyIdentCodeEicFromENTSOEIdentifiedObjectCommand
   */
  @PutMapping("/unAssignEnergyIdentCodeEic")
  public void unAssignEnergyIdentCodeEic(
      @RequestBody(required = true)
          UnAssignEnergyIdentCodeEicFromENTSOEIdentifiedObjectCommand command) {
    try {
      ENTSOEIdentifiedObjectBusinessDelegate.getENTSOEIdentifiedObjectInstance()
          .unAssignEnergyIdentCodeEic(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EnergyIdentCodeEic", exc);
    }
  }

  /**
   * save ShortName on ENTSOEIdentifiedObject
   *
   * @param command AssignShortNameToENTSOEIdentifiedObjectCommand
   */
  @PutMapping("/assignShortName")
  public void assignShortName(@RequestBody AssignShortNameToENTSOEIdentifiedObjectCommand command) {
    try {
      ENTSOEIdentifiedObjectBusinessDelegate.getENTSOEIdentifiedObjectInstance()
          .assignShortName(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ShortName", exc);
    }
  }

  /**
   * unassign ShortName on ENTSOEIdentifiedObject
   *
   * @param command UnAssignShortNameFromENTSOEIdentifiedObjectCommand
   */
  @PutMapping("/unAssignShortName")
  public void unAssignShortName(
      @RequestBody(required = true) UnAssignShortNameFromENTSOEIdentifiedObjectCommand command) {
    try {
      ENTSOEIdentifiedObjectBusinessDelegate.getENTSOEIdentifiedObjectInstance()
          .unAssignShortName(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ShortName", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ENTSOEIdentifiedObject eNTSOEIdentifiedObject = null;
  private static final Logger LOGGER =
      Logger.getLogger(ENTSOEIdentifiedObjectCommandRestController.class.getName());
}
