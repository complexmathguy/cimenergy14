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
 * Implements Spring Controller command CQRS processing for entity GovHydroIEEE0.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroIEEE0")
public class GovHydroIEEE0CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovHydroIEEE0. if not key provided, calls create, otherwise calls save
   *
   * @param GovHydroIEEE0 govHydroIEEE0
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovHydroIEEE0Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().createGovHydroIEEE0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovHydroIEEE0. if no key provided, calls create, otherwise calls save
   *
   * @param GovHydroIEEE0 govHydroIEEE0
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovHydroIEEE0Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovHydroIEEE0Command
      // -----------------------------------------------
      completableFuture =
          GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().updateGovHydroIEEE0(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovHydroIEEE0Controller:update() - successfully update GovHydroIEEE0 - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovHydroIEEE0 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govHydroIEEE0Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovHydroIEEE0Command command = new DeleteGovHydroIEEE0Command(govHydroIEEE0Id);

    try {
      GovHydroIEEE0BusinessDelegate delegate =
          GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted GovHydroIEEE0 with key " + command.getGovHydroIEEE0Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save K on GovHydroIEEE0
   *
   * @param command AssignKToGovHydroIEEE0Command
   */
  @PutMapping("/assignK")
  public void assignK(@RequestBody AssignKToGovHydroIEEE0Command command) {
    try {
      GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().assignK(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K", exc);
    }
  }

  /**
   * unassign K on GovHydroIEEE0
   *
   * @param command UnAssignKFromGovHydroIEEE0Command
   */
  @PutMapping("/unAssignK")
  public void unAssignK(@RequestBody(required = true) UnAssignKFromGovHydroIEEE0Command command) {
    try {
      GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().unAssignK(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K", exc);
    }
  }

  /**
   * save Mwbase on GovHydroIEEE0
   *
   * @param command AssignMwbaseToGovHydroIEEE0Command
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovHydroIEEE0Command command) {
    try {
      GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovHydroIEEE0
   *
   * @param command UnAssignMwbaseFromGovHydroIEEE0Command
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovHydroIEEE0Command command) {
    try {
      GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save Pmax on GovHydroIEEE0
   *
   * @param command AssignPmaxToGovHydroIEEE0Command
   */
  @PutMapping("/assignPmax")
  public void assignPmax(@RequestBody AssignPmaxToGovHydroIEEE0Command command) {
    try {
      GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().assignPmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmax", exc);
    }
  }

  /**
   * unassign Pmax on GovHydroIEEE0
   *
   * @param command UnAssignPmaxFromGovHydroIEEE0Command
   */
  @PutMapping("/unAssignPmax")
  public void unAssignPmax(
      @RequestBody(required = true) UnAssignPmaxFromGovHydroIEEE0Command command) {
    try {
      GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().unAssignPmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmax", exc);
    }
  }

  /**
   * save Pmin on GovHydroIEEE0
   *
   * @param command AssignPminToGovHydroIEEE0Command
   */
  @PutMapping("/assignPmin")
  public void assignPmin(@RequestBody AssignPminToGovHydroIEEE0Command command) {
    try {
      GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().assignPmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmin", exc);
    }
  }

  /**
   * unassign Pmin on GovHydroIEEE0
   *
   * @param command UnAssignPminFromGovHydroIEEE0Command
   */
  @PutMapping("/unAssignPmin")
  public void unAssignPmin(
      @RequestBody(required = true) UnAssignPminFromGovHydroIEEE0Command command) {
    try {
      GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().unAssignPmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmin", exc);
    }
  }

  /**
   * save T1 on GovHydroIEEE0
   *
   * @param command AssignT1ToGovHydroIEEE0Command
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToGovHydroIEEE0Command command) {
    try {
      GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on GovHydroIEEE0
   *
   * @param command UnAssignT1FromGovHydroIEEE0Command
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromGovHydroIEEE0Command command) {
    try {
      GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on GovHydroIEEE0
   *
   * @param command AssignT2ToGovHydroIEEE0Command
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToGovHydroIEEE0Command command) {
    try {
      GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on GovHydroIEEE0
   *
   * @param command UnAssignT2FromGovHydroIEEE0Command
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromGovHydroIEEE0Command command) {
    try {
      GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on GovHydroIEEE0
   *
   * @param command AssignT3ToGovHydroIEEE0Command
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToGovHydroIEEE0Command command) {
    try {
      GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on GovHydroIEEE0
   *
   * @param command UnAssignT3FromGovHydroIEEE0Command
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromGovHydroIEEE0Command command) {
    try {
      GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on GovHydroIEEE0
   *
   * @param command AssignT4ToGovHydroIEEE0Command
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToGovHydroIEEE0Command command) {
    try {
      GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on GovHydroIEEE0
   *
   * @param command UnAssignT4FromGovHydroIEEE0Command
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromGovHydroIEEE0Command command) {
    try {
      GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovHydroIEEE0 govHydroIEEE0 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovHydroIEEE0CommandRestController.class.getName());
}
