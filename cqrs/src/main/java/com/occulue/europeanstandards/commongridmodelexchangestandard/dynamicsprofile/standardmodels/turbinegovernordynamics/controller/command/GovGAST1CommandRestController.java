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
 * Implements Spring Controller command CQRS processing for entity GovGAST1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovGAST1")
public class GovGAST1CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovGAST1. if not key provided, calls create, otherwise calls save
   *
   * @param GovGAST1 govGAST1
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovGAST1Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = GovGAST1BusinessDelegate.getGovGAST1Instance().createGovGAST1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovGAST1. if no key provided, calls create, otherwise calls save
   *
   * @param GovGAST1 govGAST1
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovGAST1Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovGAST1Command
      // -----------------------------------------------
      completableFuture = GovGAST1BusinessDelegate.getGovGAST1Instance().updateGovGAST1(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovGAST1Controller:update() - successfully update GovGAST1 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovGAST1 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govGAST1Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovGAST1Command command = new DeleteGovGAST1Command(govGAST1Id);

    try {
      GovGAST1BusinessDelegate delegate = GovGAST1BusinessDelegate.getGovGAST1Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovGAST1 with key " + command.getGovGAST1Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save A on GovGAST1
   *
   * @param command AssignAToGovGAST1Command
   */
  @PutMapping("/assignA")
  public void assignA(@RequestBody AssignAToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignA(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A", exc);
    }
  }

  /**
   * unassign A on GovGAST1
   *
   * @param command UnAssignAFromGovGAST1Command
   */
  @PutMapping("/unAssignA")
  public void unAssignA(@RequestBody(required = true) UnAssignAFromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignA(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A", exc);
    }
  }

  /**
   * save B on GovGAST1
   *
   * @param command AssignBToGovGAST1Command
   */
  @PutMapping("/assignB")
  public void assignB(@RequestBody AssignBToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignB(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign B", exc);
    }
  }

  /**
   * unassign B on GovGAST1
   *
   * @param command UnAssignBFromGovGAST1Command
   */
  @PutMapping("/unAssignB")
  public void unAssignB(@RequestBody(required = true) UnAssignBFromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignB(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign B", exc);
    }
  }

  /**
   * save Db1 on GovGAST1
   *
   * @param command AssignDb1ToGovGAST1Command
   */
  @PutMapping("/assignDb1")
  public void assignDb1(@RequestBody AssignDb1ToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignDb1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db1", exc);
    }
  }

  /**
   * unassign Db1 on GovGAST1
   *
   * @param command UnAssignDb1FromGovGAST1Command
   */
  @PutMapping("/unAssignDb1")
  public void unAssignDb1(@RequestBody(required = true) UnAssignDb1FromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignDb1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db1", exc);
    }
  }

  /**
   * save Db2 on GovGAST1
   *
   * @param command AssignDb2ToGovGAST1Command
   */
  @PutMapping("/assignDb2")
  public void assignDb2(@RequestBody AssignDb2ToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignDb2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db2", exc);
    }
  }

  /**
   * unassign Db2 on GovGAST1
   *
   * @param command UnAssignDb2FromGovGAST1Command
   */
  @PutMapping("/unAssignDb2")
  public void unAssignDb2(@RequestBody(required = true) UnAssignDb2FromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignDb2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db2", exc);
    }
  }

  /**
   * save Eps on GovGAST1
   *
   * @param command AssignEpsToGovGAST1Command
   */
  @PutMapping("/assignEps")
  public void assignEps(@RequestBody AssignEpsToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignEps(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Eps", exc);
    }
  }

  /**
   * unassign Eps on GovGAST1
   *
   * @param command UnAssignEpsFromGovGAST1Command
   */
  @PutMapping("/unAssignEps")
  public void unAssignEps(@RequestBody(required = true) UnAssignEpsFromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignEps(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Eps", exc);
    }
  }

  /**
   * save Fidle on GovGAST1
   *
   * @param command AssignFidleToGovGAST1Command
   */
  @PutMapping("/assignFidle")
  public void assignFidle(@RequestBody AssignFidleToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignFidle(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Fidle", exc);
    }
  }

  /**
   * unassign Fidle on GovGAST1
   *
   * @param command UnAssignFidleFromGovGAST1Command
   */
  @PutMapping("/unAssignFidle")
  public void unAssignFidle(
      @RequestBody(required = true) UnAssignFidleFromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignFidle(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Fidle", exc);
    }
  }

  /**
   * save Gv1 on GovGAST1
   *
   * @param command AssignGv1ToGovGAST1Command
   */
  @PutMapping("/assignGv1")
  public void assignGv1(@RequestBody AssignGv1ToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignGv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv1", exc);
    }
  }

  /**
   * unassign Gv1 on GovGAST1
   *
   * @param command UnAssignGv1FromGovGAST1Command
   */
  @PutMapping("/unAssignGv1")
  public void unAssignGv1(@RequestBody(required = true) UnAssignGv1FromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignGv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv1", exc);
    }
  }

  /**
   * save Gv2 on GovGAST1
   *
   * @param command AssignGv2ToGovGAST1Command
   */
  @PutMapping("/assignGv2")
  public void assignGv2(@RequestBody AssignGv2ToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignGv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv2", exc);
    }
  }

  /**
   * unassign Gv2 on GovGAST1
   *
   * @param command UnAssignGv2FromGovGAST1Command
   */
  @PutMapping("/unAssignGv2")
  public void unAssignGv2(@RequestBody(required = true) UnAssignGv2FromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignGv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv2", exc);
    }
  }

  /**
   * save Gv3 on GovGAST1
   *
   * @param command AssignGv3ToGovGAST1Command
   */
  @PutMapping("/assignGv3")
  public void assignGv3(@RequestBody AssignGv3ToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignGv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv3", exc);
    }
  }

  /**
   * unassign Gv3 on GovGAST1
   *
   * @param command UnAssignGv3FromGovGAST1Command
   */
  @PutMapping("/unAssignGv3")
  public void unAssignGv3(@RequestBody(required = true) UnAssignGv3FromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignGv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv3", exc);
    }
  }

  /**
   * save Gv4 on GovGAST1
   *
   * @param command AssignGv4ToGovGAST1Command
   */
  @PutMapping("/assignGv4")
  public void assignGv4(@RequestBody AssignGv4ToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignGv4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv4", exc);
    }
  }

  /**
   * unassign Gv4 on GovGAST1
   *
   * @param command UnAssignGv4FromGovGAST1Command
   */
  @PutMapping("/unAssignGv4")
  public void unAssignGv4(@RequestBody(required = true) UnAssignGv4FromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignGv4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv4", exc);
    }
  }

  /**
   * save Gv5 on GovGAST1
   *
   * @param command AssignGv5ToGovGAST1Command
   */
  @PutMapping("/assignGv5")
  public void assignGv5(@RequestBody AssignGv5ToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignGv5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv5", exc);
    }
  }

  /**
   * unassign Gv5 on GovGAST1
   *
   * @param command UnAssignGv5FromGovGAST1Command
   */
  @PutMapping("/unAssignGv5")
  public void unAssignGv5(@RequestBody(required = true) UnAssignGv5FromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignGv5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv5", exc);
    }
  }

  /**
   * save Gv6 on GovGAST1
   *
   * @param command AssignGv6ToGovGAST1Command
   */
  @PutMapping("/assignGv6")
  public void assignGv6(@RequestBody AssignGv6ToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignGv6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv6", exc);
    }
  }

  /**
   * unassign Gv6 on GovGAST1
   *
   * @param command UnAssignGv6FromGovGAST1Command
   */
  @PutMapping("/unAssignGv6")
  public void unAssignGv6(@RequestBody(required = true) UnAssignGv6FromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignGv6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv6", exc);
    }
  }

  /**
   * save Ka on GovGAST1
   *
   * @param command AssignKaToGovGAST1Command
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on GovGAST1
   *
   * @param command UnAssignKaFromGovGAST1Command
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kt on GovGAST1
   *
   * @param command AssignKtToGovGAST1Command
   */
  @PutMapping("/assignKt")
  public void assignKt(@RequestBody AssignKtToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignKt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kt", exc);
    }
  }

  /**
   * unassign Kt on GovGAST1
   *
   * @param command UnAssignKtFromGovGAST1Command
   */
  @PutMapping("/unAssignKt")
  public void unAssignKt(@RequestBody(required = true) UnAssignKtFromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignKt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kt", exc);
    }
  }

  /**
   * save Lmax on GovGAST1
   *
   * @param command AssignLmaxToGovGAST1Command
   */
  @PutMapping("/assignLmax")
  public void assignLmax(@RequestBody AssignLmaxToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignLmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Lmax", exc);
    }
  }

  /**
   * unassign Lmax on GovGAST1
   *
   * @param command UnAssignLmaxFromGovGAST1Command
   */
  @PutMapping("/unAssignLmax")
  public void unAssignLmax(@RequestBody(required = true) UnAssignLmaxFromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignLmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Lmax", exc);
    }
  }

  /**
   * save Loadinc on GovGAST1
   *
   * @param command AssignLoadincToGovGAST1Command
   */
  @PutMapping("/assignLoadinc")
  public void assignLoadinc(@RequestBody AssignLoadincToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignLoadinc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Loadinc", exc);
    }
  }

  /**
   * unassign Loadinc on GovGAST1
   *
   * @param command UnAssignLoadincFromGovGAST1Command
   */
  @PutMapping("/unAssignLoadinc")
  public void unAssignLoadinc(
      @RequestBody(required = true) UnAssignLoadincFromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignLoadinc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Loadinc", exc);
    }
  }

  /**
   * save Ltrate on GovGAST1
   *
   * @param command AssignLtrateToGovGAST1Command
   */
  @PutMapping("/assignLtrate")
  public void assignLtrate(@RequestBody AssignLtrateToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignLtrate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ltrate", exc);
    }
  }

  /**
   * unassign Ltrate on GovGAST1
   *
   * @param command UnAssignLtrateFromGovGAST1Command
   */
  @PutMapping("/unAssignLtrate")
  public void unAssignLtrate(
      @RequestBody(required = true) UnAssignLtrateFromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignLtrate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ltrate", exc);
    }
  }

  /**
   * save Mwbase on GovGAST1
   *
   * @param command AssignMwbaseToGovGAST1Command
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovGAST1
   *
   * @param command UnAssignMwbaseFromGovGAST1Command
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save Pgv1 on GovGAST1
   *
   * @param command AssignPgv1ToGovGAST1Command
   */
  @PutMapping("/assignPgv1")
  public void assignPgv1(@RequestBody AssignPgv1ToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignPgv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv1", exc);
    }
  }

  /**
   * unassign Pgv1 on GovGAST1
   *
   * @param command UnAssignPgv1FromGovGAST1Command
   */
  @PutMapping("/unAssignPgv1")
  public void unAssignPgv1(@RequestBody(required = true) UnAssignPgv1FromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignPgv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv1", exc);
    }
  }

  /**
   * save Pgv2 on GovGAST1
   *
   * @param command AssignPgv2ToGovGAST1Command
   */
  @PutMapping("/assignPgv2")
  public void assignPgv2(@RequestBody AssignPgv2ToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignPgv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv2", exc);
    }
  }

  /**
   * unassign Pgv2 on GovGAST1
   *
   * @param command UnAssignPgv2FromGovGAST1Command
   */
  @PutMapping("/unAssignPgv2")
  public void unAssignPgv2(@RequestBody(required = true) UnAssignPgv2FromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignPgv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv2", exc);
    }
  }

  /**
   * save Pgv3 on GovGAST1
   *
   * @param command AssignPgv3ToGovGAST1Command
   */
  @PutMapping("/assignPgv3")
  public void assignPgv3(@RequestBody AssignPgv3ToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignPgv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv3", exc);
    }
  }

  /**
   * unassign Pgv3 on GovGAST1
   *
   * @param command UnAssignPgv3FromGovGAST1Command
   */
  @PutMapping("/unAssignPgv3")
  public void unAssignPgv3(@RequestBody(required = true) UnAssignPgv3FromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignPgv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv3", exc);
    }
  }

  /**
   * save Pgv4 on GovGAST1
   *
   * @param command AssignPgv4ToGovGAST1Command
   */
  @PutMapping("/assignPgv4")
  public void assignPgv4(@RequestBody AssignPgv4ToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignPgv4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv4", exc);
    }
  }

  /**
   * unassign Pgv4 on GovGAST1
   *
   * @param command UnAssignPgv4FromGovGAST1Command
   */
  @PutMapping("/unAssignPgv4")
  public void unAssignPgv4(@RequestBody(required = true) UnAssignPgv4FromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignPgv4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv4", exc);
    }
  }

  /**
   * save Pgv5 on GovGAST1
   *
   * @param command AssignPgv5ToGovGAST1Command
   */
  @PutMapping("/assignPgv5")
  public void assignPgv5(@RequestBody AssignPgv5ToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignPgv5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv5", exc);
    }
  }

  /**
   * unassign Pgv5 on GovGAST1
   *
   * @param command UnAssignPgv5FromGovGAST1Command
   */
  @PutMapping("/unAssignPgv5")
  public void unAssignPgv5(@RequestBody(required = true) UnAssignPgv5FromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignPgv5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv5", exc);
    }
  }

  /**
   * save Pgv6 on GovGAST1
   *
   * @param command AssignPgv6ToGovGAST1Command
   */
  @PutMapping("/assignPgv6")
  public void assignPgv6(@RequestBody AssignPgv6ToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignPgv6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv6", exc);
    }
  }

  /**
   * unassign Pgv6 on GovGAST1
   *
   * @param command UnAssignPgv6FromGovGAST1Command
   */
  @PutMapping("/unAssignPgv6")
  public void unAssignPgv6(@RequestBody(required = true) UnAssignPgv6FromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignPgv6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv6", exc);
    }
  }

  /**
   * save R on GovGAST1
   *
   * @param command AssignRToGovGAST1Command
   */
  @PutMapping("/assignR")
  public void assignR(@RequestBody AssignRToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignR(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R", exc);
    }
  }

  /**
   * unassign R on GovGAST1
   *
   * @param command UnAssignRFromGovGAST1Command
   */
  @PutMapping("/unAssignR")
  public void unAssignR(@RequestBody(required = true) UnAssignRFromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignR(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R", exc);
    }
  }

  /**
   * save Rmax on GovGAST1
   *
   * @param command AssignRmaxToGovGAST1Command
   */
  @PutMapping("/assignRmax")
  public void assignRmax(@RequestBody AssignRmaxToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignRmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rmax", exc);
    }
  }

  /**
   * unassign Rmax on GovGAST1
   *
   * @param command UnAssignRmaxFromGovGAST1Command
   */
  @PutMapping("/unAssignRmax")
  public void unAssignRmax(@RequestBody(required = true) UnAssignRmaxFromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignRmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rmax", exc);
    }
  }

  /**
   * save T1 on GovGAST1
   *
   * @param command AssignT1ToGovGAST1Command
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on GovGAST1
   *
   * @param command UnAssignT1FromGovGAST1Command
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on GovGAST1
   *
   * @param command AssignT2ToGovGAST1Command
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on GovGAST1
   *
   * @param command UnAssignT2FromGovGAST1Command
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on GovGAST1
   *
   * @param command AssignT3ToGovGAST1Command
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on GovGAST1
   *
   * @param command UnAssignT3FromGovGAST1Command
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on GovGAST1
   *
   * @param command AssignT4ToGovGAST1Command
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on GovGAST1
   *
   * @param command UnAssignT4FromGovGAST1Command
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save T5 on GovGAST1
   *
   * @param command AssignT5ToGovGAST1Command
   */
  @PutMapping("/assignT5")
  public void assignT5(@RequestBody AssignT5ToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignT5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T5", exc);
    }
  }

  /**
   * unassign T5 on GovGAST1
   *
   * @param command UnAssignT5FromGovGAST1Command
   */
  @PutMapping("/unAssignT5")
  public void unAssignT5(@RequestBody(required = true) UnAssignT5FromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignT5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T5", exc);
    }
  }

  /**
   * save Tltr on GovGAST1
   *
   * @param command AssignTltrToGovGAST1Command
   */
  @PutMapping("/assignTltr")
  public void assignTltr(@RequestBody AssignTltrToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignTltr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tltr", exc);
    }
  }

  /**
   * unassign Tltr on GovGAST1
   *
   * @param command UnAssignTltrFromGovGAST1Command
   */
  @PutMapping("/unAssignTltr")
  public void unAssignTltr(@RequestBody(required = true) UnAssignTltrFromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignTltr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tltr", exc);
    }
  }

  /**
   * save Vmax on GovGAST1
   *
   * @param command AssignVmaxToGovGAST1Command
   */
  @PutMapping("/assignVmax")
  public void assignVmax(@RequestBody AssignVmaxToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignVmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmax", exc);
    }
  }

  /**
   * unassign Vmax on GovGAST1
   *
   * @param command UnAssignVmaxFromGovGAST1Command
   */
  @PutMapping("/unAssignVmax")
  public void unAssignVmax(@RequestBody(required = true) UnAssignVmaxFromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignVmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmax", exc);
    }
  }

  /**
   * save Vmin on GovGAST1
   *
   * @param command AssignVminToGovGAST1Command
   */
  @PutMapping("/assignVmin")
  public void assignVmin(@RequestBody AssignVminToGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().assignVmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmin", exc);
    }
  }

  /**
   * unassign Vmin on GovGAST1
   *
   * @param command UnAssignVminFromGovGAST1Command
   */
  @PutMapping("/unAssignVmin")
  public void unAssignVmin(@RequestBody(required = true) UnAssignVminFromGovGAST1Command command) {
    try {
      GovGAST1BusinessDelegate.getGovGAST1Instance().unAssignVmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovGAST1 govGAST1 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovGAST1CommandRestController.class.getName());
}
