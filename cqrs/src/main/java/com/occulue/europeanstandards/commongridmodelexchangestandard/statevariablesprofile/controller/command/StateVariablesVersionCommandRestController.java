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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity StateVariablesVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/StateVariablesVersion")
public class StateVariablesVersionCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a StateVariablesVersion. if not key provided, calls create, otherwise calls save
   *
   * @param StateVariablesVersion stateVariablesVersion
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateStateVariablesVersionCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
              .createStateVariablesVersion(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a StateVariablesVersion. if no key provided, calls create, otherwise calls
   * save
   *
   * @param StateVariablesVersion stateVariablesVersion
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateStateVariablesVersionCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateStateVariablesVersionCommand
      // -----------------------------------------------
      completableFuture =
          StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
              .updateStateVariablesVersion(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "StateVariablesVersionController:update() - successfully update StateVariablesVersion - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a StateVariablesVersion entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID stateVariablesVersionId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteStateVariablesVersionCommand command =
        new DeleteStateVariablesVersionCommand(stateVariablesVersionId);

    try {
      StateVariablesVersionBusinessDelegate delegate =
          StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted StateVariablesVersion with key "
              + command.getStateVariablesVersionId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save BaseUML on StateVariablesVersion
   *
   * @param command AssignBaseUMLToStateVariablesVersionCommand
   */
  @PutMapping("/assignBaseUML")
  public void assignBaseUML(@RequestBody AssignBaseUMLToStateVariablesVersionCommand command) {
    try {
      StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
          .assignBaseUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseUML", exc);
    }
  }

  /**
   * unassign BaseUML on StateVariablesVersion
   *
   * @param command UnAssignBaseUMLFromStateVariablesVersionCommand
   */
  @PutMapping("/unAssignBaseUML")
  public void unAssignBaseUML(
      @RequestBody(required = true) UnAssignBaseUMLFromStateVariablesVersionCommand command) {
    try {
      StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
          .unAssignBaseUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseUML", exc);
    }
  }

  /**
   * save BaseURI on StateVariablesVersion
   *
   * @param command AssignBaseURIToStateVariablesVersionCommand
   */
  @PutMapping("/assignBaseURI")
  public void assignBaseURI(@RequestBody AssignBaseURIToStateVariablesVersionCommand command) {
    try {
      StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
          .assignBaseURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseURI", exc);
    }
  }

  /**
   * unassign BaseURI on StateVariablesVersion
   *
   * @param command UnAssignBaseURIFromStateVariablesVersionCommand
   */
  @PutMapping("/unAssignBaseURI")
  public void unAssignBaseURI(
      @RequestBody(required = true) UnAssignBaseURIFromStateVariablesVersionCommand command) {
    try {
      StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
          .unAssignBaseURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseURI", exc);
    }
  }

  /**
   * save Date on StateVariablesVersion
   *
   * @param command AssignDateToStateVariablesVersionCommand
   */
  @PutMapping("/assignDate")
  public void assignDate(@RequestBody AssignDateToStateVariablesVersionCommand command) {
    try {
      StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance().assignDate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Date", exc);
    }
  }

  /**
   * unassign Date on StateVariablesVersion
   *
   * @param command UnAssignDateFromStateVariablesVersionCommand
   */
  @PutMapping("/unAssignDate")
  public void unAssignDate(
      @RequestBody(required = true) UnAssignDateFromStateVariablesVersionCommand command) {
    try {
      StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
          .unAssignDate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Date", exc);
    }
  }

  /**
   * save DifferenceModelURI on StateVariablesVersion
   *
   * @param command AssignDifferenceModelURIToStateVariablesVersionCommand
   */
  @PutMapping("/assignDifferenceModelURI")
  public void assignDifferenceModelURI(
      @RequestBody AssignDifferenceModelURIToStateVariablesVersionCommand command) {
    try {
      StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
          .assignDifferenceModelURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign DifferenceModelURI", exc);
    }
  }

  /**
   * unassign DifferenceModelURI on StateVariablesVersion
   *
   * @param command UnAssignDifferenceModelURIFromStateVariablesVersionCommand
   */
  @PutMapping("/unAssignDifferenceModelURI")
  public void unAssignDifferenceModelURI(
      @RequestBody(required = true)
          UnAssignDifferenceModelURIFromStateVariablesVersionCommand command) {
    try {
      StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
          .unAssignDifferenceModelURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign DifferenceModelURI", exc);
    }
  }

  /**
   * save EntsoeUML on StateVariablesVersion
   *
   * @param command AssignEntsoeUMLToStateVariablesVersionCommand
   */
  @PutMapping("/assignEntsoeUML")
  public void assignEntsoeUML(@RequestBody AssignEntsoeUMLToStateVariablesVersionCommand command) {
    try {
      StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
          .assignEntsoeUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeUML", exc);
    }
  }

  /**
   * unassign EntsoeUML on StateVariablesVersion
   *
   * @param command UnAssignEntsoeUMLFromStateVariablesVersionCommand
   */
  @PutMapping("/unAssignEntsoeUML")
  public void unAssignEntsoeUML(
      @RequestBody(required = true) UnAssignEntsoeUMLFromStateVariablesVersionCommand command) {
    try {
      StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
          .unAssignEntsoeUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeUML", exc);
    }
  }

  /**
   * save EntsoeURI on StateVariablesVersion
   *
   * @param command AssignEntsoeURIToStateVariablesVersionCommand
   */
  @PutMapping("/assignEntsoeURI")
  public void assignEntsoeURI(@RequestBody AssignEntsoeURIToStateVariablesVersionCommand command) {
    try {
      StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
          .assignEntsoeURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeURI", exc);
    }
  }

  /**
   * unassign EntsoeURI on StateVariablesVersion
   *
   * @param command UnAssignEntsoeURIFromStateVariablesVersionCommand
   */
  @PutMapping("/unAssignEntsoeURI")
  public void unAssignEntsoeURI(
      @RequestBody(required = true) UnAssignEntsoeURIFromStateVariablesVersionCommand command) {
    try {
      StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
          .unAssignEntsoeURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeURI", exc);
    }
  }

  /**
   * save ModelDescriptionURI on StateVariablesVersion
   *
   * @param command AssignModelDescriptionURIToStateVariablesVersionCommand
   */
  @PutMapping("/assignModelDescriptionURI")
  public void assignModelDescriptionURI(
      @RequestBody AssignModelDescriptionURIToStateVariablesVersionCommand command) {
    try {
      StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
          .assignModelDescriptionURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ModelDescriptionURI", exc);
    }
  }

  /**
   * unassign ModelDescriptionURI on StateVariablesVersion
   *
   * @param command UnAssignModelDescriptionURIFromStateVariablesVersionCommand
   */
  @PutMapping("/unAssignModelDescriptionURI")
  public void unAssignModelDescriptionURI(
      @RequestBody(required = true)
          UnAssignModelDescriptionURIFromStateVariablesVersionCommand command) {
    try {
      StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
          .unAssignModelDescriptionURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ModelDescriptionURI", exc);
    }
  }

  /**
   * save NamespaceRDF on StateVariablesVersion
   *
   * @param command AssignNamespaceRDFToStateVariablesVersionCommand
   */
  @PutMapping("/assignNamespaceRDF")
  public void assignNamespaceRDF(
      @RequestBody AssignNamespaceRDFToStateVariablesVersionCommand command) {
    try {
      StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
          .assignNamespaceRDF(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NamespaceRDF", exc);
    }
  }

  /**
   * unassign NamespaceRDF on StateVariablesVersion
   *
   * @param command UnAssignNamespaceRDFFromStateVariablesVersionCommand
   */
  @PutMapping("/unAssignNamespaceRDF")
  public void unAssignNamespaceRDF(
      @RequestBody(required = true) UnAssignNamespaceRDFFromStateVariablesVersionCommand command) {
    try {
      StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
          .unAssignNamespaceRDF(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NamespaceRDF", exc);
    }
  }

  /**
   * save NamespaceUML on StateVariablesVersion
   *
   * @param command AssignNamespaceUMLToStateVariablesVersionCommand
   */
  @PutMapping("/assignNamespaceUML")
  public void assignNamespaceUML(
      @RequestBody AssignNamespaceUMLToStateVariablesVersionCommand command) {
    try {
      StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
          .assignNamespaceUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NamespaceUML", exc);
    }
  }

  /**
   * unassign NamespaceUML on StateVariablesVersion
   *
   * @param command UnAssignNamespaceUMLFromStateVariablesVersionCommand
   */
  @PutMapping("/unAssignNamespaceUML")
  public void unAssignNamespaceUML(
      @RequestBody(required = true) UnAssignNamespaceUMLFromStateVariablesVersionCommand command) {
    try {
      StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
          .unAssignNamespaceUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NamespaceUML", exc);
    }
  }

  /**
   * save ShortName on StateVariablesVersion
   *
   * @param command AssignShortNameToStateVariablesVersionCommand
   */
  @PutMapping("/assignShortName")
  public void assignShortName(@RequestBody AssignShortNameToStateVariablesVersionCommand command) {
    try {
      StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
          .assignShortName(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ShortName", exc);
    }
  }

  /**
   * unassign ShortName on StateVariablesVersion
   *
   * @param command UnAssignShortNameFromStateVariablesVersionCommand
   */
  @PutMapping("/unAssignShortName")
  public void unAssignShortName(
      @RequestBody(required = true) UnAssignShortNameFromStateVariablesVersionCommand command) {
    try {
      StateVariablesVersionBusinessDelegate.getStateVariablesVersionInstance()
          .unAssignShortName(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ShortName", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected StateVariablesVersion stateVariablesVersion = null;
  private static final Logger LOGGER =
      Logger.getLogger(StateVariablesVersionCommandRestController.class.getName());
}
