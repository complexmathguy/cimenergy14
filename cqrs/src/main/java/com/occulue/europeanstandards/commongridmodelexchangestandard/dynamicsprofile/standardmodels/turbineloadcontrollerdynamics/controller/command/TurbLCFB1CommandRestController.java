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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbineloadcontrollerdynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity TurbLCFB1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TurbLCFB1")
public class TurbLCFB1CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a TurbLCFB1. if not key provided, calls create, otherwise calls save
   *
   * @param TurbLCFB1 turbLCFB1
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateTurbLCFB1Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().createTurbLCFB1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a TurbLCFB1. if no key provided, calls create, otherwise calls save
   *
   * @param TurbLCFB1 turbLCFB1
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateTurbLCFB1Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateTurbLCFB1Command
      // -----------------------------------------------
      completableFuture = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().updateTurbLCFB1(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "TurbLCFB1Controller:update() - successfully update TurbLCFB1 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a TurbLCFB1 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID turbLCFB1Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteTurbLCFB1Command command = new DeleteTurbLCFB1Command(turbLCFB1Id);

    try {
      TurbLCFB1BusinessDelegate delegate = TurbLCFB1BusinessDelegate.getTurbLCFB1Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted TurbLCFB1 with key " + command.getTurbLCFB1Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Db on TurbLCFB1
   *
   * @param command AssignDbToTurbLCFB1Command
   */
  @PutMapping("/assignDb")
  public void assignDb(@RequestBody AssignDbToTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().assignDb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db", exc);
    }
  }

  /**
   * unassign Db on TurbLCFB1
   *
   * @param command UnAssignDbFromTurbLCFB1Command
   */
  @PutMapping("/unAssignDb")
  public void unAssignDb(@RequestBody(required = true) UnAssignDbFromTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().unAssignDb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db", exc);
    }
  }

  /**
   * save Emax on TurbLCFB1
   *
   * @param command AssignEmaxToTurbLCFB1Command
   */
  @PutMapping("/assignEmax")
  public void assignEmax(@RequestBody AssignEmaxToTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().assignEmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Emax", exc);
    }
  }

  /**
   * unassign Emax on TurbLCFB1
   *
   * @param command UnAssignEmaxFromTurbLCFB1Command
   */
  @PutMapping("/unAssignEmax")
  public void unAssignEmax(@RequestBody(required = true) UnAssignEmaxFromTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().unAssignEmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Emax", exc);
    }
  }

  /**
   * save Fb on TurbLCFB1
   *
   * @param command AssignFbToTurbLCFB1Command
   */
  @PutMapping("/assignFb")
  public void assignFb(@RequestBody AssignFbToTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().assignFb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Fb", exc);
    }
  }

  /**
   * unassign Fb on TurbLCFB1
   *
   * @param command UnAssignFbFromTurbLCFB1Command
   */
  @PutMapping("/unAssignFb")
  public void unAssignFb(@RequestBody(required = true) UnAssignFbFromTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().unAssignFb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Fb", exc);
    }
  }

  /**
   * save Fbf on TurbLCFB1
   *
   * @param command AssignFbfToTurbLCFB1Command
   */
  @PutMapping("/assignFbf")
  public void assignFbf(@RequestBody AssignFbfToTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().assignFbf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Fbf", exc);
    }
  }

  /**
   * unassign Fbf on TurbLCFB1
   *
   * @param command UnAssignFbfFromTurbLCFB1Command
   */
  @PutMapping("/unAssignFbf")
  public void unAssignFbf(@RequestBody(required = true) UnAssignFbfFromTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().unAssignFbf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Fbf", exc);
    }
  }

  /**
   * save Irmax on TurbLCFB1
   *
   * @param command AssignIrmaxToTurbLCFB1Command
   */
  @PutMapping("/assignIrmax")
  public void assignIrmax(@RequestBody AssignIrmaxToTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().assignIrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Irmax", exc);
    }
  }

  /**
   * unassign Irmax on TurbLCFB1
   *
   * @param command UnAssignIrmaxFromTurbLCFB1Command
   */
  @PutMapping("/unAssignIrmax")
  public void unAssignIrmax(
      @RequestBody(required = true) UnAssignIrmaxFromTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().unAssignIrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Irmax", exc);
    }
  }

  /**
   * save Ki on TurbLCFB1
   *
   * @param command AssignKiToTurbLCFB1Command
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on TurbLCFB1
   *
   * @param command UnAssignKiFromTurbLCFB1Command
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(@RequestBody(required = true) UnAssignKiFromTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Kp on TurbLCFB1
   *
   * @param command AssignKpToTurbLCFB1Command
   */
  @PutMapping("/assignKp")
  public void assignKp(@RequestBody AssignKpToTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().assignKp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp", exc);
    }
  }

  /**
   * unassign Kp on TurbLCFB1
   *
   * @param command UnAssignKpFromTurbLCFB1Command
   */
  @PutMapping("/unAssignKp")
  public void unAssignKp(@RequestBody(required = true) UnAssignKpFromTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().unAssignKp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp", exc);
    }
  }

  /**
   * save Mwbase on TurbLCFB1
   *
   * @param command AssignMwbaseToTurbLCFB1Command
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on TurbLCFB1
   *
   * @param command UnAssignMwbaseFromTurbLCFB1Command
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save Pbf on TurbLCFB1
   *
   * @param command AssignPbfToTurbLCFB1Command
   */
  @PutMapping("/assignPbf")
  public void assignPbf(@RequestBody AssignPbfToTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().assignPbf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pbf", exc);
    }
  }

  /**
   * unassign Pbf on TurbLCFB1
   *
   * @param command UnAssignPbfFromTurbLCFB1Command
   */
  @PutMapping("/unAssignPbf")
  public void unAssignPbf(@RequestBody(required = true) UnAssignPbfFromTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().unAssignPbf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pbf", exc);
    }
  }

  /**
   * save Pmwset on TurbLCFB1
   *
   * @param command AssignPmwsetToTurbLCFB1Command
   */
  @PutMapping("/assignPmwset")
  public void assignPmwset(@RequestBody AssignPmwsetToTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().assignPmwset(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmwset", exc);
    }
  }

  /**
   * unassign Pmwset on TurbLCFB1
   *
   * @param command UnAssignPmwsetFromTurbLCFB1Command
   */
  @PutMapping("/unAssignPmwset")
  public void unAssignPmwset(
      @RequestBody(required = true) UnAssignPmwsetFromTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().unAssignPmwset(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmwset", exc);
    }
  }

  /**
   * save SpeedReferenceGovernor on TurbLCFB1
   *
   * @param command AssignSpeedReferenceGovernorToTurbLCFB1Command
   */
  @PutMapping("/assignSpeedReferenceGovernor")
  public void assignSpeedReferenceGovernor(
      @RequestBody AssignSpeedReferenceGovernorToTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().assignSpeedReferenceGovernor(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SpeedReferenceGovernor", exc);
    }
  }

  /**
   * unassign SpeedReferenceGovernor on TurbLCFB1
   *
   * @param command UnAssignSpeedReferenceGovernorFromTurbLCFB1Command
   */
  @PutMapping("/unAssignSpeedReferenceGovernor")
  public void unAssignSpeedReferenceGovernor(
      @RequestBody(required = true) UnAssignSpeedReferenceGovernorFromTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().unAssignSpeedReferenceGovernor(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SpeedReferenceGovernor", exc);
    }
  }

  /**
   * save Tpelec on TurbLCFB1
   *
   * @param command AssignTpelecToTurbLCFB1Command
   */
  @PutMapping("/assignTpelec")
  public void assignTpelec(@RequestBody AssignTpelecToTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().assignTpelec(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpelec", exc);
    }
  }

  /**
   * unassign Tpelec on TurbLCFB1
   *
   * @param command UnAssignTpelecFromTurbLCFB1Command
   */
  @PutMapping("/unAssignTpelec")
  public void unAssignTpelec(
      @RequestBody(required = true) UnAssignTpelecFromTurbLCFB1Command command) {
    try {
      TurbLCFB1BusinessDelegate.getTurbLCFB1Instance().unAssignTpelec(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpelec", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected TurbLCFB1 turbLCFB1 = null;
  private static final Logger LOGGER =
      Logger.getLogger(TurbLCFB1CommandRestController.class.getName());
}
