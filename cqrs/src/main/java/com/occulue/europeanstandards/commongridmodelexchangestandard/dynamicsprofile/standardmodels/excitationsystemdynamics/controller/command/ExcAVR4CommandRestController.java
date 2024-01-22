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
 * Implements Spring Controller command CQRS processing for entity ExcAVR4.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAVR4")
public class ExcAVR4CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcAVR4. if not key provided, calls create, otherwise calls save
   *
   * @param ExcAVR4 excAVR4
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcAVR4Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcAVR4BusinessDelegate.getExcAVR4Instance().createExcAVR4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcAVR4. if no key provided, calls create, otherwise calls save
   *
   * @param ExcAVR4 excAVR4
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcAVR4Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcAVR4Command
      // -----------------------------------------------
      completableFuture = ExcAVR4BusinessDelegate.getExcAVR4Instance().updateExcAVR4(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcAVR4Controller:update() - successfully update ExcAVR4 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcAVR4 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excAVR4Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcAVR4Command command = new DeleteExcAVR4Command(excAVR4Id);

    try {
      ExcAVR4BusinessDelegate delegate = ExcAVR4BusinessDelegate.getExcAVR4Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcAVR4 with key " + command.getExcAVR4Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Imul on ExcAVR4
   *
   * @param command AssignImulToExcAVR4Command
   */
  @PutMapping("/assignImul")
  public void assignImul(@RequestBody AssignImulToExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().assignImul(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Imul", exc);
    }
  }

  /**
   * unassign Imul on ExcAVR4
   *
   * @param command UnAssignImulFromExcAVR4Command
   */
  @PutMapping("/unAssignImul")
  public void unAssignImul(@RequestBody(required = true) UnAssignImulFromExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().unAssignImul(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Imul", exc);
    }
  }

  /**
   * save Ka on ExcAVR4
   *
   * @param command AssignKaToExcAVR4Command
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcAVR4
   *
   * @param command UnAssignKaFromExcAVR4Command
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Ke on ExcAVR4
   *
   * @param command AssignKeToExcAVR4Command
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcAVR4
   *
   * @param command UnAssignKeFromExcAVR4Command
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kif on ExcAVR4
   *
   * @param command AssignKifToExcAVR4Command
   */
  @PutMapping("/assignKif")
  public void assignKif(@RequestBody AssignKifToExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().assignKif(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kif", exc);
    }
  }

  /**
   * unassign Kif on ExcAVR4
   *
   * @param command UnAssignKifFromExcAVR4Command
   */
  @PutMapping("/unAssignKif")
  public void unAssignKif(@RequestBody(required = true) UnAssignKifFromExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().unAssignKif(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kif", exc);
    }
  }

  /**
   * save T1 on ExcAVR4
   *
   * @param command AssignT1ToExcAVR4Command
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on ExcAVR4
   *
   * @param command UnAssignT1FromExcAVR4Command
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T1if on ExcAVR4
   *
   * @param command AssignT1ifToExcAVR4Command
   */
  @PutMapping("/assignT1if")
  public void assignT1if(@RequestBody AssignT1ifToExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().assignT1if(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1if", exc);
    }
  }

  /**
   * unassign T1if on ExcAVR4
   *
   * @param command UnAssignT1ifFromExcAVR4Command
   */
  @PutMapping("/unAssignT1if")
  public void unAssignT1if(@RequestBody(required = true) UnAssignT1ifFromExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().unAssignT1if(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1if", exc);
    }
  }

  /**
   * save T2 on ExcAVR4
   *
   * @param command AssignT2ToExcAVR4Command
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on ExcAVR4
   *
   * @param command UnAssignT2FromExcAVR4Command
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on ExcAVR4
   *
   * @param command AssignT3ToExcAVR4Command
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on ExcAVR4
   *
   * @param command UnAssignT3FromExcAVR4Command
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on ExcAVR4
   *
   * @param command AssignT4ToExcAVR4Command
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on ExcAVR4
   *
   * @param command UnAssignT4FromExcAVR4Command
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save Tif on ExcAVR4
   *
   * @param command AssignTifToExcAVR4Command
   */
  @PutMapping("/assignTif")
  public void assignTif(@RequestBody AssignTifToExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().assignTif(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tif", exc);
    }
  }

  /**
   * unassign Tif on ExcAVR4
   *
   * @param command UnAssignTifFromExcAVR4Command
   */
  @PutMapping("/unAssignTif")
  public void unAssignTif(@RequestBody(required = true) UnAssignTifFromExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().unAssignTif(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tif", exc);
    }
  }

  /**
   * save Vfmn on ExcAVR4
   *
   * @param command AssignVfmnToExcAVR4Command
   */
  @PutMapping("/assignVfmn")
  public void assignVfmn(@RequestBody AssignVfmnToExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().assignVfmn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vfmn", exc);
    }
  }

  /**
   * unassign Vfmn on ExcAVR4
   *
   * @param command UnAssignVfmnFromExcAVR4Command
   */
  @PutMapping("/unAssignVfmn")
  public void unAssignVfmn(@RequestBody(required = true) UnAssignVfmnFromExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().unAssignVfmn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vfmn", exc);
    }
  }

  /**
   * save Vfmx on ExcAVR4
   *
   * @param command AssignVfmxToExcAVR4Command
   */
  @PutMapping("/assignVfmx")
  public void assignVfmx(@RequestBody AssignVfmxToExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().assignVfmx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vfmx", exc);
    }
  }

  /**
   * unassign Vfmx on ExcAVR4
   *
   * @param command UnAssignVfmxFromExcAVR4Command
   */
  @PutMapping("/unAssignVfmx")
  public void unAssignVfmx(@RequestBody(required = true) UnAssignVfmxFromExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().unAssignVfmx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vfmx", exc);
    }
  }

  /**
   * save Vrmn on ExcAVR4
   *
   * @param command AssignVrmnToExcAVR4Command
   */
  @PutMapping("/assignVrmn")
  public void assignVrmn(@RequestBody AssignVrmnToExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().assignVrmn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmn", exc);
    }
  }

  /**
   * unassign Vrmn on ExcAVR4
   *
   * @param command UnAssignVrmnFromExcAVR4Command
   */
  @PutMapping("/unAssignVrmn")
  public void unAssignVrmn(@RequestBody(required = true) UnAssignVrmnFromExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().unAssignVrmn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmn", exc);
    }
  }

  /**
   * save Vrmx on ExcAVR4
   *
   * @param command AssignVrmxToExcAVR4Command
   */
  @PutMapping("/assignVrmx")
  public void assignVrmx(@RequestBody AssignVrmxToExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().assignVrmx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmx", exc);
    }
  }

  /**
   * unassign Vrmx on ExcAVR4
   *
   * @param command UnAssignVrmxFromExcAVR4Command
   */
  @PutMapping("/unAssignVrmx")
  public void unAssignVrmx(@RequestBody(required = true) UnAssignVrmxFromExcAVR4Command command) {
    try {
      ExcAVR4BusinessDelegate.getExcAVR4Instance().unAssignVrmx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmx", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcAVR4 excAVR4 = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcAVR4CommandRestController.class.getName());
}
