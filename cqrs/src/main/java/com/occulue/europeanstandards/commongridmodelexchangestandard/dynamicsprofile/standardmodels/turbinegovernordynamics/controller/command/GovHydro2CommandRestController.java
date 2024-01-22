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
 * Implements Spring Controller command CQRS processing for entity GovHydro2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydro2")
public class GovHydro2CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovHydro2. if not key provided, calls create, otherwise calls save
   *
   * @param GovHydro2 govHydro2
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovHydro2Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = GovHydro2BusinessDelegate.getGovHydro2Instance().createGovHydro2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovHydro2. if no key provided, calls create, otherwise calls save
   *
   * @param GovHydro2 govHydro2
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovHydro2Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovHydro2Command
      // -----------------------------------------------
      completableFuture = GovHydro2BusinessDelegate.getGovHydro2Instance().updateGovHydro2(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovHydro2Controller:update() - successfully update GovHydro2 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovHydro2 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govHydro2Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovHydro2Command command = new DeleteGovHydro2Command(govHydro2Id);

    try {
      GovHydro2BusinessDelegate delegate = GovHydro2BusinessDelegate.getGovHydro2Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovHydro2 with key " + command.getGovHydro2Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Aturb on GovHydro2
   *
   * @param command AssignAturbToGovHydro2Command
   */
  @PutMapping("/assignAturb")
  public void assignAturb(@RequestBody AssignAturbToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignAturb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Aturb", exc);
    }
  }

  /**
   * unassign Aturb on GovHydro2
   *
   * @param command UnAssignAturbFromGovHydro2Command
   */
  @PutMapping("/unAssignAturb")
  public void unAssignAturb(
      @RequestBody(required = true) UnAssignAturbFromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignAturb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Aturb", exc);
    }
  }

  /**
   * save Bturb on GovHydro2
   *
   * @param command AssignBturbToGovHydro2Command
   */
  @PutMapping("/assignBturb")
  public void assignBturb(@RequestBody AssignBturbToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignBturb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bturb", exc);
    }
  }

  /**
   * unassign Bturb on GovHydro2
   *
   * @param command UnAssignBturbFromGovHydro2Command
   */
  @PutMapping("/unAssignBturb")
  public void unAssignBturb(
      @RequestBody(required = true) UnAssignBturbFromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignBturb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bturb", exc);
    }
  }

  /**
   * save Db1 on GovHydro2
   *
   * @param command AssignDb1ToGovHydro2Command
   */
  @PutMapping("/assignDb1")
  public void assignDb1(@RequestBody AssignDb1ToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignDb1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db1", exc);
    }
  }

  /**
   * unassign Db1 on GovHydro2
   *
   * @param command UnAssignDb1FromGovHydro2Command
   */
  @PutMapping("/unAssignDb1")
  public void unAssignDb1(@RequestBody(required = true) UnAssignDb1FromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignDb1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db1", exc);
    }
  }

  /**
   * save Db2 on GovHydro2
   *
   * @param command AssignDb2ToGovHydro2Command
   */
  @PutMapping("/assignDb2")
  public void assignDb2(@RequestBody AssignDb2ToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignDb2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db2", exc);
    }
  }

  /**
   * unassign Db2 on GovHydro2
   *
   * @param command UnAssignDb2FromGovHydro2Command
   */
  @PutMapping("/unAssignDb2")
  public void unAssignDb2(@RequestBody(required = true) UnAssignDb2FromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignDb2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db2", exc);
    }
  }

  /**
   * save Eps on GovHydro2
   *
   * @param command AssignEpsToGovHydro2Command
   */
  @PutMapping("/assignEps")
  public void assignEps(@RequestBody AssignEpsToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignEps(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Eps", exc);
    }
  }

  /**
   * unassign Eps on GovHydro2
   *
   * @param command UnAssignEpsFromGovHydro2Command
   */
  @PutMapping("/unAssignEps")
  public void unAssignEps(@RequestBody(required = true) UnAssignEpsFromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignEps(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Eps", exc);
    }
  }

  /**
   * save Gv1 on GovHydro2
   *
   * @param command AssignGv1ToGovHydro2Command
   */
  @PutMapping("/assignGv1")
  public void assignGv1(@RequestBody AssignGv1ToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignGv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv1", exc);
    }
  }

  /**
   * unassign Gv1 on GovHydro2
   *
   * @param command UnAssignGv1FromGovHydro2Command
   */
  @PutMapping("/unAssignGv1")
  public void unAssignGv1(@RequestBody(required = true) UnAssignGv1FromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignGv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv1", exc);
    }
  }

  /**
   * save Gv2 on GovHydro2
   *
   * @param command AssignGv2ToGovHydro2Command
   */
  @PutMapping("/assignGv2")
  public void assignGv2(@RequestBody AssignGv2ToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignGv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv2", exc);
    }
  }

  /**
   * unassign Gv2 on GovHydro2
   *
   * @param command UnAssignGv2FromGovHydro2Command
   */
  @PutMapping("/unAssignGv2")
  public void unAssignGv2(@RequestBody(required = true) UnAssignGv2FromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignGv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv2", exc);
    }
  }

  /**
   * save Gv3 on GovHydro2
   *
   * @param command AssignGv3ToGovHydro2Command
   */
  @PutMapping("/assignGv3")
  public void assignGv3(@RequestBody AssignGv3ToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignGv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv3", exc);
    }
  }

  /**
   * unassign Gv3 on GovHydro2
   *
   * @param command UnAssignGv3FromGovHydro2Command
   */
  @PutMapping("/unAssignGv3")
  public void unAssignGv3(@RequestBody(required = true) UnAssignGv3FromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignGv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv3", exc);
    }
  }

  /**
   * save Gv4 on GovHydro2
   *
   * @param command AssignGv4ToGovHydro2Command
   */
  @PutMapping("/assignGv4")
  public void assignGv4(@RequestBody AssignGv4ToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignGv4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv4", exc);
    }
  }

  /**
   * unassign Gv4 on GovHydro2
   *
   * @param command UnAssignGv4FromGovHydro2Command
   */
  @PutMapping("/unAssignGv4")
  public void unAssignGv4(@RequestBody(required = true) UnAssignGv4FromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignGv4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv4", exc);
    }
  }

  /**
   * save Gv5 on GovHydro2
   *
   * @param command AssignGv5ToGovHydro2Command
   */
  @PutMapping("/assignGv5")
  public void assignGv5(@RequestBody AssignGv5ToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignGv5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv5", exc);
    }
  }

  /**
   * unassign Gv5 on GovHydro2
   *
   * @param command UnAssignGv5FromGovHydro2Command
   */
  @PutMapping("/unAssignGv5")
  public void unAssignGv5(@RequestBody(required = true) UnAssignGv5FromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignGv5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv5", exc);
    }
  }

  /**
   * save Gv6 on GovHydro2
   *
   * @param command AssignGv6ToGovHydro2Command
   */
  @PutMapping("/assignGv6")
  public void assignGv6(@RequestBody AssignGv6ToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignGv6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv6", exc);
    }
  }

  /**
   * unassign Gv6 on GovHydro2
   *
   * @param command UnAssignGv6FromGovHydro2Command
   */
  @PutMapping("/unAssignGv6")
  public void unAssignGv6(@RequestBody(required = true) UnAssignGv6FromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignGv6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv6", exc);
    }
  }

  /**
   * save Kturb on GovHydro2
   *
   * @param command AssignKturbToGovHydro2Command
   */
  @PutMapping("/assignKturb")
  public void assignKturb(@RequestBody AssignKturbToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignKturb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kturb", exc);
    }
  }

  /**
   * unassign Kturb on GovHydro2
   *
   * @param command UnAssignKturbFromGovHydro2Command
   */
  @PutMapping("/unAssignKturb")
  public void unAssignKturb(
      @RequestBody(required = true) UnAssignKturbFromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignKturb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kturb", exc);
    }
  }

  /**
   * save Mwbase on GovHydro2
   *
   * @param command AssignMwbaseToGovHydro2Command
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovHydro2
   *
   * @param command UnAssignMwbaseFromGovHydro2Command
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save Pgv1 on GovHydro2
   *
   * @param command AssignPgv1ToGovHydro2Command
   */
  @PutMapping("/assignPgv1")
  public void assignPgv1(@RequestBody AssignPgv1ToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignPgv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv1", exc);
    }
  }

  /**
   * unassign Pgv1 on GovHydro2
   *
   * @param command UnAssignPgv1FromGovHydro2Command
   */
  @PutMapping("/unAssignPgv1")
  public void unAssignPgv1(@RequestBody(required = true) UnAssignPgv1FromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignPgv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv1", exc);
    }
  }

  /**
   * save Pgv2 on GovHydro2
   *
   * @param command AssignPgv2ToGovHydro2Command
   */
  @PutMapping("/assignPgv2")
  public void assignPgv2(@RequestBody AssignPgv2ToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignPgv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv2", exc);
    }
  }

  /**
   * unassign Pgv2 on GovHydro2
   *
   * @param command UnAssignPgv2FromGovHydro2Command
   */
  @PutMapping("/unAssignPgv2")
  public void unAssignPgv2(@RequestBody(required = true) UnAssignPgv2FromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignPgv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv2", exc);
    }
  }

  /**
   * save Pgv3 on GovHydro2
   *
   * @param command AssignPgv3ToGovHydro2Command
   */
  @PutMapping("/assignPgv3")
  public void assignPgv3(@RequestBody AssignPgv3ToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignPgv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv3", exc);
    }
  }

  /**
   * unassign Pgv3 on GovHydro2
   *
   * @param command UnAssignPgv3FromGovHydro2Command
   */
  @PutMapping("/unAssignPgv3")
  public void unAssignPgv3(@RequestBody(required = true) UnAssignPgv3FromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignPgv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv3", exc);
    }
  }

  /**
   * save Pgv4 on GovHydro2
   *
   * @param command AssignPgv4ToGovHydro2Command
   */
  @PutMapping("/assignPgv4")
  public void assignPgv4(@RequestBody AssignPgv4ToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignPgv4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv4", exc);
    }
  }

  /**
   * unassign Pgv4 on GovHydro2
   *
   * @param command UnAssignPgv4FromGovHydro2Command
   */
  @PutMapping("/unAssignPgv4")
  public void unAssignPgv4(@RequestBody(required = true) UnAssignPgv4FromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignPgv4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv4", exc);
    }
  }

  /**
   * save Pgv5 on GovHydro2
   *
   * @param command AssignPgv5ToGovHydro2Command
   */
  @PutMapping("/assignPgv5")
  public void assignPgv5(@RequestBody AssignPgv5ToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignPgv5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv5", exc);
    }
  }

  /**
   * unassign Pgv5 on GovHydro2
   *
   * @param command UnAssignPgv5FromGovHydro2Command
   */
  @PutMapping("/unAssignPgv5")
  public void unAssignPgv5(@RequestBody(required = true) UnAssignPgv5FromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignPgv5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv5", exc);
    }
  }

  /**
   * save Pgv6 on GovHydro2
   *
   * @param command AssignPgv6ToGovHydro2Command
   */
  @PutMapping("/assignPgv6")
  public void assignPgv6(@RequestBody AssignPgv6ToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignPgv6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv6", exc);
    }
  }

  /**
   * unassign Pgv6 on GovHydro2
   *
   * @param command UnAssignPgv6FromGovHydro2Command
   */
  @PutMapping("/unAssignPgv6")
  public void unAssignPgv6(@RequestBody(required = true) UnAssignPgv6FromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignPgv6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv6", exc);
    }
  }

  /**
   * save Pmax on GovHydro2
   *
   * @param command AssignPmaxToGovHydro2Command
   */
  @PutMapping("/assignPmax")
  public void assignPmax(@RequestBody AssignPmaxToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignPmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmax", exc);
    }
  }

  /**
   * unassign Pmax on GovHydro2
   *
   * @param command UnAssignPmaxFromGovHydro2Command
   */
  @PutMapping("/unAssignPmax")
  public void unAssignPmax(@RequestBody(required = true) UnAssignPmaxFromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignPmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmax", exc);
    }
  }

  /**
   * save Pmin on GovHydro2
   *
   * @param command AssignPminToGovHydro2Command
   */
  @PutMapping("/assignPmin")
  public void assignPmin(@RequestBody AssignPminToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignPmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmin", exc);
    }
  }

  /**
   * unassign Pmin on GovHydro2
   *
   * @param command UnAssignPminFromGovHydro2Command
   */
  @PutMapping("/unAssignPmin")
  public void unAssignPmin(@RequestBody(required = true) UnAssignPminFromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignPmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmin", exc);
    }
  }

  /**
   * save Rperm on GovHydro2
   *
   * @param command AssignRpermToGovHydro2Command
   */
  @PutMapping("/assignRperm")
  public void assignRperm(@RequestBody AssignRpermToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignRperm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rperm", exc);
    }
  }

  /**
   * unassign Rperm on GovHydro2
   *
   * @param command UnAssignRpermFromGovHydro2Command
   */
  @PutMapping("/unAssignRperm")
  public void unAssignRperm(
      @RequestBody(required = true) UnAssignRpermFromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignRperm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rperm", exc);
    }
  }

  /**
   * save Rtemp on GovHydro2
   *
   * @param command AssignRtempToGovHydro2Command
   */
  @PutMapping("/assignRtemp")
  public void assignRtemp(@RequestBody AssignRtempToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignRtemp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rtemp", exc);
    }
  }

  /**
   * unassign Rtemp on GovHydro2
   *
   * @param command UnAssignRtempFromGovHydro2Command
   */
  @PutMapping("/unAssignRtemp")
  public void unAssignRtemp(
      @RequestBody(required = true) UnAssignRtempFromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignRtemp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rtemp", exc);
    }
  }

  /**
   * save Tg on GovHydro2
   *
   * @param command AssignTgToGovHydro2Command
   */
  @PutMapping("/assignTg")
  public void assignTg(@RequestBody AssignTgToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignTg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tg", exc);
    }
  }

  /**
   * unassign Tg on GovHydro2
   *
   * @param command UnAssignTgFromGovHydro2Command
   */
  @PutMapping("/unAssignTg")
  public void unAssignTg(@RequestBody(required = true) UnAssignTgFromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignTg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tg", exc);
    }
  }

  /**
   * save Tp on GovHydro2
   *
   * @param command AssignTpToGovHydro2Command
   */
  @PutMapping("/assignTp")
  public void assignTp(@RequestBody AssignTpToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignTp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tp", exc);
    }
  }

  /**
   * unassign Tp on GovHydro2
   *
   * @param command UnAssignTpFromGovHydro2Command
   */
  @PutMapping("/unAssignTp")
  public void unAssignTp(@RequestBody(required = true) UnAssignTpFromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignTp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tp", exc);
    }
  }

  /**
   * save Tr on GovHydro2
   *
   * @param command AssignTrToGovHydro2Command
   */
  @PutMapping("/assignTr")
  public void assignTr(@RequestBody AssignTrToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignTr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tr", exc);
    }
  }

  /**
   * unassign Tr on GovHydro2
   *
   * @param command UnAssignTrFromGovHydro2Command
   */
  @PutMapping("/unAssignTr")
  public void unAssignTr(@RequestBody(required = true) UnAssignTrFromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignTr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tr", exc);
    }
  }

  /**
   * save Tw on GovHydro2
   *
   * @param command AssignTwToGovHydro2Command
   */
  @PutMapping("/assignTw")
  public void assignTw(@RequestBody AssignTwToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignTw(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw", exc);
    }
  }

  /**
   * unassign Tw on GovHydro2
   *
   * @param command UnAssignTwFromGovHydro2Command
   */
  @PutMapping("/unAssignTw")
  public void unAssignTw(@RequestBody(required = true) UnAssignTwFromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignTw(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw", exc);
    }
  }

  /**
   * save Uc on GovHydro2
   *
   * @param command AssignUcToGovHydro2Command
   */
  @PutMapping("/assignUc")
  public void assignUc(@RequestBody AssignUcToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignUc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uc", exc);
    }
  }

  /**
   * unassign Uc on GovHydro2
   *
   * @param command UnAssignUcFromGovHydro2Command
   */
  @PutMapping("/unAssignUc")
  public void unAssignUc(@RequestBody(required = true) UnAssignUcFromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignUc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uc", exc);
    }
  }

  /**
   * save Uo on GovHydro2
   *
   * @param command AssignUoToGovHydro2Command
   */
  @PutMapping("/assignUo")
  public void assignUo(@RequestBody AssignUoToGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().assignUo(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uo", exc);
    }
  }

  /**
   * unassign Uo on GovHydro2
   *
   * @param command UnAssignUoFromGovHydro2Command
   */
  @PutMapping("/unAssignUo")
  public void unAssignUo(@RequestBody(required = true) UnAssignUoFromGovHydro2Command command) {
    try {
      GovHydro2BusinessDelegate.getGovHydro2Instance().unAssignUo(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uo", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovHydro2 govHydro2 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovHydro2CommandRestController.class.getName());
}
