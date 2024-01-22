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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity WindContPitchAngleIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindContPitchAngleIEC")
public class WindContPitchAngleIECCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a WindContPitchAngleIEC. if not key provided, calls create, otherwise calls save
   *
   * @param WindContPitchAngleIEC windContPitchAngleIEC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateWindContPitchAngleIECCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance()
              .createWindContPitchAngleIEC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a WindContPitchAngleIEC. if no key provided, calls create, otherwise calls
   * save
   *
   * @param WindContPitchAngleIEC windContPitchAngleIEC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateWindContPitchAngleIECCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateWindContPitchAngleIECCommand
      // -----------------------------------------------
      completableFuture =
          WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance()
              .updateWindContPitchAngleIEC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "WindContPitchAngleIECController:update() - successfully update WindContPitchAngleIEC - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a WindContPitchAngleIEC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID windContPitchAngleIECId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteWindContPitchAngleIECCommand command =
        new DeleteWindContPitchAngleIECCommand(windContPitchAngleIECId);

    try {
      WindContPitchAngleIECBusinessDelegate delegate =
          WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted WindContPitchAngleIEC with key "
              + command.getWindContPitchAngleIECId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Dthetamax on WindContPitchAngleIEC
   *
   * @param command AssignDthetamaxToWindContPitchAngleIECCommand
   */
  @PutMapping("/assignDthetamax")
  public void assignDthetamax(@RequestBody AssignDthetamaxToWindContPitchAngleIECCommand command) {
    try {
      WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance()
          .assignDthetamax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dthetamax", exc);
    }
  }

  /**
   * unassign Dthetamax on WindContPitchAngleIEC
   *
   * @param command UnAssignDthetamaxFromWindContPitchAngleIECCommand
   */
  @PutMapping("/unAssignDthetamax")
  public void unAssignDthetamax(
      @RequestBody(required = true) UnAssignDthetamaxFromWindContPitchAngleIECCommand command) {
    try {
      WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance()
          .unAssignDthetamax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dthetamax", exc);
    }
  }

  /**
   * save Dthetamin on WindContPitchAngleIEC
   *
   * @param command AssignDthetaminToWindContPitchAngleIECCommand
   */
  @PutMapping("/assignDthetamin")
  public void assignDthetamin(@RequestBody AssignDthetaminToWindContPitchAngleIECCommand command) {
    try {
      WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance()
          .assignDthetamin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dthetamin", exc);
    }
  }

  /**
   * unassign Dthetamin on WindContPitchAngleIEC
   *
   * @param command UnAssignDthetaminFromWindContPitchAngleIECCommand
   */
  @PutMapping("/unAssignDthetamin")
  public void unAssignDthetamin(
      @RequestBody(required = true) UnAssignDthetaminFromWindContPitchAngleIECCommand command) {
    try {
      WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance()
          .unAssignDthetamin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dthetamin", exc);
    }
  }

  /**
   * save Kic on WindContPitchAngleIEC
   *
   * @param command AssignKicToWindContPitchAngleIECCommand
   */
  @PutMapping("/assignKic")
  public void assignKic(@RequestBody AssignKicToWindContPitchAngleIECCommand command) {
    try {
      WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance().assignKic(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kic", exc);
    }
  }

  /**
   * unassign Kic on WindContPitchAngleIEC
   *
   * @param command UnAssignKicFromWindContPitchAngleIECCommand
   */
  @PutMapping("/unAssignKic")
  public void unAssignKic(
      @RequestBody(required = true) UnAssignKicFromWindContPitchAngleIECCommand command) {
    try {
      WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance().unAssignKic(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kic", exc);
    }
  }

  /**
   * save Kiomega on WindContPitchAngleIEC
   *
   * @param command AssignKiomegaToWindContPitchAngleIECCommand
   */
  @PutMapping("/assignKiomega")
  public void assignKiomega(@RequestBody AssignKiomegaToWindContPitchAngleIECCommand command) {
    try {
      WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance()
          .assignKiomega(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kiomega", exc);
    }
  }

  /**
   * unassign Kiomega on WindContPitchAngleIEC
   *
   * @param command UnAssignKiomegaFromWindContPitchAngleIECCommand
   */
  @PutMapping("/unAssignKiomega")
  public void unAssignKiomega(
      @RequestBody(required = true) UnAssignKiomegaFromWindContPitchAngleIECCommand command) {
    try {
      WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance()
          .unAssignKiomega(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kiomega", exc);
    }
  }

  /**
   * save Kpc on WindContPitchAngleIEC
   *
   * @param command AssignKpcToWindContPitchAngleIECCommand
   */
  @PutMapping("/assignKpc")
  public void assignKpc(@RequestBody AssignKpcToWindContPitchAngleIECCommand command) {
    try {
      WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance().assignKpc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpc", exc);
    }
  }

  /**
   * unassign Kpc on WindContPitchAngleIEC
   *
   * @param command UnAssignKpcFromWindContPitchAngleIECCommand
   */
  @PutMapping("/unAssignKpc")
  public void unAssignKpc(
      @RequestBody(required = true) UnAssignKpcFromWindContPitchAngleIECCommand command) {
    try {
      WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance().unAssignKpc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpc", exc);
    }
  }

  /**
   * save Kpomega on WindContPitchAngleIEC
   *
   * @param command AssignKpomegaToWindContPitchAngleIECCommand
   */
  @PutMapping("/assignKpomega")
  public void assignKpomega(@RequestBody AssignKpomegaToWindContPitchAngleIECCommand command) {
    try {
      WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance()
          .assignKpomega(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpomega", exc);
    }
  }

  /**
   * unassign Kpomega on WindContPitchAngleIEC
   *
   * @param command UnAssignKpomegaFromWindContPitchAngleIECCommand
   */
  @PutMapping("/unAssignKpomega")
  public void unAssignKpomega(
      @RequestBody(required = true) UnAssignKpomegaFromWindContPitchAngleIECCommand command) {
    try {
      WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance()
          .unAssignKpomega(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpomega", exc);
    }
  }

  /**
   * save Kpx on WindContPitchAngleIEC
   *
   * @param command AssignKpxToWindContPitchAngleIECCommand
   */
  @PutMapping("/assignKpx")
  public void assignKpx(@RequestBody AssignKpxToWindContPitchAngleIECCommand command) {
    try {
      WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance().assignKpx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpx", exc);
    }
  }

  /**
   * unassign Kpx on WindContPitchAngleIEC
   *
   * @param command UnAssignKpxFromWindContPitchAngleIECCommand
   */
  @PutMapping("/unAssignKpx")
  public void unAssignKpx(
      @RequestBody(required = true) UnAssignKpxFromWindContPitchAngleIECCommand command) {
    try {
      WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance().unAssignKpx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpx", exc);
    }
  }

  /**
   * save Thetamax on WindContPitchAngleIEC
   *
   * @param command AssignThetamaxToWindContPitchAngleIECCommand
   */
  @PutMapping("/assignThetamax")
  public void assignThetamax(@RequestBody AssignThetamaxToWindContPitchAngleIECCommand command) {
    try {
      WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance()
          .assignThetamax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Thetamax", exc);
    }
  }

  /**
   * unassign Thetamax on WindContPitchAngleIEC
   *
   * @param command UnAssignThetamaxFromWindContPitchAngleIECCommand
   */
  @PutMapping("/unAssignThetamax")
  public void unAssignThetamax(
      @RequestBody(required = true) UnAssignThetamaxFromWindContPitchAngleIECCommand command) {
    try {
      WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance()
          .unAssignThetamax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Thetamax", exc);
    }
  }

  /**
   * save Thetamin on WindContPitchAngleIEC
   *
   * @param command AssignThetaminToWindContPitchAngleIECCommand
   */
  @PutMapping("/assignThetamin")
  public void assignThetamin(@RequestBody AssignThetaminToWindContPitchAngleIECCommand command) {
    try {
      WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance()
          .assignThetamin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Thetamin", exc);
    }
  }

  /**
   * unassign Thetamin on WindContPitchAngleIEC
   *
   * @param command UnAssignThetaminFromWindContPitchAngleIECCommand
   */
  @PutMapping("/unAssignThetamin")
  public void unAssignThetamin(
      @RequestBody(required = true) UnAssignThetaminFromWindContPitchAngleIECCommand command) {
    try {
      WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance()
          .unAssignThetamin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Thetamin", exc);
    }
  }

  /**
   * save Ttheta on WindContPitchAngleIEC
   *
   * @param command AssignTthetaToWindContPitchAngleIECCommand
   */
  @PutMapping("/assignTtheta")
  public void assignTtheta(@RequestBody AssignTthetaToWindContPitchAngleIECCommand command) {
    try {
      WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance()
          .assignTtheta(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ttheta", exc);
    }
  }

  /**
   * unassign Ttheta on WindContPitchAngleIEC
   *
   * @param command UnAssignTthetaFromWindContPitchAngleIECCommand
   */
  @PutMapping("/unAssignTtheta")
  public void unAssignTtheta(
      @RequestBody(required = true) UnAssignTthetaFromWindContPitchAngleIECCommand command) {
    try {
      WindContPitchAngleIECBusinessDelegate.getWindContPitchAngleIECInstance()
          .unAssignTtheta(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ttheta", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindContPitchAngleIEC windContPitchAngleIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindContPitchAngleIECCommandRestController.class.getName());
}
