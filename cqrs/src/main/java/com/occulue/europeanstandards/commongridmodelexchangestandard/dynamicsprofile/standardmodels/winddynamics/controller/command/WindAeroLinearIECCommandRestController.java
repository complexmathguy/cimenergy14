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
 * Implements Spring Controller command CQRS processing for entity WindAeroLinearIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindAeroLinearIEC")
public class WindAeroLinearIECCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindAeroLinearIEC. if not key provided, calls create, otherwise calls save
   *
   * @param WindAeroLinearIEC windAeroLinearIEC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindAeroLinearIECCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance()
              .createWindAeroLinearIEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindAeroLinearIEC. if no key provided, calls create, otherwise calls save
   *
   * @param WindAeroLinearIEC windAeroLinearIEC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindAeroLinearIECCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindAeroLinearIECCommand
      // -----------------------------------------------
      completableFuture =
          WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance()
              .updateWindAeroLinearIEC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindAeroLinearIECController:update() - successfully update WindAeroLinearIEC - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindAeroLinearIEC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID windAeroLinearIECId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindAeroLinearIECCommand command =
        new DeleteWindAeroLinearIECCommand(windAeroLinearIECId);

    try {
      WindAeroLinearIECBusinessDelegate delegate =
          WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindAeroLinearIEC with key " + command.getWindAeroLinearIECId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Dpomega on WindAeroLinearIEC
   *
   * @param command AssignDpomegaToWindAeroLinearIECCommand
   */
  @PutMapping("/assignDpomega")
  public void assignDpomega(@RequestBody AssignDpomegaToWindAeroLinearIECCommand command) {
    try {
      WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance().assignDpomega(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dpomega", exc);
    }
  }

  /**
   * unassign Dpomega on WindAeroLinearIEC
   *
   * @param command UnAssignDpomegaFromWindAeroLinearIECCommand
   */
  @PutMapping("/unAssignDpomega")
  public void unAssignDpomega(
      @RequestBody(required = true) UnAssignDpomegaFromWindAeroLinearIECCommand command) {
    try {
      WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance().unAssignDpomega(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dpomega", exc);
    }
  }

  /**
   * save Dptheta on WindAeroLinearIEC
   *
   * @param command AssignDpthetaToWindAeroLinearIECCommand
   */
  @PutMapping("/assignDptheta")
  public void assignDptheta(@RequestBody AssignDpthetaToWindAeroLinearIECCommand command) {
    try {
      WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance().assignDptheta(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dptheta", exc);
    }
  }

  /**
   * unassign Dptheta on WindAeroLinearIEC
   *
   * @param command UnAssignDpthetaFromWindAeroLinearIECCommand
   */
  @PutMapping("/unAssignDptheta")
  public void unAssignDptheta(
      @RequestBody(required = true) UnAssignDpthetaFromWindAeroLinearIECCommand command) {
    try {
      WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance().unAssignDptheta(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dptheta", exc);
    }
  }

  /**
   * save Omegazero on WindAeroLinearIEC
   *
   * @param command AssignOmegazeroToWindAeroLinearIECCommand
   */
  @PutMapping("/assignOmegazero")
  public void assignOmegazero(@RequestBody AssignOmegazeroToWindAeroLinearIECCommand command) {
    try {
      WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance().assignOmegazero(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Omegazero", exc);
    }
  }

  /**
   * unassign Omegazero on WindAeroLinearIEC
   *
   * @param command UnAssignOmegazeroFromWindAeroLinearIECCommand
   */
  @PutMapping("/unAssignOmegazero")
  public void unAssignOmegazero(
      @RequestBody(required = true) UnAssignOmegazeroFromWindAeroLinearIECCommand command) {
    try {
      WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance().unAssignOmegazero(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Omegazero", exc);
    }
  }

  /**
   * save Pavail on WindAeroLinearIEC
   *
   * @param command AssignPavailToWindAeroLinearIECCommand
   */
  @PutMapping("/assignPavail")
  public void assignPavail(@RequestBody AssignPavailToWindAeroLinearIECCommand command) {
    try {
      WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance().assignPavail(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pavail", exc);
    }
  }

  /**
   * unassign Pavail on WindAeroLinearIEC
   *
   * @param command UnAssignPavailFromWindAeroLinearIECCommand
   */
  @PutMapping("/unAssignPavail")
  public void unAssignPavail(
      @RequestBody(required = true) UnAssignPavailFromWindAeroLinearIECCommand command) {
    try {
      WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance().unAssignPavail(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pavail", exc);
    }
  }

  /**
   * save Thetazero on WindAeroLinearIEC
   *
   * @param command AssignThetazeroToWindAeroLinearIECCommand
   */
  @PutMapping("/assignThetazero")
  public void assignThetazero(@RequestBody AssignThetazeroToWindAeroLinearIECCommand command) {
    try {
      WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance().assignThetazero(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Thetazero", exc);
    }
  }

  /**
   * unassign Thetazero on WindAeroLinearIEC
   *
   * @param command UnAssignThetazeroFromWindAeroLinearIECCommand
   */
  @PutMapping("/unAssignThetazero")
  public void unAssignThetazero(
      @RequestBody(required = true) UnAssignThetazeroFromWindAeroLinearIECCommand command) {
    try {
      WindAeroLinearIECBusinessDelegate.getWindAeroLinearIECInstance().unAssignThetazero(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Thetazero", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindAeroLinearIEC windAeroLinearIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindAeroLinearIECCommandRestController.class.getName());
}
