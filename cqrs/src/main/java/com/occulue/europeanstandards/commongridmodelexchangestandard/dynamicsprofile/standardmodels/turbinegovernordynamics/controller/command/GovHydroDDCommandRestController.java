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
 * Implements Spring Controller command CQRS processing for entity GovHydroDD.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroDD")
public class GovHydroDDCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovHydroDD. if not key provided, calls create, otherwise calls save
   *
   * @param GovHydroDD govHydroDD
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovHydroDDCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          GovHydroDDBusinessDelegate.getGovHydroDDInstance().createGovHydroDD(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovHydroDD. if no key provided, calls create, otherwise calls save
   *
   * @param GovHydroDD govHydroDD
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovHydroDDCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovHydroDDCommand
      // -----------------------------------------------
      completableFuture =
          GovHydroDDBusinessDelegate.getGovHydroDDInstance().updateGovHydroDD(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovHydroDDController:update() - successfully update GovHydroDD - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovHydroDD entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govHydroDDId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovHydroDDCommand command = new DeleteGovHydroDDCommand(govHydroDDId);

    try {
      GovHydroDDBusinessDelegate delegate = GovHydroDDBusinessDelegate.getGovHydroDDInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovHydroDD with key " + command.getGovHydroDDId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Aturb on GovHydroDD
   *
   * @param command AssignAturbToGovHydroDDCommand
   */
  @PutMapping("/assignAturb")
  public void assignAturb(@RequestBody AssignAturbToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignAturb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Aturb", exc);
    }
  }

  /**
   * unassign Aturb on GovHydroDD
   *
   * @param command UnAssignAturbFromGovHydroDDCommand
   */
  @PutMapping("/unAssignAturb")
  public void unAssignAturb(
      @RequestBody(required = true) UnAssignAturbFromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignAturb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Aturb", exc);
    }
  }

  /**
   * save Bturb on GovHydroDD
   *
   * @param command AssignBturbToGovHydroDDCommand
   */
  @PutMapping("/assignBturb")
  public void assignBturb(@RequestBody AssignBturbToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignBturb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bturb", exc);
    }
  }

  /**
   * unassign Bturb on GovHydroDD
   *
   * @param command UnAssignBturbFromGovHydroDDCommand
   */
  @PutMapping("/unAssignBturb")
  public void unAssignBturb(
      @RequestBody(required = true) UnAssignBturbFromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignBturb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bturb", exc);
    }
  }

  /**
   * save Db1 on GovHydroDD
   *
   * @param command AssignDb1ToGovHydroDDCommand
   */
  @PutMapping("/assignDb1")
  public void assignDb1(@RequestBody AssignDb1ToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignDb1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db1", exc);
    }
  }

  /**
   * unassign Db1 on GovHydroDD
   *
   * @param command UnAssignDb1FromGovHydroDDCommand
   */
  @PutMapping("/unAssignDb1")
  public void unAssignDb1(@RequestBody(required = true) UnAssignDb1FromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignDb1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db1", exc);
    }
  }

  /**
   * save Db2 on GovHydroDD
   *
   * @param command AssignDb2ToGovHydroDDCommand
   */
  @PutMapping("/assignDb2")
  public void assignDb2(@RequestBody AssignDb2ToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignDb2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db2", exc);
    }
  }

  /**
   * unassign Db2 on GovHydroDD
   *
   * @param command UnAssignDb2FromGovHydroDDCommand
   */
  @PutMapping("/unAssignDb2")
  public void unAssignDb2(@RequestBody(required = true) UnAssignDb2FromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignDb2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db2", exc);
    }
  }

  /**
   * save Eps on GovHydroDD
   *
   * @param command AssignEpsToGovHydroDDCommand
   */
  @PutMapping("/assignEps")
  public void assignEps(@RequestBody AssignEpsToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignEps(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Eps", exc);
    }
  }

  /**
   * unassign Eps on GovHydroDD
   *
   * @param command UnAssignEpsFromGovHydroDDCommand
   */
  @PutMapping("/unAssignEps")
  public void unAssignEps(@RequestBody(required = true) UnAssignEpsFromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignEps(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Eps", exc);
    }
  }

  /**
   * save Gmax on GovHydroDD
   *
   * @param command AssignGmaxToGovHydroDDCommand
   */
  @PutMapping("/assignGmax")
  public void assignGmax(@RequestBody AssignGmaxToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignGmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gmax", exc);
    }
  }

  /**
   * unassign Gmax on GovHydroDD
   *
   * @param command UnAssignGmaxFromGovHydroDDCommand
   */
  @PutMapping("/unAssignGmax")
  public void unAssignGmax(
      @RequestBody(required = true) UnAssignGmaxFromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignGmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gmax", exc);
    }
  }

  /**
   * save Gmin on GovHydroDD
   *
   * @param command AssignGminToGovHydroDDCommand
   */
  @PutMapping("/assignGmin")
  public void assignGmin(@RequestBody AssignGminToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignGmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gmin", exc);
    }
  }

  /**
   * unassign Gmin on GovHydroDD
   *
   * @param command UnAssignGminFromGovHydroDDCommand
   */
  @PutMapping("/unAssignGmin")
  public void unAssignGmin(
      @RequestBody(required = true) UnAssignGminFromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignGmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gmin", exc);
    }
  }

  /**
   * save Gv1 on GovHydroDD
   *
   * @param command AssignGv1ToGovHydroDDCommand
   */
  @PutMapping("/assignGv1")
  public void assignGv1(@RequestBody AssignGv1ToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignGv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv1", exc);
    }
  }

  /**
   * unassign Gv1 on GovHydroDD
   *
   * @param command UnAssignGv1FromGovHydroDDCommand
   */
  @PutMapping("/unAssignGv1")
  public void unAssignGv1(@RequestBody(required = true) UnAssignGv1FromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignGv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv1", exc);
    }
  }

  /**
   * save Gv2 on GovHydroDD
   *
   * @param command AssignGv2ToGovHydroDDCommand
   */
  @PutMapping("/assignGv2")
  public void assignGv2(@RequestBody AssignGv2ToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignGv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv2", exc);
    }
  }

  /**
   * unassign Gv2 on GovHydroDD
   *
   * @param command UnAssignGv2FromGovHydroDDCommand
   */
  @PutMapping("/unAssignGv2")
  public void unAssignGv2(@RequestBody(required = true) UnAssignGv2FromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignGv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv2", exc);
    }
  }

  /**
   * save Gv3 on GovHydroDD
   *
   * @param command AssignGv3ToGovHydroDDCommand
   */
  @PutMapping("/assignGv3")
  public void assignGv3(@RequestBody AssignGv3ToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignGv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv3", exc);
    }
  }

  /**
   * unassign Gv3 on GovHydroDD
   *
   * @param command UnAssignGv3FromGovHydroDDCommand
   */
  @PutMapping("/unAssignGv3")
  public void unAssignGv3(@RequestBody(required = true) UnAssignGv3FromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignGv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv3", exc);
    }
  }

  /**
   * save Gv4 on GovHydroDD
   *
   * @param command AssignGv4ToGovHydroDDCommand
   */
  @PutMapping("/assignGv4")
  public void assignGv4(@RequestBody AssignGv4ToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignGv4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv4", exc);
    }
  }

  /**
   * unassign Gv4 on GovHydroDD
   *
   * @param command UnAssignGv4FromGovHydroDDCommand
   */
  @PutMapping("/unAssignGv4")
  public void unAssignGv4(@RequestBody(required = true) UnAssignGv4FromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignGv4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv4", exc);
    }
  }

  /**
   * save Gv5 on GovHydroDD
   *
   * @param command AssignGv5ToGovHydroDDCommand
   */
  @PutMapping("/assignGv5")
  public void assignGv5(@RequestBody AssignGv5ToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignGv5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv5", exc);
    }
  }

  /**
   * unassign Gv5 on GovHydroDD
   *
   * @param command UnAssignGv5FromGovHydroDDCommand
   */
  @PutMapping("/unAssignGv5")
  public void unAssignGv5(@RequestBody(required = true) UnAssignGv5FromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignGv5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv5", exc);
    }
  }

  /**
   * save Gv6 on GovHydroDD
   *
   * @param command AssignGv6ToGovHydroDDCommand
   */
  @PutMapping("/assignGv6")
  public void assignGv6(@RequestBody AssignGv6ToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignGv6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv6", exc);
    }
  }

  /**
   * unassign Gv6 on GovHydroDD
   *
   * @param command UnAssignGv6FromGovHydroDDCommand
   */
  @PutMapping("/unAssignGv6")
  public void unAssignGv6(@RequestBody(required = true) UnAssignGv6FromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignGv6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv6", exc);
    }
  }

  /**
   * save InputSignal on GovHydroDD
   *
   * @param command AssignInputSignalToGovHydroDDCommand
   */
  @PutMapping("/assignInputSignal")
  public void assignInputSignal(@RequestBody AssignInputSignalToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignInputSignal(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign InputSignal", exc);
    }
  }

  /**
   * unassign InputSignal on GovHydroDD
   *
   * @param command UnAssignInputSignalFromGovHydroDDCommand
   */
  @PutMapping("/unAssignInputSignal")
  public void unAssignInputSignal(
      @RequestBody(required = true) UnAssignInputSignalFromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignInputSignal(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign InputSignal", exc);
    }
  }

  /**
   * save K1 on GovHydroDD
   *
   * @param command AssignK1ToGovHydroDDCommand
   */
  @PutMapping("/assignK1")
  public void assignK1(@RequestBody AssignK1ToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignK1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K1", exc);
    }
  }

  /**
   * unassign K1 on GovHydroDD
   *
   * @param command UnAssignK1FromGovHydroDDCommand
   */
  @PutMapping("/unAssignK1")
  public void unAssignK1(@RequestBody(required = true) UnAssignK1FromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignK1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K1", exc);
    }
  }

  /**
   * save K2 on GovHydroDD
   *
   * @param command AssignK2ToGovHydroDDCommand
   */
  @PutMapping("/assignK2")
  public void assignK2(@RequestBody AssignK2ToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignK2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K2", exc);
    }
  }

  /**
   * unassign K2 on GovHydroDD
   *
   * @param command UnAssignK2FromGovHydroDDCommand
   */
  @PutMapping("/unAssignK2")
  public void unAssignK2(@RequestBody(required = true) UnAssignK2FromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignK2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K2", exc);
    }
  }

  /**
   * save Kg on GovHydroDD
   *
   * @param command AssignKgToGovHydroDDCommand
   */
  @PutMapping("/assignKg")
  public void assignKg(@RequestBody AssignKgToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignKg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kg", exc);
    }
  }

  /**
   * unassign Kg on GovHydroDD
   *
   * @param command UnAssignKgFromGovHydroDDCommand
   */
  @PutMapping("/unAssignKg")
  public void unAssignKg(@RequestBody(required = true) UnAssignKgFromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignKg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kg", exc);
    }
  }

  /**
   * save Ki on GovHydroDD
   *
   * @param command AssignKiToGovHydroDDCommand
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on GovHydroDD
   *
   * @param command UnAssignKiFromGovHydroDDCommand
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(@RequestBody(required = true) UnAssignKiFromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Mwbase on GovHydroDD
   *
   * @param command AssignMwbaseToGovHydroDDCommand
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovHydroDD
   *
   * @param command UnAssignMwbaseFromGovHydroDDCommand
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save Pgv1 on GovHydroDD
   *
   * @param command AssignPgv1ToGovHydroDDCommand
   */
  @PutMapping("/assignPgv1")
  public void assignPgv1(@RequestBody AssignPgv1ToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignPgv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv1", exc);
    }
  }

  /**
   * unassign Pgv1 on GovHydroDD
   *
   * @param command UnAssignPgv1FromGovHydroDDCommand
   */
  @PutMapping("/unAssignPgv1")
  public void unAssignPgv1(
      @RequestBody(required = true) UnAssignPgv1FromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignPgv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv1", exc);
    }
  }

  /**
   * save Pgv2 on GovHydroDD
   *
   * @param command AssignPgv2ToGovHydroDDCommand
   */
  @PutMapping("/assignPgv2")
  public void assignPgv2(@RequestBody AssignPgv2ToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignPgv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv2", exc);
    }
  }

  /**
   * unassign Pgv2 on GovHydroDD
   *
   * @param command UnAssignPgv2FromGovHydroDDCommand
   */
  @PutMapping("/unAssignPgv2")
  public void unAssignPgv2(
      @RequestBody(required = true) UnAssignPgv2FromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignPgv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv2", exc);
    }
  }

  /**
   * save Pgv3 on GovHydroDD
   *
   * @param command AssignPgv3ToGovHydroDDCommand
   */
  @PutMapping("/assignPgv3")
  public void assignPgv3(@RequestBody AssignPgv3ToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignPgv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv3", exc);
    }
  }

  /**
   * unassign Pgv3 on GovHydroDD
   *
   * @param command UnAssignPgv3FromGovHydroDDCommand
   */
  @PutMapping("/unAssignPgv3")
  public void unAssignPgv3(
      @RequestBody(required = true) UnAssignPgv3FromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignPgv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv3", exc);
    }
  }

  /**
   * save Pgv4 on GovHydroDD
   *
   * @param command AssignPgv4ToGovHydroDDCommand
   */
  @PutMapping("/assignPgv4")
  public void assignPgv4(@RequestBody AssignPgv4ToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignPgv4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv4", exc);
    }
  }

  /**
   * unassign Pgv4 on GovHydroDD
   *
   * @param command UnAssignPgv4FromGovHydroDDCommand
   */
  @PutMapping("/unAssignPgv4")
  public void unAssignPgv4(
      @RequestBody(required = true) UnAssignPgv4FromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignPgv4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv4", exc);
    }
  }

  /**
   * save Pgv5 on GovHydroDD
   *
   * @param command AssignPgv5ToGovHydroDDCommand
   */
  @PutMapping("/assignPgv5")
  public void assignPgv5(@RequestBody AssignPgv5ToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignPgv5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv5", exc);
    }
  }

  /**
   * unassign Pgv5 on GovHydroDD
   *
   * @param command UnAssignPgv5FromGovHydroDDCommand
   */
  @PutMapping("/unAssignPgv5")
  public void unAssignPgv5(
      @RequestBody(required = true) UnAssignPgv5FromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignPgv5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv5", exc);
    }
  }

  /**
   * save Pgv6 on GovHydroDD
   *
   * @param command AssignPgv6ToGovHydroDDCommand
   */
  @PutMapping("/assignPgv6")
  public void assignPgv6(@RequestBody AssignPgv6ToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignPgv6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv6", exc);
    }
  }

  /**
   * unassign Pgv6 on GovHydroDD
   *
   * @param command UnAssignPgv6FromGovHydroDDCommand
   */
  @PutMapping("/unAssignPgv6")
  public void unAssignPgv6(
      @RequestBody(required = true) UnAssignPgv6FromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignPgv6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv6", exc);
    }
  }

  /**
   * save Pmax on GovHydroDD
   *
   * @param command AssignPmaxToGovHydroDDCommand
   */
  @PutMapping("/assignPmax")
  public void assignPmax(@RequestBody AssignPmaxToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignPmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmax", exc);
    }
  }

  /**
   * unassign Pmax on GovHydroDD
   *
   * @param command UnAssignPmaxFromGovHydroDDCommand
   */
  @PutMapping("/unAssignPmax")
  public void unAssignPmax(
      @RequestBody(required = true) UnAssignPmaxFromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignPmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmax", exc);
    }
  }

  /**
   * save Pmin on GovHydroDD
   *
   * @param command AssignPminToGovHydroDDCommand
   */
  @PutMapping("/assignPmin")
  public void assignPmin(@RequestBody AssignPminToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignPmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmin", exc);
    }
  }

  /**
   * unassign Pmin on GovHydroDD
   *
   * @param command UnAssignPminFromGovHydroDDCommand
   */
  @PutMapping("/unAssignPmin")
  public void unAssignPmin(
      @RequestBody(required = true) UnAssignPminFromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignPmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmin", exc);
    }
  }

  /**
   * save R on GovHydroDD
   *
   * @param command AssignRToGovHydroDDCommand
   */
  @PutMapping("/assignR")
  public void assignR(@RequestBody AssignRToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignR(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R", exc);
    }
  }

  /**
   * unassign R on GovHydroDD
   *
   * @param command UnAssignRFromGovHydroDDCommand
   */
  @PutMapping("/unAssignR")
  public void unAssignR(@RequestBody(required = true) UnAssignRFromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignR(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R", exc);
    }
  }

  /**
   * save Td on GovHydroDD
   *
   * @param command AssignTdToGovHydroDDCommand
   */
  @PutMapping("/assignTd")
  public void assignTd(@RequestBody AssignTdToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignTd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Td", exc);
    }
  }

  /**
   * unassign Td on GovHydroDD
   *
   * @param command UnAssignTdFromGovHydroDDCommand
   */
  @PutMapping("/unAssignTd")
  public void unAssignTd(@RequestBody(required = true) UnAssignTdFromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignTd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Td", exc);
    }
  }

  /**
   * save Tf on GovHydroDD
   *
   * @param command AssignTfToGovHydroDDCommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on GovHydroDD
   *
   * @param command UnAssignTfFromGovHydroDDCommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Tp on GovHydroDD
   *
   * @param command AssignTpToGovHydroDDCommand
   */
  @PutMapping("/assignTp")
  public void assignTp(@RequestBody AssignTpToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignTp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tp", exc);
    }
  }

  /**
   * unassign Tp on GovHydroDD
   *
   * @param command UnAssignTpFromGovHydroDDCommand
   */
  @PutMapping("/unAssignTp")
  public void unAssignTp(@RequestBody(required = true) UnAssignTpFromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignTp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tp", exc);
    }
  }

  /**
   * save Tt on GovHydroDD
   *
   * @param command AssignTtToGovHydroDDCommand
   */
  @PutMapping("/assignTt")
  public void assignTt(@RequestBody AssignTtToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignTt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tt", exc);
    }
  }

  /**
   * unassign Tt on GovHydroDD
   *
   * @param command UnAssignTtFromGovHydroDDCommand
   */
  @PutMapping("/unAssignTt")
  public void unAssignTt(@RequestBody(required = true) UnAssignTtFromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignTt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tt", exc);
    }
  }

  /**
   * save Tturb on GovHydroDD
   *
   * @param command AssignTturbToGovHydroDDCommand
   */
  @PutMapping("/assignTturb")
  public void assignTturb(@RequestBody AssignTturbToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignTturb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tturb", exc);
    }
  }

  /**
   * unassign Tturb on GovHydroDD
   *
   * @param command UnAssignTturbFromGovHydroDDCommand
   */
  @PutMapping("/unAssignTturb")
  public void unAssignTturb(
      @RequestBody(required = true) UnAssignTturbFromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignTturb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tturb", exc);
    }
  }

  /**
   * save Velcl on GovHydroDD
   *
   * @param command AssignVelclToGovHydroDDCommand
   */
  @PutMapping("/assignVelcl")
  public void assignVelcl(@RequestBody AssignVelclToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignVelcl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Velcl", exc);
    }
  }

  /**
   * unassign Velcl on GovHydroDD
   *
   * @param command UnAssignVelclFromGovHydroDDCommand
   */
  @PutMapping("/unAssignVelcl")
  public void unAssignVelcl(
      @RequestBody(required = true) UnAssignVelclFromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignVelcl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Velcl", exc);
    }
  }

  /**
   * save Velop on GovHydroDD
   *
   * @param command AssignVelopToGovHydroDDCommand
   */
  @PutMapping("/assignVelop")
  public void assignVelop(@RequestBody AssignVelopToGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().assignVelop(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Velop", exc);
    }
  }

  /**
   * unassign Velop on GovHydroDD
   *
   * @param command UnAssignVelopFromGovHydroDDCommand
   */
  @PutMapping("/unAssignVelop")
  public void unAssignVelop(
      @RequestBody(required = true) UnAssignVelopFromGovHydroDDCommand command) {
    try {
      GovHydroDDBusinessDelegate.getGovHydroDDInstance().unAssignVelop(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Velop", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovHydroDD govHydroDD = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovHydroDDCommandRestController.class.getName());
}
