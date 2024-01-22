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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for AngleDegrees as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by AngleDegreesAggregate
 *
 * @author your_name_here
 */
@Component("angleDegrees-entity-projector")
public class AngleDegreesEntityProjector {

  // core constructor
  public AngleDegreesEntityProjector(AngleDegreesRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a AngleDegrees
   *
   * @param	entity AngleDegrees
   */
  public AngleDegrees create(AngleDegrees entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a AngleDegrees
   *
   * @param	entity AngleDegrees
   */
  public AngleDegrees update(AngleDegrees entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a AngleDegrees
   *
   * @param	id		UUID
   */
  public AngleDegrees delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    AngleDegrees entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Value
   *
   * @param	parentId	UUID
   * @param	assignment 	FloatProxy
   * @return	AngleDegrees
   */
  public AngleDegrees assignValue(UUID parentId, FloatProxy assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    AngleDegrees parentEntity = repository.findById(parentId).get();
    assignment = FloatProxyProjector.find(assignment.getFloatProxyId());

    // ------------------------------------------
    // assign the Value to the parent entity
    // ------------------------------------------
    parentEntity.setValue(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Value
   *
   * @param	parentId		UUID
   * @return	AngleDegrees
   */
  public AngleDegrees unAssignValue(UUID parentId) {
    AngleDegrees parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Value on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Value on the parent entithy
    // ------------------------------------------
    parentEntity.setValue(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the AngleDegrees via an FindAngleDegreesQuery
   *
   * @return query FindAngleDegreesQuery
   */
  @SuppressWarnings("unused")
  public AngleDegrees find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a AngleDegrees - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all AngleDegreess
   *
   * @param query FindAllAngleDegreesQuery
   * @return List<AngleDegrees>
   */
  @SuppressWarnings("unused")
  public List<AngleDegrees> findAll(FindAllAngleDegreesQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all AngleDegrees - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final AngleDegreesRepository repository;

  @Autowired
  @Qualifier(value = "floatProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .FloatProxyEntityProjector
      FloatProxyProjector;

  @Autowired
  @Qualifier(value = "csConverter-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector
          .CsConverterEntityProjector
      CsConverterProjector;

  @Autowired
  @Qualifier(value = "phaseTapChangerAsymmetrical-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .PhaseTapChangerAsymmetricalEntityProjector
      PhaseTapChangerAsymmetricalProjector;

  @Autowired
  @Qualifier(value = "phaseTapChangerLinear-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .PhaseTapChangerLinearEntityProjector
      PhaseTapChangerLinearProjector;

  @Autowired
  @Qualifier(value = "phaseTapChangerTablePoint-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .PhaseTapChangerTablePointEntityProjector
      PhaseTapChangerTablePointProjector;

  @Autowired
  @Qualifier(value = "powerTransformer-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .PowerTransformerEntityProjector
      PowerTransformerProjector;

  @Autowired
  @Qualifier(value = "excIEEEST3A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcIEEEST3AEntityProjector
      ExcIEEEST3AProjector;

  @Autowired
  @Qualifier(value = "windAeroLinearIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindAeroLinearIECEntityProjector
      WindAeroLinearIECProjector;

  @Autowired
  @Qualifier(value = "windContPitchAngleIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindContPitchAngleIECEntityProjector
      WindContPitchAngleIECProjector;

  @Autowired
  @Qualifier(value = "diagramObject-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout
          .projector.DiagramObjectEntityProjector
      DiagramObjectProjector;

  private static final Logger LOGGER =
      Logger.getLogger(AngleDegreesEntityProjector.class.getName());
}
