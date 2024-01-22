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
 * Implements Spring Controller command CQRS processing for entity GovCT2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovCT2")
public class GovCT2CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovCT2. if not key provided, calls create, otherwise calls save
   *
   * @param GovCT2 govCT2
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreateGovCT2Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = GovCT2BusinessDelegate.getGovCT2Instance().createGovCT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovCT2. if no key provided, calls create, otherwise calls save
   *
   * @param GovCT2 govCT2
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdateGovCT2Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovCT2Command
      // -----------------------------------------------
      completableFuture = GovCT2BusinessDelegate.getGovCT2Instance().updateGovCT2(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovCT2Controller:update() - successfully update GovCT2 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovCT2 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govCT2Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovCT2Command command = new DeleteGovCT2Command(govCT2Id);

    try {
      GovCT2BusinessDelegate delegate = GovCT2BusinessDelegate.getGovCT2Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted GovCT2 with key " + command.getGovCT2Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Aset on GovCT2
   *
   * @param command AssignAsetToGovCT2Command
   */
  @PutMapping("/assignAset")
  public void assignAset(@RequestBody AssignAsetToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignAset(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Aset", exc);
    }
  }

  /**
   * unassign Aset on GovCT2
   *
   * @param command UnAssignAsetFromGovCT2Command
   */
  @PutMapping("/unAssignAset")
  public void unAssignAset(@RequestBody(required = true) UnAssignAsetFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignAset(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Aset", exc);
    }
  }

  /**
   * save Db on GovCT2
   *
   * @param command AssignDbToGovCT2Command
   */
  @PutMapping("/assignDb")
  public void assignDb(@RequestBody AssignDbToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignDb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db", exc);
    }
  }

  /**
   * unassign Db on GovCT2
   *
   * @param command UnAssignDbFromGovCT2Command
   */
  @PutMapping("/unAssignDb")
  public void unAssignDb(@RequestBody(required = true) UnAssignDbFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignDb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db", exc);
    }
  }

  /**
   * save Dm on GovCT2
   *
   * @param command AssignDmToGovCT2Command
   */
  @PutMapping("/assignDm")
  public void assignDm(@RequestBody AssignDmToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignDm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dm", exc);
    }
  }

  /**
   * unassign Dm on GovCT2
   *
   * @param command UnAssignDmFromGovCT2Command
   */
  @PutMapping("/unAssignDm")
  public void unAssignDm(@RequestBody(required = true) UnAssignDmFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignDm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dm", exc);
    }
  }

  /**
   * save Flim1 on GovCT2
   *
   * @param command AssignFlim1ToGovCT2Command
   */
  @PutMapping("/assignFlim1")
  public void assignFlim1(@RequestBody AssignFlim1ToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignFlim1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Flim1", exc);
    }
  }

  /**
   * unassign Flim1 on GovCT2
   *
   * @param command UnAssignFlim1FromGovCT2Command
   */
  @PutMapping("/unAssignFlim1")
  public void unAssignFlim1(@RequestBody(required = true) UnAssignFlim1FromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignFlim1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Flim1", exc);
    }
  }

  /**
   * save Flim10 on GovCT2
   *
   * @param command AssignFlim10ToGovCT2Command
   */
  @PutMapping("/assignFlim10")
  public void assignFlim10(@RequestBody AssignFlim10ToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignFlim10(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Flim10", exc);
    }
  }

  /**
   * unassign Flim10 on GovCT2
   *
   * @param command UnAssignFlim10FromGovCT2Command
   */
  @PutMapping("/unAssignFlim10")
  public void unAssignFlim10(
      @RequestBody(required = true) UnAssignFlim10FromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignFlim10(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Flim10", exc);
    }
  }

  /**
   * save Flim2 on GovCT2
   *
   * @param command AssignFlim2ToGovCT2Command
   */
  @PutMapping("/assignFlim2")
  public void assignFlim2(@RequestBody AssignFlim2ToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignFlim2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Flim2", exc);
    }
  }

  /**
   * unassign Flim2 on GovCT2
   *
   * @param command UnAssignFlim2FromGovCT2Command
   */
  @PutMapping("/unAssignFlim2")
  public void unAssignFlim2(@RequestBody(required = true) UnAssignFlim2FromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignFlim2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Flim2", exc);
    }
  }

  /**
   * save Flim3 on GovCT2
   *
   * @param command AssignFlim3ToGovCT2Command
   */
  @PutMapping("/assignFlim3")
  public void assignFlim3(@RequestBody AssignFlim3ToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignFlim3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Flim3", exc);
    }
  }

  /**
   * unassign Flim3 on GovCT2
   *
   * @param command UnAssignFlim3FromGovCT2Command
   */
  @PutMapping("/unAssignFlim3")
  public void unAssignFlim3(@RequestBody(required = true) UnAssignFlim3FromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignFlim3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Flim3", exc);
    }
  }

  /**
   * save Flim4 on GovCT2
   *
   * @param command AssignFlim4ToGovCT2Command
   */
  @PutMapping("/assignFlim4")
  public void assignFlim4(@RequestBody AssignFlim4ToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignFlim4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Flim4", exc);
    }
  }

  /**
   * unassign Flim4 on GovCT2
   *
   * @param command UnAssignFlim4FromGovCT2Command
   */
  @PutMapping("/unAssignFlim4")
  public void unAssignFlim4(@RequestBody(required = true) UnAssignFlim4FromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignFlim4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Flim4", exc);
    }
  }

  /**
   * save Flim5 on GovCT2
   *
   * @param command AssignFlim5ToGovCT2Command
   */
  @PutMapping("/assignFlim5")
  public void assignFlim5(@RequestBody AssignFlim5ToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignFlim5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Flim5", exc);
    }
  }

  /**
   * unassign Flim5 on GovCT2
   *
   * @param command UnAssignFlim5FromGovCT2Command
   */
  @PutMapping("/unAssignFlim5")
  public void unAssignFlim5(@RequestBody(required = true) UnAssignFlim5FromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignFlim5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Flim5", exc);
    }
  }

  /**
   * save Flim6 on GovCT2
   *
   * @param command AssignFlim6ToGovCT2Command
   */
  @PutMapping("/assignFlim6")
  public void assignFlim6(@RequestBody AssignFlim6ToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignFlim6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Flim6", exc);
    }
  }

  /**
   * unassign Flim6 on GovCT2
   *
   * @param command UnAssignFlim6FromGovCT2Command
   */
  @PutMapping("/unAssignFlim6")
  public void unAssignFlim6(@RequestBody(required = true) UnAssignFlim6FromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignFlim6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Flim6", exc);
    }
  }

  /**
   * save Flim7 on GovCT2
   *
   * @param command AssignFlim7ToGovCT2Command
   */
  @PutMapping("/assignFlim7")
  public void assignFlim7(@RequestBody AssignFlim7ToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignFlim7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Flim7", exc);
    }
  }

  /**
   * unassign Flim7 on GovCT2
   *
   * @param command UnAssignFlim7FromGovCT2Command
   */
  @PutMapping("/unAssignFlim7")
  public void unAssignFlim7(@RequestBody(required = true) UnAssignFlim7FromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignFlim7(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Flim7", exc);
    }
  }

  /**
   * save Flim8 on GovCT2
   *
   * @param command AssignFlim8ToGovCT2Command
   */
  @PutMapping("/assignFlim8")
  public void assignFlim8(@RequestBody AssignFlim8ToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignFlim8(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Flim8", exc);
    }
  }

  /**
   * unassign Flim8 on GovCT2
   *
   * @param command UnAssignFlim8FromGovCT2Command
   */
  @PutMapping("/unAssignFlim8")
  public void unAssignFlim8(@RequestBody(required = true) UnAssignFlim8FromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignFlim8(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Flim8", exc);
    }
  }

  /**
   * save Flim9 on GovCT2
   *
   * @param command AssignFlim9ToGovCT2Command
   */
  @PutMapping("/assignFlim9")
  public void assignFlim9(@RequestBody AssignFlim9ToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignFlim9(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Flim9", exc);
    }
  }

  /**
   * unassign Flim9 on GovCT2
   *
   * @param command UnAssignFlim9FromGovCT2Command
   */
  @PutMapping("/unAssignFlim9")
  public void unAssignFlim9(@RequestBody(required = true) UnAssignFlim9FromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignFlim9(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Flim9", exc);
    }
  }

  /**
   * save Ka on GovCT2
   *
   * @param command AssignKaToGovCT2Command
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on GovCT2
   *
   * @param command UnAssignKaFromGovCT2Command
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kdgov on GovCT2
   *
   * @param command AssignKdgovToGovCT2Command
   */
  @PutMapping("/assignKdgov")
  public void assignKdgov(@RequestBody AssignKdgovToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignKdgov(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kdgov", exc);
    }
  }

  /**
   * unassign Kdgov on GovCT2
   *
   * @param command UnAssignKdgovFromGovCT2Command
   */
  @PutMapping("/unAssignKdgov")
  public void unAssignKdgov(@RequestBody(required = true) UnAssignKdgovFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignKdgov(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kdgov", exc);
    }
  }

  /**
   * save Kigov on GovCT2
   *
   * @param command AssignKigovToGovCT2Command
   */
  @PutMapping("/assignKigov")
  public void assignKigov(@RequestBody AssignKigovToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignKigov(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kigov", exc);
    }
  }

  /**
   * unassign Kigov on GovCT2
   *
   * @param command UnAssignKigovFromGovCT2Command
   */
  @PutMapping("/unAssignKigov")
  public void unAssignKigov(@RequestBody(required = true) UnAssignKigovFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignKigov(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kigov", exc);
    }
  }

  /**
   * save Kiload on GovCT2
   *
   * @param command AssignKiloadToGovCT2Command
   */
  @PutMapping("/assignKiload")
  public void assignKiload(@RequestBody AssignKiloadToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignKiload(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kiload", exc);
    }
  }

  /**
   * unassign Kiload on GovCT2
   *
   * @param command UnAssignKiloadFromGovCT2Command
   */
  @PutMapping("/unAssignKiload")
  public void unAssignKiload(
      @RequestBody(required = true) UnAssignKiloadFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignKiload(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kiload", exc);
    }
  }

  /**
   * save Kimw on GovCT2
   *
   * @param command AssignKimwToGovCT2Command
   */
  @PutMapping("/assignKimw")
  public void assignKimw(@RequestBody AssignKimwToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignKimw(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kimw", exc);
    }
  }

  /**
   * unassign Kimw on GovCT2
   *
   * @param command UnAssignKimwFromGovCT2Command
   */
  @PutMapping("/unAssignKimw")
  public void unAssignKimw(@RequestBody(required = true) UnAssignKimwFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignKimw(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kimw", exc);
    }
  }

  /**
   * save Kpgov on GovCT2
   *
   * @param command AssignKpgovToGovCT2Command
   */
  @PutMapping("/assignKpgov")
  public void assignKpgov(@RequestBody AssignKpgovToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignKpgov(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpgov", exc);
    }
  }

  /**
   * unassign Kpgov on GovCT2
   *
   * @param command UnAssignKpgovFromGovCT2Command
   */
  @PutMapping("/unAssignKpgov")
  public void unAssignKpgov(@RequestBody(required = true) UnAssignKpgovFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignKpgov(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpgov", exc);
    }
  }

  /**
   * save Kpload on GovCT2
   *
   * @param command AssignKploadToGovCT2Command
   */
  @PutMapping("/assignKpload")
  public void assignKpload(@RequestBody AssignKploadToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignKpload(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpload", exc);
    }
  }

  /**
   * unassign Kpload on GovCT2
   *
   * @param command UnAssignKploadFromGovCT2Command
   */
  @PutMapping("/unAssignKpload")
  public void unAssignKpload(
      @RequestBody(required = true) UnAssignKploadFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignKpload(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpload", exc);
    }
  }

  /**
   * save Kturb on GovCT2
   *
   * @param command AssignKturbToGovCT2Command
   */
  @PutMapping("/assignKturb")
  public void assignKturb(@RequestBody AssignKturbToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignKturb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kturb", exc);
    }
  }

  /**
   * unassign Kturb on GovCT2
   *
   * @param command UnAssignKturbFromGovCT2Command
   */
  @PutMapping("/unAssignKturb")
  public void unAssignKturb(@RequestBody(required = true) UnAssignKturbFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignKturb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kturb", exc);
    }
  }

  /**
   * save Ldref on GovCT2
   *
   * @param command AssignLdrefToGovCT2Command
   */
  @PutMapping("/assignLdref")
  public void assignLdref(@RequestBody AssignLdrefToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignLdref(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ldref", exc);
    }
  }

  /**
   * unassign Ldref on GovCT2
   *
   * @param command UnAssignLdrefFromGovCT2Command
   */
  @PutMapping("/unAssignLdref")
  public void unAssignLdref(@RequestBody(required = true) UnAssignLdrefFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignLdref(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ldref", exc);
    }
  }

  /**
   * save Maxerr on GovCT2
   *
   * @param command AssignMaxerrToGovCT2Command
   */
  @PutMapping("/assignMaxerr")
  public void assignMaxerr(@RequestBody AssignMaxerrToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignMaxerr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Maxerr", exc);
    }
  }

  /**
   * unassign Maxerr on GovCT2
   *
   * @param command UnAssignMaxerrFromGovCT2Command
   */
  @PutMapping("/unAssignMaxerr")
  public void unAssignMaxerr(
      @RequestBody(required = true) UnAssignMaxerrFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignMaxerr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Maxerr", exc);
    }
  }

  /**
   * save Minerr on GovCT2
   *
   * @param command AssignMinerrToGovCT2Command
   */
  @PutMapping("/assignMinerr")
  public void assignMinerr(@RequestBody AssignMinerrToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignMinerr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Minerr", exc);
    }
  }

  /**
   * unassign Minerr on GovCT2
   *
   * @param command UnAssignMinerrFromGovCT2Command
   */
  @PutMapping("/unAssignMinerr")
  public void unAssignMinerr(
      @RequestBody(required = true) UnAssignMinerrFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignMinerr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Minerr", exc);
    }
  }

  /**
   * save Mwbase on GovCT2
   *
   * @param command AssignMwbaseToGovCT2Command
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovCT2
   *
   * @param command UnAssignMwbaseFromGovCT2Command
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save Plim1 on GovCT2
   *
   * @param command AssignPlim1ToGovCT2Command
   */
  @PutMapping("/assignPlim1")
  public void assignPlim1(@RequestBody AssignPlim1ToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignPlim1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Plim1", exc);
    }
  }

  /**
   * unassign Plim1 on GovCT2
   *
   * @param command UnAssignPlim1FromGovCT2Command
   */
  @PutMapping("/unAssignPlim1")
  public void unAssignPlim1(@RequestBody(required = true) UnAssignPlim1FromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignPlim1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Plim1", exc);
    }
  }

  /**
   * save Plim10 on GovCT2
   *
   * @param command AssignPlim10ToGovCT2Command
   */
  @PutMapping("/assignPlim10")
  public void assignPlim10(@RequestBody AssignPlim10ToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignPlim10(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Plim10", exc);
    }
  }

  /**
   * unassign Plim10 on GovCT2
   *
   * @param command UnAssignPlim10FromGovCT2Command
   */
  @PutMapping("/unAssignPlim10")
  public void unAssignPlim10(
      @RequestBody(required = true) UnAssignPlim10FromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignPlim10(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Plim10", exc);
    }
  }

  /**
   * save Plim2 on GovCT2
   *
   * @param command AssignPlim2ToGovCT2Command
   */
  @PutMapping("/assignPlim2")
  public void assignPlim2(@RequestBody AssignPlim2ToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignPlim2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Plim2", exc);
    }
  }

  /**
   * unassign Plim2 on GovCT2
   *
   * @param command UnAssignPlim2FromGovCT2Command
   */
  @PutMapping("/unAssignPlim2")
  public void unAssignPlim2(@RequestBody(required = true) UnAssignPlim2FromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignPlim2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Plim2", exc);
    }
  }

  /**
   * save Plim3 on GovCT2
   *
   * @param command AssignPlim3ToGovCT2Command
   */
  @PutMapping("/assignPlim3")
  public void assignPlim3(@RequestBody AssignPlim3ToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignPlim3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Plim3", exc);
    }
  }

  /**
   * unassign Plim3 on GovCT2
   *
   * @param command UnAssignPlim3FromGovCT2Command
   */
  @PutMapping("/unAssignPlim3")
  public void unAssignPlim3(@RequestBody(required = true) UnAssignPlim3FromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignPlim3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Plim3", exc);
    }
  }

  /**
   * save Plim4 on GovCT2
   *
   * @param command AssignPlim4ToGovCT2Command
   */
  @PutMapping("/assignPlim4")
  public void assignPlim4(@RequestBody AssignPlim4ToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignPlim4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Plim4", exc);
    }
  }

  /**
   * unassign Plim4 on GovCT2
   *
   * @param command UnAssignPlim4FromGovCT2Command
   */
  @PutMapping("/unAssignPlim4")
  public void unAssignPlim4(@RequestBody(required = true) UnAssignPlim4FromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignPlim4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Plim4", exc);
    }
  }

  /**
   * save Plim5 on GovCT2
   *
   * @param command AssignPlim5ToGovCT2Command
   */
  @PutMapping("/assignPlim5")
  public void assignPlim5(@RequestBody AssignPlim5ToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignPlim5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Plim5", exc);
    }
  }

  /**
   * unassign Plim5 on GovCT2
   *
   * @param command UnAssignPlim5FromGovCT2Command
   */
  @PutMapping("/unAssignPlim5")
  public void unAssignPlim5(@RequestBody(required = true) UnAssignPlim5FromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignPlim5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Plim5", exc);
    }
  }

  /**
   * save Plim6 on GovCT2
   *
   * @param command AssignPlim6ToGovCT2Command
   */
  @PutMapping("/assignPlim6")
  public void assignPlim6(@RequestBody AssignPlim6ToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignPlim6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Plim6", exc);
    }
  }

  /**
   * unassign Plim6 on GovCT2
   *
   * @param command UnAssignPlim6FromGovCT2Command
   */
  @PutMapping("/unAssignPlim6")
  public void unAssignPlim6(@RequestBody(required = true) UnAssignPlim6FromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignPlim6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Plim6", exc);
    }
  }

  /**
   * save Plim7 on GovCT2
   *
   * @param command AssignPlim7ToGovCT2Command
   */
  @PutMapping("/assignPlim7")
  public void assignPlim7(@RequestBody AssignPlim7ToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignPlim7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Plim7", exc);
    }
  }

  /**
   * unassign Plim7 on GovCT2
   *
   * @param command UnAssignPlim7FromGovCT2Command
   */
  @PutMapping("/unAssignPlim7")
  public void unAssignPlim7(@RequestBody(required = true) UnAssignPlim7FromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignPlim7(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Plim7", exc);
    }
  }

  /**
   * save Plim8 on GovCT2
   *
   * @param command AssignPlim8ToGovCT2Command
   */
  @PutMapping("/assignPlim8")
  public void assignPlim8(@RequestBody AssignPlim8ToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignPlim8(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Plim8", exc);
    }
  }

  /**
   * unassign Plim8 on GovCT2
   *
   * @param command UnAssignPlim8FromGovCT2Command
   */
  @PutMapping("/unAssignPlim8")
  public void unAssignPlim8(@RequestBody(required = true) UnAssignPlim8FromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignPlim8(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Plim8", exc);
    }
  }

  /**
   * save Plim9 on GovCT2
   *
   * @param command AssignPlim9ToGovCT2Command
   */
  @PutMapping("/assignPlim9")
  public void assignPlim9(@RequestBody AssignPlim9ToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignPlim9(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Plim9", exc);
    }
  }

  /**
   * unassign Plim9 on GovCT2
   *
   * @param command UnAssignPlim9FromGovCT2Command
   */
  @PutMapping("/unAssignPlim9")
  public void unAssignPlim9(@RequestBody(required = true) UnAssignPlim9FromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignPlim9(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Plim9", exc);
    }
  }

  /**
   * save Prate on GovCT2
   *
   * @param command AssignPrateToGovCT2Command
   */
  @PutMapping("/assignPrate")
  public void assignPrate(@RequestBody AssignPrateToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignPrate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Prate", exc);
    }
  }

  /**
   * unassign Prate on GovCT2
   *
   * @param command UnAssignPrateFromGovCT2Command
   */
  @PutMapping("/unAssignPrate")
  public void unAssignPrate(@RequestBody(required = true) UnAssignPrateFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignPrate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Prate", exc);
    }
  }

  /**
   * save R on GovCT2
   *
   * @param command AssignRToGovCT2Command
   */
  @PutMapping("/assignR")
  public void assignR(@RequestBody AssignRToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignR(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R", exc);
    }
  }

  /**
   * unassign R on GovCT2
   *
   * @param command UnAssignRFromGovCT2Command
   */
  @PutMapping("/unAssignR")
  public void unAssignR(@RequestBody(required = true) UnAssignRFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignR(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R", exc);
    }
  }

  /**
   * save Rclose on GovCT2
   *
   * @param command AssignRcloseToGovCT2Command
   */
  @PutMapping("/assignRclose")
  public void assignRclose(@RequestBody AssignRcloseToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignRclose(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rclose", exc);
    }
  }

  /**
   * unassign Rclose on GovCT2
   *
   * @param command UnAssignRcloseFromGovCT2Command
   */
  @PutMapping("/unAssignRclose")
  public void unAssignRclose(
      @RequestBody(required = true) UnAssignRcloseFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignRclose(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rclose", exc);
    }
  }

  /**
   * save Rdown on GovCT2
   *
   * @param command AssignRdownToGovCT2Command
   */
  @PutMapping("/assignRdown")
  public void assignRdown(@RequestBody AssignRdownToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignRdown(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rdown", exc);
    }
  }

  /**
   * unassign Rdown on GovCT2
   *
   * @param command UnAssignRdownFromGovCT2Command
   */
  @PutMapping("/unAssignRdown")
  public void unAssignRdown(@RequestBody(required = true) UnAssignRdownFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignRdown(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rdown", exc);
    }
  }

  /**
   * save Ropen on GovCT2
   *
   * @param command AssignRopenToGovCT2Command
   */
  @PutMapping("/assignRopen")
  public void assignRopen(@RequestBody AssignRopenToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignRopen(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ropen", exc);
    }
  }

  /**
   * unassign Ropen on GovCT2
   *
   * @param command UnAssignRopenFromGovCT2Command
   */
  @PutMapping("/unAssignRopen")
  public void unAssignRopen(@RequestBody(required = true) UnAssignRopenFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignRopen(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ropen", exc);
    }
  }

  /**
   * save Rup on GovCT2
   *
   * @param command AssignRupToGovCT2Command
   */
  @PutMapping("/assignRup")
  public void assignRup(@RequestBody AssignRupToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignRup(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rup", exc);
    }
  }

  /**
   * unassign Rup on GovCT2
   *
   * @param command UnAssignRupFromGovCT2Command
   */
  @PutMapping("/unAssignRup")
  public void unAssignRup(@RequestBody(required = true) UnAssignRupFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignRup(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rup", exc);
    }
  }

  /**
   * save Ta on GovCT2
   *
   * @param command AssignTaToGovCT2Command
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on GovCT2
   *
   * @param command UnAssignTaFromGovCT2Command
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tact on GovCT2
   *
   * @param command AssignTactToGovCT2Command
   */
  @PutMapping("/assignTact")
  public void assignTact(@RequestBody AssignTactToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignTact(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tact", exc);
    }
  }

  /**
   * unassign Tact on GovCT2
   *
   * @param command UnAssignTactFromGovCT2Command
   */
  @PutMapping("/unAssignTact")
  public void unAssignTact(@RequestBody(required = true) UnAssignTactFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignTact(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tact", exc);
    }
  }

  /**
   * save Tb on GovCT2
   *
   * @param command AssignTbToGovCT2Command
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on GovCT2
   *
   * @param command UnAssignTbFromGovCT2Command
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on GovCT2
   *
   * @param command AssignTcToGovCT2Command
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on GovCT2
   *
   * @param command UnAssignTcFromGovCT2Command
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Tdgov on GovCT2
   *
   * @param command AssignTdgovToGovCT2Command
   */
  @PutMapping("/assignTdgov")
  public void assignTdgov(@RequestBody AssignTdgovToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignTdgov(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tdgov", exc);
    }
  }

  /**
   * unassign Tdgov on GovCT2
   *
   * @param command UnAssignTdgovFromGovCT2Command
   */
  @PutMapping("/unAssignTdgov")
  public void unAssignTdgov(@RequestBody(required = true) UnAssignTdgovFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignTdgov(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tdgov", exc);
    }
  }

  /**
   * save Teng on GovCT2
   *
   * @param command AssignTengToGovCT2Command
   */
  @PutMapping("/assignTeng")
  public void assignTeng(@RequestBody AssignTengToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignTeng(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Teng", exc);
    }
  }

  /**
   * unassign Teng on GovCT2
   *
   * @param command UnAssignTengFromGovCT2Command
   */
  @PutMapping("/unAssignTeng")
  public void unAssignTeng(@RequestBody(required = true) UnAssignTengFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignTeng(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Teng", exc);
    }
  }

  /**
   * save Tfload on GovCT2
   *
   * @param command AssignTfloadToGovCT2Command
   */
  @PutMapping("/assignTfload")
  public void assignTfload(@RequestBody AssignTfloadToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignTfload(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tfload", exc);
    }
  }

  /**
   * unassign Tfload on GovCT2
   *
   * @param command UnAssignTfloadFromGovCT2Command
   */
  @PutMapping("/unAssignTfload")
  public void unAssignTfload(
      @RequestBody(required = true) UnAssignTfloadFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignTfload(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tfload", exc);
    }
  }

  /**
   * save Tpelec on GovCT2
   *
   * @param command AssignTpelecToGovCT2Command
   */
  @PutMapping("/assignTpelec")
  public void assignTpelec(@RequestBody AssignTpelecToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignTpelec(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpelec", exc);
    }
  }

  /**
   * unassign Tpelec on GovCT2
   *
   * @param command UnAssignTpelecFromGovCT2Command
   */
  @PutMapping("/unAssignTpelec")
  public void unAssignTpelec(
      @RequestBody(required = true) UnAssignTpelecFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignTpelec(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpelec", exc);
    }
  }

  /**
   * save Tsa on GovCT2
   *
   * @param command AssignTsaToGovCT2Command
   */
  @PutMapping("/assignTsa")
  public void assignTsa(@RequestBody AssignTsaToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignTsa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tsa", exc);
    }
  }

  /**
   * unassign Tsa on GovCT2
   *
   * @param command UnAssignTsaFromGovCT2Command
   */
  @PutMapping("/unAssignTsa")
  public void unAssignTsa(@RequestBody(required = true) UnAssignTsaFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignTsa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tsa", exc);
    }
  }

  /**
   * save Tsb on GovCT2
   *
   * @param command AssignTsbToGovCT2Command
   */
  @PutMapping("/assignTsb")
  public void assignTsb(@RequestBody AssignTsbToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignTsb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tsb", exc);
    }
  }

  /**
   * unassign Tsb on GovCT2
   *
   * @param command UnAssignTsbFromGovCT2Command
   */
  @PutMapping("/unAssignTsb")
  public void unAssignTsb(@RequestBody(required = true) UnAssignTsbFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignTsb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tsb", exc);
    }
  }

  /**
   * save Vmax on GovCT2
   *
   * @param command AssignVmaxToGovCT2Command
   */
  @PutMapping("/assignVmax")
  public void assignVmax(@RequestBody AssignVmaxToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignVmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmax", exc);
    }
  }

  /**
   * unassign Vmax on GovCT2
   *
   * @param command UnAssignVmaxFromGovCT2Command
   */
  @PutMapping("/unAssignVmax")
  public void unAssignVmax(@RequestBody(required = true) UnAssignVmaxFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignVmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmax", exc);
    }
  }

  /**
   * save Vmin on GovCT2
   *
   * @param command AssignVminToGovCT2Command
   */
  @PutMapping("/assignVmin")
  public void assignVmin(@RequestBody AssignVminToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignVmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmin", exc);
    }
  }

  /**
   * unassign Vmin on GovCT2
   *
   * @param command UnAssignVminFromGovCT2Command
   */
  @PutMapping("/unAssignVmin")
  public void unAssignVmin(@RequestBody(required = true) UnAssignVminFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignVmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmin", exc);
    }
  }

  /**
   * save Wfnl on GovCT2
   *
   * @param command AssignWfnlToGovCT2Command
   */
  @PutMapping("/assignWfnl")
  public void assignWfnl(@RequestBody AssignWfnlToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignWfnl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Wfnl", exc);
    }
  }

  /**
   * unassign Wfnl on GovCT2
   *
   * @param command UnAssignWfnlFromGovCT2Command
   */
  @PutMapping("/unAssignWfnl")
  public void unAssignWfnl(@RequestBody(required = true) UnAssignWfnlFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignWfnl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Wfnl", exc);
    }
  }

  /**
   * save Wfspd on GovCT2
   *
   * @param command AssignWfspdToGovCT2Command
   */
  @PutMapping("/assignWfspd")
  public void assignWfspd(@RequestBody AssignWfspdToGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().assignWfspd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Wfspd", exc);
    }
  }

  /**
   * unassign Wfspd on GovCT2
   *
   * @param command UnAssignWfspdFromGovCT2Command
   */
  @PutMapping("/unAssignWfspd")
  public void unAssignWfspd(@RequestBody(required = true) UnAssignWfspdFromGovCT2Command command) {
    try {
      GovCT2BusinessDelegate.getGovCT2Instance().unAssignWfspd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Wfspd", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovCT2 govCT2 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovCT2CommandRestController.class.getName());
}
