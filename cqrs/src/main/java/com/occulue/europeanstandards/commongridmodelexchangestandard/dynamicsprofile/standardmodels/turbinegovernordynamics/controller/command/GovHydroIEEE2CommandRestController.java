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
 * Implements Spring Controller command CQRS processing for entity GovHydroIEEE2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroIEEE2")
public class GovHydroIEEE2CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovHydroIEEE2. if not key provided, calls create, otherwise calls save
   *
   * @param GovHydroIEEE2 govHydroIEEE2
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovHydroIEEE2Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().createGovHydroIEEE2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovHydroIEEE2. if no key provided, calls create, otherwise calls save
   *
   * @param GovHydroIEEE2 govHydroIEEE2
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovHydroIEEE2Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovHydroIEEE2Command
      // -----------------------------------------------
      completableFuture =
          GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().updateGovHydroIEEE2(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovHydroIEEE2Controller:update() - successfully update GovHydroIEEE2 - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovHydroIEEE2 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govHydroIEEE2Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovHydroIEEE2Command command = new DeleteGovHydroIEEE2Command(govHydroIEEE2Id);

    try {
      GovHydroIEEE2BusinessDelegate delegate =
          GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted GovHydroIEEE2 with key " + command.getGovHydroIEEE2Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Aturb on GovHydroIEEE2
   *
   * @param command AssignAturbToGovHydroIEEE2Command
   */
  @PutMapping("/assignAturb")
  public void assignAturb(@RequestBody AssignAturbToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignAturb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Aturb", exc);
    }
  }

  /**
   * unassign Aturb on GovHydroIEEE2
   *
   * @param command UnAssignAturbFromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignAturb")
  public void unAssignAturb(
      @RequestBody(required = true) UnAssignAturbFromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignAturb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Aturb", exc);
    }
  }

  /**
   * save Bturb on GovHydroIEEE2
   *
   * @param command AssignBturbToGovHydroIEEE2Command
   */
  @PutMapping("/assignBturb")
  public void assignBturb(@RequestBody AssignBturbToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignBturb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bturb", exc);
    }
  }

  /**
   * unassign Bturb on GovHydroIEEE2
   *
   * @param command UnAssignBturbFromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignBturb")
  public void unAssignBturb(
      @RequestBody(required = true) UnAssignBturbFromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignBturb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bturb", exc);
    }
  }

  /**
   * save Gv1 on GovHydroIEEE2
   *
   * @param command AssignGv1ToGovHydroIEEE2Command
   */
  @PutMapping("/assignGv1")
  public void assignGv1(@RequestBody AssignGv1ToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignGv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv1", exc);
    }
  }

  /**
   * unassign Gv1 on GovHydroIEEE2
   *
   * @param command UnAssignGv1FromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignGv1")
  public void unAssignGv1(
      @RequestBody(required = true) UnAssignGv1FromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignGv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv1", exc);
    }
  }

  /**
   * save Gv2 on GovHydroIEEE2
   *
   * @param command AssignGv2ToGovHydroIEEE2Command
   */
  @PutMapping("/assignGv2")
  public void assignGv2(@RequestBody AssignGv2ToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignGv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv2", exc);
    }
  }

  /**
   * unassign Gv2 on GovHydroIEEE2
   *
   * @param command UnAssignGv2FromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignGv2")
  public void unAssignGv2(
      @RequestBody(required = true) UnAssignGv2FromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignGv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv2", exc);
    }
  }

  /**
   * save Gv3 on GovHydroIEEE2
   *
   * @param command AssignGv3ToGovHydroIEEE2Command
   */
  @PutMapping("/assignGv3")
  public void assignGv3(@RequestBody AssignGv3ToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignGv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv3", exc);
    }
  }

  /**
   * unassign Gv3 on GovHydroIEEE2
   *
   * @param command UnAssignGv3FromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignGv3")
  public void unAssignGv3(
      @RequestBody(required = true) UnAssignGv3FromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignGv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv3", exc);
    }
  }

  /**
   * save Gv4 on GovHydroIEEE2
   *
   * @param command AssignGv4ToGovHydroIEEE2Command
   */
  @PutMapping("/assignGv4")
  public void assignGv4(@RequestBody AssignGv4ToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignGv4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv4", exc);
    }
  }

  /**
   * unassign Gv4 on GovHydroIEEE2
   *
   * @param command UnAssignGv4FromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignGv4")
  public void unAssignGv4(
      @RequestBody(required = true) UnAssignGv4FromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignGv4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv4", exc);
    }
  }

  /**
   * save Gv5 on GovHydroIEEE2
   *
   * @param command AssignGv5ToGovHydroIEEE2Command
   */
  @PutMapping("/assignGv5")
  public void assignGv5(@RequestBody AssignGv5ToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignGv5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv5", exc);
    }
  }

  /**
   * unassign Gv5 on GovHydroIEEE2
   *
   * @param command UnAssignGv5FromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignGv5")
  public void unAssignGv5(
      @RequestBody(required = true) UnAssignGv5FromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignGv5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv5", exc);
    }
  }

  /**
   * save Gv6 on GovHydroIEEE2
   *
   * @param command AssignGv6ToGovHydroIEEE2Command
   */
  @PutMapping("/assignGv6")
  public void assignGv6(@RequestBody AssignGv6ToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignGv6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv6", exc);
    }
  }

  /**
   * unassign Gv6 on GovHydroIEEE2
   *
   * @param command UnAssignGv6FromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignGv6")
  public void unAssignGv6(
      @RequestBody(required = true) UnAssignGv6FromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignGv6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv6", exc);
    }
  }

  /**
   * save Kturb on GovHydroIEEE2
   *
   * @param command AssignKturbToGovHydroIEEE2Command
   */
  @PutMapping("/assignKturb")
  public void assignKturb(@RequestBody AssignKturbToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignKturb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kturb", exc);
    }
  }

  /**
   * unassign Kturb on GovHydroIEEE2
   *
   * @param command UnAssignKturbFromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignKturb")
  public void unAssignKturb(
      @RequestBody(required = true) UnAssignKturbFromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignKturb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kturb", exc);
    }
  }

  /**
   * save Mwbase on GovHydroIEEE2
   *
   * @param command AssignMwbaseToGovHydroIEEE2Command
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovHydroIEEE2
   *
   * @param command UnAssignMwbaseFromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save Pgv1 on GovHydroIEEE2
   *
   * @param command AssignPgv1ToGovHydroIEEE2Command
   */
  @PutMapping("/assignPgv1")
  public void assignPgv1(@RequestBody AssignPgv1ToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignPgv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv1", exc);
    }
  }

  /**
   * unassign Pgv1 on GovHydroIEEE2
   *
   * @param command UnAssignPgv1FromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignPgv1")
  public void unAssignPgv1(
      @RequestBody(required = true) UnAssignPgv1FromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignPgv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv1", exc);
    }
  }

  /**
   * save Pgv2 on GovHydroIEEE2
   *
   * @param command AssignPgv2ToGovHydroIEEE2Command
   */
  @PutMapping("/assignPgv2")
  public void assignPgv2(@RequestBody AssignPgv2ToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignPgv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv2", exc);
    }
  }

  /**
   * unassign Pgv2 on GovHydroIEEE2
   *
   * @param command UnAssignPgv2FromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignPgv2")
  public void unAssignPgv2(
      @RequestBody(required = true) UnAssignPgv2FromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignPgv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv2", exc);
    }
  }

  /**
   * save Pgv3 on GovHydroIEEE2
   *
   * @param command AssignPgv3ToGovHydroIEEE2Command
   */
  @PutMapping("/assignPgv3")
  public void assignPgv3(@RequestBody AssignPgv3ToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignPgv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv3", exc);
    }
  }

  /**
   * unassign Pgv3 on GovHydroIEEE2
   *
   * @param command UnAssignPgv3FromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignPgv3")
  public void unAssignPgv3(
      @RequestBody(required = true) UnAssignPgv3FromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignPgv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv3", exc);
    }
  }

  /**
   * save Pgv4 on GovHydroIEEE2
   *
   * @param command AssignPgv4ToGovHydroIEEE2Command
   */
  @PutMapping("/assignPgv4")
  public void assignPgv4(@RequestBody AssignPgv4ToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignPgv4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv4", exc);
    }
  }

  /**
   * unassign Pgv4 on GovHydroIEEE2
   *
   * @param command UnAssignPgv4FromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignPgv4")
  public void unAssignPgv4(
      @RequestBody(required = true) UnAssignPgv4FromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignPgv4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv4", exc);
    }
  }

  /**
   * save Pgv5 on GovHydroIEEE2
   *
   * @param command AssignPgv5ToGovHydroIEEE2Command
   */
  @PutMapping("/assignPgv5")
  public void assignPgv5(@RequestBody AssignPgv5ToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignPgv5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv5", exc);
    }
  }

  /**
   * unassign Pgv5 on GovHydroIEEE2
   *
   * @param command UnAssignPgv5FromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignPgv5")
  public void unAssignPgv5(
      @RequestBody(required = true) UnAssignPgv5FromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignPgv5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv5", exc);
    }
  }

  /**
   * save Pgv6 on GovHydroIEEE2
   *
   * @param command AssignPgv6ToGovHydroIEEE2Command
   */
  @PutMapping("/assignPgv6")
  public void assignPgv6(@RequestBody AssignPgv6ToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignPgv6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv6", exc);
    }
  }

  /**
   * unassign Pgv6 on GovHydroIEEE2
   *
   * @param command UnAssignPgv6FromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignPgv6")
  public void unAssignPgv6(
      @RequestBody(required = true) UnAssignPgv6FromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignPgv6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv6", exc);
    }
  }

  /**
   * save Pmax on GovHydroIEEE2
   *
   * @param command AssignPmaxToGovHydroIEEE2Command
   */
  @PutMapping("/assignPmax")
  public void assignPmax(@RequestBody AssignPmaxToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignPmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmax", exc);
    }
  }

  /**
   * unassign Pmax on GovHydroIEEE2
   *
   * @param command UnAssignPmaxFromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignPmax")
  public void unAssignPmax(
      @RequestBody(required = true) UnAssignPmaxFromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignPmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmax", exc);
    }
  }

  /**
   * save Pmin on GovHydroIEEE2
   *
   * @param command AssignPminToGovHydroIEEE2Command
   */
  @PutMapping("/assignPmin")
  public void assignPmin(@RequestBody AssignPminToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignPmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmin", exc);
    }
  }

  /**
   * unassign Pmin on GovHydroIEEE2
   *
   * @param command UnAssignPminFromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignPmin")
  public void unAssignPmin(
      @RequestBody(required = true) UnAssignPminFromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignPmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmin", exc);
    }
  }

  /**
   * save Rperm on GovHydroIEEE2
   *
   * @param command AssignRpermToGovHydroIEEE2Command
   */
  @PutMapping("/assignRperm")
  public void assignRperm(@RequestBody AssignRpermToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignRperm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rperm", exc);
    }
  }

  /**
   * unassign Rperm on GovHydroIEEE2
   *
   * @param command UnAssignRpermFromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignRperm")
  public void unAssignRperm(
      @RequestBody(required = true) UnAssignRpermFromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignRperm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rperm", exc);
    }
  }

  /**
   * save Rtemp on GovHydroIEEE2
   *
   * @param command AssignRtempToGovHydroIEEE2Command
   */
  @PutMapping("/assignRtemp")
  public void assignRtemp(@RequestBody AssignRtempToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignRtemp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rtemp", exc);
    }
  }

  /**
   * unassign Rtemp on GovHydroIEEE2
   *
   * @param command UnAssignRtempFromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignRtemp")
  public void unAssignRtemp(
      @RequestBody(required = true) UnAssignRtempFromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignRtemp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rtemp", exc);
    }
  }

  /**
   * save Tg on GovHydroIEEE2
   *
   * @param command AssignTgToGovHydroIEEE2Command
   */
  @PutMapping("/assignTg")
  public void assignTg(@RequestBody AssignTgToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignTg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tg", exc);
    }
  }

  /**
   * unassign Tg on GovHydroIEEE2
   *
   * @param command UnAssignTgFromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignTg")
  public void unAssignTg(@RequestBody(required = true) UnAssignTgFromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignTg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tg", exc);
    }
  }

  /**
   * save Tp on GovHydroIEEE2
   *
   * @param command AssignTpToGovHydroIEEE2Command
   */
  @PutMapping("/assignTp")
  public void assignTp(@RequestBody AssignTpToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignTp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tp", exc);
    }
  }

  /**
   * unassign Tp on GovHydroIEEE2
   *
   * @param command UnAssignTpFromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignTp")
  public void unAssignTp(@RequestBody(required = true) UnAssignTpFromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignTp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tp", exc);
    }
  }

  /**
   * save Tr on GovHydroIEEE2
   *
   * @param command AssignTrToGovHydroIEEE2Command
   */
  @PutMapping("/assignTr")
  public void assignTr(@RequestBody AssignTrToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignTr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tr", exc);
    }
  }

  /**
   * unassign Tr on GovHydroIEEE2
   *
   * @param command UnAssignTrFromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignTr")
  public void unAssignTr(@RequestBody(required = true) UnAssignTrFromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignTr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tr", exc);
    }
  }

  /**
   * save Tw on GovHydroIEEE2
   *
   * @param command AssignTwToGovHydroIEEE2Command
   */
  @PutMapping("/assignTw")
  public void assignTw(@RequestBody AssignTwToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignTw(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw", exc);
    }
  }

  /**
   * unassign Tw on GovHydroIEEE2
   *
   * @param command UnAssignTwFromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignTw")
  public void unAssignTw(@RequestBody(required = true) UnAssignTwFromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignTw(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw", exc);
    }
  }

  /**
   * save Uc on GovHydroIEEE2
   *
   * @param command AssignUcToGovHydroIEEE2Command
   */
  @PutMapping("/assignUc")
  public void assignUc(@RequestBody AssignUcToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignUc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uc", exc);
    }
  }

  /**
   * unassign Uc on GovHydroIEEE2
   *
   * @param command UnAssignUcFromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignUc")
  public void unAssignUc(@RequestBody(required = true) UnAssignUcFromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignUc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uc", exc);
    }
  }

  /**
   * save Uo on GovHydroIEEE2
   *
   * @param command AssignUoToGovHydroIEEE2Command
   */
  @PutMapping("/assignUo")
  public void assignUo(@RequestBody AssignUoToGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().assignUo(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uo", exc);
    }
  }

  /**
   * unassign Uo on GovHydroIEEE2
   *
   * @param command UnAssignUoFromGovHydroIEEE2Command
   */
  @PutMapping("/unAssignUo")
  public void unAssignUo(@RequestBody(required = true) UnAssignUoFromGovHydroIEEE2Command command) {
    try {
      GovHydroIEEE2BusinessDelegate.getGovHydroIEEE2Instance().unAssignUo(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uo", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovHydroIEEE2 govHydroIEEE2 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovHydroIEEE2CommandRestController.class.getName());
}
