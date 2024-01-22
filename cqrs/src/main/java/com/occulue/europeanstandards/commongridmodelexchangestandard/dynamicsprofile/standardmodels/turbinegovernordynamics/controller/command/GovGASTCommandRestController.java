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
 * Implements Spring Controller command CQRS processing for entity GovGAST.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovGAST")
public class GovGASTCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovGAST. if not key provided, calls create, otherwise calls save
   *
   * @param GovGAST govGAST
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovGASTCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = GovGASTBusinessDelegate.getGovGASTInstance().createGovGAST(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovGAST. if no key provided, calls create, otherwise calls save
   *
   * @param GovGAST govGAST
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovGASTCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovGASTCommand
      // -----------------------------------------------
      completableFuture = GovGASTBusinessDelegate.getGovGASTInstance().updateGovGAST(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovGASTController:update() - successfully update GovGAST - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovGAST entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govGASTId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovGASTCommand command = new DeleteGovGASTCommand(govGASTId);

    try {
      GovGASTBusinessDelegate delegate = GovGASTBusinessDelegate.getGovGASTInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted GovGAST with key " + command.getGovGASTId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save At on GovGAST
   *
   * @param command AssignAtToGovGASTCommand
   */
  @PutMapping("/assignAt")
  public void assignAt(@RequestBody AssignAtToGovGASTCommand command) {
    try {
      GovGASTBusinessDelegate.getGovGASTInstance().assignAt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign At", exc);
    }
  }

  /**
   * unassign At on GovGAST
   *
   * @param command UnAssignAtFromGovGASTCommand
   */
  @PutMapping("/unAssignAt")
  public void unAssignAt(@RequestBody(required = true) UnAssignAtFromGovGASTCommand command) {
    try {
      GovGASTBusinessDelegate.getGovGASTInstance().unAssignAt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign At", exc);
    }
  }

  /**
   * save Dturb on GovGAST
   *
   * @param command AssignDturbToGovGASTCommand
   */
  @PutMapping("/assignDturb")
  public void assignDturb(@RequestBody AssignDturbToGovGASTCommand command) {
    try {
      GovGASTBusinessDelegate.getGovGASTInstance().assignDturb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dturb", exc);
    }
  }

  /**
   * unassign Dturb on GovGAST
   *
   * @param command UnAssignDturbFromGovGASTCommand
   */
  @PutMapping("/unAssignDturb")
  public void unAssignDturb(@RequestBody(required = true) UnAssignDturbFromGovGASTCommand command) {
    try {
      GovGASTBusinessDelegate.getGovGASTInstance().unAssignDturb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dturb", exc);
    }
  }

  /**
   * save Kt on GovGAST
   *
   * @param command AssignKtToGovGASTCommand
   */
  @PutMapping("/assignKt")
  public void assignKt(@RequestBody AssignKtToGovGASTCommand command) {
    try {
      GovGASTBusinessDelegate.getGovGASTInstance().assignKt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kt", exc);
    }
  }

  /**
   * unassign Kt on GovGAST
   *
   * @param command UnAssignKtFromGovGASTCommand
   */
  @PutMapping("/unAssignKt")
  public void unAssignKt(@RequestBody(required = true) UnAssignKtFromGovGASTCommand command) {
    try {
      GovGASTBusinessDelegate.getGovGASTInstance().unAssignKt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kt", exc);
    }
  }

  /**
   * save Mwbase on GovGAST
   *
   * @param command AssignMwbaseToGovGASTCommand
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovGASTCommand command) {
    try {
      GovGASTBusinessDelegate.getGovGASTInstance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovGAST
   *
   * @param command UnAssignMwbaseFromGovGASTCommand
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovGASTCommand command) {
    try {
      GovGASTBusinessDelegate.getGovGASTInstance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save R on GovGAST
   *
   * @param command AssignRToGovGASTCommand
   */
  @PutMapping("/assignR")
  public void assignR(@RequestBody AssignRToGovGASTCommand command) {
    try {
      GovGASTBusinessDelegate.getGovGASTInstance().assignR(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R", exc);
    }
  }

  /**
   * unassign R on GovGAST
   *
   * @param command UnAssignRFromGovGASTCommand
   */
  @PutMapping("/unAssignR")
  public void unAssignR(@RequestBody(required = true) UnAssignRFromGovGASTCommand command) {
    try {
      GovGASTBusinessDelegate.getGovGASTInstance().unAssignR(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R", exc);
    }
  }

  /**
   * save T1 on GovGAST
   *
   * @param command AssignT1ToGovGASTCommand
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToGovGASTCommand command) {
    try {
      GovGASTBusinessDelegate.getGovGASTInstance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on GovGAST
   *
   * @param command UnAssignT1FromGovGASTCommand
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromGovGASTCommand command) {
    try {
      GovGASTBusinessDelegate.getGovGASTInstance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on GovGAST
   *
   * @param command AssignT2ToGovGASTCommand
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToGovGASTCommand command) {
    try {
      GovGASTBusinessDelegate.getGovGASTInstance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on GovGAST
   *
   * @param command UnAssignT2FromGovGASTCommand
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromGovGASTCommand command) {
    try {
      GovGASTBusinessDelegate.getGovGASTInstance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on GovGAST
   *
   * @param command AssignT3ToGovGASTCommand
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToGovGASTCommand command) {
    try {
      GovGASTBusinessDelegate.getGovGASTInstance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on GovGAST
   *
   * @param command UnAssignT3FromGovGASTCommand
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromGovGASTCommand command) {
    try {
      GovGASTBusinessDelegate.getGovGASTInstance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save Vmax on GovGAST
   *
   * @param command AssignVmaxToGovGASTCommand
   */
  @PutMapping("/assignVmax")
  public void assignVmax(@RequestBody AssignVmaxToGovGASTCommand command) {
    try {
      GovGASTBusinessDelegate.getGovGASTInstance().assignVmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmax", exc);
    }
  }

  /**
   * unassign Vmax on GovGAST
   *
   * @param command UnAssignVmaxFromGovGASTCommand
   */
  @PutMapping("/unAssignVmax")
  public void unAssignVmax(@RequestBody(required = true) UnAssignVmaxFromGovGASTCommand command) {
    try {
      GovGASTBusinessDelegate.getGovGASTInstance().unAssignVmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmax", exc);
    }
  }

  /**
   * save Vmin on GovGAST
   *
   * @param command AssignVminToGovGASTCommand
   */
  @PutMapping("/assignVmin")
  public void assignVmin(@RequestBody AssignVminToGovGASTCommand command) {
    try {
      GovGASTBusinessDelegate.getGovGASTInstance().assignVmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmin", exc);
    }
  }

  /**
   * unassign Vmin on GovGAST
   *
   * @param command UnAssignVminFromGovGASTCommand
   */
  @PutMapping("/unAssignVmin")
  public void unAssignVmin(@RequestBody(required = true) UnAssignVminFromGovGASTCommand command) {
    try {
      GovGASTBusinessDelegate.getGovGASTInstance().unAssignVmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovGAST govGAST = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovGASTCommandRestController.class.getName());
}
