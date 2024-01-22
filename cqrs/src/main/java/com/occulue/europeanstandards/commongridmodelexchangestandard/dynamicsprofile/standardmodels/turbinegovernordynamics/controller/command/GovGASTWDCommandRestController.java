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
 * Implements Spring Controller command CQRS processing for entity GovGASTWD.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovGASTWD")
public class GovGASTWDCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovGASTWD. if not key provided, calls create, otherwise calls save
   *
   * @param GovGASTWD govGASTWD
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovGASTWDCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = GovGASTWDBusinessDelegate.getGovGASTWDInstance().createGovGASTWD(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovGASTWD. if no key provided, calls create, otherwise calls save
   *
   * @param GovGASTWD govGASTWD
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovGASTWDCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovGASTWDCommand
      // -----------------------------------------------
      completableFuture = GovGASTWDBusinessDelegate.getGovGASTWDInstance().updateGovGASTWD(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovGASTWDController:update() - successfully update GovGASTWD - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovGASTWD entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govGASTWDId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovGASTWDCommand command = new DeleteGovGASTWDCommand(govGASTWDId);

    try {
      GovGASTWDBusinessDelegate delegate = GovGASTWDBusinessDelegate.getGovGASTWDInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovGASTWD with key " + command.getGovGASTWDId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save A on GovGASTWD
   *
   * @param command AssignAToGovGASTWDCommand
   */
  @PutMapping("/assignA")
  public void assignA(@RequestBody AssignAToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignA(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign A", exc);
    }
  }

  /**
   * unassign A on GovGASTWD
   *
   * @param command UnAssignAFromGovGASTWDCommand
   */
  @PutMapping("/unAssignA")
  public void unAssignA(@RequestBody(required = true) UnAssignAFromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignA(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign A", exc);
    }
  }

  /**
   * save Af1 on GovGASTWD
   *
   * @param command AssignAf1ToGovGASTWDCommand
   */
  @PutMapping("/assignAf1")
  public void assignAf1(@RequestBody AssignAf1ToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignAf1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Af1", exc);
    }
  }

  /**
   * unassign Af1 on GovGASTWD
   *
   * @param command UnAssignAf1FromGovGASTWDCommand
   */
  @PutMapping("/unAssignAf1")
  public void unAssignAf1(@RequestBody(required = true) UnAssignAf1FromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignAf1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Af1", exc);
    }
  }

  /**
   * save Af2 on GovGASTWD
   *
   * @param command AssignAf2ToGovGASTWDCommand
   */
  @PutMapping("/assignAf2")
  public void assignAf2(@RequestBody AssignAf2ToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignAf2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Af2", exc);
    }
  }

  /**
   * unassign Af2 on GovGASTWD
   *
   * @param command UnAssignAf2FromGovGASTWDCommand
   */
  @PutMapping("/unAssignAf2")
  public void unAssignAf2(@RequestBody(required = true) UnAssignAf2FromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignAf2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Af2", exc);
    }
  }

  /**
   * save B on GovGASTWD
   *
   * @param command AssignBToGovGASTWDCommand
   */
  @PutMapping("/assignB")
  public void assignB(@RequestBody AssignBToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignB(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign B", exc);
    }
  }

  /**
   * unassign B on GovGASTWD
   *
   * @param command UnAssignBFromGovGASTWDCommand
   */
  @PutMapping("/unAssignB")
  public void unAssignB(@RequestBody(required = true) UnAssignBFromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignB(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign B", exc);
    }
  }

  /**
   * save Bf1 on GovGASTWD
   *
   * @param command AssignBf1ToGovGASTWDCommand
   */
  @PutMapping("/assignBf1")
  public void assignBf1(@RequestBody AssignBf1ToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignBf1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bf1", exc);
    }
  }

  /**
   * unassign Bf1 on GovGASTWD
   *
   * @param command UnAssignBf1FromGovGASTWDCommand
   */
  @PutMapping("/unAssignBf1")
  public void unAssignBf1(@RequestBody(required = true) UnAssignBf1FromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignBf1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bf1", exc);
    }
  }

  /**
   * save Bf2 on GovGASTWD
   *
   * @param command AssignBf2ToGovGASTWDCommand
   */
  @PutMapping("/assignBf2")
  public void assignBf2(@RequestBody AssignBf2ToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignBf2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bf2", exc);
    }
  }

  /**
   * unassign Bf2 on GovGASTWD
   *
   * @param command UnAssignBf2FromGovGASTWDCommand
   */
  @PutMapping("/unAssignBf2")
  public void unAssignBf2(@RequestBody(required = true) UnAssignBf2FromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignBf2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bf2", exc);
    }
  }

  /**
   * save C on GovGASTWD
   *
   * @param command AssignCToGovGASTWDCommand
   */
  @PutMapping("/assignC")
  public void assignC(@RequestBody AssignCToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign C", exc);
    }
  }

  /**
   * unassign C on GovGASTWD
   *
   * @param command UnAssignCFromGovGASTWDCommand
   */
  @PutMapping("/unAssignC")
  public void unAssignC(@RequestBody(required = true) UnAssignCFromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignC(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign C", exc);
    }
  }

  /**
   * save Cf2 on GovGASTWD
   *
   * @param command AssignCf2ToGovGASTWDCommand
   */
  @PutMapping("/assignCf2")
  public void assignCf2(@RequestBody AssignCf2ToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignCf2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Cf2", exc);
    }
  }

  /**
   * unassign Cf2 on GovGASTWD
   *
   * @param command UnAssignCf2FromGovGASTWDCommand
   */
  @PutMapping("/unAssignCf2")
  public void unAssignCf2(@RequestBody(required = true) UnAssignCf2FromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignCf2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Cf2", exc);
    }
  }

  /**
   * save Ecr on GovGASTWD
   *
   * @param command AssignEcrToGovGASTWDCommand
   */
  @PutMapping("/assignEcr")
  public void assignEcr(@RequestBody AssignEcrToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignEcr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ecr", exc);
    }
  }

  /**
   * unassign Ecr on GovGASTWD
   *
   * @param command UnAssignEcrFromGovGASTWDCommand
   */
  @PutMapping("/unAssignEcr")
  public void unAssignEcr(@RequestBody(required = true) UnAssignEcrFromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignEcr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ecr", exc);
    }
  }

  /**
   * save Etd on GovGASTWD
   *
   * @param command AssignEtdToGovGASTWDCommand
   */
  @PutMapping("/assignEtd")
  public void assignEtd(@RequestBody AssignEtdToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignEtd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Etd", exc);
    }
  }

  /**
   * unassign Etd on GovGASTWD
   *
   * @param command UnAssignEtdFromGovGASTWDCommand
   */
  @PutMapping("/unAssignEtd")
  public void unAssignEtd(@RequestBody(required = true) UnAssignEtdFromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignEtd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Etd", exc);
    }
  }

  /**
   * save K3 on GovGASTWD
   *
   * @param command AssignK3ToGovGASTWDCommand
   */
  @PutMapping("/assignK3")
  public void assignK3(@RequestBody AssignK3ToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignK3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K3", exc);
    }
  }

  /**
   * unassign K3 on GovGASTWD
   *
   * @param command UnAssignK3FromGovGASTWDCommand
   */
  @PutMapping("/unAssignK3")
  public void unAssignK3(@RequestBody(required = true) UnAssignK3FromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignK3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K3", exc);
    }
  }

  /**
   * save K4 on GovGASTWD
   *
   * @param command AssignK4ToGovGASTWDCommand
   */
  @PutMapping("/assignK4")
  public void assignK4(@RequestBody AssignK4ToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignK4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K4", exc);
    }
  }

  /**
   * unassign K4 on GovGASTWD
   *
   * @param command UnAssignK4FromGovGASTWDCommand
   */
  @PutMapping("/unAssignK4")
  public void unAssignK4(@RequestBody(required = true) UnAssignK4FromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignK4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K4", exc);
    }
  }

  /**
   * save K5 on GovGASTWD
   *
   * @param command AssignK5ToGovGASTWDCommand
   */
  @PutMapping("/assignK5")
  public void assignK5(@RequestBody AssignK5ToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignK5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K5", exc);
    }
  }

  /**
   * unassign K5 on GovGASTWD
   *
   * @param command UnAssignK5FromGovGASTWDCommand
   */
  @PutMapping("/unAssignK5")
  public void unAssignK5(@RequestBody(required = true) UnAssignK5FromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignK5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K5", exc);
    }
  }

  /**
   * save K6 on GovGASTWD
   *
   * @param command AssignK6ToGovGASTWDCommand
   */
  @PutMapping("/assignK6")
  public void assignK6(@RequestBody AssignK6ToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignK6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K6", exc);
    }
  }

  /**
   * unassign K6 on GovGASTWD
   *
   * @param command UnAssignK6FromGovGASTWDCommand
   */
  @PutMapping("/unAssignK6")
  public void unAssignK6(@RequestBody(required = true) UnAssignK6FromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignK6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K6", exc);
    }
  }

  /**
   * save Kd on GovGASTWD
   *
   * @param command AssignKdToGovGASTWDCommand
   */
  @PutMapping("/assignKd")
  public void assignKd(@RequestBody AssignKdToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignKd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd", exc);
    }
  }

  /**
   * unassign Kd on GovGASTWD
   *
   * @param command UnAssignKdFromGovGASTWDCommand
   */
  @PutMapping("/unAssignKd")
  public void unAssignKd(@RequestBody(required = true) UnAssignKdFromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignKd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd", exc);
    }
  }

  /**
   * save Kdroop on GovGASTWD
   *
   * @param command AssignKdroopToGovGASTWDCommand
   */
  @PutMapping("/assignKdroop")
  public void assignKdroop(@RequestBody AssignKdroopToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignKdroop(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kdroop", exc);
    }
  }

  /**
   * unassign Kdroop on GovGASTWD
   *
   * @param command UnAssignKdroopFromGovGASTWDCommand
   */
  @PutMapping("/unAssignKdroop")
  public void unAssignKdroop(
      @RequestBody(required = true) UnAssignKdroopFromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignKdroop(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kdroop", exc);
    }
  }

  /**
   * save Kf on GovGASTWD
   *
   * @param command AssignKfToGovGASTWDCommand
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on GovGASTWD
   *
   * @param command UnAssignKfFromGovGASTWDCommand
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Ki on GovGASTWD
   *
   * @param command AssignKiToGovGASTWDCommand
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on GovGASTWD
   *
   * @param command UnAssignKiFromGovGASTWDCommand
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(@RequestBody(required = true) UnAssignKiFromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Kp on GovGASTWD
   *
   * @param command AssignKpToGovGASTWDCommand
   */
  @PutMapping("/assignKp")
  public void assignKp(@RequestBody AssignKpToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignKp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp", exc);
    }
  }

  /**
   * unassign Kp on GovGASTWD
   *
   * @param command UnAssignKpFromGovGASTWDCommand
   */
  @PutMapping("/unAssignKp")
  public void unAssignKp(@RequestBody(required = true) UnAssignKpFromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignKp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp", exc);
    }
  }

  /**
   * save Mwbase on GovGASTWD
   *
   * @param command AssignMwbaseToGovGASTWDCommand
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovGASTWD
   *
   * @param command UnAssignMwbaseFromGovGASTWDCommand
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save T on GovGASTWD
   *
   * @param command AssignTToGovGASTWDCommand
   */
  @PutMapping("/assignT")
  public void assignT(@RequestBody AssignTToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignT(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T", exc);
    }
  }

  /**
   * unassign T on GovGASTWD
   *
   * @param command UnAssignTFromGovGASTWDCommand
   */
  @PutMapping("/unAssignT")
  public void unAssignT(@RequestBody(required = true) UnAssignTFromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignT(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T", exc);
    }
  }

  /**
   * save T3 on GovGASTWD
   *
   * @param command AssignT3ToGovGASTWDCommand
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on GovGASTWD
   *
   * @param command UnAssignT3FromGovGASTWDCommand
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on GovGASTWD
   *
   * @param command AssignT4ToGovGASTWDCommand
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on GovGASTWD
   *
   * @param command UnAssignT4FromGovGASTWDCommand
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save T5 on GovGASTWD
   *
   * @param command AssignT5ToGovGASTWDCommand
   */
  @PutMapping("/assignT5")
  public void assignT5(@RequestBody AssignT5ToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignT5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T5", exc);
    }
  }

  /**
   * unassign T5 on GovGASTWD
   *
   * @param command UnAssignT5FromGovGASTWDCommand
   */
  @PutMapping("/unAssignT5")
  public void unAssignT5(@RequestBody(required = true) UnAssignT5FromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignT5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T5", exc);
    }
  }

  /**
   * save Tc on GovGASTWD
   *
   * @param command AssignTcToGovGASTWDCommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on GovGASTWD
   *
   * @param command UnAssignTcFromGovGASTWDCommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Tcd on GovGASTWD
   *
   * @param command AssignTcdToGovGASTWDCommand
   */
  @PutMapping("/assignTcd")
  public void assignTcd(@RequestBody AssignTcdToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignTcd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tcd", exc);
    }
  }

  /**
   * unassign Tcd on GovGASTWD
   *
   * @param command UnAssignTcdFromGovGASTWDCommand
   */
  @PutMapping("/unAssignTcd")
  public void unAssignTcd(@RequestBody(required = true) UnAssignTcdFromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignTcd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tcd", exc);
    }
  }

  /**
   * save Td on GovGASTWD
   *
   * @param command AssignTdToGovGASTWDCommand
   */
  @PutMapping("/assignTd")
  public void assignTd(@RequestBody AssignTdToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignTd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Td", exc);
    }
  }

  /**
   * unassign Td on GovGASTWD
   *
   * @param command UnAssignTdFromGovGASTWDCommand
   */
  @PutMapping("/unAssignTd")
  public void unAssignTd(@RequestBody(required = true) UnAssignTdFromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignTd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Td", exc);
    }
  }

  /**
   * save Tf on GovGASTWD
   *
   * @param command AssignTfToGovGASTWDCommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on GovGASTWD
   *
   * @param command UnAssignTfFromGovGASTWDCommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Tmax on GovGASTWD
   *
   * @param command AssignTmaxToGovGASTWDCommand
   */
  @PutMapping("/assignTmax")
  public void assignTmax(@RequestBody AssignTmaxToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignTmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tmax", exc);
    }
  }

  /**
   * unassign Tmax on GovGASTWD
   *
   * @param command UnAssignTmaxFromGovGASTWDCommand
   */
  @PutMapping("/unAssignTmax")
  public void unAssignTmax(@RequestBody(required = true) UnAssignTmaxFromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignTmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tmax", exc);
    }
  }

  /**
   * save Tmin on GovGASTWD
   *
   * @param command AssignTminToGovGASTWDCommand
   */
  @PutMapping("/assignTmin")
  public void assignTmin(@RequestBody AssignTminToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignTmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tmin", exc);
    }
  }

  /**
   * unassign Tmin on GovGASTWD
   *
   * @param command UnAssignTminFromGovGASTWDCommand
   */
  @PutMapping("/unAssignTmin")
  public void unAssignTmin(@RequestBody(required = true) UnAssignTminFromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignTmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tmin", exc);
    }
  }

  /**
   * save Tr on GovGASTWD
   *
   * @param command AssignTrToGovGASTWDCommand
   */
  @PutMapping("/assignTr")
  public void assignTr(@RequestBody AssignTrToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignTr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tr", exc);
    }
  }

  /**
   * unassign Tr on GovGASTWD
   *
   * @param command UnAssignTrFromGovGASTWDCommand
   */
  @PutMapping("/unAssignTr")
  public void unAssignTr(@RequestBody(required = true) UnAssignTrFromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignTr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tr", exc);
    }
  }

  /**
   * save Trate on GovGASTWD
   *
   * @param command AssignTrateToGovGASTWDCommand
   */
  @PutMapping("/assignTrate")
  public void assignTrate(@RequestBody AssignTrateToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignTrate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Trate", exc);
    }
  }

  /**
   * unassign Trate on GovGASTWD
   *
   * @param command UnAssignTrateFromGovGASTWDCommand
   */
  @PutMapping("/unAssignTrate")
  public void unAssignTrate(
      @RequestBody(required = true) UnAssignTrateFromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignTrate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Trate", exc);
    }
  }

  /**
   * save Tt on GovGASTWD
   *
   * @param command AssignTtToGovGASTWDCommand
   */
  @PutMapping("/assignTt")
  public void assignTt(@RequestBody AssignTtToGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().assignTt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tt", exc);
    }
  }

  /**
   * unassign Tt on GovGASTWD
   *
   * @param command UnAssignTtFromGovGASTWDCommand
   */
  @PutMapping("/unAssignTt")
  public void unAssignTt(@RequestBody(required = true) UnAssignTtFromGovGASTWDCommand command) {
    try {
      GovGASTWDBusinessDelegate.getGovGASTWDInstance().unAssignTt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tt", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovGASTWD govGASTWD = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovGASTWDCommandRestController.class.getName());
}
