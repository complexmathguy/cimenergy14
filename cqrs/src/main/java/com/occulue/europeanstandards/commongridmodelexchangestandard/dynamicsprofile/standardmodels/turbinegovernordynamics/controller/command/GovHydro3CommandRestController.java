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
 * Implements Spring Controller command CQRS processing for entity GovHydro3.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydro3")
public class GovHydro3CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovHydro3. if not key provided, calls create, otherwise calls save
   *
   * @param GovHydro3 govHydro3
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovHydro3Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = GovHydro3BusinessDelegate.getGovHydro3Instance().createGovHydro3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovHydro3. if no key provided, calls create, otherwise calls save
   *
   * @param GovHydro3 govHydro3
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovHydro3Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovHydro3Command
      // -----------------------------------------------
      completableFuture = GovHydro3BusinessDelegate.getGovHydro3Instance().updateGovHydro3(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovHydro3Controller:update() - successfully update GovHydro3 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovHydro3 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govHydro3Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovHydro3Command command = new DeleteGovHydro3Command(govHydro3Id);

    try {
      GovHydro3BusinessDelegate delegate = GovHydro3BusinessDelegate.getGovHydro3Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovHydro3 with key " + command.getGovHydro3Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save At on GovHydro3
   *
   * @param command AssignAtToGovHydro3Command
   */
  @PutMapping("/assignAt")
  public void assignAt(@RequestBody AssignAtToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignAt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign At", exc);
    }
  }

  /**
   * unassign At on GovHydro3
   *
   * @param command UnAssignAtFromGovHydro3Command
   */
  @PutMapping("/unAssignAt")
  public void unAssignAt(@RequestBody(required = true) UnAssignAtFromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignAt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign At", exc);
    }
  }

  /**
   * save Db1 on GovHydro3
   *
   * @param command AssignDb1ToGovHydro3Command
   */
  @PutMapping("/assignDb1")
  public void assignDb1(@RequestBody AssignDb1ToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignDb1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db1", exc);
    }
  }

  /**
   * unassign Db1 on GovHydro3
   *
   * @param command UnAssignDb1FromGovHydro3Command
   */
  @PutMapping("/unAssignDb1")
  public void unAssignDb1(@RequestBody(required = true) UnAssignDb1FromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignDb1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db1", exc);
    }
  }

  /**
   * save Db2 on GovHydro3
   *
   * @param command AssignDb2ToGovHydro3Command
   */
  @PutMapping("/assignDb2")
  public void assignDb2(@RequestBody AssignDb2ToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignDb2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db2", exc);
    }
  }

  /**
   * unassign Db2 on GovHydro3
   *
   * @param command UnAssignDb2FromGovHydro3Command
   */
  @PutMapping("/unAssignDb2")
  public void unAssignDb2(@RequestBody(required = true) UnAssignDb2FromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignDb2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db2", exc);
    }
  }

  /**
   * save Dturb on GovHydro3
   *
   * @param command AssignDturbToGovHydro3Command
   */
  @PutMapping("/assignDturb")
  public void assignDturb(@RequestBody AssignDturbToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignDturb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dturb", exc);
    }
  }

  /**
   * unassign Dturb on GovHydro3
   *
   * @param command UnAssignDturbFromGovHydro3Command
   */
  @PutMapping("/unAssignDturb")
  public void unAssignDturb(
      @RequestBody(required = true) UnAssignDturbFromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignDturb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dturb", exc);
    }
  }

  /**
   * save Eps on GovHydro3
   *
   * @param command AssignEpsToGovHydro3Command
   */
  @PutMapping("/assignEps")
  public void assignEps(@RequestBody AssignEpsToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignEps(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Eps", exc);
    }
  }

  /**
   * unassign Eps on GovHydro3
   *
   * @param command UnAssignEpsFromGovHydro3Command
   */
  @PutMapping("/unAssignEps")
  public void unAssignEps(@RequestBody(required = true) UnAssignEpsFromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignEps(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Eps", exc);
    }
  }

  /**
   * save GovernorControl on GovHydro3
   *
   * @param command AssignGovernorControlToGovHydro3Command
   */
  @PutMapping("/assignGovernorControl")
  public void assignGovernorControl(@RequestBody AssignGovernorControlToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignGovernorControl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign GovernorControl", exc);
    }
  }

  /**
   * unassign GovernorControl on GovHydro3
   *
   * @param command UnAssignGovernorControlFromGovHydro3Command
   */
  @PutMapping("/unAssignGovernorControl")
  public void unAssignGovernorControl(
      @RequestBody(required = true) UnAssignGovernorControlFromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignGovernorControl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign GovernorControl", exc);
    }
  }

  /**
   * save Gv1 on GovHydro3
   *
   * @param command AssignGv1ToGovHydro3Command
   */
  @PutMapping("/assignGv1")
  public void assignGv1(@RequestBody AssignGv1ToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignGv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv1", exc);
    }
  }

  /**
   * unassign Gv1 on GovHydro3
   *
   * @param command UnAssignGv1FromGovHydro3Command
   */
  @PutMapping("/unAssignGv1")
  public void unAssignGv1(@RequestBody(required = true) UnAssignGv1FromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignGv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv1", exc);
    }
  }

  /**
   * save Gv2 on GovHydro3
   *
   * @param command AssignGv2ToGovHydro3Command
   */
  @PutMapping("/assignGv2")
  public void assignGv2(@RequestBody AssignGv2ToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignGv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv2", exc);
    }
  }

  /**
   * unassign Gv2 on GovHydro3
   *
   * @param command UnAssignGv2FromGovHydro3Command
   */
  @PutMapping("/unAssignGv2")
  public void unAssignGv2(@RequestBody(required = true) UnAssignGv2FromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignGv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv2", exc);
    }
  }

  /**
   * save Gv3 on GovHydro3
   *
   * @param command AssignGv3ToGovHydro3Command
   */
  @PutMapping("/assignGv3")
  public void assignGv3(@RequestBody AssignGv3ToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignGv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv3", exc);
    }
  }

  /**
   * unassign Gv3 on GovHydro3
   *
   * @param command UnAssignGv3FromGovHydro3Command
   */
  @PutMapping("/unAssignGv3")
  public void unAssignGv3(@RequestBody(required = true) UnAssignGv3FromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignGv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv3", exc);
    }
  }

  /**
   * save Gv4 on GovHydro3
   *
   * @param command AssignGv4ToGovHydro3Command
   */
  @PutMapping("/assignGv4")
  public void assignGv4(@RequestBody AssignGv4ToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignGv4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv4", exc);
    }
  }

  /**
   * unassign Gv4 on GovHydro3
   *
   * @param command UnAssignGv4FromGovHydro3Command
   */
  @PutMapping("/unAssignGv4")
  public void unAssignGv4(@RequestBody(required = true) UnAssignGv4FromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignGv4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv4", exc);
    }
  }

  /**
   * save Gv5 on GovHydro3
   *
   * @param command AssignGv5ToGovHydro3Command
   */
  @PutMapping("/assignGv5")
  public void assignGv5(@RequestBody AssignGv5ToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignGv5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv5", exc);
    }
  }

  /**
   * unassign Gv5 on GovHydro3
   *
   * @param command UnAssignGv5FromGovHydro3Command
   */
  @PutMapping("/unAssignGv5")
  public void unAssignGv5(@RequestBody(required = true) UnAssignGv5FromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignGv5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv5", exc);
    }
  }

  /**
   * save Gv6 on GovHydro3
   *
   * @param command AssignGv6ToGovHydro3Command
   */
  @PutMapping("/assignGv6")
  public void assignGv6(@RequestBody AssignGv6ToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignGv6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv6", exc);
    }
  }

  /**
   * unassign Gv6 on GovHydro3
   *
   * @param command UnAssignGv6FromGovHydro3Command
   */
  @PutMapping("/unAssignGv6")
  public void unAssignGv6(@RequestBody(required = true) UnAssignGv6FromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignGv6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv6", exc);
    }
  }

  /**
   * save H0 on GovHydro3
   *
   * @param command AssignH0ToGovHydro3Command
   */
  @PutMapping("/assignH0")
  public void assignH0(@RequestBody AssignH0ToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignH0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign H0", exc);
    }
  }

  /**
   * unassign H0 on GovHydro3
   *
   * @param command UnAssignH0FromGovHydro3Command
   */
  @PutMapping("/unAssignH0")
  public void unAssignH0(@RequestBody(required = true) UnAssignH0FromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignH0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign H0", exc);
    }
  }

  /**
   * save K1 on GovHydro3
   *
   * @param command AssignK1ToGovHydro3Command
   */
  @PutMapping("/assignK1")
  public void assignK1(@RequestBody AssignK1ToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignK1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K1", exc);
    }
  }

  /**
   * unassign K1 on GovHydro3
   *
   * @param command UnAssignK1FromGovHydro3Command
   */
  @PutMapping("/unAssignK1")
  public void unAssignK1(@RequestBody(required = true) UnAssignK1FromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignK1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K1", exc);
    }
  }

  /**
   * save K2 on GovHydro3
   *
   * @param command AssignK2ToGovHydro3Command
   */
  @PutMapping("/assignK2")
  public void assignK2(@RequestBody AssignK2ToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignK2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K2", exc);
    }
  }

  /**
   * unassign K2 on GovHydro3
   *
   * @param command UnAssignK2FromGovHydro3Command
   */
  @PutMapping("/unAssignK2")
  public void unAssignK2(@RequestBody(required = true) UnAssignK2FromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignK2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K2", exc);
    }
  }

  /**
   * save Kg on GovHydro3
   *
   * @param command AssignKgToGovHydro3Command
   */
  @PutMapping("/assignKg")
  public void assignKg(@RequestBody AssignKgToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignKg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kg", exc);
    }
  }

  /**
   * unassign Kg on GovHydro3
   *
   * @param command UnAssignKgFromGovHydro3Command
   */
  @PutMapping("/unAssignKg")
  public void unAssignKg(@RequestBody(required = true) UnAssignKgFromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignKg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kg", exc);
    }
  }

  /**
   * save Ki on GovHydro3
   *
   * @param command AssignKiToGovHydro3Command
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on GovHydro3
   *
   * @param command UnAssignKiFromGovHydro3Command
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(@RequestBody(required = true) UnAssignKiFromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Mwbase on GovHydro3
   *
   * @param command AssignMwbaseToGovHydro3Command
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovHydro3
   *
   * @param command UnAssignMwbaseFromGovHydro3Command
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save Pgv1 on GovHydro3
   *
   * @param command AssignPgv1ToGovHydro3Command
   */
  @PutMapping("/assignPgv1")
  public void assignPgv1(@RequestBody AssignPgv1ToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignPgv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv1", exc);
    }
  }

  /**
   * unassign Pgv1 on GovHydro3
   *
   * @param command UnAssignPgv1FromGovHydro3Command
   */
  @PutMapping("/unAssignPgv1")
  public void unAssignPgv1(@RequestBody(required = true) UnAssignPgv1FromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignPgv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv1", exc);
    }
  }

  /**
   * save Pgv2 on GovHydro3
   *
   * @param command AssignPgv2ToGovHydro3Command
   */
  @PutMapping("/assignPgv2")
  public void assignPgv2(@RequestBody AssignPgv2ToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignPgv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv2", exc);
    }
  }

  /**
   * unassign Pgv2 on GovHydro3
   *
   * @param command UnAssignPgv2FromGovHydro3Command
   */
  @PutMapping("/unAssignPgv2")
  public void unAssignPgv2(@RequestBody(required = true) UnAssignPgv2FromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignPgv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv2", exc);
    }
  }

  /**
   * save Pgv3 on GovHydro3
   *
   * @param command AssignPgv3ToGovHydro3Command
   */
  @PutMapping("/assignPgv3")
  public void assignPgv3(@RequestBody AssignPgv3ToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignPgv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv3", exc);
    }
  }

  /**
   * unassign Pgv3 on GovHydro3
   *
   * @param command UnAssignPgv3FromGovHydro3Command
   */
  @PutMapping("/unAssignPgv3")
  public void unAssignPgv3(@RequestBody(required = true) UnAssignPgv3FromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignPgv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv3", exc);
    }
  }

  /**
   * save Pgv4 on GovHydro3
   *
   * @param command AssignPgv4ToGovHydro3Command
   */
  @PutMapping("/assignPgv4")
  public void assignPgv4(@RequestBody AssignPgv4ToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignPgv4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv4", exc);
    }
  }

  /**
   * unassign Pgv4 on GovHydro3
   *
   * @param command UnAssignPgv4FromGovHydro3Command
   */
  @PutMapping("/unAssignPgv4")
  public void unAssignPgv4(@RequestBody(required = true) UnAssignPgv4FromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignPgv4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv4", exc);
    }
  }

  /**
   * save Pgv5 on GovHydro3
   *
   * @param command AssignPgv5ToGovHydro3Command
   */
  @PutMapping("/assignPgv5")
  public void assignPgv5(@RequestBody AssignPgv5ToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignPgv5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv5", exc);
    }
  }

  /**
   * unassign Pgv5 on GovHydro3
   *
   * @param command UnAssignPgv5FromGovHydro3Command
   */
  @PutMapping("/unAssignPgv5")
  public void unAssignPgv5(@RequestBody(required = true) UnAssignPgv5FromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignPgv5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv5", exc);
    }
  }

  /**
   * save Pgv6 on GovHydro3
   *
   * @param command AssignPgv6ToGovHydro3Command
   */
  @PutMapping("/assignPgv6")
  public void assignPgv6(@RequestBody AssignPgv6ToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignPgv6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pgv6", exc);
    }
  }

  /**
   * unassign Pgv6 on GovHydro3
   *
   * @param command UnAssignPgv6FromGovHydro3Command
   */
  @PutMapping("/unAssignPgv6")
  public void unAssignPgv6(@RequestBody(required = true) UnAssignPgv6FromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignPgv6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pgv6", exc);
    }
  }

  /**
   * save Pmax on GovHydro3
   *
   * @param command AssignPmaxToGovHydro3Command
   */
  @PutMapping("/assignPmax")
  public void assignPmax(@RequestBody AssignPmaxToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignPmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmax", exc);
    }
  }

  /**
   * unassign Pmax on GovHydro3
   *
   * @param command UnAssignPmaxFromGovHydro3Command
   */
  @PutMapping("/unAssignPmax")
  public void unAssignPmax(@RequestBody(required = true) UnAssignPmaxFromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignPmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmax", exc);
    }
  }

  /**
   * save Pmin on GovHydro3
   *
   * @param command AssignPminToGovHydro3Command
   */
  @PutMapping("/assignPmin")
  public void assignPmin(@RequestBody AssignPminToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignPmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmin", exc);
    }
  }

  /**
   * unassign Pmin on GovHydro3
   *
   * @param command UnAssignPminFromGovHydro3Command
   */
  @PutMapping("/unAssignPmin")
  public void unAssignPmin(@RequestBody(required = true) UnAssignPminFromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignPmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmin", exc);
    }
  }

  /**
   * save Qnl on GovHydro3
   *
   * @param command AssignQnlToGovHydro3Command
   */
  @PutMapping("/assignQnl")
  public void assignQnl(@RequestBody AssignQnlToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignQnl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Qnl", exc);
    }
  }

  /**
   * unassign Qnl on GovHydro3
   *
   * @param command UnAssignQnlFromGovHydro3Command
   */
  @PutMapping("/unAssignQnl")
  public void unAssignQnl(@RequestBody(required = true) UnAssignQnlFromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignQnl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Qnl", exc);
    }
  }

  /**
   * save Relec on GovHydro3
   *
   * @param command AssignRelecToGovHydro3Command
   */
  @PutMapping("/assignRelec")
  public void assignRelec(@RequestBody AssignRelecToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignRelec(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Relec", exc);
    }
  }

  /**
   * unassign Relec on GovHydro3
   *
   * @param command UnAssignRelecFromGovHydro3Command
   */
  @PutMapping("/unAssignRelec")
  public void unAssignRelec(
      @RequestBody(required = true) UnAssignRelecFromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignRelec(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Relec", exc);
    }
  }

  /**
   * save Rgate on GovHydro3
   *
   * @param command AssignRgateToGovHydro3Command
   */
  @PutMapping("/assignRgate")
  public void assignRgate(@RequestBody AssignRgateToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignRgate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rgate", exc);
    }
  }

  /**
   * unassign Rgate on GovHydro3
   *
   * @param command UnAssignRgateFromGovHydro3Command
   */
  @PutMapping("/unAssignRgate")
  public void unAssignRgate(
      @RequestBody(required = true) UnAssignRgateFromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignRgate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rgate", exc);
    }
  }

  /**
   * save Td on GovHydro3
   *
   * @param command AssignTdToGovHydro3Command
   */
  @PutMapping("/assignTd")
  public void assignTd(@RequestBody AssignTdToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignTd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Td", exc);
    }
  }

  /**
   * unassign Td on GovHydro3
   *
   * @param command UnAssignTdFromGovHydro3Command
   */
  @PutMapping("/unAssignTd")
  public void unAssignTd(@RequestBody(required = true) UnAssignTdFromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignTd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Td", exc);
    }
  }

  /**
   * save Tf on GovHydro3
   *
   * @param command AssignTfToGovHydro3Command
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on GovHydro3
   *
   * @param command UnAssignTfFromGovHydro3Command
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Tp on GovHydro3
   *
   * @param command AssignTpToGovHydro3Command
   */
  @PutMapping("/assignTp")
  public void assignTp(@RequestBody AssignTpToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignTp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tp", exc);
    }
  }

  /**
   * unassign Tp on GovHydro3
   *
   * @param command UnAssignTpFromGovHydro3Command
   */
  @PutMapping("/unAssignTp")
  public void unAssignTp(@RequestBody(required = true) UnAssignTpFromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignTp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tp", exc);
    }
  }

  /**
   * save Tt on GovHydro3
   *
   * @param command AssignTtToGovHydro3Command
   */
  @PutMapping("/assignTt")
  public void assignTt(@RequestBody AssignTtToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignTt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tt", exc);
    }
  }

  /**
   * unassign Tt on GovHydro3
   *
   * @param command UnAssignTtFromGovHydro3Command
   */
  @PutMapping("/unAssignTt")
  public void unAssignTt(@RequestBody(required = true) UnAssignTtFromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignTt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tt", exc);
    }
  }

  /**
   * save Tw on GovHydro3
   *
   * @param command AssignTwToGovHydro3Command
   */
  @PutMapping("/assignTw")
  public void assignTw(@RequestBody AssignTwToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignTw(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw", exc);
    }
  }

  /**
   * unassign Tw on GovHydro3
   *
   * @param command UnAssignTwFromGovHydro3Command
   */
  @PutMapping("/unAssignTw")
  public void unAssignTw(@RequestBody(required = true) UnAssignTwFromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignTw(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw", exc);
    }
  }

  /**
   * save Velcl on GovHydro3
   *
   * @param command AssignVelclToGovHydro3Command
   */
  @PutMapping("/assignVelcl")
  public void assignVelcl(@RequestBody AssignVelclToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignVelcl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Velcl", exc);
    }
  }

  /**
   * unassign Velcl on GovHydro3
   *
   * @param command UnAssignVelclFromGovHydro3Command
   */
  @PutMapping("/unAssignVelcl")
  public void unAssignVelcl(
      @RequestBody(required = true) UnAssignVelclFromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignVelcl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Velcl", exc);
    }
  }

  /**
   * save Velop on GovHydro3
   *
   * @param command AssignVelopToGovHydro3Command
   */
  @PutMapping("/assignVelop")
  public void assignVelop(@RequestBody AssignVelopToGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().assignVelop(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Velop", exc);
    }
  }

  /**
   * unassign Velop on GovHydro3
   *
   * @param command UnAssignVelopFromGovHydro3Command
   */
  @PutMapping("/unAssignVelop")
  public void unAssignVelop(
      @RequestBody(required = true) UnAssignVelopFromGovHydro3Command command) {
    try {
      GovHydro3BusinessDelegate.getGovHydro3Instance().unAssignVelop(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Velop", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovHydro3 govHydro3 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovHydro3CommandRestController.class.getName());
}
