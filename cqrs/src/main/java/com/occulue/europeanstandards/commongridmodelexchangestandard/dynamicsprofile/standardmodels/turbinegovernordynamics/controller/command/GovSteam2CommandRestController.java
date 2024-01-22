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
 * Implements Spring Controller command CQRS processing for entity GovSteam2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteam2")
public class GovSteam2CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovSteam2. if not key provided, calls create, otherwise calls save
   *
   * @param GovSteam2 govSteam2
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovSteam2Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = GovSteam2BusinessDelegate.getGovSteam2Instance().createGovSteam2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovSteam2. if no key provided, calls create, otherwise calls save
   *
   * @param GovSteam2 govSteam2
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovSteam2Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovSteam2Command
      // -----------------------------------------------
      completableFuture = GovSteam2BusinessDelegate.getGovSteam2Instance().updateGovSteam2(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovSteam2Controller:update() - successfully update GovSteam2 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovSteam2 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govSteam2Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovSteam2Command command = new DeleteGovSteam2Command(govSteam2Id);

    try {
      GovSteam2BusinessDelegate delegate = GovSteam2BusinessDelegate.getGovSteam2Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovSteam2 with key " + command.getGovSteam2Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Dbf on GovSteam2
   *
   * @param command AssignDbfToGovSteam2Command
   */
  @PutMapping("/assignDbf")
  public void assignDbf(@RequestBody AssignDbfToGovSteam2Command command) {
    try {
      GovSteam2BusinessDelegate.getGovSteam2Instance().assignDbf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dbf", exc);
    }
  }

  /**
   * unassign Dbf on GovSteam2
   *
   * @param command UnAssignDbfFromGovSteam2Command
   */
  @PutMapping("/unAssignDbf")
  public void unAssignDbf(@RequestBody(required = true) UnAssignDbfFromGovSteam2Command command) {
    try {
      GovSteam2BusinessDelegate.getGovSteam2Instance().unAssignDbf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dbf", exc);
    }
  }

  /**
   * save K on GovSteam2
   *
   * @param command AssignKToGovSteam2Command
   */
  @PutMapping("/assignK")
  public void assignK(@RequestBody AssignKToGovSteam2Command command) {
    try {
      GovSteam2BusinessDelegate.getGovSteam2Instance().assignK(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K", exc);
    }
  }

  /**
   * unassign K on GovSteam2
   *
   * @param command UnAssignKFromGovSteam2Command
   */
  @PutMapping("/unAssignK")
  public void unAssignK(@RequestBody(required = true) UnAssignKFromGovSteam2Command command) {
    try {
      GovSteam2BusinessDelegate.getGovSteam2Instance().unAssignK(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K", exc);
    }
  }

  /**
   * save Mnef on GovSteam2
   *
   * @param command AssignMnefToGovSteam2Command
   */
  @PutMapping("/assignMnef")
  public void assignMnef(@RequestBody AssignMnefToGovSteam2Command command) {
    try {
      GovSteam2BusinessDelegate.getGovSteam2Instance().assignMnef(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mnef", exc);
    }
  }

  /**
   * unassign Mnef on GovSteam2
   *
   * @param command UnAssignMnefFromGovSteam2Command
   */
  @PutMapping("/unAssignMnef")
  public void unAssignMnef(@RequestBody(required = true) UnAssignMnefFromGovSteam2Command command) {
    try {
      GovSteam2BusinessDelegate.getGovSteam2Instance().unAssignMnef(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mnef", exc);
    }
  }

  /**
   * save Mxef on GovSteam2
   *
   * @param command AssignMxefToGovSteam2Command
   */
  @PutMapping("/assignMxef")
  public void assignMxef(@RequestBody AssignMxefToGovSteam2Command command) {
    try {
      GovSteam2BusinessDelegate.getGovSteam2Instance().assignMxef(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mxef", exc);
    }
  }

  /**
   * unassign Mxef on GovSteam2
   *
   * @param command UnAssignMxefFromGovSteam2Command
   */
  @PutMapping("/unAssignMxef")
  public void unAssignMxef(@RequestBody(required = true) UnAssignMxefFromGovSteam2Command command) {
    try {
      GovSteam2BusinessDelegate.getGovSteam2Instance().unAssignMxef(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mxef", exc);
    }
  }

  /**
   * save Pmax on GovSteam2
   *
   * @param command AssignPmaxToGovSteam2Command
   */
  @PutMapping("/assignPmax")
  public void assignPmax(@RequestBody AssignPmaxToGovSteam2Command command) {
    try {
      GovSteam2BusinessDelegate.getGovSteam2Instance().assignPmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmax", exc);
    }
  }

  /**
   * unassign Pmax on GovSteam2
   *
   * @param command UnAssignPmaxFromGovSteam2Command
   */
  @PutMapping("/unAssignPmax")
  public void unAssignPmax(@RequestBody(required = true) UnAssignPmaxFromGovSteam2Command command) {
    try {
      GovSteam2BusinessDelegate.getGovSteam2Instance().unAssignPmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmax", exc);
    }
  }

  /**
   * save Pmin on GovSteam2
   *
   * @param command AssignPminToGovSteam2Command
   */
  @PutMapping("/assignPmin")
  public void assignPmin(@RequestBody AssignPminToGovSteam2Command command) {
    try {
      GovSteam2BusinessDelegate.getGovSteam2Instance().assignPmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmin", exc);
    }
  }

  /**
   * unassign Pmin on GovSteam2
   *
   * @param command UnAssignPminFromGovSteam2Command
   */
  @PutMapping("/unAssignPmin")
  public void unAssignPmin(@RequestBody(required = true) UnAssignPminFromGovSteam2Command command) {
    try {
      GovSteam2BusinessDelegate.getGovSteam2Instance().unAssignPmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmin", exc);
    }
  }

  /**
   * save T1 on GovSteam2
   *
   * @param command AssignT1ToGovSteam2Command
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToGovSteam2Command command) {
    try {
      GovSteam2BusinessDelegate.getGovSteam2Instance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on GovSteam2
   *
   * @param command UnAssignT1FromGovSteam2Command
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromGovSteam2Command command) {
    try {
      GovSteam2BusinessDelegate.getGovSteam2Instance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on GovSteam2
   *
   * @param command AssignT2ToGovSteam2Command
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToGovSteam2Command command) {
    try {
      GovSteam2BusinessDelegate.getGovSteam2Instance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on GovSteam2
   *
   * @param command UnAssignT2FromGovSteam2Command
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromGovSteam2Command command) {
    try {
      GovSteam2BusinessDelegate.getGovSteam2Instance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovSteam2 govSteam2 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovSteam2CommandRestController.class.getName());
}
