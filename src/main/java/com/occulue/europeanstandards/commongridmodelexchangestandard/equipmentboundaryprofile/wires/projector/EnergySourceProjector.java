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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for EnergySource as outlined for the CQRS pattern. All event handling and query
 * handling related to EnergySource are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by EnergySourceAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("energySource")
@Component("energySource-projector")
public class EnergySourceProjector extends EnergySourceEntityProjector {

  // core constructor
  public EnergySourceProjector(
      EnergySourceRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateEnergySourceEvent
   */
  @EventHandler(payloadType = CreateEnergySourceEvent.class)
  public void handle(CreateEnergySourceEvent event) {
    LOGGER.info("handling CreateEnergySourceEvent - " + event);
    EnergySource entity = new EnergySource();
    entity.setEnergySourceId(event.getEnergySourceId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEnergySource(entity);
  }

  /*
   * @param	event UpdateEnergySourceEvent
   */
  @EventHandler(payloadType = UpdateEnergySourceEvent.class)
  public void handle(UpdateEnergySourceEvent event) {
    LOGGER.info("handling UpdateEnergySourceEvent - " + event);

    EnergySource entity = new EnergySource();
    entity.setEnergySourceId(event.getEnergySourceId());
    entity.setEnergySource(event.getEnergySource());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEnergySource(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEnergySource(entity);
  }

  /*
   * @param	event DeleteEnergySourceEvent
   */
  @EventHandler(payloadType = DeleteEnergySourceEvent.class)
  public void handle(DeleteEnergySourceEvent event) {
    LOGGER.info("handling DeleteEnergySourceEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    EnergySource entity = delete(event.getEnergySourceId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEnergySource(entity);
  }

  /*
   * @param	event AssignEnergySourceToEnergySourceEvent
   */
  @EventHandler(payloadType = AssignEnergySourceToEnergySourceEvent.class)
  public void handle(AssignEnergySourceToEnergySourceEvent event) {
    LOGGER.info("handling AssignEnergySourceToEnergySourceEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    EnergySource entity = addToEnergySource(event.getEnergySourceId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEnergySource(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEnergySource(entity);
  }

  /*
   * @param	event RemoveEnergySourceFromEnergySourceEvent
   */
  @EventHandler(payloadType = RemoveEnergySourceFromEnergySourceEvent.class)
  public void handle(RemoveEnergySourceFromEnergySourceEvent event) {
    LOGGER.info("handling RemoveEnergySourceFromEnergySourceEvent - " + event);

    EnergySource entity = removeFromEnergySource(event.getEnergySourceId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEnergySource(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEnergySource(entity);
  }

  /**
   * Method to retrieve the EnergySource via an EnergySourcePrimaryKey.
   *
   * @param id Long
   * @return EnergySource
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public EnergySource handle(FindEnergySourceQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getEnergySourceId());
  }

  /**
   * Method to retrieve a collection of all EnergySources
   *
   * @param query FindAllEnergySourceQuery
   * @return List<EnergySource>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<EnergySource> handle(FindAllEnergySourceQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindEnergySource, but only if the id matches
   *
   * @param entity EnergySource
   */
  protected void emitFindEnergySource(EnergySource entity) {
    LOGGER.info("handling emitFindEnergySource");

    queryUpdateEmitter.emit(
        FindEnergySourceQuery.class,
        query -> query.getFilter().getEnergySourceId().equals(entity.getEnergySourceId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllEnergySource
   *
   * @param entity EnergySource
   */
  protected void emitFindAllEnergySource(EnergySource entity) {
    LOGGER.info("handling emitFindAllEnergySource");

    queryUpdateEmitter.emit(FindAllEnergySourceQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(EnergySourceProjector.class.getName());
}
