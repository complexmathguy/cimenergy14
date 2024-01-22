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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity RotatingMachineDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RotatingMachineDynamics")
public class RotatingMachineDynamicsCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a RotatingMachineDynamics. if not key provided, calls create, otherwise calls
   * save
   *
   * @param RotatingMachineDynamics rotatingMachineDynamics
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateRotatingMachineDynamicsCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance()
              .createRotatingMachineDynamics(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a RotatingMachineDynamics. if no key provided, calls create, otherwise calls
   * save
   *
   * @param RotatingMachineDynamics rotatingMachineDynamics
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateRotatingMachineDynamicsCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateRotatingMachineDynamicsCommand
      // -----------------------------------------------
      completableFuture =
          RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance()
              .updateRotatingMachineDynamics(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "RotatingMachineDynamicsController:update() - successfully update RotatingMachineDynamics - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a RotatingMachineDynamics entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID rotatingMachineDynamicsId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteRotatingMachineDynamicsCommand command =
        new DeleteRotatingMachineDynamicsCommand(rotatingMachineDynamicsId);

    try {
      RotatingMachineDynamicsBusinessDelegate delegate =
          RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted RotatingMachineDynamics with key "
              + command.getRotatingMachineDynamicsId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Damping on RotatingMachineDynamics
   *
   * @param command AssignDampingToRotatingMachineDynamicsCommand
   */
  @PutMapping("/assignDamping")
  public void assignDamping(@RequestBody AssignDampingToRotatingMachineDynamicsCommand command) {
    try {
      RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance()
          .assignDamping(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Damping", exc);
    }
  }

  /**
   * unassign Damping on RotatingMachineDynamics
   *
   * @param command UnAssignDampingFromRotatingMachineDynamicsCommand
   */
  @PutMapping("/unAssignDamping")
  public void unAssignDamping(
      @RequestBody(required = true) UnAssignDampingFromRotatingMachineDynamicsCommand command) {
    try {
      RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance()
          .unAssignDamping(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Damping", exc);
    }
  }

  /**
   * save Inertia on RotatingMachineDynamics
   *
   * @param command AssignInertiaToRotatingMachineDynamicsCommand
   */
  @PutMapping("/assignInertia")
  public void assignInertia(@RequestBody AssignInertiaToRotatingMachineDynamicsCommand command) {
    try {
      RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance()
          .assignInertia(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Inertia", exc);
    }
  }

  /**
   * unassign Inertia on RotatingMachineDynamics
   *
   * @param command UnAssignInertiaFromRotatingMachineDynamicsCommand
   */
  @PutMapping("/unAssignInertia")
  public void unAssignInertia(
      @RequestBody(required = true) UnAssignInertiaFromRotatingMachineDynamicsCommand command) {
    try {
      RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance()
          .unAssignInertia(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Inertia", exc);
    }
  }

  /**
   * save SaturationFactor on RotatingMachineDynamics
   *
   * @param command AssignSaturationFactorToRotatingMachineDynamicsCommand
   */
  @PutMapping("/assignSaturationFactor")
  public void assignSaturationFactor(
      @RequestBody AssignSaturationFactorToRotatingMachineDynamicsCommand command) {
    try {
      RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance()
          .assignSaturationFactor(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SaturationFactor", exc);
    }
  }

  /**
   * unassign SaturationFactor on RotatingMachineDynamics
   *
   * @param command UnAssignSaturationFactorFromRotatingMachineDynamicsCommand
   */
  @PutMapping("/unAssignSaturationFactor")
  public void unAssignSaturationFactor(
      @RequestBody(required = true)
          UnAssignSaturationFactorFromRotatingMachineDynamicsCommand command) {
    try {
      RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance()
          .unAssignSaturationFactor(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SaturationFactor", exc);
    }
  }

  /**
   * save SaturationFactor120 on RotatingMachineDynamics
   *
   * @param command AssignSaturationFactor120ToRotatingMachineDynamicsCommand
   */
  @PutMapping("/assignSaturationFactor120")
  public void assignSaturationFactor120(
      @RequestBody AssignSaturationFactor120ToRotatingMachineDynamicsCommand command) {
    try {
      RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance()
          .assignSaturationFactor120(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SaturationFactor120", exc);
    }
  }

  /**
   * unassign SaturationFactor120 on RotatingMachineDynamics
   *
   * @param command UnAssignSaturationFactor120FromRotatingMachineDynamicsCommand
   */
  @PutMapping("/unAssignSaturationFactor120")
  public void unAssignSaturationFactor120(
      @RequestBody(required = true)
          UnAssignSaturationFactor120FromRotatingMachineDynamicsCommand command) {
    try {
      RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance()
          .unAssignSaturationFactor120(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SaturationFactor120", exc);
    }
  }

  /**
   * save StatorLeakageReactance on RotatingMachineDynamics
   *
   * @param command AssignStatorLeakageReactanceToRotatingMachineDynamicsCommand
   */
  @PutMapping("/assignStatorLeakageReactance")
  public void assignStatorLeakageReactance(
      @RequestBody AssignStatorLeakageReactanceToRotatingMachineDynamicsCommand command) {
    try {
      RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance()
          .assignStatorLeakageReactance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign StatorLeakageReactance", exc);
    }
  }

  /**
   * unassign StatorLeakageReactance on RotatingMachineDynamics
   *
   * @param command UnAssignStatorLeakageReactanceFromRotatingMachineDynamicsCommand
   */
  @PutMapping("/unAssignStatorLeakageReactance")
  public void unAssignStatorLeakageReactance(
      @RequestBody(required = true)
          UnAssignStatorLeakageReactanceFromRotatingMachineDynamicsCommand command) {
    try {
      RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance()
          .unAssignStatorLeakageReactance(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign StatorLeakageReactance", exc);
    }
  }

  /**
   * save StatorResistance on RotatingMachineDynamics
   *
   * @param command AssignStatorResistanceToRotatingMachineDynamicsCommand
   */
  @PutMapping("/assignStatorResistance")
  public void assignStatorResistance(
      @RequestBody AssignStatorResistanceToRotatingMachineDynamicsCommand command) {
    try {
      RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance()
          .assignStatorResistance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign StatorResistance", exc);
    }
  }

  /**
   * unassign StatorResistance on RotatingMachineDynamics
   *
   * @param command UnAssignStatorResistanceFromRotatingMachineDynamicsCommand
   */
  @PutMapping("/unAssignStatorResistance")
  public void unAssignStatorResistance(
      @RequestBody(required = true)
          UnAssignStatorResistanceFromRotatingMachineDynamicsCommand command) {
    try {
      RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance()
          .unAssignStatorResistance(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign StatorResistance", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected RotatingMachineDynamics rotatingMachineDynamics = null;
  private static final Logger LOGGER =
      Logger.getLogger(RotatingMachineDynamicsCommandRestController.class.getName());
}
