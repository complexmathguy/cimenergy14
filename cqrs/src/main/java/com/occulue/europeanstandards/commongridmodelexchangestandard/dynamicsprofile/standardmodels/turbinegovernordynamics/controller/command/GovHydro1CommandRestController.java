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
 * Implements Spring Controller command CQRS processing for entity GovHydro1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydro1")
public class GovHydro1CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovHydro1. if not key provided, calls create, otherwise calls save
   *
   * @param GovHydro1 govHydro1
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovHydro1Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = GovHydro1BusinessDelegate.getGovHydro1Instance().createGovHydro1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovHydro1. if no key provided, calls create, otherwise calls save
   *
   * @param GovHydro1 govHydro1
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovHydro1Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovHydro1Command
      // -----------------------------------------------
      completableFuture = GovHydro1BusinessDelegate.getGovHydro1Instance().updateGovHydro1(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovHydro1Controller:update() - successfully update GovHydro1 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovHydro1 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govHydro1Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovHydro1Command command = new DeleteGovHydro1Command(govHydro1Id);

    try {
      GovHydro1BusinessDelegate delegate = GovHydro1BusinessDelegate.getGovHydro1Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovHydro1 with key " + command.getGovHydro1Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save At on GovHydro1
   *
   * @param command AssignAtToGovHydro1Command
   */
  @PutMapping("/assignAt")
  public void assignAt(@RequestBody AssignAtToGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().assignAt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign At", exc);
    }
  }

  /**
   * unassign At on GovHydro1
   *
   * @param command UnAssignAtFromGovHydro1Command
   */
  @PutMapping("/unAssignAt")
  public void unAssignAt(@RequestBody(required = true) UnAssignAtFromGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().unAssignAt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign At", exc);
    }
  }

  /**
   * save Dturb on GovHydro1
   *
   * @param command AssignDturbToGovHydro1Command
   */
  @PutMapping("/assignDturb")
  public void assignDturb(@RequestBody AssignDturbToGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().assignDturb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dturb", exc);
    }
  }

  /**
   * unassign Dturb on GovHydro1
   *
   * @param command UnAssignDturbFromGovHydro1Command
   */
  @PutMapping("/unAssignDturb")
  public void unAssignDturb(
      @RequestBody(required = true) UnAssignDturbFromGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().unAssignDturb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dturb", exc);
    }
  }

  /**
   * save Gmax on GovHydro1
   *
   * @param command AssignGmaxToGovHydro1Command
   */
  @PutMapping("/assignGmax")
  public void assignGmax(@RequestBody AssignGmaxToGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().assignGmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gmax", exc);
    }
  }

  /**
   * unassign Gmax on GovHydro1
   *
   * @param command UnAssignGmaxFromGovHydro1Command
   */
  @PutMapping("/unAssignGmax")
  public void unAssignGmax(@RequestBody(required = true) UnAssignGmaxFromGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().unAssignGmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gmax", exc);
    }
  }

  /**
   * save Gmin on GovHydro1
   *
   * @param command AssignGminToGovHydro1Command
   */
  @PutMapping("/assignGmin")
  public void assignGmin(@RequestBody AssignGminToGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().assignGmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gmin", exc);
    }
  }

  /**
   * unassign Gmin on GovHydro1
   *
   * @param command UnAssignGminFromGovHydro1Command
   */
  @PutMapping("/unAssignGmin")
  public void unAssignGmin(@RequestBody(required = true) UnAssignGminFromGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().unAssignGmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gmin", exc);
    }
  }

  /**
   * save Hdam on GovHydro1
   *
   * @param command AssignHdamToGovHydro1Command
   */
  @PutMapping("/assignHdam")
  public void assignHdam(@RequestBody AssignHdamToGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().assignHdam(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Hdam", exc);
    }
  }

  /**
   * unassign Hdam on GovHydro1
   *
   * @param command UnAssignHdamFromGovHydro1Command
   */
  @PutMapping("/unAssignHdam")
  public void unAssignHdam(@RequestBody(required = true) UnAssignHdamFromGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().unAssignHdam(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Hdam", exc);
    }
  }

  /**
   * save Mwbase on GovHydro1
   *
   * @param command AssignMwbaseToGovHydro1Command
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovHydro1
   *
   * @param command UnAssignMwbaseFromGovHydro1Command
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save Qnl on GovHydro1
   *
   * @param command AssignQnlToGovHydro1Command
   */
  @PutMapping("/assignQnl")
  public void assignQnl(@RequestBody AssignQnlToGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().assignQnl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Qnl", exc);
    }
  }

  /**
   * unassign Qnl on GovHydro1
   *
   * @param command UnAssignQnlFromGovHydro1Command
   */
  @PutMapping("/unAssignQnl")
  public void unAssignQnl(@RequestBody(required = true) UnAssignQnlFromGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().unAssignQnl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Qnl", exc);
    }
  }

  /**
   * save Rperm on GovHydro1
   *
   * @param command AssignRpermToGovHydro1Command
   */
  @PutMapping("/assignRperm")
  public void assignRperm(@RequestBody AssignRpermToGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().assignRperm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rperm", exc);
    }
  }

  /**
   * unassign Rperm on GovHydro1
   *
   * @param command UnAssignRpermFromGovHydro1Command
   */
  @PutMapping("/unAssignRperm")
  public void unAssignRperm(
      @RequestBody(required = true) UnAssignRpermFromGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().unAssignRperm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rperm", exc);
    }
  }

  /**
   * save Rtemp on GovHydro1
   *
   * @param command AssignRtempToGovHydro1Command
   */
  @PutMapping("/assignRtemp")
  public void assignRtemp(@RequestBody AssignRtempToGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().assignRtemp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rtemp", exc);
    }
  }

  /**
   * unassign Rtemp on GovHydro1
   *
   * @param command UnAssignRtempFromGovHydro1Command
   */
  @PutMapping("/unAssignRtemp")
  public void unAssignRtemp(
      @RequestBody(required = true) UnAssignRtempFromGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().unAssignRtemp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rtemp", exc);
    }
  }

  /**
   * save Tf on GovHydro1
   *
   * @param command AssignTfToGovHydro1Command
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on GovHydro1
   *
   * @param command UnAssignTfFromGovHydro1Command
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Tg on GovHydro1
   *
   * @param command AssignTgToGovHydro1Command
   */
  @PutMapping("/assignTg")
  public void assignTg(@RequestBody AssignTgToGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().assignTg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tg", exc);
    }
  }

  /**
   * unassign Tg on GovHydro1
   *
   * @param command UnAssignTgFromGovHydro1Command
   */
  @PutMapping("/unAssignTg")
  public void unAssignTg(@RequestBody(required = true) UnAssignTgFromGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().unAssignTg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tg", exc);
    }
  }

  /**
   * save Tr on GovHydro1
   *
   * @param command AssignTrToGovHydro1Command
   */
  @PutMapping("/assignTr")
  public void assignTr(@RequestBody AssignTrToGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().assignTr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tr", exc);
    }
  }

  /**
   * unassign Tr on GovHydro1
   *
   * @param command UnAssignTrFromGovHydro1Command
   */
  @PutMapping("/unAssignTr")
  public void unAssignTr(@RequestBody(required = true) UnAssignTrFromGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().unAssignTr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tr", exc);
    }
  }

  /**
   * save Tw on GovHydro1
   *
   * @param command AssignTwToGovHydro1Command
   */
  @PutMapping("/assignTw")
  public void assignTw(@RequestBody AssignTwToGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().assignTw(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw", exc);
    }
  }

  /**
   * unassign Tw on GovHydro1
   *
   * @param command UnAssignTwFromGovHydro1Command
   */
  @PutMapping("/unAssignTw")
  public void unAssignTw(@RequestBody(required = true) UnAssignTwFromGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().unAssignTw(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw", exc);
    }
  }

  /**
   * save Velm on GovHydro1
   *
   * @param command AssignVelmToGovHydro1Command
   */
  @PutMapping("/assignVelm")
  public void assignVelm(@RequestBody AssignVelmToGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().assignVelm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Velm", exc);
    }
  }

  /**
   * unassign Velm on GovHydro1
   *
   * @param command UnAssignVelmFromGovHydro1Command
   */
  @PutMapping("/unAssignVelm")
  public void unAssignVelm(@RequestBody(required = true) UnAssignVelmFromGovHydro1Command command) {
    try {
      GovHydro1BusinessDelegate.getGovHydro1Instance().unAssignVelm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Velm", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovHydro1 govHydro1 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovHydro1CommandRestController.class.getName());
}
