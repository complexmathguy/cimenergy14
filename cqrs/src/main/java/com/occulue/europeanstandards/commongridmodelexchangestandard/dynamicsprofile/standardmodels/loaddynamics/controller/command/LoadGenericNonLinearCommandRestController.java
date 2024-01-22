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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity LoadGenericNonLinear.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadGenericNonLinear")
public class LoadGenericNonLinearCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a LoadGenericNonLinear. if not key provided, calls create, otherwise calls save
   *
   * @param LoadGenericNonLinear loadGenericNonLinear
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateLoadGenericNonLinearCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance()
              .createLoadGenericNonLinear(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a LoadGenericNonLinear. if no key provided, calls create, otherwise calls save
   *
   * @param LoadGenericNonLinear loadGenericNonLinear
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateLoadGenericNonLinearCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateLoadGenericNonLinearCommand
      // -----------------------------------------------
      completableFuture =
          LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance()
              .updateLoadGenericNonLinear(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "LoadGenericNonLinearController:update() - successfully update LoadGenericNonLinear - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a LoadGenericNonLinear entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID loadGenericNonLinearId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteLoadGenericNonLinearCommand command =
        new DeleteLoadGenericNonLinearCommand(loadGenericNonLinearId);

    try {
      LoadGenericNonLinearBusinessDelegate delegate =
          LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted LoadGenericNonLinear with key "
              + command.getLoadGenericNonLinearId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Bs on LoadGenericNonLinear
   *
   * @param command AssignBsToLoadGenericNonLinearCommand
   */
  @PutMapping("/assignBs")
  public void assignBs(@RequestBody AssignBsToLoadGenericNonLinearCommand command) {
    try {
      LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().assignBs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bs", exc);
    }
  }

  /**
   * unassign Bs on LoadGenericNonLinear
   *
   * @param command UnAssignBsFromLoadGenericNonLinearCommand
   */
  @PutMapping("/unAssignBs")
  public void unAssignBs(
      @RequestBody(required = true) UnAssignBsFromLoadGenericNonLinearCommand command) {
    try {
      LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().unAssignBs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bs", exc);
    }
  }

  /**
   * save Bt on LoadGenericNonLinear
   *
   * @param command AssignBtToLoadGenericNonLinearCommand
   */
  @PutMapping("/assignBt")
  public void assignBt(@RequestBody AssignBtToLoadGenericNonLinearCommand command) {
    try {
      LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().assignBt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bt", exc);
    }
  }

  /**
   * unassign Bt on LoadGenericNonLinear
   *
   * @param command UnAssignBtFromLoadGenericNonLinearCommand
   */
  @PutMapping("/unAssignBt")
  public void unAssignBt(
      @RequestBody(required = true) UnAssignBtFromLoadGenericNonLinearCommand command) {
    try {
      LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().unAssignBt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bt", exc);
    }
  }

  /**
   * save Ls on LoadGenericNonLinear
   *
   * @param command AssignLsToLoadGenericNonLinearCommand
   */
  @PutMapping("/assignLs")
  public void assignLs(@RequestBody AssignLsToLoadGenericNonLinearCommand command) {
    try {
      LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().assignLs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ls", exc);
    }
  }

  /**
   * unassign Ls on LoadGenericNonLinear
   *
   * @param command UnAssignLsFromLoadGenericNonLinearCommand
   */
  @PutMapping("/unAssignLs")
  public void unAssignLs(
      @RequestBody(required = true) UnAssignLsFromLoadGenericNonLinearCommand command) {
    try {
      LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().unAssignLs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ls", exc);
    }
  }

  /**
   * save Lt on LoadGenericNonLinear
   *
   * @param command AssignLtToLoadGenericNonLinearCommand
   */
  @PutMapping("/assignLt")
  public void assignLt(@RequestBody AssignLtToLoadGenericNonLinearCommand command) {
    try {
      LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().assignLt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Lt", exc);
    }
  }

  /**
   * unassign Lt on LoadGenericNonLinear
   *
   * @param command UnAssignLtFromLoadGenericNonLinearCommand
   */
  @PutMapping("/unAssignLt")
  public void unAssignLt(
      @RequestBody(required = true) UnAssignLtFromLoadGenericNonLinearCommand command) {
    try {
      LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().unAssignLt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Lt", exc);
    }
  }

  /**
   * save Pt on LoadGenericNonLinear
   *
   * @param command AssignPtToLoadGenericNonLinearCommand
   */
  @PutMapping("/assignPt")
  public void assignPt(@RequestBody AssignPtToLoadGenericNonLinearCommand command) {
    try {
      LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().assignPt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pt", exc);
    }
  }

  /**
   * unassign Pt on LoadGenericNonLinear
   *
   * @param command UnAssignPtFromLoadGenericNonLinearCommand
   */
  @PutMapping("/unAssignPt")
  public void unAssignPt(
      @RequestBody(required = true) UnAssignPtFromLoadGenericNonLinearCommand command) {
    try {
      LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().unAssignPt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pt", exc);
    }
  }

  /**
   * save Qt on LoadGenericNonLinear
   *
   * @param command AssignQtToLoadGenericNonLinearCommand
   */
  @PutMapping("/assignQt")
  public void assignQt(@RequestBody AssignQtToLoadGenericNonLinearCommand command) {
    try {
      LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().assignQt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Qt", exc);
    }
  }

  /**
   * unassign Qt on LoadGenericNonLinear
   *
   * @param command UnAssignQtFromLoadGenericNonLinearCommand
   */
  @PutMapping("/unAssignQt")
  public void unAssignQt(
      @RequestBody(required = true) UnAssignQtFromLoadGenericNonLinearCommand command) {
    try {
      LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().unAssignQt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Qt", exc);
    }
  }

  /**
   * save Tp on LoadGenericNonLinear
   *
   * @param command AssignTpToLoadGenericNonLinearCommand
   */
  @PutMapping("/assignTp")
  public void assignTp(@RequestBody AssignTpToLoadGenericNonLinearCommand command) {
    try {
      LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().assignTp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tp", exc);
    }
  }

  /**
   * unassign Tp on LoadGenericNonLinear
   *
   * @param command UnAssignTpFromLoadGenericNonLinearCommand
   */
  @PutMapping("/unAssignTp")
  public void unAssignTp(
      @RequestBody(required = true) UnAssignTpFromLoadGenericNonLinearCommand command) {
    try {
      LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().unAssignTp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tp", exc);
    }
  }

  /**
   * save Tq on LoadGenericNonLinear
   *
   * @param command AssignTqToLoadGenericNonLinearCommand
   */
  @PutMapping("/assignTq")
  public void assignTq(@RequestBody AssignTqToLoadGenericNonLinearCommand command) {
    try {
      LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().assignTq(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tq", exc);
    }
  }

  /**
   * unassign Tq on LoadGenericNonLinear
   *
   * @param command UnAssignTqFromLoadGenericNonLinearCommand
   */
  @PutMapping("/unAssignTq")
  public void unAssignTq(
      @RequestBody(required = true) UnAssignTqFromLoadGenericNonLinearCommand command) {
    try {
      LoadGenericNonLinearBusinessDelegate.getLoadGenericNonLinearInstance().unAssignTq(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tq", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected LoadGenericNonLinear loadGenericNonLinear = null;
  private static final Logger LOGGER =
      Logger.getLogger(LoadGenericNonLinearCommandRestController.class.getName());
}
