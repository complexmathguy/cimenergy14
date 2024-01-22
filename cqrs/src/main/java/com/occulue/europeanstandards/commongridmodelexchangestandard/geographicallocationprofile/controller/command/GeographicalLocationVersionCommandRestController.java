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
package com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity GeographicalLocationVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GeographicalLocationVersion")
public class GeographicalLocationVersionCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GeographicalLocationVersion. if not key provided, calls create, otherwise
   * calls save
   *
   * @param GeographicalLocationVersion geographicalLocationVersion
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGeographicalLocationVersionCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
              .createGeographicalLocationVersion(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GeographicalLocationVersion. if no key provided, calls create, otherwise
   * calls save
   *
   * @param GeographicalLocationVersion geographicalLocationVersion
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGeographicalLocationVersionCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGeographicalLocationVersionCommand
      // -----------------------------------------------
      completableFuture =
          GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
              .updateGeographicalLocationVersion(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GeographicalLocationVersionController:update() - successfully update GeographicalLocationVersion - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GeographicalLocationVersion entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID geographicalLocationVersionId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGeographicalLocationVersionCommand command =
        new DeleteGeographicalLocationVersionCommand(geographicalLocationVersionId);

    try {
      GeographicalLocationVersionBusinessDelegate delegate =
          GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted GeographicalLocationVersion with key "
              + command.getGeographicalLocationVersionId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save BaseUML on GeographicalLocationVersion
   *
   * @param command AssignBaseUMLToGeographicalLocationVersionCommand
   */
  @PutMapping("/assignBaseUML")
  public void assignBaseUML(
      @RequestBody AssignBaseUMLToGeographicalLocationVersionCommand command) {
    try {
      GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
          .assignBaseUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseUML", exc);
    }
  }

  /**
   * unassign BaseUML on GeographicalLocationVersion
   *
   * @param command UnAssignBaseUMLFromGeographicalLocationVersionCommand
   */
  @PutMapping("/unAssignBaseUML")
  public void unAssignBaseUML(
      @RequestBody(required = true) UnAssignBaseUMLFromGeographicalLocationVersionCommand command) {
    try {
      GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
          .unAssignBaseUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseUML", exc);
    }
  }

  /**
   * save BaseURI on GeographicalLocationVersion
   *
   * @param command AssignBaseURIToGeographicalLocationVersionCommand
   */
  @PutMapping("/assignBaseURI")
  public void assignBaseURI(
      @RequestBody AssignBaseURIToGeographicalLocationVersionCommand command) {
    try {
      GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
          .assignBaseURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseURI", exc);
    }
  }

  /**
   * unassign BaseURI on GeographicalLocationVersion
   *
   * @param command UnAssignBaseURIFromGeographicalLocationVersionCommand
   */
  @PutMapping("/unAssignBaseURI")
  public void unAssignBaseURI(
      @RequestBody(required = true) UnAssignBaseURIFromGeographicalLocationVersionCommand command) {
    try {
      GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
          .unAssignBaseURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseURI", exc);
    }
  }

  /**
   * save Date on GeographicalLocationVersion
   *
   * @param command AssignDateToGeographicalLocationVersionCommand
   */
  @PutMapping("/assignDate")
  public void assignDate(@RequestBody AssignDateToGeographicalLocationVersionCommand command) {
    try {
      GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
          .assignDate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Date", exc);
    }
  }

  /**
   * unassign Date on GeographicalLocationVersion
   *
   * @param command UnAssignDateFromGeographicalLocationVersionCommand
   */
  @PutMapping("/unAssignDate")
  public void unAssignDate(
      @RequestBody(required = true) UnAssignDateFromGeographicalLocationVersionCommand command) {
    try {
      GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
          .unAssignDate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Date", exc);
    }
  }

  /**
   * save DifferenceModelURI on GeographicalLocationVersion
   *
   * @param command AssignDifferenceModelURIToGeographicalLocationVersionCommand
   */
  @PutMapping("/assignDifferenceModelURI")
  public void assignDifferenceModelURI(
      @RequestBody AssignDifferenceModelURIToGeographicalLocationVersionCommand command) {
    try {
      GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
          .assignDifferenceModelURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign DifferenceModelURI", exc);
    }
  }

  /**
   * unassign DifferenceModelURI on GeographicalLocationVersion
   *
   * @param command UnAssignDifferenceModelURIFromGeographicalLocationVersionCommand
   */
  @PutMapping("/unAssignDifferenceModelURI")
  public void unAssignDifferenceModelURI(
      @RequestBody(required = true)
          UnAssignDifferenceModelURIFromGeographicalLocationVersionCommand command) {
    try {
      GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
          .unAssignDifferenceModelURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign DifferenceModelURI", exc);
    }
  }

  /**
   * save EntsoeUML on GeographicalLocationVersion
   *
   * @param command AssignEntsoeUMLToGeographicalLocationVersionCommand
   */
  @PutMapping("/assignEntsoeUML")
  public void assignEntsoeUML(
      @RequestBody AssignEntsoeUMLToGeographicalLocationVersionCommand command) {
    try {
      GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
          .assignEntsoeUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeUML", exc);
    }
  }

  /**
   * unassign EntsoeUML on GeographicalLocationVersion
   *
   * @param command UnAssignEntsoeUMLFromGeographicalLocationVersionCommand
   */
  @PutMapping("/unAssignEntsoeUML")
  public void unAssignEntsoeUML(
      @RequestBody(required = true)
          UnAssignEntsoeUMLFromGeographicalLocationVersionCommand command) {
    try {
      GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
          .unAssignEntsoeUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeUML", exc);
    }
  }

  /**
   * save EntsoeURI on GeographicalLocationVersion
   *
   * @param command AssignEntsoeURIToGeographicalLocationVersionCommand
   */
  @PutMapping("/assignEntsoeURI")
  public void assignEntsoeURI(
      @RequestBody AssignEntsoeURIToGeographicalLocationVersionCommand command) {
    try {
      GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
          .assignEntsoeURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeURI", exc);
    }
  }

  /**
   * unassign EntsoeURI on GeographicalLocationVersion
   *
   * @param command UnAssignEntsoeURIFromGeographicalLocationVersionCommand
   */
  @PutMapping("/unAssignEntsoeURI")
  public void unAssignEntsoeURI(
      @RequestBody(required = true)
          UnAssignEntsoeURIFromGeographicalLocationVersionCommand command) {
    try {
      GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
          .unAssignEntsoeURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeURI", exc);
    }
  }

  /**
   * save ModelDescriptionURI on GeographicalLocationVersion
   *
   * @param command AssignModelDescriptionURIToGeographicalLocationVersionCommand
   */
  @PutMapping("/assignModelDescriptionURI")
  public void assignModelDescriptionURI(
      @RequestBody AssignModelDescriptionURIToGeographicalLocationVersionCommand command) {
    try {
      GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
          .assignModelDescriptionURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ModelDescriptionURI", exc);
    }
  }

  /**
   * unassign ModelDescriptionURI on GeographicalLocationVersion
   *
   * @param command UnAssignModelDescriptionURIFromGeographicalLocationVersionCommand
   */
  @PutMapping("/unAssignModelDescriptionURI")
  public void unAssignModelDescriptionURI(
      @RequestBody(required = true)
          UnAssignModelDescriptionURIFromGeographicalLocationVersionCommand command) {
    try {
      GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
          .unAssignModelDescriptionURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ModelDescriptionURI", exc);
    }
  }

  /**
   * save NamespaceRDF on GeographicalLocationVersion
   *
   * @param command AssignNamespaceRDFToGeographicalLocationVersionCommand
   */
  @PutMapping("/assignNamespaceRDF")
  public void assignNamespaceRDF(
      @RequestBody AssignNamespaceRDFToGeographicalLocationVersionCommand command) {
    try {
      GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
          .assignNamespaceRDF(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NamespaceRDF", exc);
    }
  }

  /**
   * unassign NamespaceRDF on GeographicalLocationVersion
   *
   * @param command UnAssignNamespaceRDFFromGeographicalLocationVersionCommand
   */
  @PutMapping("/unAssignNamespaceRDF")
  public void unAssignNamespaceRDF(
      @RequestBody(required = true)
          UnAssignNamespaceRDFFromGeographicalLocationVersionCommand command) {
    try {
      GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
          .unAssignNamespaceRDF(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NamespaceRDF", exc);
    }
  }

  /**
   * save NamespaceUML on GeographicalLocationVersion
   *
   * @param command AssignNamespaceUMLToGeographicalLocationVersionCommand
   */
  @PutMapping("/assignNamespaceUML")
  public void assignNamespaceUML(
      @RequestBody AssignNamespaceUMLToGeographicalLocationVersionCommand command) {
    try {
      GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
          .assignNamespaceUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NamespaceUML", exc);
    }
  }

  /**
   * unassign NamespaceUML on GeographicalLocationVersion
   *
   * @param command UnAssignNamespaceUMLFromGeographicalLocationVersionCommand
   */
  @PutMapping("/unAssignNamespaceUML")
  public void unAssignNamespaceUML(
      @RequestBody(required = true)
          UnAssignNamespaceUMLFromGeographicalLocationVersionCommand command) {
    try {
      GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
          .unAssignNamespaceUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NamespaceUML", exc);
    }
  }

  /**
   * save ShortName on GeographicalLocationVersion
   *
   * @param command AssignShortNameToGeographicalLocationVersionCommand
   */
  @PutMapping("/assignShortName")
  public void assignShortName(
      @RequestBody AssignShortNameToGeographicalLocationVersionCommand command) {
    try {
      GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
          .assignShortName(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ShortName", exc);
    }
  }

  /**
   * unassign ShortName on GeographicalLocationVersion
   *
   * @param command UnAssignShortNameFromGeographicalLocationVersionCommand
   */
  @PutMapping("/unAssignShortName")
  public void unAssignShortName(
      @RequestBody(required = true)
          UnAssignShortNameFromGeographicalLocationVersionCommand command) {
    try {
      GeographicalLocationVersionBusinessDelegate.getGeographicalLocationVersionInstance()
          .unAssignShortName(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ShortName", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GeographicalLocationVersion geographicalLocationVersion = null;
  private static final Logger LOGGER =
      Logger.getLogger(GeographicalLocationVersionCommandRestController.class.getName());
}
