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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity Quality61850.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Quality61850")
public class Quality61850CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Quality61850. if not key provided, calls create, otherwise calls save
   *
   * @param Quality61850 quality61850
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateQuality61850Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          Quality61850BusinessDelegate.getQuality61850Instance().createQuality61850(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Quality61850. if no key provided, calls create, otherwise calls save
   *
   * @param Quality61850 quality61850
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateQuality61850Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateQuality61850Command
      // -----------------------------------------------
      completableFuture =
          Quality61850BusinessDelegate.getQuality61850Instance().updateQuality61850(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "Quality61850Controller:update() - successfully update Quality61850 - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Quality61850 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID quality61850Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteQuality61850Command command = new DeleteQuality61850Command(quality61850Id);

    try {
      Quality61850BusinessDelegate delegate =
          Quality61850BusinessDelegate.getQuality61850Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted Quality61850 with key " + command.getQuality61850Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save BadReference on Quality61850
   *
   * @param command AssignBadReferenceToQuality61850Command
   */
  @PutMapping("/assignBadReference")
  public void assignBadReference(@RequestBody AssignBadReferenceToQuality61850Command command) {
    try {
      Quality61850BusinessDelegate.getQuality61850Instance().assignBadReference(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BadReference", exc);
    }
  }

  /**
   * unassign BadReference on Quality61850
   *
   * @param command UnAssignBadReferenceFromQuality61850Command
   */
  @PutMapping("/unAssignBadReference")
  public void unAssignBadReference(
      @RequestBody(required = true) UnAssignBadReferenceFromQuality61850Command command) {
    try {
      Quality61850BusinessDelegate.getQuality61850Instance().unAssignBadReference(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BadReference", exc);
    }
  }

  /**
   * save EstimatorReplaced on Quality61850
   *
   * @param command AssignEstimatorReplacedToQuality61850Command
   */
  @PutMapping("/assignEstimatorReplaced")
  public void assignEstimatorReplaced(
      @RequestBody AssignEstimatorReplacedToQuality61850Command command) {
    try {
      Quality61850BusinessDelegate.getQuality61850Instance().assignEstimatorReplaced(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EstimatorReplaced", exc);
    }
  }

  /**
   * unassign EstimatorReplaced on Quality61850
   *
   * @param command UnAssignEstimatorReplacedFromQuality61850Command
   */
  @PutMapping("/unAssignEstimatorReplaced")
  public void unAssignEstimatorReplaced(
      @RequestBody(required = true) UnAssignEstimatorReplacedFromQuality61850Command command) {
    try {
      Quality61850BusinessDelegate.getQuality61850Instance().unAssignEstimatorReplaced(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EstimatorReplaced", exc);
    }
  }

  /**
   * save Failure on Quality61850
   *
   * @param command AssignFailureToQuality61850Command
   */
  @PutMapping("/assignFailure")
  public void assignFailure(@RequestBody AssignFailureToQuality61850Command command) {
    try {
      Quality61850BusinessDelegate.getQuality61850Instance().assignFailure(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Failure", exc);
    }
  }

  /**
   * unassign Failure on Quality61850
   *
   * @param command UnAssignFailureFromQuality61850Command
   */
  @PutMapping("/unAssignFailure")
  public void unAssignFailure(
      @RequestBody(required = true) UnAssignFailureFromQuality61850Command command) {
    try {
      Quality61850BusinessDelegate.getQuality61850Instance().unAssignFailure(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Failure", exc);
    }
  }

  /**
   * save OldData on Quality61850
   *
   * @param command AssignOldDataToQuality61850Command
   */
  @PutMapping("/assignOldData")
  public void assignOldData(@RequestBody AssignOldDataToQuality61850Command command) {
    try {
      Quality61850BusinessDelegate.getQuality61850Instance().assignOldData(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign OldData", exc);
    }
  }

  /**
   * unassign OldData on Quality61850
   *
   * @param command UnAssignOldDataFromQuality61850Command
   */
  @PutMapping("/unAssignOldData")
  public void unAssignOldData(
      @RequestBody(required = true) UnAssignOldDataFromQuality61850Command command) {
    try {
      Quality61850BusinessDelegate.getQuality61850Instance().unAssignOldData(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign OldData", exc);
    }
  }

  /**
   * save OperatorBlocked on Quality61850
   *
   * @param command AssignOperatorBlockedToQuality61850Command
   */
  @PutMapping("/assignOperatorBlocked")
  public void assignOperatorBlocked(
      @RequestBody AssignOperatorBlockedToQuality61850Command command) {
    try {
      Quality61850BusinessDelegate.getQuality61850Instance().assignOperatorBlocked(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign OperatorBlocked", exc);
    }
  }

  /**
   * unassign OperatorBlocked on Quality61850
   *
   * @param command UnAssignOperatorBlockedFromQuality61850Command
   */
  @PutMapping("/unAssignOperatorBlocked")
  public void unAssignOperatorBlocked(
      @RequestBody(required = true) UnAssignOperatorBlockedFromQuality61850Command command) {
    try {
      Quality61850BusinessDelegate.getQuality61850Instance().unAssignOperatorBlocked(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign OperatorBlocked", exc);
    }
  }

  /**
   * save Oscillatory on Quality61850
   *
   * @param command AssignOscillatoryToQuality61850Command
   */
  @PutMapping("/assignOscillatory")
  public void assignOscillatory(@RequestBody AssignOscillatoryToQuality61850Command command) {
    try {
      Quality61850BusinessDelegate.getQuality61850Instance().assignOscillatory(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Oscillatory", exc);
    }
  }

  /**
   * unassign Oscillatory on Quality61850
   *
   * @param command UnAssignOscillatoryFromQuality61850Command
   */
  @PutMapping("/unAssignOscillatory")
  public void unAssignOscillatory(
      @RequestBody(required = true) UnAssignOscillatoryFromQuality61850Command command) {
    try {
      Quality61850BusinessDelegate.getQuality61850Instance().unAssignOscillatory(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Oscillatory", exc);
    }
  }

  /**
   * save OutOfRange on Quality61850
   *
   * @param command AssignOutOfRangeToQuality61850Command
   */
  @PutMapping("/assignOutOfRange")
  public void assignOutOfRange(@RequestBody AssignOutOfRangeToQuality61850Command command) {
    try {
      Quality61850BusinessDelegate.getQuality61850Instance().assignOutOfRange(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign OutOfRange", exc);
    }
  }

  /**
   * unassign OutOfRange on Quality61850
   *
   * @param command UnAssignOutOfRangeFromQuality61850Command
   */
  @PutMapping("/unAssignOutOfRange")
  public void unAssignOutOfRange(
      @RequestBody(required = true) UnAssignOutOfRangeFromQuality61850Command command) {
    try {
      Quality61850BusinessDelegate.getQuality61850Instance().unAssignOutOfRange(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign OutOfRange", exc);
    }
  }

  /**
   * save OverFlow on Quality61850
   *
   * @param command AssignOverFlowToQuality61850Command
   */
  @PutMapping("/assignOverFlow")
  public void assignOverFlow(@RequestBody AssignOverFlowToQuality61850Command command) {
    try {
      Quality61850BusinessDelegate.getQuality61850Instance().assignOverFlow(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign OverFlow", exc);
    }
  }

  /**
   * unassign OverFlow on Quality61850
   *
   * @param command UnAssignOverFlowFromQuality61850Command
   */
  @PutMapping("/unAssignOverFlow")
  public void unAssignOverFlow(
      @RequestBody(required = true) UnAssignOverFlowFromQuality61850Command command) {
    try {
      Quality61850BusinessDelegate.getQuality61850Instance().unAssignOverFlow(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign OverFlow", exc);
    }
  }

  /**
   * save Suspect on Quality61850
   *
   * @param command AssignSuspectToQuality61850Command
   */
  @PutMapping("/assignSuspect")
  public void assignSuspect(@RequestBody AssignSuspectToQuality61850Command command) {
    try {
      Quality61850BusinessDelegate.getQuality61850Instance().assignSuspect(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Suspect", exc);
    }
  }

  /**
   * unassign Suspect on Quality61850
   *
   * @param command UnAssignSuspectFromQuality61850Command
   */
  @PutMapping("/unAssignSuspect")
  public void unAssignSuspect(
      @RequestBody(required = true) UnAssignSuspectFromQuality61850Command command) {
    try {
      Quality61850BusinessDelegate.getQuality61850Instance().unAssignSuspect(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Suspect", exc);
    }
  }

  /**
   * save Test on Quality61850
   *
   * @param command AssignTestToQuality61850Command
   */
  @PutMapping("/assignTest")
  public void assignTest(@RequestBody AssignTestToQuality61850Command command) {
    try {
      Quality61850BusinessDelegate.getQuality61850Instance().assignTest(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Test", exc);
    }
  }

  /**
   * unassign Test on Quality61850
   *
   * @param command UnAssignTestFromQuality61850Command
   */
  @PutMapping("/unAssignTest")
  public void unAssignTest(
      @RequestBody(required = true) UnAssignTestFromQuality61850Command command) {
    try {
      Quality61850BusinessDelegate.getQuality61850Instance().unAssignTest(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Test", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Quality61850 quality61850 = null;
  private static final Logger LOGGER =
      Logger.getLogger(Quality61850CommandRestController.class.getName());
}
