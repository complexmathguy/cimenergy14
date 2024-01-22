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
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for RegulationSchedule as outlined for the CQRS pattern. All event handling and query
 * handling related to RegulationSchedule are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by RegulationScheduleAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("regulationSchedule")
@Component("regulationSchedule-projector")
public class RegulationScheduleProjector extends RegulationScheduleEntityProjector {

  // core constructor
  public RegulationScheduleProjector(
      RegulationScheduleRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateRegulationScheduleEvent
   */
  @EventHandler(payloadType = CreateRegulationScheduleEvent.class)
  public void handle(CreateRegulationScheduleEvent event) {
    LOGGER.info("handling CreateRegulationScheduleEvent - " + event);
    RegulationSchedule entity = new RegulationSchedule();
    entity.setRegulationScheduleId(event.getRegulationScheduleId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRegulationSchedule(entity);
  }

  /*
   * @param	event UpdateRegulationScheduleEvent
   */
  @EventHandler(payloadType = UpdateRegulationScheduleEvent.class)
  public void handle(UpdateRegulationScheduleEvent event) {
    LOGGER.info("handling UpdateRegulationScheduleEvent - " + event);

    RegulationSchedule entity = new RegulationSchedule();
    entity.setRegulationScheduleId(event.getRegulationScheduleId());
    entity.setRegulationSchedule(event.getRegulationSchedule());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRegulationSchedule(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRegulationSchedule(entity);
  }

  /*
   * @param	event DeleteRegulationScheduleEvent
   */
  @EventHandler(payloadType = DeleteRegulationScheduleEvent.class)
  public void handle(DeleteRegulationScheduleEvent event) {
    LOGGER.info("handling DeleteRegulationScheduleEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    RegulationSchedule entity = delete(event.getRegulationScheduleId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRegulationSchedule(entity);
  }

  /*
   * @param	event AssignRegulationScheduleToRegulationScheduleEvent
   */
  @EventHandler(payloadType = AssignRegulationScheduleToRegulationScheduleEvent.class)
  public void handle(AssignRegulationScheduleToRegulationScheduleEvent event) {
    LOGGER.info("handling AssignRegulationScheduleToRegulationScheduleEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    RegulationSchedule entity =
        addToRegulationSchedule(event.getRegulationScheduleId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRegulationSchedule(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRegulationSchedule(entity);
  }

  /*
   * @param	event RemoveRegulationScheduleFromRegulationScheduleEvent
   */
  @EventHandler(payloadType = RemoveRegulationScheduleFromRegulationScheduleEvent.class)
  public void handle(RemoveRegulationScheduleFromRegulationScheduleEvent event) {
    LOGGER.info("handling RemoveRegulationScheduleFromRegulationScheduleEvent - " + event);

    RegulationSchedule entity =
        removeFromRegulationSchedule(event.getRegulationScheduleId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRegulationSchedule(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRegulationSchedule(entity);
  }

  /**
   * Method to retrieve the RegulationSchedule via an RegulationSchedulePrimaryKey.
   *
   * @param id Long
   * @return RegulationSchedule
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public RegulationSchedule handle(FindRegulationScheduleQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getRegulationScheduleId());
  }

  /**
   * Method to retrieve a collection of all RegulationSchedules
   *
   * @param query FindAllRegulationScheduleQuery
   * @return List<RegulationSchedule>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<RegulationSchedule> handle(FindAllRegulationScheduleQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindRegulationSchedule, but only if the id matches
   *
   * @param entity RegulationSchedule
   */
  protected void emitFindRegulationSchedule(RegulationSchedule entity) {
    LOGGER.info("handling emitFindRegulationSchedule");

    queryUpdateEmitter.emit(
        FindRegulationScheduleQuery.class,
        query ->
            query.getFilter().getRegulationScheduleId().equals(entity.getRegulationScheduleId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllRegulationSchedule
   *
   * @param entity RegulationSchedule
   */
  protected void emitFindAllRegulationSchedule(RegulationSchedule entity) {
    LOGGER.info("handling emitFindAllRegulationSchedule");

    queryUpdateEmitter.emit(FindAllRegulationScheduleQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(RegulationScheduleProjector.class.getName());
}
