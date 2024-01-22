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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for SolarGeneratingUnit as outlined for the CQRS pattern. All event handling and query
 * handling related to SolarGeneratingUnit are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by SolarGeneratingUnitAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("solarGeneratingUnit")
@Component("solarGeneratingUnit-projector")
public class SolarGeneratingUnitProjector extends SolarGeneratingUnitEntityProjector {

  // core constructor
  public SolarGeneratingUnitProjector(
      SolarGeneratingUnitRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateSolarGeneratingUnitEvent
   */
  @EventHandler(payloadType = CreateSolarGeneratingUnitEvent.class)
  public void handle(CreateSolarGeneratingUnitEvent event) {
    LOGGER.info("handling CreateSolarGeneratingUnitEvent - " + event);
    SolarGeneratingUnit entity = new SolarGeneratingUnit();
    entity.setSolarGeneratingUnitId(event.getSolarGeneratingUnitId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSolarGeneratingUnit(entity);
  }

  /*
   * @param	event UpdateSolarGeneratingUnitEvent
   */
  @EventHandler(payloadType = UpdateSolarGeneratingUnitEvent.class)
  public void handle(UpdateSolarGeneratingUnitEvent event) {
    LOGGER.info("handling UpdateSolarGeneratingUnitEvent - " + event);

    SolarGeneratingUnit entity = new SolarGeneratingUnit();
    entity.setSolarGeneratingUnitId(event.getSolarGeneratingUnitId());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSolarGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSolarGeneratingUnit(entity);
  }

  /*
   * @param	event DeleteSolarGeneratingUnitEvent
   */
  @EventHandler(payloadType = DeleteSolarGeneratingUnitEvent.class)
  public void handle(DeleteSolarGeneratingUnitEvent event) {
    LOGGER.info("handling DeleteSolarGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    SolarGeneratingUnit entity = delete(event.getSolarGeneratingUnitId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSolarGeneratingUnit(entity);
  }

  /**
   * Method to retrieve the SolarGeneratingUnit via an SolarGeneratingUnitPrimaryKey.
   *
   * @param id Long
   * @return SolarGeneratingUnit
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public SolarGeneratingUnit handle(FindSolarGeneratingUnitQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getSolarGeneratingUnitId());
  }

  /**
   * Method to retrieve a collection of all SolarGeneratingUnits
   *
   * @param query FindAllSolarGeneratingUnitQuery
   * @return List<SolarGeneratingUnit>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<SolarGeneratingUnit> handle(FindAllSolarGeneratingUnitQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindSolarGeneratingUnit, but only if the id matches
   *
   * @param entity SolarGeneratingUnit
   */
  protected void emitFindSolarGeneratingUnit(SolarGeneratingUnit entity) {
    LOGGER.info("handling emitFindSolarGeneratingUnit");

    queryUpdateEmitter.emit(
        FindSolarGeneratingUnitQuery.class,
        query ->
            query.getFilter().getSolarGeneratingUnitId().equals(entity.getSolarGeneratingUnitId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllSolarGeneratingUnit
   *
   * @param entity SolarGeneratingUnit
   */
  protected void emitFindAllSolarGeneratingUnit(SolarGeneratingUnit entity) {
    LOGGER.info("handling emitFindAllSolarGeneratingUnit");

    queryUpdateEmitter.emit(FindAllSolarGeneratingUnitQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(SolarGeneratingUnitProjector.class.getName());
}
