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
package com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity DiagramLayoutVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiagramLayoutVersion")
public class DiagramLayoutVersionCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a DiagramLayoutVersion. if not key provided, calls create, otherwise calls save
   *
   * @param DiagramLayoutVersion diagramLayoutVersion
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateDiagramLayoutVersionCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance()
              .createDiagramLayoutVersion(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a DiagramLayoutVersion. if no key provided, calls create, otherwise calls save
   *
   * @param DiagramLayoutVersion diagramLayoutVersion
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateDiagramLayoutVersionCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateDiagramLayoutVersionCommand
      // -----------------------------------------------
      completableFuture =
          DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance()
              .updateDiagramLayoutVersion(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "DiagramLayoutVersionController:update() - successfully update DiagramLayoutVersion - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a DiagramLayoutVersion entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID diagramLayoutVersionId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteDiagramLayoutVersionCommand command =
        new DeleteDiagramLayoutVersionCommand(diagramLayoutVersionId);

    try {
      DiagramLayoutVersionBusinessDelegate delegate =
          DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted DiagramLayoutVersion with key "
              + command.getDiagramLayoutVersionId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save BaseUML on DiagramLayoutVersion
   *
   * @param command AssignBaseUMLToDiagramLayoutVersionCommand
   */
  @PutMapping("/assignBaseUML")
  public void assignBaseUML(@RequestBody AssignBaseUMLToDiagramLayoutVersionCommand command) {
    try {
      DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance().assignBaseUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseUML", exc);
    }
  }

  /**
   * unassign BaseUML on DiagramLayoutVersion
   *
   * @param command UnAssignBaseUMLFromDiagramLayoutVersionCommand
   */
  @PutMapping("/unAssignBaseUML")
  public void unAssignBaseUML(
      @RequestBody(required = true) UnAssignBaseUMLFromDiagramLayoutVersionCommand command) {
    try {
      DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance()
          .unAssignBaseUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseUML", exc);
    }
  }

  /**
   * save BaseURI on DiagramLayoutVersion
   *
   * @param command AssignBaseURIToDiagramLayoutVersionCommand
   */
  @PutMapping("/assignBaseURI")
  public void assignBaseURI(@RequestBody AssignBaseURIToDiagramLayoutVersionCommand command) {
    try {
      DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance().assignBaseURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseURI", exc);
    }
  }

  /**
   * unassign BaseURI on DiagramLayoutVersion
   *
   * @param command UnAssignBaseURIFromDiagramLayoutVersionCommand
   */
  @PutMapping("/unAssignBaseURI")
  public void unAssignBaseURI(
      @RequestBody(required = true) UnAssignBaseURIFromDiagramLayoutVersionCommand command) {
    try {
      DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance()
          .unAssignBaseURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseURI", exc);
    }
  }

  /**
   * save Date on DiagramLayoutVersion
   *
   * @param command AssignDateToDiagramLayoutVersionCommand
   */
  @PutMapping("/assignDate")
  public void assignDate(@RequestBody AssignDateToDiagramLayoutVersionCommand command) {
    try {
      DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance().assignDate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Date", exc);
    }
  }

  /**
   * unassign Date on DiagramLayoutVersion
   *
   * @param command UnAssignDateFromDiagramLayoutVersionCommand
   */
  @PutMapping("/unAssignDate")
  public void unAssignDate(
      @RequestBody(required = true) UnAssignDateFromDiagramLayoutVersionCommand command) {
    try {
      DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance().unAssignDate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Date", exc);
    }
  }

  /**
   * save DifferenceModelURI on DiagramLayoutVersion
   *
   * @param command AssignDifferenceModelURIToDiagramLayoutVersionCommand
   */
  @PutMapping("/assignDifferenceModelURI")
  public void assignDifferenceModelURI(
      @RequestBody AssignDifferenceModelURIToDiagramLayoutVersionCommand command) {
    try {
      DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance()
          .assignDifferenceModelURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign DifferenceModelURI", exc);
    }
  }

  /**
   * unassign DifferenceModelURI on DiagramLayoutVersion
   *
   * @param command UnAssignDifferenceModelURIFromDiagramLayoutVersionCommand
   */
  @PutMapping("/unAssignDifferenceModelURI")
  public void unAssignDifferenceModelURI(
      @RequestBody(required = true)
          UnAssignDifferenceModelURIFromDiagramLayoutVersionCommand command) {
    try {
      DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance()
          .unAssignDifferenceModelURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign DifferenceModelURI", exc);
    }
  }

  /**
   * save EntsoeUML on DiagramLayoutVersion
   *
   * @param command AssignEntsoeUMLToDiagramLayoutVersionCommand
   */
  @PutMapping("/assignEntsoeUML")
  public void assignEntsoeUML(@RequestBody AssignEntsoeUMLToDiagramLayoutVersionCommand command) {
    try {
      DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance()
          .assignEntsoeUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeUML", exc);
    }
  }

  /**
   * unassign EntsoeUML on DiagramLayoutVersion
   *
   * @param command UnAssignEntsoeUMLFromDiagramLayoutVersionCommand
   */
  @PutMapping("/unAssignEntsoeUML")
  public void unAssignEntsoeUML(
      @RequestBody(required = true) UnAssignEntsoeUMLFromDiagramLayoutVersionCommand command) {
    try {
      DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance()
          .unAssignEntsoeUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeUML", exc);
    }
  }

  /**
   * save EntsoeURI on DiagramLayoutVersion
   *
   * @param command AssignEntsoeURIToDiagramLayoutVersionCommand
   */
  @PutMapping("/assignEntsoeURI")
  public void assignEntsoeURI(@RequestBody AssignEntsoeURIToDiagramLayoutVersionCommand command) {
    try {
      DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance()
          .assignEntsoeURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeURI", exc);
    }
  }

  /**
   * unassign EntsoeURI on DiagramLayoutVersion
   *
   * @param command UnAssignEntsoeURIFromDiagramLayoutVersionCommand
   */
  @PutMapping("/unAssignEntsoeURI")
  public void unAssignEntsoeURI(
      @RequestBody(required = true) UnAssignEntsoeURIFromDiagramLayoutVersionCommand command) {
    try {
      DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance()
          .unAssignEntsoeURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeURI", exc);
    }
  }

  /**
   * save ModelDescriptionURI on DiagramLayoutVersion
   *
   * @param command AssignModelDescriptionURIToDiagramLayoutVersionCommand
   */
  @PutMapping("/assignModelDescriptionURI")
  public void assignModelDescriptionURI(
      @RequestBody AssignModelDescriptionURIToDiagramLayoutVersionCommand command) {
    try {
      DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance()
          .assignModelDescriptionURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ModelDescriptionURI", exc);
    }
  }

  /**
   * unassign ModelDescriptionURI on DiagramLayoutVersion
   *
   * @param command UnAssignModelDescriptionURIFromDiagramLayoutVersionCommand
   */
  @PutMapping("/unAssignModelDescriptionURI")
  public void unAssignModelDescriptionURI(
      @RequestBody(required = true)
          UnAssignModelDescriptionURIFromDiagramLayoutVersionCommand command) {
    try {
      DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance()
          .unAssignModelDescriptionURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ModelDescriptionURI", exc);
    }
  }

  /**
   * save NamespaceRDF on DiagramLayoutVersion
   *
   * @param command AssignNamespaceRDFToDiagramLayoutVersionCommand
   */
  @PutMapping("/assignNamespaceRDF")
  public void assignNamespaceRDF(
      @RequestBody AssignNamespaceRDFToDiagramLayoutVersionCommand command) {
    try {
      DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance()
          .assignNamespaceRDF(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NamespaceRDF", exc);
    }
  }

  /**
   * unassign NamespaceRDF on DiagramLayoutVersion
   *
   * @param command UnAssignNamespaceRDFFromDiagramLayoutVersionCommand
   */
  @PutMapping("/unAssignNamespaceRDF")
  public void unAssignNamespaceRDF(
      @RequestBody(required = true) UnAssignNamespaceRDFFromDiagramLayoutVersionCommand command) {
    try {
      DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance()
          .unAssignNamespaceRDF(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NamespaceRDF", exc);
    }
  }

  /**
   * save NamespaceUML on DiagramLayoutVersion
   *
   * @param command AssignNamespaceUMLToDiagramLayoutVersionCommand
   */
  @PutMapping("/assignNamespaceUML")
  public void assignNamespaceUML(
      @RequestBody AssignNamespaceUMLToDiagramLayoutVersionCommand command) {
    try {
      DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance()
          .assignNamespaceUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NamespaceUML", exc);
    }
  }

  /**
   * unassign NamespaceUML on DiagramLayoutVersion
   *
   * @param command UnAssignNamespaceUMLFromDiagramLayoutVersionCommand
   */
  @PutMapping("/unAssignNamespaceUML")
  public void unAssignNamespaceUML(
      @RequestBody(required = true) UnAssignNamespaceUMLFromDiagramLayoutVersionCommand command) {
    try {
      DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance()
          .unAssignNamespaceUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NamespaceUML", exc);
    }
  }

  /**
   * save ShortName on DiagramLayoutVersion
   *
   * @param command AssignShortNameToDiagramLayoutVersionCommand
   */
  @PutMapping("/assignShortName")
  public void assignShortName(@RequestBody AssignShortNameToDiagramLayoutVersionCommand command) {
    try {
      DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance()
          .assignShortName(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ShortName", exc);
    }
  }

  /**
   * unassign ShortName on DiagramLayoutVersion
   *
   * @param command UnAssignShortNameFromDiagramLayoutVersionCommand
   */
  @PutMapping("/unAssignShortName")
  public void unAssignShortName(
      @RequestBody(required = true) UnAssignShortNameFromDiagramLayoutVersionCommand command) {
    try {
      DiagramLayoutVersionBusinessDelegate.getDiagramLayoutVersionInstance()
          .unAssignShortName(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ShortName", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DiagramLayoutVersion diagramLayoutVersion = null;
  private static final Logger LOGGER =
      Logger.getLogger(DiagramLayoutVersionCommandRestController.class.getName());
}
