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
 * Projector for StringProxy as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by StringProxyAggregate
 *
 * @author your_name_here
 */
@Component("stringProxy-entity-projector")
public class StringProxyEntityProjector {

  // core constructor
  public StringProxyEntityProjector(StringProxyRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a StringProxy
   *
   * @param	entity StringProxy
   */
  public StringProxy create(StringProxy entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a StringProxy
   *
   * @param	entity StringProxy
   */
  public StringProxy update(StringProxy entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a StringProxy
   *
   * @param	id		UUID
   */
  public StringProxy delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    StringProxy entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /**
   * Method to retrieve the StringProxy via an FindStringProxyQuery
   *
   * @return query FindStringProxyQuery
   */
  @SuppressWarnings("unused")
  public StringProxy find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a StringProxy - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all StringProxys
   *
   * @param query FindAllStringProxyQuery
   * @return List<StringProxy>
   */
  @SuppressWarnings("unused")
  public List<StringProxy> findAll(FindAllStringProxyQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all StringProxy - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final StringProxyRepository repository;

  @Autowired
  @Qualifier(value = "boundaryExtensions-entity-projector")
  com.occulue.europeanstandards.extension.projector.BoundaryExtensionsEntityProjector
      BoundaryExtensionsProjector;

  @Autowired
  @Qualifier(value = "eNTSOEIdentifiedObject-entity-projector")
  com.occulue.europeanstandards.extension.projector.ENTSOEIdentifiedObjectEntityProjector
      ENTSOEIdentifiedObjectProjector;

  @Autowired
  @Qualifier(value = "extensionVersion-entity-projector")
  com.occulue.europeanstandards.extension.projector.ExtensionVersionEntityProjector
      ExtensionVersionProjector;

  @Autowired
  @Qualifier(value = "domainVersion-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .DomainVersionEntityProjector
      DomainVersionProjector;

  @Autowired
  @Qualifier(value = "equipmentBoundaryVersion-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.projector
          .EquipmentBoundaryVersionEntityProjector
      EquipmentBoundaryVersionProjector;

  @Autowired
  @Qualifier(value = "identifiedObject-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core
          .projector.IdentifiedObjectEntityProjector
      IdentifiedObjectProjector;

  @Autowired
  @Qualifier(value = "topologyBoundaryVersion-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.topologyboundaryprofile.projector
          .TopologyBoundaryVersionEntityProjector
      TopologyBoundaryVersionProjector;

  @Autowired
  @Qualifier(value = "equipmentVersion-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.projector
          .EquipmentVersionEntityProjector
      EquipmentVersionProjector;

  @Autowired
  @Qualifier(value = "control-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector
          .ControlEntityProjector
      ControlProjector;

  @Autowired
  @Qualifier(value = "measurement-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector
          .MeasurementEntityProjector
      MeasurementProjector;

  @Autowired
  @Qualifier(value = "stringMeasurementValue-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector
          .StringMeasurementValueEntityProjector
      StringMeasurementValueProjector;

  @Autowired
  @Qualifier(value = "coordinateSystem-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common
          .projector.CoordinateSystemEntityProjector
      CoordinateSystemProjector;

  @Autowired
  @Qualifier(value = "positionPoint-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common
          .projector.PositionPointEntityProjector
      PositionPointProjector;

  @Autowired
  @Qualifier(value = "textDiagramObject-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout
          .projector.TextDiagramObjectEntityProjector
      TextDiagramObjectProjector;

  private static final Logger LOGGER = Logger.getLogger(StringProxyEntityProjector.class.getName());
}
