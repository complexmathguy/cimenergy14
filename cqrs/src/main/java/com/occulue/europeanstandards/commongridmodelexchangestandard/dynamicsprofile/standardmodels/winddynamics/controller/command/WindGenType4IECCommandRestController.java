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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity WindGenType4IEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindGenType4IEC")
public class WindGenType4IECCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindGenType4IEC. if not key provided, calls create, otherwise calls save
   *
   * @param WindGenType4IEC windGenType4IEC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindGenType4IECCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindGenType4IECBusinessDelegate.getWindGenType4IECInstance()
              .createWindGenType4IEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindGenType4IEC. if no key provided, calls create, otherwise calls save
   *
   * @param WindGenType4IEC windGenType4IEC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindGenType4IECCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindGenType4IECCommand
      // -----------------------------------------------
      completableFuture =
          WindGenType4IECBusinessDelegate.getWindGenType4IECInstance()
              .updateWindGenType4IEC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindGenType4IECController:update() - successfully update WindGenType4IEC - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindGenType4IEC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID windGenType4IECId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindGenType4IECCommand command = new DeleteWindGenType4IECCommand(windGenType4IECId);

    try {
      WindGenType4IECBusinessDelegate delegate =
          WindGenType4IECBusinessDelegate.getWindGenType4IECInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindGenType4IEC with key " + command.getWindGenType4IECId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Dipmax on WindGenType4IEC
   *
   * @param command AssignDipmaxToWindGenType4IECCommand
   */
  @PutMapping("/assignDipmax")
  public void assignDipmax(@RequestBody AssignDipmaxToWindGenType4IECCommand command) {
    try {
      WindGenType4IECBusinessDelegate.getWindGenType4IECInstance().assignDipmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dipmax", exc);
    }
  }

  /**
   * unassign Dipmax on WindGenType4IEC
   *
   * @param command UnAssignDipmaxFromWindGenType4IECCommand
   */
  @PutMapping("/unAssignDipmax")
  public void unAssignDipmax(
      @RequestBody(required = true) UnAssignDipmaxFromWindGenType4IECCommand command) {
    try {
      WindGenType4IECBusinessDelegate.getWindGenType4IECInstance().unAssignDipmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dipmax", exc);
    }
  }

  /**
   * save Diqmax on WindGenType4IEC
   *
   * @param command AssignDiqmaxToWindGenType4IECCommand
   */
  @PutMapping("/assignDiqmax")
  public void assignDiqmax(@RequestBody AssignDiqmaxToWindGenType4IECCommand command) {
    try {
      WindGenType4IECBusinessDelegate.getWindGenType4IECInstance().assignDiqmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Diqmax", exc);
    }
  }

  /**
   * unassign Diqmax on WindGenType4IEC
   *
   * @param command UnAssignDiqmaxFromWindGenType4IECCommand
   */
  @PutMapping("/unAssignDiqmax")
  public void unAssignDiqmax(
      @RequestBody(required = true) UnAssignDiqmaxFromWindGenType4IECCommand command) {
    try {
      WindGenType4IECBusinessDelegate.getWindGenType4IECInstance().unAssignDiqmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Diqmax", exc);
    }
  }

  /**
   * save Diqmin on WindGenType4IEC
   *
   * @param command AssignDiqminToWindGenType4IECCommand
   */
  @PutMapping("/assignDiqmin")
  public void assignDiqmin(@RequestBody AssignDiqminToWindGenType4IECCommand command) {
    try {
      WindGenType4IECBusinessDelegate.getWindGenType4IECInstance().assignDiqmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Diqmin", exc);
    }
  }

  /**
   * unassign Diqmin on WindGenType4IEC
   *
   * @param command UnAssignDiqminFromWindGenType4IECCommand
   */
  @PutMapping("/unAssignDiqmin")
  public void unAssignDiqmin(
      @RequestBody(required = true) UnAssignDiqminFromWindGenType4IECCommand command) {
    try {
      WindGenType4IECBusinessDelegate.getWindGenType4IECInstance().unAssignDiqmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Diqmin", exc);
    }
  }

  /**
   * save Tg on WindGenType4IEC
   *
   * @param command AssignTgToWindGenType4IECCommand
   */
  @PutMapping("/assignTg")
  public void assignTg(@RequestBody AssignTgToWindGenType4IECCommand command) {
    try {
      WindGenType4IECBusinessDelegate.getWindGenType4IECInstance().assignTg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tg", exc);
    }
  }

  /**
   * unassign Tg on WindGenType4IEC
   *
   * @param command UnAssignTgFromWindGenType4IECCommand
   */
  @PutMapping("/unAssignTg")
  public void unAssignTg(
      @RequestBody(required = true) UnAssignTgFromWindGenType4IECCommand command) {
    try {
      WindGenType4IECBusinessDelegate.getWindGenType4IECInstance().unAssignTg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tg", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindGenType4IEC windGenType4IEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindGenType4IECCommandRestController.class.getName());
}
