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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for TransformerEnd as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by TransformerEndAggregate
 *
 * @author your_name_here
 */
@Component("transformerEnd-entity-projector")
public class TransformerEndEntityProjector {

  // core constructor
  public TransformerEndEntityProjector(TransformerEndRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a TransformerEnd
   *
   * @param	entity TransformerEnd
   */
  public TransformerEnd create(TransformerEnd entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a TransformerEnd
   *
   * @param	entity TransformerEnd
   */
  public TransformerEnd update(TransformerEnd entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a TransformerEnd
   *
   * @param	id		UUID
   */
  public TransformerEnd delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    TransformerEnd entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a EndNumber
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	TransformerEnd
   */
  public TransformerEnd assignEndNumber(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning EndNumber as " + assignment.toString());

    TransformerEnd parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the EndNumber to the parent entity
    // ------------------------------------------
    parentEntity.setEndNumber(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the EndNumber
   *
   * @param	parentId		UUID
   * @return	TransformerEnd
   */
  public TransformerEnd unAssignEndNumber(UUID parentId) {
    TransformerEnd parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning EndNumber on " + parentEntity.toString());

    // ------------------------------------------
    // null out the EndNumber on the parent entithy
    // ------------------------------------------
    parentEntity.setEndNumber(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Grounded
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	TransformerEnd
   */
  public TransformerEnd assignGrounded(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Grounded as " + assignment.toString());

    TransformerEnd parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Grounded to the parent entity
    // ------------------------------------------
    parentEntity.setGrounded(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Grounded
   *
   * @param	parentId		UUID
   * @return	TransformerEnd
   */
  public TransformerEnd unAssignGrounded(UUID parentId) {
    TransformerEnd parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Grounded on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Grounded on the parent entithy
    // ------------------------------------------
    parentEntity.setGrounded(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rground
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	TransformerEnd
   */
  public TransformerEnd assignRground(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning Rground as " + assignment.toString());

    TransformerEnd parentEntity = repository.findById(parentId).get();
    assignment = ResistanceProjector.find(assignment.getResistanceId());

    // ------------------------------------------
    // assign the Rground to the parent entity
    // ------------------------------------------
    parentEntity.setRground(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rground
   *
   * @param	parentId		UUID
   * @return	TransformerEnd
   */
  public TransformerEnd unAssignRground(UUID parentId) {
    TransformerEnd parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rground on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rground on the parent entithy
    // ------------------------------------------
    parentEntity.setRground(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Xground
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	TransformerEnd
   */
  public TransformerEnd assignXground(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning Xground as " + assignment.toString());

    TransformerEnd parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the Xground to the parent entity
    // ------------------------------------------
    parentEntity.setXground(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Xground
   *
   * @param	parentId		UUID
   * @return	TransformerEnd
   */
  public TransformerEnd unAssignXground(UUID parentId) {
    TransformerEnd parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Xground on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Xground on the parent entithy
    // ------------------------------------------
    parentEntity.setXground(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the TransformerEnds
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	TransformerEnd
   */
  public TransformerEnd addToTransformerEnds(UUID parentId, TransformerEnd addTo) {
    LOGGER.info("handling AssignTransformerEndsToTransformerEndEvent - ");

    TransformerEnd parentEntity = repository.findById(parentId).get();
    TransformerEnd child = TransformerEndProjector.find(addTo.getTransformerEndId());

    parentEntity.getTransformerEnds().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the TransformerEnds
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	TransformerEnd
   */
  public TransformerEnd removeFromTransformerEnds(UUID parentId, TransformerEnd removeFrom) {
    LOGGER.info("handling RemoveTransformerEndsFromTransformerEndEvent ");

    TransformerEnd parentEntity = repository.findById(parentId).get();
    TransformerEnd child = TransformerEndProjector.find(removeFrom.getTransformerEndId());

    parentEntity.getTransformerEnds().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the TransformerEnd
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	TransformerEnd
   */
  public TransformerEnd addToTransformerEnd(UUID parentId, TransformerEnd addTo) {
    LOGGER.info("handling AssignTransformerEndToTransformerEndEvent - ");

    TransformerEnd parentEntity = repository.findById(parentId).get();
    TransformerEnd child = TransformerEndProjector.find(addTo.getTransformerEndId());

    parentEntity.getTransformerEnd().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the TransformerEnd
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	TransformerEnd
   */
  public TransformerEnd removeFromTransformerEnd(UUID parentId, TransformerEnd removeFrom) {
    LOGGER.info("handling RemoveTransformerEndFromTransformerEndEvent ");

    TransformerEnd parentEntity = repository.findById(parentId).get();
    TransformerEnd child = TransformerEndProjector.find(removeFrom.getTransformerEndId());

    parentEntity.getTransformerEnd().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the TransformerEnd via an FindTransformerEndQuery
   *
   * @return query FindTransformerEndQuery
   */
  @SuppressWarnings("unused")
  public TransformerEnd find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a TransformerEnd - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all TransformerEnds
   *
   * @param query FindAllTransformerEndQuery
   * @return List<TransformerEnd>
   */
  @SuppressWarnings("unused")
  public List<TransformerEnd> findAll(FindAllTransformerEndQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all TransformerEnd - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final TransformerEndRepository repository;

  @Autowired
  @Qualifier(value = "integerProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .IntegerProxyEntityProjector
      IntegerProxyProjector;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  @Autowired
  @Qualifier(value = "resistance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ResistanceEntityProjector
      ResistanceProjector;

  @Autowired
  @Qualifier(value = "reactance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ReactanceEntityProjector
      ReactanceProjector;

  @Autowired
  @Qualifier(value = "transformerEnd-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .TransformerEndEntityProjector
      TransformerEndProjector;

  private static final Logger LOGGER =
      Logger.getLogger(TransformerEndEntityProjector.class.getName());
}
