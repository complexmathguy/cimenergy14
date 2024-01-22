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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.asynchronousmachinedynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity
 * AsynchronousMachineEquivalentCircuit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AsynchronousMachineEquivalentCircuit")
public class AsynchronousMachineEquivalentCircuitCommandRestController
    extends BaseSpringRestController {

  /**
   * Handles create a AsynchronousMachineEquivalentCircuit. if not key provided, calls create,
   * otherwise calls save
   *
   * @param AsynchronousMachineEquivalentCircuit asynchronousMachineEquivalentCircuit
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateAsynchronousMachineEquivalentCircuitCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          AsynchronousMachineEquivalentCircuitBusinessDelegate
              .getAsynchronousMachineEquivalentCircuitInstance()
              .createAsynchronousMachineEquivalentCircuit(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a AsynchronousMachineEquivalentCircuit. if no key provided, calls create,
   * otherwise calls save
   *
   * @param AsynchronousMachineEquivalentCircuit asynchronousMachineEquivalentCircuit
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateAsynchronousMachineEquivalentCircuitCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateAsynchronousMachineEquivalentCircuitCommand
      // -----------------------------------------------
      completableFuture =
          AsynchronousMachineEquivalentCircuitBusinessDelegate
              .getAsynchronousMachineEquivalentCircuitInstance()
              .updateAsynchronousMachineEquivalentCircuit(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "AsynchronousMachineEquivalentCircuitController:update() - successfully update AsynchronousMachineEquivalentCircuit - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a AsynchronousMachineEquivalentCircuit entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID asynchronousMachineEquivalentCircuitId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteAsynchronousMachineEquivalentCircuitCommand command =
        new DeleteAsynchronousMachineEquivalentCircuitCommand(
            asynchronousMachineEquivalentCircuitId);

    try {
      AsynchronousMachineEquivalentCircuitBusinessDelegate delegate =
          AsynchronousMachineEquivalentCircuitBusinessDelegate
              .getAsynchronousMachineEquivalentCircuitInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted AsynchronousMachineEquivalentCircuit with key "
              + command.getAsynchronousMachineEquivalentCircuitId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Rr1 on AsynchronousMachineEquivalentCircuit
   *
   * @param command AssignRr1ToAsynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/assignRr1")
  public void assignRr1(
      @RequestBody AssignRr1ToAsynchronousMachineEquivalentCircuitCommand command) {
    try {
      AsynchronousMachineEquivalentCircuitBusinessDelegate
          .getAsynchronousMachineEquivalentCircuitInstance()
          .assignRr1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rr1", exc);
    }
  }

  /**
   * unassign Rr1 on AsynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignRr1FromAsynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/unAssignRr1")
  public void unAssignRr1(
      @RequestBody(required = true)
          UnAssignRr1FromAsynchronousMachineEquivalentCircuitCommand command) {
    try {
      AsynchronousMachineEquivalentCircuitBusinessDelegate
          .getAsynchronousMachineEquivalentCircuitInstance()
          .unAssignRr1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rr1", exc);
    }
  }

  /**
   * save Rr2 on AsynchronousMachineEquivalentCircuit
   *
   * @param command AssignRr2ToAsynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/assignRr2")
  public void assignRr2(
      @RequestBody AssignRr2ToAsynchronousMachineEquivalentCircuitCommand command) {
    try {
      AsynchronousMachineEquivalentCircuitBusinessDelegate
          .getAsynchronousMachineEquivalentCircuitInstance()
          .assignRr2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rr2", exc);
    }
  }

  /**
   * unassign Rr2 on AsynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignRr2FromAsynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/unAssignRr2")
  public void unAssignRr2(
      @RequestBody(required = true)
          UnAssignRr2FromAsynchronousMachineEquivalentCircuitCommand command) {
    try {
      AsynchronousMachineEquivalentCircuitBusinessDelegate
          .getAsynchronousMachineEquivalentCircuitInstance()
          .unAssignRr2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rr2", exc);
    }
  }

  /**
   * save Xlr1 on AsynchronousMachineEquivalentCircuit
   *
   * @param command AssignXlr1ToAsynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/assignXlr1")
  public void assignXlr1(
      @RequestBody AssignXlr1ToAsynchronousMachineEquivalentCircuitCommand command) {
    try {
      AsynchronousMachineEquivalentCircuitBusinessDelegate
          .getAsynchronousMachineEquivalentCircuitInstance()
          .assignXlr1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xlr1", exc);
    }
  }

  /**
   * unassign Xlr1 on AsynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignXlr1FromAsynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/unAssignXlr1")
  public void unAssignXlr1(
      @RequestBody(required = true)
          UnAssignXlr1FromAsynchronousMachineEquivalentCircuitCommand command) {
    try {
      AsynchronousMachineEquivalentCircuitBusinessDelegate
          .getAsynchronousMachineEquivalentCircuitInstance()
          .unAssignXlr1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xlr1", exc);
    }
  }

  /**
   * save Xlr2 on AsynchronousMachineEquivalentCircuit
   *
   * @param command AssignXlr2ToAsynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/assignXlr2")
  public void assignXlr2(
      @RequestBody AssignXlr2ToAsynchronousMachineEquivalentCircuitCommand command) {
    try {
      AsynchronousMachineEquivalentCircuitBusinessDelegate
          .getAsynchronousMachineEquivalentCircuitInstance()
          .assignXlr2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xlr2", exc);
    }
  }

  /**
   * unassign Xlr2 on AsynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignXlr2FromAsynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/unAssignXlr2")
  public void unAssignXlr2(
      @RequestBody(required = true)
          UnAssignXlr2FromAsynchronousMachineEquivalentCircuitCommand command) {
    try {
      AsynchronousMachineEquivalentCircuitBusinessDelegate
          .getAsynchronousMachineEquivalentCircuitInstance()
          .unAssignXlr2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xlr2", exc);
    }
  }

  /**
   * save Xm on AsynchronousMachineEquivalentCircuit
   *
   * @param command AssignXmToAsynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/assignXm")
  public void assignXm(@RequestBody AssignXmToAsynchronousMachineEquivalentCircuitCommand command) {
    try {
      AsynchronousMachineEquivalentCircuitBusinessDelegate
          .getAsynchronousMachineEquivalentCircuitInstance()
          .assignXm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xm", exc);
    }
  }

  /**
   * unassign Xm on AsynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignXmFromAsynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/unAssignXm")
  public void unAssignXm(
      @RequestBody(required = true)
          UnAssignXmFromAsynchronousMachineEquivalentCircuitCommand command) {
    try {
      AsynchronousMachineEquivalentCircuitBusinessDelegate
          .getAsynchronousMachineEquivalentCircuitInstance()
          .unAssignXm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xm", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected AsynchronousMachineEquivalentCircuit asynchronousMachineEquivalentCircuit = null;
  private static final Logger LOGGER =
      Logger.getLogger(AsynchronousMachineEquivalentCircuitCommandRestController.class.getName());
}
