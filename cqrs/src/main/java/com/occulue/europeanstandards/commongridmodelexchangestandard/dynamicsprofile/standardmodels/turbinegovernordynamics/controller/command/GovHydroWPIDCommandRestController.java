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
 * Implements Spring Controller command CQRS processing for entity GovHydroWPID.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroWPID")
public class GovHydroWPIDCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovHydroWPID. if not key provided, calls create, otherwise calls save
   *
   * @param GovHydroWPID govHydroWPID
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovHydroWPIDCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().createGovHydroWPID(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovHydroWPID. if no key provided, calls create, otherwise calls save
   *
   * @param GovHydroWPID govHydroWPID
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovHydroWPIDCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovHydroWPIDCommand
      // -----------------------------------------------
      completableFuture =
          GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().updateGovHydroWPID(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovHydroWPIDController:update() - successfully update GovHydroWPID - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovHydroWPID entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govHydroWPIDId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovHydroWPIDCommand command = new DeleteGovHydroWPIDCommand(govHydroWPIDId);

    try {
      GovHydroWPIDBusinessDelegate delegate =
          GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted GovHydroWPID with key " + command.getGovHydroWPIDId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save D on GovHydroWPID
   *
   * @param command AssignDToGovHydroWPIDCommand
   */
  @PutMapping("/assignD")
  public void assignD(@RequestBody AssignDToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignD(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign D", exc);
    }
  }

  /**
   * unassign D on GovHydroWPID
   *
   * @param command UnAssignDFromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignD")
  public void unAssignD(@RequestBody(required = true) UnAssignDFromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignD(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign D", exc);
    }
  }

  /**
   * save Gatmax on GovHydroWPID
   *
   * @param command AssignGatmaxToGovHydroWPIDCommand
   */
  @PutMapping("/assignGatmax")
  public void assignGatmax(@RequestBody AssignGatmaxToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignGatmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gatmax", exc);
    }
  }

  /**
   * unassign Gatmax on GovHydroWPID
   *
   * @param command UnAssignGatmaxFromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignGatmax")
  public void unAssignGatmax(
      @RequestBody(required = true) UnAssignGatmaxFromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignGatmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gatmax", exc);
    }
  }

  /**
   * save Gatmin on GovHydroWPID
   *
   * @param command AssignGatminToGovHydroWPIDCommand
   */
  @PutMapping("/assignGatmin")
  public void assignGatmin(@RequestBody AssignGatminToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignGatmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gatmin", exc);
    }
  }

  /**
   * unassign Gatmin on GovHydroWPID
   *
   * @param command UnAssignGatminFromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignGatmin")
  public void unAssignGatmin(
      @RequestBody(required = true) UnAssignGatminFromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignGatmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gatmin", exc);
    }
  }

  /**
   * save Gv1 on GovHydroWPID
   *
   * @param command AssignGv1ToGovHydroWPIDCommand
   */
  @PutMapping("/assignGv1")
  public void assignGv1(@RequestBody AssignGv1ToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignGv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv1", exc);
    }
  }

  /**
   * unassign Gv1 on GovHydroWPID
   *
   * @param command UnAssignGv1FromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignGv1")
  public void unAssignGv1(
      @RequestBody(required = true) UnAssignGv1FromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignGv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv1", exc);
    }
  }

  /**
   * save Gv2 on GovHydroWPID
   *
   * @param command AssignGv2ToGovHydroWPIDCommand
   */
  @PutMapping("/assignGv2")
  public void assignGv2(@RequestBody AssignGv2ToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignGv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv2", exc);
    }
  }

  /**
   * unassign Gv2 on GovHydroWPID
   *
   * @param command UnAssignGv2FromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignGv2")
  public void unAssignGv2(
      @RequestBody(required = true) UnAssignGv2FromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignGv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv2", exc);
    }
  }

  /**
   * save Gv3 on GovHydroWPID
   *
   * @param command AssignGv3ToGovHydroWPIDCommand
   */
  @PutMapping("/assignGv3")
  public void assignGv3(@RequestBody AssignGv3ToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignGv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv3", exc);
    }
  }

  /**
   * unassign Gv3 on GovHydroWPID
   *
   * @param command UnAssignGv3FromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignGv3")
  public void unAssignGv3(
      @RequestBody(required = true) UnAssignGv3FromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignGv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv3", exc);
    }
  }

  /**
   * save Kd on GovHydroWPID
   *
   * @param command AssignKdToGovHydroWPIDCommand
   */
  @PutMapping("/assignKd")
  public void assignKd(@RequestBody AssignKdToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignKd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd", exc);
    }
  }

  /**
   * unassign Kd on GovHydroWPID
   *
   * @param command UnAssignKdFromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignKd")
  public void unAssignKd(@RequestBody(required = true) UnAssignKdFromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignKd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd", exc);
    }
  }

  /**
   * save Ki on GovHydroWPID
   *
   * @param command AssignKiToGovHydroWPIDCommand
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on GovHydroWPID
   *
   * @param command UnAssignKiFromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(@RequestBody(required = true) UnAssignKiFromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Kp on GovHydroWPID
   *
   * @param command AssignKpToGovHydroWPIDCommand
   */
  @PutMapping("/assignKp")
  public void assignKp(@RequestBody AssignKpToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignKp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp", exc);
    }
  }

  /**
   * unassign Kp on GovHydroWPID
   *
   * @param command UnAssignKpFromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignKp")
  public void unAssignKp(@RequestBody(required = true) UnAssignKpFromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignKp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp", exc);
    }
  }

  /**
   * save Mwbase on GovHydroWPID
   *
   * @param command AssignMwbaseToGovHydroWPIDCommand
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovHydroWPID
   *
   * @param command UnAssignMwbaseFromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save Pgv1 on GovHydroWPID
   *
   * @param command AssignPgv1ToGovHydroWPIDCommand
   */
  @PutMapping("/assignPgv1")
  public void assignPgv1(@RequestBody AssignPgv1ToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignPgv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv1", exc);
    }
  }

  /**
   * unassign Pgv1 on GovHydroWPID
   *
   * @param command UnAssignPgv1FromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignPgv1")
  public void unAssignPgv1(
      @RequestBody(required = true) UnAssignPgv1FromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignPgv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv1", exc);
    }
  }

  /**
   * save Pgv2 on GovHydroWPID
   *
   * @param command AssignPgv2ToGovHydroWPIDCommand
   */
  @PutMapping("/assignPgv2")
  public void assignPgv2(@RequestBody AssignPgv2ToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignPgv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv2", exc);
    }
  }

  /**
   * unassign Pgv2 on GovHydroWPID
   *
   * @param command UnAssignPgv2FromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignPgv2")
  public void unAssignPgv2(
      @RequestBody(required = true) UnAssignPgv2FromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignPgv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv2", exc);
    }
  }

  /**
   * save Pgv3 on GovHydroWPID
   *
   * @param command AssignPgv3ToGovHydroWPIDCommand
   */
  @PutMapping("/assignPgv3")
  public void assignPgv3(@RequestBody AssignPgv3ToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignPgv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv3", exc);
    }
  }

  /**
   * unassign Pgv3 on GovHydroWPID
   *
   * @param command UnAssignPgv3FromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignPgv3")
  public void unAssignPgv3(
      @RequestBody(required = true) UnAssignPgv3FromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignPgv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv3", exc);
    }
  }

  /**
   * save Pmax on GovHydroWPID
   *
   * @param command AssignPmaxToGovHydroWPIDCommand
   */
  @PutMapping("/assignPmax")
  public void assignPmax(@RequestBody AssignPmaxToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignPmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmax", exc);
    }
  }

  /**
   * unassign Pmax on GovHydroWPID
   *
   * @param command UnAssignPmaxFromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignPmax")
  public void unAssignPmax(
      @RequestBody(required = true) UnAssignPmaxFromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignPmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmax", exc);
    }
  }

  /**
   * save Pmin on GovHydroWPID
   *
   * @param command AssignPminToGovHydroWPIDCommand
   */
  @PutMapping("/assignPmin")
  public void assignPmin(@RequestBody AssignPminToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignPmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmin", exc);
    }
  }

  /**
   * unassign Pmin on GovHydroWPID
   *
   * @param command UnAssignPminFromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignPmin")
  public void unAssignPmin(
      @RequestBody(required = true) UnAssignPminFromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignPmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmin", exc);
    }
  }

  /**
   * save Reg on GovHydroWPID
   *
   * @param command AssignRegToGovHydroWPIDCommand
   */
  @PutMapping("/assignReg")
  public void assignReg(@RequestBody AssignRegToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignReg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Reg", exc);
    }
  }

  /**
   * unassign Reg on GovHydroWPID
   *
   * @param command UnAssignRegFromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignReg")
  public void unAssignReg(
      @RequestBody(required = true) UnAssignRegFromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignReg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Reg", exc);
    }
  }

  /**
   * save Ta on GovHydroWPID
   *
   * @param command AssignTaToGovHydroWPIDCommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on GovHydroWPID
   *
   * @param command UnAssignTaFromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on GovHydroWPID
   *
   * @param command AssignTbToGovHydroWPIDCommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on GovHydroWPID
   *
   * @param command UnAssignTbFromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Treg on GovHydroWPID
   *
   * @param command AssignTregToGovHydroWPIDCommand
   */
  @PutMapping("/assignTreg")
  public void assignTreg(@RequestBody AssignTregToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignTreg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Treg", exc);
    }
  }

  /**
   * unassign Treg on GovHydroWPID
   *
   * @param command UnAssignTregFromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignTreg")
  public void unAssignTreg(
      @RequestBody(required = true) UnAssignTregFromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignTreg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Treg", exc);
    }
  }

  /**
   * save Tw on GovHydroWPID
   *
   * @param command AssignTwToGovHydroWPIDCommand
   */
  @PutMapping("/assignTw")
  public void assignTw(@RequestBody AssignTwToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignTw(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw", exc);
    }
  }

  /**
   * unassign Tw on GovHydroWPID
   *
   * @param command UnAssignTwFromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignTw")
  public void unAssignTw(@RequestBody(required = true) UnAssignTwFromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignTw(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw", exc);
    }
  }

  /**
   * save Velmax on GovHydroWPID
   *
   * @param command AssignVelmaxToGovHydroWPIDCommand
   */
  @PutMapping("/assignVelmax")
  public void assignVelmax(@RequestBody AssignVelmaxToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignVelmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Velmax", exc);
    }
  }

  /**
   * unassign Velmax on GovHydroWPID
   *
   * @param command UnAssignVelmaxFromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignVelmax")
  public void unAssignVelmax(
      @RequestBody(required = true) UnAssignVelmaxFromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignVelmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Velmax", exc);
    }
  }

  /**
   * save Velmin on GovHydroWPID
   *
   * @param command AssignVelminToGovHydroWPIDCommand
   */
  @PutMapping("/assignVelmin")
  public void assignVelmin(@RequestBody AssignVelminToGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().assignVelmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Velmin", exc);
    }
  }

  /**
   * unassign Velmin on GovHydroWPID
   *
   * @param command UnAssignVelminFromGovHydroWPIDCommand
   */
  @PutMapping("/unAssignVelmin")
  public void unAssignVelmin(
      @RequestBody(required = true) UnAssignVelminFromGovHydroWPIDCommand command) {
    try {
      GovHydroWPIDBusinessDelegate.getGovHydroWPIDInstance().unAssignVelmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Velmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovHydroWPID govHydroWPID = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovHydroWPIDCommandRestController.class.getName());
}
