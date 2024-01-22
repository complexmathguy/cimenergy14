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
 * Implements Spring Controller command CQRS processing for entity GovSteam1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteam1")
public class GovSteam1CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovSteam1. if not key provided, calls create, otherwise calls save
   *
   * @param GovSteam1 govSteam1
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovSteam1Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = GovSteam1BusinessDelegate.getGovSteam1Instance().createGovSteam1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovSteam1. if no key provided, calls create, otherwise calls save
   *
   * @param GovSteam1 govSteam1
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovSteam1Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovSteam1Command
      // -----------------------------------------------
      completableFuture = GovSteam1BusinessDelegate.getGovSteam1Instance().updateGovSteam1(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovSteam1Controller:update() - successfully update GovSteam1 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovSteam1 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govSteam1Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovSteam1Command command = new DeleteGovSteam1Command(govSteam1Id);

    try {
      GovSteam1BusinessDelegate delegate = GovSteam1BusinessDelegate.getGovSteam1Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovSteam1 with key " + command.getGovSteam1Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Db1 on GovSteam1
   *
   * @param command AssignDb1ToGovSteam1Command
   */
  @PutMapping("/assignDb1")
  public void assignDb1(@RequestBody AssignDb1ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignDb1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db1", exc);
    }
  }

  /**
   * unassign Db1 on GovSteam1
   *
   * @param command UnAssignDb1FromGovSteam1Command
   */
  @PutMapping("/unAssignDb1")
  public void unAssignDb1(@RequestBody(required = true) UnAssignDb1FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignDb1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db1", exc);
    }
  }

  /**
   * save Db2 on GovSteam1
   *
   * @param command AssignDb2ToGovSteam1Command
   */
  @PutMapping("/assignDb2")
  public void assignDb2(@RequestBody AssignDb2ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignDb2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db2", exc);
    }
  }

  /**
   * unassign Db2 on GovSteam1
   *
   * @param command UnAssignDb2FromGovSteam1Command
   */
  @PutMapping("/unAssignDb2")
  public void unAssignDb2(@RequestBody(required = true) UnAssignDb2FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignDb2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db2", exc);
    }
  }

  /**
   * save Eps on GovSteam1
   *
   * @param command AssignEpsToGovSteam1Command
   */
  @PutMapping("/assignEps")
  public void assignEps(@RequestBody AssignEpsToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignEps(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Eps", exc);
    }
  }

  /**
   * unassign Eps on GovSteam1
   *
   * @param command UnAssignEpsFromGovSteam1Command
   */
  @PutMapping("/unAssignEps")
  public void unAssignEps(@RequestBody(required = true) UnAssignEpsFromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignEps(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Eps", exc);
    }
  }

  /**
   * save Gv1 on GovSteam1
   *
   * @param command AssignGv1ToGovSteam1Command
   */
  @PutMapping("/assignGv1")
  public void assignGv1(@RequestBody AssignGv1ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignGv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv1", exc);
    }
  }

  /**
   * unassign Gv1 on GovSteam1
   *
   * @param command UnAssignGv1FromGovSteam1Command
   */
  @PutMapping("/unAssignGv1")
  public void unAssignGv1(@RequestBody(required = true) UnAssignGv1FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignGv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv1", exc);
    }
  }

  /**
   * save Gv2 on GovSteam1
   *
   * @param command AssignGv2ToGovSteam1Command
   */
  @PutMapping("/assignGv2")
  public void assignGv2(@RequestBody AssignGv2ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignGv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv2", exc);
    }
  }

  /**
   * unassign Gv2 on GovSteam1
   *
   * @param command UnAssignGv2FromGovSteam1Command
   */
  @PutMapping("/unAssignGv2")
  public void unAssignGv2(@RequestBody(required = true) UnAssignGv2FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignGv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv2", exc);
    }
  }

  /**
   * save Gv3 on GovSteam1
   *
   * @param command AssignGv3ToGovSteam1Command
   */
  @PutMapping("/assignGv3")
  public void assignGv3(@RequestBody AssignGv3ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignGv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv3", exc);
    }
  }

  /**
   * unassign Gv3 on GovSteam1
   *
   * @param command UnAssignGv3FromGovSteam1Command
   */
  @PutMapping("/unAssignGv3")
  public void unAssignGv3(@RequestBody(required = true) UnAssignGv3FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignGv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv3", exc);
    }
  }

  /**
   * save Gv4 on GovSteam1
   *
   * @param command AssignGv4ToGovSteam1Command
   */
  @PutMapping("/assignGv4")
  public void assignGv4(@RequestBody AssignGv4ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignGv4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv4", exc);
    }
  }

  /**
   * unassign Gv4 on GovSteam1
   *
   * @param command UnAssignGv4FromGovSteam1Command
   */
  @PutMapping("/unAssignGv4")
  public void unAssignGv4(@RequestBody(required = true) UnAssignGv4FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignGv4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv4", exc);
    }
  }

  /**
   * save Gv5 on GovSteam1
   *
   * @param command AssignGv5ToGovSteam1Command
   */
  @PutMapping("/assignGv5")
  public void assignGv5(@RequestBody AssignGv5ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignGv5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv5", exc);
    }
  }

  /**
   * unassign Gv5 on GovSteam1
   *
   * @param command UnAssignGv5FromGovSteam1Command
   */
  @PutMapping("/unAssignGv5")
  public void unAssignGv5(@RequestBody(required = true) UnAssignGv5FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignGv5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv5", exc);
    }
  }

  /**
   * save Gv6 on GovSteam1
   *
   * @param command AssignGv6ToGovSteam1Command
   */
  @PutMapping("/assignGv6")
  public void assignGv6(@RequestBody AssignGv6ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignGv6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv6", exc);
    }
  }

  /**
   * unassign Gv6 on GovSteam1
   *
   * @param command UnAssignGv6FromGovSteam1Command
   */
  @PutMapping("/unAssignGv6")
  public void unAssignGv6(@RequestBody(required = true) UnAssignGv6FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignGv6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv6", exc);
    }
  }

  /**
   * save K on GovSteam1
   *
   * @param command AssignKToGovSteam1Command
   */
  @PutMapping("/assignK")
  public void assignK(@RequestBody AssignKToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignK(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K", exc);
    }
  }

  /**
   * unassign K on GovSteam1
   *
   * @param command UnAssignKFromGovSteam1Command
   */
  @PutMapping("/unAssignK")
  public void unAssignK(@RequestBody(required = true) UnAssignKFromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignK(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K", exc);
    }
  }

  /**
   * save K1 on GovSteam1
   *
   * @param command AssignK1ToGovSteam1Command
   */
  @PutMapping("/assignK1")
  public void assignK1(@RequestBody AssignK1ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignK1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K1", exc);
    }
  }

  /**
   * unassign K1 on GovSteam1
   *
   * @param command UnAssignK1FromGovSteam1Command
   */
  @PutMapping("/unAssignK1")
  public void unAssignK1(@RequestBody(required = true) UnAssignK1FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignK1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K1", exc);
    }
  }

  /**
   * save K2 on GovSteam1
   *
   * @param command AssignK2ToGovSteam1Command
   */
  @PutMapping("/assignK2")
  public void assignK2(@RequestBody AssignK2ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignK2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K2", exc);
    }
  }

  /**
   * unassign K2 on GovSteam1
   *
   * @param command UnAssignK2FromGovSteam1Command
   */
  @PutMapping("/unAssignK2")
  public void unAssignK2(@RequestBody(required = true) UnAssignK2FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignK2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K2", exc);
    }
  }

  /**
   * save K3 on GovSteam1
   *
   * @param command AssignK3ToGovSteam1Command
   */
  @PutMapping("/assignK3")
  public void assignK3(@RequestBody AssignK3ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignK3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K3", exc);
    }
  }

  /**
   * unassign K3 on GovSteam1
   *
   * @param command UnAssignK3FromGovSteam1Command
   */
  @PutMapping("/unAssignK3")
  public void unAssignK3(@RequestBody(required = true) UnAssignK3FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignK3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K3", exc);
    }
  }

  /**
   * save K4 on GovSteam1
   *
   * @param command AssignK4ToGovSteam1Command
   */
  @PutMapping("/assignK4")
  public void assignK4(@RequestBody AssignK4ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignK4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K4", exc);
    }
  }

  /**
   * unassign K4 on GovSteam1
   *
   * @param command UnAssignK4FromGovSteam1Command
   */
  @PutMapping("/unAssignK4")
  public void unAssignK4(@RequestBody(required = true) UnAssignK4FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignK4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K4", exc);
    }
  }

  /**
   * save K5 on GovSteam1
   *
   * @param command AssignK5ToGovSteam1Command
   */
  @PutMapping("/assignK5")
  public void assignK5(@RequestBody AssignK5ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignK5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K5", exc);
    }
  }

  /**
   * unassign K5 on GovSteam1
   *
   * @param command UnAssignK5FromGovSteam1Command
   */
  @PutMapping("/unAssignK5")
  public void unAssignK5(@RequestBody(required = true) UnAssignK5FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignK5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K5", exc);
    }
  }

  /**
   * save K6 on GovSteam1
   *
   * @param command AssignK6ToGovSteam1Command
   */
  @PutMapping("/assignK6")
  public void assignK6(@RequestBody AssignK6ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignK6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K6", exc);
    }
  }

  /**
   * unassign K6 on GovSteam1
   *
   * @param command UnAssignK6FromGovSteam1Command
   */
  @PutMapping("/unAssignK6")
  public void unAssignK6(@RequestBody(required = true) UnAssignK6FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignK6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K6", exc);
    }
  }

  /**
   * save K7 on GovSteam1
   *
   * @param command AssignK7ToGovSteam1Command
   */
  @PutMapping("/assignK7")
  public void assignK7(@RequestBody AssignK7ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignK7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K7", exc);
    }
  }

  /**
   * unassign K7 on GovSteam1
   *
   * @param command UnAssignK7FromGovSteam1Command
   */
  @PutMapping("/unAssignK7")
  public void unAssignK7(@RequestBody(required = true) UnAssignK7FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignK7(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K7", exc);
    }
  }

  /**
   * save K8 on GovSteam1
   *
   * @param command AssignK8ToGovSteam1Command
   */
  @PutMapping("/assignK8")
  public void assignK8(@RequestBody AssignK8ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignK8(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K8", exc);
    }
  }

  /**
   * unassign K8 on GovSteam1
   *
   * @param command UnAssignK8FromGovSteam1Command
   */
  @PutMapping("/unAssignK8")
  public void unAssignK8(@RequestBody(required = true) UnAssignK8FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignK8(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K8", exc);
    }
  }

  /**
   * save Mwbase on GovSteam1
   *
   * @param command AssignMwbaseToGovSteam1Command
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovSteam1
   *
   * @param command UnAssignMwbaseFromGovSteam1Command
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save Pgv1 on GovSteam1
   *
   * @param command AssignPgv1ToGovSteam1Command
   */
  @PutMapping("/assignPgv1")
  public void assignPgv1(@RequestBody AssignPgv1ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignPgv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv1", exc);
    }
  }

  /**
   * unassign Pgv1 on GovSteam1
   *
   * @param command UnAssignPgv1FromGovSteam1Command
   */
  @PutMapping("/unAssignPgv1")
  public void unAssignPgv1(@RequestBody(required = true) UnAssignPgv1FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignPgv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv1", exc);
    }
  }

  /**
   * save Pgv2 on GovSteam1
   *
   * @param command AssignPgv2ToGovSteam1Command
   */
  @PutMapping("/assignPgv2")
  public void assignPgv2(@RequestBody AssignPgv2ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignPgv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv2", exc);
    }
  }

  /**
   * unassign Pgv2 on GovSteam1
   *
   * @param command UnAssignPgv2FromGovSteam1Command
   */
  @PutMapping("/unAssignPgv2")
  public void unAssignPgv2(@RequestBody(required = true) UnAssignPgv2FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignPgv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv2", exc);
    }
  }

  /**
   * save Pgv3 on GovSteam1
   *
   * @param command AssignPgv3ToGovSteam1Command
   */
  @PutMapping("/assignPgv3")
  public void assignPgv3(@RequestBody AssignPgv3ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignPgv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv3", exc);
    }
  }

  /**
   * unassign Pgv3 on GovSteam1
   *
   * @param command UnAssignPgv3FromGovSteam1Command
   */
  @PutMapping("/unAssignPgv3")
  public void unAssignPgv3(@RequestBody(required = true) UnAssignPgv3FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignPgv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv3", exc);
    }
  }

  /**
   * save Pgv4 on GovSteam1
   *
   * @param command AssignPgv4ToGovSteam1Command
   */
  @PutMapping("/assignPgv4")
  public void assignPgv4(@RequestBody AssignPgv4ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignPgv4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv4", exc);
    }
  }

  /**
   * unassign Pgv4 on GovSteam1
   *
   * @param command UnAssignPgv4FromGovSteam1Command
   */
  @PutMapping("/unAssignPgv4")
  public void unAssignPgv4(@RequestBody(required = true) UnAssignPgv4FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignPgv4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv4", exc);
    }
  }

  /**
   * save Pgv5 on GovSteam1
   *
   * @param command AssignPgv5ToGovSteam1Command
   */
  @PutMapping("/assignPgv5")
  public void assignPgv5(@RequestBody AssignPgv5ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignPgv5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv5", exc);
    }
  }

  /**
   * unassign Pgv5 on GovSteam1
   *
   * @param command UnAssignPgv5FromGovSteam1Command
   */
  @PutMapping("/unAssignPgv5")
  public void unAssignPgv5(@RequestBody(required = true) UnAssignPgv5FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignPgv5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv5", exc);
    }
  }

  /**
   * save Pgv6 on GovSteam1
   *
   * @param command AssignPgv6ToGovSteam1Command
   */
  @PutMapping("/assignPgv6")
  public void assignPgv6(@RequestBody AssignPgv6ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignPgv6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv6", exc);
    }
  }

  /**
   * unassign Pgv6 on GovSteam1
   *
   * @param command UnAssignPgv6FromGovSteam1Command
   */
  @PutMapping("/unAssignPgv6")
  public void unAssignPgv6(@RequestBody(required = true) UnAssignPgv6FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignPgv6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv6", exc);
    }
  }

  /**
   * save Pmax on GovSteam1
   *
   * @param command AssignPmaxToGovSteam1Command
   */
  @PutMapping("/assignPmax")
  public void assignPmax(@RequestBody AssignPmaxToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignPmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmax", exc);
    }
  }

  /**
   * unassign Pmax on GovSteam1
   *
   * @param command UnAssignPmaxFromGovSteam1Command
   */
  @PutMapping("/unAssignPmax")
  public void unAssignPmax(@RequestBody(required = true) UnAssignPmaxFromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignPmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmax", exc);
    }
  }

  /**
   * save Pmin on GovSteam1
   *
   * @param command AssignPminToGovSteam1Command
   */
  @PutMapping("/assignPmin")
  public void assignPmin(@RequestBody AssignPminToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignPmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmin", exc);
    }
  }

  /**
   * unassign Pmin on GovSteam1
   *
   * @param command UnAssignPminFromGovSteam1Command
   */
  @PutMapping("/unAssignPmin")
  public void unAssignPmin(@RequestBody(required = true) UnAssignPminFromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignPmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmin", exc);
    }
  }

  /**
   * save Sdb1 on GovSteam1
   *
   * @param command AssignSdb1ToGovSteam1Command
   */
  @PutMapping("/assignSdb1")
  public void assignSdb1(@RequestBody AssignSdb1ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignSdb1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Sdb1", exc);
    }
  }

  /**
   * unassign Sdb1 on GovSteam1
   *
   * @param command UnAssignSdb1FromGovSteam1Command
   */
  @PutMapping("/unAssignSdb1")
  public void unAssignSdb1(@RequestBody(required = true) UnAssignSdb1FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignSdb1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Sdb1", exc);
    }
  }

  /**
   * save Sdb2 on GovSteam1
   *
   * @param command AssignSdb2ToGovSteam1Command
   */
  @PutMapping("/assignSdb2")
  public void assignSdb2(@RequestBody AssignSdb2ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignSdb2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Sdb2", exc);
    }
  }

  /**
   * unassign Sdb2 on GovSteam1
   *
   * @param command UnAssignSdb2FromGovSteam1Command
   */
  @PutMapping("/unAssignSdb2")
  public void unAssignSdb2(@RequestBody(required = true) UnAssignSdb2FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignSdb2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Sdb2", exc);
    }
  }

  /**
   * save T1 on GovSteam1
   *
   * @param command AssignT1ToGovSteam1Command
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on GovSteam1
   *
   * @param command UnAssignT1FromGovSteam1Command
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on GovSteam1
   *
   * @param command AssignT2ToGovSteam1Command
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on GovSteam1
   *
   * @param command UnAssignT2FromGovSteam1Command
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on GovSteam1
   *
   * @param command AssignT3ToGovSteam1Command
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on GovSteam1
   *
   * @param command UnAssignT3FromGovSteam1Command
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on GovSteam1
   *
   * @param command AssignT4ToGovSteam1Command
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on GovSteam1
   *
   * @param command UnAssignT4FromGovSteam1Command
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save T5 on GovSteam1
   *
   * @param command AssignT5ToGovSteam1Command
   */
  @PutMapping("/assignT5")
  public void assignT5(@RequestBody AssignT5ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignT5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T5", exc);
    }
  }

  /**
   * unassign T5 on GovSteam1
   *
   * @param command UnAssignT5FromGovSteam1Command
   */
  @PutMapping("/unAssignT5")
  public void unAssignT5(@RequestBody(required = true) UnAssignT5FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignT5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T5", exc);
    }
  }

  /**
   * save T6 on GovSteam1
   *
   * @param command AssignT6ToGovSteam1Command
   */
  @PutMapping("/assignT6")
  public void assignT6(@RequestBody AssignT6ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignT6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T6", exc);
    }
  }

  /**
   * unassign T6 on GovSteam1
   *
   * @param command UnAssignT6FromGovSteam1Command
   */
  @PutMapping("/unAssignT6")
  public void unAssignT6(@RequestBody(required = true) UnAssignT6FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignT6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T6", exc);
    }
  }

  /**
   * save T7 on GovSteam1
   *
   * @param command AssignT7ToGovSteam1Command
   */
  @PutMapping("/assignT7")
  public void assignT7(@RequestBody AssignT7ToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignT7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T7", exc);
    }
  }

  /**
   * unassign T7 on GovSteam1
   *
   * @param command UnAssignT7FromGovSteam1Command
   */
  @PutMapping("/unAssignT7")
  public void unAssignT7(@RequestBody(required = true) UnAssignT7FromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignT7(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T7", exc);
    }
  }

  /**
   * save Uc on GovSteam1
   *
   * @param command AssignUcToGovSteam1Command
   */
  @PutMapping("/assignUc")
  public void assignUc(@RequestBody AssignUcToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignUc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uc", exc);
    }
  }

  /**
   * unassign Uc on GovSteam1
   *
   * @param command UnAssignUcFromGovSteam1Command
   */
  @PutMapping("/unAssignUc")
  public void unAssignUc(@RequestBody(required = true) UnAssignUcFromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignUc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uc", exc);
    }
  }

  /**
   * save Uo on GovSteam1
   *
   * @param command AssignUoToGovSteam1Command
   */
  @PutMapping("/assignUo")
  public void assignUo(@RequestBody AssignUoToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignUo(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uo", exc);
    }
  }

  /**
   * unassign Uo on GovSteam1
   *
   * @param command UnAssignUoFromGovSteam1Command
   */
  @PutMapping("/unAssignUo")
  public void unAssignUo(@RequestBody(required = true) UnAssignUoFromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignUo(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uo", exc);
    }
  }

  /**
   * save Valve on GovSteam1
   *
   * @param command AssignValveToGovSteam1Command
   */
  @PutMapping("/assignValve")
  public void assignValve(@RequestBody AssignValveToGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().assignValve(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Valve", exc);
    }
  }

  /**
   * unassign Valve on GovSteam1
   *
   * @param command UnAssignValveFromGovSteam1Command
   */
  @PutMapping("/unAssignValve")
  public void unAssignValve(
      @RequestBody(required = true) UnAssignValveFromGovSteam1Command command) {
    try {
      GovSteam1BusinessDelegate.getGovSteam1Instance().unAssignValve(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Valve", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovSteam1 govSteam1 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovSteam1CommandRestController.class.getName());
}
