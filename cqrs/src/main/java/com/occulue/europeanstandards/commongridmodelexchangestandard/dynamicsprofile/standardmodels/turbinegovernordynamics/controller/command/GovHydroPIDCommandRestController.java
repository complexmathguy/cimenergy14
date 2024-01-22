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
 * Implements Spring Controller command CQRS processing for entity GovHydroPID.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroPID")
public class GovHydroPIDCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovHydroPID. if not key provided, calls create, otherwise calls save
   *
   * @param GovHydroPID govHydroPID
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovHydroPIDCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().createGovHydroPID(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovHydroPID. if no key provided, calls create, otherwise calls save
   *
   * @param GovHydroPID govHydroPID
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovHydroPIDCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovHydroPIDCommand
      // -----------------------------------------------
      completableFuture =
          GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().updateGovHydroPID(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovHydroPIDController:update() - successfully update GovHydroPID - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovHydroPID entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govHydroPIDId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovHydroPIDCommand command = new DeleteGovHydroPIDCommand(govHydroPIDId);

    try {
      GovHydroPIDBusinessDelegate delegate = GovHydroPIDBusinessDelegate.getGovHydroPIDInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovHydroPID with key " + command.getGovHydroPIDId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Aturb on GovHydroPID
   *
   * @param command AssignAturbToGovHydroPIDCommand
   */
  @PutMapping("/assignAturb")
  public void assignAturb(@RequestBody AssignAturbToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignAturb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Aturb", exc);
    }
  }

  /**
   * unassign Aturb on GovHydroPID
   *
   * @param command UnAssignAturbFromGovHydroPIDCommand
   */
  @PutMapping("/unAssignAturb")
  public void unAssignAturb(
      @RequestBody(required = true) UnAssignAturbFromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignAturb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Aturb", exc);
    }
  }

  /**
   * save Bturb on GovHydroPID
   *
   * @param command AssignBturbToGovHydroPIDCommand
   */
  @PutMapping("/assignBturb")
  public void assignBturb(@RequestBody AssignBturbToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignBturb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bturb", exc);
    }
  }

  /**
   * unassign Bturb on GovHydroPID
   *
   * @param command UnAssignBturbFromGovHydroPIDCommand
   */
  @PutMapping("/unAssignBturb")
  public void unAssignBturb(
      @RequestBody(required = true) UnAssignBturbFromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignBturb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bturb", exc);
    }
  }

  /**
   * save Db1 on GovHydroPID
   *
   * @param command AssignDb1ToGovHydroPIDCommand
   */
  @PutMapping("/assignDb1")
  public void assignDb1(@RequestBody AssignDb1ToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignDb1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db1", exc);
    }
  }

  /**
   * unassign Db1 on GovHydroPID
   *
   * @param command UnAssignDb1FromGovHydroPIDCommand
   */
  @PutMapping("/unAssignDb1")
  public void unAssignDb1(@RequestBody(required = true) UnAssignDb1FromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignDb1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db1", exc);
    }
  }

  /**
   * save Db2 on GovHydroPID
   *
   * @param command AssignDb2ToGovHydroPIDCommand
   */
  @PutMapping("/assignDb2")
  public void assignDb2(@RequestBody AssignDb2ToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignDb2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db2", exc);
    }
  }

  /**
   * unassign Db2 on GovHydroPID
   *
   * @param command UnAssignDb2FromGovHydroPIDCommand
   */
  @PutMapping("/unAssignDb2")
  public void unAssignDb2(@RequestBody(required = true) UnAssignDb2FromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignDb2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db2", exc);
    }
  }

  /**
   * save Eps on GovHydroPID
   *
   * @param command AssignEpsToGovHydroPIDCommand
   */
  @PutMapping("/assignEps")
  public void assignEps(@RequestBody AssignEpsToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignEps(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Eps", exc);
    }
  }

  /**
   * unassign Eps on GovHydroPID
   *
   * @param command UnAssignEpsFromGovHydroPIDCommand
   */
  @PutMapping("/unAssignEps")
  public void unAssignEps(@RequestBody(required = true) UnAssignEpsFromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignEps(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Eps", exc);
    }
  }

  /**
   * save Gv1 on GovHydroPID
   *
   * @param command AssignGv1ToGovHydroPIDCommand
   */
  @PutMapping("/assignGv1")
  public void assignGv1(@RequestBody AssignGv1ToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignGv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv1", exc);
    }
  }

  /**
   * unassign Gv1 on GovHydroPID
   *
   * @param command UnAssignGv1FromGovHydroPIDCommand
   */
  @PutMapping("/unAssignGv1")
  public void unAssignGv1(@RequestBody(required = true) UnAssignGv1FromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignGv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv1", exc);
    }
  }

  /**
   * save Gv2 on GovHydroPID
   *
   * @param command AssignGv2ToGovHydroPIDCommand
   */
  @PutMapping("/assignGv2")
  public void assignGv2(@RequestBody AssignGv2ToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignGv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv2", exc);
    }
  }

  /**
   * unassign Gv2 on GovHydroPID
   *
   * @param command UnAssignGv2FromGovHydroPIDCommand
   */
  @PutMapping("/unAssignGv2")
  public void unAssignGv2(@RequestBody(required = true) UnAssignGv2FromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignGv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv2", exc);
    }
  }

  /**
   * save Gv3 on GovHydroPID
   *
   * @param command AssignGv3ToGovHydroPIDCommand
   */
  @PutMapping("/assignGv3")
  public void assignGv3(@RequestBody AssignGv3ToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignGv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv3", exc);
    }
  }

  /**
   * unassign Gv3 on GovHydroPID
   *
   * @param command UnAssignGv3FromGovHydroPIDCommand
   */
  @PutMapping("/unAssignGv3")
  public void unAssignGv3(@RequestBody(required = true) UnAssignGv3FromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignGv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv3", exc);
    }
  }

  /**
   * save Gv4 on GovHydroPID
   *
   * @param command AssignGv4ToGovHydroPIDCommand
   */
  @PutMapping("/assignGv4")
  public void assignGv4(@RequestBody AssignGv4ToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignGv4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv4", exc);
    }
  }

  /**
   * unassign Gv4 on GovHydroPID
   *
   * @param command UnAssignGv4FromGovHydroPIDCommand
   */
  @PutMapping("/unAssignGv4")
  public void unAssignGv4(@RequestBody(required = true) UnAssignGv4FromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignGv4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv4", exc);
    }
  }

  /**
   * save Gv5 on GovHydroPID
   *
   * @param command AssignGv5ToGovHydroPIDCommand
   */
  @PutMapping("/assignGv5")
  public void assignGv5(@RequestBody AssignGv5ToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignGv5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv5", exc);
    }
  }

  /**
   * unassign Gv5 on GovHydroPID
   *
   * @param command UnAssignGv5FromGovHydroPIDCommand
   */
  @PutMapping("/unAssignGv5")
  public void unAssignGv5(@RequestBody(required = true) UnAssignGv5FromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignGv5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv5", exc);
    }
  }

  /**
   * save Gv6 on GovHydroPID
   *
   * @param command AssignGv6ToGovHydroPIDCommand
   */
  @PutMapping("/assignGv6")
  public void assignGv6(@RequestBody AssignGv6ToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignGv6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv6", exc);
    }
  }

  /**
   * unassign Gv6 on GovHydroPID
   *
   * @param command UnAssignGv6FromGovHydroPIDCommand
   */
  @PutMapping("/unAssignGv6")
  public void unAssignGv6(@RequestBody(required = true) UnAssignGv6FromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignGv6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv6", exc);
    }
  }

  /**
   * save InputSignal on GovHydroPID
   *
   * @param command AssignInputSignalToGovHydroPIDCommand
   */
  @PutMapping("/assignInputSignal")
  public void assignInputSignal(@RequestBody AssignInputSignalToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignInputSignal(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign InputSignal", exc);
    }
  }

  /**
   * unassign InputSignal on GovHydroPID
   *
   * @param command UnAssignInputSignalFromGovHydroPIDCommand
   */
  @PutMapping("/unAssignInputSignal")
  public void unAssignInputSignal(
      @RequestBody(required = true) UnAssignInputSignalFromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignInputSignal(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign InputSignal", exc);
    }
  }

  /**
   * save Kd on GovHydroPID
   *
   * @param command AssignKdToGovHydroPIDCommand
   */
  @PutMapping("/assignKd")
  public void assignKd(@RequestBody AssignKdToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignKd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd", exc);
    }
  }

  /**
   * unassign Kd on GovHydroPID
   *
   * @param command UnAssignKdFromGovHydroPIDCommand
   */
  @PutMapping("/unAssignKd")
  public void unAssignKd(@RequestBody(required = true) UnAssignKdFromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignKd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd", exc);
    }
  }

  /**
   * save Kg on GovHydroPID
   *
   * @param command AssignKgToGovHydroPIDCommand
   */
  @PutMapping("/assignKg")
  public void assignKg(@RequestBody AssignKgToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignKg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kg", exc);
    }
  }

  /**
   * unassign Kg on GovHydroPID
   *
   * @param command UnAssignKgFromGovHydroPIDCommand
   */
  @PutMapping("/unAssignKg")
  public void unAssignKg(@RequestBody(required = true) UnAssignKgFromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignKg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kg", exc);
    }
  }

  /**
   * save Ki on GovHydroPID
   *
   * @param command AssignKiToGovHydroPIDCommand
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on GovHydroPID
   *
   * @param command UnAssignKiFromGovHydroPIDCommand
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(@RequestBody(required = true) UnAssignKiFromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Kp on GovHydroPID
   *
   * @param command AssignKpToGovHydroPIDCommand
   */
  @PutMapping("/assignKp")
  public void assignKp(@RequestBody AssignKpToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignKp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp", exc);
    }
  }

  /**
   * unassign Kp on GovHydroPID
   *
   * @param command UnAssignKpFromGovHydroPIDCommand
   */
  @PutMapping("/unAssignKp")
  public void unAssignKp(@RequestBody(required = true) UnAssignKpFromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignKp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp", exc);
    }
  }

  /**
   * save Mwbase on GovHydroPID
   *
   * @param command AssignMwbaseToGovHydroPIDCommand
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovHydroPID
   *
   * @param command UnAssignMwbaseFromGovHydroPIDCommand
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save Pgv1 on GovHydroPID
   *
   * @param command AssignPgv1ToGovHydroPIDCommand
   */
  @PutMapping("/assignPgv1")
  public void assignPgv1(@RequestBody AssignPgv1ToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignPgv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv1", exc);
    }
  }

  /**
   * unassign Pgv1 on GovHydroPID
   *
   * @param command UnAssignPgv1FromGovHydroPIDCommand
   */
  @PutMapping("/unAssignPgv1")
  public void unAssignPgv1(
      @RequestBody(required = true) UnAssignPgv1FromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignPgv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv1", exc);
    }
  }

  /**
   * save Pgv2 on GovHydroPID
   *
   * @param command AssignPgv2ToGovHydroPIDCommand
   */
  @PutMapping("/assignPgv2")
  public void assignPgv2(@RequestBody AssignPgv2ToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignPgv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv2", exc);
    }
  }

  /**
   * unassign Pgv2 on GovHydroPID
   *
   * @param command UnAssignPgv2FromGovHydroPIDCommand
   */
  @PutMapping("/unAssignPgv2")
  public void unAssignPgv2(
      @RequestBody(required = true) UnAssignPgv2FromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignPgv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv2", exc);
    }
  }

  /**
   * save Pgv3 on GovHydroPID
   *
   * @param command AssignPgv3ToGovHydroPIDCommand
   */
  @PutMapping("/assignPgv3")
  public void assignPgv3(@RequestBody AssignPgv3ToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignPgv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv3", exc);
    }
  }

  /**
   * unassign Pgv3 on GovHydroPID
   *
   * @param command UnAssignPgv3FromGovHydroPIDCommand
   */
  @PutMapping("/unAssignPgv3")
  public void unAssignPgv3(
      @RequestBody(required = true) UnAssignPgv3FromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignPgv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv3", exc);
    }
  }

  /**
   * save Pgv4 on GovHydroPID
   *
   * @param command AssignPgv4ToGovHydroPIDCommand
   */
  @PutMapping("/assignPgv4")
  public void assignPgv4(@RequestBody AssignPgv4ToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignPgv4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv4", exc);
    }
  }

  /**
   * unassign Pgv4 on GovHydroPID
   *
   * @param command UnAssignPgv4FromGovHydroPIDCommand
   */
  @PutMapping("/unAssignPgv4")
  public void unAssignPgv4(
      @RequestBody(required = true) UnAssignPgv4FromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignPgv4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv4", exc);
    }
  }

  /**
   * save Pgv5 on GovHydroPID
   *
   * @param command AssignPgv5ToGovHydroPIDCommand
   */
  @PutMapping("/assignPgv5")
  public void assignPgv5(@RequestBody AssignPgv5ToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignPgv5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv5", exc);
    }
  }

  /**
   * unassign Pgv5 on GovHydroPID
   *
   * @param command UnAssignPgv5FromGovHydroPIDCommand
   */
  @PutMapping("/unAssignPgv5")
  public void unAssignPgv5(
      @RequestBody(required = true) UnAssignPgv5FromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignPgv5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv5", exc);
    }
  }

  /**
   * save Pgv6 on GovHydroPID
   *
   * @param command AssignPgv6ToGovHydroPIDCommand
   */
  @PutMapping("/assignPgv6")
  public void assignPgv6(@RequestBody AssignPgv6ToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignPgv6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv6", exc);
    }
  }

  /**
   * unassign Pgv6 on GovHydroPID
   *
   * @param command UnAssignPgv6FromGovHydroPIDCommand
   */
  @PutMapping("/unAssignPgv6")
  public void unAssignPgv6(
      @RequestBody(required = true) UnAssignPgv6FromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignPgv6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv6", exc);
    }
  }

  /**
   * save Pmax on GovHydroPID
   *
   * @param command AssignPmaxToGovHydroPIDCommand
   */
  @PutMapping("/assignPmax")
  public void assignPmax(@RequestBody AssignPmaxToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignPmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmax", exc);
    }
  }

  /**
   * unassign Pmax on GovHydroPID
   *
   * @param command UnAssignPmaxFromGovHydroPIDCommand
   */
  @PutMapping("/unAssignPmax")
  public void unAssignPmax(
      @RequestBody(required = true) UnAssignPmaxFromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignPmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmax", exc);
    }
  }

  /**
   * save Pmin on GovHydroPID
   *
   * @param command AssignPminToGovHydroPIDCommand
   */
  @PutMapping("/assignPmin")
  public void assignPmin(@RequestBody AssignPminToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignPmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmin", exc);
    }
  }

  /**
   * unassign Pmin on GovHydroPID
   *
   * @param command UnAssignPminFromGovHydroPIDCommand
   */
  @PutMapping("/unAssignPmin")
  public void unAssignPmin(
      @RequestBody(required = true) UnAssignPminFromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignPmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmin", exc);
    }
  }

  /**
   * save R on GovHydroPID
   *
   * @param command AssignRToGovHydroPIDCommand
   */
  @PutMapping("/assignR")
  public void assignR(@RequestBody AssignRToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignR(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R", exc);
    }
  }

  /**
   * unassign R on GovHydroPID
   *
   * @param command UnAssignRFromGovHydroPIDCommand
   */
  @PutMapping("/unAssignR")
  public void unAssignR(@RequestBody(required = true) UnAssignRFromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignR(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R", exc);
    }
  }

  /**
   * save Td on GovHydroPID
   *
   * @param command AssignTdToGovHydroPIDCommand
   */
  @PutMapping("/assignTd")
  public void assignTd(@RequestBody AssignTdToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignTd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Td", exc);
    }
  }

  /**
   * unassign Td on GovHydroPID
   *
   * @param command UnAssignTdFromGovHydroPIDCommand
   */
  @PutMapping("/unAssignTd")
  public void unAssignTd(@RequestBody(required = true) UnAssignTdFromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignTd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Td", exc);
    }
  }

  /**
   * save Tf on GovHydroPID
   *
   * @param command AssignTfToGovHydroPIDCommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on GovHydroPID
   *
   * @param command UnAssignTfFromGovHydroPIDCommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Tp on GovHydroPID
   *
   * @param command AssignTpToGovHydroPIDCommand
   */
  @PutMapping("/assignTp")
  public void assignTp(@RequestBody AssignTpToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignTp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tp", exc);
    }
  }

  /**
   * unassign Tp on GovHydroPID
   *
   * @param command UnAssignTpFromGovHydroPIDCommand
   */
  @PutMapping("/unAssignTp")
  public void unAssignTp(@RequestBody(required = true) UnAssignTpFromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignTp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tp", exc);
    }
  }

  /**
   * save Tt on GovHydroPID
   *
   * @param command AssignTtToGovHydroPIDCommand
   */
  @PutMapping("/assignTt")
  public void assignTt(@RequestBody AssignTtToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignTt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tt", exc);
    }
  }

  /**
   * unassign Tt on GovHydroPID
   *
   * @param command UnAssignTtFromGovHydroPIDCommand
   */
  @PutMapping("/unAssignTt")
  public void unAssignTt(@RequestBody(required = true) UnAssignTtFromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignTt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tt", exc);
    }
  }

  /**
   * save Tturb on GovHydroPID
   *
   * @param command AssignTturbToGovHydroPIDCommand
   */
  @PutMapping("/assignTturb")
  public void assignTturb(@RequestBody AssignTturbToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignTturb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tturb", exc);
    }
  }

  /**
   * unassign Tturb on GovHydroPID
   *
   * @param command UnAssignTturbFromGovHydroPIDCommand
   */
  @PutMapping("/unAssignTturb")
  public void unAssignTturb(
      @RequestBody(required = true) UnAssignTturbFromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignTturb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tturb", exc);
    }
  }

  /**
   * save Velcl on GovHydroPID
   *
   * @param command AssignVelclToGovHydroPIDCommand
   */
  @PutMapping("/assignVelcl")
  public void assignVelcl(@RequestBody AssignVelclToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignVelcl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Velcl", exc);
    }
  }

  /**
   * unassign Velcl on GovHydroPID
   *
   * @param command UnAssignVelclFromGovHydroPIDCommand
   */
  @PutMapping("/unAssignVelcl")
  public void unAssignVelcl(
      @RequestBody(required = true) UnAssignVelclFromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignVelcl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Velcl", exc);
    }
  }

  /**
   * save Velop on GovHydroPID
   *
   * @param command AssignVelopToGovHydroPIDCommand
   */
  @PutMapping("/assignVelop")
  public void assignVelop(@RequestBody AssignVelopToGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().assignVelop(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Velop", exc);
    }
  }

  /**
   * unassign Velop on GovHydroPID
   *
   * @param command UnAssignVelopFromGovHydroPIDCommand
   */
  @PutMapping("/unAssignVelop")
  public void unAssignVelop(
      @RequestBody(required = true) UnAssignVelopFromGovHydroPIDCommand command) {
    try {
      GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().unAssignVelop(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Velop", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovHydroPID govHydroPID = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovHydroPIDCommandRestController.class.getName());
}
