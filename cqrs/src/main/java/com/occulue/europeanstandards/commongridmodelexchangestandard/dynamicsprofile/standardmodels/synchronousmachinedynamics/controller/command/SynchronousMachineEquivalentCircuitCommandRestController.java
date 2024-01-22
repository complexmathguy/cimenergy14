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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.controller.command;

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
 * SynchronousMachineEquivalentCircuit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SynchronousMachineEquivalentCircuit")
public class SynchronousMachineEquivalentCircuitCommandRestController
    extends BaseSpringRestController {

  /**
   * Handles create a SynchronousMachineEquivalentCircuit. if not key provided, calls create,
   * otherwise calls save
   *
   * @param SynchronousMachineEquivalentCircuit synchronousMachineEquivalentCircuit
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateSynchronousMachineEquivalentCircuitCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          SynchronousMachineEquivalentCircuitBusinessDelegate
              .getSynchronousMachineEquivalentCircuitInstance()
              .createSynchronousMachineEquivalentCircuit(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a SynchronousMachineEquivalentCircuit. if no key provided, calls create,
   * otherwise calls save
   *
   * @param SynchronousMachineEquivalentCircuit synchronousMachineEquivalentCircuit
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateSynchronousMachineEquivalentCircuitCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateSynchronousMachineEquivalentCircuitCommand
      // -----------------------------------------------
      completableFuture =
          SynchronousMachineEquivalentCircuitBusinessDelegate
              .getSynchronousMachineEquivalentCircuitInstance()
              .updateSynchronousMachineEquivalentCircuit(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "SynchronousMachineEquivalentCircuitController:update() - successfully update SynchronousMachineEquivalentCircuit - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a SynchronousMachineEquivalentCircuit entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID synchronousMachineEquivalentCircuitId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteSynchronousMachineEquivalentCircuitCommand command =
        new DeleteSynchronousMachineEquivalentCircuitCommand(synchronousMachineEquivalentCircuitId);

    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate delegate =
          SynchronousMachineEquivalentCircuitBusinessDelegate
              .getSynchronousMachineEquivalentCircuitInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted SynchronousMachineEquivalentCircuit with key "
              + command.getSynchronousMachineEquivalentCircuitId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save R1d on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignR1dToSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/assignR1d")
  public void assignR1d(
      @RequestBody AssignR1dToSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .assignR1d(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R1d", exc);
    }
  }

  /**
   * unassign R1d on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignR1dFromSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/unAssignR1d")
  public void unAssignR1d(
      @RequestBody(required = true)
          UnAssignR1dFromSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .unAssignR1d(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R1d", exc);
    }
  }

  /**
   * save R1q on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignR1qToSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/assignR1q")
  public void assignR1q(
      @RequestBody AssignR1qToSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .assignR1q(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R1q", exc);
    }
  }

  /**
   * unassign R1q on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignR1qFromSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/unAssignR1q")
  public void unAssignR1q(
      @RequestBody(required = true)
          UnAssignR1qFromSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .unAssignR1q(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R1q", exc);
    }
  }

  /**
   * save R2q on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignR2qToSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/assignR2q")
  public void assignR2q(
      @RequestBody AssignR2qToSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .assignR2q(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R2q", exc);
    }
  }

  /**
   * unassign R2q on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignR2qFromSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/unAssignR2q")
  public void unAssignR2q(
      @RequestBody(required = true)
          UnAssignR2qFromSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .unAssignR2q(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R2q", exc);
    }
  }

  /**
   * save Rfd on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignRfdToSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/assignRfd")
  public void assignRfd(
      @RequestBody AssignRfdToSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .assignRfd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rfd", exc);
    }
  }

  /**
   * unassign Rfd on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignRfdFromSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/unAssignRfd")
  public void unAssignRfd(
      @RequestBody(required = true)
          UnAssignRfdFromSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .unAssignRfd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rfd", exc);
    }
  }

  /**
   * save X1d on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignX1dToSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/assignX1d")
  public void assignX1d(
      @RequestBody AssignX1dToSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .assignX1d(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign X1d", exc);
    }
  }

  /**
   * unassign X1d on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignX1dFromSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/unAssignX1d")
  public void unAssignX1d(
      @RequestBody(required = true)
          UnAssignX1dFromSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .unAssignX1d(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign X1d", exc);
    }
  }

  /**
   * save X1q on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignX1qToSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/assignX1q")
  public void assignX1q(
      @RequestBody AssignX1qToSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .assignX1q(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign X1q", exc);
    }
  }

  /**
   * unassign X1q on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignX1qFromSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/unAssignX1q")
  public void unAssignX1q(
      @RequestBody(required = true)
          UnAssignX1qFromSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .unAssignX1q(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign X1q", exc);
    }
  }

  /**
   * save X2q on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignX2qToSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/assignX2q")
  public void assignX2q(
      @RequestBody AssignX2qToSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .assignX2q(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign X2q", exc);
    }
  }

  /**
   * unassign X2q on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignX2qFromSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/unAssignX2q")
  public void unAssignX2q(
      @RequestBody(required = true)
          UnAssignX2qFromSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .unAssignX2q(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign X2q", exc);
    }
  }

  /**
   * save Xad on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignXadToSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/assignXad")
  public void assignXad(
      @RequestBody AssignXadToSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .assignXad(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xad", exc);
    }
  }

  /**
   * unassign Xad on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignXadFromSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/unAssignXad")
  public void unAssignXad(
      @RequestBody(required = true)
          UnAssignXadFromSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .unAssignXad(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xad", exc);
    }
  }

  /**
   * save Xaq on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignXaqToSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/assignXaq")
  public void assignXaq(
      @RequestBody AssignXaqToSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .assignXaq(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xaq", exc);
    }
  }

  /**
   * unassign Xaq on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignXaqFromSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/unAssignXaq")
  public void unAssignXaq(
      @RequestBody(required = true)
          UnAssignXaqFromSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .unAssignXaq(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xaq", exc);
    }
  }

  /**
   * save Xf1d on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignXf1dToSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/assignXf1d")
  public void assignXf1d(
      @RequestBody AssignXf1dToSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .assignXf1d(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xf1d", exc);
    }
  }

  /**
   * unassign Xf1d on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignXf1dFromSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/unAssignXf1d")
  public void unAssignXf1d(
      @RequestBody(required = true)
          UnAssignXf1dFromSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .unAssignXf1d(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xf1d", exc);
    }
  }

  /**
   * save Xfd on SynchronousMachineEquivalentCircuit
   *
   * @param command AssignXfdToSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/assignXfd")
  public void assignXfd(
      @RequestBody AssignXfdToSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .assignXfd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xfd", exc);
    }
  }

  /**
   * unassign Xfd on SynchronousMachineEquivalentCircuit
   *
   * @param command UnAssignXfdFromSynchronousMachineEquivalentCircuitCommand
   */
  @PutMapping("/unAssignXfd")
  public void unAssignXfd(
      @RequestBody(required = true)
          UnAssignXfdFromSynchronousMachineEquivalentCircuitCommand command) {
    try {
      SynchronousMachineEquivalentCircuitBusinessDelegate
          .getSynchronousMachineEquivalentCircuitInstance()
          .unAssignXfd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xfd", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected SynchronousMachineEquivalentCircuit synchronousMachineEquivalentCircuit = null;
  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineEquivalentCircuitCommandRestController.class.getName());
}
