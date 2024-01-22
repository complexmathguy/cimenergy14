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
 * SynchronousMachineTimeConstantReactance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SynchronousMachineTimeConstantReactance")
public class SynchronousMachineTimeConstantReactanceCommandRestController
    extends BaseSpringRestController {

  /**
   * Handles create a SynchronousMachineTimeConstantReactance. if not key provided, calls create,
   * otherwise calls save
   *
   * @param SynchronousMachineTimeConstantReactance synchronousMachineTimeConstantReactance
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateSynchronousMachineTimeConstantReactanceCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          SynchronousMachineTimeConstantReactanceBusinessDelegate
              .getSynchronousMachineTimeConstantReactanceInstance()
              .createSynchronousMachineTimeConstantReactance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a SynchronousMachineTimeConstantReactance. if no key provided, calls create,
   * otherwise calls save
   *
   * @param SynchronousMachineTimeConstantReactance synchronousMachineTimeConstantReactance
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateSynchronousMachineTimeConstantReactanceCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateSynchronousMachineTimeConstantReactanceCommand
      // -----------------------------------------------
      completableFuture =
          SynchronousMachineTimeConstantReactanceBusinessDelegate
              .getSynchronousMachineTimeConstantReactanceInstance()
              .updateSynchronousMachineTimeConstantReactance(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "SynchronousMachineTimeConstantReactanceController:update() - successfully update SynchronousMachineTimeConstantReactance - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a SynchronousMachineTimeConstantReactance entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID synchronousMachineTimeConstantReactanceId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteSynchronousMachineTimeConstantReactanceCommand command =
        new DeleteSynchronousMachineTimeConstantReactanceCommand(
            synchronousMachineTimeConstantReactanceId);

    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate delegate =
          SynchronousMachineTimeConstantReactanceBusinessDelegate
              .getSynchronousMachineTimeConstantReactanceInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted SynchronousMachineTimeConstantReactance with key "
              + command.getSynchronousMachineTimeConstantReactanceId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Ks on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignKsToSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/assignKs")
  public void assignKs(
      @RequestBody AssignKsToSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .assignKs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks", exc);
    }
  }

  /**
   * unassign Ks on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignKsFromSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/unAssignKs")
  public void unAssignKs(
      @RequestBody(required = true)
          UnAssignKsFromSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .unAssignKs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks", exc);
    }
  }

  /**
   * save Tc on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignTcToSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/assignTc")
  public void assignTc(
      @RequestBody AssignTcToSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignTcFromSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(
      @RequestBody(required = true)
          UnAssignTcFromSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Tpdo on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignTpdoToSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/assignTpdo")
  public void assignTpdo(
      @RequestBody AssignTpdoToSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .assignTpdo(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpdo", exc);
    }
  }

  /**
   * unassign Tpdo on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignTpdoFromSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/unAssignTpdo")
  public void unAssignTpdo(
      @RequestBody(required = true)
          UnAssignTpdoFromSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .unAssignTpdo(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpdo", exc);
    }
  }

  /**
   * save Tppdo on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignTppdoToSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/assignTppdo")
  public void assignTppdo(
      @RequestBody AssignTppdoToSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .assignTppdo(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tppdo", exc);
    }
  }

  /**
   * unassign Tppdo on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignTppdoFromSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/unAssignTppdo")
  public void unAssignTppdo(
      @RequestBody(required = true)
          UnAssignTppdoFromSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .unAssignTppdo(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tppdo", exc);
    }
  }

  /**
   * save Tppqo on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignTppqoToSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/assignTppqo")
  public void assignTppqo(
      @RequestBody AssignTppqoToSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .assignTppqo(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tppqo", exc);
    }
  }

  /**
   * unassign Tppqo on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignTppqoFromSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/unAssignTppqo")
  public void unAssignTppqo(
      @RequestBody(required = true)
          UnAssignTppqoFromSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .unAssignTppqo(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tppqo", exc);
    }
  }

  /**
   * save Tpqo on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignTpqoToSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/assignTpqo")
  public void assignTpqo(
      @RequestBody AssignTpqoToSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .assignTpqo(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpqo", exc);
    }
  }

  /**
   * unassign Tpqo on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignTpqoFromSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/unAssignTpqo")
  public void unAssignTpqo(
      @RequestBody(required = true)
          UnAssignTpqoFromSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .unAssignTpqo(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpqo", exc);
    }
  }

  /**
   * save XDirectSubtrans on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignXDirectSubtransToSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/assignXDirectSubtrans")
  public void assignXDirectSubtrans(
      @RequestBody AssignXDirectSubtransToSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .assignXDirectSubtrans(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign XDirectSubtrans", exc);
    }
  }

  /**
   * unassign XDirectSubtrans on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXDirectSubtransFromSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/unAssignXDirectSubtrans")
  public void unAssignXDirectSubtrans(
      @RequestBody(required = true)
          UnAssignXDirectSubtransFromSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .unAssignXDirectSubtrans(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign XDirectSubtrans", exc);
    }
  }

  /**
   * save XDirectSync on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignXDirectSyncToSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/assignXDirectSync")
  public void assignXDirectSync(
      @RequestBody AssignXDirectSyncToSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .assignXDirectSync(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign XDirectSync", exc);
    }
  }

  /**
   * unassign XDirectSync on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXDirectSyncFromSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/unAssignXDirectSync")
  public void unAssignXDirectSync(
      @RequestBody(required = true)
          UnAssignXDirectSyncFromSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .unAssignXDirectSync(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign XDirectSync", exc);
    }
  }

  /**
   * save XDirectTrans on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignXDirectTransToSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/assignXDirectTrans")
  public void assignXDirectTrans(
      @RequestBody AssignXDirectTransToSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .assignXDirectTrans(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign XDirectTrans", exc);
    }
  }

  /**
   * unassign XDirectTrans on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXDirectTransFromSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/unAssignXDirectTrans")
  public void unAssignXDirectTrans(
      @RequestBody(required = true)
          UnAssignXDirectTransFromSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .unAssignXDirectTrans(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign XDirectTrans", exc);
    }
  }

  /**
   * save XQuadSubtrans on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignXQuadSubtransToSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/assignXQuadSubtrans")
  public void assignXQuadSubtrans(
      @RequestBody AssignXQuadSubtransToSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .assignXQuadSubtrans(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign XQuadSubtrans", exc);
    }
  }

  /**
   * unassign XQuadSubtrans on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXQuadSubtransFromSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/unAssignXQuadSubtrans")
  public void unAssignXQuadSubtrans(
      @RequestBody(required = true)
          UnAssignXQuadSubtransFromSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .unAssignXQuadSubtrans(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign XQuadSubtrans", exc);
    }
  }

  /**
   * save XQuadSync on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignXQuadSyncToSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/assignXQuadSync")
  public void assignXQuadSync(
      @RequestBody AssignXQuadSyncToSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .assignXQuadSync(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign XQuadSync", exc);
    }
  }

  /**
   * unassign XQuadSync on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXQuadSyncFromSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/unAssignXQuadSync")
  public void unAssignXQuadSync(
      @RequestBody(required = true)
          UnAssignXQuadSyncFromSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .unAssignXQuadSync(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign XQuadSync", exc);
    }
  }

  /**
   * save XQuadTrans on SynchronousMachineTimeConstantReactance
   *
   * @param command AssignXQuadTransToSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/assignXQuadTrans")
  public void assignXQuadTrans(
      @RequestBody AssignXQuadTransToSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .assignXQuadTrans(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign XQuadTrans", exc);
    }
  }

  /**
   * unassign XQuadTrans on SynchronousMachineTimeConstantReactance
   *
   * @param command UnAssignXQuadTransFromSynchronousMachineTimeConstantReactanceCommand
   */
  @PutMapping("/unAssignXQuadTrans")
  public void unAssignXQuadTrans(
      @RequestBody(required = true)
          UnAssignXQuadTransFromSynchronousMachineTimeConstantReactanceCommand command) {
    try {
      SynchronousMachineTimeConstantReactanceBusinessDelegate
          .getSynchronousMachineTimeConstantReactanceInstance()
          .unAssignXQuadTrans(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign XQuadTrans", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected SynchronousMachineTimeConstantReactance synchronousMachineTimeConstantReactance = null;
  private static final Logger LOGGER =
      Logger.getLogger(
          SynchronousMachineTimeConstantReactanceCommandRestController.class.getName());
}
