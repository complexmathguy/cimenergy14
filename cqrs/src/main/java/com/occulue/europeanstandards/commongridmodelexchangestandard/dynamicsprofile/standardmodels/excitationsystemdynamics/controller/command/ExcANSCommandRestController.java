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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity ExcANS.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcANS")
public class ExcANSCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcANS. if not key provided, calls create, otherwise calls save
   *
   * @param ExcANS excANS
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreateExcANSCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcANSBusinessDelegate.getExcANSInstance().createExcANS(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcANS. if no key provided, calls create, otherwise calls save
   *
   * @param ExcANS excANS
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdateExcANSCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcANSCommand
      // -----------------------------------------------
      completableFuture = ExcANSBusinessDelegate.getExcANSInstance().updateExcANS(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcANSController:update() - successfully update ExcANS - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcANS entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excANSId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcANSCommand command = new DeleteExcANSCommand(excANSId);

    try {
      ExcANSBusinessDelegate delegate = ExcANSBusinessDelegate.getExcANSInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcANS with key " + command.getExcANSId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Blint on ExcANS
   *
   * @param command AssignBlintToExcANSCommand
   */
  @PutMapping("/assignBlint")
  public void assignBlint(@RequestBody AssignBlintToExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().assignBlint(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Blint", exc);
    }
  }

  /**
   * unassign Blint on ExcANS
   *
   * @param command UnAssignBlintFromExcANSCommand
   */
  @PutMapping("/unAssignBlint")
  public void unAssignBlint(@RequestBody(required = true) UnAssignBlintFromExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().unAssignBlint(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Blint", exc);
    }
  }

  /**
   * save Ifmn on ExcANS
   *
   * @param command AssignIfmnToExcANSCommand
   */
  @PutMapping("/assignIfmn")
  public void assignIfmn(@RequestBody AssignIfmnToExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().assignIfmn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ifmn", exc);
    }
  }

  /**
   * unassign Ifmn on ExcANS
   *
   * @param command UnAssignIfmnFromExcANSCommand
   */
  @PutMapping("/unAssignIfmn")
  public void unAssignIfmn(@RequestBody(required = true) UnAssignIfmnFromExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().unAssignIfmn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ifmn", exc);
    }
  }

  /**
   * save Ifmx on ExcANS
   *
   * @param command AssignIfmxToExcANSCommand
   */
  @PutMapping("/assignIfmx")
  public void assignIfmx(@RequestBody AssignIfmxToExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().assignIfmx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ifmx", exc);
    }
  }

  /**
   * unassign Ifmx on ExcANS
   *
   * @param command UnAssignIfmxFromExcANSCommand
   */
  @PutMapping("/unAssignIfmx")
  public void unAssignIfmx(@RequestBody(required = true) UnAssignIfmxFromExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().unAssignIfmx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ifmx", exc);
    }
  }

  /**
   * save K2 on ExcANS
   *
   * @param command AssignK2ToExcANSCommand
   */
  @PutMapping("/assignK2")
  public void assignK2(@RequestBody AssignK2ToExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().assignK2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K2", exc);
    }
  }

  /**
   * unassign K2 on ExcANS
   *
   * @param command UnAssignK2FromExcANSCommand
   */
  @PutMapping("/unAssignK2")
  public void unAssignK2(@RequestBody(required = true) UnAssignK2FromExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().unAssignK2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K2", exc);
    }
  }

  /**
   * save K3 on ExcANS
   *
   * @param command AssignK3ToExcANSCommand
   */
  @PutMapping("/assignK3")
  public void assignK3(@RequestBody AssignK3ToExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().assignK3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K3", exc);
    }
  }

  /**
   * unassign K3 on ExcANS
   *
   * @param command UnAssignK3FromExcANSCommand
   */
  @PutMapping("/unAssignK3")
  public void unAssignK3(@RequestBody(required = true) UnAssignK3FromExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().unAssignK3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K3", exc);
    }
  }

  /**
   * save Kce on ExcANS
   *
   * @param command AssignKceToExcANSCommand
   */
  @PutMapping("/assignKce")
  public void assignKce(@RequestBody AssignKceToExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().assignKce(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kce", exc);
    }
  }

  /**
   * unassign Kce on ExcANS
   *
   * @param command UnAssignKceFromExcANSCommand
   */
  @PutMapping("/unAssignKce")
  public void unAssignKce(@RequestBody(required = true) UnAssignKceFromExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().unAssignKce(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kce", exc);
    }
  }

  /**
   * save Krvecc on ExcANS
   *
   * @param command AssignKrveccToExcANSCommand
   */
  @PutMapping("/assignKrvecc")
  public void assignKrvecc(@RequestBody AssignKrveccToExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().assignKrvecc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Krvecc", exc);
    }
  }

  /**
   * unassign Krvecc on ExcANS
   *
   * @param command UnAssignKrveccFromExcANSCommand
   */
  @PutMapping("/unAssignKrvecc")
  public void unAssignKrvecc(
      @RequestBody(required = true) UnAssignKrveccFromExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().unAssignKrvecc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Krvecc", exc);
    }
  }

  /**
   * save Kvfif on ExcANS
   *
   * @param command AssignKvfifToExcANSCommand
   */
  @PutMapping("/assignKvfif")
  public void assignKvfif(@RequestBody AssignKvfifToExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().assignKvfif(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kvfif", exc);
    }
  }

  /**
   * unassign Kvfif on ExcANS
   *
   * @param command UnAssignKvfifFromExcANSCommand
   */
  @PutMapping("/unAssignKvfif")
  public void unAssignKvfif(@RequestBody(required = true) UnAssignKvfifFromExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().unAssignKvfif(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kvfif", exc);
    }
  }

  /**
   * save T1 on ExcANS
   *
   * @param command AssignT1ToExcANSCommand
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on ExcANS
   *
   * @param command UnAssignT1FromExcANSCommand
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on ExcANS
   *
   * @param command AssignT2ToExcANSCommand
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on ExcANS
   *
   * @param command UnAssignT2FromExcANSCommand
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on ExcANS
   *
   * @param command AssignT3ToExcANSCommand
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on ExcANS
   *
   * @param command UnAssignT3FromExcANSCommand
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save Tb on ExcANS
   *
   * @param command AssignTbToExcANSCommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcANS
   *
   * @param command UnAssignTbFromExcANSCommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Vrmn on ExcANS
   *
   * @param command AssignVrmnToExcANSCommand
   */
  @PutMapping("/assignVrmn")
  public void assignVrmn(@RequestBody AssignVrmnToExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().assignVrmn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmn", exc);
    }
  }

  /**
   * unassign Vrmn on ExcANS
   *
   * @param command UnAssignVrmnFromExcANSCommand
   */
  @PutMapping("/unAssignVrmn")
  public void unAssignVrmn(@RequestBody(required = true) UnAssignVrmnFromExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().unAssignVrmn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmn", exc);
    }
  }

  /**
   * save Vrmx on ExcANS
   *
   * @param command AssignVrmxToExcANSCommand
   */
  @PutMapping("/assignVrmx")
  public void assignVrmx(@RequestBody AssignVrmxToExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().assignVrmx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmx", exc);
    }
  }

  /**
   * unassign Vrmx on ExcANS
   *
   * @param command UnAssignVrmxFromExcANSCommand
   */
  @PutMapping("/unAssignVrmx")
  public void unAssignVrmx(@RequestBody(required = true) UnAssignVrmxFromExcANSCommand command) {
    try {
      ExcANSBusinessDelegate.getExcANSInstance().unAssignVrmx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmx", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcANS excANS = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcANSCommandRestController.class.getName());
}
