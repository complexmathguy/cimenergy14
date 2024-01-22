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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for SeasonDayTypeSchedule as outlined for the CQRS pattern. All event handling and
 * query handling related to SeasonDayTypeSchedule are invoked here and dispersed as an event to be
 * handled elsewhere.
 *
 * <p>Commands are handled by SeasonDayTypeScheduleAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("seasonDayTypeSchedule")
@Component("seasonDayTypeSchedule-projector")
public class SeasonDayTypeScheduleProjector extends SeasonDayTypeScheduleEntityProjector {

  // core constructor
  public SeasonDayTypeScheduleProjector(
      SeasonDayTypeScheduleRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateSeasonDayTypeScheduleEvent
   */
  @EventHandler(payloadType = CreateSeasonDayTypeScheduleEvent.class)
  public void handle(CreateSeasonDayTypeScheduleEvent event) {
    LOGGER.info("handling CreateSeasonDayTypeScheduleEvent - " + event);
    SeasonDayTypeSchedule entity = new SeasonDayTypeSchedule();
    entity.setSeasonDayTypeScheduleId(event.getSeasonDayTypeScheduleId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeasonDayTypeSchedule(entity);
  }

  /*
   * @param	event UpdateSeasonDayTypeScheduleEvent
   */
  @EventHandler(payloadType = UpdateSeasonDayTypeScheduleEvent.class)
  public void handle(UpdateSeasonDayTypeScheduleEvent event) {
    LOGGER.info("handling UpdateSeasonDayTypeScheduleEvent - " + event);

    SeasonDayTypeSchedule entity = new SeasonDayTypeSchedule();
    entity.setSeasonDayTypeScheduleId(event.getSeasonDayTypeScheduleId());
    entity.setSeasonDayTypeSchedules(event.getSeasonDayTypeSchedules());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSeasonDayTypeSchedule(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeasonDayTypeSchedule(entity);
  }

  /*
   * @param	event DeleteSeasonDayTypeScheduleEvent
   */
  @EventHandler(payloadType = DeleteSeasonDayTypeScheduleEvent.class)
  public void handle(DeleteSeasonDayTypeScheduleEvent event) {
    LOGGER.info("handling DeleteSeasonDayTypeScheduleEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    SeasonDayTypeSchedule entity = delete(event.getSeasonDayTypeScheduleId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeasonDayTypeSchedule(entity);
  }

  /*
   * @param	event AssignSeasonDayTypeSchedulesToSeasonDayTypeScheduleEvent
   */
  @EventHandler(payloadType = AssignSeasonDayTypeSchedulesToSeasonDayTypeScheduleEvent.class)
  public void handle(AssignSeasonDayTypeSchedulesToSeasonDayTypeScheduleEvent event) {
    LOGGER.info("handling AssignSeasonDayTypeSchedulesToSeasonDayTypeScheduleEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    SeasonDayTypeSchedule entity =
        addToSeasonDayTypeSchedules(event.getSeasonDayTypeScheduleId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSeasonDayTypeSchedule(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeasonDayTypeSchedule(entity);
  }

  /*
   * @param	event RemoveSeasonDayTypeSchedulesFromSeasonDayTypeScheduleEvent
   */
  @EventHandler(payloadType = RemoveSeasonDayTypeSchedulesFromSeasonDayTypeScheduleEvent.class)
  public void handle(RemoveSeasonDayTypeSchedulesFromSeasonDayTypeScheduleEvent event) {
    LOGGER.info("handling RemoveSeasonDayTypeSchedulesFromSeasonDayTypeScheduleEvent - " + event);

    SeasonDayTypeSchedule entity =
        removeFromSeasonDayTypeSchedules(event.getSeasonDayTypeScheduleId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSeasonDayTypeSchedule(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeasonDayTypeSchedule(entity);
  }

  /**
   * Method to retrieve the SeasonDayTypeSchedule via an SeasonDayTypeSchedulePrimaryKey.
   *
   * @param id Long
   * @return SeasonDayTypeSchedule
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public SeasonDayTypeSchedule handle(FindSeasonDayTypeScheduleQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getSeasonDayTypeScheduleId());
  }

  /**
   * Method to retrieve a collection of all SeasonDayTypeSchedules
   *
   * @param query FindAllSeasonDayTypeScheduleQuery
   * @return List<SeasonDayTypeSchedule>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<SeasonDayTypeSchedule> handle(FindAllSeasonDayTypeScheduleQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindSeasonDayTypeSchedule, but only if the id matches
   *
   * @param entity SeasonDayTypeSchedule
   */
  protected void emitFindSeasonDayTypeSchedule(SeasonDayTypeSchedule entity) {
    LOGGER.info("handling emitFindSeasonDayTypeSchedule");

    queryUpdateEmitter.emit(
        FindSeasonDayTypeScheduleQuery.class,
        query ->
            query
                .getFilter()
                .getSeasonDayTypeScheduleId()
                .equals(entity.getSeasonDayTypeScheduleId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllSeasonDayTypeSchedule
   *
   * @param entity SeasonDayTypeSchedule
   */
  protected void emitFindAllSeasonDayTypeSchedule(SeasonDayTypeSchedule entity) {
    LOGGER.info("handling emitFindAllSeasonDayTypeSchedule");

    queryUpdateEmitter.emit(FindAllSeasonDayTypeScheduleQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(SeasonDayTypeScheduleProjector.class.getName());
}
