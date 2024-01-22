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
 * Implements Spring Controller command CQRS processing for entity GovCT1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovCT1")
public class GovCT1CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovCT1. if not key provided, calls create, otherwise calls save
   *
   * @param GovCT1 govCT1
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreateGovCT1Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = GovCT1BusinessDelegate.getGovCT1Instance().createGovCT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovCT1. if no key provided, calls create, otherwise calls save
   *
   * @param GovCT1 govCT1
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdateGovCT1Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovCT1Command
      // -----------------------------------------------
      completableFuture = GovCT1BusinessDelegate.getGovCT1Instance().updateGovCT1(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovCT1Controller:update() - successfully update GovCT1 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovCT1 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govCT1Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovCT1Command command = new DeleteGovCT1Command(govCT1Id);

    try {
      GovCT1BusinessDelegate delegate = GovCT1BusinessDelegate.getGovCT1Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted GovCT1 with key " + command.getGovCT1Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Aset on GovCT1
   *
   * @param command AssignAsetToGovCT1Command
   */
  @PutMapping("/assignAset")
  public void assignAset(@RequestBody AssignAsetToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignAset(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Aset", exc);
    }
  }

  /**
   * unassign Aset on GovCT1
   *
   * @param command UnAssignAsetFromGovCT1Command
   */
  @PutMapping("/unAssignAset")
  public void unAssignAset(@RequestBody(required = true) UnAssignAsetFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignAset(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Aset", exc);
    }
  }

  /**
   * save Db on GovCT1
   *
   * @param command AssignDbToGovCT1Command
   */
  @PutMapping("/assignDb")
  public void assignDb(@RequestBody AssignDbToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignDb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db", exc);
    }
  }

  /**
   * unassign Db on GovCT1
   *
   * @param command UnAssignDbFromGovCT1Command
   */
  @PutMapping("/unAssignDb")
  public void unAssignDb(@RequestBody(required = true) UnAssignDbFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignDb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db", exc);
    }
  }

  /**
   * save Dm on GovCT1
   *
   * @param command AssignDmToGovCT1Command
   */
  @PutMapping("/assignDm")
  public void assignDm(@RequestBody AssignDmToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignDm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dm", exc);
    }
  }

  /**
   * unassign Dm on GovCT1
   *
   * @param command UnAssignDmFromGovCT1Command
   */
  @PutMapping("/unAssignDm")
  public void unAssignDm(@RequestBody(required = true) UnAssignDmFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignDm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dm", exc);
    }
  }

  /**
   * save Ka on GovCT1
   *
   * @param command AssignKaToGovCT1Command
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on GovCT1
   *
   * @param command UnAssignKaFromGovCT1Command
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kdgov on GovCT1
   *
   * @param command AssignKdgovToGovCT1Command
   */
  @PutMapping("/assignKdgov")
  public void assignKdgov(@RequestBody AssignKdgovToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignKdgov(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kdgov", exc);
    }
  }

  /**
   * unassign Kdgov on GovCT1
   *
   * @param command UnAssignKdgovFromGovCT1Command
   */
  @PutMapping("/unAssignKdgov")
  public void unAssignKdgov(@RequestBody(required = true) UnAssignKdgovFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignKdgov(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kdgov", exc);
    }
  }

  /**
   * save Kigov on GovCT1
   *
   * @param command AssignKigovToGovCT1Command
   */
  @PutMapping("/assignKigov")
  public void assignKigov(@RequestBody AssignKigovToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignKigov(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kigov", exc);
    }
  }

  /**
   * unassign Kigov on GovCT1
   *
   * @param command UnAssignKigovFromGovCT1Command
   */
  @PutMapping("/unAssignKigov")
  public void unAssignKigov(@RequestBody(required = true) UnAssignKigovFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignKigov(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kigov", exc);
    }
  }

  /**
   * save Kiload on GovCT1
   *
   * @param command AssignKiloadToGovCT1Command
   */
  @PutMapping("/assignKiload")
  public void assignKiload(@RequestBody AssignKiloadToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignKiload(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kiload", exc);
    }
  }

  /**
   * unassign Kiload on GovCT1
   *
   * @param command UnAssignKiloadFromGovCT1Command
   */
  @PutMapping("/unAssignKiload")
  public void unAssignKiload(
      @RequestBody(required = true) UnAssignKiloadFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignKiload(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kiload", exc);
    }
  }

  /**
   * save Kimw on GovCT1
   *
   * @param command AssignKimwToGovCT1Command
   */
  @PutMapping("/assignKimw")
  public void assignKimw(@RequestBody AssignKimwToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignKimw(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kimw", exc);
    }
  }

  /**
   * unassign Kimw on GovCT1
   *
   * @param command UnAssignKimwFromGovCT1Command
   */
  @PutMapping("/unAssignKimw")
  public void unAssignKimw(@RequestBody(required = true) UnAssignKimwFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignKimw(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kimw", exc);
    }
  }

  /**
   * save Kpgov on GovCT1
   *
   * @param command AssignKpgovToGovCT1Command
   */
  @PutMapping("/assignKpgov")
  public void assignKpgov(@RequestBody AssignKpgovToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignKpgov(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpgov", exc);
    }
  }

  /**
   * unassign Kpgov on GovCT1
   *
   * @param command UnAssignKpgovFromGovCT1Command
   */
  @PutMapping("/unAssignKpgov")
  public void unAssignKpgov(@RequestBody(required = true) UnAssignKpgovFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignKpgov(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpgov", exc);
    }
  }

  /**
   * save Kpload on GovCT1
   *
   * @param command AssignKploadToGovCT1Command
   */
  @PutMapping("/assignKpload")
  public void assignKpload(@RequestBody AssignKploadToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignKpload(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpload", exc);
    }
  }

  /**
   * unassign Kpload on GovCT1
   *
   * @param command UnAssignKploadFromGovCT1Command
   */
  @PutMapping("/unAssignKpload")
  public void unAssignKpload(
      @RequestBody(required = true) UnAssignKploadFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignKpload(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpload", exc);
    }
  }

  /**
   * save Kturb on GovCT1
   *
   * @param command AssignKturbToGovCT1Command
   */
  @PutMapping("/assignKturb")
  public void assignKturb(@RequestBody AssignKturbToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignKturb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kturb", exc);
    }
  }

  /**
   * unassign Kturb on GovCT1
   *
   * @param command UnAssignKturbFromGovCT1Command
   */
  @PutMapping("/unAssignKturb")
  public void unAssignKturb(@RequestBody(required = true) UnAssignKturbFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignKturb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kturb", exc);
    }
  }

  /**
   * save Ldref on GovCT1
   *
   * @param command AssignLdrefToGovCT1Command
   */
  @PutMapping("/assignLdref")
  public void assignLdref(@RequestBody AssignLdrefToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignLdref(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ldref", exc);
    }
  }

  /**
   * unassign Ldref on GovCT1
   *
   * @param command UnAssignLdrefFromGovCT1Command
   */
  @PutMapping("/unAssignLdref")
  public void unAssignLdref(@RequestBody(required = true) UnAssignLdrefFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignLdref(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ldref", exc);
    }
  }

  /**
   * save Maxerr on GovCT1
   *
   * @param command AssignMaxerrToGovCT1Command
   */
  @PutMapping("/assignMaxerr")
  public void assignMaxerr(@RequestBody AssignMaxerrToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignMaxerr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Maxerr", exc);
    }
  }

  /**
   * unassign Maxerr on GovCT1
   *
   * @param command UnAssignMaxerrFromGovCT1Command
   */
  @PutMapping("/unAssignMaxerr")
  public void unAssignMaxerr(
      @RequestBody(required = true) UnAssignMaxerrFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignMaxerr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Maxerr", exc);
    }
  }

  /**
   * save Minerr on GovCT1
   *
   * @param command AssignMinerrToGovCT1Command
   */
  @PutMapping("/assignMinerr")
  public void assignMinerr(@RequestBody AssignMinerrToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignMinerr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Minerr", exc);
    }
  }

  /**
   * unassign Minerr on GovCT1
   *
   * @param command UnAssignMinerrFromGovCT1Command
   */
  @PutMapping("/unAssignMinerr")
  public void unAssignMinerr(
      @RequestBody(required = true) UnAssignMinerrFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignMinerr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Minerr", exc);
    }
  }

  /**
   * save Mwbase on GovCT1
   *
   * @param command AssignMwbaseToGovCT1Command
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovCT1
   *
   * @param command UnAssignMwbaseFromGovCT1Command
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save R on GovCT1
   *
   * @param command AssignRToGovCT1Command
   */
  @PutMapping("/assignR")
  public void assignR(@RequestBody AssignRToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignR(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R", exc);
    }
  }

  /**
   * unassign R on GovCT1
   *
   * @param command UnAssignRFromGovCT1Command
   */
  @PutMapping("/unAssignR")
  public void unAssignR(@RequestBody(required = true) UnAssignRFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignR(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R", exc);
    }
  }

  /**
   * save Rclose on GovCT1
   *
   * @param command AssignRcloseToGovCT1Command
   */
  @PutMapping("/assignRclose")
  public void assignRclose(@RequestBody AssignRcloseToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignRclose(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rclose", exc);
    }
  }

  /**
   * unassign Rclose on GovCT1
   *
   * @param command UnAssignRcloseFromGovCT1Command
   */
  @PutMapping("/unAssignRclose")
  public void unAssignRclose(
      @RequestBody(required = true) UnAssignRcloseFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignRclose(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rclose", exc);
    }
  }

  /**
   * save Rdown on GovCT1
   *
   * @param command AssignRdownToGovCT1Command
   */
  @PutMapping("/assignRdown")
  public void assignRdown(@RequestBody AssignRdownToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignRdown(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rdown", exc);
    }
  }

  /**
   * unassign Rdown on GovCT1
   *
   * @param command UnAssignRdownFromGovCT1Command
   */
  @PutMapping("/unAssignRdown")
  public void unAssignRdown(@RequestBody(required = true) UnAssignRdownFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignRdown(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rdown", exc);
    }
  }

  /**
   * save Ropen on GovCT1
   *
   * @param command AssignRopenToGovCT1Command
   */
  @PutMapping("/assignRopen")
  public void assignRopen(@RequestBody AssignRopenToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignRopen(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ropen", exc);
    }
  }

  /**
   * unassign Ropen on GovCT1
   *
   * @param command UnAssignRopenFromGovCT1Command
   */
  @PutMapping("/unAssignRopen")
  public void unAssignRopen(@RequestBody(required = true) UnAssignRopenFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignRopen(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ropen", exc);
    }
  }

  /**
   * save Rup on GovCT1
   *
   * @param command AssignRupToGovCT1Command
   */
  @PutMapping("/assignRup")
  public void assignRup(@RequestBody AssignRupToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignRup(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rup", exc);
    }
  }

  /**
   * unassign Rup on GovCT1
   *
   * @param command UnAssignRupFromGovCT1Command
   */
  @PutMapping("/unAssignRup")
  public void unAssignRup(@RequestBody(required = true) UnAssignRupFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignRup(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rup", exc);
    }
  }

  /**
   * save Ta on GovCT1
   *
   * @param command AssignTaToGovCT1Command
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on GovCT1
   *
   * @param command UnAssignTaFromGovCT1Command
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tact on GovCT1
   *
   * @param command AssignTactToGovCT1Command
   */
  @PutMapping("/assignTact")
  public void assignTact(@RequestBody AssignTactToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignTact(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tact", exc);
    }
  }

  /**
   * unassign Tact on GovCT1
   *
   * @param command UnAssignTactFromGovCT1Command
   */
  @PutMapping("/unAssignTact")
  public void unAssignTact(@RequestBody(required = true) UnAssignTactFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignTact(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tact", exc);
    }
  }

  /**
   * save Tb on GovCT1
   *
   * @param command AssignTbToGovCT1Command
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on GovCT1
   *
   * @param command UnAssignTbFromGovCT1Command
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on GovCT1
   *
   * @param command AssignTcToGovCT1Command
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on GovCT1
   *
   * @param command UnAssignTcFromGovCT1Command
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Tdgov on GovCT1
   *
   * @param command AssignTdgovToGovCT1Command
   */
  @PutMapping("/assignTdgov")
  public void assignTdgov(@RequestBody AssignTdgovToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignTdgov(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tdgov", exc);
    }
  }

  /**
   * unassign Tdgov on GovCT1
   *
   * @param command UnAssignTdgovFromGovCT1Command
   */
  @PutMapping("/unAssignTdgov")
  public void unAssignTdgov(@RequestBody(required = true) UnAssignTdgovFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignTdgov(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tdgov", exc);
    }
  }

  /**
   * save Teng on GovCT1
   *
   * @param command AssignTengToGovCT1Command
   */
  @PutMapping("/assignTeng")
  public void assignTeng(@RequestBody AssignTengToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignTeng(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Teng", exc);
    }
  }

  /**
   * unassign Teng on GovCT1
   *
   * @param command UnAssignTengFromGovCT1Command
   */
  @PutMapping("/unAssignTeng")
  public void unAssignTeng(@RequestBody(required = true) UnAssignTengFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignTeng(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Teng", exc);
    }
  }

  /**
   * save Tfload on GovCT1
   *
   * @param command AssignTfloadToGovCT1Command
   */
  @PutMapping("/assignTfload")
  public void assignTfload(@RequestBody AssignTfloadToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignTfload(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tfload", exc);
    }
  }

  /**
   * unassign Tfload on GovCT1
   *
   * @param command UnAssignTfloadFromGovCT1Command
   */
  @PutMapping("/unAssignTfload")
  public void unAssignTfload(
      @RequestBody(required = true) UnAssignTfloadFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignTfload(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tfload", exc);
    }
  }

  /**
   * save Tpelec on GovCT1
   *
   * @param command AssignTpelecToGovCT1Command
   */
  @PutMapping("/assignTpelec")
  public void assignTpelec(@RequestBody AssignTpelecToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignTpelec(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpelec", exc);
    }
  }

  /**
   * unassign Tpelec on GovCT1
   *
   * @param command UnAssignTpelecFromGovCT1Command
   */
  @PutMapping("/unAssignTpelec")
  public void unAssignTpelec(
      @RequestBody(required = true) UnAssignTpelecFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignTpelec(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpelec", exc);
    }
  }

  /**
   * save Tsa on GovCT1
   *
   * @param command AssignTsaToGovCT1Command
   */
  @PutMapping("/assignTsa")
  public void assignTsa(@RequestBody AssignTsaToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignTsa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tsa", exc);
    }
  }

  /**
   * unassign Tsa on GovCT1
   *
   * @param command UnAssignTsaFromGovCT1Command
   */
  @PutMapping("/unAssignTsa")
  public void unAssignTsa(@RequestBody(required = true) UnAssignTsaFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignTsa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tsa", exc);
    }
  }

  /**
   * save Tsb on GovCT1
   *
   * @param command AssignTsbToGovCT1Command
   */
  @PutMapping("/assignTsb")
  public void assignTsb(@RequestBody AssignTsbToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignTsb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tsb", exc);
    }
  }

  /**
   * unassign Tsb on GovCT1
   *
   * @param command UnAssignTsbFromGovCT1Command
   */
  @PutMapping("/unAssignTsb")
  public void unAssignTsb(@RequestBody(required = true) UnAssignTsbFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignTsb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tsb", exc);
    }
  }

  /**
   * save Vmax on GovCT1
   *
   * @param command AssignVmaxToGovCT1Command
   */
  @PutMapping("/assignVmax")
  public void assignVmax(@RequestBody AssignVmaxToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignVmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmax", exc);
    }
  }

  /**
   * unassign Vmax on GovCT1
   *
   * @param command UnAssignVmaxFromGovCT1Command
   */
  @PutMapping("/unAssignVmax")
  public void unAssignVmax(@RequestBody(required = true) UnAssignVmaxFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignVmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmax", exc);
    }
  }

  /**
   * save Vmin on GovCT1
   *
   * @param command AssignVminToGovCT1Command
   */
  @PutMapping("/assignVmin")
  public void assignVmin(@RequestBody AssignVminToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignVmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmin", exc);
    }
  }

  /**
   * unassign Vmin on GovCT1
   *
   * @param command UnAssignVminFromGovCT1Command
   */
  @PutMapping("/unAssignVmin")
  public void unAssignVmin(@RequestBody(required = true) UnAssignVminFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignVmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmin", exc);
    }
  }

  /**
   * save Wfnl on GovCT1
   *
   * @param command AssignWfnlToGovCT1Command
   */
  @PutMapping("/assignWfnl")
  public void assignWfnl(@RequestBody AssignWfnlToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignWfnl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Wfnl", exc);
    }
  }

  /**
   * unassign Wfnl on GovCT1
   *
   * @param command UnAssignWfnlFromGovCT1Command
   */
  @PutMapping("/unAssignWfnl")
  public void unAssignWfnl(@RequestBody(required = true) UnAssignWfnlFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignWfnl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Wfnl", exc);
    }
  }

  /**
   * save Wfspd on GovCT1
   *
   * @param command AssignWfspdToGovCT1Command
   */
  @PutMapping("/assignWfspd")
  public void assignWfspd(@RequestBody AssignWfspdToGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().assignWfspd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Wfspd", exc);
    }
  }

  /**
   * unassign Wfspd on GovCT1
   *
   * @param command UnAssignWfspdFromGovCT1Command
   */
  @PutMapping("/unAssignWfspd")
  public void unAssignWfspd(@RequestBody(required = true) UnAssignWfspdFromGovCT1Command command) {
    try {
      GovCT1BusinessDelegate.getGovCT1Instance().unAssignWfspd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Wfspd", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovCT1 govCT1 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovCT1CommandRestController.class.getName());
}
