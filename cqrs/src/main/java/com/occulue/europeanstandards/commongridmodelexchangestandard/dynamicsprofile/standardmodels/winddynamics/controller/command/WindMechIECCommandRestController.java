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
 * Implements Spring Controller command CQRS processing for entity WindMechIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindMechIEC")
public class WindMechIECCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindMechIEC. if not key provided, calls create, otherwise calls save
   *
   * @param WindMechIEC windMechIEC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindMechIECCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindMechIECBusinessDelegate.getWindMechIECInstance().createWindMechIEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindMechIEC. if no key provided, calls create, otherwise calls save
   *
   * @param WindMechIEC windMechIEC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindMechIECCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindMechIECCommand
      // -----------------------------------------------
      completableFuture =
          WindMechIECBusinessDelegate.getWindMechIECInstance().updateWindMechIEC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindMechIECController:update() - successfully update WindMechIEC - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindMechIEC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID windMechIECId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindMechIECCommand command = new DeleteWindMechIECCommand(windMechIECId);

    try {
      WindMechIECBusinessDelegate delegate = WindMechIECBusinessDelegate.getWindMechIECInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted WindMechIEC with key " + command.getWindMechIECId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Cdrt on WindMechIEC
   *
   * @param command AssignCdrtToWindMechIECCommand
   */
  @PutMapping("/assignCdrt")
  public void assignCdrt(@RequestBody AssignCdrtToWindMechIECCommand command) {
    try {
      WindMechIECBusinessDelegate.getWindMechIECInstance().assignCdrt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Cdrt", exc);
    }
  }

  /**
   * unassign Cdrt on WindMechIEC
   *
   * @param command UnAssignCdrtFromWindMechIECCommand
   */
  @PutMapping("/unAssignCdrt")
  public void unAssignCdrt(
      @RequestBody(required = true) UnAssignCdrtFromWindMechIECCommand command) {
    try {
      WindMechIECBusinessDelegate.getWindMechIECInstance().unAssignCdrt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Cdrt", exc);
    }
  }

  /**
   * save Hgen on WindMechIEC
   *
   * @param command AssignHgenToWindMechIECCommand
   */
  @PutMapping("/assignHgen")
  public void assignHgen(@RequestBody AssignHgenToWindMechIECCommand command) {
    try {
      WindMechIECBusinessDelegate.getWindMechIECInstance().assignHgen(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Hgen", exc);
    }
  }

  /**
   * unassign Hgen on WindMechIEC
   *
   * @param command UnAssignHgenFromWindMechIECCommand
   */
  @PutMapping("/unAssignHgen")
  public void unAssignHgen(
      @RequestBody(required = true) UnAssignHgenFromWindMechIECCommand command) {
    try {
      WindMechIECBusinessDelegate.getWindMechIECInstance().unAssignHgen(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Hgen", exc);
    }
  }

  /**
   * save Hwtr on WindMechIEC
   *
   * @param command AssignHwtrToWindMechIECCommand
   */
  @PutMapping("/assignHwtr")
  public void assignHwtr(@RequestBody AssignHwtrToWindMechIECCommand command) {
    try {
      WindMechIECBusinessDelegate.getWindMechIECInstance().assignHwtr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Hwtr", exc);
    }
  }

  /**
   * unassign Hwtr on WindMechIEC
   *
   * @param command UnAssignHwtrFromWindMechIECCommand
   */
  @PutMapping("/unAssignHwtr")
  public void unAssignHwtr(
      @RequestBody(required = true) UnAssignHwtrFromWindMechIECCommand command) {
    try {
      WindMechIECBusinessDelegate.getWindMechIECInstance().unAssignHwtr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Hwtr", exc);
    }
  }

  /**
   * save Kdrt on WindMechIEC
   *
   * @param command AssignKdrtToWindMechIECCommand
   */
  @PutMapping("/assignKdrt")
  public void assignKdrt(@RequestBody AssignKdrtToWindMechIECCommand command) {
    try {
      WindMechIECBusinessDelegate.getWindMechIECInstance().assignKdrt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kdrt", exc);
    }
  }

  /**
   * unassign Kdrt on WindMechIEC
   *
   * @param command UnAssignKdrtFromWindMechIECCommand
   */
  @PutMapping("/unAssignKdrt")
  public void unAssignKdrt(
      @RequestBody(required = true) UnAssignKdrtFromWindMechIECCommand command) {
    try {
      WindMechIECBusinessDelegate.getWindMechIECInstance().unAssignKdrt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kdrt", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindMechIEC windMechIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindMechIECCommandRestController.class.getName());
}
