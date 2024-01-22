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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity CsConverter.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/CsConverter")
public class CsConverterCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a CsConverter. if not key provided, calls create, otherwise calls save
   *
   * @param CsConverter csConverter
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateCsConverterCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          CsConverterBusinessDelegate.getCsConverterInstance().createCsConverter(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a CsConverter. if no key provided, calls create, otherwise calls save
   *
   * @param CsConverter csConverter
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateCsConverterCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateCsConverterCommand
      // -----------------------------------------------
      completableFuture =
          CsConverterBusinessDelegate.getCsConverterInstance().updateCsConverter(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "CsConverterController:update() - successfully update CsConverter - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a CsConverter entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID csConverterId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteCsConverterCommand command = new DeleteCsConverterCommand(csConverterId);

    try {
      CsConverterBusinessDelegate delegate = CsConverterBusinessDelegate.getCsConverterInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted CsConverter with key " + command.getCsConverterId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save MaxAlpha on CsConverter
   *
   * @param command AssignMaxAlphaToCsConverterCommand
   */
  @PutMapping("/assignMaxAlpha")
  public void assignMaxAlpha(@RequestBody AssignMaxAlphaToCsConverterCommand command) {
    try {
      CsConverterBusinessDelegate.getCsConverterInstance().assignMaxAlpha(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MaxAlpha", exc);
    }
  }

  /**
   * unassign MaxAlpha on CsConverter
   *
   * @param command UnAssignMaxAlphaFromCsConverterCommand
   */
  @PutMapping("/unAssignMaxAlpha")
  public void unAssignMaxAlpha(
      @RequestBody(required = true) UnAssignMaxAlphaFromCsConverterCommand command) {
    try {
      CsConverterBusinessDelegate.getCsConverterInstance().unAssignMaxAlpha(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MaxAlpha", exc);
    }
  }

  /**
   * save MaxGamma on CsConverter
   *
   * @param command AssignMaxGammaToCsConverterCommand
   */
  @PutMapping("/assignMaxGamma")
  public void assignMaxGamma(@RequestBody AssignMaxGammaToCsConverterCommand command) {
    try {
      CsConverterBusinessDelegate.getCsConverterInstance().assignMaxGamma(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MaxGamma", exc);
    }
  }

  /**
   * unassign MaxGamma on CsConverter
   *
   * @param command UnAssignMaxGammaFromCsConverterCommand
   */
  @PutMapping("/unAssignMaxGamma")
  public void unAssignMaxGamma(
      @RequestBody(required = true) UnAssignMaxGammaFromCsConverterCommand command) {
    try {
      CsConverterBusinessDelegate.getCsConverterInstance().unAssignMaxGamma(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MaxGamma", exc);
    }
  }

  /**
   * save MaxIdc on CsConverter
   *
   * @param command AssignMaxIdcToCsConverterCommand
   */
  @PutMapping("/assignMaxIdc")
  public void assignMaxIdc(@RequestBody AssignMaxIdcToCsConverterCommand command) {
    try {
      CsConverterBusinessDelegate.getCsConverterInstance().assignMaxIdc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MaxIdc", exc);
    }
  }

  /**
   * unassign MaxIdc on CsConverter
   *
   * @param command UnAssignMaxIdcFromCsConverterCommand
   */
  @PutMapping("/unAssignMaxIdc")
  public void unAssignMaxIdc(
      @RequestBody(required = true) UnAssignMaxIdcFromCsConverterCommand command) {
    try {
      CsConverterBusinessDelegate.getCsConverterInstance().unAssignMaxIdc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MaxIdc", exc);
    }
  }

  /**
   * save MinAlpha on CsConverter
   *
   * @param command AssignMinAlphaToCsConverterCommand
   */
  @PutMapping("/assignMinAlpha")
  public void assignMinAlpha(@RequestBody AssignMinAlphaToCsConverterCommand command) {
    try {
      CsConverterBusinessDelegate.getCsConverterInstance().assignMinAlpha(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MinAlpha", exc);
    }
  }

  /**
   * unassign MinAlpha on CsConverter
   *
   * @param command UnAssignMinAlphaFromCsConverterCommand
   */
  @PutMapping("/unAssignMinAlpha")
  public void unAssignMinAlpha(
      @RequestBody(required = true) UnAssignMinAlphaFromCsConverterCommand command) {
    try {
      CsConverterBusinessDelegate.getCsConverterInstance().unAssignMinAlpha(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MinAlpha", exc);
    }
  }

  /**
   * save MinGamma on CsConverter
   *
   * @param command AssignMinGammaToCsConverterCommand
   */
  @PutMapping("/assignMinGamma")
  public void assignMinGamma(@RequestBody AssignMinGammaToCsConverterCommand command) {
    try {
      CsConverterBusinessDelegate.getCsConverterInstance().assignMinGamma(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MinGamma", exc);
    }
  }

  /**
   * unassign MinGamma on CsConverter
   *
   * @param command UnAssignMinGammaFromCsConverterCommand
   */
  @PutMapping("/unAssignMinGamma")
  public void unAssignMinGamma(
      @RequestBody(required = true) UnAssignMinGammaFromCsConverterCommand command) {
    try {
      CsConverterBusinessDelegate.getCsConverterInstance().unAssignMinGamma(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MinGamma", exc);
    }
  }

  /**
   * save MinIdc on CsConverter
   *
   * @param command AssignMinIdcToCsConverterCommand
   */
  @PutMapping("/assignMinIdc")
  public void assignMinIdc(@RequestBody AssignMinIdcToCsConverterCommand command) {
    try {
      CsConverterBusinessDelegate.getCsConverterInstance().assignMinIdc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MinIdc", exc);
    }
  }

  /**
   * unassign MinIdc on CsConverter
   *
   * @param command UnAssignMinIdcFromCsConverterCommand
   */
  @PutMapping("/unAssignMinIdc")
  public void unAssignMinIdc(
      @RequestBody(required = true) UnAssignMinIdcFromCsConverterCommand command) {
    try {
      CsConverterBusinessDelegate.getCsConverterInstance().unAssignMinIdc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MinIdc", exc);
    }
  }

  /**
   * save RatedIdc on CsConverter
   *
   * @param command AssignRatedIdcToCsConverterCommand
   */
  @PutMapping("/assignRatedIdc")
  public void assignRatedIdc(@RequestBody AssignRatedIdcToCsConverterCommand command) {
    try {
      CsConverterBusinessDelegate.getCsConverterInstance().assignRatedIdc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign RatedIdc", exc);
    }
  }

  /**
   * unassign RatedIdc on CsConverter
   *
   * @param command UnAssignRatedIdcFromCsConverterCommand
   */
  @PutMapping("/unAssignRatedIdc")
  public void unAssignRatedIdc(
      @RequestBody(required = true) UnAssignRatedIdcFromCsConverterCommand command) {
    try {
      CsConverterBusinessDelegate.getCsConverterInstance().unAssignRatedIdc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign RatedIdc", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected CsConverter csConverter = null;
  private static final Logger LOGGER =
      Logger.getLogger(CsConverterCommandRestController.class.getName());
}
