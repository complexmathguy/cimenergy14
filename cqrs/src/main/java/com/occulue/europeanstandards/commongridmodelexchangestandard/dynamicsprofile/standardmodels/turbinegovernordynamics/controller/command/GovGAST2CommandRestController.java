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
 * Implements Spring Controller command CQRS processing for entity GovGAST2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovGAST2")
public class GovGAST2CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovGAST2. if not key provided, calls create, otherwise calls save
   *
   * @param GovGAST2 govGAST2
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovGAST2Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = GovGAST2BusinessDelegate.getGovGAST2Instance().createGovGAST2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovGAST2. if no key provided, calls create, otherwise calls save
   *
   * @param GovGAST2 govGAST2
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovGAST2Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovGAST2Command
      // -----------------------------------------------
      completableFuture = GovGAST2BusinessDelegate.getGovGAST2Instance().updateGovGAST2(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovGAST2Controller:update() - successfully update GovGAST2 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovGAST2 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govGAST2Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovGAST2Command command = new DeleteGovGAST2Command(govGAST2Id);

    try {
      GovGAST2BusinessDelegate delegate = GovGAST2BusinessDelegate.getGovGAST2Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovGAST2 with key " + command.getGovGAST2Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save A on GovGAST2
   *
   * @param command AssignAToGovGAST2Command
   */
  @PutMapping("/assignA")
  public void assignA(@RequestBody AssignAToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignA(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A", exc);
    }
  }

  /**
   * unassign A on GovGAST2
   *
   * @param command UnAssignAFromGovGAST2Command
   */
  @PutMapping("/unAssignA")
  public void unAssignA(@RequestBody(required = true) UnAssignAFromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignA(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A", exc);
    }
  }

  /**
   * save Af1 on GovGAST2
   *
   * @param command AssignAf1ToGovGAST2Command
   */
  @PutMapping("/assignAf1")
  public void assignAf1(@RequestBody AssignAf1ToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignAf1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Af1", exc);
    }
  }

  /**
   * unassign Af1 on GovGAST2
   *
   * @param command UnAssignAf1FromGovGAST2Command
   */
  @PutMapping("/unAssignAf1")
  public void unAssignAf1(@RequestBody(required = true) UnAssignAf1FromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignAf1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Af1", exc);
    }
  }

  /**
   * save Af2 on GovGAST2
   *
   * @param command AssignAf2ToGovGAST2Command
   */
  @PutMapping("/assignAf2")
  public void assignAf2(@RequestBody AssignAf2ToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignAf2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Af2", exc);
    }
  }

  /**
   * unassign Af2 on GovGAST2
   *
   * @param command UnAssignAf2FromGovGAST2Command
   */
  @PutMapping("/unAssignAf2")
  public void unAssignAf2(@RequestBody(required = true) UnAssignAf2FromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignAf2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Af2", exc);
    }
  }

  /**
   * save B on GovGAST2
   *
   * @param command AssignBToGovGAST2Command
   */
  @PutMapping("/assignB")
  public void assignB(@RequestBody AssignBToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignB(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign B", exc);
    }
  }

  /**
   * unassign B on GovGAST2
   *
   * @param command UnAssignBFromGovGAST2Command
   */
  @PutMapping("/unAssignB")
  public void unAssignB(@RequestBody(required = true) UnAssignBFromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignB(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign B", exc);
    }
  }

  /**
   * save Bf1 on GovGAST2
   *
   * @param command AssignBf1ToGovGAST2Command
   */
  @PutMapping("/assignBf1")
  public void assignBf1(@RequestBody AssignBf1ToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignBf1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bf1", exc);
    }
  }

  /**
   * unassign Bf1 on GovGAST2
   *
   * @param command UnAssignBf1FromGovGAST2Command
   */
  @PutMapping("/unAssignBf1")
  public void unAssignBf1(@RequestBody(required = true) UnAssignBf1FromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignBf1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bf1", exc);
    }
  }

  /**
   * save Bf2 on GovGAST2
   *
   * @param command AssignBf2ToGovGAST2Command
   */
  @PutMapping("/assignBf2")
  public void assignBf2(@RequestBody AssignBf2ToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignBf2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bf2", exc);
    }
  }

  /**
   * unassign Bf2 on GovGAST2
   *
   * @param command UnAssignBf2FromGovGAST2Command
   */
  @PutMapping("/unAssignBf2")
  public void unAssignBf2(@RequestBody(required = true) UnAssignBf2FromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignBf2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bf2", exc);
    }
  }

  /**
   * save C on GovGAST2
   *
   * @param command AssignCToGovGAST2Command
   */
  @PutMapping("/assignC")
  public void assignC(@RequestBody AssignCToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign C", exc);
    }
  }

  /**
   * unassign C on GovGAST2
   *
   * @param command UnAssignCFromGovGAST2Command
   */
  @PutMapping("/unAssignC")
  public void unAssignC(@RequestBody(required = true) UnAssignCFromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignC(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign C", exc);
    }
  }

  /**
   * save Cf2 on GovGAST2
   *
   * @param command AssignCf2ToGovGAST2Command
   */
  @PutMapping("/assignCf2")
  public void assignCf2(@RequestBody AssignCf2ToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignCf2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Cf2", exc);
    }
  }

  /**
   * unassign Cf2 on GovGAST2
   *
   * @param command UnAssignCf2FromGovGAST2Command
   */
  @PutMapping("/unAssignCf2")
  public void unAssignCf2(@RequestBody(required = true) UnAssignCf2FromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignCf2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Cf2", exc);
    }
  }

  /**
   * save Ecr on GovGAST2
   *
   * @param command AssignEcrToGovGAST2Command
   */
  @PutMapping("/assignEcr")
  public void assignEcr(@RequestBody AssignEcrToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignEcr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ecr", exc);
    }
  }

  /**
   * unassign Ecr on GovGAST2
   *
   * @param command UnAssignEcrFromGovGAST2Command
   */
  @PutMapping("/unAssignEcr")
  public void unAssignEcr(@RequestBody(required = true) UnAssignEcrFromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignEcr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ecr", exc);
    }
  }

  /**
   * save Etd on GovGAST2
   *
   * @param command AssignEtdToGovGAST2Command
   */
  @PutMapping("/assignEtd")
  public void assignEtd(@RequestBody AssignEtdToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignEtd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Etd", exc);
    }
  }

  /**
   * unassign Etd on GovGAST2
   *
   * @param command UnAssignEtdFromGovGAST2Command
   */
  @PutMapping("/unAssignEtd")
  public void unAssignEtd(@RequestBody(required = true) UnAssignEtdFromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignEtd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Etd", exc);
    }
  }

  /**
   * save K3 on GovGAST2
   *
   * @param command AssignK3ToGovGAST2Command
   */
  @PutMapping("/assignK3")
  public void assignK3(@RequestBody AssignK3ToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignK3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K3", exc);
    }
  }

  /**
   * unassign K3 on GovGAST2
   *
   * @param command UnAssignK3FromGovGAST2Command
   */
  @PutMapping("/unAssignK3")
  public void unAssignK3(@RequestBody(required = true) UnAssignK3FromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignK3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K3", exc);
    }
  }

  /**
   * save K4 on GovGAST2
   *
   * @param command AssignK4ToGovGAST2Command
   */
  @PutMapping("/assignK4")
  public void assignK4(@RequestBody AssignK4ToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignK4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K4", exc);
    }
  }

  /**
   * unassign K4 on GovGAST2
   *
   * @param command UnAssignK4FromGovGAST2Command
   */
  @PutMapping("/unAssignK4")
  public void unAssignK4(@RequestBody(required = true) UnAssignK4FromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignK4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K4", exc);
    }
  }

  /**
   * save K5 on GovGAST2
   *
   * @param command AssignK5ToGovGAST2Command
   */
  @PutMapping("/assignK5")
  public void assignK5(@RequestBody AssignK5ToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignK5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K5", exc);
    }
  }

  /**
   * unassign K5 on GovGAST2
   *
   * @param command UnAssignK5FromGovGAST2Command
   */
  @PutMapping("/unAssignK5")
  public void unAssignK5(@RequestBody(required = true) UnAssignK5FromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignK5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K5", exc);
    }
  }

  /**
   * save K6 on GovGAST2
   *
   * @param command AssignK6ToGovGAST2Command
   */
  @PutMapping("/assignK6")
  public void assignK6(@RequestBody AssignK6ToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignK6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K6", exc);
    }
  }

  /**
   * unassign K6 on GovGAST2
   *
   * @param command UnAssignK6FromGovGAST2Command
   */
  @PutMapping("/unAssignK6")
  public void unAssignK6(@RequestBody(required = true) UnAssignK6FromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignK6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K6", exc);
    }
  }

  /**
   * save Kf on GovGAST2
   *
   * @param command AssignKfToGovGAST2Command
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on GovGAST2
   *
   * @param command UnAssignKfFromGovGAST2Command
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Mwbase on GovGAST2
   *
   * @param command AssignMwbaseToGovGAST2Command
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovGAST2
   *
   * @param command UnAssignMwbaseFromGovGAST2Command
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save T on GovGAST2
   *
   * @param command AssignTToGovGAST2Command
   */
  @PutMapping("/assignT")
  public void assignT(@RequestBody AssignTToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignT(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T", exc);
    }
  }

  /**
   * unassign T on GovGAST2
   *
   * @param command UnAssignTFromGovGAST2Command
   */
  @PutMapping("/unAssignT")
  public void unAssignT(@RequestBody(required = true) UnAssignTFromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignT(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T", exc);
    }
  }

  /**
   * save T3 on GovGAST2
   *
   * @param command AssignT3ToGovGAST2Command
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on GovGAST2
   *
   * @param command UnAssignT3FromGovGAST2Command
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on GovGAST2
   *
   * @param command AssignT4ToGovGAST2Command
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on GovGAST2
   *
   * @param command UnAssignT4FromGovGAST2Command
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save T5 on GovGAST2
   *
   * @param command AssignT5ToGovGAST2Command
   */
  @PutMapping("/assignT5")
  public void assignT5(@RequestBody AssignT5ToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignT5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T5", exc);
    }
  }

  /**
   * unassign T5 on GovGAST2
   *
   * @param command UnAssignT5FromGovGAST2Command
   */
  @PutMapping("/unAssignT5")
  public void unAssignT5(@RequestBody(required = true) UnAssignT5FromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignT5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T5", exc);
    }
  }

  /**
   * save Tc on GovGAST2
   *
   * @param command AssignTcToGovGAST2Command
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on GovGAST2
   *
   * @param command UnAssignTcFromGovGAST2Command
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Tcd on GovGAST2
   *
   * @param command AssignTcdToGovGAST2Command
   */
  @PutMapping("/assignTcd")
  public void assignTcd(@RequestBody AssignTcdToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignTcd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tcd", exc);
    }
  }

  /**
   * unassign Tcd on GovGAST2
   *
   * @param command UnAssignTcdFromGovGAST2Command
   */
  @PutMapping("/unAssignTcd")
  public void unAssignTcd(@RequestBody(required = true) UnAssignTcdFromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignTcd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tcd", exc);
    }
  }

  /**
   * save Tf on GovGAST2
   *
   * @param command AssignTfToGovGAST2Command
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on GovGAST2
   *
   * @param command UnAssignTfFromGovGAST2Command
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Tmax on GovGAST2
   *
   * @param command AssignTmaxToGovGAST2Command
   */
  @PutMapping("/assignTmax")
  public void assignTmax(@RequestBody AssignTmaxToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignTmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tmax", exc);
    }
  }

  /**
   * unassign Tmax on GovGAST2
   *
   * @param command UnAssignTmaxFromGovGAST2Command
   */
  @PutMapping("/unAssignTmax")
  public void unAssignTmax(@RequestBody(required = true) UnAssignTmaxFromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignTmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tmax", exc);
    }
  }

  /**
   * save Tmin on GovGAST2
   *
   * @param command AssignTminToGovGAST2Command
   */
  @PutMapping("/assignTmin")
  public void assignTmin(@RequestBody AssignTminToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignTmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tmin", exc);
    }
  }

  /**
   * unassign Tmin on GovGAST2
   *
   * @param command UnAssignTminFromGovGAST2Command
   */
  @PutMapping("/unAssignTmin")
  public void unAssignTmin(@RequestBody(required = true) UnAssignTminFromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignTmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tmin", exc);
    }
  }

  /**
   * save Tr on GovGAST2
   *
   * @param command AssignTrToGovGAST2Command
   */
  @PutMapping("/assignTr")
  public void assignTr(@RequestBody AssignTrToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignTr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tr", exc);
    }
  }

  /**
   * unassign Tr on GovGAST2
   *
   * @param command UnAssignTrFromGovGAST2Command
   */
  @PutMapping("/unAssignTr")
  public void unAssignTr(@RequestBody(required = true) UnAssignTrFromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignTr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tr", exc);
    }
  }

  /**
   * save Trate on GovGAST2
   *
   * @param command AssignTrateToGovGAST2Command
   */
  @PutMapping("/assignTrate")
  public void assignTrate(@RequestBody AssignTrateToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignTrate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Trate", exc);
    }
  }

  /**
   * unassign Trate on GovGAST2
   *
   * @param command UnAssignTrateFromGovGAST2Command
   */
  @PutMapping("/unAssignTrate")
  public void unAssignTrate(
      @RequestBody(required = true) UnAssignTrateFromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignTrate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Trate", exc);
    }
  }

  /**
   * save Tt on GovGAST2
   *
   * @param command AssignTtToGovGAST2Command
   */
  @PutMapping("/assignTt")
  public void assignTt(@RequestBody AssignTtToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignTt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tt", exc);
    }
  }

  /**
   * unassign Tt on GovGAST2
   *
   * @param command UnAssignTtFromGovGAST2Command
   */
  @PutMapping("/unAssignTt")
  public void unAssignTt(@RequestBody(required = true) UnAssignTtFromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignTt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tt", exc);
    }
  }

  /**
   * save W on GovGAST2
   *
   * @param command AssignWToGovGAST2Command
   */
  @PutMapping("/assignW")
  public void assignW(@RequestBody AssignWToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignW(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign W", exc);
    }
  }

  /**
   * unassign W on GovGAST2
   *
   * @param command UnAssignWFromGovGAST2Command
   */
  @PutMapping("/unAssignW")
  public void unAssignW(@RequestBody(required = true) UnAssignWFromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignW(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign W", exc);
    }
  }

  /**
   * save X on GovGAST2
   *
   * @param command AssignXToGovGAST2Command
   */
  @PutMapping("/assignX")
  public void assignX(@RequestBody AssignXToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignX(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign X", exc);
    }
  }

  /**
   * unassign X on GovGAST2
   *
   * @param command UnAssignXFromGovGAST2Command
   */
  @PutMapping("/unAssignX")
  public void unAssignX(@RequestBody(required = true) UnAssignXFromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignX(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign X", exc);
    }
  }

  /**
   * save Y on GovGAST2
   *
   * @param command AssignYToGovGAST2Command
   */
  @PutMapping("/assignY")
  public void assignY(@RequestBody AssignYToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignY(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Y", exc);
    }
  }

  /**
   * unassign Y on GovGAST2
   *
   * @param command UnAssignYFromGovGAST2Command
   */
  @PutMapping("/unAssignY")
  public void unAssignY(@RequestBody(required = true) UnAssignYFromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignY(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Y", exc);
    }
  }

  /**
   * save Z on GovGAST2
   *
   * @param command AssignZToGovGAST2Command
   */
  @PutMapping("/assignZ")
  public void assignZ(@RequestBody AssignZToGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().assignZ(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Z", exc);
    }
  }

  /**
   * unassign Z on GovGAST2
   *
   * @param command UnAssignZFromGovGAST2Command
   */
  @PutMapping("/unAssignZ")
  public void unAssignZ(@RequestBody(required = true) UnAssignZFromGovGAST2Command command) {
    try {
      GovGAST2BusinessDelegate.getGovGAST2Instance().unAssignZ(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Z", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovGAST2 govGAST2 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovGAST2CommandRestController.class.getName());
}
