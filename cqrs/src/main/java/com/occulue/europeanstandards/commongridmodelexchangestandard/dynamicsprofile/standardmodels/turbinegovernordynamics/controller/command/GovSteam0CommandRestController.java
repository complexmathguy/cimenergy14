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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity GovSteam0.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteam0")
public class GovSteam0CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovSteam0. if not key provided, calls create, otherwise calls save
   *
   * @param GovSteam0 govSteam0
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovSteam0Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = GovSteam0BusinessDelegate.getGovSteam0Instance().createGovSteam0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovSteam0. if no key provided, calls create, otherwise calls save
   *
   * @param GovSteam0 govSteam0
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovSteam0Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovSteam0Command
      // -----------------------------------------------
      completableFuture = GovSteam0BusinessDelegate.getGovSteam0Instance().updateGovSteam0(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovSteam0Controller:update() - successfully update GovSteam0 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovSteam0 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govSteam0Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovSteam0Command command = new DeleteGovSteam0Command(govSteam0Id);

    try {
      GovSteam0BusinessDelegate delegate = GovSteam0BusinessDelegate.getGovSteam0Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovSteam0 with key " + command.getGovSteam0Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Dt on GovSteam0
   *
   * @param command AssignDtToGovSteam0Command
   */
  @PutMapping("/assignDt")
  public void assignDt(@RequestBody AssignDtToGovSteam0Command command) {
    try {
      GovSteam0BusinessDelegate.getGovSteam0Instance().assignDt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dt", exc);
    }
  }

  /**
   * unassign Dt on GovSteam0
   *
   * @param command UnAssignDtFromGovSteam0Command
   */
  @PutMapping("/unAssignDt")
  public void unAssignDt(@RequestBody(required = true) UnAssignDtFromGovSteam0Command command) {
    try {
      GovSteam0BusinessDelegate.getGovSteam0Instance().unAssignDt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dt", exc);
    }
  }

  /**
   * save Mwbase on GovSteam0
   *
   * @param command AssignMwbaseToGovSteam0Command
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovSteam0Command command) {
    try {
      GovSteam0BusinessDelegate.getGovSteam0Instance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovSteam0
   *
   * @param command UnAssignMwbaseFromGovSteam0Command
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovSteam0Command command) {
    try {
      GovSteam0BusinessDelegate.getGovSteam0Instance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save R on GovSteam0
   *
   * @param command AssignRToGovSteam0Command
   */
  @PutMapping("/assignR")
  public void assignR(@RequestBody AssignRToGovSteam0Command command) {
    try {
      GovSteam0BusinessDelegate.getGovSteam0Instance().assignR(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R", exc);
    }
  }

  /**
   * unassign R on GovSteam0
   *
   * @param command UnAssignRFromGovSteam0Command
   */
  @PutMapping("/unAssignR")
  public void unAssignR(@RequestBody(required = true) UnAssignRFromGovSteam0Command command) {
    try {
      GovSteam0BusinessDelegate.getGovSteam0Instance().unAssignR(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R", exc);
    }
  }

  /**
   * save T1 on GovSteam0
   *
   * @param command AssignT1ToGovSteam0Command
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToGovSteam0Command command) {
    try {
      GovSteam0BusinessDelegate.getGovSteam0Instance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on GovSteam0
   *
   * @param command UnAssignT1FromGovSteam0Command
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromGovSteam0Command command) {
    try {
      GovSteam0BusinessDelegate.getGovSteam0Instance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on GovSteam0
   *
   * @param command AssignT2ToGovSteam0Command
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToGovSteam0Command command) {
    try {
      GovSteam0BusinessDelegate.getGovSteam0Instance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on GovSteam0
   *
   * @param command UnAssignT2FromGovSteam0Command
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromGovSteam0Command command) {
    try {
      GovSteam0BusinessDelegate.getGovSteam0Instance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on GovSteam0
   *
   * @param command AssignT3ToGovSteam0Command
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToGovSteam0Command command) {
    try {
      GovSteam0BusinessDelegate.getGovSteam0Instance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on GovSteam0
   *
   * @param command UnAssignT3FromGovSteam0Command
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromGovSteam0Command command) {
    try {
      GovSteam0BusinessDelegate.getGovSteam0Instance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save Vmax on GovSteam0
   *
   * @param command AssignVmaxToGovSteam0Command
   */
  @PutMapping("/assignVmax")
  public void assignVmax(@RequestBody AssignVmaxToGovSteam0Command command) {
    try {
      GovSteam0BusinessDelegate.getGovSteam0Instance().assignVmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmax", exc);
    }
  }

  /**
   * unassign Vmax on GovSteam0
   *
   * @param command UnAssignVmaxFromGovSteam0Command
   */
  @PutMapping("/unAssignVmax")
  public void unAssignVmax(@RequestBody(required = true) UnAssignVmaxFromGovSteam0Command command) {
    try {
      GovSteam0BusinessDelegate.getGovSteam0Instance().unAssignVmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmax", exc);
    }
  }

  /**
   * save Vmin on GovSteam0
   *
   * @param command AssignVminToGovSteam0Command
   */
  @PutMapping("/assignVmin")
  public void assignVmin(@RequestBody AssignVminToGovSteam0Command command) {
    try {
      GovSteam0BusinessDelegate.getGovSteam0Instance().assignVmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmin", exc);
    }
  }

  /**
   * unassign Vmin on GovSteam0
   *
   * @param command UnAssignVminFromGovSteam0Command
   */
  @PutMapping("/unAssignVmin")
  public void unAssignVmin(@RequestBody(required = true) UnAssignVminFromGovSteam0Command command) {
    try {
      GovSteam0BusinessDelegate.getGovSteam0Instance().unAssignVmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovSteam0 govSteam0 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovSteam0CommandRestController.class.getName());
}
