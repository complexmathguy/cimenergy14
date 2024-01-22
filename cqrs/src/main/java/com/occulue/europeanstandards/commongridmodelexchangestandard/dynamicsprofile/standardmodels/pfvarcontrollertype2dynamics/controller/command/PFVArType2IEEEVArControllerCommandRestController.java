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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype2dynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity PFVArType2IEEEVArController.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArType2IEEEVArController")
public class PFVArType2IEEEVArControllerCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PFVArType2IEEEVArController. if not key provided, calls create, otherwise
   * calls save
   *
   * @param PFVArType2IEEEVArController pFVArType2IEEEVArController
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePFVArType2IEEEVArControllerCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance()
              .createPFVArType2IEEEVArController(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PFVArType2IEEEVArController. if no key provided, calls create, otherwise
   * calls save
   *
   * @param PFVArType2IEEEVArController pFVArType2IEEEVArController
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePFVArType2IEEEVArControllerCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePFVArType2IEEEVArControllerCommand
      // -----------------------------------------------
      completableFuture =
          PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance()
              .updatePFVArType2IEEEVArController(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PFVArType2IEEEVArControllerController:update() - successfully update PFVArType2IEEEVArController - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PFVArType2IEEEVArController entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID pFVArType2IEEEVArControllerId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePFVArType2IEEEVArControllerCommand command =
        new DeletePFVArType2IEEEVArControllerCommand(pFVArType2IEEEVArControllerId);

    try {
      PFVArType2IEEEVArControllerBusinessDelegate delegate =
          PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted PFVArType2IEEEVArController with key "
              + command.getPFVArType2IEEEVArControllerId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Exlon on PFVArType2IEEEVArController
   *
   * @param command AssignExlonToPFVArType2IEEEVArControllerCommand
   */
  @PutMapping("/assignExlon")
  public void assignExlon(@RequestBody AssignExlonToPFVArType2IEEEVArControllerCommand command) {
    try {
      PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance()
          .assignExlon(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Exlon", exc);
    }
  }

  /**
   * unassign Exlon on PFVArType2IEEEVArController
   *
   * @param command UnAssignExlonFromPFVArType2IEEEVArControllerCommand
   */
  @PutMapping("/unAssignExlon")
  public void unAssignExlon(
      @RequestBody(required = true) UnAssignExlonFromPFVArType2IEEEVArControllerCommand command) {
    try {
      PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance()
          .unAssignExlon(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Exlon", exc);
    }
  }

  /**
   * save Ki on PFVArType2IEEEVArController
   *
   * @param command AssignKiToPFVArType2IEEEVArControllerCommand
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToPFVArType2IEEEVArControllerCommand command) {
    try {
      PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance()
          .assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on PFVArType2IEEEVArController
   *
   * @param command UnAssignKiFromPFVArType2IEEEVArControllerCommand
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(
      @RequestBody(required = true) UnAssignKiFromPFVArType2IEEEVArControllerCommand command) {
    try {
      PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance()
          .unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Kp on PFVArType2IEEEVArController
   *
   * @param command AssignKpToPFVArType2IEEEVArControllerCommand
   */
  @PutMapping("/assignKp")
  public void assignKp(@RequestBody AssignKpToPFVArType2IEEEVArControllerCommand command) {
    try {
      PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance()
          .assignKp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp", exc);
    }
  }

  /**
   * unassign Kp on PFVArType2IEEEVArController
   *
   * @param command UnAssignKpFromPFVArType2IEEEVArControllerCommand
   */
  @PutMapping("/unAssignKp")
  public void unAssignKp(
      @RequestBody(required = true) UnAssignKpFromPFVArType2IEEEVArControllerCommand command) {
    try {
      PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance()
          .unAssignKp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp", exc);
    }
  }

  /**
   * save Qref on PFVArType2IEEEVArController
   *
   * @param command AssignQrefToPFVArType2IEEEVArControllerCommand
   */
  @PutMapping("/assignQref")
  public void assignQref(@RequestBody AssignQrefToPFVArType2IEEEVArControllerCommand command) {
    try {
      PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance()
          .assignQref(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Qref", exc);
    }
  }

  /**
   * unassign Qref on PFVArType2IEEEVArController
   *
   * @param command UnAssignQrefFromPFVArType2IEEEVArControllerCommand
   */
  @PutMapping("/unAssignQref")
  public void unAssignQref(
      @RequestBody(required = true) UnAssignQrefFromPFVArType2IEEEVArControllerCommand command) {
    try {
      PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance()
          .unAssignQref(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Qref", exc);
    }
  }

  /**
   * save Vclmt on PFVArType2IEEEVArController
   *
   * @param command AssignVclmtToPFVArType2IEEEVArControllerCommand
   */
  @PutMapping("/assignVclmt")
  public void assignVclmt(@RequestBody AssignVclmtToPFVArType2IEEEVArControllerCommand command) {
    try {
      PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance()
          .assignVclmt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vclmt", exc);
    }
  }

  /**
   * unassign Vclmt on PFVArType2IEEEVArController
   *
   * @param command UnAssignVclmtFromPFVArType2IEEEVArControllerCommand
   */
  @PutMapping("/unAssignVclmt")
  public void unAssignVclmt(
      @RequestBody(required = true) UnAssignVclmtFromPFVArType2IEEEVArControllerCommand command) {
    try {
      PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance()
          .unAssignVclmt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vclmt", exc);
    }
  }

  /**
   * save Vref on PFVArType2IEEEVArController
   *
   * @param command AssignVrefToPFVArType2IEEEVArControllerCommand
   */
  @PutMapping("/assignVref")
  public void assignVref(@RequestBody AssignVrefToPFVArType2IEEEVArControllerCommand command) {
    try {
      PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance()
          .assignVref(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vref", exc);
    }
  }

  /**
   * unassign Vref on PFVArType2IEEEVArController
   *
   * @param command UnAssignVrefFromPFVArType2IEEEVArControllerCommand
   */
  @PutMapping("/unAssignVref")
  public void unAssignVref(
      @RequestBody(required = true) UnAssignVrefFromPFVArType2IEEEVArControllerCommand command) {
    try {
      PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance()
          .unAssignVref(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vref", exc);
    }
  }

  /**
   * save Vs on PFVArType2IEEEVArController
   *
   * @param command AssignVsToPFVArType2IEEEVArControllerCommand
   */
  @PutMapping("/assignVs")
  public void assignVs(@RequestBody AssignVsToPFVArType2IEEEVArControllerCommand command) {
    try {
      PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance()
          .assignVs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vs", exc);
    }
  }

  /**
   * unassign Vs on PFVArType2IEEEVArController
   *
   * @param command UnAssignVsFromPFVArType2IEEEVArControllerCommand
   */
  @PutMapping("/unAssignVs")
  public void unAssignVs(
      @RequestBody(required = true) UnAssignVsFromPFVArType2IEEEVArControllerCommand command) {
    try {
      PFVArType2IEEEVArControllerBusinessDelegate.getPFVArType2IEEEVArControllerInstance()
          .unAssignVs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vs", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PFVArType2IEEEVArController pFVArType2IEEEVArController = null;
  private static final Logger LOGGER =
      Logger.getLogger(PFVArType2IEEEVArControllerCommandRestController.class.getName());
}
