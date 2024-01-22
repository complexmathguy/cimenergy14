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
 * Implements Spring Controller command CQRS processing for entity GovHydroPID2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroPID2")
public class GovHydroPID2CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovHydroPID2. if not key provided, calls create, otherwise calls save
   *
   * @param GovHydroPID2 govHydroPID2
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovHydroPID2Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().createGovHydroPID2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovHydroPID2. if no key provided, calls create, otherwise calls save
   *
   * @param GovHydroPID2 govHydroPID2
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovHydroPID2Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovHydroPID2Command
      // -----------------------------------------------
      completableFuture =
          GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().updateGovHydroPID2(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovHydroPID2Controller:update() - successfully update GovHydroPID2 - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovHydroPID2 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govHydroPID2Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovHydroPID2Command command = new DeleteGovHydroPID2Command(govHydroPID2Id);

    try {
      GovHydroPID2BusinessDelegate delegate =
          GovHydroPID2BusinessDelegate.getGovHydroPID2Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted GovHydroPID2 with key " + command.getGovHydroPID2Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Atw on GovHydroPID2
   *
   * @param command AssignAtwToGovHydroPID2Command
   */
  @PutMapping("/assignAtw")
  public void assignAtw(@RequestBody AssignAtwToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignAtw(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Atw", exc);
    }
  }

  /**
   * unassign Atw on GovHydroPID2
   *
   * @param command UnAssignAtwFromGovHydroPID2Command
   */
  @PutMapping("/unAssignAtw")
  public void unAssignAtw(
      @RequestBody(required = true) UnAssignAtwFromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignAtw(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Atw", exc);
    }
  }

  /**
   * save D on GovHydroPID2
   *
   * @param command AssignDToGovHydroPID2Command
   */
  @PutMapping("/assignD")
  public void assignD(@RequestBody AssignDToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignD(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign D", exc);
    }
  }

  /**
   * unassign D on GovHydroPID2
   *
   * @param command UnAssignDFromGovHydroPID2Command
   */
  @PutMapping("/unAssignD")
  public void unAssignD(@RequestBody(required = true) UnAssignDFromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignD(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign D", exc);
    }
  }

  /**
   * save FeedbackSignal on GovHydroPID2
   *
   * @param command AssignFeedbackSignalToGovHydroPID2Command
   */
  @PutMapping("/assignFeedbackSignal")
  public void assignFeedbackSignal(@RequestBody AssignFeedbackSignalToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignFeedbackSignal(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign FeedbackSignal", exc);
    }
  }

  /**
   * unassign FeedbackSignal on GovHydroPID2
   *
   * @param command UnAssignFeedbackSignalFromGovHydroPID2Command
   */
  @PutMapping("/unAssignFeedbackSignal")
  public void unAssignFeedbackSignal(
      @RequestBody(required = true) UnAssignFeedbackSignalFromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignFeedbackSignal(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign FeedbackSignal", exc);
    }
  }

  /**
   * save G0 on GovHydroPID2
   *
   * @param command AssignG0ToGovHydroPID2Command
   */
  @PutMapping("/assignG0")
  public void assignG0(@RequestBody AssignG0ToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignG0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign G0", exc);
    }
  }

  /**
   * unassign G0 on GovHydroPID2
   *
   * @param command UnAssignG0FromGovHydroPID2Command
   */
  @PutMapping("/unAssignG0")
  public void unAssignG0(@RequestBody(required = true) UnAssignG0FromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignG0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign G0", exc);
    }
  }

  /**
   * save G1 on GovHydroPID2
   *
   * @param command AssignG1ToGovHydroPID2Command
   */
  @PutMapping("/assignG1")
  public void assignG1(@RequestBody AssignG1ToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignG1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign G1", exc);
    }
  }

  /**
   * unassign G1 on GovHydroPID2
   *
   * @param command UnAssignG1FromGovHydroPID2Command
   */
  @PutMapping("/unAssignG1")
  public void unAssignG1(@RequestBody(required = true) UnAssignG1FromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignG1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign G1", exc);
    }
  }

  /**
   * save G2 on GovHydroPID2
   *
   * @param command AssignG2ToGovHydroPID2Command
   */
  @PutMapping("/assignG2")
  public void assignG2(@RequestBody AssignG2ToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignG2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign G2", exc);
    }
  }

  /**
   * unassign G2 on GovHydroPID2
   *
   * @param command UnAssignG2FromGovHydroPID2Command
   */
  @PutMapping("/unAssignG2")
  public void unAssignG2(@RequestBody(required = true) UnAssignG2FromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignG2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign G2", exc);
    }
  }

  /**
   * save Gmax on GovHydroPID2
   *
   * @param command AssignGmaxToGovHydroPID2Command
   */
  @PutMapping("/assignGmax")
  public void assignGmax(@RequestBody AssignGmaxToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignGmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gmax", exc);
    }
  }

  /**
   * unassign Gmax on GovHydroPID2
   *
   * @param command UnAssignGmaxFromGovHydroPID2Command
   */
  @PutMapping("/unAssignGmax")
  public void unAssignGmax(
      @RequestBody(required = true) UnAssignGmaxFromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignGmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gmax", exc);
    }
  }

  /**
   * save Gmin on GovHydroPID2
   *
   * @param command AssignGminToGovHydroPID2Command
   */
  @PutMapping("/assignGmin")
  public void assignGmin(@RequestBody AssignGminToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignGmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gmin", exc);
    }
  }

  /**
   * unassign Gmin on GovHydroPID2
   *
   * @param command UnAssignGminFromGovHydroPID2Command
   */
  @PutMapping("/unAssignGmin")
  public void unAssignGmin(
      @RequestBody(required = true) UnAssignGminFromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignGmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gmin", exc);
    }
  }

  /**
   * save Kd on GovHydroPID2
   *
   * @param command AssignKdToGovHydroPID2Command
   */
  @PutMapping("/assignKd")
  public void assignKd(@RequestBody AssignKdToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignKd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd", exc);
    }
  }

  /**
   * unassign Kd on GovHydroPID2
   *
   * @param command UnAssignKdFromGovHydroPID2Command
   */
  @PutMapping("/unAssignKd")
  public void unAssignKd(@RequestBody(required = true) UnAssignKdFromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignKd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd", exc);
    }
  }

  /**
   * save Ki on GovHydroPID2
   *
   * @param command AssignKiToGovHydroPID2Command
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on GovHydroPID2
   *
   * @param command UnAssignKiFromGovHydroPID2Command
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(@RequestBody(required = true) UnAssignKiFromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Kp on GovHydroPID2
   *
   * @param command AssignKpToGovHydroPID2Command
   */
  @PutMapping("/assignKp")
  public void assignKp(@RequestBody AssignKpToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignKp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp", exc);
    }
  }

  /**
   * unassign Kp on GovHydroPID2
   *
   * @param command UnAssignKpFromGovHydroPID2Command
   */
  @PutMapping("/unAssignKp")
  public void unAssignKp(@RequestBody(required = true) UnAssignKpFromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignKp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp", exc);
    }
  }

  /**
   * save Mwbase on GovHydroPID2
   *
   * @param command AssignMwbaseToGovHydroPID2Command
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovHydroPID2
   *
   * @param command UnAssignMwbaseFromGovHydroPID2Command
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save P1 on GovHydroPID2
   *
   * @param command AssignP1ToGovHydroPID2Command
   */
  @PutMapping("/assignP1")
  public void assignP1(@RequestBody AssignP1ToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignP1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign P1", exc);
    }
  }

  /**
   * unassign P1 on GovHydroPID2
   *
   * @param command UnAssignP1FromGovHydroPID2Command
   */
  @PutMapping("/unAssignP1")
  public void unAssignP1(@RequestBody(required = true) UnAssignP1FromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignP1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign P1", exc);
    }
  }

  /**
   * save P2 on GovHydroPID2
   *
   * @param command AssignP2ToGovHydroPID2Command
   */
  @PutMapping("/assignP2")
  public void assignP2(@RequestBody AssignP2ToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignP2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign P2", exc);
    }
  }

  /**
   * unassign P2 on GovHydroPID2
   *
   * @param command UnAssignP2FromGovHydroPID2Command
   */
  @PutMapping("/unAssignP2")
  public void unAssignP2(@RequestBody(required = true) UnAssignP2FromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignP2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign P2", exc);
    }
  }

  /**
   * save P3 on GovHydroPID2
   *
   * @param command AssignP3ToGovHydroPID2Command
   */
  @PutMapping("/assignP3")
  public void assignP3(@RequestBody AssignP3ToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignP3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign P3", exc);
    }
  }

  /**
   * unassign P3 on GovHydroPID2
   *
   * @param command UnAssignP3FromGovHydroPID2Command
   */
  @PutMapping("/unAssignP3")
  public void unAssignP3(@RequestBody(required = true) UnAssignP3FromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignP3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign P3", exc);
    }
  }

  /**
   * save Rperm on GovHydroPID2
   *
   * @param command AssignRpermToGovHydroPID2Command
   */
  @PutMapping("/assignRperm")
  public void assignRperm(@RequestBody AssignRpermToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignRperm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rperm", exc);
    }
  }

  /**
   * unassign Rperm on GovHydroPID2
   *
   * @param command UnAssignRpermFromGovHydroPID2Command
   */
  @PutMapping("/unAssignRperm")
  public void unAssignRperm(
      @RequestBody(required = true) UnAssignRpermFromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignRperm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rperm", exc);
    }
  }

  /**
   * save Ta on GovHydroPID2
   *
   * @param command AssignTaToGovHydroPID2Command
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on GovHydroPID2
   *
   * @param command UnAssignTaFromGovHydroPID2Command
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on GovHydroPID2
   *
   * @param command AssignTbToGovHydroPID2Command
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on GovHydroPID2
   *
   * @param command UnAssignTbFromGovHydroPID2Command
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Treg on GovHydroPID2
   *
   * @param command AssignTregToGovHydroPID2Command
   */
  @PutMapping("/assignTreg")
  public void assignTreg(@RequestBody AssignTregToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignTreg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Treg", exc);
    }
  }

  /**
   * unassign Treg on GovHydroPID2
   *
   * @param command UnAssignTregFromGovHydroPID2Command
   */
  @PutMapping("/unAssignTreg")
  public void unAssignTreg(
      @RequestBody(required = true) UnAssignTregFromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignTreg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Treg", exc);
    }
  }

  /**
   * save Tw on GovHydroPID2
   *
   * @param command AssignTwToGovHydroPID2Command
   */
  @PutMapping("/assignTw")
  public void assignTw(@RequestBody AssignTwToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignTw(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw", exc);
    }
  }

  /**
   * unassign Tw on GovHydroPID2
   *
   * @param command UnAssignTwFromGovHydroPID2Command
   */
  @PutMapping("/unAssignTw")
  public void unAssignTw(@RequestBody(required = true) UnAssignTwFromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignTw(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw", exc);
    }
  }

  /**
   * save Velmax on GovHydroPID2
   *
   * @param command AssignVelmaxToGovHydroPID2Command
   */
  @PutMapping("/assignVelmax")
  public void assignVelmax(@RequestBody AssignVelmaxToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignVelmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Velmax", exc);
    }
  }

  /**
   * unassign Velmax on GovHydroPID2
   *
   * @param command UnAssignVelmaxFromGovHydroPID2Command
   */
  @PutMapping("/unAssignVelmax")
  public void unAssignVelmax(
      @RequestBody(required = true) UnAssignVelmaxFromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignVelmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Velmax", exc);
    }
  }

  /**
   * save Velmin on GovHydroPID2
   *
   * @param command AssignVelminToGovHydroPID2Command
   */
  @PutMapping("/assignVelmin")
  public void assignVelmin(@RequestBody AssignVelminToGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().assignVelmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Velmin", exc);
    }
  }

  /**
   * unassign Velmin on GovHydroPID2
   *
   * @param command UnAssignVelminFromGovHydroPID2Command
   */
  @PutMapping("/unAssignVelmin")
  public void unAssignVelmin(
      @RequestBody(required = true) UnAssignVelminFromGovHydroPID2Command command) {
    try {
      GovHydroPID2BusinessDelegate.getGovHydroPID2Instance().unAssignVelmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Velmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovHydroPID2 govHydroPID2 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovHydroPID2CommandRestController.class.getName());
}
