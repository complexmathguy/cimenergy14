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
 * Implements Spring Controller command CQRS processing for entity GovSteamCC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteamCC")
public class GovSteamCCCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovSteamCC. if not key provided, calls create, otherwise calls save
   *
   * @param GovSteamCC govSteamCC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovSteamCCCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          GovSteamCCBusinessDelegate.getGovSteamCCInstance().createGovSteamCC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovSteamCC. if no key provided, calls create, otherwise calls save
   *
   * @param GovSteamCC govSteamCC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovSteamCCCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovSteamCCCommand
      // -----------------------------------------------
      completableFuture =
          GovSteamCCBusinessDelegate.getGovSteamCCInstance().updateGovSteamCC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovSteamCCController:update() - successfully update GovSteamCC - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovSteamCC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govSteamCCId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovSteamCCCommand command = new DeleteGovSteamCCCommand(govSteamCCId);

    try {
      GovSteamCCBusinessDelegate delegate = GovSteamCCBusinessDelegate.getGovSteamCCInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovSteamCC with key " + command.getGovSteamCCId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Dhp on GovSteamCC
   *
   * @param command AssignDhpToGovSteamCCCommand
   */
  @PutMapping("/assignDhp")
  public void assignDhp(@RequestBody AssignDhpToGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().assignDhp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dhp", exc);
    }
  }

  /**
   * unassign Dhp on GovSteamCC
   *
   * @param command UnAssignDhpFromGovSteamCCCommand
   */
  @PutMapping("/unAssignDhp")
  public void unAssignDhp(@RequestBody(required = true) UnAssignDhpFromGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().unAssignDhp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dhp", exc);
    }
  }

  /**
   * save Dlp on GovSteamCC
   *
   * @param command AssignDlpToGovSteamCCCommand
   */
  @PutMapping("/assignDlp")
  public void assignDlp(@RequestBody AssignDlpToGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().assignDlp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dlp", exc);
    }
  }

  /**
   * unassign Dlp on GovSteamCC
   *
   * @param command UnAssignDlpFromGovSteamCCCommand
   */
  @PutMapping("/unAssignDlp")
  public void unAssignDlp(@RequestBody(required = true) UnAssignDlpFromGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().unAssignDlp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dlp", exc);
    }
  }

  /**
   * save Fhp on GovSteamCC
   *
   * @param command AssignFhpToGovSteamCCCommand
   */
  @PutMapping("/assignFhp")
  public void assignFhp(@RequestBody AssignFhpToGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().assignFhp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Fhp", exc);
    }
  }

  /**
   * unassign Fhp on GovSteamCC
   *
   * @param command UnAssignFhpFromGovSteamCCCommand
   */
  @PutMapping("/unAssignFhp")
  public void unAssignFhp(@RequestBody(required = true) UnAssignFhpFromGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().unAssignFhp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Fhp", exc);
    }
  }

  /**
   * save Flp on GovSteamCC
   *
   * @param command AssignFlpToGovSteamCCCommand
   */
  @PutMapping("/assignFlp")
  public void assignFlp(@RequestBody AssignFlpToGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().assignFlp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Flp", exc);
    }
  }

  /**
   * unassign Flp on GovSteamCC
   *
   * @param command UnAssignFlpFromGovSteamCCCommand
   */
  @PutMapping("/unAssignFlp")
  public void unAssignFlp(@RequestBody(required = true) UnAssignFlpFromGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().unAssignFlp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Flp", exc);
    }
  }

  /**
   * save Mwbase on GovSteamCC
   *
   * @param command AssignMwbaseToGovSteamCCCommand
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovSteamCC
   *
   * @param command UnAssignMwbaseFromGovSteamCCCommand
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save Pmaxhp on GovSteamCC
   *
   * @param command AssignPmaxhpToGovSteamCCCommand
   */
  @PutMapping("/assignPmaxhp")
  public void assignPmaxhp(@RequestBody AssignPmaxhpToGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().assignPmaxhp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmaxhp", exc);
    }
  }

  /**
   * unassign Pmaxhp on GovSteamCC
   *
   * @param command UnAssignPmaxhpFromGovSteamCCCommand
   */
  @PutMapping("/unAssignPmaxhp")
  public void unAssignPmaxhp(
      @RequestBody(required = true) UnAssignPmaxhpFromGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().unAssignPmaxhp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmaxhp", exc);
    }
  }

  /**
   * save Pmaxlp on GovSteamCC
   *
   * @param command AssignPmaxlpToGovSteamCCCommand
   */
  @PutMapping("/assignPmaxlp")
  public void assignPmaxlp(@RequestBody AssignPmaxlpToGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().assignPmaxlp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmaxlp", exc);
    }
  }

  /**
   * unassign Pmaxlp on GovSteamCC
   *
   * @param command UnAssignPmaxlpFromGovSteamCCCommand
   */
  @PutMapping("/unAssignPmaxlp")
  public void unAssignPmaxlp(
      @RequestBody(required = true) UnAssignPmaxlpFromGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().unAssignPmaxlp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmaxlp", exc);
    }
  }

  /**
   * save Rhp on GovSteamCC
   *
   * @param command AssignRhpToGovSteamCCCommand
   */
  @PutMapping("/assignRhp")
  public void assignRhp(@RequestBody AssignRhpToGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().assignRhp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rhp", exc);
    }
  }

  /**
   * unassign Rhp on GovSteamCC
   *
   * @param command UnAssignRhpFromGovSteamCCCommand
   */
  @PutMapping("/unAssignRhp")
  public void unAssignRhp(@RequestBody(required = true) UnAssignRhpFromGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().unAssignRhp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rhp", exc);
    }
  }

  /**
   * save Rlp on GovSteamCC
   *
   * @param command AssignRlpToGovSteamCCCommand
   */
  @PutMapping("/assignRlp")
  public void assignRlp(@RequestBody AssignRlpToGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().assignRlp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rlp", exc);
    }
  }

  /**
   * unassign Rlp on GovSteamCC
   *
   * @param command UnAssignRlpFromGovSteamCCCommand
   */
  @PutMapping("/unAssignRlp")
  public void unAssignRlp(@RequestBody(required = true) UnAssignRlpFromGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().unAssignRlp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rlp", exc);
    }
  }

  /**
   * save T1hp on GovSteamCC
   *
   * @param command AssignT1hpToGovSteamCCCommand
   */
  @PutMapping("/assignT1hp")
  public void assignT1hp(@RequestBody AssignT1hpToGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().assignT1hp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1hp", exc);
    }
  }

  /**
   * unassign T1hp on GovSteamCC
   *
   * @param command UnAssignT1hpFromGovSteamCCCommand
   */
  @PutMapping("/unAssignT1hp")
  public void unAssignT1hp(
      @RequestBody(required = true) UnAssignT1hpFromGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().unAssignT1hp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1hp", exc);
    }
  }

  /**
   * save T1lp on GovSteamCC
   *
   * @param command AssignT1lpToGovSteamCCCommand
   */
  @PutMapping("/assignT1lp")
  public void assignT1lp(@RequestBody AssignT1lpToGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().assignT1lp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1lp", exc);
    }
  }

  /**
   * unassign T1lp on GovSteamCC
   *
   * @param command UnAssignT1lpFromGovSteamCCCommand
   */
  @PutMapping("/unAssignT1lp")
  public void unAssignT1lp(
      @RequestBody(required = true) UnAssignT1lpFromGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().unAssignT1lp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1lp", exc);
    }
  }

  /**
   * save T3hp on GovSteamCC
   *
   * @param command AssignT3hpToGovSteamCCCommand
   */
  @PutMapping("/assignT3hp")
  public void assignT3hp(@RequestBody AssignT3hpToGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().assignT3hp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3hp", exc);
    }
  }

  /**
   * unassign T3hp on GovSteamCC
   *
   * @param command UnAssignT3hpFromGovSteamCCCommand
   */
  @PutMapping("/unAssignT3hp")
  public void unAssignT3hp(
      @RequestBody(required = true) UnAssignT3hpFromGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().unAssignT3hp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3hp", exc);
    }
  }

  /**
   * save T3lp on GovSteamCC
   *
   * @param command AssignT3lpToGovSteamCCCommand
   */
  @PutMapping("/assignT3lp")
  public void assignT3lp(@RequestBody AssignT3lpToGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().assignT3lp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3lp", exc);
    }
  }

  /**
   * unassign T3lp on GovSteamCC
   *
   * @param command UnAssignT3lpFromGovSteamCCCommand
   */
  @PutMapping("/unAssignT3lp")
  public void unAssignT3lp(
      @RequestBody(required = true) UnAssignT3lpFromGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().unAssignT3lp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3lp", exc);
    }
  }

  /**
   * save T4hp on GovSteamCC
   *
   * @param command AssignT4hpToGovSteamCCCommand
   */
  @PutMapping("/assignT4hp")
  public void assignT4hp(@RequestBody AssignT4hpToGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().assignT4hp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4hp", exc);
    }
  }

  /**
   * unassign T4hp on GovSteamCC
   *
   * @param command UnAssignT4hpFromGovSteamCCCommand
   */
  @PutMapping("/unAssignT4hp")
  public void unAssignT4hp(
      @RequestBody(required = true) UnAssignT4hpFromGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().unAssignT4hp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4hp", exc);
    }
  }

  /**
   * save T4lp on GovSteamCC
   *
   * @param command AssignT4lpToGovSteamCCCommand
   */
  @PutMapping("/assignT4lp")
  public void assignT4lp(@RequestBody AssignT4lpToGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().assignT4lp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4lp", exc);
    }
  }

  /**
   * unassign T4lp on GovSteamCC
   *
   * @param command UnAssignT4lpFromGovSteamCCCommand
   */
  @PutMapping("/unAssignT4lp")
  public void unAssignT4lp(
      @RequestBody(required = true) UnAssignT4lpFromGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().unAssignT4lp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4lp", exc);
    }
  }

  /**
   * save T5hp on GovSteamCC
   *
   * @param command AssignT5hpToGovSteamCCCommand
   */
  @PutMapping("/assignT5hp")
  public void assignT5hp(@RequestBody AssignT5hpToGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().assignT5hp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T5hp", exc);
    }
  }

  /**
   * unassign T5hp on GovSteamCC
   *
   * @param command UnAssignT5hpFromGovSteamCCCommand
   */
  @PutMapping("/unAssignT5hp")
  public void unAssignT5hp(
      @RequestBody(required = true) UnAssignT5hpFromGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().unAssignT5hp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T5hp", exc);
    }
  }

  /**
   * save T5lp on GovSteamCC
   *
   * @param command AssignT5lpToGovSteamCCCommand
   */
  @PutMapping("/assignT5lp")
  public void assignT5lp(@RequestBody AssignT5lpToGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().assignT5lp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T5lp", exc);
    }
  }

  /**
   * unassign T5lp on GovSteamCC
   *
   * @param command UnAssignT5lpFromGovSteamCCCommand
   */
  @PutMapping("/unAssignT5lp")
  public void unAssignT5lp(
      @RequestBody(required = true) UnAssignT5lpFromGovSteamCCCommand command) {
    try {
      GovSteamCCBusinessDelegate.getGovSteamCCInstance().unAssignT5lp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T5lp", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovSteamCC govSteamCC = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovSteamCCCommandRestController.class.getName());
}
