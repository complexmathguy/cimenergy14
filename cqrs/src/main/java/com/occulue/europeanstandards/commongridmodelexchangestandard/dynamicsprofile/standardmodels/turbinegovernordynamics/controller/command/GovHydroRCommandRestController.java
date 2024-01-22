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
 * Implements Spring Controller command CQRS processing for entity GovHydroR.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroR")
public class GovHydroRCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovHydroR. if not key provided, calls create, otherwise calls save
   *
   * @param GovHydroR govHydroR
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovHydroRCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = GovHydroRBusinessDelegate.getGovHydroRInstance().createGovHydroR(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovHydroR. if no key provided, calls create, otherwise calls save
   *
   * @param GovHydroR govHydroR
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovHydroRCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovHydroRCommand
      // -----------------------------------------------
      completableFuture = GovHydroRBusinessDelegate.getGovHydroRInstance().updateGovHydroR(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovHydroRController:update() - successfully update GovHydroR - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovHydroR entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govHydroRId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovHydroRCommand command = new DeleteGovHydroRCommand(govHydroRId);

    try {
      GovHydroRBusinessDelegate delegate = GovHydroRBusinessDelegate.getGovHydroRInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovHydroR with key " + command.getGovHydroRId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save At on GovHydroR
   *
   * @param command AssignAtToGovHydroRCommand
   */
  @PutMapping("/assignAt")
  public void assignAt(@RequestBody AssignAtToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignAt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign At", exc);
    }
  }

  /**
   * unassign At on GovHydroR
   *
   * @param command UnAssignAtFromGovHydroRCommand
   */
  @PutMapping("/unAssignAt")
  public void unAssignAt(@RequestBody(required = true) UnAssignAtFromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignAt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign At", exc);
    }
  }

  /**
   * save Db1 on GovHydroR
   *
   * @param command AssignDb1ToGovHydroRCommand
   */
  @PutMapping("/assignDb1")
  public void assignDb1(@RequestBody AssignDb1ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignDb1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db1", exc);
    }
  }

  /**
   * unassign Db1 on GovHydroR
   *
   * @param command UnAssignDb1FromGovHydroRCommand
   */
  @PutMapping("/unAssignDb1")
  public void unAssignDb1(@RequestBody(required = true) UnAssignDb1FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignDb1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db1", exc);
    }
  }

  /**
   * save Db2 on GovHydroR
   *
   * @param command AssignDb2ToGovHydroRCommand
   */
  @PutMapping("/assignDb2")
  public void assignDb2(@RequestBody AssignDb2ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignDb2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db2", exc);
    }
  }

  /**
   * unassign Db2 on GovHydroR
   *
   * @param command UnAssignDb2FromGovHydroRCommand
   */
  @PutMapping("/unAssignDb2")
  public void unAssignDb2(@RequestBody(required = true) UnAssignDb2FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignDb2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db2", exc);
    }
  }

  /**
   * save Dturb on GovHydroR
   *
   * @param command AssignDturbToGovHydroRCommand
   */
  @PutMapping("/assignDturb")
  public void assignDturb(@RequestBody AssignDturbToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignDturb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dturb", exc);
    }
  }

  /**
   * unassign Dturb on GovHydroR
   *
   * @param command UnAssignDturbFromGovHydroRCommand
   */
  @PutMapping("/unAssignDturb")
  public void unAssignDturb(
      @RequestBody(required = true) UnAssignDturbFromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignDturb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dturb", exc);
    }
  }

  /**
   * save Eps on GovHydroR
   *
   * @param command AssignEpsToGovHydroRCommand
   */
  @PutMapping("/assignEps")
  public void assignEps(@RequestBody AssignEpsToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignEps(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Eps", exc);
    }
  }

  /**
   * unassign Eps on GovHydroR
   *
   * @param command UnAssignEpsFromGovHydroRCommand
   */
  @PutMapping("/unAssignEps")
  public void unAssignEps(@RequestBody(required = true) UnAssignEpsFromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignEps(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Eps", exc);
    }
  }

  /**
   * save Gmax on GovHydroR
   *
   * @param command AssignGmaxToGovHydroRCommand
   */
  @PutMapping("/assignGmax")
  public void assignGmax(@RequestBody AssignGmaxToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignGmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gmax", exc);
    }
  }

  /**
   * unassign Gmax on GovHydroR
   *
   * @param command UnAssignGmaxFromGovHydroRCommand
   */
  @PutMapping("/unAssignGmax")
  public void unAssignGmax(@RequestBody(required = true) UnAssignGmaxFromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignGmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gmax", exc);
    }
  }

  /**
   * save Gmin on GovHydroR
   *
   * @param command AssignGminToGovHydroRCommand
   */
  @PutMapping("/assignGmin")
  public void assignGmin(@RequestBody AssignGminToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignGmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gmin", exc);
    }
  }

  /**
   * unassign Gmin on GovHydroR
   *
   * @param command UnAssignGminFromGovHydroRCommand
   */
  @PutMapping("/unAssignGmin")
  public void unAssignGmin(@RequestBody(required = true) UnAssignGminFromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignGmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gmin", exc);
    }
  }

  /**
   * save Gv1 on GovHydroR
   *
   * @param command AssignGv1ToGovHydroRCommand
   */
  @PutMapping("/assignGv1")
  public void assignGv1(@RequestBody AssignGv1ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignGv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv1", exc);
    }
  }

  /**
   * unassign Gv1 on GovHydroR
   *
   * @param command UnAssignGv1FromGovHydroRCommand
   */
  @PutMapping("/unAssignGv1")
  public void unAssignGv1(@RequestBody(required = true) UnAssignGv1FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignGv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv1", exc);
    }
  }

  /**
   * save Gv2 on GovHydroR
   *
   * @param command AssignGv2ToGovHydroRCommand
   */
  @PutMapping("/assignGv2")
  public void assignGv2(@RequestBody AssignGv2ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignGv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv2", exc);
    }
  }

  /**
   * unassign Gv2 on GovHydroR
   *
   * @param command UnAssignGv2FromGovHydroRCommand
   */
  @PutMapping("/unAssignGv2")
  public void unAssignGv2(@RequestBody(required = true) UnAssignGv2FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignGv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv2", exc);
    }
  }

  /**
   * save Gv3 on GovHydroR
   *
   * @param command AssignGv3ToGovHydroRCommand
   */
  @PutMapping("/assignGv3")
  public void assignGv3(@RequestBody AssignGv3ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignGv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv3", exc);
    }
  }

  /**
   * unassign Gv3 on GovHydroR
   *
   * @param command UnAssignGv3FromGovHydroRCommand
   */
  @PutMapping("/unAssignGv3")
  public void unAssignGv3(@RequestBody(required = true) UnAssignGv3FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignGv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv3", exc);
    }
  }

  /**
   * save Gv4 on GovHydroR
   *
   * @param command AssignGv4ToGovHydroRCommand
   */
  @PutMapping("/assignGv4")
  public void assignGv4(@RequestBody AssignGv4ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignGv4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv4", exc);
    }
  }

  /**
   * unassign Gv4 on GovHydroR
   *
   * @param command UnAssignGv4FromGovHydroRCommand
   */
  @PutMapping("/unAssignGv4")
  public void unAssignGv4(@RequestBody(required = true) UnAssignGv4FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignGv4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv4", exc);
    }
  }

  /**
   * save Gv5 on GovHydroR
   *
   * @param command AssignGv5ToGovHydroRCommand
   */
  @PutMapping("/assignGv5")
  public void assignGv5(@RequestBody AssignGv5ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignGv5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv5", exc);
    }
  }

  /**
   * unassign Gv5 on GovHydroR
   *
   * @param command UnAssignGv5FromGovHydroRCommand
   */
  @PutMapping("/unAssignGv5")
  public void unAssignGv5(@RequestBody(required = true) UnAssignGv5FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignGv5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv5", exc);
    }
  }

  /**
   * save Gv6 on GovHydroR
   *
   * @param command AssignGv6ToGovHydroRCommand
   */
  @PutMapping("/assignGv6")
  public void assignGv6(@RequestBody AssignGv6ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignGv6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv6", exc);
    }
  }

  /**
   * unassign Gv6 on GovHydroR
   *
   * @param command UnAssignGv6FromGovHydroRCommand
   */
  @PutMapping("/unAssignGv6")
  public void unAssignGv6(@RequestBody(required = true) UnAssignGv6FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignGv6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv6", exc);
    }
  }

  /**
   * save H0 on GovHydroR
   *
   * @param command AssignH0ToGovHydroRCommand
   */
  @PutMapping("/assignH0")
  public void assignH0(@RequestBody AssignH0ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignH0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign H0", exc);
    }
  }

  /**
   * unassign H0 on GovHydroR
   *
   * @param command UnAssignH0FromGovHydroRCommand
   */
  @PutMapping("/unAssignH0")
  public void unAssignH0(@RequestBody(required = true) UnAssignH0FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignH0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign H0", exc);
    }
  }

  /**
   * save InputSignal on GovHydroR
   *
   * @param command AssignInputSignalToGovHydroRCommand
   */
  @PutMapping("/assignInputSignal")
  public void assignInputSignal(@RequestBody AssignInputSignalToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignInputSignal(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign InputSignal", exc);
    }
  }

  /**
   * unassign InputSignal on GovHydroR
   *
   * @param command UnAssignInputSignalFromGovHydroRCommand
   */
  @PutMapping("/unAssignInputSignal")
  public void unAssignInputSignal(
      @RequestBody(required = true) UnAssignInputSignalFromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignInputSignal(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign InputSignal", exc);
    }
  }

  /**
   * save Kg on GovHydroR
   *
   * @param command AssignKgToGovHydroRCommand
   */
  @PutMapping("/assignKg")
  public void assignKg(@RequestBody AssignKgToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignKg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kg", exc);
    }
  }

  /**
   * unassign Kg on GovHydroR
   *
   * @param command UnAssignKgFromGovHydroRCommand
   */
  @PutMapping("/unAssignKg")
  public void unAssignKg(@RequestBody(required = true) UnAssignKgFromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignKg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kg", exc);
    }
  }

  /**
   * save Ki on GovHydroR
   *
   * @param command AssignKiToGovHydroRCommand
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on GovHydroR
   *
   * @param command UnAssignKiFromGovHydroRCommand
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(@RequestBody(required = true) UnAssignKiFromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Mwbase on GovHydroR
   *
   * @param command AssignMwbaseToGovHydroRCommand
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovHydroR
   *
   * @param command UnAssignMwbaseFromGovHydroRCommand
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save Pgv1 on GovHydroR
   *
   * @param command AssignPgv1ToGovHydroRCommand
   */
  @PutMapping("/assignPgv1")
  public void assignPgv1(@RequestBody AssignPgv1ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignPgv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv1", exc);
    }
  }

  /**
   * unassign Pgv1 on GovHydroR
   *
   * @param command UnAssignPgv1FromGovHydroRCommand
   */
  @PutMapping("/unAssignPgv1")
  public void unAssignPgv1(@RequestBody(required = true) UnAssignPgv1FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignPgv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv1", exc);
    }
  }

  /**
   * save Pgv2 on GovHydroR
   *
   * @param command AssignPgv2ToGovHydroRCommand
   */
  @PutMapping("/assignPgv2")
  public void assignPgv2(@RequestBody AssignPgv2ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignPgv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv2", exc);
    }
  }

  /**
   * unassign Pgv2 on GovHydroR
   *
   * @param command UnAssignPgv2FromGovHydroRCommand
   */
  @PutMapping("/unAssignPgv2")
  public void unAssignPgv2(@RequestBody(required = true) UnAssignPgv2FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignPgv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv2", exc);
    }
  }

  /**
   * save Pgv3 on GovHydroR
   *
   * @param command AssignPgv3ToGovHydroRCommand
   */
  @PutMapping("/assignPgv3")
  public void assignPgv3(@RequestBody AssignPgv3ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignPgv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv3", exc);
    }
  }

  /**
   * unassign Pgv3 on GovHydroR
   *
   * @param command UnAssignPgv3FromGovHydroRCommand
   */
  @PutMapping("/unAssignPgv3")
  public void unAssignPgv3(@RequestBody(required = true) UnAssignPgv3FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignPgv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv3", exc);
    }
  }

  /**
   * save Pgv4 on GovHydroR
   *
   * @param command AssignPgv4ToGovHydroRCommand
   */
  @PutMapping("/assignPgv4")
  public void assignPgv4(@RequestBody AssignPgv4ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignPgv4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv4", exc);
    }
  }

  /**
   * unassign Pgv4 on GovHydroR
   *
   * @param command UnAssignPgv4FromGovHydroRCommand
   */
  @PutMapping("/unAssignPgv4")
  public void unAssignPgv4(@RequestBody(required = true) UnAssignPgv4FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignPgv4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv4", exc);
    }
  }

  /**
   * save Pgv5 on GovHydroR
   *
   * @param command AssignPgv5ToGovHydroRCommand
   */
  @PutMapping("/assignPgv5")
  public void assignPgv5(@RequestBody AssignPgv5ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignPgv5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv5", exc);
    }
  }

  /**
   * unassign Pgv5 on GovHydroR
   *
   * @param command UnAssignPgv5FromGovHydroRCommand
   */
  @PutMapping("/unAssignPgv5")
  public void unAssignPgv5(@RequestBody(required = true) UnAssignPgv5FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignPgv5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv5", exc);
    }
  }

  /**
   * save Pgv6 on GovHydroR
   *
   * @param command AssignPgv6ToGovHydroRCommand
   */
  @PutMapping("/assignPgv6")
  public void assignPgv6(@RequestBody AssignPgv6ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignPgv6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv6", exc);
    }
  }

  /**
   * unassign Pgv6 on GovHydroR
   *
   * @param command UnAssignPgv6FromGovHydroRCommand
   */
  @PutMapping("/unAssignPgv6")
  public void unAssignPgv6(@RequestBody(required = true) UnAssignPgv6FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignPgv6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv6", exc);
    }
  }

  /**
   * save Pmax on GovHydroR
   *
   * @param command AssignPmaxToGovHydroRCommand
   */
  @PutMapping("/assignPmax")
  public void assignPmax(@RequestBody AssignPmaxToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignPmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmax", exc);
    }
  }

  /**
   * unassign Pmax on GovHydroR
   *
   * @param command UnAssignPmaxFromGovHydroRCommand
   */
  @PutMapping("/unAssignPmax")
  public void unAssignPmax(@RequestBody(required = true) UnAssignPmaxFromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignPmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmax", exc);
    }
  }

  /**
   * save Pmin on GovHydroR
   *
   * @param command AssignPminToGovHydroRCommand
   */
  @PutMapping("/assignPmin")
  public void assignPmin(@RequestBody AssignPminToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignPmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmin", exc);
    }
  }

  /**
   * unassign Pmin on GovHydroR
   *
   * @param command UnAssignPminFromGovHydroRCommand
   */
  @PutMapping("/unAssignPmin")
  public void unAssignPmin(@RequestBody(required = true) UnAssignPminFromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignPmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmin", exc);
    }
  }

  /**
   * save Qnl on GovHydroR
   *
   * @param command AssignQnlToGovHydroRCommand
   */
  @PutMapping("/assignQnl")
  public void assignQnl(@RequestBody AssignQnlToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignQnl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Qnl", exc);
    }
  }

  /**
   * unassign Qnl on GovHydroR
   *
   * @param command UnAssignQnlFromGovHydroRCommand
   */
  @PutMapping("/unAssignQnl")
  public void unAssignQnl(@RequestBody(required = true) UnAssignQnlFromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignQnl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Qnl", exc);
    }
  }

  /**
   * save R on GovHydroR
   *
   * @param command AssignRToGovHydroRCommand
   */
  @PutMapping("/assignR")
  public void assignR(@RequestBody AssignRToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignR(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R", exc);
    }
  }

  /**
   * unassign R on GovHydroR
   *
   * @param command UnAssignRFromGovHydroRCommand
   */
  @PutMapping("/unAssignR")
  public void unAssignR(@RequestBody(required = true) UnAssignRFromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignR(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R", exc);
    }
  }

  /**
   * save T1 on GovHydroR
   *
   * @param command AssignT1ToGovHydroRCommand
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on GovHydroR
   *
   * @param command UnAssignT1FromGovHydroRCommand
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on GovHydroR
   *
   * @param command AssignT2ToGovHydroRCommand
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on GovHydroR
   *
   * @param command UnAssignT2FromGovHydroRCommand
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on GovHydroR
   *
   * @param command AssignT3ToGovHydroRCommand
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on GovHydroR
   *
   * @param command UnAssignT3FromGovHydroRCommand
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on GovHydroR
   *
   * @param command AssignT4ToGovHydroRCommand
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on GovHydroR
   *
   * @param command UnAssignT4FromGovHydroRCommand
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save T5 on GovHydroR
   *
   * @param command AssignT5ToGovHydroRCommand
   */
  @PutMapping("/assignT5")
  public void assignT5(@RequestBody AssignT5ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignT5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T5", exc);
    }
  }

  /**
   * unassign T5 on GovHydroR
   *
   * @param command UnAssignT5FromGovHydroRCommand
   */
  @PutMapping("/unAssignT5")
  public void unAssignT5(@RequestBody(required = true) UnAssignT5FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignT5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T5", exc);
    }
  }

  /**
   * save T6 on GovHydroR
   *
   * @param command AssignT6ToGovHydroRCommand
   */
  @PutMapping("/assignT6")
  public void assignT6(@RequestBody AssignT6ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignT6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T6", exc);
    }
  }

  /**
   * unassign T6 on GovHydroR
   *
   * @param command UnAssignT6FromGovHydroRCommand
   */
  @PutMapping("/unAssignT6")
  public void unAssignT6(@RequestBody(required = true) UnAssignT6FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignT6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T6", exc);
    }
  }

  /**
   * save T7 on GovHydroR
   *
   * @param command AssignT7ToGovHydroRCommand
   */
  @PutMapping("/assignT7")
  public void assignT7(@RequestBody AssignT7ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignT7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T7", exc);
    }
  }

  /**
   * unassign T7 on GovHydroR
   *
   * @param command UnAssignT7FromGovHydroRCommand
   */
  @PutMapping("/unAssignT7")
  public void unAssignT7(@RequestBody(required = true) UnAssignT7FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignT7(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T7", exc);
    }
  }

  /**
   * save T8 on GovHydroR
   *
   * @param command AssignT8ToGovHydroRCommand
   */
  @PutMapping("/assignT8")
  public void assignT8(@RequestBody AssignT8ToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignT8(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T8", exc);
    }
  }

  /**
   * unassign T8 on GovHydroR
   *
   * @param command UnAssignT8FromGovHydroRCommand
   */
  @PutMapping("/unAssignT8")
  public void unAssignT8(@RequestBody(required = true) UnAssignT8FromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignT8(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T8", exc);
    }
  }

  /**
   * save Td on GovHydroR
   *
   * @param command AssignTdToGovHydroRCommand
   */
  @PutMapping("/assignTd")
  public void assignTd(@RequestBody AssignTdToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignTd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Td", exc);
    }
  }

  /**
   * unassign Td on GovHydroR
   *
   * @param command UnAssignTdFromGovHydroRCommand
   */
  @PutMapping("/unAssignTd")
  public void unAssignTd(@RequestBody(required = true) UnAssignTdFromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignTd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Td", exc);
    }
  }

  /**
   * save Tp on GovHydroR
   *
   * @param command AssignTpToGovHydroRCommand
   */
  @PutMapping("/assignTp")
  public void assignTp(@RequestBody AssignTpToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignTp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tp", exc);
    }
  }

  /**
   * unassign Tp on GovHydroR
   *
   * @param command UnAssignTpFromGovHydroRCommand
   */
  @PutMapping("/unAssignTp")
  public void unAssignTp(@RequestBody(required = true) UnAssignTpFromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignTp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tp", exc);
    }
  }

  /**
   * save Tt on GovHydroR
   *
   * @param command AssignTtToGovHydroRCommand
   */
  @PutMapping("/assignTt")
  public void assignTt(@RequestBody AssignTtToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignTt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tt", exc);
    }
  }

  /**
   * unassign Tt on GovHydroR
   *
   * @param command UnAssignTtFromGovHydroRCommand
   */
  @PutMapping("/unAssignTt")
  public void unAssignTt(@RequestBody(required = true) UnAssignTtFromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignTt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tt", exc);
    }
  }

  /**
   * save Tw on GovHydroR
   *
   * @param command AssignTwToGovHydroRCommand
   */
  @PutMapping("/assignTw")
  public void assignTw(@RequestBody AssignTwToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignTw(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw", exc);
    }
  }

  /**
   * unassign Tw on GovHydroR
   *
   * @param command UnAssignTwFromGovHydroRCommand
   */
  @PutMapping("/unAssignTw")
  public void unAssignTw(@RequestBody(required = true) UnAssignTwFromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignTw(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw", exc);
    }
  }

  /**
   * save Velcl on GovHydroR
   *
   * @param command AssignVelclToGovHydroRCommand
   */
  @PutMapping("/assignVelcl")
  public void assignVelcl(@RequestBody AssignVelclToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignVelcl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Velcl", exc);
    }
  }

  /**
   * unassign Velcl on GovHydroR
   *
   * @param command UnAssignVelclFromGovHydroRCommand
   */
  @PutMapping("/unAssignVelcl")
  public void unAssignVelcl(
      @RequestBody(required = true) UnAssignVelclFromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignVelcl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Velcl", exc);
    }
  }

  /**
   * save Velop on GovHydroR
   *
   * @param command AssignVelopToGovHydroRCommand
   */
  @PutMapping("/assignVelop")
  public void assignVelop(@RequestBody AssignVelopToGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().assignVelop(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Velop", exc);
    }
  }

  /**
   * unassign Velop on GovHydroR
   *
   * @param command UnAssignVelopFromGovHydroRCommand
   */
  @PutMapping("/unAssignVelop")
  public void unAssignVelop(
      @RequestBody(required = true) UnAssignVelopFromGovHydroRCommand command) {
    try {
      GovHydroRBusinessDelegate.getGovHydroRInstance().unAssignVelop(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Velop", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovHydroR govHydroR = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovHydroRCommandRestController.class.getName());
}
