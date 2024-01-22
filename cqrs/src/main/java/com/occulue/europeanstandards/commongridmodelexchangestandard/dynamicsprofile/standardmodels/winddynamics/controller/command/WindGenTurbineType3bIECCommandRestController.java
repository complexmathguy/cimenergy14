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
 * Implements Spring Controller command CQRS processing for entity WindGenTurbineType3bIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindGenTurbineType3bIEC")
public class WindGenTurbineType3bIECCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindGenTurbineType3bIEC. if not key provided, calls create, otherwise calls
   * save
   *
   * @param WindGenTurbineType3bIEC windGenTurbineType3bIEC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindGenTurbineType3bIECCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance()
              .createWindGenTurbineType3bIEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindGenTurbineType3bIEC. if no key provided, calls create, otherwise calls
   * save
   *
   * @param WindGenTurbineType3bIEC windGenTurbineType3bIEC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindGenTurbineType3bIECCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindGenTurbineType3bIECCommand
      // -----------------------------------------------
      completableFuture =
          WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance()
              .updateWindGenTurbineType3bIEC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindGenTurbineType3bIECController:update() - successfully update WindGenTurbineType3bIEC - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindGenTurbineType3bIEC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID windGenTurbineType3bIECId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindGenTurbineType3bIECCommand command =
        new DeleteWindGenTurbineType3bIECCommand(windGenTurbineType3bIECId);

    try {
      WindGenTurbineType3bIECBusinessDelegate delegate =
          WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindGenTurbineType3bIEC with key "
              + command.getWindGenTurbineType3bIECId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Fducw on WindGenTurbineType3bIEC
   *
   * @param command AssignFducwToWindGenTurbineType3bIECCommand
   */
  @PutMapping("/assignFducw")
  public void assignFducw(@RequestBody AssignFducwToWindGenTurbineType3bIECCommand command) {
    try {
      WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance()
          .assignFducw(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Fducw", exc);
    }
  }

  /**
   * unassign Fducw on WindGenTurbineType3bIEC
   *
   * @param command UnAssignFducwFromWindGenTurbineType3bIECCommand
   */
  @PutMapping("/unAssignFducw")
  public void unAssignFducw(
      @RequestBody(required = true) UnAssignFducwFromWindGenTurbineType3bIECCommand command) {
    try {
      WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance()
          .unAssignFducw(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Fducw", exc);
    }
  }

  /**
   * save Mwtcwp on WindGenTurbineType3bIEC
   *
   * @param command AssignMwtcwpToWindGenTurbineType3bIECCommand
   */
  @PutMapping("/assignMwtcwp")
  public void assignMwtcwp(@RequestBody AssignMwtcwpToWindGenTurbineType3bIECCommand command) {
    try {
      WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance()
          .assignMwtcwp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwtcwp", exc);
    }
  }

  /**
   * unassign Mwtcwp on WindGenTurbineType3bIEC
   *
   * @param command UnAssignMwtcwpFromWindGenTurbineType3bIECCommand
   */
  @PutMapping("/unAssignMwtcwp")
  public void unAssignMwtcwp(
      @RequestBody(required = true) UnAssignMwtcwpFromWindGenTurbineType3bIECCommand command) {
    try {
      WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance()
          .unAssignMwtcwp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwtcwp", exc);
    }
  }

  /**
   * save Tg on WindGenTurbineType3bIEC
   *
   * @param command AssignTgToWindGenTurbineType3bIECCommand
   */
  @PutMapping("/assignTg")
  public void assignTg(@RequestBody AssignTgToWindGenTurbineType3bIECCommand command) {
    try {
      WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance()
          .assignTg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tg", exc);
    }
  }

  /**
   * unassign Tg on WindGenTurbineType3bIEC
   *
   * @param command UnAssignTgFromWindGenTurbineType3bIECCommand
   */
  @PutMapping("/unAssignTg")
  public void unAssignTg(
      @RequestBody(required = true) UnAssignTgFromWindGenTurbineType3bIECCommand command) {
    try {
      WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance()
          .unAssignTg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tg", exc);
    }
  }

  /**
   * save Two on WindGenTurbineType3bIEC
   *
   * @param command AssignTwoToWindGenTurbineType3bIECCommand
   */
  @PutMapping("/assignTwo")
  public void assignTwo(@RequestBody AssignTwoToWindGenTurbineType3bIECCommand command) {
    try {
      WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance()
          .assignTwo(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Two", exc);
    }
  }

  /**
   * unassign Two on WindGenTurbineType3bIEC
   *
   * @param command UnAssignTwoFromWindGenTurbineType3bIECCommand
   */
  @PutMapping("/unAssignTwo")
  public void unAssignTwo(
      @RequestBody(required = true) UnAssignTwoFromWindGenTurbineType3bIECCommand command) {
    try {
      WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance()
          .unAssignTwo(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Two", exc);
    }
  }

  /**
   * save Xs on WindGenTurbineType3bIEC
   *
   * @param command AssignXsToWindGenTurbineType3bIECCommand
   */
  @PutMapping("/assignXs")
  public void assignXs(@RequestBody AssignXsToWindGenTurbineType3bIECCommand command) {
    try {
      WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance()
          .assignXs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xs", exc);
    }
  }

  /**
   * unassign Xs on WindGenTurbineType3bIEC
   *
   * @param command UnAssignXsFromWindGenTurbineType3bIECCommand
   */
  @PutMapping("/unAssignXs")
  public void unAssignXs(
      @RequestBody(required = true) UnAssignXsFromWindGenTurbineType3bIECCommand command) {
    try {
      WindGenTurbineType3bIECBusinessDelegate.getWindGenTurbineType3bIECInstance()
          .unAssignXs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xs", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindGenTurbineType3bIEC windGenTurbineType3bIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindGenTurbineType3bIECCommandRestController.class.getName());
}
