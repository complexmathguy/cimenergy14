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
package com.occulue.europeanstandards.commongridmodelexchangestandard.steadystatehypothesisprofile.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity SteadyStateHypothesisVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SteadyStateHypothesisVersion")
public class SteadyStateHypothesisVersionCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a SteadyStateHypothesisVersion. if not key provided, calls create, otherwise
   * calls save
   *
   * @param SteadyStateHypothesisVersion steadyStateHypothesisVersion
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateSteadyStateHypothesisVersionCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
              .createSteadyStateHypothesisVersion(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a SteadyStateHypothesisVersion. if no key provided, calls create, otherwise
   * calls save
   *
   * @param SteadyStateHypothesisVersion steadyStateHypothesisVersion
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateSteadyStateHypothesisVersionCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateSteadyStateHypothesisVersionCommand
      // -----------------------------------------------
      completableFuture =
          SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
              .updateSteadyStateHypothesisVersion(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "SteadyStateHypothesisVersionController:update() - successfully update SteadyStateHypothesisVersion - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a SteadyStateHypothesisVersion entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID steadyStateHypothesisVersionId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteSteadyStateHypothesisVersionCommand command =
        new DeleteSteadyStateHypothesisVersionCommand(steadyStateHypothesisVersionId);

    try {
      SteadyStateHypothesisVersionBusinessDelegate delegate =
          SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted SteadyStateHypothesisVersion with key "
              + command.getSteadyStateHypothesisVersionId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save BaseUML on SteadyStateHypothesisVersion
   *
   * @param command AssignBaseUMLToSteadyStateHypothesisVersionCommand
   */
  @PutMapping("/assignBaseUML")
  public void assignBaseUML(
      @RequestBody AssignBaseUMLToSteadyStateHypothesisVersionCommand command) {
    try {
      SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
          .assignBaseUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseUML", exc);
    }
  }

  /**
   * unassign BaseUML on SteadyStateHypothesisVersion
   *
   * @param command UnAssignBaseUMLFromSteadyStateHypothesisVersionCommand
   */
  @PutMapping("/unAssignBaseUML")
  public void unAssignBaseUML(
      @RequestBody(required = true)
          UnAssignBaseUMLFromSteadyStateHypothesisVersionCommand command) {
    try {
      SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
          .unAssignBaseUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseUML", exc);
    }
  }

  /**
   * save BaseURI on SteadyStateHypothesisVersion
   *
   * @param command AssignBaseURIToSteadyStateHypothesisVersionCommand
   */
  @PutMapping("/assignBaseURI")
  public void assignBaseURI(
      @RequestBody AssignBaseURIToSteadyStateHypothesisVersionCommand command) {
    try {
      SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
          .assignBaseURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseURI", exc);
    }
  }

  /**
   * unassign BaseURI on SteadyStateHypothesisVersion
   *
   * @param command UnAssignBaseURIFromSteadyStateHypothesisVersionCommand
   */
  @PutMapping("/unAssignBaseURI")
  public void unAssignBaseURI(
      @RequestBody(required = true)
          UnAssignBaseURIFromSteadyStateHypothesisVersionCommand command) {
    try {
      SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
          .unAssignBaseURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseURI", exc);
    }
  }

  /**
   * save Date on SteadyStateHypothesisVersion
   *
   * @param command AssignDateToSteadyStateHypothesisVersionCommand
   */
  @PutMapping("/assignDate")
  public void assignDate(@RequestBody AssignDateToSteadyStateHypothesisVersionCommand command) {
    try {
      SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
          .assignDate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Date", exc);
    }
  }

  /**
   * unassign Date on SteadyStateHypothesisVersion
   *
   * @param command UnAssignDateFromSteadyStateHypothesisVersionCommand
   */
  @PutMapping("/unAssignDate")
  public void unAssignDate(
      @RequestBody(required = true) UnAssignDateFromSteadyStateHypothesisVersionCommand command) {
    try {
      SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
          .unAssignDate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Date", exc);
    }
  }

  /**
   * save DifferenceModelURI on SteadyStateHypothesisVersion
   *
   * @param command AssignDifferenceModelURIToSteadyStateHypothesisVersionCommand
   */
  @PutMapping("/assignDifferenceModelURI")
  public void assignDifferenceModelURI(
      @RequestBody AssignDifferenceModelURIToSteadyStateHypothesisVersionCommand command) {
    try {
      SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
          .assignDifferenceModelURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign DifferenceModelURI", exc);
    }
  }

  /**
   * unassign DifferenceModelURI on SteadyStateHypothesisVersion
   *
   * @param command UnAssignDifferenceModelURIFromSteadyStateHypothesisVersionCommand
   */
  @PutMapping("/unAssignDifferenceModelURI")
  public void unAssignDifferenceModelURI(
      @RequestBody(required = true)
          UnAssignDifferenceModelURIFromSteadyStateHypothesisVersionCommand command) {
    try {
      SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
          .unAssignDifferenceModelURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign DifferenceModelURI", exc);
    }
  }

  /**
   * save EntsoeUML on SteadyStateHypothesisVersion
   *
   * @param command AssignEntsoeUMLToSteadyStateHypothesisVersionCommand
   */
  @PutMapping("/assignEntsoeUML")
  public void assignEntsoeUML(
      @RequestBody AssignEntsoeUMLToSteadyStateHypothesisVersionCommand command) {
    try {
      SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
          .assignEntsoeUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeUML", exc);
    }
  }

  /**
   * unassign EntsoeUML on SteadyStateHypothesisVersion
   *
   * @param command UnAssignEntsoeUMLFromSteadyStateHypothesisVersionCommand
   */
  @PutMapping("/unAssignEntsoeUML")
  public void unAssignEntsoeUML(
      @RequestBody(required = true)
          UnAssignEntsoeUMLFromSteadyStateHypothesisVersionCommand command) {
    try {
      SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
          .unAssignEntsoeUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeUML", exc);
    }
  }

  /**
   * save EntsoeURI on SteadyStateHypothesisVersion
   *
   * @param command AssignEntsoeURIToSteadyStateHypothesisVersionCommand
   */
  @PutMapping("/assignEntsoeURI")
  public void assignEntsoeURI(
      @RequestBody AssignEntsoeURIToSteadyStateHypothesisVersionCommand command) {
    try {
      SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
          .assignEntsoeURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeURI", exc);
    }
  }

  /**
   * unassign EntsoeURI on SteadyStateHypothesisVersion
   *
   * @param command UnAssignEntsoeURIFromSteadyStateHypothesisVersionCommand
   */
  @PutMapping("/unAssignEntsoeURI")
  public void unAssignEntsoeURI(
      @RequestBody(required = true)
          UnAssignEntsoeURIFromSteadyStateHypothesisVersionCommand command) {
    try {
      SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
          .unAssignEntsoeURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeURI", exc);
    }
  }

  /**
   * save ModelDescriptionURI on SteadyStateHypothesisVersion
   *
   * @param command AssignModelDescriptionURIToSteadyStateHypothesisVersionCommand
   */
  @PutMapping("/assignModelDescriptionURI")
  public void assignModelDescriptionURI(
      @RequestBody AssignModelDescriptionURIToSteadyStateHypothesisVersionCommand command) {
    try {
      SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
          .assignModelDescriptionURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ModelDescriptionURI", exc);
    }
  }

  /**
   * unassign ModelDescriptionURI on SteadyStateHypothesisVersion
   *
   * @param command UnAssignModelDescriptionURIFromSteadyStateHypothesisVersionCommand
   */
  @PutMapping("/unAssignModelDescriptionURI")
  public void unAssignModelDescriptionURI(
      @RequestBody(required = true)
          UnAssignModelDescriptionURIFromSteadyStateHypothesisVersionCommand command) {
    try {
      SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
          .unAssignModelDescriptionURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ModelDescriptionURI", exc);
    }
  }

  /**
   * save NamespaceRDF on SteadyStateHypothesisVersion
   *
   * @param command AssignNamespaceRDFToSteadyStateHypothesisVersionCommand
   */
  @PutMapping("/assignNamespaceRDF")
  public void assignNamespaceRDF(
      @RequestBody AssignNamespaceRDFToSteadyStateHypothesisVersionCommand command) {
    try {
      SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
          .assignNamespaceRDF(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NamespaceRDF", exc);
    }
  }

  /**
   * unassign NamespaceRDF on SteadyStateHypothesisVersion
   *
   * @param command UnAssignNamespaceRDFFromSteadyStateHypothesisVersionCommand
   */
  @PutMapping("/unAssignNamespaceRDF")
  public void unAssignNamespaceRDF(
      @RequestBody(required = true)
          UnAssignNamespaceRDFFromSteadyStateHypothesisVersionCommand command) {
    try {
      SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
          .unAssignNamespaceRDF(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NamespaceRDF", exc);
    }
  }

  /**
   * save NamespaceUML on SteadyStateHypothesisVersion
   *
   * @param command AssignNamespaceUMLToSteadyStateHypothesisVersionCommand
   */
  @PutMapping("/assignNamespaceUML")
  public void assignNamespaceUML(
      @RequestBody AssignNamespaceUMLToSteadyStateHypothesisVersionCommand command) {
    try {
      SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
          .assignNamespaceUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NamespaceUML", exc);
    }
  }

  /**
   * unassign NamespaceUML on SteadyStateHypothesisVersion
   *
   * @param command UnAssignNamespaceUMLFromSteadyStateHypothesisVersionCommand
   */
  @PutMapping("/unAssignNamespaceUML")
  public void unAssignNamespaceUML(
      @RequestBody(required = true)
          UnAssignNamespaceUMLFromSteadyStateHypothesisVersionCommand command) {
    try {
      SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
          .unAssignNamespaceUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NamespaceUML", exc);
    }
  }

  /**
   * save ShortName on SteadyStateHypothesisVersion
   *
   * @param command AssignShortNameToSteadyStateHypothesisVersionCommand
   */
  @PutMapping("/assignShortName")
  public void assignShortName(
      @RequestBody AssignShortNameToSteadyStateHypothesisVersionCommand command) {
    try {
      SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
          .assignShortName(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ShortName", exc);
    }
  }

  /**
   * unassign ShortName on SteadyStateHypothesisVersion
   *
   * @param command UnAssignShortNameFromSteadyStateHypothesisVersionCommand
   */
  @PutMapping("/unAssignShortName")
  public void unAssignShortName(
      @RequestBody(required = true)
          UnAssignShortNameFromSteadyStateHypothesisVersionCommand command) {
    try {
      SteadyStateHypothesisVersionBusinessDelegate.getSteadyStateHypothesisVersionInstance()
          .unAssignShortName(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ShortName", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected SteadyStateHypothesisVersion steadyStateHypothesisVersion = null;
  private static final Logger LOGGER =
      Logger.getLogger(SteadyStateHypothesisVersionCommandRestController.class.getName());
}
