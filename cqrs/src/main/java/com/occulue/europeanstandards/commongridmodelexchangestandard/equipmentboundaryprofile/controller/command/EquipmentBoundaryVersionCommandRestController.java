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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity EquipmentBoundaryVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EquipmentBoundaryVersion")
public class EquipmentBoundaryVersionCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a EquipmentBoundaryVersion. if not key provided, calls create, otherwise calls
   * save
   *
   * @param EquipmentBoundaryVersion equipmentBoundaryVersion
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateEquipmentBoundaryVersionCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
              .createEquipmentBoundaryVersion(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a EquipmentBoundaryVersion. if no key provided, calls create, otherwise calls
   * save
   *
   * @param EquipmentBoundaryVersion equipmentBoundaryVersion
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateEquipmentBoundaryVersionCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateEquipmentBoundaryVersionCommand
      // -----------------------------------------------
      completableFuture =
          EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
              .updateEquipmentBoundaryVersion(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "EquipmentBoundaryVersionController:update() - successfully update EquipmentBoundaryVersion - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a EquipmentBoundaryVersion entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID equipmentBoundaryVersionId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteEquipmentBoundaryVersionCommand command =
        new DeleteEquipmentBoundaryVersionCommand(equipmentBoundaryVersionId);

    try {
      EquipmentBoundaryVersionBusinessDelegate delegate =
          EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted EquipmentBoundaryVersion with key "
              + command.getEquipmentBoundaryVersionId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save BaseUML on EquipmentBoundaryVersion
   *
   * @param command AssignBaseUMLToEquipmentBoundaryVersionCommand
   */
  @PutMapping("/assignBaseUML")
  public void assignBaseUML(@RequestBody AssignBaseUMLToEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .assignBaseUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseUML", exc);
    }
  }

  /**
   * unassign BaseUML on EquipmentBoundaryVersion
   *
   * @param command UnAssignBaseUMLFromEquipmentBoundaryVersionCommand
   */
  @PutMapping("/unAssignBaseUML")
  public void unAssignBaseUML(
      @RequestBody(required = true) UnAssignBaseUMLFromEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .unAssignBaseUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseUML", exc);
    }
  }

  /**
   * save BaseURI on EquipmentBoundaryVersion
   *
   * @param command AssignBaseURIToEquipmentBoundaryVersionCommand
   */
  @PutMapping("/assignBaseURI")
  public void assignBaseURI(@RequestBody AssignBaseURIToEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .assignBaseURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseURI", exc);
    }
  }

  /**
   * unassign BaseURI on EquipmentBoundaryVersion
   *
   * @param command UnAssignBaseURIFromEquipmentBoundaryVersionCommand
   */
  @PutMapping("/unAssignBaseURI")
  public void unAssignBaseURI(
      @RequestBody(required = true) UnAssignBaseURIFromEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .unAssignBaseURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseURI", exc);
    }
  }

  /**
   * save Date on EquipmentBoundaryVersion
   *
   * @param command AssignDateToEquipmentBoundaryVersionCommand
   */
  @PutMapping("/assignDate")
  public void assignDate(@RequestBody AssignDateToEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .assignDate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Date", exc);
    }
  }

  /**
   * unassign Date on EquipmentBoundaryVersion
   *
   * @param command UnAssignDateFromEquipmentBoundaryVersionCommand
   */
  @PutMapping("/unAssignDate")
  public void unAssignDate(
      @RequestBody(required = true) UnAssignDateFromEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .unAssignDate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Date", exc);
    }
  }

  /**
   * save DifferenceModelURI on EquipmentBoundaryVersion
   *
   * @param command AssignDifferenceModelURIToEquipmentBoundaryVersionCommand
   */
  @PutMapping("/assignDifferenceModelURI")
  public void assignDifferenceModelURI(
      @RequestBody AssignDifferenceModelURIToEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .assignDifferenceModelURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign DifferenceModelURI", exc);
    }
  }

  /**
   * unassign DifferenceModelURI on EquipmentBoundaryVersion
   *
   * @param command UnAssignDifferenceModelURIFromEquipmentBoundaryVersionCommand
   */
  @PutMapping("/unAssignDifferenceModelURI")
  public void unAssignDifferenceModelURI(
      @RequestBody(required = true)
          UnAssignDifferenceModelURIFromEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .unAssignDifferenceModelURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign DifferenceModelURI", exc);
    }
  }

  /**
   * save EntsoeUML on EquipmentBoundaryVersion
   *
   * @param command AssignEntsoeUMLToEquipmentBoundaryVersionCommand
   */
  @PutMapping("/assignEntsoeUML")
  public void assignEntsoeUML(
      @RequestBody AssignEntsoeUMLToEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .assignEntsoeUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeUML", exc);
    }
  }

  /**
   * unassign EntsoeUML on EquipmentBoundaryVersion
   *
   * @param command UnAssignEntsoeUMLFromEquipmentBoundaryVersionCommand
   */
  @PutMapping("/unAssignEntsoeUML")
  public void unAssignEntsoeUML(
      @RequestBody(required = true) UnAssignEntsoeUMLFromEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .unAssignEntsoeUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeUML", exc);
    }
  }

  /**
   * save EntsoeURIcore on EquipmentBoundaryVersion
   *
   * @param command AssignEntsoeURIcoreToEquipmentBoundaryVersionCommand
   */
  @PutMapping("/assignEntsoeURIcore")
  public void assignEntsoeURIcore(
      @RequestBody AssignEntsoeURIcoreToEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .assignEntsoeURIcore(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeURIcore", exc);
    }
  }

  /**
   * unassign EntsoeURIcore on EquipmentBoundaryVersion
   *
   * @param command UnAssignEntsoeURIcoreFromEquipmentBoundaryVersionCommand
   */
  @PutMapping("/unAssignEntsoeURIcore")
  public void unAssignEntsoeURIcore(
      @RequestBody(required = true)
          UnAssignEntsoeURIcoreFromEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .unAssignEntsoeURIcore(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeURIcore", exc);
    }
  }

  /**
   * save EntsoeURIoperation on EquipmentBoundaryVersion
   *
   * @param command AssignEntsoeURIoperationToEquipmentBoundaryVersionCommand
   */
  @PutMapping("/assignEntsoeURIoperation")
  public void assignEntsoeURIoperation(
      @RequestBody AssignEntsoeURIoperationToEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .assignEntsoeURIoperation(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeURIoperation", exc);
    }
  }

  /**
   * unassign EntsoeURIoperation on EquipmentBoundaryVersion
   *
   * @param command UnAssignEntsoeURIoperationFromEquipmentBoundaryVersionCommand
   */
  @PutMapping("/unAssignEntsoeURIoperation")
  public void unAssignEntsoeURIoperation(
      @RequestBody(required = true)
          UnAssignEntsoeURIoperationFromEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .unAssignEntsoeURIoperation(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeURIoperation", exc);
    }
  }

  /**
   * save ModelDescriptionURI on EquipmentBoundaryVersion
   *
   * @param command AssignModelDescriptionURIToEquipmentBoundaryVersionCommand
   */
  @PutMapping("/assignModelDescriptionURI")
  public void assignModelDescriptionURI(
      @RequestBody AssignModelDescriptionURIToEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .assignModelDescriptionURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ModelDescriptionURI", exc);
    }
  }

  /**
   * unassign ModelDescriptionURI on EquipmentBoundaryVersion
   *
   * @param command UnAssignModelDescriptionURIFromEquipmentBoundaryVersionCommand
   */
  @PutMapping("/unAssignModelDescriptionURI")
  public void unAssignModelDescriptionURI(
      @RequestBody(required = true)
          UnAssignModelDescriptionURIFromEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .unAssignModelDescriptionURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ModelDescriptionURI", exc);
    }
  }

  /**
   * save NamespaceRDF on EquipmentBoundaryVersion
   *
   * @param command AssignNamespaceRDFToEquipmentBoundaryVersionCommand
   */
  @PutMapping("/assignNamespaceRDF")
  public void assignNamespaceRDF(
      @RequestBody AssignNamespaceRDFToEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .assignNamespaceRDF(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NamespaceRDF", exc);
    }
  }

  /**
   * unassign NamespaceRDF on EquipmentBoundaryVersion
   *
   * @param command UnAssignNamespaceRDFFromEquipmentBoundaryVersionCommand
   */
  @PutMapping("/unAssignNamespaceRDF")
  public void unAssignNamespaceRDF(
      @RequestBody(required = true)
          UnAssignNamespaceRDFFromEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .unAssignNamespaceRDF(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NamespaceRDF", exc);
    }
  }

  /**
   * save NamespaceUML on EquipmentBoundaryVersion
   *
   * @param command AssignNamespaceUMLToEquipmentBoundaryVersionCommand
   */
  @PutMapping("/assignNamespaceUML")
  public void assignNamespaceUML(
      @RequestBody AssignNamespaceUMLToEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .assignNamespaceUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NamespaceUML", exc);
    }
  }

  /**
   * unassign NamespaceUML on EquipmentBoundaryVersion
   *
   * @param command UnAssignNamespaceUMLFromEquipmentBoundaryVersionCommand
   */
  @PutMapping("/unAssignNamespaceUML")
  public void unAssignNamespaceUML(
      @RequestBody(required = true)
          UnAssignNamespaceUMLFromEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .unAssignNamespaceUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NamespaceUML", exc);
    }
  }

  /**
   * save ShortName on EquipmentBoundaryVersion
   *
   * @param command AssignShortNameToEquipmentBoundaryVersionCommand
   */
  @PutMapping("/assignShortName")
  public void assignShortName(
      @RequestBody AssignShortNameToEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .assignShortName(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ShortName", exc);
    }
  }

  /**
   * unassign ShortName on EquipmentBoundaryVersion
   *
   * @param command UnAssignShortNameFromEquipmentBoundaryVersionCommand
   */
  @PutMapping("/unAssignShortName")
  public void unAssignShortName(
      @RequestBody(required = true) UnAssignShortNameFromEquipmentBoundaryVersionCommand command) {
    try {
      EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
          .unAssignShortName(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ShortName", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected EquipmentBoundaryVersion equipmentBoundaryVersion = null;
  private static final Logger LOGGER =
      Logger.getLogger(EquipmentBoundaryVersionCommandRestController.class.getName());
}
